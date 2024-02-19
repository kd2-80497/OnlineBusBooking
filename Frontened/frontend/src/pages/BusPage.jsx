// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import { useState,useEffect } from 'react';
import { createError,createUrl } from "../services/utils";
import busBackgroundImage from '../assests/2.jpg';
import '../styles/Bus.css';
function BusPage() {


const [buses,setBuses]=useState([]);
const [bus,setBus] = useState({id: "",busNo : "",capacity: "", source: "",destination:"",travelDate: "",departureTime: "",arrivalTime: ""});

useEffect(() => {
    FetchRecords();
  }, []);


//   const FetchRecords = () => {
//     const url = createUrl('bus');

//     axios.get(url)
//       .then(response => {
//         // Handle successful response
//         console.log(response.data);  // or any other logic you want to perform with the response
//         setBuses(response.data);
//       })
//       .catch(error => {
//         // Handle error
//         console.error('Error fetching data:', error);
//       });
//     }
// const FetchRecords = () => {
//     const url = createUrl('bus');
  
//     axios.get(url)
//       .then(response => {
//         // Handle successful response
//         console.log(response.data);
//       })
//       .catch(error => {
//         // Handle error
//         console.error('Error fetching data:', error);
//         console.log('Response status:', error.response.status);
//         console.log('Response data:', error.response.data);
//       });
//   };
const FetchRecords = async () => {
    try {
      const response = await axios.get('http://localhost:8080/bus', {
        params: {
          source: 'your_source_value', // Provide the actual source value here
        },
      });
      console.log("responsen "+response.data);
      setBuses(response.data);
    } catch (error) {
      console.error('Error fetching buses:', error);
    }
  };

const RemoveRecord=(id)=>{
    console.log(id);
    const deleteUrl = createUrl(`bus/${id}`);
   // var deleteUrl=url + "/" + id;
    axios.delete(deleteUrl).then((result)=>{
    //   if(result.data.affectedRows !== undefined && result.data.affectedRows > 0){

        FetchRecords();
    //   }
    })
}

const OnTextChanged=(args)=>{
var copyofBus = {...bus};
//target batayega kaha par change hua
copyofBus[args.target.name] = args.target.value;
setBus(copyofBus);
}

const AddRecord=()=>{
    console.log("bus to be added");
    console.log(bus);
    const postUrl = createUrl(`bus`);

axios.post(postUrl,bus).then((response)=>{
    //same as DELETE only we will use here Reset function
    // if(response.data.affectedRows !== undefined && response.data.affectedRows > 0){
console.log(response.data);
        FetchRecords();
        Reset();
    //   }
})
}
const EditRecord=(No)=>{
    console.log("no "+No)
    console.log("buses.length "+No)
    for(var i=0; i<buses.length;i++){
        if(buses[i].id === No){

         var busToEdit = {...buses[i]};
         console.log("busToEdit "+busToEdit)
         setBus(busToEdit);
         break;
        }
    }
}
const UpdateRecord=()=>{
    console.log("UpdateRecord bus ");
console.log(bus);
    const updateUrl = createUrl(`bus/${bus.id}`);
   // var updateUrl=url + "/" + bus.id;
    axios.put(updateUrl,bus).then((response)=>{
        
        // if(response.data.affectedRows !== undefined && response.data.affectedRows > 0){
             console.log(response);
            FetchRecords();
            Reset();
        //   }
    })

}
const Reset=()=>{
setBus({id: "",busNo : "",capacity: "", source: "",destination:"",travelDate: "",departureTime: "",arrivalTime: ""});
}

// 1.just like componentDidMount
//2.data result mai aayega array ke format mai server se data ley rahe hai set kia Emps ko
//3.emps set hoga render first tym call hoga and here we are getting data using AXIOS
    //  useEffect(()=>{FetchRecords()},[])
    const formatLocalDate = (localDate) => {
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return new Date(localDate).toLocaleDateString('en-US', options);
      };
    
      const formatLocalDateTime = (localDateTime) => {
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric' };
        return new Date(localDateTime).toLocaleDateString('en-US', options);
      };


    return (
        <div className="bus1">
  <div style={{ textAlign: 'left' }}>
        
        <div className='table-responsive'>
            <table className='table table-bordered'>
                <tbody>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>id</td>
                        <td><input type='number' name='id'
                                 value={bus.id}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                 
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>busNo</td>
                        <td><input type='text' name='busNo'
                                 value={bus.busNo}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>Capacity</td>
                        <td><input type='number' name='capacity'
                                 value={bus.capacity}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>source</td>
                        <td><input type='text' name='source'
                                 value={bus.source}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>destination</td>
                        <td><input type='text' name='destination'
                                 value={bus.destination}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>travelDate</td>
                        <td><input type='text' name='travelDate'
                                 value={bus.travelDate}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>departureTime</td>
                        <td><input type='text' name='departureTime'
                                 value={bus.departureTime}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    <tr>
                        {/* TEXT KA CHANGE HOGA TO ONCHANGE CALL HOGA */}
                        <td>arrivalTime</td>
                        <td><input type='text' name='arrivalTime'
                                 value={bus.arrivalTime}
                                 onChange={OnTextChanged}/>
                                 </td>
                    </tr>
                    {/* travelDate: "",departureTime: "",arrivalTime: "" */}
                    <tr>
                        <td></td>
                        <td>
                        <button className='btn btn-primary' onClick={AddRecord}>Add Record</button>
                        <button className='btn btn-success' onClick={UpdateRecord}>Update Record</button>
                        <button className='btn btn-info' onClick={Reset}>Reset Record</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <hr></hr>
        <hr></hr>
        <div className='table-responsive'>
            <table className='table table-bordered'>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>busNo</th>
                        <th>capacity</th>
                        <th>source</th>
                        <th>destination</th>
                        <th>travelDate</th>
                        <th>departureTime</th>
                        <th>arrivalTime</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        // har tym emp mai data aayega
                        buses.map((bus)=>{
                            // give unique key if we dont want warning
                           return (<tr key={bus.id}>
                            <td>{bus.id}</td>
                            <td>{bus.busNo}</td>
                            <td>{bus.capacity}</td>
                            <td>{bus.source}</td>
                            <td>{bus.destination}</td>
                            <td>{formatLocalDate(bus.travelDate)}</td>
                            <td>{formatLocalDateTime(bus.departureTime)}</td>
                            <td> {formatLocalDateTime(bus.arrivalTime)}</td>
                            
                            <td><button className='btn btn-warning' onClick={()=>{EditRecord(bus.id)}}>Edit</button></td>
                            <td><button className='btn btn-danger' onClick={()=>{RemoveRecord(bus.id)}}>
                                Delete</button></td>
                           </tr>)
                        })
                    }
                </tbody>
            </table>

        </div>

    </div> 
    </div>
    );
   
}

export default BusPage;