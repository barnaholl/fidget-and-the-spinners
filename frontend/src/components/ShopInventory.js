import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";

const styles = (theme) => ({
  root: {
    flexGrow: 1,
    justify: "flex-end",
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
});

function FormRow(props) {}

FormRow.propTypes = {
  classes: PropTypes.object.isRequired,
};

function NestedGrid(props) {
  const { classes } = props;

  return (
    <div className={classes.root}>
      <Grid container item xs={12} spacing={1}>
        <Grid item xs={4}>
          <Paper className={classes.paper}>
            <button
              onClick={() => {
                console.log("Item 1 clicked");
              }}
            >
              item
            </button>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper className={classes.paper}>
            <button
              onClick={() => {
                console.log("Item 2 clicked");
              }}
            >
              item
            </button>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper className={classes.paper}>
            <button
              onClick={() => {
                console.log("Item 3 clicked");
              }}
            >
              item
            </button>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper className={classes.paper}>
            <button
              onClick={() => {
                console.log("Item 4 clicked");
              }}
            >
              item
            </button>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper className={classes.paper}>
            <button
              onClick={() => {
                console.log("Item 5 clicked");
              }}
            >
              item
            </button>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper className={classes.paper}>
            <button
              onClick={() => {
                console.log("Item 6 clicked");
              }}
            >
              item
            </button>
          </Paper>
        </Grid>
      </Grid>
    </div>
  );
}

NestedGrid.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(NestedGrid);
