

import { toast } from 'react-toastify'
import { useEffect, useState } from "react";
import { getAllSource } from "../services/city";

const CitySelector = () => {
    const[destination,setDestination]=useState([]);

    // debugger;
    // const loadAllSource= () =>{
    //             const result =  getAllSource()
    //             if(result.status === 'success'){
    //                 console.log(result)
    //                 setSource(result.data)
    //             }else{
    //                 toast.error(result.error);
    //             }
    //         }

  //  useEffect(()=>{
  //    const result =  getAllSource()
  //   if(result.status === 200){
  //       console.log(result)
  //       setSource(result.data)
  //   }else{
  //       toast.error(result.error);
  //   }
  // },[])
debugger;

  useEffect(() => {
    const fetchData = async () => {
        try {
            const result = await getAllSource();
            if (result.status === 200) {
                console.log(result);
                setDestination(result.data);
            } else {
                toast.error(result.error);
            }
        } catch (error) {
            console.error("Error fetching data:", error);
            toast.error("Error fetching data");
        }
    };

    fetchData();
}, []);

return(

    <div>
   <label htmlFor="citySelect">Select a Destination :</label>
      <select id="citySelect">
        <option value="">Select a city</option>
        {destination.map(bus => (
          <option key={bus._id} value={bus.destination}>{bus.destination}</option>
        ))}
      </select>

    </div>




)
    
}


export  default CitySelector;