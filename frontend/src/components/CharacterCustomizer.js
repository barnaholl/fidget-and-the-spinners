import React, { useState } from "react";
import KeyboardArrowLeftIcon from "@material-ui/icons/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@material-ui/icons/KeyboardArrowRight";
import Button from "@material-ui/core/Button";
import Alien from "../images/Alien.png";
import Hacker from "../images/Hacker.png";
import Jedi from "../images/Jedi.png";
import Frenchman from "../images/Frenchman.png";
import Ninja from "../images/Ninja.png";
import Nature from "../images/backgrounds/ForestHills.jpg";
import Mountains from "../images/backgrounds/Mountains.jpg";
import Polar from "../images/backgrounds/NorthernLights.jpg";
import Snow from "../images/backgrounds/Snow.jpg";

function AvatarSelector(avatar, setAvatar, avatarList, direction) {
  let index = avatarList.indexOf(avatar);

  if (index >= avatarList.length - 1 && direction === 1) {
    index = 0;
  } else if (index <= 0 && direction === -1) {
    index = avatarList.length - 1;
  } else {
    index += direction;
  }

  setAvatar(avatarList[index]);
  return avatar;
}

function CharacterCustomizer() {
  const [avatarList] = useState([Alien, Hacker, Jedi, Frenchman, Ninja]);
  const [avatar, setAvatar] = useState(avatarList[0]);
  const [backgroundList] = useState([Nature, Mountains, Polar, Snow]);
  const [background, setBackground] = useState(backgroundList[0]);

  return (
    <div className='character-creation-div'>
      <div className='left-arrows'>
        <Button
          onClick={() => {
            AvatarSelector(background, setBackground, backgroundList, -1);
          }}
        >
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

      <div>
        <img
          src={avatar}
          alt='avatar'
          height='250px'
          width='250px'
          className='character-box'
        />
      </div>

      <div>
        <img
          src={background}
          alt='background'
          height='250px'
          width='250px'
          id='backgroundImg'
        />
      </div>
      <div className='right-arrows'>
        <Button
          onClick={() => {
            AvatarSelector(background, setBackground, backgroundList, 1);
          }}
        >
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
