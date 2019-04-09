package com.masd.masd.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Marina Baban
 */

@Entity
public class Expenses {
    private int id;
    private String date;
    private Double amount;
    private String comments;
    private Category categoryByIdCategory;
    private Account accountByIdAccount;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true, length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 200)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses expenses = (Expenses) o;
        return id == expenses.id &&
                Objects.equals(date, expenses.date) &&
                Objects.equals(amount, expenses.amount) &&
                Objects.equals(comments, expenses.comments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, amount, comments);
    }

    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "id")
    public Category getCategoryByIdCategory() {
        return categoryByIdCategory;
    }

    public void setCategoryByIdCategory(Category categoryByIdCategory) {
        this.categoryByIdCategory = categoryByIdCategory;
    }

    @ManyToOne
    @JoinColumn(name = "idAccount", referencedColumnName = "id")
    public Account getAccountByIdAccount() {
        return accountByIdAccount;
    }

    public void setAccountByIdAccount(Account accountByIdAccount) {
        this.accountByIdAccount = accountByIdAccount;
    }
}
