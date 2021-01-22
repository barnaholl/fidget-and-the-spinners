import React, { useState, createContext } from "react";
import { fetchCharacterApi } from "../api/apiCalls";

export const CharacterContext = createContext();

export function CharacterProvider(props) {
  const [character, setCharacter] = useState([]);

  function fetchCharacter() {
    fetchCharacterApi().then((data) => setCharacter(data.data));
  }

  return (
    <CharacterContext.Provider value={{ character, fetchCharacter }}>
      {props.children}
    </CharacterContext.Provider>
  );
}