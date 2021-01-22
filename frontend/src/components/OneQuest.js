import React from 'react';
import {Link} from "react-router-dom";
import styled from "styled-components";
import AccessAlarmRoundedIcon from "@material-ui/icons/AccessAlarmRounded";
import MonetizationOnRoundedIcon from "@material-ui/icons/MonetizationOnRounded";
import CloudUploadRoundedIcon from "@material-ui/icons/CloudUploadRounded";
import Grid from "@material-ui/core/Grid";




const OneQuest = (props) => {


    return (
        <QuestDiv className="oneQuest">
                <h1>{props.quest.name}</h1>
                <h3>{props.quest.description}</h3>
                <div className="GridDiv">
                <Grid container className="GridForRewards">
                    <Grid item className="rewardCoin">
                    <MonetizationOnRoundedIcon />{props.quest.rewardCoin} Gold 
                    </Grid>
                    <Grid item className="rewardXP">
                    <CloudUploadRoundedIcon />{props.quest.rewardXP} XP
                    </Grid>
                    <Grid item className="questTime">
                    <AccessAlarmRoundedIcon />{props.quest.questTime} ms
                    </Grid>
                </Grid>
                </div>
                <Link to="/fight"><FightButton>Start!</FightButton></Link>
            </QuestDiv>
    )
}

export default OneQuest;

const QuestDiv = styled.div`

    box-shadow: -9px 9px 6px 5px rgba(0,0,0,0.2);
    border: 2px solid black;
    max-height: 751px;
    height: auto;
    min-height: 375px;
    width: 410px;
    margin-top: 60px;
    background-color: #f9aeae;
    text-align: center;

    p {
        font-size: 18px;
    }

    .GridDiv {
        position: relative;
        left: 75px;
        font-size: 22px;
        margin-bottom: 150px;
    }
`

const FightButton = styled.button`
    background-color: #4CAF50;
    border: 1px solid black;
    color: black;
    text-align: center;
    text-decoration: none;
    position: relative;
    font-size: 20px;
`