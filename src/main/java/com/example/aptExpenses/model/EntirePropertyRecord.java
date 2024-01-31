package com.example.aptExpenses.model;

public class EntirePropertyRecord {

    private Apartment apt;
    private Expense exp;
    private ExpenseMetadata expMeta;

    public EntirePropertyRecord (Apartment apt, Expense exp, ExpenseMetadata expMeta) {
        this.apt = apt;
        this.exp = exp;
        this.expMeta = expMeta;
    }

    public Apartment getApt() {
        return apt;
    }

    public void setApt(Apartment apt) {
        this.apt = apt;
    }

    public Expense getExp() {
        return exp;
    }

    public void setExp(Expense exp) {
        this.exp = exp;
    }

    public ExpenseMetadata getExpMeta() {
        return expMeta;
    }

    public void setExpMeta(ExpenseMetadata expMeta) {
        this.expMeta = expMeta;
    }
    
}
