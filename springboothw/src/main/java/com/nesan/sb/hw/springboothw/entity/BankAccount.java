package com.nesan.sb.hw.springboothw.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_bank_account")
public class BankAccount {
    @Id
    private String bankAcctNbr;

    private int balance;

    private String branchCode;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "atype")
    private BankAccountType type;

    @Override
    public String toString() {
        return "BankAccount [balance=" + balance + ", bankAcctNbr=" + bankAcctNbr + ", branchCode=" + branchCode
                + ", type=" + type + "]";
    }

    public BankAccountType getType() {
        return type;
    }

    public void setType(BankAccountType type) {
        this.type = type;
    }

    public String getBankAcctNbr() {
        return bankAcctNbr;
    }

    public void setBankAcctNbr(String bankAcctNbr) {
        this.bankAcctNbr = bankAcctNbr;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    
}
