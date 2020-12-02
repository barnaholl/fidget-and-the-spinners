import React from "react";
import Navbar from "../layout/Navbar";
import Stats from "../components/Stats";
import Inventory from "../components/Inventory";
import Grid from "@material-ui/core/Grid";

export default function Character() {
  return (
    <Grid
      container
      direction="row"
      justify="space-evenly"
      alignItems="center"
      spacing={8}
    >
      <Grid item xs={2}>
        <Navbar />
      </Grid>
      <Grid item xs={5}>
        <Stats />
      </Grid>
      <Grid item xs={5}>
        <Inventory />
      </Grid>
    </Grid>
  );
}
