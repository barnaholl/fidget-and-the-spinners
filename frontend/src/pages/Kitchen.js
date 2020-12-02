import React from "react";
import Navbar from "../layout/Navbar";
import Container from "@material-ui/core/Container";
import QuestModal from "../components/QuestModal";

export default function Kitchen() {
  return (
    <Container component="main" maxWidth="xs">
      <Navbar />
      <QuestModal />
    </Container>
  );
}
