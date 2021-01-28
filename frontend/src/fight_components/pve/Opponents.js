import React, {useState} from 'react';
import styled from "styled-components";
import axios from "axios";
import playerPNG from "../../images/player.PNG";
import enemyPNG from "../../images/enemy.PNG";
import fireballPNG from "../../images/fireball.png";
import enemyTaco from "../../images/taco.png";
import slashImage from "../../images/slash.png";
import fireDamageImage from "../../images/fireDamage.png";

const Opponents = (props) => {

    const [getPlayer, setPlayer] = useState([]);
    const [getEnemy, setEnemy] = useState([]);
    const [getLoading, setLoading] = useState(true);
    const [getFightLoading, setFightLoading] = useState(true);
    const [getPlayerHP, setPlayerHP] = useState(0);
    const [getEnemyHP, setEnemyHP] = useState(0);
    const [displayedDMG, setDisplayedDMG] = useState(" -1 ");
    const [playerShootsFireball, setPlayerShootsFireball] = useState(false);
    const [enemyShootsTaco, setEnemyShootsTaco] = useState(false);
    const [slashImageShown, setSlashImageShown] = useState(false);
    const [fireDamageImageShown, setfireDamageImageShown] = useState(true);
    const [sendRequestForPlayer, setSendRequestForPlayer] = useState(true);
    const [sendRequestForEnemy, setSendRequestForEnemy] = useState(true);


    let content = <div>Loading...</div>;

    const FightEvent = async (ev) => {
        
        const requestOptions = {
            headers:{
                'Content-Type': 'application/json',
            },
            crossorigin: true
        }
        
        var postBody = JSON.stringify({player: getPlayer, enemy: getEnemy});
        
        const response = await axios.post("http://localhost:56675/api/fight", postBody, requestOptions);

        await setPlayerHP(getPlayer.motivation);
        await setEnemyHP(getEnemy.hp);
        
        await setFightLoading(false);
        await loopOverFightLog(response.data);
    }

    const loopOverFightLog = async (fightlog) => {
        console.log(fightlog);

        for (var i=0; i < fightlog.length;i++) {

            await TurnOffDamageIndicators();

            await ChangeDisplayedDMG(fightlog[i].dealtDMG);

            var didWeAttack = fightlog[i].damageDealer === getPlayer.name;

            if(didWeAttack) {
                await setPlayerShootsFireball(true);
                await setEnemyShootsTaco(false);
            } 
            else 
            {
                await setPlayerShootsFireball(false);
                await setEnemyShootsTaco(true);
            }
            
            await delay(1000);

            TurnOffFightAnimation();

            if(didWeAttack) {
                await setfireDamageImageShown(true);
                await setSlashImageShown(false);
            } 
            else
            {
                await setSlashImageShown(true);
                await setfireDamageImageShown(false);
            }

            await ChangeEnemyHPAsync(fightlog[i].enemyHealthPoint);  
            await ChangePlayerHPAsync(fightlog[i].ourHealthPoint);

            await delay(750);
        }

        await TurnOffDamageIndicators();
        await TurnOffFightAnimation();
    }

    const delay = (ms) => new Promise((resolve, reject) => setTimeout(resolve, ms));

    const TurnOffDamageIndicators = async () => {
        await setfireDamageImageShown(false);
        await setSlashImageShown(false);
    }

    const TurnOffFightAnimation = async () => {
        await setPlayerShootsFireball(false);
        await setEnemyShootsTaco(false);
    }

    const ChangePlayerHPAsync = async (newHP) => {
        await setPlayerHP(newHP);
    }

    const ChangeEnemyHPAsync = async (newHP) => {
        await setEnemyHP(newHP);
    }

    const ChangeDisplayedDMG = async (newDMG) => {
        await setDisplayedDMG(newDMG);
    }

    const AxiosGetPlayer = async () => {
        await setSendRequestForPlayer(false);

        var response = await axios("http://localhost:56675/api/character");
        await setPlayer(response.data);
        await setPlayerHP(getPlayer.motivation);

    }

    const AxiosGetEnemy = async () => {
        await setSendRequestForEnemy(false);

        const requestOptions = {
            headers:{
                'Content-Type': 'application/json',
            },
            crossorigin: true
        }

        var postBody = JSON.stringify({player: getPlayer});

        var response = await axios.post("http://localhost:56675/api/enemy", postBody, requestOptions);

        await setEnemy(response.data);
        await setEnemyHP(getEnemy.hp);

    }





    const FireballDiv = styled.div`
        display: ${playerShootsFireball ? "block" : "none"};
        height: auto;
        position: absolute;
        z-index: 55;
        width: auto;
        border: none;
        top: 360px;
        left: 648px;
        animation: fireballMoveAnimation 1.2s linear;

        img {
            height: 45px;
            width: 80px;
        }
    `
    const TacoDiv = styled.div`
        display: ${enemyShootsTaco ? "block" : "none"};
        height: auto;
        position: absolute;
        z-index: 55;
        width: auto;
        border: none;
        top: 360px;
        left: 1300px;
        animation: tacoMoveAnimation 1.2s linear;

        img {
            height: 45px;
            width: 80px;
        }
    `

    const SlashImageDiv = styled.div`
        display: ${slashImageShown ? "block" : "none"};
        position: absolute;

        height: 120px;
        width: 115px;
        top: 320px;
        left: 630px;

        img {
            max-width: 100%;
            max-height: 100%;
            opacity: 65%;
        }

        p {
            font-size: 40px;
            color: white;
            display: block;
            position: absolute;
            bottom: 50px;
            left: 25px;
            opacity: 95%;
            z-index: 2;

            animation: damageIndicatorAnimation 0.8s linear;
        }
    `

    const FireDamageImageDiv = styled.div`
        display: ${fireDamageImageShown ? "block" : "none"};
        position: absolute;

        height: 120px;
        width: 115px;
        top: 320px;
        left: 1200px;


        img {
            max-width: 100%;
            max-height: 100%;
            opacity: 65%;
        }

        p {
            font-size: 40px;
            color: white;
            display: block;
            position: absolute;
            bottom: 50px;
            left: 25px;
            opacity: 95%;
            z-index: 2;

            animation: damageIndicatorAnimation 0.8s linear;
        }
    `
    
    
    const GetEveryone = async () => {
        await AxiosGetPlayer();
        await AxiosGetEnemy();
        await setLoading(false);
        console.log("GET EVERYONE IN HERE");
    }

    if(getLoading && sendRequestForEnemy && sendRequestForPlayer)
    {
        GetEveryone();
    } 
    else if(getEnemy && getPlayer && !getLoading)
    {
        
        if(!getFightLoading)
        {
            content = (
            <Container className="players">
                <FireballDiv className="FireballPlayer">
                    <img src={fireballPNG} alt="Player fireball pic">

                    </img>
                </FireballDiv>
                <SlashImageDiv className="SlashDamageIndicatorDiv">
                    <p>-{displayedDMG}</p>
                    <img src={slashImage} alt="Damage indicator">

                    </img>
                </SlashImageDiv>
            <FighterDiv className="firstPlayer">
                <div className="firstPlayerImageDiv">
                    <img src={playerPNG} alt="PlayerPicture"></img>
                </div>
                <div className="firstPlayerNameDiv">{getPlayer.name} | Level: {getPlayer.characterLevel}</div>

                <div className="healthProgressDiv">
                    <progress id="healthBar" value={getPlayerHP} max={getPlayer.motivation}></progress>
                    <div className="TextBelowHPbar">{getPlayerHP} / {getPlayer.motivation}</div>
                </div>

                <div className="firstPlayerAttributes">
                    <p>Algorithm: {getPlayer.algorithm}</p>
                    <p>Clean Code: {getPlayer.cleanCode}</p>
                    <p>Design: {getPlayer.design}</p>
                    <p>Problem Solving: {getPlayer.problemSolving}</p>
                    <p>Testing: {getPlayer.testing}</p>
                </div>
            </FighterDiv>


            
            <TacoDiv className="TacoEnemyPlayer">
                <img src={enemyTaco} alt="Enemys Taco pic">

                </img>
            </TacoDiv>

            <FireDamageImageDiv className="FireDamageIndicatorDiv">
                <p>-{displayedDMG}</p>
                <img src={fireDamageImage} alt="Damage indicator with fire">

                </img>
            </FireDamageImageDiv>

            <FighterDiv className="secondPlayer">
                <div className="secondPlayerImageDiv">
                    <img src={enemyPNG} alt="EnemyPicture">

                    </img>
                </div>
                <div className="secondPlayerNameDiv">{getEnemy.name}</div>
                <div className="healthProgressDiv">
                    <progress id="healthBar" value={getEnemyHP} max={getEnemy.hp}></progress>
                    <div className="TextBelowHPbar">{getEnemyHP} / {getEnemy.hp}</div>
                </div>
                <div className="secondPlayerAttributes">
                    <p>Armor: {getEnemy.armor}</p>
                    <p>Damage: {getEnemy.damage}</p>
                    <p>Compiler Error Chance: {getEnemy.compilerErrorChance}</p>
                    <p>Runtime Error Chance: {getEnemy.runtimeErrorChance}</p>
                    <p>Favorite Quote: You won't pass me, stranger!</p>
                </div>
            </FighterDiv>
            <FightButton onClick={FightEvent}>Fight!</FightButton>

        </Container>)
        } 
        else
        {
            content = (
            <Container className="players">
                <FighterDiv className="firstPlayer">
                <div className="firstPlayerImageDiv">
                    <img src={playerPNG} alt="PlayerPicture">

                    </img>
                </div>
                <div className="firstPlayerNameDiv">{getPlayer.name} | Level: {getPlayer.characterLevel}</div>
                <div className="healthProgressDiv">
                    <progress id="healthBar" value={getPlayer.motivation} max={getPlayer.motivation}></progress>
                    <div className="TextBelowHPbar">{getPlayer.motivation} / {getPlayer.motivation}</div>
                </div>
                <div className="firstPlayerAttributes">
                    <p>Algorithm: {getPlayer.algorithm}</p>
                    <p>Clean Code: {getPlayer.cleanCode}</p>
                    <p>Design: {getPlayer.design}</p>
                    <p>Problem Solving: {getPlayer.problemSolving}</p>
                    <p>Testing: {getPlayer.testing}</p>
                </div>
            </FighterDiv>

            <FighterDiv className="secondPlayer">
                <div className="secondPlayerImageDiv">
                    <img src={enemyPNG} alt="EnemyPicture">

                    </img>
                </div>
                <div className="secondPlayerNameDiv">{getEnemy.name}</div>
                <div className="healthProgressDiv">
                    <progress id="healthBar" value={getEnemy.hp} max={getEnemy.hp}></progress>
                    <div className="TextBelowHPbar">{getEnemy.hp} / {getEnemy.hp}</div>
                </div>
                <div className="secondPlayerAttributes">
                    <p>Armor: {getEnemy.armor}</p>
                    <p>Damage: {getEnemy.damage}</p>
                    <p>Compiler Error Chance: {getEnemy.compilerErrorChance}</p>
                    <p>Runtime Error Chance: {getEnemy.runtimeErrorChance}</p>
                    <p>Favorite Quote: You won't pass me, stranger!</p>
                </div>
            </FighterDiv>
                <FightButton className="w3-button w3-green" onClick={FightEvent}>Fight!</FightButton>

            </Container>)

        }
    }
    
    return content;
}


const Container = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
`


const FighterDiv = styled.div`

    box-shadow: -9px 9px 6px 5px rgba(0,0,0,0.2);
    border: 2px solid black;
    max-height: 751px;
    height: auto;
    min-height: 550px;
    width: 292px;
    margin-top: 60px;
    background-color: #f9aeae;


    @keyframes damageIndicatorAnimation {
        0% {
            bottom: 0px;
            opacity:95%;
        }

        100% {
            bottom: 60px;
            opacity: 50%;
        }
    }


    @keyframes fireballMoveAnimation {
        0% {
            left:640px;
        }
            
        100% {
            left: 1300px;
        }
    }

    @keyframes tacoMoveAnimation {
        0% {
            left:1250px;
        }
        
        100% {
            left:550px;
        }
    }


    .firstPlayerNameDiv, .secondPlayerNameDiv {
        text-align: center;
        font-size: 18px;
        font-weight: 500;
        padding-top: 5px;
    }

    .firstPlayerImageDiv, .secondPlayerImageDiv {
        border:1px solid black;
        height: 305px;

       img {
            height: 305px;
            width: 290px;
        }
       
    }

    .firstPlayerHPDiv, .secondPlayerHPDiv {
        background-color: orangered;
        border-top: 1px solid black;
        text-align: center;
        font-size: 18px;
        font-weight: 500;
    }

    .healthProgressDiv {
        height: 50px;
    }

    .TextBelowHPbar {
        justify-content: center;
        display: flex;
        font-weight: 600;
        font-size: 19px;
        padding-bottom: 7px;
        position: relative;
        bottom: 33px;
    }

    #healthBar {
        width: 290px;
        height: 25px;
        padding-left: 5px;
        padding-right: 3px;
        margin-top: 10px;
        margin-bottom: 5px;
        -webkit-appearance: none;
    }
    progress[value]::-webkit-progress-bar {
        background-color: #ddd;
        border-radius: 2px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.25) inset;
    }

    progress[value]::-webkit-progress-value {
        background-color: #c54;
    }

    progess:not([value]) {
        background-color: #c54;
    }

    p {
        border-top: 1px solid black;
        font-weight: 600;
        padding-left: 2px;
        padding-top: 3px;
        margin-top: 0px;
    }

`

const FightButton = styled.button`
    background-color: #4CAF50;
    border: 1px solid black;
    color: black;
    text-align: center;
    text-decoration: none;
    text-decoration: none;
    position: absolute;
    font-size: 20px;
`
export default Opponents;