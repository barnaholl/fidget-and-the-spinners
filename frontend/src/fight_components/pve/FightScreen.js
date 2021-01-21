import React from 'react';
import styled from "styled-components";
import Opponents from "./Opponents";

const FightScreen = (props) => {


    return (
        <FightScreenStyled className="FightScreen">
            <Opponents>
            {props.children}
            </Opponents>
        </FightScreenStyled>
    )
}

export default FightScreen;


const FightScreenStyled = styled.div`
    width: 1920px;
    height: 840px;
    background-color: lightcoral;
    padding-bottom: 0px;
    padding-top: 97px;
    
`