import Navbar from "../components/Navbar";
import '../styles/HomeStyles.css';
import { Link, useNavigate } from 'react-router-dom'
export function Home(){
    const navigate = useNavigate();
    const handleClick = () => {
        console.log('Button clicked!');
        navigate('/booking')
      };

    return (<>
    <Navbar/>
    <div className="home">
    <div className="container">
       
    <h1 className='title' class="text-xxl-end">WELCOME TO YATRI</h1>
    <button onClick={handleClick} className="btn btn-secondary btn-sm z-3 position-absolute p-5 rounded-3" style={{ display: 'flex', justifyContent: 'flex-end' }} >Book Ticket</button>
   
    </div>
    
    </div>
    </>)

}

export default Home ;