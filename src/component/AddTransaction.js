import React, { useEffect, useState }  from "react";
import axios from "axios";
import {TextField,Button, MenuItem, Grid,Paper,Avatar} from '@mui/material';
import CurrencyExchangeIcon from '@mui/icons-material/CurrencyExchange';
import { Container } from "@mui/system";
import { Link } from "react-router-dom";
import Subheader from "./Subheader";
import Footer from "./Footer";
const config = require("./Config");
function AddTransaction(){
    const [fromCountry, setFromCountry] = useState("");
    const [toCountry, setToCountry] = useState("");
    const [senderName, setSenderName] = useState("");
    const [receiverName, setReceiverName] = useState("");
    const [senderAccNo, setSenderAccNo] = useState("");
    const [receiverAccNo,setReceiverAccNo] =useState("");
    const [sendingCurrency,setSendingCurrency] = useState("");
    const [receivingCurrency,setReceivingCurrency] = useState("");
    const [sendingAmount,setSendingAmount] = useState("");
    const [formErrors, setFormErrors] = useState({});


    useEffect(()=>{
      //update the selcted currency value based on selected country value for "From country"
      if(fromCountry === 'USA'){
        setSendingCurrency("Dollar");
      }
      else if(fromCountry === 'India'){
        setSendingCurrency("INR");
      }
      else if(fromCountry === 'Dubai'){
         setSendingCurrency("Dirham");
      }
      else if(fromCountry === 'Canada'){
        setSendingCurrency("CAD");
      }
    },[fromCountry]);

   
    useEffect(()=>{
      //update the selected currency value based on selected country value for "To country"
      if(toCountry === 'USA'){
        setReceivingCurrency("Dollar");
      }
      else if(toCountry === 'India'){
         setReceivingCurrency("INR");
      }
      else if(toCountry === 'Dubai'){
         setReceivingCurrency("Dirham");
      }
      else if(toCountry === 'Canada'){
         setReceivingCurrency("CAD");
      }
    },[toCountry]);
   
    const paperStyle = { padding: 20, height: '70vh', width: 280, margin: "20px auto"}
    const avatarStyle = { backgroundColor: '#1bbd7e' }
    //Handling the submit button
    const handleSubmit = ()=>{
         let errors = {};
        
        if(!fromCountry) {
         errors['fromCountryError'] = "From Country is required."
        }
        
        if(!toCountry) {
         errors['toCountryError'] = "To Country is required."
        }
        
        if(!senderName){
             errors['senderNameError'] = "Sender's Name is required"
        }
        if(!receiverName){
             errors['receiverNameError'] = "Receiver's Name is required"
        }
        if(!senderAccNo){
             errors['senderAccNoError'] = "Sender's Account No is required"
        }
        if(!receiverAccNo){
             errors['receiverAccNoError'] = "Receiver's Account No is required"
        }
        if(!sendingCurrency){
             errors['sendingCurrencyError'] = "Sending Currency is required"
        }
        if(!receivingCurrency){
             errors['receivingCurrencyError'] = "Receiving Currency is required"
        }
        if(!sendingAmount){
             errors['sendingAmountError'] = "Sending Amount is required"
         }
         if(sendingAmount < 0) {
            errors['sendingAmountError'] = "Sending Amount should be a positive number."
         }

         setFormErrors(errors);  
    
         const noErrors = Object.keys(errors).length === 0;
      
         

            
          
        if(noErrors){
        const payload = {
          
         fromCountry : fromCountry,
         toCountry: toCountry,
         senderName : senderName,
         receiverName: receiverName,
         senderAccNo: senderAccNo,
         receiverAccNo: receiverAccNo,
         sendingCurrency: sendingCurrency,
         receivingCurrency: receivingCurrency,
         sendingAmount: sendingAmount
       };
         //call the api to save the vitals
        axios.post(config.addTransactionUrl,payload)
        
         .then(resp=> alert("Transaction is saved with id: "+resp.data.transactionId))

         .catch((error) => {
            alert(error.response.data);
          });
      }  
      

   };

    return(
      <>
            {<div>
            <Subheader/>

            <Footer/>
            
        </div> }
        <div class="row" style={{marginTop:'5%'}}>

        <Container maxWidth="sm" style={{display:'flex',justifyContent:"center",alignItems:"center",height:"100vh"}}>
      <Grid>
         <Paper elevation={10} style={{paperStyle,padding : "20px",
          height: "88vh",width: "536px",margin: "20px auto"}}>
         <Grid align='center'>
         <Avatar style={avatarStyle}><CurrencyExchangeIcon/></Avatar>
          <h2>Transaction Details</h2></Grid>   
       <form  style={{display:"flex",flexDirection:"column",minWidth:"150px",maxWidth:"200px",height:"150px"}}>
       
       <div style={{display:"flex",flexDirection:"row",width:"500px"}}>
        <TextField
            label="From Country" value={fromCountry} onChange={(event)=>setFromCountry(event.target.value)}
            select
            required
            error={!!formErrors.fromCountry} helperText={formErrors.fromCountry}
            style={{marginBottom:"10px",width:"400px",marginRight:"-32px"}}>
               <MenuItem value="USA">USA</MenuItem>
               <MenuItem value="India">India</MenuItem>
               <MenuItem value="Dubai">Dubai</MenuItem>
               <MenuItem value="Canada">Canada</MenuItem>
            </TextField>
        {/* {
          formErrors.fromCountryError && <div style={{color: "red"}}>{formErrors.fromCountryError}</div>
        } */}
        <TextField
            label="To Country" value={toCountry} onChange={(event)=>setToCountry(event.target.value)}
            select
            required
            error={!!formErrors.toCountry} helperText={formErrors.toCountry}
            style={{marginBottom:"10px",width:"400px",marginLeft:"50px"}}>
            <MenuItem value="USA" disabled={fromCountry==="USA"}>USA</MenuItem>
            <MenuItem value="India"disabled={fromCountry ==="India"}>India</MenuItem>
            <MenuItem value="Dubai"disabled={fromCountry ==="Dubai"}>Dubai</MenuItem>
            <MenuItem value="Canada"disabled={fromCountry ==="Canada"}>Canada</MenuItem>
            </TextField>
         </div>   
         {/* {
          formErrors.toCountryError && <div style={{color: "red"}}>{formErrors.toCountryError}</div>
         }    */}
         <div style={{display:"flex",flexDirection:"row",width:"500px"}}>
        <TextField
           label="Sender Name" value={senderName} onChange={(event)=>setSenderName(event.target.value)}required
           error={!!formErrors.senderName} helperText={formErrors.senderName}
           style={{marginBottom:"10px",width:"400px",marginRight:"-32px"}}></TextField>
         {/* {
            formErrors.senderNameError && <div style={{color: "red"}}>{formErrors.senderNameError}</div>
         }   */}
        <TextField
           label="Receiver Name" value={receiverName} onChange={(event)=>setReceiverName(event.target.value)}required
           error={!!formErrors.receiverName} helperText={formErrors.receiverName}
           style={{marginBottom:"10px",width:"400px",marginLeft:"50px"}}></TextField>
         {/* {
            formErrors.receiverNameError && <div style={{color: "red"}}>{formErrors.receiverNameError}</div>  
         }   */}
         </div>
         <div style={{display:"flex",flexDirection:"row",width:"500px"}}>
        <TextField
           label="Sender Acc No" value={senderAccNo} onChange={(event)=>setSenderAccNo(event.target.value)}required
           error={!!formErrors.senderAccNo} helperText={formErrors.senderAccNo}
           style={{marginBottom:"10px",width:"400px",marginRight:"-32px"}}></TextField>
         
        <TextField
           label="Receiver Acc No" value={receiverAccNo} onChange={(event)=>setReceiverAccNo(event.target.value)}required
           error={!!formErrors.receiverAccNo} helperText={formErrors.receiverAccNo}
           style={{marginBottom:"10px",width:"400px",marginLeft:"50px"}}></TextField>
         </div>  
         <div style={{display:"flex",flexDirection:"row",width:"500px"}}> 
         <TextField
           label="Sending Currency" value={sendingCurrency}disabled={!fromCountry} onChange={(event)=>setSendingCurrency(event.target.value)}
           select
           required
           error={!!formErrors.sendingCurrency} helperText={formErrors.sendingCurrency}
           style={{marginBottom:"10px",marginBottom:"10px",width:"400px",marginRight:"-32px"}}>
             <MenuItem value="Dollar" >Dollar</MenuItem>
            <MenuItem value="INR">INR</MenuItem>
            <MenuItem value="Dirham">Dirham</MenuItem>
            <MenuItem value="CAD">CAD</MenuItem>
           </TextField>
         {/* {
            formErrors.sendingCurrencyError && <div style={{color: "red"}}>{formErrors.sendingCurrencyError}</div>
         }   */}
         <TextField
           label="Receiving Currency" value={receivingCurrency} disabled={!fromCountry}onChange={(event)=>setReceivingCurrency(event.target.value)}
           select
           required
           error={!!formErrors.receivingCurrency} helperText={formErrors.receivingCurrency}
           style={{marginBottom:"10px",marginBottom:"10px",width:"400px",marginLeft:"50px"}}>
            <MenuItem value="Dollar" >Dollar</MenuItem>
            <MenuItem value="INR">INR</MenuItem>
            <MenuItem value="Dirham">Dirham</MenuItem>
            <MenuItem value="CAD">CAD</MenuItem>
           </TextField>
         </div>
         <TextField
           label="Sending Amount" value={sendingAmount} onChange={(event)=>setSendingAmount(event.target.value)}required
           error={!!formErrors.sendingAmount} helperText={formErrors.sendingAmount}
           style={{marginBottom:"10px",marginLeft:"100px",width:"250px"}}></TextField>
         {/* {
            formErrors.sendingAmountError && <div style={{color: "red"}}>{formErrors.sendingAmountError}</div>
         }   */}
        <div style={{display:"flex",justifyContent:"space-between"}}>
        <Button onClick ={handleSubmit} type="submit" variant="contained" color="primary"style={{marginLeft:"150px"}} >Submit</Button>
        <Link to="/"><Button type="button" variant="contained" color="secondary"style={{marginLeft:"50px"}} >Cancel</Button></Link>
        </div>
       </form>
         {/* </Container>   */}
         </Paper>
      </Grid>
   </Container>
   </div>
   </> );

}
export default AddTransaction;