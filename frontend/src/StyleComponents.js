import { makeStyles } from "@material-ui/core/styles";

const drawerWidth = 240;

export const useStyles = makeStyles(() => ({
  appBar: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
  },
  container: {
    backdropFilter: "brightness(0.3)",
    padding: "1rem",
    borderRadius: "1%",
  },
  merchant: {},
  itemHover: {
    backdropFilter: "brightness(0.3)",
    padding: "1rem",
    borderRadius: "3%",
  },
}));
