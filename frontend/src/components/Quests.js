import React, {useState} from 'react';
import {fetchCharacterApi} from "../api/apiCalls";
import { postCharToGetQuests } from "../api/apiPosts";
import styled from "styled-components";
import QuestMapper from "./QuestMapper";




const Quests = (props) => {
    
    const [getPlayer, setPlayer] = useState([]);
    const [quests, setQuests] = useState([]);
    const [charLoaded, setCharLoaded] = useState(false);
    const [questsLoaded, setQuestsLoaded] = useState(false);



    const GetCharacter = async () => {
        var response = await fetchCharacterApi();
        await setPlayer(response.data);
        await setCharLoaded(true);
    }

    const GetQuests = async () => {
        let postBody = await getPlayer;
        var response = await postCharToGetQuests(postBody);
        await setQuests(response.data);
        await setQuestsLoaded(true);
    }


    let content = (<div>Loading...</div>);

    if(!charLoaded) {
        GetCharacter();
        return content;
    } else if(!questsLoaded && charLoaded) {
        GetQuests();
        return content;
    } else if(questsLoaded && charLoaded) {
        console.log(quests);

        content = (<Container>
                    <QuestMapper quests={quests}>{props.children}</QuestMapper>
                  </Container>)
    }


    return content;
}

export default Quests;

const Container = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
`