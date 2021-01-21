import axios from "axios";

export const fetchRefreshItemsInShopApi = async (characterId,characterLevel,numberOfitems) => {
    return await axios.put(
      `http://localhost:8762/shop-handler/refreshShop/?characterId=${characterId}&characterLevel=${characterLevel}`   
    );
  };