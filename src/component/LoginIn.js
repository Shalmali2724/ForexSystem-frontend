import React from 'react'
import { Grid,Paper, Avatar, TextField, Button, Typography,Link } from '@mui/material'
import * as Yup from 'yup'
import { Formik,Form,Field,ErrorMessage } from 'formik'
const LoginIn=({})=>{
    const paperStyle={padding :20,height:'70vh',width:280, margin:"20px auto"}
    const avatarStyle={backgroundColor:'#1bbd7e'}
    const btnstyle={margin:'8px 0'}
    const initalValues={
        username:'',
        password:''
    }
    const validationSchema=Yup.object().shape({
        username:Yup.string().email('Please enter valid email').required("Required"),
        password:Yup.string().required("Required")
    })
    const onSubmit=(values,props)=>{
        console.log(values)
        setTimeout(()=>{
            props.resetForm()
            props.setSubmitting(false)

        },2000)
         console.log(props)
    }
    return(
        <Grid> <Paper elevation={10} style={paperStyle}>  <Grid align='center'><Avatar style={avatarStyle}></Avatar>
                    <h2>Sign In</h2>
                </Grid>
                <Formik initialValues={initalValues} onSubmit={onSubmit} validationSchema={validationSchema}> 
                    {(props)=>(
                    <Form>
            <Field as={TextField} label='Username' name="username" placeholder='Enter username' fullWidth required  helperText={<ErrorMessage name="username"/>} />
                <Field as={TextField} label='Password' name="password" placeholder='Enter password' type='password' fullWidth required helperText={<ErrorMessage name="password"/>}
                 />      
                <Button type='submit' color='primary' variant="contained" disabled={props.isSubmitting}
                 style={btnstyle} fullWidth>{props.isSubmitting?"Loading":"Sign in"}</Button>
                 {console.log(props)} </Form>
                    )}</Formik>
                <Typography > Do you have an account ?
                     <Link href="SignUp" >  Sign Up  </Link><br></br> <Link href='/'>
                    <Button type='submit' variant='contained' color='secondary'>Cancel</Button>
                    </Link>  </Typography></Paper> </Grid>)}
export default LoginIn;