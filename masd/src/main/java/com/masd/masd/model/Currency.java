package com.masd.masd.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Marina Baban
 */

@Entity
public class Currency {
    private int id;
    private String name;
    private Double value;

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
    @Column(name = "name", nullable = true, length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value", nullable = true, precision = 0)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return id == currency.id &&
                Objects.equals(name, currency.name) &&
                Objects.equals(value, currency.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, value);
    }
}
