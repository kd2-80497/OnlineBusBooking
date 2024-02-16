import { Route,Routes } from "react-router-dom";
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Signin from "./pages/Signin";
import Signup from "./pages/Signup";
import ForgotPassword from "./pages/ForgotPassword";
import Home from "./pages/Home";
 import Bus from "./pages/Bus";
import Booking from "./pages/Booking";
import Payment from "./pages/Payment";
import Feedback from "./pages/Feedback";
function App() {
  return (
    <div className="container">
   <Routes>
    <Route  index element={<Signin/>}   />
    <Route  path='/' element={<Signin/>}   />
    <Route  path='/signup' element={<Signup/>}   />
    <Route  path='/home' element={<Home/>}   />
     <Route  path='/forgotPassword' element={<ForgotPassword/>}   /> 
    <Route  path='/bus' element={<Bus/>}   />
    <Route  path='/booking' element={<Booking/>}   />
    <Route  path='/payment' element={<Payment/>}   />
    <Route  path='/feedback' element={<Feedback/>}   />
   </Routes>
   <ToastContainer />
    </div>
  );
}

export default App;
