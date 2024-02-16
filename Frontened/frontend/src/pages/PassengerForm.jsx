import { useState } from "react";
// import back from '../assests/back.jpg';
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { passenger } from "../services/passenger";

export function PassengerForm(){
   
    const[firstName,setFirstName]=useState('');
    const[lastName,setLastName]=useState('');
    const[gender,setGender]=useState('');
    const[age,setAge]=useState('');
    const[seatNumber,setSeatNumber]=useState('');
   // const navigate = useNavigate();
    const  handleSubmit=async()=>{
      debugger;
        if (firstName.length === 0) {
            toast.warn('enter first name')
          } else if (lastName.length === 0) {
            toast.warn('enter last name')
          } else if (gender.length === 0  ) {
            toast.warn('enter gender')
          } else if (age.length === 0) {
            toast.warn('enter age')
          } else if (seatNumber.length === 0) {
            toast.warn('enter seatNumber')
          } 
          else{
            const result = await passenger(firstName,lastName,gender,age,seatNumber)
            
            if(result.status ==="success"){
                toast.success("Passenger details added successfully")
              //  navigate('/')
            }
            else{
                toast.error(result['error'])
            }
          }
       }
      
  return (
    <>
   
   <div className="container mt-5" >
      <div className="card">
      <img src="assests\back.jpg" className="card-img-top" alt="Bus Image" />
        <div className="card-body">
          <h1 className="card-title text-center mb-4">Passenger Details</h1>
      <form onSubmit={(e) => { e.preventDefault(); handleSubmit(); }}>
        <div className='row'>
          <div className='col'></div>
          <div className='col'>
            <div className='form'>
              <div className='mb-3'>
                <label htmlFor='firstName' className='form-label'>First Name</label>
                <input
                  onChange={(e) => setFirstName(e.target.value)}
                  type='text'
                  className='form-control'
                />
              </div>
              <div className='mb-3'>
                <label htmlFor='lastName' className='form-label'>Last Name</label>
                <input
                  onChange={(e) => setLastName(e.target.value)}
                  type='text'
                  className='form-control'
                />
              </div>
              <div className='mb-3'>
                <label htmlFor='gender' className='form-label'>Gender</label>
                <select
                  onChange={(e) => setGender(e.target.value)}
                  className='form-select'
                  id='gender'
                >
                  <option value='' disabled>Select Gender</option>
                  <option value='male'>Male</option>
                  <option value='female'>Female</option>
                  <option value='other'>Other</option>
                </select>
              </div>
              <div className='mb-3'>
                <label htmlFor='age' className='form-label'>Age</label>
                <input
                  onChange={(e) => setAge(e.target.value)}
                  type='number'
                  className='form-control'
                  id='age'
                  min='1' // Set the minimum age (adjust as needed)
                  max='120' // Set the maximum age (adjust as needed)
                  required // Add the required attribute for form validation
                />
              </div>
              <div className='mb-3'>
                <label htmlFor='seatNumber' className='form-label'>Seat Number</label>
                <input
                  onChange={(e) => setSeatNumber(e.target.value)}
                  type='number'
                  placeholder=''
                  className='form-control'
                />
              </div>
              <div className='mb-3'>
                {/* <div>
                  Already got an account? <Link to='/'>Sign in here</Link>
                </div> */}
                <button type='submit'className='btn btn-primary mt-4'>
                  Add Passenger
                </button>
              </div>
            </div>
          </div>
          <div className='col'></div>
        </div>
      </form>
      </div>
      </div>
      </div>
    </>
  );
}