/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnectorcommons.sql.Expression;
import com.dataconnector.object.ValueRoot;
import java.util.List;

/**
 *
 * @author proveedor_hhurtado
 */
public interface Predicate extends Expression {
    void setOperation(OperationEnum operation);
    OperationEnum getOperation();    
    List<Expression> getListExpression();
}
