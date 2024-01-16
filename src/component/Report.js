import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import './CSS/Report.css';


function Report() {

    const handleDownload = () => {
        axios.get(`/api/download`).then((response) => {
          console.log(response.data); // check response data
          const url = window.URL.createObjectURL(new Blob([response.data]));
          const link = document.createElement('a');
          link.href = url;
          link.setAttribute('download', 'receipt.pdf');
          document.body.appendChild(link);
          link.click();
        
          // Show success message
          const message = document.createElement('p');
          message.innerText = 'Download successful!';
          document.body.appendChild(message);
        
          // Remove message after a few seconds
          setTimeout(() => {
            document.body.removeChild(message);
          }, 3000);
        }).catch((error) => {
          console.log(error);
        });
      };
         
    const handleCancel = () => {
        
    }

    return (
        <div className="receipt"  >
            <div className="receipt-header">
                {/* <img src="https://examplebank.com/images/logo.png" alt="Bank Logo" /> */}
                <h1>FOREX TRANSACTION RECEIPT</h1>
            </div>
            <div className="receipt-details">
                <p><span>Customer Name:</span></p>
                <p><span>Account Number:</span></p>
                <p><span>Transaction ID:</span></p>
                <p><span>Transaction Date:</span></p>
                
            </div>
            <div className="receipt-summary">
                {/* <table>
                    <thead>
                        <tr>
                            <th>Currency</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    {/* <tbody>
                        <tr>
                            <td>USD</td>
                            <td>$1000.00</td>
                        </tr>
                        <tr>
                            <td>EUR</td>
                            <td>€500.00</td>
                        </tr>
                    </tbody> 
                </table> */}
                <p><span>Total Amount:</span></p>
            </div>
            <div className="receipt-footer">
                <p>Thank you for your business.</p>
            </div>
            <div className="btnDiv">
                <button type="button" className="btn btn-primary" onClick={handleDownload}>Download</button>
                <Link to="/Index"><button type="button" className="btn btn-primary" style={{ marginLeft: "10px" }} onClick={handleCancel}>Cancel</button></Link>
            </div>
        </div> 
    );
    
}

export default Report;
