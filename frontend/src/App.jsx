import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Button } from './components/ui/button'
import Login from './pages/components/Login'
import { Route, Routes } from 'react-router-dom'
import PrivateRoute from './pages/components/PrivateRoute'
import SignUp from './pages/SignUp'
function Home(){
  return <div className="hello">
    hello from the home
  </div>
}
function App() {
  const [count, setCount] = useState(0)

  return (
    <Routes>
      <Route path='/' element=
      {
        <PrivateRoute >
          <Home/>
          </PrivateRoute>
        
      }/>
      <Route path='/login' element={<Login/>}/>
      <Route path="/signup" element={<SignUp/>}/>
    </Routes>
  )
}

export default App
