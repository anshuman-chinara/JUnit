package com.jUnitStudy.controllers;

import com.jUnitStudy.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class HelloAssertListController {

    private List<Items> listItems = new ArrayList<>();

    @PostMapping(path = "/add")
    public String addItem(@RequestBody Items items){
        listItems.add(items);
        return "Item added successfully: " + items.getItemName();
    }

    @GetMapping(path = "/all")
    public List<Items> getAllItems(){
        return listItems;
    }
}
