import axios from "axios";

 

export const fetchStatsApi = async () => {
  return await axios.get(`http://localhost:8762/character-handler/statistics/?characterId=${characterId}`);
};

export const fetchQuestsApi = async () => {
  return await axios.get("http://localhost:5000/quests");
};

export const fetchInventoryItemsApi = async () => {
  return await axios.get(`http://localhost:8762/character-handler/inventory/?characterId=${characterId}`);
};

export const fetchEquipmentItemsApi = async (characterId) => {
  return await axios.get(`http://localhost:8762/character-handler/equipment/?characterId=${characterId}`);
};

export const fetchShopItemsApi = async () => {
  return await axios.get(`http://localhost:8762/shop-handler/getItemsByCharacterId/?characterId=${characterId}`); 
};

export const fetchCharacterApi = async (userId) => {
  return await axios.get(`http://localhost:8762/character-handler/character/?userId=${userId}`)
};

