import Typography from "@material-ui/core/Typography";
import "../App.css";

function Copyright() {
  return (
    <Typography variant='overline'>
      {"Copyright © Fidget and the Spinners"} {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}

export default Copyright;
