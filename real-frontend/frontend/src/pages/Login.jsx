import React from 'react'
import Logo from '../assets/icon_logo.svg'
import Email from '../assets/icon_email.svg';
import Eye from '../assets/icon_eye.svg';
import Password from '../assets/Frame.svg';

import Arrow from '../assets/icon_arrow.svg';
const Login = () => {
  return (
    <div className='h-screen w-screen font-inter '>
      <div className="bg-white gap-7 mt-7 min-h-full flex flex-col w-full  items-center">
        <div className='flex py-3 gap-3 w-fit justify-around'>
          <img className='h-[60px] w-[60px]' src={Logo} alt="" />
          <h1 className='max-w-25 self-center font-san font-bold text-2xl'>Group Cinema</h1>
        </div>
        <div className='text-inherit text-center font-semibold text-2xl max-w-25  '>Welcome Back </div>
        <div><p className='font-inter font-normal text-[12px] max-w-28 text-gray-600 text-center'>Please login to your account</p></div>
        <div className='flex flex-col gap-2'>
        <div className="w-84">
          <div className='bg-primary m-3 w-full rounded-4xl py-4 px-5'>
            <div className='flex gap-2 w-full'>
              <img src={Email} alt="" />
              <input className="placeholder-white basis-auto" type='email' placeholder='Email' />
            </div>
          </div>
        </div>
          <div className="w-84">
            <div className='bg-primary m-3 w-full rounded-4xl py-4 px-5'>
              <div className='flex gap-2 w-full'>
                <div className='flex gap-2'>
                <img src={Password} alt="" />
                <input className="placeholder-white basis-auto" type='password' placeholder='Password' />
              </div>
              <button className=' cursor-pointer w-8 h-7'>
                <img src={Eye} alt="eye" className='object-fill'/>
              </button>
              </div>
            </div>
            <div>
          
            
          </div>
        </div>
        </div>
        <div className='justify-self-end w-full flex justify-center items-center'>
           <button className="flex justify-center gap-4  bg-amber-400 text-white w-85 p-3  rounded-4xl">
            Sign in 
            <img src={Arrow} alt="arrow" className='w-6 h-auto object-fill'/>
           </button>
        </div>
        
      </div>
    </div>
  )
}

export default Login