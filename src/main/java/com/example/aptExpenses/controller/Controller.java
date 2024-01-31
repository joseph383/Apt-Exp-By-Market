package com.example.aptExpenses.controller;
import com.example.aptExpenses.Util.Util;
import com.example.aptExpenses.service.SqlService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class Controller {

    // lookup java 17 features

    //@Autowired
    private SqlService sqlService = new SqlService();
    private Util util = new Util();

@GetMapping("/")  
public ResponseEntity<String> homePage() {
    // Have dropdown pre-populated with markets in database for Update Apt and Market expenses option
    ArrayList<String> markets = sqlService.getAllMarkets();
    return ResponseEntity
            .status(HttpStatus.OK)
            .header("Custom-Header", "Successfully loaded market names")
            .body("Welcome to the home page where you will see options to 1. Create Apt \n 2. Update Apt \n 3. Generate Market Level Expense Report\n" + util.concatArrayListString(markets)); 
}

@RequestMapping("/createProperty")  
public String createProperty() {
    // Make front-end form
    // Make service to do validation on submit
    // Show error message and stay on page
    // Or show success message and move to home page
    return "Welcome to the createProperty page where you will upload an apartment's information and expenses";  
}

@RequestMapping("/getAllPropertiesInMarket")  
public String getAllPropertiesInMarket() {
    // Need input parameter = String marketName
    // Query db to get all properties in that market
    // Bring back it's apt id, apt name, unit count and year built
    return "Welcome to the getAllPropertiesInMarket page where you will see all properties in a market";  
}

@RequestMapping("/updateProperty")  
public String updateProperty() {
    // Need input parameter = String apt id
    // Load front-end form from /createProperty and prepopulate with data in db
    // Make service to do validation on submit
    // Show error message and stay on page
    // Or show success message and move to home page
    return "Welcome to the updateProperty page where you will have the form pre-populated with that property's info and you can make changes";  
}

@RequestMapping("/marketExpenses")  
public String marketExpenses(@RequestParam String marketName) {
    // Queries db
    // Returns data 
    return "Welcome to the marketExpenses page where you will see the average expenses and per door cost of apartment buildings in this market";  
}

} 