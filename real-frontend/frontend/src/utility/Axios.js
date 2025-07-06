import axios, { Axios } from "axios";

export const myAxios=axios.create({
    baseURL:"http://localhost:8080",
    headers:{
        'Content-Type':'application/json'
    }
})
