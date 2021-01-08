import axios from "axios";

export const fetchStatsApi = async () => {
  return await axios.get("http://localhost:5000/stats/1");
};

export const fetchQuestsApi = async () => {
  return await axios.get("http://localhost:5000/quests");
};

export const gatewayApi = async (username, password, email) => {
  return await axios.post(
    "http://localhost:8762/user-handler/register",
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

// gateway api: http://localhost:8762/
