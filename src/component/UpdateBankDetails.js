function UpdateBankDetails()
{
    const [bankId,setBankId] = useState("");
    const[name,setName]=useState(""); 
    const[bankName,setBankName]=useState(""); 
    const[accountNumber,setAccountNumber]=useState("");
    const[ifscCode,setIfscCode]=useState("");
    const[contactNumber,setContactNumber]=useState("");
    const [formErrors, setFormErrors] = useState({});

    
return(
    <Container maxWidth="sm" style={{display:'flex',justifyContent:"center",alignItems:"center",height:"100vh"}}>
          
    <form  style={{ display:"flex",marginTop:"-50%" ,flexDirection:"column",minWidth:"300px",maxWidth:"500px",height:"150px"}}>
    <h2>Bank Details</h2>

    
  
    
     <TextField
        label="Account Holder Name" value={name} onChange={(event)=>setName(event.target.value)}required
        error={!!formErrors.NameError} helperText={formErrors.NameError}
        style={{marginBottom:"10px"}}>
   </TextField>
     
     <TextField
        label="Bank Name " value={bankName} onChange={(event)=>setBankName(event.target.value)}required
        error={!!formErrors.bankNameError} helperText={formErrors.bankNameError}
        style={{marginBottom:"10px"}}></TextField>
     
     <TextField
        label="Account  Number " value={accountNumber} onChange={(event)=>setAccountNumber(event.target.value)}required
        error={!!formErrors.AccountNumberError} helperText={formErrors.AccountNumberError}
        style={{marginBottom:"10px"}}></TextField>
     
     <TextField
        label="IFSC Code " value={ifscCode} onChange={(event)=>setIfscCode(event.target.value)}required
        error={!!formErrors.IFSCCodeError} helperText={formErrors.IFSCCodeError}
        style={{marginBottom:"10px"}}></TextField>

         <TextField
        label="Contact Number" value={contactNumber} onChange={(event)=>setContactNumber(event.target.value)}required
        error={!!formErrors.contactNumberError} helperText={formErrors.contactNumberError}
        style={{marginBottom:"10px"}}></TextField>
      
     
      
      
     
     <div style={{display:"flex",justifyContent:"space-between"}}>
     <Button onClick ={handleSubmit} type="submit" variant="contained" color="primary" fullWidth >Submit</Button>
     </div>
     <div style={{marginTop:"5%"}}>
       <Link to="/"><Button type="button"variant="contained" color="secondary" fullWidth>Cancel</Button></Link>
   
   </div>
  
  
    </form>
    </Container>  
  
    
    
    )
    


}
export default UpdateBankDetails;