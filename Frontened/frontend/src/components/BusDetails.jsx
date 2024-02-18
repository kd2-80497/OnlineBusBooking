// BusDetails.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom'



function BusDetails({ source, destination }) {
  const [buses, setBuses] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchBusDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/bus?source=${source}&destination=${destination}`);
      
      // const busesArray = Object.values(response.data);
       setBuses(response.data);
      // setBuses(busesArray);
      } catch (error) {
        console.error('Error fetching data:', error);
        setBuses([])
      } finally {
        setLoading(false);
      }
    };

    fetchBusDetails();
  }, [source, destination]);

  if (loading) {
    return <p>Loading...</p>;

  }
  const BookBus =()=>{
    navigate('/booking')
  }

  return (
   
       
        <div className="table-responsive">
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>Source</th>
              <th>Destination</th>
              <th>Travel Date</th>
              <th>Departure Time</th>
              <th>Arrival Time</th>
              <th>Fare</th>
              <th>Available Seats</th>
              <th>Book</th>
            </tr>
          </thead>
          <tbody>
            {buses.map((bus) => {
              return (
                <tr key={bus.id}>
                     <td>{bus.source}</td>
                  <td>{bus.destination}</td>
                  <td>{bus.travelDate}</td>
                  <td>{bus.departureTime}</td>
                  <td>{bus.arrivalTime}</td>
                  <td>{bus.fare}</td>
                  <td>{bus.availableSeats}</td>

                  <td>
                    <button
                      className="btn btn-primary"
                      onClick={() => {
                         BookBus(buses.id);
                      }}
                    >
                      Book
                    </button>
                  </td>
                  
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>


  );
}

export default BusDetails;
