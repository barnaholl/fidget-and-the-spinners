import React, { useState, createContext } from "react";
import { postCharToGetQuests } from "../api/apiPosts";

export const QuestContext = createContext();

export function QuestProvider(props) {
  const [quests, setQuests] = useState([]);
  const [actualQuest, setActualQuest] = useState([]);

  async function fetchQuests(character) {
    await postCharToGetQuests(character).then((res) => setQuests(res.data));
    console.log("szívrepedést kapok geci");
  }

  return (
    <QuestContext.Provider
      value={{ quests, fetchQuests, actualQuest, setActualQuest }}
    >
      {props.children}
    </QuestContext.Provider>
  );
}
