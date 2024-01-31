package com.example.aptExpenses.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.aptExpenses.model.Apartment;
import com.example.aptExpenses.model.EntirePropertyRecord;
import com.example.aptExpenses.model.Expense;
import com.example.aptExpenses.model.ExpenseMetadata;

public class SqlService {

    // Get the markets in the db (Pre-selected markets in dropdown on main page - for update and market level reports page)
    private String getAllMarketsSQL = "SELECT market FROM apt_level;";

    // Generate market level expense report on specified market
    private String getMarketExpenseReportSQL = "SELECT round(Avg(taxes), 0) as AvgTaxes, round(Avg(insurance), 0) as AvgInsurance, round(Avg(electric), 0) as AvgElectric, " + 
                                                "round(Avg(water), 0) as AvgWater, round(Avg(payroll), 0) as AvgPayroll, round(Avg(management), 0) as AvgManagement, " + 
                                                "round(Avg(repair_maintenance), 0) as AvgRepairMaintenance, round(Avg(contract_services), 0) as AvgContractServices, " +
                                                "round(Avg(general), 0) as AvgGeneral, round(Avg(admin), 0) as AvgAdmin, round(Avg(legal), 0) as AvgLegal, " +
                                                "round(Avg(marketing), 0) as AvgMarketing, round(Avg(trash_removal), 0) as AvgTrashRemoval, round(Avg(turnover), 0) as AvgTurnover, " +
                                                "round(Avg(misc), 0) as AvgMisc FROM expense_level exp JOIN apt_level apt ON exp.id = apt.id WHERE market = ?;";

    // Get the list of properties to update (Display all columns except id which will be stored in Java and passed to next page to populate form)
    private String getAllPropertiesSQL = "SELECT id, apt_name, unit_count, year_built FROM apt_level WHERE market = ?;";

    // Get entire apt record to prepopulate form for updating info (display everything except id fields)
    private String getPropertyRecordSQL = "SELECT apt.id as AptId, apt_name, market, unit_count, year_built, exp.id as ExpId, taxes, insurance, electric, water, payroll, management, repair_maintenance, " + 
                                            "contract_services, general, admin, legal, marketing, trash_removal, turnover, misc, exp_meta.id as MetaId, t12_date, notes " +
                                            "FROM apt_level apt " + 
                                            "JOIN expense_level exp ON apt.id = exp.id " + 
                                            "JOIN expense_metadata exp_meta ON exp.id = exp_meta.id " +
                                            "WHERE apt.id = ?;";

    // Insert new apartment record into database

    // Update existing apartment record in database

    public ArrayList<String> getAllMarkets() {

        ArrayList<String> marketNames = new ArrayList<String>();

        try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apt_exp_by_market", "root", "acE962%lmn");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getAllMarketsSQL);

        while (rs.next()) {
            marketNames.add(rs.getString("market"));
        }

        } catch (SQLException sqlE) {
            System.out.println("SQLException: " + sqlE);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException: " + cnfe);
        }

        return marketNames;
        
  }

  public Expense getMarketExpenseReport(String market) {

    Expense aptExpense = null;

    try {

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apt_exp_by_market", "root", "acE962%lmn");
    PreparedStatement stmt = conn.prepareStatement(getMarketExpenseReportSQL);
    stmt.setString(1, market);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        aptExpense = new Expense(0,0,
            rs.getInt("AvgTaxes"), rs.getInt("AvgInsurance"), rs.getInt("AvgElectric"), rs.getInt("AvgWater"), 
            rs.getInt("AvgPayroll"), rs.getInt("AvgManagement"), rs.getInt("AvgRepairMaintenance"), rs.getInt("AvgContractServices"),
            rs.getInt("AvgGeneral"), rs.getInt("AvgAdmin"), rs.getInt("AvgLegal"), rs.getInt("AvgMarketing"), 
            rs.getInt("AvgTrashRemoval"), rs.getInt("AvgTurnover"), rs.getInt("AvgMisc"));
            
    }

    } catch (SQLException sqlE) {
        System.out.println("SQLException: " + sqlE);
    } catch (ClassNotFoundException cnfe) {
        System.out.println("ClassNotFoundException: " + cnfe);
    }

    return aptExpense;
    
}

public ArrayList<Apartment> getPropertiesInMarket(String market) {

    ArrayList<Apartment> apartments = new ArrayList<Apartment>();

    try {

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apt_exp_by_market", "root", "acE962%lmn");
    PreparedStatement stmt = conn.prepareStatement(getAllPropertiesSQL);
    stmt.setString(1, market);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        Apartment apt = new Apartment(rs.getInt("id"), rs.getString("apt_name"), market, rs.getInt("unit_count"), rs.getInt("year_built"));

        apartments.add(apt);
    }

    } catch (SQLException sqlE) {
        System.out.println("SQLException: " + sqlE);
    } catch (ClassNotFoundException cnfe) {
        System.out.println("ClassNotFoundException: " + cnfe);
    }

    return apartments;
    
}

 

public EntirePropertyRecord getPropertyRecord(int aptId) {

    EntirePropertyRecord propertyRecord = null;

    try {

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apt_exp_by_market", "root", "acE962%lmn");
    PreparedStatement stmt = conn.prepareStatement(getPropertyRecordSQL);
    stmt.setInt(1, aptId);
    ResultSet rs = stmt.executeQuery();

    

    while (rs.next()) {
        Apartment apt = new Apartment(rs.getInt("AptId"), rs.getString("apt_name"), rs.getString("market"), rs.getInt("unit_count"), rs.getInt("year_built"));
        Expense exp = new Expense(rs.getInt("AptId"), rs.getInt("ExpId"), rs.getInt("taxes"), rs.getInt("insurance"), rs.getInt("electric"), rs.getInt("water"),
        rs.getInt("payroll"), rs.getInt("management"), rs.getInt("repair_maintenance"), rs.getInt("contract_services"), 
        rs.getInt("general"), rs.getInt("admin"), rs.getInt("legal"), rs.getInt("marketing"), rs.getInt("trash_removal"),
        rs.getInt("turnover"), rs.getInt("misc"));
        ExpenseMetadata expMeta = new ExpenseMetadata(rs.getInt("ExpId"), rs.getInt("MetaId"), rs.getDate("t12_date"), rs.getString("notes"));

        propertyRecord = new EntirePropertyRecord(apt, exp, expMeta);
        
    }

    } catch (SQLException sqlE) {
        System.out.println("SQLException: " + sqlE);
    } catch (ClassNotFoundException cnfe) {
        System.out.println("ClassNotFoundException: " + cnfe);
    }

    return propertyRecord;
    
}
    
}
