/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.object;

import com.dataconnector.sql.Expression;

/**
 *Clase que representa los valores constantes de diferentes tipo
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 26/02/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public class ValueExpression implements Expression{

    private final Object element;
    private final Class type;
   

    public ValueExpression(String value) {
        this.type=String.class;
        this.element = value;
    }

    
    public ValueExpression(Object element, Class type) {
        this.element = element;
        this.type = type;
    }
    
    public String getValue() {
        return (String)element;
    } 

    public Object getElement() {
        return element;
    }

    public Class getType() {
        return type;
    }



    @Override
    public String getAlias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StringBuilder getSQLTransalte() {
        StringBuilder sb=new StringBuilder();
        sb.append(element);
        return sb;
    }
    
    
    
}
