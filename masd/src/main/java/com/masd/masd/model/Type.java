package com.masd.masd.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Marina Baban
 */

@Entity
public class Type {
    private int id;
    private String name;

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
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id == type.id &&
                Objects.equals(name, type.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
