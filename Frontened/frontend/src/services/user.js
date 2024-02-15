import axios from "axios";
import { createError,createUrl } from "./utils";

export  async function signupUser(firstName,lastName,email,password,phoneNumber){

try{
const url = createUrl('user/signup')
const body = {
    firstName,
    lastName,
    email,
    password,
    phoneNumber,
    
}



const response = await axios.post(url,body)
return response.data
}catch(ex){
    return createError(ex)
}

}