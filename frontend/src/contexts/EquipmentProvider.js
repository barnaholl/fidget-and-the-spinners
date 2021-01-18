import React, { useState, createContext } from "react";
import { fetchEquipmentItemsApi } from "../api/apiCalls";

export const EquipmentContext = createContext();

export function EquipmentProvider(props) {
  const [equipmentItems, setEquipmentItems] = useState([]);

  function fetchEquipmentItems() {
    fetchEquipmentItemsApi().then((data) => setEquipmentItems(data.data));
  }

  return (
    <EquipmentContext.Provider value={{ equipmentItems, fetchEquipmentItems }}>
      {props.children}
    </EquipmentContext.Provider>
  );
}
