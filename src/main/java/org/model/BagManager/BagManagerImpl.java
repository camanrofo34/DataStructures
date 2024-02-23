/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.BagManager;

import org.model.LinkedList.singly.LinkedList;
import org.model.array.Array;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 */
public class BagManagerImpl implements BagManagerInterface {

    Array<Array> inventory = new Array<>(new Array[]{new Array<Item>(6), null, null, null});
    int realSize=1;

    @Override
    public void addBag(int lenght) {
        if (lenght == 6 || lenght == 8 || lenght == 12) {
            if(inventory.add(new Array<Item>(lenght))) realSize++;
        }
    }

    @Override
    public boolean addItem(Item item) {
        for (int i = 0; i < realSize; i++) {
            int index=inventory.get(i).indexOf(item);
            if (index != -1) {
                Item OldItem=(Item) inventory.get(i).get(index);
                OldItem.addQuantity();
                return true;
            }
        }
        for (int i = 0; i < realSize; i++){
            if(inventory.get(i).add(item)) return true;
        }
        return false;
    }

    @Override
    public List<Item> displayItems() {
        LinkedList<Item> itemsToDisplay = new LinkedList<>();
        for (int i = 0; i < realSize; i++) {
            for(int j = 0; j<inventory.get(i).size(); j++){
                Item newItem = (Item) inventory.get(i).get(j);
                itemsToDisplay.add(new Item(newItem.getItemName(), newItem.getType(), newItem.getDescription()));     
            }
        }
        return itemsToDisplay;
    }

    @Override
    public List<Item> sortByRank() {
        LinkedList<Item> itemsToDisplay = new LinkedList<>();
        for (int i = 0; i < realSize; i++){
            itemsToDisplay.addFirst(inventory.get(i));
        }
        itemsToDisplay.sort(e -> e.getRank());
        return itemsToDisplay;
    }

    @Override
    public boolean exchangeItems(Item indexItem1, Item indexItem2) {
        for(int i = 0; i<realSize; i++){
            if (inventory.get(i).contains(indexItem1)){
                
            }
        }
        return true;
    }
}
