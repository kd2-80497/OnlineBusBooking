import { useState } from "react"
import Navbar from "../components/Navbar";
import { Link, useNavigate } from 'react-router-dom'
import React from "react";
import axios from "axios";
import { toast } from 'react-toastify'
const  SelectSeat=()=>{

const[noOfSeatsToBook,setNoOfSeats]=useState(1);

const[busTypeTOBook,setBusType] =useState("");
const navigate = useNavigate();

const selectedBus = JSON.parse(sessionStorage.getItem("selectedBus"));
console.log(selectedBus);

const BASE_URL = "http://localhost:8080";
const handleBook=async(event)=>{

    const fetchedUserId = sessionStorage.getItem("userid");
    const fetchedBusid = sessionStorage.getItem("busid");

    const params = {

        busid:fetchedBusid,
        userid:fetchedUserId,
        noOfSeats:noOfSeatsToBook,
        busType:busTypeTOBook,
    };
    event.preventDefault();

    try{
        const response = await axios.post(BASE_URL,{params});
        const booking = response.data;
        sessionStorage.setItem("bookingid",booking.id);
        sessionStorage.setItem("nooFSeats",booking.noOfSeats);
        sessionStorage.setItem("busType",booking.busType);
        navigate("/passenger");

console.log(booking.id);
console.log(booking.noOfSeats);



        
    }catch (error) {
        toast.error(`${error.response.data}`);
      }
}
return (
    <>
    
   
    <div className="selectSeats">

<form onSubmit={handleBook}>
<h1>Booking Details</h1>

<table>

<tbody>
                <tr>
                  <th>Source : </th>
                  <td>{selectedBus.source}</td>
                </tr>

                <tr>
                  <th>Destination : </th>
                  <td>{selectedBus.destination}</td>
                </tr>
                <tr>
                  <th>Travel Date : </th>
                  <td>{selectedBus.travelDate}</td>
                </tr>
                <tr>
                  <th>Departure Time : </th>
                  <td>{selectedBus.departureTime}</td>
                </tr>
                <tr>
                  <th>Arrival Time : </th>
                  <td>{selectedBus.arrivalTime}</td>
                </tr>

                <tr>
                  <th>Business Fare : </th>
                  <td>{selectedBus.fare}</td>
                </tr>

                <tr>
                  <th>Available Seats : </th>
                  <td>{selectedBus.availableSeats}</td>
                </tr>

                <tr>
                  <th>Select Number of Passengers : </th>
                  <td>
                    <input
                      type="number"
                      min="1"
                      max="10"
                      value={noOfSeatsToBook}
                      required
                      onChange={(event) => setNoOfSeats(event.target.value)}
                    />
                  </td>
                </tr>

                <tr>
                  <th>Select AC/NON-AC : </th>
                  <td>
                    <select
                      required
                      value={busTypeTOBook}
                      onChange={(event) => setBusType(event.target.value)}
                    >
                      <option value="">Select </option>
                      <option value="AC">AC</option>
                      <option value="NON_AC">NON-AC</option>
                     
                    </select>
                  </td>
                </tr>
</tbody>




</table>

<input type="submit" value="Book Now"></input>

</form>


    </div>
    
    
    
    
    
    
    </>
);

};
export default SelectSeat;