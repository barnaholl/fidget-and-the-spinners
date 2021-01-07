import React, { useState, createContext } from "react";
import { fetchQuestsApi } from "../api/apiCalls";

export const InventoryContext = createContext();

export function InventoryProvider(props) {
  const [inventoryItems, setInventoryItems] = useState([]);

  function fetchInventoryItems() {
    fetchInventoryItemsApi().then((data) => setInventoryItems(data.data));
  }

  return (
    <InventoryContext.Provider
      value={{ inventoryItems, fetchInventoryItems}}
    >
      {props.children}
    </InventoryContext.Provider>
  );
}
