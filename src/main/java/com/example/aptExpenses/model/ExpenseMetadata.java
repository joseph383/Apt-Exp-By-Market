package com.example.aptExpenses.model;

import java.util.Date;

public class ExpenseMetadata {

    private int expenseId;
    private int expense_metadata_id;
    private Date t12_date;
    private String notes;

    public ExpenseMetadata(int expenseId, int expense_metadata_id, Date t12_date, String notes) {
        this.expenseId = expenseId; // db is generating this
        this.expense_metadata_id = expense_metadata_id; // db is generating this
        this.t12_date = t12_date;
        this.notes = notes;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getExpense_metadata_id() {
        return expense_metadata_id;
    }

    public void setExpense_metadata_id(int expense_metadata_id) {
        this.expense_metadata_id = expense_metadata_id;
    }

    public Date getT12_date() {
        return t12_date;
    }

    public void setT12_date(Date t12_date) {
        this.t12_date = t12_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    
}
