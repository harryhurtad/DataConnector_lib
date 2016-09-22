/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnectorcommons.sql.Expression;

/**
 * Interfaz que representa un Parametro de una sentencia SQL
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public interface ParameterExpression<X> extends Expression{
    
    String getNombreParametro();
    <X extends Object>Class<X> getParameterType();
}
