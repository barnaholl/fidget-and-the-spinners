import React from 'react'
import { Link } from "react-router-dom";
import Button from "@material-ui/core/Button";


function Landing() {
    return (
        <div align="center">
            <h3>Welcome Traveler!</h3>
            <p>Beyond this point you will find adventures, success and failures. </p>
            <p>At some point you might wish you had never started it.</p> 
            <p>But you know deep down that in the end, it's all worth it.</p>
            <Link to={"/username/character-creation"}>
            <Button
              type="submit"
              variant="contained"
              color="primary"
            >
              Continue
            </Button>
          </Link>
        </div>
    )
}

export default Landing