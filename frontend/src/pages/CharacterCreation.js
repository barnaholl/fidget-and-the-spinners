import React from "react";
import Container from "@material-ui/core/Container";
import Copyright from "../components/Copyright";
import Grid from '@material-ui/core/Grid';
import KeyboardArrowLeftIcon from '@material-ui/icons/KeyboardArrowLeft';
import KeyboardArrowRightIcon from '@material-ui/icons/KeyboardArrowRight';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Stickman from '../images/stickman.png';

function CharacterCreation() {
  return (
    <Container component="main" maxWidth="xs" align="center">
      <Grid container spacing={3} display="inline" >
        <Grid item xs={1}>
          <KeyboardArrowLeftIcon/>
        <Grid/>
        <Grid item xs={10}>
        <img src={Stickman} alt="stickman"/>
        </Grid>
        <Grid item xs={1}>
          <KeyboardArrowRightIcon/>
        </Grid>
          <KeyboardArrowLeftIcon/>
        <Grid>
        </Grid>
          <KeyboardArrowRightIcon/>
        </Grid>
        <Grid>
          <KeyboardArrowLeftIcon/>
        </Grid>
        <Grid>
          <KeyboardArrowRightIcon/>
        </Grid>
      </Grid>
      <Box component="span" m={1}>
            <Button />
          </Box>
      <Copyright />
    </Container>
  );
}

export default CharacterCreation;
