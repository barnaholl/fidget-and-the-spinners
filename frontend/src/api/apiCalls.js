import axios from "axios";

 
export const fetchStatsApi = async (characterId) => {
  return await axios.get("http://localhost:5002/stats/1");
};

export const fetchQuestsApi = async () => {
  return await axios.get("http://localhost:5002/quests");
};

export const fetchInventoryItemsApi = async (characterId) => {
  return await axios.get(`http://localhost:8762/character-handler/inventory/?characterId=${characterId}`);
};

export const fetchEquipmentItemsApi = async (characterId) => {
  return await axios.get(`http://localhost:8762/character-handler/equipment/?characterId=${characterId}`);
};

export const fetchShopItemsApi = async (characterId) => {
  return await axios.get(`http://localhost:8762/shop-handler/getItemsByCharacterId/?characterId=${characterId}`); 
};

export const fetchCharacterApi = async (userId) => {
  return await axios.get(`http://localhost:8762/character-handler/character/?userId=${userId}`)
};

export const fetchUserByToken = async (jwtToken) => {
  return await axios.get(`http://localhost:8762/current-user/${jwtToken}`)
};

