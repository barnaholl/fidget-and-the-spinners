import React from "react";
import Navbar from "../layout/Navbar";
import Stats from "../components/Stats";
import Inventory from "../components/Inventory";
import Grid from "@material-ui/core/Grid";
import { useStyles } from "../StyleComponents";

export default function Character() {
  const classes = useStyles();
  return (
    <>
      <Navbar />
      <Grid
        container
        direction="row"
        justify="space-evenly"
        alignItems="center"
        spacing={8}
        className={classes.appBar}
      >
        <Grid item xs={5}>
          <Stats />
        </Grid>
        <Grid item xs={5}>
          <Inventory />
        </Grid>
      </Grid>
    </>
  );
}
