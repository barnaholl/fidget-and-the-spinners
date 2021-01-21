import axios from "axios";

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
  );
};

export const fetchLoginApi = async (username, password) => {
  return await axios.post(
    "http://localhost:8762/login",
    {
      username: username,
      password: password
    },
    {
      withCredentials: true,
    }
  );
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


