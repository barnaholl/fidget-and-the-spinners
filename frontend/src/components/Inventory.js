import React, { useEffect, useContext } from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Item from "./Item";
import Grid from "@material-ui/core/Grid";
import { InventoryContext } from "../contexts/InventoryProvider";

const styles = (theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
});

// const ItemHandler = (items, classes) => {
//   for (let i = 0; i < 6; i++) {
//     return (
//       <Grid item xs={4}>
//         <Paper className={classes.paper}>item</Paper>
//       </Grid>
//     );
//   }
// };
function NestedGrid(props) {
  const { inventoryItems, fetchInventoryItems } = useContext(InventoryContext);

  useEffect(() => {
    fetchInventoryItems();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const { classes } = props;

  const kiskutya = [];

  for (let i = 0; i < 6; i++) {
    kiskutya.push(
      <Grid item xs={4}>
        <Paper className={classes.paper}>item</Paper>
      </Grid>
    );
  }

  return (
    <div className={classes.root}>
      <Grid container item xs={12} spacing={1}>
        {kiskutya}
        {/* {inventoryItems.map((item, index) => (
          <Item paper={classes.paper} item={item} />
        ))} */}
      </Grid>
    </div>
  );
}

NestedGrid.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(NestedGrid);
