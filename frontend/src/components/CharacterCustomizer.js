import React, { useState } from "react";
import KeyboardArrowLeftIcon from "@material-ui/icons/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@material-ui/icons/KeyboardArrowRight";
import Button from "@material-ui/core/Button";
import Stickman from "../images/stickman.png";
import Alien from "../images/avataralien.png";
import Hacker from "../images/avatarhacker.jpg";
import Jedi from "../images/avatarjedi.png";
import Frenchman from "../images/avatarmustache.png";
import Ninja from "../images/avatarninja.jpg";

function AvatarSelector(avatar, setAvatar, avatarList, direction) {
  let index = avatarList.indexOf(avatar);

  if (index >= avatarList.length - 1 && direction === 1) {
    index = 0;
  } else if (index <= 0 && direction === -1) {
    index = 5;
  } else {
    index += direction;
  }

  setAvatar(avatarList[index]);
  return avatar;
}

function CharacterCustomizer() {
  const [avatarList] = useState([
    Stickman,
    Alien,
    Hacker,
    Jedi,
    Frenchman,
    Ninja,
  ]);
  const [avatar, setAvatar] = useState(avatarList[0]);

  return (
    <div className='character-creation-div'>
      <div className='left-arrows'>
        <Button>
          <KeyboardArrowLeftIcon />
        </Button>
        <Button
          onClick={() => AvatarSelector(avatar, setAvatar, avatarList, -1)}
        >
          <KeyboardArrowLeftIcon />
        </Button>
        <Button>
          <KeyboardArrowLeftIcon />
        </Button>
      </div>

      <div className='character-box'>
        <img src={avatar} alt='stickman' height='250px' width='250px' />
      </div>
      <div className='right-arrows'>
        <Button>
          <KeyboardArrowRightIcon />
        </Button>
        <Button
          onClick={() => AvatarSelector(avatar, setAvatar, avatarList, 1)}
        >
          <KeyboardArrowRightIcon />
        </Button>
        <Button>
          <KeyboardArrowRightIcon />
        </Button>
      </div>
    </div>
  );
}

export default CharacterCustomizer;
