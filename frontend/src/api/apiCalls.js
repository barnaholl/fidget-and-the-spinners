import axios from "axios";

export const fetchStatsApi = async () => {
  return await axios.get("http://localhost:5000/stats/1");
};
