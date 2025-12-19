
import './App.css'
import Login from './pages/Login';
import  TestComponent from './components/TestComponent';
import { Route, Routes } from 'react-router'
import Home from './pages/Home';

function App() {

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
