import { Avatar, Button, Checkbox, Grid, Paper, TextField, Typography } from '@mui/material';
import React from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import {FormHelperText} from '@mui/material'
import { Link } from 'react-router-dom';
import { Formik,Field,Form,ErrorMessage } from 'formik';
import * as Yup from 'yup'








const signup=()=>{
    const paperStyle={padding:'30px 20px',width:380, margin:'20px auto'}
    const headerStyle={margin:0}
    const avatarStyle={backgroundColor:'green'}
    const initalValues={
        name:'',
        email:'',
        gender:'',
        mobileNo:'',
        password:'',
        confirmPassword:'',
        termsAndConditions:false
    }
    const validationSchema=Yup.object().shape({
        name:Yup.string().min(3,"It's too short").required("Required"),
        email:Yup.string().email("Enter valid email").required("Required"),
        gender:Yup.string().oneOf(["male","female"],"Required").required("Required"),
        mobileNo:Yup.number().typeError("Enter valid Mobile No").required("Required"),
        password:Yup.string().min(8,"Password  minimum length should be 8").required("Required"),
        confirmPassword:Yup.string().oneOf([Yup.ref('password')],"Password not matched").required("Required"),
        termsAndConditions:Yup.string().oneOf(["true"],"Accept terms & conditions")
    })
    const onSubmit=(values,props)=>{
        console.log(values)
        console.log(props)
        setTimeout(()=>{
            props.resetForm()
            props.setSubmitting(false)
        },2000)
    }
    return (
        <Grid>
            <Paper elevation={20} style={paperStyle}>
                <Grid align='center'>
                    <Avatar style={avatarStyle}>
                    <AddCircleOutlineIcon/>
                    </Avatar>
                    <h2 style={headerStyle}>Sign Up</h2>
                    <Typography variant='caption' gutterBottom>Please fill this form to create an account</Typography>
                </Grid>
                <Formik initialValues={initalValues} validationSchema={validationSchema} onSubmit={onSubmit}>
                    {(props)=>(
                        <Form>
                            
                    <Field as={TextField} fullWidth name="name" label='Name'
                     placeholder='Enter your name' helperText={<ErrorMessage name='name'/>}/>
                    <Field as={TextField} fullWidth name="email" label='Email'
                     placeholder='Enter your name' helperText={<ErrorMessage name='email'/>}/>
                    <FormControl>
  <FormLabel component="legend">Gender</FormLabel>
  <RadioGroup
    aria-label="gender" name="gender" style={{display:'initial'}}
  >
    <FormControlLabel value="female" control={<Radio />} label="Female" />
    <FormControlLabel value="male" control={<Radio />} label="Male" />
  </RadioGroup>
</FormControl>
<FormHelperText><ErrorMessage name='gender'/></FormHelperText>
                    <Field as={TextField} fullWidth name="mobileNo" label='Mobile No'
                    placeholder='Enter your mobileNo' helperText={<ErrorMessage name='mobileNo'/>}/>
                    <Field as={TextField} fullWidth name="password" type="password" label='Password'
                    placeholder='Enter your password' helperText={<ErrorMessage name='password'/>}/>
                    <Field as={TextField} fullWidth name="confirmPassword" type="password" label='Confirm Password'
                    placeholder='Enter your confirm password' helperText={<ErrorMessage name='confirmPassword'/>}/>
                    <FormControlLabel
                    control={<Field as={Checkbox} name="termsAndConditions" />}
                    label="I accept the terms and conditions."/>
                    <FormHelperText><ErrorMessage name='gender'/></FormHelperText>
                    {/* <Link to='/signup'> */}
                    <Button type='submit' variant='contained' disabled={props.isSubmitting} color='primary'>{props.isSubmitting?"Loading":"sign Up"}</Button>
                    {/* </Link> */}

                    <Link to='/'>
                    
                    <Button type='submit' variant='contained' color='secondary'>Cancel</Button>
                    </Link>
                
                        </Form>
                    )}
                </Formik>
            </Paper>
        </Grid>
    )
}
export default signup;