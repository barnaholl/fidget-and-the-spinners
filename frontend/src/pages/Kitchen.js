import React, { useEffect, useContext } from "react";
import Navbar from "../layout/Navbar";
import Container from "@material-ui/core/Container";
import QuestModal from "../components/QuestModal";
import { QuestContext } from "../contexts/QuestProvider";
import {CharacterContext} from "../contexts/CharacterProvider";

export default function Kitchen() {
  const { fetchQuests } = useContext(QuestContext);
  const { character, fetchCharacter } = useContext(CharacterContext);

  useEffect(() => {
    async function fetchData() {
      await fetchCharacter();
    };

    async function fetchQuestDataAsync(asd) {
      await fetchQuests(asd);
    }
    
    fetchData();
    fetchQuestDataAsync(character);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Container component='main' maxWidth='xs'>
      <Navbar />
      <QuestModal />
    </Container>
  );
}
