import React, { useState, createContext } from "react";

export const UserIdContext = createContext();

export function UserIdProvider(props) {
  const [userId, setUserId] = useState([]);

  return (
    <UserIdContext.Provider value={{ userId, setUserId }}>
      {props.children}
    </UserIdContext.Provider>
  );
}
