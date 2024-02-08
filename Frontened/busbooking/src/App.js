
import './App.css';
import { Route,Routes } from 'react-router-dom';
import SignUp from './Routes/SignUp';
import Signin from './Routes/Signin';
import Navbar from './components/Navbar';
import Home from './Routes/Home';

function App() {
  return <div className='app'>
     <Navbar> </Navbar>
    <Routes>
    {/* <Route path="*" element={<NotFoundPage />} /> */}
          <Route path="/" element={<Home />} />
      <Route path='/signup' element={<SignUp/>}></Route>
      <Route path='/signin' element={<Signin/>}></Route>
      
    </Routes>
  </div>
}

export default App;
