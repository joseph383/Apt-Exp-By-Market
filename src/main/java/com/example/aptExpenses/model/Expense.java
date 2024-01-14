package com.example.aptExpenses.model;

public class Expense {

    private int apartmentId;
    private int expenseId;
    private int taxes;
    private int insurance;
    private int electric;
    private int water;
    private int payroll;
    private int management;
    private int repair_and_maintenance;
    private int contract_services;
    private int general;
    private int admin;
    private int legal;
    private int marketing;
    private int turnover;
    private int trash_removal;
    private int misc;

    public Expense(int apartmentId, int expenseId, int taxes, int insurance, int electric, int water, int payroll,
            int management, int repair_and_maintenance, int contract_services, int general, int admin, int legal,
            int marketing, int turnover, int trash_removal, int misc) {
        this.apartmentId = apartmentId; // db is generating this
        this.expenseId = expenseId; // db is generating this
        this.taxes = taxes;
        this.insurance = insurance;
        this.electric = electric;
        this.water = water;
        this.payroll = payroll;
        this.management = management;
        this.repair_and_maintenance = repair_and_maintenance;
        this.contract_services = contract_services;
        this.general = general;
        this.admin = admin;
        this.legal = legal;
        this.marketing = marketing;
        this.turnover = turnover;
        this.trash_removal = trash_removal;
        this.misc = misc;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public int getManagement() {
        return management;
    }

    public void setManagement(int management) {
        this.management = management;
    }

    public int getRepair_and_maintenance() {
        return repair_and_maintenance;
    }

    public void setRepair_and_maintenance(int repair_and_maintenance) {
        this.repair_and_maintenance = repair_and_maintenance;
    }

    public int getContract_services() {
        return contract_services;
    }

    public void setContract_services(int contract_services) {
        this.contract_services = contract_services;
    }

    public int getGeneral() {
        return general;
    }

    public void setGeneral(int general) {
        this.general = general;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getLegal() {
        return legal;
    }

    public void setLegal(int legal) {
        this.legal = legal;
    }

    public int getMarketing() {
        return marketing;
    }

    public void setMarketing(int marketing) {
        this.marketing = marketing;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public int getTrash_removal() {
        return trash_removal;
    }

    public void setTrash_removal(int trash_removal) {
        this.trash_removal = trash_removal;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc = misc;
    }

    
    
}
