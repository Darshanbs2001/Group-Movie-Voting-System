import { instance as axios, pAxios } from "./Axios";

export const signupUser=async(userDetails)=>{
        let user={
            'name':userDetails.Name,
            'email':userDetails.Email,
            'password':userDetails.ConfirmPassword
        }
        return await axios.post("/auth/register",user);
    }
export const userLogin =async(loginData)=>{
    return await axios.post("/auth/login",loginData);
}
export const userInfo=async()=>{
    if(localStorage.getItem('token')!==null){
        const {data}=await pAxios.get("auth/getinfo");
        return data;
    }
}