import axios from "axios";

export const fetchDeleteCharacterApi = async (characterId) => {
    return await axios.delete(
        `http://localhost:8762/character-handler/character/?characterId=${characterId}`,
    );
};