import React, { useState, createContext } from "react";
import { fetchQuestsApi } from "../api/apiCalls";

export const QuestContext = createContext();

export function QuestProvider(props) {
  const [quests, setQuests] = useState([]);
  const [actualQuest, setActualQuest] = useState([]);

  function fetchQuests() {
    fetchQuestsApi().then((data) => console.log(data));
  }

  return (
    <QuestContext.Provider
      value={{ quests, fetchQuests, actualQuest, setActualQuest }}
    >
      {props.children}
    </QuestContext.Provider>
  );
}
