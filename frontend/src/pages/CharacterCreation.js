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
    <Container component="main" maxWidth="xs">
      <Grid item Container align="center">
        <Grid item>
          <KeyboardArrowLeftIcon/>
          <Box component="span" m={1}>
            <Button />
          </Box>
          <KeyboardArrowRightIcon/>
          <img src={Stickman} alt="stickman"/>
          <KeyboardArrowLeftIcon/>
          <KeyboardArrowRightIcon/>
          <KeyboardArrowLeftIcon/>
          <KeyboardArrowRightIcon/>
        </Grid>
      </Grid>
      <Copyright />
    </Container>
  );
}

export default CharacterCreation;
