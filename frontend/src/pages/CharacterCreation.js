import React from "react";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import Copyright from "../components/Copyright";
import Typography from "@material-ui/core/Typography";
import FormGroup from "@material-ui/core/FormGroup";
import FormLabel from "@material-ui/core/FormLabel";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import KeyboardArrowLeftIcon from "@material-ui/icons/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@material-ui/icons/KeyboardArrowRight";
import Stickman from "../images/stickman.png";
import "../App.css";

function CharacterCreation() {
  return (
    <Container component="main" maxWidth="xs">
      <Typography variant="h3" component="h2">
        Username
      </Typography>
      <FormLabel component="legend">Choose your class:</FormLabel>
      <FormGroup className="align-center">
        <FormControlLabel
          control={<Checkbox name="frontend" />}
          label="Frontend"
        />
        <FormControlLabel
          control={<Checkbox name="backend" />}
          label="Backend"
        />
        <FormControlLabel control={<Checkbox name="tester" />} label="Tester" />
      </FormGroup>
      <div className="character-creation-div">
        <div className="left-arrows">
          <Button>
            <KeyboardArrowLeftIcon />
          </Button>
          <Button>
            <KeyboardArrowLeftIcon />
          </Button>
          <Button>
            <KeyboardArrowLeftIcon />
          </Button>
        </div>
        <div className="character-box">
          <img src={Stickman} alt="stickman" />
        </div>
        <div className="right-arrows">
          <Button>
            <KeyboardArrowRightIcon />
          </Button>
          <Button>
            <KeyboardArrowRightIcon />
          </Button>
          <Button>
            <KeyboardArrowRightIcon />
          </Button>
        </div>
      </div>
      <Copyright />
    </Container>
  );
}

export default CharacterCreation;
