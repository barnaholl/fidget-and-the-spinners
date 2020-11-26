import React from "react";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import Copyright from "../components/Copyright";
import KeyboardArrowLeftIcon from '@material-ui/icons/KeyboardArrowLeft';
import KeyboardArrowRightIcon from '@material-ui/icons/KeyboardArrowRight';
import Stickman from '../images/stickman.png';
import '../App.css';

function CharacterCreation() {
  return (
    <Container component="main" maxWidth="xs">
      <div className="character-creation-div">
        <div className="left-arrows">
          <Button>
            <KeyboardArrowLeftIcon/>
          </Button>
          <Button>
            <KeyboardArrowLeftIcon/>
          </Button>
          <Button>
            <KeyboardArrowLeftIcon/>
          </Button>
        </div>
        <div className="character-box">
          <img src={Stickman} alt="stickman"/>
        </div>
        <div className="right-arrows">
          <Button>
            <KeyboardArrowRightIcon/>
          </Button>
          <Button>
            <KeyboardArrowRightIcon/>
          </Button>
          <Button>
            <KeyboardArrowRightIcon/>
          </Button>
        </div>
      </div>
      <Copyright />
    </Container>
  );
}

export default CharacterCreation;
