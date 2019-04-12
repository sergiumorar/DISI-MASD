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
    private Account sender;
    private Account receiver;

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
    public Account getSender() {
        return sender;
    }

    public void setSender(Account accountByIdSender) {
        this.sender = accountByIdSender;
    }

    @ManyToOne
    @JoinColumn(name = "idReceiver", referencedColumnName = "id")
    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account accountByIdReceiver) {
        this.receiver = accountByIdReceiver;
    }
}
