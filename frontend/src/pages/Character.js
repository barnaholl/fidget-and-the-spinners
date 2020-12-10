import React from "react";
import Grid from "@material-ui/core/Grid";
import { makeStyles } from "@material-ui/core/styles";
import Navbar from "../layout/Navbar";
import Stats from "../components/Stats";
import CharacterEquipment from "../components/CharacterEquipment";
import Inventory from "../components/Inventory";
import CharacterWindow from "../components/CharacterWindow";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  appBar: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
  },
  grid: {
    marginTop: 50,
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
    </Grid>
  );
}
