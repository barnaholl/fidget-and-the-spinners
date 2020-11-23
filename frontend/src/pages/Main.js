import React from "react";
import Button from "@material-ui/core/Button";
import { Link } from "react-router-dom";

export default function Main() {
  return (
    <div>
      <h1>Welcome traveler</h1>
      <Link to={"/login"}>
        <Button variant="contained" color="primary">
          Login
        </Button>
      </Link>
      <Link to={"/register"}>
        <Button variant="contained" color="primary">
          Register
        </Button>
      </Link>
    </div>
  );
}
