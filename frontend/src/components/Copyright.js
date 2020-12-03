import Typography from "@material-ui/core/Typography";
import "../App.css";

export default function Copyright() {
  return (
    <footer>
      <Typography variant='subtitle1' color='textSecondary' align='center'>
        {"Copyright © Fidget and the Spinners"} {new Date().getFullYear()}
        {"."}
      </Typography>
    </footer>
  );
}
