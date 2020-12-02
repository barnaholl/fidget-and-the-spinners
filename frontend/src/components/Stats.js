import React, { useState } from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles({
  table: {
    maxWidth: 650,
  },
});

function createData(name, value) {
  return { name, value };
}

const rows = [
  createData("Problem solving", 0),
  createData("Design", 0),
  createData("Algorithm", 0),
  createData("Testing", 0),
  createData("Clean code", 0),
];

const char1 = [
  {
    ProblemSolving: 0,
    Design: 0,
    Algorithm: 0,
    Testing: 0,
    CleanCode: 0,
  },
];

export default function Stats() {
  const [character, setcharacter] = useState(char1[0]);
  const classes = useStyles();

  console.log(character);

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableBody>
          {Object.entries(character).map((stat) => (
            <TableRow key={stat[0]}>
              {console.log(stat)}
              <TableCell component="th" scope="row" width="70%" align="left">
                {stat[0]}
              </TableCell>
              <TableCell align="left">{stat[1]}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
