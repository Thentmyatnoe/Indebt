package com.example.indebt.database.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Loan {
    @PrimaryKey
    @NonNull
    private String loanID;
    private String categoryID;
    private String customerID;
    private String openBalance;
    private String lastPayment;
    private String lastPaymentDate;
    private String lastActual;
    private String lastActualDate;
    private String total;
    private String agreement;
    private String deadLineDate;
    private String status;
    private String createdBy;
    private String createdOn;
    private String modifiedBy;
    private String modifiedOn;

    @NonNull
    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(@NonNull String loanID) {
        this.loanID = loanID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(String openBalance) {
        this.openBalance = openBalance;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getLastActual() {
        return lastActual;
    }

    public void setLastActual(String lastActual) {
        this.lastActual = lastActual;
    }

    public String getLastActualDate() {
        return lastActualDate;
    }

    public void setLastActualDate(String lastActualDate) {
        this.lastActualDate = lastActualDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(String deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
