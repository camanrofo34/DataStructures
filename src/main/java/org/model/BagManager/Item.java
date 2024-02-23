/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.BagManager;

/**
 *
 * @author PC 4060TI
 */
public class Item {

    String itemName;
    int rank;
    Type type;
    int durability;
    int quantity;
    String description;

    enum Type {
        CLOTH, LEATHER, PLATE
    };

    public Item(String itemName, int rank, Type type, int durability, String description) {
        this.itemName = itemName;
        this.rank = rank;
        this.type = type;
        this.durability = durability;
        this.quantity = 1;
        this.description = description;
    }
    public Item(String itemName, Type type, String description) {
        this.itemName = itemName;
        this.type = type;
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return itemName + ", " + type + ", " + description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity() {
        this.quantity++;
    }

}
