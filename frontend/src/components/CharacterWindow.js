import React from "react";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import Stats from "./Stats";
import CharacterEquipment from "./CharacterEquipment";

const useStyles = makeStyles((theme) => ({
  container: {
    backdropFilter: "brightness(0.6)",
    padding: "1rem",
  },
  table: {
    maxWidth: 650,
  },
}));

export default function CharacterWindow() {
  const classes = useStyles();

  return (
    <Container maxWidth='sm' className={classes.container}>
      <CharacterEquipment />
      <Stats />
    </Container>
  );
}
