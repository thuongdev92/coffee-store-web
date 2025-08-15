package com.tdev.coffee.cftable;

import jakarta.persistence.*;

@Entity
@Table(name = "CafeTable")
public class CfTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cfTableName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCfTableName() {
        return cfTableName;
    }

    public void setCfTableName(String cfTableName) {
        this.cfTableName = cfTableName;
    }
}
