import axios from "axios";

 

export const fetchStatsApi = async () => {
  return await axios.get("http://localhost:5000/stats/1");
};

export const fetchQuestsApi = async () => {
  return await axios.get("http://localhost:5000/quests");
};

export const fetchInventoryItemsApi = async () => {
  return await axios.get("http://localhost:5000/inventory");
};

export const fetchEquipmentItemsApi = async () => {
  return await axios.get("http://localhost:5000/equipment");
};

export const fetchShopItemsApi = async () => {
  return await axios.get("http://localhost:5000/shop");
};
