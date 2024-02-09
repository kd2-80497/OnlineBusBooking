
import { useState } from "react";
import axios from "axios";
// import { Toast } from "bootstrap";

const SignUp=()=>{

    const [formData, setFormData] = useState({
    
        email: '',
        password: '',
        firstName: '',
        lastName: '',
        phoneNumber: '',
       role:'',
      });
      
    
      const { email, password, firstName, lastName, phoneNumber, role } = formData;
    
      const onChange = e => setFormData({ ...formData, [e.target.name]: e.target.value });


      const onSubmit =async (event) =>{
        event.preventDefault();
        
       
      
    
    try{
      const response = await axios.post("http://localhost:8080" +`/signup`, formData);
      console.log(response.data)
    //   // toast.success('Registration Successful.', {
    //     position: toast.POSITION.TOP_CENTER
    //  }
  
      // navigate('/login');
    }
    catch(error){
        if (error.response.status === 404) {
            // // toast.error(`${error.response.data}`, {
            //     position: toast.POSITION.TOP_CENTER
            // });
        }
    }
  }
        
    return <div>
        <h1>SignUp Here</h1>
        <form onSubmit={e => onSubmit(e)}>

        <div >
           <label htmlFor="firstName">firstName: </label>
            <br />
          <input type='text' placeholder='firstName' name='firstName' value={firstName} onChange={e => onChange(e)} required />
        </div> 
        <div >
           <label htmlFor="lastName">lastName: </label>
            <br />
          <input type='text' placeholder='lastName' name='lastName' value={lastName} onChange={e => onChange(e)} required />
        </div>
        <div >
           <label htmlFor="email">email: </label>
            <br />
          <input type='email' placeholder='email' name='email' value={email} onChange={e => onChange(e)} required />
        </div>
        <div >
           <label htmlFor="password">password: </label>
            <br />
          <input type='password' placeholder='password' name='password' value={password} onChange={e => onChange(e)} required />
        </div>
        <div >
           <label htmlFor="phoneNumber">phoneNumber: </label>
            <br />
          <input type='phoneNumber' placeholder='phoneNumber' name='phoneNumber' value={phoneNumber} onChange={e => onChange(e)} required />
        </div>
        <div >
           <label htmlFor="role">role: </label>
            <br />
          <input type='role' placeholder='role' name='role' value={role} onChange={e => onChange(e)} required />
        </div>
       <div><input type='submit' className='add-flight-form button' value='Register' /></div>
        </form>
    </div>
}

export default SignUp;