/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import java.util.List;

/**
 *
 * @author proveedor_hhurtado
 */
public interface Predicate extends Expression {
    void setOperation(OperationEnum operation);
    OperationEnum getOperation(); 
    StringBuilder getSql();
    void setListExpression(List<Expression> listExp);
}
