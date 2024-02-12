
import './App.css';
import { Route,Routes } from 'react-router-dom';
import SignUp from './Routes/SignUp';
import Signin from './Routes/Signin';
import Navbar from './components/Navbar';
import Home from './Routes/Home';

import Contact from './Routes/Contact';

import AboutUs from './components/AboutUs';
import { createContext, useReducer } from "react";
import { initialState, reducer } from "./reducer/UseReducer";
import AddUsers from './Routes/AddUsers';

export const UserContext = createContext();

function App() {
  const [state, dispatch] = useReducer(reducer, initialState);
  return <div className='app'>
     <Navbar> </Navbar>
    <Routes>
    {/* <Route path="*" element={<NotFoundPage />} /> */}
          <Route path="/" element={<Home />} />
      <Route path='/signup' element={<SignUp/>}></Route>
      <Route path='/signin' element={<Signin/>}></Route>
      <Route path='/addUsers' element={<AddUsers/>}></Route>

      <Route path='/contact' element={<Contact/>}></Route>

      <Route path='/about' element={<AboutUs/>}></Route>

    </Routes>
  </div>
}

export default App;
