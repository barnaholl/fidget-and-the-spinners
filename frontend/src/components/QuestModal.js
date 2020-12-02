import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Modal from "@material-ui/core/Modal";
import Backdrop from "@material-ui/core/Backdrop";
import { useSpring, animated } from "react-spring/web.cjs"; // web.cjs is required for IE 11 support

const useStyles = makeStyles((theme) => ({
  modal: {
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  paper: {
    backgroundColor: theme.palette.background.paper,
    border: "2px solid #000",
    boxShadow: theme.shadows[5],
    padding: theme.spacing(2, 4, 3),
  },
}));

const Fade = React.forwardRef(function Fade(props, ref) {
  const { in: open, children, onEnter, onExited, ...other } = props;
  const style = useSpring({
    from: { opacity: 0 },
    to: { opacity: open ? 1 : 0, width: "30%" },
    onStart: () => {
      if (open && onEnter) {
        onEnter();
      }
    },
    onRest: () => {
      if (!open && onExited) {
        onExited();
      }
    },
  });

  return (
    <animated.div ref={ref} style={style} {...other}>
      {children}
    </animated.div>
  );
});

export default function QuestModal() {
  const classes = useStyles();
  const [open, setOpen] = useState(false);

  const DUMMYQUESTS = [
    {
      id: 1,
      name: "Baklava",
      description:
        "You might wander far off the land, but do you have what it takes to sail along powerful tidalwaves?",
    },
    {
      id: 2,
      name: "Kilimanjaro",
      description: "Roaming to the East was never an easy task.",
    },
    {
      id: 3,
      name: "Tulok",
      description:
        "At the feet of the grandiose Mount Everest you will find this rare beast. He's too sacred to hunt, but bring me his milk",
    },
  ];

  const [actualQuest, setActualQuest] = useState(DUMMYQUESTS[0]);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <button type='button' onClick={handleOpen}>
        Take Quest
      </button>
      <Modal
        aria-labelledby='spring-modal-title'
        aria-describedby='spring-modal-description'
        className={classes.modal}
        open={open}
        onClose={handleClose}
        closeAfterTransition
        BackdropComponent={Backdrop}
        BackdropProps={{
          timeout: 500,
        }}
      >
        <Fade in={open}>
          <div className={classes.paper}>
            <h2 id='spring-modal-title'>Take Quest</h2>
            <p id='spring-modal-description'>Choose your quest here</p>
            <button onClick={() => setActualQuest(DUMMYQUESTS[0])}>
              Quest 1
            </button>
            <button onClick={() => setActualQuest(DUMMYQUESTS[1])}>
              Quest 2
            </button>
            <button onClick={() => setActualQuest(DUMMYQUESTS[2])}>
              Quest 3
            </button>
            <div>
              <h4>{actualQuest.name}</h4>
              <h5>{actualQuest.description}</h5>
            </div>
          </div>
        </Fade>
      </Modal>
    </div>
  );
}
