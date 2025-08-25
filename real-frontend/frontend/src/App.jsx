import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from './pages/Login'
import { Route, Routes } from 'react-router'

function App() {
  const [count, setCount] = useState(0)

  return (
    <Routes>
      <Route path="login" element={<Login></Login>}/>
      <Route path="*" element={<p>sorry cannot seem to find the route </p>}/>
    </Routes>
  )
}

export default App
