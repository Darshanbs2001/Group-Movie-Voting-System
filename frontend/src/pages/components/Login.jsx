import { Button } from '@/components/ui/button'
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card'
import { Input } from '@/components/ui/input'
import { Label } from '@/components/ui/label'
import { userLogin } from '@/services/UserServices'
import { useState } from 'react'
import { AiFillEye, AiFillEyeInvisible } from 'react-icons/ai';
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
const Login = () => {
  const [isShow, setShow] = useState(true);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isError, setIsError] = useState(false);
  const [error, setError] = useState("");
const navigate=useNavigate();
  const handleLogin = async () => {
    if (email !== "" || password !== "") {

      setIsError(true);
      setError("Please enter the email and password");
      console.log("email", email);
      console.log("password", password);
      
      const response=await userLogin({'email':email,'password':password});
      const jwt=response.data.jwt;
      localStorage.setItem('token',jwt);
        toast.success('user signed in');
        setTimeout(()=>navigate('/'),3000);
           
      console.log(jwt);
    } else {
      setIsError(false);
      setError("");
      // call the api here
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-purple-500 to-purple-700">
      <Card className="w-96 p-8 bg-white/90 backdrop-blur-lg shadow-xl rounded-2xl border border-purple-200">
        <CardHeader className="flex flex-col items-center space-y-4">
          <CardTitle className="text-4xl font-bold text-black animate-fade-in">Login</CardTitle>
          <CardDescription className="text-center text-gray-600 animate-fade-in">
            Please enter the email and password

          </CardDescription>
        </CardHeader>
        <CardContent className="flex flex-col space-y-6 animate-fade-in">
          <Input
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}

            placeholder="Enter your email"
            className="p-4 placeholder:text-gray-400 border border-gray-200 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent transition-all duration-300"
          />
          <div className="relative">
            <Input
              id="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            
              
              type={`${isShow ? "password" : "text"}`}
              className="p-4 outline-none border-none placeholder:text-gray-400 border border-gray-200 rounded-lg focus:ring-2 focus:ring-purple-500 focus:border-transparent transition-all duration-300"
            />
            <div className="absolute right-4 top-1/2 -translate-y-1/2 cursor-pointer" onClick={(e) => {
              e.preventDefault();
              setShow(!isShow);
            }}>
              {isShow ? (
                <AiFillEyeInvisible className="text-gray-500 hover:text-purple-600 transition-colors" />
              ) : (
                <AiFillEye className="text-gray-500 hover:text-purple-600 transition-colors" />
              )}
            </div>
          </div>
        
        <div className="flex items-center justify-between">
          <Button
            className="bg-red-600  rounded-lg hover:bg-red-700 text-white font-medium px-6 py-3  transition-all duration-300 transform hover:scale-105"
            onClick={(e) => {
              e.preventDefault();
              setEmail('');
              setPassword('');
            }}
          >
            Reset
          </Button>
          <Button
            className="bg-black text-white font-medium px-8 py-3 rounded-lg shadow-lg hover:shadow-xl transition-all duration-300 transform hover:scale-105 hover:bg-gray-800"
            onClick={handleLogin}
          >
            Sign in
          </Button>
        </div>
      </CardContent>
    </Card>
    </div >
  );
}

export default Login