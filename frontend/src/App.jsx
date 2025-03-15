import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Button } from './components/ui/button'
import Login from './pages/components/Login'
import { Route, Routes } from 'react-router-dom'
import PrivateRoute from './pages/components/PrivateRoute'
import SignUp from './pages/SignUp'
import Sidebar from './pages/components/Sidebar'
import Mypage from './pages/Mypage'
function Home(){
  return <div >
    <Sidebar/>
  </div>
}
function App() {

  return (
    <Routes>
      <Route path='/' element=
      {
        <PrivateRoute >
          <Home/>
          </PrivateRoute>
        
      }/>
      <Route path="/test" element={<Mypage/>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path="/signup" element={<SignUp/>}/>
    </Routes>
  )
}

export default App
