import React, { useState, createContext } from "react";
import { fetchEverythingApi } from "../api/apiCalls";

export const UserIdContext = createContext();

export function UserIdProvider(props) {
  const [userId, setUserId] = useState([]);

  function fetchUserId() {
    fetchEverythingApi().then((data) => setUserId(data.data));
  }

  return (
    <UserIdContext.Provider value={{ userId, fetchUserId }}>
      {props.children}
    </UserIdContext.Provider>
  );
}
