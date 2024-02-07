import logo from './logo.svg';
import './App.css';
import { Route,Routes } from 'react-router-dom';
import SignUp from './Routes/SignUp';

function App() {
  return <div className='app'>
    <Routes>
      <Route path='/signup' element={<SignUp/>}></Route>
    </Routes>
  </div>
}

export default App;
