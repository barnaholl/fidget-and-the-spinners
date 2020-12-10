import React, { useState } from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import Container from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import Stats from "./Stats";
import CharacterEquipment from "./CharacterEquipment";
import KeyboardArrowLeftIcon from "@material-ui/icons/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@material-ui/icons/KeyboardArrowRight";

const useStyles = makeStyles((theme) => ({
  container: {
    backdropFilter: "brightness(0.6)",
  },
  table: {
    maxWidth: 650,
  },
}));

export default function CharacterWindow() {
  const classes = useStyles();

  return (
    <Container className={classes.container}>
      <CharacterEquipment />
      <Stats />
    </Container>
  );
}
