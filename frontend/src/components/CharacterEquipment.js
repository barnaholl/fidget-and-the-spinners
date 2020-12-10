import React from "react";
import Grid from "@material-ui/core/Grid";
import "../App.css";
import Avatar from "../images/avataricon.png";

export default function CharacterEquipment() {
  return (
    <Grid
      container
      direction='row'
      justify='space-evenly'
      spacing={0}
      alignItems='center'
    >
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
      <div className='character-box'>
        <img src={Avatar} alt='avataricon' />
      </div>
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
    </Grid>
  );
}
