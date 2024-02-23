/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.BagManager;

import org.model.array.Array;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 */
public interface BagManagerInterface {
    public void addBag(int lenght);
    public boolean addItem (Item item);
    public List<Item> displayItems();
    public boolean exchangeItems(Item indexItem1, Item indexItem2);
    public List<Item> sortByRank();
}
