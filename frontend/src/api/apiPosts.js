import axios from "axios";

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
