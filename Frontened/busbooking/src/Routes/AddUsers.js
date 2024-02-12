//import axios from 'axios';
import { useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useEffect } from 'react';
import usersService from '../services/users.service';


const AddUsers = () => {
  const [firstName, setFirstname] = useState('');
  const [lastName, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [role, setRole] = useState('');
  
  

  const navigate = useNavigate();
 // const { id } = useParams();

  const saveUsers = (e) => {
    e.preventDefault();

    const Users = {
      firstName,
      lastName,
      email,
      password,
     phoneNumber,
     role
    };
    
      //create
      usersService
        .create(Users)
        .then((response) => {
          console.log('Users added successfully', response.data);
          navigate('/');
        })
        .catch((error) => {
          console.log('something went wroing' + error.response);
        });
 
      }

  return (
    <div className='container'>
      <h3>Add Users</h3>
      <hr />
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='firstName'
            value={firstName}
            onChange={(e) => setFirstname(e.target.value)}
            placeholder='Enter first name'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='lastName'
            value={lastName}
            onChange={(e) => setLastname(e.target.value)}
            placeholder='Enter last name'
          />
        </div>
       
        <div className='form-group'>
          <input
            type='email'
            className='form-control col-4'
            id='email'
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder='Enter Email'
          />
          </div>
          <div className='form-group'>
          <input
            type='password'
            className='form-control col-4'
            id='password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder='Enter Password'
          />
          </div>
          <div className='form-group'>
          <input
            type='phoneNumber'
            className='form-control col-4'
            id='phoneNumber'
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            placeholder='Enter PhoneNumber'
          />
          </div>
        {/* {/ <div className='form-group'>
          <input
            type='password'
            className='form-control col-4'
            id='password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder='Enter Password'
          />
        </div>
        <div className='form-group'>
          <input
            type='password'
            className='form-control col-4'
            id='password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder='Enter Password'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='department'
            value={department}
            onChange={(e) => setDepartment(e.target.value)}
            placeholder='Enter Department'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='location'
            value={location}
            onChange={(e) => setLocation(e.target.value)}
            placeholder='Enter Location'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='sal'
            value={salary}
            onChange={(e) => setSalary(e.target.value)}
            placeholder='Enter salary'
          />
        </div>
        <div className='form-group'>
          <input
            type='date'
            className='form-control col-4'
            id='joinDate'
            value={joinDate}
            onChange={(e) => setJoindate(e.target.value)}
            placeholder='Enter Joining date'
          />
        </div> } */}
        <div>
          <button onClick={(e) => saveUsers(e)} className='btn btn-primary'>
            Save Or Update
          </button>
        </div>
      </form>
      <hr />
      <Link to='/'>Back to List</Link>
    </div>
  );

};

export default AddUsers;










