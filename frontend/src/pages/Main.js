import React from "react";
import Button from "@material-ui/core/Button";
import { Link } from "react-router-dom";
import Container from "@material-ui/core/Container";
import Copyright from "../components/Copyright";

export default function Main() {
  return (
    <Container component="main" maxWidth="xs">
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
      <Copyright />
    </Container>
  );
}
