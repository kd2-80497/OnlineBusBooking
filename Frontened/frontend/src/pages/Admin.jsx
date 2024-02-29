import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
// import "../css/admin.css" 

function Admin() {
  const navigate = useNavigate();

  useEffect(() => {
    if (sessionStorage.getItem("isAdmin") !== "true") {
      navigate("/Admin");
    }
  }, []);

  return (
    <div className="adminimage">
      <br/>
    <div className="container-fluid mt-5"   >

      <div className="row"  style={{ marginLeft:'200px', marginRight:'200px'}}>
      <h1  >WELCOME ADMIN</h1>
        <div className="col-md-4"  style={{marginTop:'50px'}}>
          <div className="card mb-4" >
            <div className="card-body text-center"   style={{backgroundColor:'pink'}}>
              <h3 className="card-title">Users List</h3>
              <button
                type="button"
                className="btn btn-primary btn-lg"
                onClick={() => navigate("/UsersPage")}
              >
                Go to Users
              </button>
            </div>
          </div>
        </div>

      

        <div className="col-md-4" style={{marginTop:'50px'}}>
          <div className="card mb-4">
            <div className="card-body text-center"  style={{backgroundColor:'pink'}}>
              <h3 className="card-title">Feedback List</h3>
              <button
                type="button"
                className="btn btn-primary btn-lg"
                onClick={() => navigate("/FeedbackList")}
              >
                Go to Feedback 
              </button>
            </div>
          </div>
        </div>

      
        
        <div className="col-md-4" style={{marginTop:'50px'}}>
          <div className="card mb-4">
            <div className="card-body text-center"  style={{backgroundColor:'pink'}}>
              <h3 className="card-title">Bus List</h3>
              <button
                type="button"
                className="btn btn-primary btn-lg"
                onClick={() => navigate("/BusPage")}
              >
                Go to Buses
              </button>
            </div>
          </div>
        </div>
      </div>
      <br/><br/><br/><br/><br/><br/><br/><br/>
    </div></div>
  );
}

export default Admin;
