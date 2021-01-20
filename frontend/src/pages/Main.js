import React from "react";
import Container from "@material-ui/core/Container";
import Navbar from "../layout/Navbar";

export default function Main() {
  return (
    <>
      <Container component='main' maxWidth='xs'>
        <Navbar />
      </Container>
    </>
  );
}
