import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import { Avatar, Grid, Paper, TextField, Button, Typography} from '@mui/material';
// import { CurrencyBitcoin } from "@mui/icons-material";
import CurrencyExchangeIcon from '@mui/icons-material/CurrencyExchange';
// import  '/.CurrencyConverter.css';
import { Link } from 'react-router-dom';
import Subheader from "./Subheader";
import Footer from "./Footer";
const config = require('./Config');
const apiUrl = config.currencyConverterUrl;
function CurrencyConverter() {
  const [fromCurrency, setFromCurrency] = useState('USD');
  const [toCurrency, setToCurrency] = useState('INR');
  const [amount, setAmount] = useState(1);
  const [convertedAmount, setConvertedAmount] = useState("");
  const[amountError,setAmountError] = useState("");
  const[fromError,setFromError] = useState("");
  const[toError,setToError] = useState("");
  
  const paperStyle = { padding: 20, height: '70vh', width: 280, margin: "20px auto"}
    const avatarStyle = { backgroundColor: '#1bbd7e' }
    const btnstyle = { margin: '8px 0' }    
  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get(`${apiUrl}/rate/convert?amount=${amount}&fromCurrency=${fromCurrency}&toCurrency=${toCurrency}`);
      setConvertedAmount(response.data);
    } catch (error) {
      console.log(error);
    }
  };


  return (
    <>
    {<div>
    <Subheader/>
    <Footer/>
</div> }
    <Grid>
      <Paper elevation={10} style={{paperStyle,padding : "20px",
    height: "88vh",
    width: "350px",
    margin: "20px auto"}}>
        <Grid align='center'>
          <Avatar style={avatarStyle}><CurrencyExchangeIcon/></Avatar>
          <h2>Currency Converter</h2>
        </Grid>
        <form onSubmit={handleSubmit} style={{display:"flex",flexDirection:"column",alignItems: "center"}}>
          <label>
            Amount:
            <br></br>
            <input type="number" name="amount" value={amount} className="form-control" id ="amount" placeholder='Enter amount' onChange={(event) =>{setAmount(event.target.value);
            if(event.target.value === "") {
              setAmountError("Please enter an amount.");
            } else{
              setAmountError("");
            }
            }
            }
            
            required/>
            {
              amountError && <div style={{color: "red"}}>{amountError}</div>
            }
            <br></br>
          </label>
          <label>
            From Currency:
            <input type="text" name="fromCurrency" value={fromCurrency} className="form-control" id="fromCurrency" placeholder="Enter currency" onChange={(event) => {setFromCurrency(event.target.value);
            if(event.target.value === ""){
              setFromError("Please enter currency.");
            }else{
              setFromError("");
            }
          } 
        }
        required/>
        {
              fromError && <div style={{color: "red"}}>{fromError}</div>
            }

        <br></br>
          </label>
          <label>
            To Currency:
            <br></br>
            <input type="text" name ="toCurrency" value={toCurrency} className="form-control" id="toCurrency" placeholder="Enter currency" onChange={(event) =>{setToCurrency(event.target.value);
            if(event.target.value === ""){
              setToError("Please enter currency.");
            }else{
              setToError("");
            }
          } 
        }
        required/>
        {
              toError && <div style={{color: "red"}}>{toError}</div>
            }
          </label>
          <br></br>
          <button type="submit">Convert</button>
          <h4>Converted Amount:</h4>
          <p>
          {convertedAmount &&
            `${amount} ${fromCurrency} = ${convertedAmount} ${toCurrency}`}
        </p>
        </form>
        
        {/* <Link to="/">
          <button type="button" className="btn btn-primary" style={{ marginLeft: "10px" }} onClick={handleCancel}>Cancel</button>
        </Link> */}
         <Link to="/"><label>Cancel</label></Link>



      </Paper>


    </Grid>
 </> )

}

export default CurrencyConverter;
