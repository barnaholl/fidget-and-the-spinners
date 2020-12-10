import React from "react";
import Navbar from "../layout/Navbar";
import Stats from "../components/Stats";
import CharacterWindow from "../components/CharacterWindow";
import Inventory from "../components/Inventory";
import Grid from "@material-ui/core/Grid";
import { makeStyles } from "@material-ui/core/styles";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  appBar: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
  },
}));

export default function Character() {
  const classes = useStyles();
  return (
    <>
      <Navbar />
      <Grid
        container
        direction='row'
        justify='space-evenly'
        alignItems='center'
        spacing={8}
        className={classes.appBar}
      >
        {/*<Grid item xs={5}>
          <CharacterWindow />
  </Grid>*/}
        <Grid item xs={5}>
          <CharacterWindow />
        </Grid>
        <Grid item xs={5}>
          <Inventory />
        </Grid>
      </Grid>
    </>
  );
}
