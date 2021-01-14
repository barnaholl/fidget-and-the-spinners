import { Grid } from "@material-ui/core";
import React from "react";
import CharacterWindow from "../components/CharacterWindow";
import Inventory from "../components/Inventory";
import ShopInventory from "../components/ShopWindow";
import Navbar from "../layout/Navbar";
import { useStyles } from "../StyleComponents";
import Merchant from "../images/Merchant.png";

export default function Shop() {
  const classes = useStyles();

  return (
    <>
      <Navbar />
      <Grid container direction='row' spacing={1} className={classes.appBar}>
        <Grid container item xs={7}>
          <CharacterWindow />
        </Grid>
        <Grid container item xs={4} alignItems='baseline' justify='center'>
          <Inventory />

          <img
            src={Merchant}
            alt='merchant'
            width='941px'
            height='1953px'
            className={classes.merchant}
          />
          <ShopInventory />
        </Grid>
      </Grid>
    </>
  );
}
