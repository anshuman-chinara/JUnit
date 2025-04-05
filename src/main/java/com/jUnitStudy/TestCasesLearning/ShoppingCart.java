package com.jUnitStudy.TestCasesLearning;

import com.jUnitStudy.model.Items;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Items> listItems = new ArrayList<> ();

    public List<Items> addItems(){
        Items itemsInCart1 = new Items();
        itemsInCart1.setItemName("Laptop");
        itemsInCart1.setItemQuantity(50);

        Items itemsInCart2 = new Items();
        itemsInCart2.setItemName("MobilePhone");
        itemsInCart2.setItemQuantity(100);

        listItems.add(itemsInCart1);
        listItems.add(itemsInCart2);

        return listItems;
    }

    public List<Items> addItemsAutomatically(List<Items> newItems){
        for(Items item: newItems){
            listItems.add(item);
        }
        return listItems;
    }

    //If the item is present then it will update the list or will add a new item
    public String addOrUpdateItem(Items newItem){

        if (newItem == null){
            return "Invalid item: null";    //check for null input
        } else if (newItem.getItemName() == null || newItem.getItemName().trim().isEmpty()){
            return "Invalid item: name is required";    //validate the item name
        } else if (newItem.getItemQuantity() == null || newItem.getItemQuantity() <= 0){
            return "Invalid item: quantity must be positive";   //validate the item quantity
        } else {
            //Here, the newItem has pass all the basic validation
            boolean foundExisting = false;

            for(Items existingItem: listItems){
                if(existingItem.getItemName().equalsIgnoreCase(newItem.getItemName())){
                    int updatedQuantity = existingItem.getItemQuantity() + newItem.getItemQuantity();
                    existingItem.setItemQuantity(updatedQuantity);
                    foundExisting = true; //Updated the item
                    return "Updated " + newItem.getItemName() + " to new quantity: " + updatedQuantity;
                }
            }
            //If the loop completes and foundExisting is false, no matching item has found
            if(!foundExisting){
                listItems.add(newItem);
                return "Added newItem: " + newItem.getItemName();
            } else {
                return "Unexpected condition - item was found but not get updated. Please check your logic";
            }
        }

    }

    public List<Items> getItems() {
        return listItems;
    }


/*    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItems();
        System.out.println(shoppingCart.getItems());

    }*/

}
