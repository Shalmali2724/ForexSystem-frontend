import React, { useState } from "react";
import axios from "axios";
import './CSS/TransactionReport.css'
import Subheader from "./Subheader";
import Footer from "./Footer";
import { Link } from "react-router-dom";


function TransactionReport() {
    const [transactions, setTransactions] = useState([]);
    const [transactionId, setTransactionId] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

        if (!transactionId) {
            setError('Please enter a transaction ID.');
            return;
        }

        axios.get(`/api/transactions/${transactionId}`).then((response) => {
            setTransactions([response.data]);
            setError('');
        }).catch((error) => {
            setTransactions([]);
            setError('Transaction not found.');
        });
    }

    return (
        <>
            {<div>
            <Subheader/>

            <Footer/>
            
        </div> }

        <div className="receipt">
            <div className="transaction-header">
                <h2>Transaction Report</h2>
            </div>
            <form onSubmit={handleSubmit}>
                <h5>
                    Enter Transaction ID:
                    <input type="text" value={transactionId} onChange={(e) => setTransactionId(e.target.value)} />
                </h5>
                {/* <button type="submit" >Generate Report</button> */}
                <Link to="/Report"><button type="button" className="btn btn-primary" style={{ marginLeft: "10px" }} >Generate Report</button></Link>
                {error && <p className="error">{error}</p>}
            </form>
        </div>
   </> 
   );
}

export default TransactionReport;


