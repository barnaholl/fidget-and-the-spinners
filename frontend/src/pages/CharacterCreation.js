import React from "react";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import Copyright from "../components/Copyright";
import Typography from "@material-ui/core/Typography";
import FormGroup from "@material-ui/core/FormGroup";
import FormLabel from "@material-ui/core/FormLabel";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import KeyboardArrowLeftIcon from "@material-ui/icons/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@material-ui/icons/KeyboardArrowRight";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import Stickman from "../images/stickman.png";
import { makeStyles } from "@material-ui/core/styles";
import "../App.css";

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

function CharacterCreation() {
  const classes = useStyles();

  return (
    <Container component="main" maxWidth="xs">
      <Typography variant="h3" component="h2">
        Username
      </Typography>
      <FormGroup className="align-center" style={{ textAlign: "center" }}>
        <FormLabel component="legend">Choose your class:</FormLabel>
        <FormControlLabel
          control={<Checkbox name="frontend" />}
          label="Frontend"
        />
        <FormControlLabel
          control={<Checkbox name="backend" />}
          label="Backend"
        />
        <FormControlLabel control={<Checkbox name="tester" />} label="Tester" />
      </FormGroup>
      <div className="character-creation-div">
        <div className="left-arrows">
          <Button>
            <KeyboardArrowLeftIcon />
          </Button>
          <Button>
            <KeyboardArrowLeftIcon />
          </Button>
          <Button>
            <KeyboardArrowLeftIcon />
          </Button>
        </div>
        <div className="character-box">
          <img src={Stickman} alt="stickman" />
        </div>
        <div className="right-arrows">
          <Button>
            <KeyboardArrowRightIcon />
          </Button>
          <Button>
            <KeyboardArrowRightIcon />
          </Button>
          <Button>
            <KeyboardArrowRightIcon />
          </Button>
        </div>
      </div>
      <TableContainer component={Paper} className="stat-box">
        <Table className={classes.table} aria-label="simple table">
          <TableBody>
            {rows.map((row) => (
              <TableRow key={row.name}>
                <TableCell component="th" scope="row" width="70%" align="left">
                  {row.name}
                </TableCell>
                <TableCell align="left">{row.value}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <Copyright />
    </Container>
  );
}

export default CharacterCreation;
