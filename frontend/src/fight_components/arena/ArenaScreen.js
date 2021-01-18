import React from 'react'
import ArenaFight from "./ArenaFight";
import styled from "styled-components";


const ArenaScreen = (props) => {


    return (
        <ArenaScreenStyled>
            <ArenaFight>
                {props.children}
            </ArenaFight>   
        </ArenaScreenStyled>
    )
}

export default ArenaScreen;

const ArenaScreenStyled = styled.div`
    width: 1920px;
    height: 840px;
    background-color: #965151;
    padding-bottom: 0px;
    padding-top: 97px;
    
`