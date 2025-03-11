import { Button } from '@/components/ui/button'
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card'
import { Input } from '@/components/ui/input'
import { Label } from '@/components/ui/label'
import  { useState } from 'react'

const Login = () => {
    const [isShow,setShow]=useState(true);
  return (<Card className="  min-h-full bg-blue-400 text-white shadow-lg">
    <CardHeader className="">
      <CardTitle>Login Form</CardTitle>
      <CardDescription className="text-inherit">Please enter the email and password</CardDescription>
    </CardHeader>
    <CardContent className="min-h-full">
    <form>
          <div className="grid w-full items-center gap-7">
            <div className="flex flex-col space-y-1.5 gap-2 ">
              <Label htmlFor="name" className="self-start pl-1">Email</Label>
              <Input id="name" placeholder="Enter the Email" className="p-5 placeholder:text-white"/>
            </div>
            <div className="flex flex-col space-y-1.5 gap-2">
              <Label htmlFor="password" className="self-start pl-1">Password</Label>
              <Input type={`${isShow?"password" : "password"}`} id="password" placeholder="Enter Password" className=" ring-white p-5 focus:ring-white focus:border-white focus:outline-none  placeholder:text-white"/>
            <Button className="w-1/3 bg-blue-600" onClick={(e)=>{e.preventDefault(); setShow(!isShow)
                console.log(isShow)
                return
            }
        }>Show</Button>
            </div>
            </div>
    </form>
    </CardContent>
    <CardFooter>
      <Button className="bg-blue-600">Sign in</Button>
    </CardFooter>
  </Card>
  
      
)
}

export default Login