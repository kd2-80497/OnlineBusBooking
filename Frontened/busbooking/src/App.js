
import './App.css';
import { Route,Routes } from 'react-router-dom';
import SignUp from './Routes/SignUp';
import Signin from './Routes/Signin';
import Navbar from './components/Navbar';
import Home from './Routes/Home';
import Contact from './Routes/Contact';
function App() {
  return <div className='app'>
     <Navbar> </Navbar>
    <Routes>
    {/* <Route path="*" element={<NotFoundPage />} /> */}
          <Route path="/" element={<Home />} />
      <Route path='/signup' element={<SignUp/>}></Route>
      <Route path='/signin' element={<Signin/>}></Route>
      <Route path='/contact' element={<Contact/>}></Route>
    </Routes>
  </div>
}

export default App;
