import React, { useState, useEffect } from "react";
import axios from "axios";
import { createError,createUrl } from "../services/utils";
import 'bootstrap/dist/css/bootstrap.min.css'; 
import '../assests/2.jpg'
import '../styles/Feedback.css';
function UsersPage() {
    const [users,setUsers]=useState([]);
    const [user,setUser] = useState({id : "",firstName: "", lastName: "", email:"",phoneNumber:"",role:""});

    useEffect(() => {
        fetchData();
      }, []);

   
      const fetchData = () => {
        const url = createUrl('users');

        axios.get(url)
          .then(response => {
            // Handle successful response
            console.log(response.data);  // or any other logic you want to perform with the response
            setUsers(response.data);
          })
          .catch(error => {
            // Handle error
            console.error('Error fetching data:', error);
          });
        
      
        // axios
        //   .get(`${createUrl}/admin/users`)
        //   .then((response) => {
        //     console.log(response.data);
        //     setData(response.data);
        //   })
        //   .catch((error) => {});
      };

    //   const handleEdit = (propertyId) => {
    //     setIsEditing(propertyId);
    //   };
    
      const handleSave = (editedProperty) => {
        axios
          .put(`${createUrl}/users/edit`, editedProperty)
          .then(() => {
    
            fetchData();
          })
          .catch((error) => {});
      };
      const RemoveRecord=(id)=>{
        console.log(id);
      //const url=  "http://localhost:8080/users"
      const deleteUrl = createUrl(`users/${id}`);

        //var deleteUrl=url + "/" + id;
        axios.delete(deleteUrl).then((response)=>{
          if(response.data.affectedRows !== undefined && response.data.affectedRows > 0){
    
           fetchData();
          }
        })
    }
      const EditRecord=(id)=>{
        for(var i=0; i<users.length;i++){
            if(users[i].id === id){
             var userToEdit = {...users[i]};
             setUser(userToEdit);
             break;
            }
        }
    }
  return (
    <div className="user">
    <div >
    <div >
      <br></br>
      <br></br>
      <br></br>
      <br></br>

      <h1 className="text-center">Users Management</h1>
      <table className="table table-bordered table-light"  >
        <thead className="thead-dark">
            <tr>
            <th>ID</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Mobile Number</th>
            <th>Role</th>
            
          </tr>
        </thead>
        <tbody>
       
        {users.map(user => (
    <tr key={user.id}>
      <td>{user.id}</td>
      <td>{user.firstName}</td>
      <td>{user.lastName}</td>
      <td>{user.email}</td>
      <td>{user.phoneNumber}</td>
      <td>{user.role}</td>
      
      
    </tr>
  ))}
          </tbody>
      </table>
      </div>
      </div>
      </div>
  );
};

export default UsersPage;

