import Typography from "@material-ui/core/Typography";
import "../App.css";

export default function Copyright() {
  return (
    <footer>
      <Typography variant="title" color="textSecondary" align="center">
        {"Copyright © Fidget and the Spinners"}
        {" "}
        {new Date().getFullYear()}
        {"."}
      </Typography>
    </footer>
  );
}
