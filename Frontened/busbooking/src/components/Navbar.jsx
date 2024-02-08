import { Link } from "react-router-dom";
import "../styles/NavbarStyles.css"
import { MenuItems } from "./MenuItems";
import { useState } from "react";
 import { UserContext } from "../App";
import { useContext } from 'react';

function Navbar() {
    // const { state, dispatch } = useContext(UserContext)
     const [clicked, setClicked] = useState(false);

    function handleClick() {
        setClicked(!clicked);
    }

    const RenderMenu = () => {
        if (false) {
            return (
                <>
                    <label >Welcome {sessionStorage.getItem("fname")}!</label>
                    <Link to="/logout"><button > Logout</button></Link>
                </>
            )
        }
        else {
            return (
                <>
                    <Link to="/SignUp">
                        <button>Register</button>
                    </Link>
                    <Link to="/Signin">
                        <button>SignIn</button>
                    </Link>
                </>
            )
        }
    }

    return (
        <nav className="NavbarItems">
            <h1 className="navbar-logo">YATRI</h1>
            <div className="menu-icons" onClick={handleClick}>
                <i className={clicked ? 'fas fa-times' : 'fas fa-bars'}></i>
            </div>
            <ul className={clicked ? 'navbar-menu active' : 'navbar-menu'}>
                {MenuItems.map((item, index) => {
                    return (
                        <li key={index}>
                            <Link className={item.cName} to={item.url}>
                                <i className={item.icon}></i>
                                {item.title}
                            </Link>
                        </li>
                    );
                })}

                {/* {isLoggedIn ? (
                    <Link to="/logout"><button onClick={onLogout}>Logout</button></Link>
                ) : (
                    <>
                        <Link to="/register">
                            <button>Register</button>
                        </Link>
                        <Link to="/signin">
                            <button>SignIn</button>
                        </Link>
                    </>
                )} */}
                <RenderMenu></RenderMenu>
            </ul>
        </nav>
    );
}

export default Navbar;

// import { Component , useState, useContext} from "react";
// import { Link, useNavigate } from "react-router-dom";
// import "../styles/NavbarStyles.css"
// import { MenuItems } from "./MenuItems";
// import SignIn from "../routes/SignIn";
// import { Navigate } from "react-router-dom";
// import { UserContext } from "../App";


// class Navbar extends Component {

//     const {state, dispatch}=useContext(UserContext);
 
//     state = { clicked: false }
//     handleClick = () => {
//         this.setState({clicked : !this.state.clicked})
//     }
   
 
//     render() {
//         return (
//             <nav className="NavbarItems">
//                 <h1 className="navbar-logo">Udaan Airways</h1>
//                 <div className="menu-icons" onClick={this.handleClick}>
//                     <i className={this.state.clicked ? "fas fa-times" : "fas fa-bars"}></i>
//                 </div>
//                 <ul className={this.state.clicked ? "navbar-menu active" : "navbar-menu"}>
//                     {MenuItems.map((item, index) => {
//                         return (
//                             <li key={index}>
//                                 <Link className={item
//                                     .cName} to={item.url}><i className={item.icon}></i>{item.title}</Link>
//                             </li>
//                         )
//                     })}
//                    <Link to="/register" ><button>Register</button></Link>
//                    <Link to="/login" ><button >SignIn</button></Link>
//                 </ul>
//             </nav>
//         )
//     }
// }


// export default Navbar;