import { Route,Routes } from "react-router-dom";
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Signin from "./pages/Signin";
import Signup from "./pages/Signup";
import Home from "./pages/Home";
 import Bus from "./pages/Bus";
import Booking from "./pages/Booking";
import ContactUs from "./pages/contact/ContactUs";
import AboutUs from "./pages/AboutUs";
import { PassengerForm } from "./pages/PassengerForm";
function App() {
  return (
    <div className="container">
   <Routes>
    <Route  index element={<Signin/>}   />
    <Route  path='/' element={<Signin/>}   />
    <Route  path='/signup' element={<Signup/>}   />
    <Route  path='/home' element={<Home/>}   />
    <Route  path='/bus' element={<Bus/>}   />
    <Route  path='/booking' element={<Booking/>}   />
    <Route  path='/contact' element={<ContactUs/>}   />
    <Route  path='/aboutus' element={<AboutUs/>}   />
    <Route  path='/passenger' element={<PassengerForm/>}   />
   </Routes>
   <ToastContainer />
    </div>
  );
}

export default App;
