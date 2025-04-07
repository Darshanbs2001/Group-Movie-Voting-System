
import { userInfo } from '@/services/UserServices';
import React from 'react'
import { Outlet } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
function Error(){
    return <div className="text-red-300">
        sorry you are not admin 

    </div>
}
const PrivateRoute = ({children}) => {
    const isAdmin=async()=>{
      const {admin}=await userInfo();
      console.log(admin)
      return admin;
    }
  if(isAdmin()===true){
    
    return(
    <>
    {children}
    
    </>
    )
  }
  else{
    return <Error/>;
  }
}

export default PrivateRoute;