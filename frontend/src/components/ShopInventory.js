import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import ItemSlot from "./Item";
import DefaultItemIcon from "../images/Icons/DefaultComputerIcon.png";

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
  item: {
    flexGrow: 1,
    backgroundImage: `url(${DefaultItemIcon})`,
    backgroundSize: "100%",
    height: "100px",
    width: "100px",
    display: "block",
  },
});

function FormRow(props) {}

FormRow.propTypes = {
  classes: PropTypes.object.isRequired,
};

function ShopInventory(props) {
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

ShopInventory.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(ShopInventory);
