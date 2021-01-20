package com.codecool.itemhandlerservice.model;



public enum EquipmentSlot {
    LANGUAGE(ProgrammingLanguageName.class),
    IDEA(IdeaName.class),
    FRAMEWORK(FrameworkName.class),
    COMPUTER(ComputerName.class),
    ACCESSORY(AccessoryName.class);

    private Class resultClass;

    <T extends Enum<T>> EquipmentSlot(Class<T> enumeration) {
        resultClass=enumeration;
    }

    public Class getEnum() {
        return resultClass;
    }
}
