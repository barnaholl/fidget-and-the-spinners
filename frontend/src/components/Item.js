import React from "react";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";

export default function Item(props) {
  return (
    <Grid item xs={4}>
      <Paper className={props.paper}>{props.item.name}</Paper>
    </Grid>
  );
}
