import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import ItemSlot from "./ItemSlot";

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
          <ItemSlot paperClass={classes.paper} />
        </Grid>
        <Grid item xs={4}>
          <ItemSlot paperClass={classes.paper} />
        </Grid>
        <Grid item xs={4}>
          <ItemSlot paperClass={classes.paper} />
        </Grid>
        <Grid item xs={4}>
          <ItemSlot paperClass={classes.paper} />
        </Grid>
        <Grid item xs={4}>
          <ItemSlot paperClass={classes.paper} />
        </Grid>
        <Grid item xs={4}>
          <ItemSlot paperClass={classes.paper} />
        </Grid>
      </Grid>
    </div>
  );
}

NestedGrid.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(NestedGrid);
