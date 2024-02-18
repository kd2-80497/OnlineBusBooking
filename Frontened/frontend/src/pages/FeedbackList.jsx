import React, { useState, useEffect } from "react";
import axios from "axios";
import { createError,createUrl } from "../services/utils";
import 'bootstrap/dist/css/bootstrap.min.css'; 
import '../assests/2.jpg'
import '../styles/Feedback.css';
function FeedbackList() {
    const [feedbacks,setFeedbacks]=useState([]);
    const [feedback,setFeedback] = useState({passengerid : "",busid: "", feedBack: ""});

    useEffect(() => {
        fetchData();
      }, []);

   
      const fetchData = () => {
        const url = createUrl('feedback');

        axios.get(url)
          .then(response => {
            // Handle successful response
            console.log(response.data);  // or any other logic you want to perform with the response
            setFeedbacks(response.data);
          })
          .catch(error => {
            // Handle error
            console.error('Error fetching data:', error);
          });
        
      
      
      };

    
  return (
    <div className="feed">
    <div >
    <div >
      <br></br>
      <br></br>
      <br></br>
      <br></br>

      <h1 className="text-center">FeedBack Data</h1>
      <table className="table table-bordered table-light"  >
        <thead className="thead-dark">
            <tr>
            <th>ID</th>
            <th>PassengerId</th>
            <th>BusId</th>
            <th>FeedBack</th>
          </tr>
        </thead>
        <tbody>
       
        {feedbacks.map(user => (
    <tr key={feedback.id}>
      <td>{feedback.id}</td>
      <td>{feedback.passengerid}</td>
      <td>{feedback.busid}</td>
      <td>{feedback.feedBack}</td>
    
     
    </tr>
  ))}
          </tbody>
      </table>
      </div>
      </div>
      </div>
  );
};

export default FeedbackList;

