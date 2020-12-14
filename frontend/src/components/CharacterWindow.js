import React from "react";
import Container from "@material-ui/core/Container";
import Stats from "./Stats";
import CharacterEquipment from "./CharacterEquipment";
import { useStyles } from "../StyleComponents";

export default function CharacterWindow() {
  const classes = useStyles();

  return (
    <Container maxWidth="sm" className={classes.container}>
      <CharacterEquipment />
      <Stats />
    </Container>
  );
}
