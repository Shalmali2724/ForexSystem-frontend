import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import  './CSS/AllTransaction.css';

function AllTransaction() {
    return (
        <div class="flex-container">
            <div class="flex-item">
                <h1>Transaction List</h1>

            </div>
            <button  style={{width:"100px" }} ><Link to="/admin/dashboard" align="left"> </Link></button>
            <div class="header_fixed">
            </div>


            <table>

                <thead>

                    <tr>

                        <th>From Country</th>
                        <th>To Country</th>
                        <th>Sender's Name </th>
                        <th>Receiver's Name</th>
                        <th>Sender's Account No</th>
                        <th>Receiver's Account No</th>
                        <th>Sender's CurrencyName</th>
                        <th>Receiver's CurrencyName</th>
                        <th>Sending Amount</th>
                        <th>Extra Charges</th>

                        
                    </tr>

                </thead>

                            </table>

        </div>

    )
}

export default AllTransaction;

