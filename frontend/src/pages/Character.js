import React from "react";
import Grid from "@material-ui/core/Grid";
import Navbar from "../layout/Navbar";
import Inventory from "../components/Inventory";
import CharacterWindow from "../components/CharacterWindow";
import { useStyles } from "../StyleComponents";

export default function Character() {
  const classes = useStyles();

  return (
    <>
      <Navbar />
      <Grid container direction='row' spacing={1} className={classes.appBar}>
        <Grid item xs={7}>
          <CharacterWindow />
        </Grid>
        <Grid item xs={4}>
          <Inventory />
        </Grid>
      </Grid>
    </>
  );
}
