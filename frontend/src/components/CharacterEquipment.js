import React from "react";
import Grid from "@material-ui/core/Grid";
import "../App.css";
import Avatar from "../images/avatarjedi.png";
import DefaultItemIcon from "../images/Icons/DefaultComputerIcon.png";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles(() => ({
  item: {
    flexGrow: 1,
    backgroundImage: `url(${DefaultItemIcon})`,
    backgroundSize: "100%",
    height: "100px",
    width: "100px",
    display: "block",
  },
  avatarImage: {
    display: "block",
    margin: "auto",
    width: "150px",
    height: "150px",
  },
}));

export default function CharacterEquipment() {
  const classes = useStyles();

  return (
    <Grid container justify="center" spacing={0}>
      <Grid item xs={6}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={0}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={10}>
        <img src={Avatar} alt="avataricon" className={classes.avatarImage} />
      </Grid>
      <Grid item xs={4}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={4}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={0}>
        <div className={classes.item}></div>
      </Grid>
    </Grid>
  );
}
