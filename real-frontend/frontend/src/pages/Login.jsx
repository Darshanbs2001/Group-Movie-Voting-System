import React from 'react'
import Logo from '../assets/icon_logo.svg'
const Login = () => {
  return (
    <div className='h-screen w-screen  '>
        <div className="bg-white mt-7 min-h-full flex flex-col w-full  items-center">
             <div className='flex py-3 gap-3 w-fit justify-around'>
                <img className='h-[60px] w-[60px]'src={Logo} alt="" />
                <h1 className='self-center font-san font-bold text-2xl'>Group Cinema</h1>
            </div>
             <div></div>
             <div></div>
             <div></div>
             <div></div>
             <div></div>
        </div>
    </div>
  )
}

export default Login