import React from "react";
import Grid from "@material-ui/core/Grid";
import "../App.css";
import Avatar from "../images/avatarjedi.png";
import styled from "styled-components";

const Avatarr = styled.img`
  border: none;
`;

export default function CharacterEquipment() {
  return (
    <Grid
      container
      direction='row'
      justify='space-evenly'
      spacing={9}
      alignItems='center'
    >
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
      <Grid item>
        <div className='default-equipment'></div>
      </Grid>
      <Grid item className='character-box'>
        <img src={Avatar} alt='avataricon' />
      </Grid>
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
