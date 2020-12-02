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
  const [character] = useState(char1[0]);
  const classes = useStyles();

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableBody>
          {Object.entries(character).map((stat) => (
            <TableRow key={stat[0]}>
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
