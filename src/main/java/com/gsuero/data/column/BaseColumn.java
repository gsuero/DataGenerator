package com.gsuero.data.column;

import java.io.IOException;
import java.io.Serializable;

import com.gsuero.data.Visitor;

/**
 * @author gsuero
 */
public class BaseColumn implements Serializable {
    private static final long serialVersionUID = -3089008452450694424L;

    public void accept(Visitor visitor) {
        try {
            visitor.visitEnter(this);
            visitor.visit(this);
            visitor.visitLeave(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Name of the property/column
     */
    private String name;
    /**
     * Chance of being null
     */
    private int chance = 0;
    /**
     * column type to be generated
     */
    private ColumnType type;

    public BaseColumn(ColumnType type) {
        super();
        this.type = type;
    }
    
    public BaseColumn(String name, int chance, ColumnType type) {
        super();
        this.name = name;
        this.chance = chance;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        if (chance > 100) {
            chance = 100;
        } else if (chance < 0) {
            chance = 0;
        }
        this.chance = chance;
    }

    public ColumnType getType() {
        return type;
    }
    public void setType(ColumnType type) {
        this.type = type;
    }
}
