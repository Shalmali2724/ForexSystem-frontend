import React, { useEffect, useState } from 'react';
import userBankBgImage from './image/userBankBgImage.jpg';
import './UserBankdetails.css';
import axios from 'axios';
function UserBankDetails()
{
     const [bankId,setBankId] = useState("");
     const[name,setName]=useState(""); 
     const[bankName,setBankName]=useState(""); 
     const[accountNumber,setAccountNumber]=useState("");
     const[ifscCode,setIfscCode]=useState("");
     const[contactNumber,setContactNumber]=useState("");
     const [formErrors, setFormErrors] = useState({});


     const handleCancel = () => {
        const confirmed = window.confirm('Are you sure you want to cancel?');
        if (confirmed) {
         
        }}

     const handleSubmit = () => {
        let errors = {};
        if (!name) {
            errors['NameError'] = "Name is required."
        }
         if (!accountNumber) {
            errors['AccountNumberError'] = "Account Number  is required."
        }
       
        if (!ifscCode) {
            errors['IFSCCodeError'] = "IFSC Code is required."
        } 
        if (!bankName) {
            errors['bankNameError'] = "Bank Name is required."
        } 
        if (!contactNumber) {
            errors['contactNumberError'] = "Contact Number is requred."
        } 
        // if (!contactNumber <= 10) {

        //     errors['contactNumberError'] = "Invalid Mobile no(Only 10 digit)/ characters not allowed."
            
        //      }


        setFormErrors(errors);
        const noErrors = Object.keys(errors).length === 0;
        // if no errors then  call the api
        if (noErrors) {

            const payload = {
                acHolderName:name,
                bankName: bankName,
                accountNumber:accountNumber,
                ifscCode:ifscCode,
                contactNumber:contactNumber
        


            }
            
            axios.post("http://localhost:8081/UserBankDetails/save", payload).then(resp => alert("Bank Details Saved: "+resp.data.id));
        }
     }


return(

<div  class="main-div" align='center'>
    
    <div align='center'>
   

     <div class=" my-1 col-md-6 mb-4">
    <label><h6>Registration Id </h6></label>
    <input type="text" name="bankId" value={bankId} className="form-control" disabled placeholder="Enter registration Id"/>
     </div>


        <div  class="col-md-6 mb-4">
        <label><h6>Account Holder Name</h6></label>
        <input type="text" name="name"  value={name} onChange={(event) => setName(event.target.value)} className="form-control" placeholder="Enter Account Holder Name"/>
        {
        formErrors.NameError && <div style={{ color: "red" }}>{formErrors.NameError}</div>
        }
        </div>
        <div class="col-md-6 mb-4">
        <label><h6>Bank Name</h6></label>
        <input type="text"className="form-control" name="bankName"  value={bankName} onChange={(event) => setBankName(event.target.value)} placeholder="Enter Bank Name "/>
        {
        formErrors.bankNameError && <div style={{ color: "red" }}>{formErrors.bankNameError}</div>
        }
        </div> 

        <div class="col-md-6 mb-4">
        <label><h6>Account Number</h6></label>
        <input type="text" className="form-control" value={accountNumber} onChange={(event) => setAccountNumber(event.target.value)}name="accountNumber" placeholder="Enter Account Number"/>
        {
        formErrors.AccountNumberError && <div style={{ color: "red" }}>{formErrors.AccountNumberError}</div>
        }
        </div>

        <div class="col-md-6 mb-4">
        <label><h6>Bank IFSC Code</h6></label>
        <input type="text" className="form-control" value={ifscCode} name="ifscCode" onChange={(event) => setIfscCode(event.target.value)} placeholder="Enter Bank IFSC Code"/>
        {
        formErrors.IFSCCodeError && <div style={{ color: "red" }}>{formErrors.IFSCCodeError}</div>
        }
        </div>

        <div class="col-md-6 mb-4">
        <label><h6>Contact Number</h6></label>
        <input type="text" className="form-control"  value={contactNumber} name="contactNumber" onChange={(event) => setContactNumber(event.target.value)}placeholder="Enter Contact Number"/>
        {
        formErrors.contactNumberError && <div style={{ color: "red" }}>{formErrors.contactNumberError}</div>
        }
        </div>

 

        <div class="col-md-6 mb-4">
        <button type="button" className="btn btn-primary" onClick={handleSubmit} >Submit</button>

        <button type="button" className="btn btn-primary" style={{marginLeft:"10px"}} onClick={handleCancel}>Cancel</button><br></br>
        </div>

</div>
</div>


)

}
export default UserBankDetails;