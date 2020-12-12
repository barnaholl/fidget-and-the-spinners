import React from "react";
import Grid from "@material-ui/core/Grid";
import "../App.css";
import Avatar from "../images/avatarjedi.png";
import DefaultItemIcon from "../images/Icons/DefaultComputerIcon.png";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  item: {
    //padding: theme.spacing(4),
    flexGrow: 1,
    backgroundImage: `url(${DefaultItemIcon})`,
    backgroundSize: "100%",
    height: "100px",
    width: "100px",
  },
}));

export default function CharacterEquipment() {
  const classes = useStyles();

  return (
    <Grid
      container
      //direction='row'
      justify='center'
      spacing={0}
      alignItems='center'
    >
      <Grid item xs={6}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={3}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item>
        <img src={Avatar} alt='avataricon' width='150' height='150' />
      </Grid>
      <Grid item xs={8}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={3}>
        <div className={classes.item}></div>
      </Grid>
      <Grid item xs={3}>
        <div className={classes.item}></div>
      </Grid>
    </Grid>
  );
}
