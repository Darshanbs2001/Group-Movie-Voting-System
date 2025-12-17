import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from './pages/Login';
import  TestComponent from './components/TestComponent';
import { Route, Routes } from 'react-router'
import Home from './pages/Home';

function App() {
  const [count, setCount] = useState(0)

  return (
    <Routes>
      <Route path="" element={<Home/>}></Route>
      <Route path="login" element={<Login></Login>}/>
      <Route path="test" element={<TestComponent></TestComponent>}/>
      <Route path="*" element={<p>sorry cannot seem to find the route </p>}/>
    </Routes>
  )
}

export default App
