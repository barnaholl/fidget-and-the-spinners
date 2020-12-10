import React, { useState, forwardRef, useEffect, useContext } from "react";
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
  const { quests, fetchQuests } = useContext(QuestContext);
  const { actualQuest, setActualQuest } = useContext(QuestContext);

  useEffect(() => {
    fetchQuests();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
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
          {/* <div className={classes.paper}>
            <h2 id="spring-modal-title">Take Quest</h2>
            <p id="spring-modal-description">Choose your quest here</p>
            <button onClick={() => setActualQuest(quests[0])}>Quest 1</button>
            <button onClick={() => setActualQuest(quests[1])}>Quest 2</button>
            <button onClick={() => setActualQuest(quests[2])}>Quest 3</button>
            <div>
              <h4>{actualQuest.name}</h4>
              <h5>{actualQuest.description}</h5>
            </div>
            <h4>Reward:</h4>
            <div className={classes.rewards}>
              {Object.entries(actualQuest.rewards).map((reward, id) => (
                <div key={id} id={reward[0]} className="item">
                  {reward[1]}
                </div>
              ))}
            </div>
          </div> */}
        </Fade>
      </Modal>
    </div>
  );
}
