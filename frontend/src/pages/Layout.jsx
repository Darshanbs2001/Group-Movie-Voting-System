import { useState } from "react";
import Sidebar from "./components/Sidebar"

const Layout = ({children}) => {
    const[isOpen,setOpen]=useState(true);

  return (
    <div className="flex">
        <Sidebar isOpen={isOpen} setOpen={setOpen}/>
       
        {children}
    </div>
  )
}

export default Layout