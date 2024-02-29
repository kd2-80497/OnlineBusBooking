import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'

import { signinUser } from '../services/user'
import axios from 'axios'

export function Signin() {
 
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const navigate = useNavigate()
  debugger;
  const onSignin = async () => {
    if (email.length == 0) {
      toast.warn('enter email')
    } else if (password.length == 0) {
      toast.warn('enter password')
    } else {
      // make the api call
      
      const result = await signinUser(email, password)
      console.log("resULT"+result);
      if (result['status'] != 'error') {
        // cache the token
        const token = result.data.token;
   console.log(token);

      

            sessionStorage.setItem("jwtToken", token);
            sessionStorage.setItem('userid', result.id);
            sessionStorage.setItem('role', result.role);

            toast.success('Welcome to Yatri')
            navigate('/home')


          }

       
        




       else {
        toast.error(result['error'])
      }

    }
  }

  // const onForgotPassword= async () => {
  //   if (email.length == 0) {
  //     toast.warn('enter email')
  //   } else if (password.length == 0) {
  //     toast.warn('enter password')
  //   } else {
  //     // make the api call
  //     const result = await signinUser(email, password)
  //     if (result['status'] == 'success') {
  //       // cache the token
  //       const token = result['data']['token']
  //       sessionStorage['token'] = token

  //       toast.success('Welcome to the busbooking ')
  //       navigate('/home')
  //     } else {
  //       toast.error(result['error'])
  //     }
  //   }
  // }

  return (
    <>
      <h1 className='title'>Signin</h1>

      <div className='row'>
        <div className='col'></div>
        <div className='col'>
          <div className='form'>
            <div className='mb-3'>
              <label htmlFor=''>Email</label>
              <input
                onChange={(e) => setEmail(e.target.value)}
                type='email'
                placeholder='abc@test.com'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <label htmlFor=''>Password</label>
              <input
                onChange={(e) => setPassword(e.target.value)}
                type='password'
                placeholder='xxxxxxxx'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <div>
                Don't have an account? <Link to='/signup'>Signup here</Link>
              </div>
              <button onClick={onSignin} className='btn btn-primary mt-2'>
                Signin
              </button>
            </div>
            <div className='mb-3'>
              <div>
                Don't have an account? <Link to='/forgotpassword'>forgotpassword here</Link>
              </div>
              {/* <button onClick={onForgotPassword} className='btn btn-primary mt-2'>
                ForgotPassword
              </button> */}
            </div>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </>
  )
}

export default Signin