import { Grid } from "@material-ui/core";
import React from "react";
import Navbar from "../layout/Navbar";

export default function Shop() {
  return (
    <Grid>
      <Grid item xs={2}>
        <Navbar />
      </Grid>
    </Grid>
  );
}
