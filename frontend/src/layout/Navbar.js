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
import Button from "@material-ui/core/Button";
import Container from "@material-ui/core/Container";
import { fetchLogoutApi } from "../api/apiPosts";
import { useHistory } from "react-router-dom";

const drawerWidth = 240;

var barIcons = [
  { Kitchen: "/kitchen" },
  { Arena: "/arena" },
  { Shop: "/shop" },
  { shop2: "/shop2" },
  { Character: "/character" },
  { Dungeon: "/dungeon" },
  { Fortress: "/fortress" },
  { Guild: "/guild" },
  { Mail: "/mail" },
  { "Hall of Fame": "/hall-of-fame" },
];

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    "& > *": {
      margin: theme.spacing(1),
    },
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
  const history = useHistory();

  const handleLogout = () => {
    fetchLogoutApi();
    history.push("/login");
  };

  return (
    <Container className={classes.root}>
      <CssBaseline />
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
        anchor="left"
        contentalign="center"
      >
        <div className={classes.toolbar} />
        <Button onClick={handleLogout}> Logout </Button>
        <Divider />
        <List>
          {barIcons.map((item) => (
            <Link
              key={Object.entries(item)[0][0]}
              to={Object.entries(item)[0][1]}
            >
              <Button
                fullWidth
                variant="outlined"
                color="primary"
                size="medium"
              >
                <ListItem button key={Object.entries(item)[0][0]}>
                  <ListItemIcon></ListItemIcon>
                  <ListItemText primary={Object.entries(item)[0][0]} />
                </ListItem>
              </Button>
            </Link>
          ))}
        </List>
      </Drawer>
    </Container>
  );
}
