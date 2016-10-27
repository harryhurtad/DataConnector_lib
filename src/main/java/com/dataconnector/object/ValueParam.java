/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.object;

import com.dataconnectorcommons.sql.Expression;

/**
 *
 * @author proveedor_hhurtado
 */
public class ValueParam implements Expression {

     private final Object element;
    
    public ValueParam(String value) {    
        this.element = value;
    }
    
    @Override
    public String getAlias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StringBuilder getSQLTransalte() {
         StringBuilder sb=new StringBuilder();
         sb.append(":");
          sb.append(element);
         
         return sb;
    }
    
}
