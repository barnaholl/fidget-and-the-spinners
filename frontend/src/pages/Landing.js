import React from 'react'
import { Link } from "react-router-dom";
import Button from "@material-ui/core/Button";
import Copyright from "../components/Copyright";
import '../../src/App.css'


function Landing() {
    return (
        <div align="center">
          <h3>Welcome Traveler!</h3>
          <p>Beyond this point you will find adventures, success and failures. </p>
          <p>At some point you might wish you had never started it.</p> 
          <p>But you know deep down that in the end, it's all worth it.</p>
          <Link to={"/login"}>
            <Button variant="contained" color="primary" id="login-button">
              Login
            </Button>
          </Link>
          <Link to={"/register"}>
            <Button variant="contained" color="primary" id="register-button">
              Register
            </Button>
          </Link>
          <Copyright />
        </div>
    )
}

export default Landing
