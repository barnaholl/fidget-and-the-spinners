import React from "react";
import Grid from "@material-ui/core/Grid";
import Navbar from "../layout/Navbar";
import ShopWindow from "../components/ShopWindow";
import CharacterWindow from "../components/CharacterWindow";
import { useStyles } from "../StyleComponents";

export default function Character() {
  const classes = useStyles();

  return (
    <>
      <Navbar />
      <Grid container direction='row' spacing={0} className={classes.appBar}>
        <Grid item xs={8}>
          <CharacterWindow />
        </Grid>
        <Grid item xs={4}>
          <ShopWindow />
        </Grid>
      </Grid>
    </>
  );
}
