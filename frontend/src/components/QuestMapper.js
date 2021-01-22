import React from 'react';
import OneQuest from "./OneQuest";

const QuestMapper = (props) => {

    return props.quests.map((oneQuest) => (
        <OneQuest quest={oneQuest}>{props.children}</OneQuest>
    ))
}
export default QuestMapper;