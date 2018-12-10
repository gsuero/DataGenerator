package com.gsuero.data;

/**
 * @author gsuero
 */
public interface Visitable {
    public void accept(VisitorAdapter visitor);
}
