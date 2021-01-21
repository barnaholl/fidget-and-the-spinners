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
