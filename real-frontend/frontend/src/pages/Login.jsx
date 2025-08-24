import React, { useState } from 'react'
import Logo from '../assets/icon_logo.svg'
import Email from '../assets/icon_email.svg';
import Eye from '../assets/icon_eye.svg';
import Password from '../assets/Frame.svg';
import Photo from '../assets/login photo.png';
import Arrow from '../assets/icon_arrow.svg';
import { handleLogin } from '../services/UserService';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faEyeSlash,faEye} from '@fortawesome/free-solid-svg-icons'
import { useNavigate } from 'react-router';
const Login = () => {
  const [loginDetail, setLoginDetail] = useState({ email: "", password: "" });
  const [show,setShow]=useState(false);
  const [error, setError] = useState({ email: "", password: "" });
  const navigate=useNavigate();
  function update(key, value) {
    
    setLoginDetail((prev) => ({
      ...prev,
      [key]: value
    }));
    
    
   }
  const handleSubmit = async () => {
    try {
      
      let data = await handleLogin(loginDetail);
      console.log(data.jwt);
      sessionStorage.setItem('jwt',data?.jwt);
        setError(err=>{
        err.email="";
        err.password="";
      })

      //navigate('/')
      
      
    }
    catch (err) {
      setError(err.response?.data);
      console.log(err.status);
      console.log(err);
    }
  }
  return (
    <div className='h-screen md:flex md:items-center md:justify-center md:h-fit md:w-[96%]   mx-5  md:m-4 '>
      <div className=' md:p-7 md:gap-7 h-full md:w-fit md:h-[600px] md:bg-primary flex md:justify-between rounded-4xl'>
        <div className='hidden md:block  w-full h-full'>
          <img className="object-fill w-full h-[550px]" src={Photo} alt="" />
        </div>
        <div className=' bg-white rounded-4xl md:p-4 md:w-[70%] w-full pt-18 flex flex-col items-center  md:h-full h-full'>
          <div className="flex  justify-around  gap-6">
            <img className="h-auto w-17" src={Logo} />
            <span className='font-inter font-bold text-2xl'>Group<br /> Cinema</span>
          </div>
          <div className='mt-4 mb-4  flex flex-col gap-10 items-center justify-center  w-full '><p className='font-bold font-inter text-2xl text-center w-[150px] md:w-fit'>Welcome Back</p>
            <p className='md:max-w-fit max-w-[150px] text-center font-light text-gray-500'>please login to your account</p>
          </div>

          <div className='px-1 w-full flex flex-col gap-7 '>
            <div>
              <div className=' bg-primary w-full  rounded-4xl flex gap-3 px-3 py-3 justify-center'>
                <img className="w-fit " src={Email} alt="" />
                <input className="placeholder-white w-full outline-none text-white" type="email" placeholder='Email' onChange={(e) => update("email", e.target.value)} />
                {error?.email && <p className='bg-white rounded-full px-1 py-1 text-red-500 mr-2 text-xl font-bold'>!</p>}
              </div>

              {error?.email && <p className='text-red-600 ml-3'>{error.email}</p>}
            </div>
            <div >
              <div className=' bg-primary w-full rounded-4xl flex gap-2 px-4 py-3 '>
                <img className="w-[24px]" src={Password} alt="" />
                <input className="placeholder-white w-full outline-none text-white" type={show?'text':'password'} placeholder='Password' onChange={(e) => update("password", e.target.value)} />
                <button onClick={()=>setShow(!show)} className='cursor-pointer hover:bg-white hover:rounded-full'>
                 { show?
                  <FontAwesomeIcon color='gold' size='xl' icon={faEye}/>
                  :
                <FontAwesomeIcon color='gold' size='xl' icon={faEyeSlash} /> 
                }
                  </button>
                {error?.password && <p className='bg-white rounded-full px-1 py-1 text-red-500 mr-2 text-xl font-bold'>!</p>}

              </div>
              {error?.password && <p className='text-red-600 ml-3'>{error.password}</p>}

            </div>
            </div>

            <div className='h-full w-full flex  justify-center items-end '>
              <button onClick={handleSubmit} className=" cursor-pointer opacity-100 hover:opacity-80 m-2 p-3 w-full rounded-4xl bg-amber-500 flex items-center justify-center gap-5">
                <p className='text-white font-inter font-bold'>Sign In</p>
                <img className="object-contain w-7 " src={Arrow} alt="" />
              </button>
            </div>
          </div>
        </div>
      </div>
      )
}

      export default Login;