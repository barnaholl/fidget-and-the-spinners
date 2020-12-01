import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Drawer from "@material-ui/core/Drawer";
import CssBaseline from "@material-ui/core/CssBaseline";
import List from "@material-ui/core/List";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import { Link } from "react-router-dom";
import ListItemText from "@material-ui/core/ListItemText";

const drawerWidth = 240;

var barIcons = [
  { Kitchen: "/kitchen" },
  { Arena: "/arena" },
  { shop1: "/shop1" },
  { shop2: "/shop2" },
  { Dungeon: "/dungeon" },
  { Fortress: "/fortress" },
  { Guild: "/guild" },
  { Mail: "/mail" },
  { "Hall of Fame": "/hall-of-fame" },
];

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
  },
  appBar: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
}));

export default function LeftSideBar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <CssBaseline />
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
        anchor="left"
      >
        <div className={classes.toolbar} />
        <Divider />
        <List>
          {barIcons.map((item) => (
            <Link to={Object.entries(item)[0][1]}>
              <ListItem button key={Object.entries(item)[0][0]}>
                <ListItemIcon></ListItemIcon>
                <ListItemText primary={Object.entries(item)[0][0]} />
              </ListItem>
            </Link>
          ))}
        </List>
      </Drawer>
    </div>
  );
}
