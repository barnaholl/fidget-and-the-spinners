package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.Equipment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    public Equipment getNewEquipment() {
        return Equipment.builder().build();
    }
}
