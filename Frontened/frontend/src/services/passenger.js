import axios from "axios";
import { createError,createUrl } from "./utils";

export  async function passenger(firstName,lastName,gender,age,seatNumber){

try{
const url = createUrl('/passenger')
const body = {
    firstName,
    lastName,
    gender,
    age,
   seatNumber
    
    
}



const response = await axios.post(url,body)
return response.data
}catch(ex){
    return createError(ex)
}

}