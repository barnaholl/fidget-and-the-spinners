import React from "react";
import Grid from "@material-ui/core/Grid";
import "../App.css";

export default function CharacterEquipment() {
  return (
    <Grid
      container
      direction="row"
      justify="space-evenly"
      spacing={0}
      alignItems="center"
    >
      <Grid item>
        <div className="default-equipment"></div>
      </Grid>
      <Grid item>
        <div className="default-equipment"></div>
      </Grid>
      <Grid item></Grid>
      <Grid item>
        <div className="default-equipment"></div>
      </Grid>
      <Grid item>
        <div className="default-equipment"></div>
      </Grid>
      <Grid item>
        <div className="default-equipment"></div>
      </Grid>
    </Grid>
  );
}
