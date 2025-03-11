import { instance as axios } from "./Axios";

export const signupUser=async(userDetails)=>{
        let user={
            'name':userDetails.Name,
            'email':userDetails.Email,
            'password':userDetails.ConfirmPassword
        }
        return await axios.post("/auth/register",user);
    }