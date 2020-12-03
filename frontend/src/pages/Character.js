import React from "react";
import Navbar from "../layout/Navbar";
import Stats from "../components/Stats";
import Inventory from "../components/Inventory";
import Grid from "@material-ui/core/Grid";
import CharacterEquipment from "../components/CharacterEquipment";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles({
  grid: {
    marginTop: 50,
  },
});

export default function Character() {
  const classes = useStyles();

  return (
    <Grid
      className={classes.grid}
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
        <CharacterEquipment />
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
