import React from 'react'
import Navbar from '../components/Navbar'

const Home = () => {
  return (
    <div  >
        <Navbar/>
        <div className='mx-8 my-4 grid grid-cols-2 md:grid-cols-6 gap-2'>
          <div>hello</div>
          <div>hello</div>
        </div>
    </div>
  )
}

export default Home