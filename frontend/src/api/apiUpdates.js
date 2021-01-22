import axios from "axios";

export const fetchUpdateItemsInShopApi = async (characterId,characterLevel) => {
    return await axios.put(
      `http://localhost:8762/shop-handler/refreshShop/?characterId=${characterId}&characterLevel=${characterLevel}`   
    );
  };

  export const fetchUpdateCharacterApi = async (userId,character) => {
    return await axios.put(
      `http://localhost:8762/character-handler/character/?userId=${userId}`,
      character,
      {withCredentials: true }  
    );
  };

export const fetchUpdateStatsApi = async (characterId,statistics) => {
  return await axios.put(
    `http://localhost:8762/character-handler/statistics/?characterId=${characterId}`,
    statistics,
    {withCredentials: true }  
  );
};

export const fetchUpdateInventoryApi = async (characterId,inventory) => {
  return await axios.put(
    `http://localhost:8762/character-handler/inventory/?characterId=${characterId}`,
    inventory,
    {withCredentials: true }  
  );
};

export const fetchUpdateEquipmentApi = async (characterId,equipment) => {
  return await axios.put(
    `http://localhost:8762/character-handler/equipment/?characterId=${characterId}`,
    equipment,
    {withCredentials: true }  
  );
};