import React, { useState } from "react";
import Paper from "@material-ui/core/Paper";

function ItemSlot(props) {
  const [isShown, setIsShown] = useState(false);

  return (
    <>
      <Paper
        className={props.paperClass}
        onMouseEnter={() => setIsShown(true)}
        onMouseLeave={() => setIsShown(false)}
      >
        {isShown && <h3>I'll appear when you hover over the item slot</h3>}
        item
      </Paper>
    </>
  );
}

export default ItemSlot;
