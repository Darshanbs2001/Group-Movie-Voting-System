import React from 'react'
import { Outlet } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
function Error(){
    return <div className="text-red-300">
        sorry you are not admin 

    </div>
}
const PrivateRoute = ({children}) => {
    const user_role="admin";
  if(user_role==='admin'){
    return <>
    {children}
    
    </>
  }
  else{
    return <Error/>;
  }
}

export default PrivateRoute;