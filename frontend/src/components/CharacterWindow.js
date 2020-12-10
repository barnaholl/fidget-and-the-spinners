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

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    "& > *": {
      margin: theme.spacing(1),
    },
  },
  table: {
    maxWidth: 650,
  },
}));

export default function CharacterWindow() {
  const classes = useStyles();

  return (
    <Container className={classes.root}>
      <Stats />
    </Container>
  );
}
