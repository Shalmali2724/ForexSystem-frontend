import React from "react";
import './CSS/Admin.css';

function Admin() {
	return (
        <div class="header">
       <a href="#default" class="logo">Admin</a>
        <div class="header-center">
          <div class="menu-bar">

          <a href="/Admin">Home</a>

          <a href="/AddCurrency">AddCurrency</a>
            <a href="/AllTransaction">Transaction History</a>
            <a href="/UpdateCurrency">UpdateCurrency</a>
            
           <div class="header-right"> 
          <a href="/LoginIn">SignOut</a>
          

          </div>
          </div>
                </div>
                </div>
                


      
              )
}
export default Admin;

