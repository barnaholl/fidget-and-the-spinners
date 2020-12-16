import React, { useState, forwardRef, useContext } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Modal from "@material-ui/core/Modal";
import Backdrop from "@material-ui/core/Backdrop";
import { useSpring, animated } from "react-spring/web.cjs"; // web.cjs is required for IE 11 support
import { QuestContext } from "../contexts/QuestProvider";

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
  rewards: {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-evenly",
  },
  item: {
    order: 3,
  },
}));

const Fade = forwardRef(function Fade(props, ref) {
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
  const { quests, actualQuest, setActualQuest } = useContext(QuestContext);

  const handleOpen = () => {
    setOpen(true);
    setActualQuest(quests[0]);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <>
      <button type="button" onClick={handleOpen}>
        Take Quest
      </button>
      <Modal
        aria-labelledby="spring-modal-title"
        aria-describedby="spring-modal-description"
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
            <h2 id="spring-modal-title">Take Quest</h2>
            <p id="spring-modal-description">Choose your quest here</p>
            <button
              onClick={() => {
                return setActualQuest(quests[0]);
              }}
            >
              Quest 1
            </button>
            <button onClick={() => setActualQuest(quests[1])}>Quest 2</button>
            <button onClick={() => setActualQuest(quests[2])}>Quest 3</button>

            <h4>{actualQuest.name}</h4>
            <h5>{actualQuest.description}</h5>
            <h4>Reward:</h4>
            <div className={classes.rewards}>
              <div>Gold</div>
              <div>{actualQuest.rewardCoin}</div>
              <div>XP</div>
              <div>{actualQuest.rewardXP}</div>
              <div>Time</div>
              <div>{actualQuest.questTime}</div>
            </div>
          </div>
        </Fade>
      </Modal>
    </>
  );
}
