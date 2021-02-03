import React, { useState, createContext } from "react";
import { fetchShopItemsApi } from "../api/apiCalls";

export const ShopContext = createContext();

export function ShopProvider(props) {
  const [shopItems, setShopItems] = useState([]);

  function fetchShopItems() {
    fetchShopItemsApi().then((data) => setShopItems(data.data));
  }

  return (
    <ShopContext.Provider value={{ shopItems, fetchShopItems }}>
      {props.children}
    </ShopContext.Provider>
  );
}
