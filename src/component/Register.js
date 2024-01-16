
import React, { useEffect, useState } from 'react';
import axios from "axios";
import TextField from '@mui/material/TextField';
import { styled } from '@mui/material/styles';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';
import { makeStyles } from '@material-ui/core/styles';
const StyledForm = styled('form')({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  gap: '1rem',
});
const useStyles = makeStyles((theme) => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
}));
function Register() {
 
  const [values, setValues] = useState({
    userName: "",
   
  });
  const [errors, setErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const [openDialog, setOpenDialog] = useState(false);
  const [openSnackbar, setOpenSnackbar] = useState(false);
  const [bool,setBool]=useState(false);
  const [emailError,setEmailError]=useState();
  const [dispError,setDispError]=useState();
  const [dispSuccess,setDispSuccess]=useState();

  const [disSuccess,setDisSuccess]=useState(false)
  
 

  
  
  const handleSubmit = (event) => {
    event.preventDefault();
    setErrors(validate(values));
    setIsSubmit(true);
    const errors = validate(values);
    console.log(values);
   
      axios
      .post(`http://localhost:8081/auth/sendEmail/${values.userName}`)
      .then((response)=>{
      console.log(response.data);
      setDispSuccess(response.data);
      setDisSuccess(!disSuccess);

       })
     .catch((err)=>{
      console.log(err)
    
  
      
    })
  

  };
  useEffect(() => {
   // console.log(errors);
    if (Object.keys(errors).length === 0 && isSubmit) {
       console.log(errors);
}}, [errors]);
const handleChange = (event) => {
  const { name, value } = event.target;
  setValues({ ...values, [name]: value });
  setErrors({ ...errors, [name]: '' });
  
};

  const validate = (values) => {
    let errors = {};
    const nameRegex=/^[a-zA-Z]{3,20}$/;
    if (!values.userName) {
     // errors.userName ="email is required";
     setEmailError("email is required");
    }

   



    return errors;
  };
  const validateEmail = (email) => {
    // email validation regex
    const re = /\S+@\S+\.\S+/;
    if (!email) {
      //errors.userName=('email is required');
      setEmailError('email is required');
    } else if(!re.test(email)) {
      //errors.userName=('Invalid email format');
      setEmailError('Invalid email format')
    }else{
      //errors.userName=('');
      setEmailError('')
      setBool(true)
    }
    if(bool){
      axios
      .get(`http://localhost:8081/auth/verifyEmail/${email}`)
      .then((response)=>{
       setEmailError(response.data);
       })
     .catch((err)=>{
      console.log(err.message)
      
    })

    }
  };

  const handleEmailChange = (e) => {
    setValues(prevValues => ({
      ...prevValues,
      userName: (e.target.value)
    }));
    validateEmail(e.target.value);
  };

  

    
   
   


    

  return (
    <div className='container' alignItems='center' >
  <div class="jumbotron" style={{width:"50%" ,height:"50",alignContent:"center"}} alignContent="center  "  >
        <h3>Register</h3>
          <TextField
          id="userName"
          label="Registered Email"
          type="email"
          value={values.userName}
          onChange={handleEmailChange}
          error={!!emailError}
          helperText={emailError}
          autoComplete="off"
        />
     

    
      <div>
        <button type="submit" onClick={handleSubmit}>submit</button>
        <h6><a href="demo2" >go back to login!</a></h6>
        </div>
        </div>
{
  <Snackbar
  open={disSuccess}
  autoHideDuration={3000}
  onClose={()=>setDisSuccess(!disSuccess)}
  anchorOrigin={{ vertical: 'top', horizontal: 'center' }}
>
  <MuiAlert elevation={6} variant="filled" onClose={()=>setDisSuccess(!disSuccess)} severity="success">
   {dispSuccess}
  </MuiAlert>
</Snackbar>
}

      </div> 
       )
      }
      
      export default Register