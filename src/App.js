import logo from './logo.svg';
import './App.css';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

import { BrowserRouter, Route, Routes } from "react-router-dom";
import Footer from './component/Footer';
import Header from './component/Header';
import Subheader from './component/Subheader';
import Index from './component/Index';
import Title from './component/Title';
import LoginIn from './component/LoginIn';
import Signup from './component/signUp';
import AddTransaction from './component/AddTransaction';
import AboutUs from './component/AboutUs';
import FAQ from './component/FAQ';
// import AddBank from './component/AddBank';
import Admin from './component/Admin';
import AllTransaction from './component/AllTransaction';
import TransactionReport from './component/TransactionReport';
import CurrencyConverter from './component/CurrencyConverter';
import Admin_Footer from './component/Admin_Footer';
// import Contact from './component/Contact';
import Admin_Index from './component/Admin_Index';
import SaveUserBankDetails from './component/SaveUserBankDetails';
import Report from './component/Report';
import AddCurrency from './component/AddCurrency';
import Demo from './component/Demo';
import Demo2 from './component/Demo2';
import Register from './component/Register';
import ForgotPassFirst from './component/ForgotPassFirst';
import VerifyOtp from './component/VerifyOtp';
function App() {
 
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
        <Route path='/Admin' element={<Admin/>}></Route>
        <Route path='/AllTransaction' element={<AllTransaction/>}></Route>
          <Route path='/Title' element={<Title />}></Route> 
          <Route path='/Footer' element={<Footer/>}></Route>
          <Route path='/Header' element={<Header />}></Route>
          <Route path='/Subheader' element={<Subheader />}></Route>
          <Route path='/' element={<Index/>}></Route>
          <Route path='/LoginIn' element={<LoginIn/>}></Route>
          <Route path ="/signup"element={<Signup/>}/>
          <Route path='/AddTransaction' element={<AddTransaction />}></Route> 
          <Route path='/makePayment' element={<makePayment />}></Route>
          <Route path='/AboutUs' element={<AboutUs />}></Route>
           <Route path='/FAQ' element={<FAQ />}></Route> 
           <Route path='/Report' element={<Report/>}></Route>
           {/* <Route path='/AddBank' element={<AddBank />}></Route>  */}
           <Route path='/TransactionReport' element={<TransactionReport/>}></Route> 
           <Route path='/CurrencyConverter' element={<CurrencyConverter/>}></Route> 
           <Route path='/Admin_Footer' element={<Admin_Footer/>}></Route> 
            {/* <Route path='/Contact' element={<Contact/>}></Route>   */}
           <Route path='/Admin_Index' element={<Admin_Index/>}></Route> 
           <Route path='/SaveUserBankDetails' element={<SaveUserBankDetails/>}></Route> 
           <Route path='/AddCurrency' element={<AddCurrency/>}></Route>
       <Route path='/register' element={<Register/>}></Route>
       <Route path='/forgotPassFirst' element={<ForgotPassFirst/>}></Route>
       <Route path='/verifyOtp/:userName' element={<VerifyOtp/>}></Route>
<Route path="/demo" element={<Demo/>}></Route>
<Route path="/demo2" element={<Demo2/>}></Route>

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
