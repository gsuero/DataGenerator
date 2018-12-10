package com.gsuero.data;

import java.io.IOException;

import com.gsuero.data.column.BaseColumn;

/**
 * @author gsuero
 */
public interface Visitor {
    void visit(BaseColumn column) throws IOException;
    void visitEnter(BaseColumn column) throws IOException;
    void visitLeave(BaseColumn column) throws IOException;
}
