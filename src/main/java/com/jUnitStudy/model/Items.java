package com.jUnitStudy.model;

public class Items {

    private String itemName;
    private Integer itemQuantity;

    //No-args constructor
    public Items(){

    }

    //Parameterized Contsructor
    public Items(String itemName, Integer itemQuantity){
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    //toString()
    public String toString(){
        return "(itemName: " + itemName + " And " + "itemQuantity: " + itemQuantity + ")";
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setItemQuantity(Integer itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    public String getItemName(){
        return itemName;
    }

    public Integer getItemQuantity(){
        return itemQuantity;
    }
}
