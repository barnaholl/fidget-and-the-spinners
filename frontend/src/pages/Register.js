import React, { useState } from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import { ValidatorForm, TextValidator } from "react-material-ui-form-validator";
import "../App.css";
import { fetchRegisterApi } from "../api/apiPosts";

const usernameRegex =
  "^(?=.{3,16}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
const passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(10),
    display: "flex",
    padding: 20,
    color: "white",
    opacity: 0.8,
    borderRadius: 10,
    backgroundColor: "black",
    flexDirection: "column",
    alignItems: "center",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: "100%",
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function Register() {
  const classes = useStyles();

  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordRepeat, setPasswordRepeat] = useState("");

  ValidatorForm.addValidationRule("isPasswordMatch", (value) => {
    if (value !== password) {
      return false;
    }
    return true;
  });

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Create account
        </Typography>
        <ValidatorForm
          className={classes.form}
          onSubmit={(e) => {
            console.log("i am alive");
            e.preventDefault();
            console.log("i am dead");
          }}
        >
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextValidator
                name="username"
                variant="outlined"
                required
                fullWidth
                id="username"
                label="Username"
                autoFocus
                autoComplete="off"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                validators={[`matchRegexp:${usernameRegex}`]}
                errorMessages={[
                  "Please enter a 3-16 character long username, use letters A-Z, numbers 0-9 and , or _",
                ]}
              />
            </Grid>
            <Grid item xs={12}>
              <TextValidator
                variant="outlined"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="off"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                validators={[`isEmail`]}
                errorMessages={["Please enter a valid email address"]}
              />
            </Grid>
            <Grid item xs={12}>
              <TextValidator
                variant="outlined"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                validators={[`matchRegexp:${passwordRegex}`]}
                errorMessages={["8- long, at least one: A-Z, a-z, 0-9"]}
              />
            </Grid>
            <Grid item xs={12}>
              <TextValidator
                variant="outlined"
                required
                fullWidth
                name="repeatPassword"
                label="Repeat Password"
                type="password"
                id="password"
                autoComplete="current-password"
                value={passwordRepeat}
                onChange={(e) => setPasswordRepeat(e.target.value)}
                validators={[`isPasswordMatch`]}
                errorMessages={["Passwords are not matching"]}
              />
            </Grid>
            <Grid item xs={12}>
              <FormControlLabel
                control={<Checkbox value="allowExtraEmails" color="primary" />}
                label="I have read and accept the general terms and conditions and the game rules."
              />
            </Grid>
          </Grid>
          <Link to={`/${username}/character-creation`}>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
              onClick={() => {
                fetchRegisterApi(username, password, email);
              }}
            >
              Play Now
            </Button>
          </Link>
          <Grid container justify="flex-end">
            <Grid item>
              <Link to={"/login"}>Already registered? Login</Link>
            </Grid>
          </Grid>
        </ValidatorForm>
      </div>
    </Container>
  );
}
