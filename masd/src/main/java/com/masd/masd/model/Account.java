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
    private Currency currencyByIdCurrency;
    private Type typeByIdType;
    private User userByIdUser;
    private Collection<Expenses> expensesById;
    private Collection<Transfer> transfersById;
    private Collection<Transfer> transfersById_0;

    @Id
    @Column(name = "id", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "idCurrency", referencedColumnName = "id")
    public Currency getCurrencyByIdCurrency() {
        return currencyByIdCurrency;
    }

    public void setCurrencyByIdCurrency(Currency currencyByIdCurrency) {
        this.currencyByIdCurrency = currencyByIdCurrency;
    }

    @ManyToOne
    @JoinColumn(name = "idType", referencedColumnName = "id")
    public Type getTypeByIdType() {
        return typeByIdType;
    }

    public void setTypeByIdType(Type typeByIdType) {
        this.typeByIdType = typeByIdType;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @OneToMany(mappedBy = "accountByIdAccount")
    public Collection<Expenses> getExpensesById() {
        return expensesById;
    }

    public void setExpensesById(Collection<Expenses> expensesById) {
        this.expensesById = expensesById;
    }

    @OneToMany(mappedBy = "accountByIdSender")
    public Collection<Transfer> getTransfersById() {
        return transfersById;
    }

    public void setTransfersById(Collection<Transfer> transfersById) {
        this.transfersById = transfersById;
    }

    @OneToMany(mappedBy = "accountByIdReceiver")
    public Collection<Transfer> getTransfersById_0() {
        return transfersById_0;
    }

    public void setTransfersById_0(Collection<Transfer> transfersById_0) {
        this.transfersById_0 = transfersById_0;
    }
}
