package com.masd.masd.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Marina Baban
 */

@Entity
public class Account {
    private int id;
    private String name;
    private Double amount;
    private Double spendingLimit;
    private Currency currency;
    private Type type;
    private User user;
    private Collection<Expenses> expenses;
    private Collection<Transfer> sender;
    private Collection<Transfer> receiver;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "spendingLimit", nullable = true, precision = 0)
    public Double getSpendingLimit() {
        return spendingLimit;
    }

    public void setSpendingLimit(Double spendingLimit) {
        this.spendingLimit = spendingLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(name, account.name) &&
                Objects.equals(amount, account.amount) &&
                Objects.equals(spendingLimit, account.spendingLimit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, amount, spendingLimit);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurrency", referencedColumnName = "id")
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currencyByIdCurrency) {
        this.currency = currencyByIdCurrency;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idType", referencedColumnName = "id")
    public Type getType() {
        return type;
    }

    public void setType(Type typeByIdType) {
        this.type = typeByIdType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User userByIdUser) {
        this.user = userByIdUser;
    }

    @OneToMany(mappedBy = "account")
    public Collection<Expenses> getExpenses() {
        return expenses;
    }

    public void setExpenses(Collection<Expenses> expensesById) {
        this.expenses = expensesById;
    }

    @OneToMany(mappedBy = "sender")
    public Collection<Transfer> getSender() {
        return sender;
    }

    public void setSender(Collection<Transfer> transfersById) {
        this.sender = transfersById;
    }

    @OneToMany(mappedBy = "receiver")
    public Collection<Transfer> getReceiver() {
        return receiver;
    }

    public void setReceiver(Collection<Transfer> transfersById_0) {
        this.receiver = transfersById_0;
    }
}
