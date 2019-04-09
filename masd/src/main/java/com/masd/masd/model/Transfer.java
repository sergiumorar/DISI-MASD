package com.masd.masd.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Marina Baban
 */

@Entity
public class Transfer {
    private int id;
    private Double amount;
    private Account accountByIdSender;
    private Account accountByIdReceiver;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return id == transfer.id &&
                Objects.equals(amount, transfer.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount);
    }

    @ManyToOne
    @JoinColumn(name = "idSender", referencedColumnName = "id")
    public Account getAccountByIdSender() {
        return accountByIdSender;
    }

    public void setAccountByIdSender(Account accountByIdSender) {
        this.accountByIdSender = accountByIdSender;
    }

    @ManyToOne
    @JoinColumn(name = "idReceiver", referencedColumnName = "id")
    public Account getAccountByIdReceiver() {
        return accountByIdReceiver;
    }

    public void setAccountByIdReceiver(Account accountByIdReceiver) {
        this.accountByIdReceiver = accountByIdReceiver;
    }
}
