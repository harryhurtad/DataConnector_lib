/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

/**
 *
 * @author proveedor_hhurtado
 */
public interface Root extends Form {
    Expression get(String nombreParametro);
}
