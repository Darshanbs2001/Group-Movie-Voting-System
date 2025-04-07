import axios from "axios";



export const instance=axios.create({
    baseURL:"http://localhost:8080/",
    
});
export const pAxios=axios.create({
    baseURL:"http://localhost:8080/",
    headers:{
        "Authorization":"Bearer "+localStorage.getItem('token')
        
    }
})