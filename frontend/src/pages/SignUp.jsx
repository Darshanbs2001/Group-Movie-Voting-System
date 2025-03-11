import { useMutation } from '@tanstack/react-query';
import  { useState } from 'react'
import {MdOutlineCancel} from "react-icons/md";
import Input from './components/Input';
import { signupUser } from '@/services/UserServices';
import { toast, ToastContainer } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
    const navigate=useNavigate();
    const [Error, setError] = useState(null)
    const mutation=useMutation(
        {
            mutationFn:signupUser,
            onSuccess:(data)=>{
              console.log(data);
              toast.success("User Sign Up Successfull")
              setError({});
              setTimeout(()=>
              navigate('/login')
              ,2000)
              
            },
            onError:(err)=>{
                let data=err?.response?.data
                console.log(data);
                setError(
                    ()=>{
                        let temp={...data};
                        return temp;
                    }
                )
                toast.error("Sorry something went wrong");
                console.log(err);
                console.log(Error);
            }
        }
    )
    const[userDetails,setUserDetails]=useState(
        {
            'Name':"",
            "Phone":"",

        }
    )
    
  return (
    <div className="md:w-full md:h-screen md:flex md:justify-center md:items-center">
    <div className="md:rounded-2xl bg-purple-500 text-black w-full md:w-[900px] flex flex-col md:align-middle md:justify-center">
        <span className="self-end text-2xl p-1 cursor-pointer hover:bg-white hover:rounded-s-full hover:delay-250 transition-colors"><MdOutlineCancel/> </span>
        <div className="flex flex-col m-8">
            <div className="flex justify-center w-full">
        <h1 className=" w-3/4 font-bold w-full align-middle text-center leading-8  text-wrap tracking-tighter text-3xl ">Let's get to know you better</h1>
        </div>
        <Input error={Error?.name} type='text' placeholder='Name' contentName={'Name'} content={userDetails.Name} change={setUserDetails}/>
        <Input error={Error?.email} type='email' placeholder='Email'contentName={'Email'} content={userDetails.Email} change={setUserDetails}/>
        <Input error={Error?.password} type='password' placeholder='Enter a password'contentName={'Password'} content={userDetails.Password} change={setUserDetails}/>
        <Input error={Error?.password} type='password' placeholder='Enter a confirm password'contentName={'ConfirmPassword'} content={userDetails.ConfirmPassword} change={setUserDetails}/>
        <button  onClick={()=>mutation.mutate(userDetails)} className="opacity-80 bg-black text-white m-2 py-3 rounded-lg">Sign Up</button>
        </div>
        <ToastContainer />
    </div>
    </div>
    

  )
}

export default SignUp