import axios from "axios";
import React,{useState} from "react";



export const fetchRegisterApi = async (username, password, email) => {
  return await axios.post(
    "http://localhost:8762/register",
    {
      username: username,
      password: password,
      email: email,
    },
    {
      withCredentials: true,
    }
  ).then((data) => console.log(data));
};

export const FetchLoginApi = async (username, password) => {

//  const [isLoginValid, setIsLoginValid] = useState();

  return await axios.post(
    "http://localhost:8762/login",
    {
      username: username,
      password: password
    },
    {
      withCredentials: true,
    }
  ).then((data) => console.log(data))
  .catch((error) => {
    if(error.response) {
      console.log("Error during login ", error);
      //setIsLoginValid(false);
    }
  });
};

export const fetchLogoutApi = async () => {
  return await axios.post(
    "http://localhost:8762/logout"
  );
};

export const fetchCreateCharacterApi = async (userId,characterName,characterClass) => {
  return await axios.post(
    `http://localhost:8762/character-handler/character/?userId=${userId}&characterName=${characterName}&characterClass=${characterClass}`   
  );
};

export const fetchAddItemsToShopApi = async (characterId,characterLevel,numberOfitems) => {
  return await axios.post(
    `http://localhost:8762/shop-handler/addMultipleItemsByCharacterId/?characterId=${characterId}&characterLevel=${characterLevel}&numberOfItems=${numberOfitems}`   
  );
};


