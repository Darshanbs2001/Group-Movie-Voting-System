import { myAxios as axios } from "../utility/Axios";

export async function handleLogin(loginDetail){
       
        console.log(loginDetail);
    let data=await axios.post('/auth/login',loginDetail);
    console.log(data.data);
    return data.data;

}