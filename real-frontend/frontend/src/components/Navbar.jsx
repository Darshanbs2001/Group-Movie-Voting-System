import React from 'react'
import Profile from '../assets/profile.png'
import Icon from '../assets/icon_logo.svg'
import { faBars} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {  NavLink } from 'react-router-dom'
const Navbar = () => {
  return (
    <div className='bg-white shadow-lg   shadow-primary/55'>
        <div className="px-4  flex w-full  justify-between items-center  ">
            <img src={Icon} alt="" className='w-[70px] h-fit justify-self-start' />
            <div className='md:hidden cursor-pointer p-1 rounded-md hover:shadow'>
              <FontAwesomeIcon className='w-[90px] h-fit' fontSize={42} icon={faBars} />
            </div>
            <div className='hidden  md:block'>
                <ul className='font-inter cursor-pointer text-[24px] flex justify-between gap-6 '>
                    <NavLink  to={"/"} className={({isActive})=>isActive?"font-bold":"hover:bg-primary/20  px-2  rounded-2xl hover:text-primary/70 delay-130 ease-in-out"}>Movies</NavLink>
                   
                    <NavLink  to={"/groups"} className={({isActive})=>isActive?"font-bold":"hover:bg-primary/20  px-2 rounded-2xl hover:text-primary/70 delay-130 ease-in-out"}>Groups</NavLink>
                    <NavLink  to={"/tickets"} className={({isActive})=>isActive?"font-bold":"hover:bg-primary/20  px-2 rounded-2xl hover:text-primary/70 delay-130 ease-in-out"}>Tickets</NavLink>
                    
                </ul>

            </div>
            <div className='hidden md:block w-[90px] h-[90px] overflow-hidden hover:cursor-pointer p-2 hover:bg-primary/30 delay-60 ease-in-out rounded-[50%] hover:overflow-visible'>
                <img src={Profile} alt=""  className='h-full w-full object-cover rounded-[50%] hover:scale-105 ' />
            </div>
        </div>
    </div>
  )
}

export default Navbar