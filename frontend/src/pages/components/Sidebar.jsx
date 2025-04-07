import { Button } from '@/components/ui/button'
import React, { useState } from 'react'
import { Link } from 'react-router-dom'

const Sidebar = ({setOpen,isOpen}) => {
  return (
    <div className={`${isOpen?"w-56":"w-12"} md:w-fit`}>
    <button className={`${isOpen?"hidden":"block"} md:hidden`} onClick={()=>setOpen(true)}>Open</button>
   <div className={` relative rounded-tr-xl h-screen  flex flex-col items-center justify-between p-2 md:w-56 bg-purple-700 md:flex md:translate-x-0 text-white ${isOpen?" w-56 translate-x-0 transition-transform delay-400":"-translate-x-full "}`}> 
     <div className="w-full">
     {/*logo*/}
     <div className="w-full">
     <h1 className=" text-center h-24 px-4 py-1 w-full  rounded-xl cursor-pointer transition-colors delay-100 self-start justify-self-center"> App</h1>
     <button className=" absolute md:hidden top-1 right-1"onClick={()=>{setOpen(false)}}>close</button>
     </div>
     {/*routes*/}

     
     <div className=" h-56 flex-col w-full ">
      <h2 className="font-extrabold">User</h2>
        <ul className="flex flex-col gap-1 w-full px-1">
          <Link className="font-bold hover:bg-purple-500 rounded-xl px-4 py-2 transition-colors delay-250 " to={"/"}>Home</Link>
          <Link className="font-bold hover:bg-purple-500 rounded-xl px-4 py-2 transition-colors delay-250" to={"/test"}>test</Link>
        </ul>
     </div>
     <div className=" h-56 flex-col w-full ">
      <h2 className="font-extrabold">Admin</h2>
        <ul className="flex flex-col gap-1 w-full px-1">
          <Link className="font-bold hover:bg-purple-500 rounded-xl px-4 py-2 transition-colors delay-250 " to={"/"}>Home</Link>
          <Link className="font-bold hover:bg-purple-500 rounded-xl px-4 py-2 transition-colors delay-250" to={"/test"}>test</Link>
        </ul>
     </div>
     </div>
     {/*sign out and sign in options*/}
     <div className="w-full px-4  self-start hover:bg-purple-500 rounded-xl py-2 cursor-pointer">
      {/* write the logout and login option once done with login*/}
       sign in
     </div>
    </div>
    </div>
  )
}

export default Sidebar