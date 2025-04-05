package com.jUnitStudy.TestCasesLearning;

import com.jUnitStudy.model.Items;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class TestShoppingCart {

    private ShoppingCart shoppingCart;
    private List<Items> listItems = new ArrayList<> ();;

    @BeforeEach
    void setup(){
        shoppingCart = new ShoppingCart();
        Items itemsInCart1 = new Items();
        itemsInCart1.setItemName("Laptop");
        itemsInCart1.setItemQuantity(50);

        Items itemsInCart2 = new Items();
        itemsInCart2.setItemName("MobilePhone");
        itemsInCart2.setItemQuantity(100);

        listItems.add(itemsInCart1);
        listItems.add(itemsInCart2);
    }

    @Test
    void testAddItems(){
//        List<Items> items = shoppingCart.addItems();

//        assertNotNull(items, "Items list should not be null");
//        assertEquals(2, items.size());

//        Items firstItem = items.get(0);
//        Items secondItem = items.get(1);

/*        assertEquals("Laptop", firstItem.getItemName());
        assertEquals(50, firstItem.getItemQuantity());

        assertEquals("MobilePhone", secondItem.getItemName());
        assertEquals(100, secondItem.getItemQuantity());*/
        List<Items> result = shoppingCart.addItems();
        assertNotNull(result);
        assertNotEquals(3, result.size());

        assertEquals("Laptop", result.get(0).getItemName());
        assertEquals(50, result.get(0).getItemQuantity());

        assertEquals("MobilePhone", result.get(1).getItemName());
        assertEquals(100, result.get(1).getItemQuantity());

    }

    @Test
    void testAddItemsAutomatically(){
        List<Items> result = shoppingCart.addItemsAutomatically(listItems);
        Items firstItem = result.get(0);
        Items secondItem = result.get(1);
        assertNotNull(result);
        assertEquals("Laptop", firstItem.getItemName());
        assertEquals(50, firstItem.getItemQuantity());
        assertEquals("MobilePhone", secondItem.getItemName());
        assertEquals(100, secondItem.getItemQuantity());
        assertEquals(2,result.size());
        assertFalse(result.size()<0);

    }

    @Test
    void testNullItem(){
        String result = shoppingCart.addOrUpdateItem(null);
        assertEquals("Invalid item: null",result);
    }

    @Test
    void testEmptyItemName(){
        Items invalidNameItem = new Items();
        invalidNameItem.setItemName(" ");
        invalidNameItem.setItemQuantity(10);

        String result = shoppingCart.addOrUpdateItem(invalidNameItem);
        assertEquals("Invalid item: name is required",result);
    }

    @Test
    void testNegativeOrZeroItem(){
        Items invalidQuantityItem = new Items();
        invalidQuantityItem.setItemName("Tablet");
        invalidQuantityItem.setItemQuantity(0);

        String result = shoppingCart.addOrUpdateItem(invalidQuantityItem);
        assertEquals("Invalid item: quantity must be positive",result);
    }

    @Test
    void testAddNewItem(){
        Items newItem = new Items();
        newItem.setItemName("TV");
        newItem.setItemQuantity(200);

        String result = shoppingCart.addOrUpdateItem(newItem);
        assertEquals("Added newItem: TV",result);

        List<Items> items = shoppingCart.getItems();
        assertEquals(1, items.size(), "Cart should have 1 item");
        assertEquals("TV", items.get(0).getItemName());
        assertEquals(200, items.get(0).getItemQuantity());

    }

    @Test
    void testUpdateExistingItem(){
        // First, add an item
        Items firstName = new Items();
        firstName.setItemName("Laptop");
        firstName.setItemQuantity(50);
        shoppingCart.addOrUpdateItem(firstName);

        // Now create a new item with the same name but different quantity
        Items updateItem = new Items();
        updateItem.setItemName("Laptop");
        updateItem.setItemQuantity(1000);

        String result = shoppingCart.addOrUpdateItem(updateItem);
        System.out.println(result);
        assertEquals(result.contains("Updated Laptop to new quantity: 1050"),
                "Should update an existing item instead of adding a new one");


    }

    @Test
    void testTimeOut(){
        assertTimeout(ofSeconds(2),
                ()->{
            Thread.sleep(1000);
                     });
    }

    @Test
    void testGetItems() {

        List<Items> items = shoppingCart.getItems();
        assertNotNull(items, "The item list should not be null.");
        assertEquals(0, items.size(), "The item list should be empty before adding items.");
//        assertTrue();
    }

    @Test
    void testGetItemsAfterAdding(){
        shoppingCart.addItems();
        List<Items> items = shoppingCart.getItems();
        assertEquals(2, items.size());
    }

    @Test
    void testNegativeOrZeroQUantity(){
        Items  invalidItems = new Items();
        invalidItems.setItemName("Tablet");
        invalidItems.setItemQuantity(0);

        shoppingCart.getItems().add(invalidItems);
        assertTrue(shoppingCart.getItems().contains(invalidItems),
                "Item with zero quantity is still added, since ShoppingCart does not prevent it.");
    }

}
