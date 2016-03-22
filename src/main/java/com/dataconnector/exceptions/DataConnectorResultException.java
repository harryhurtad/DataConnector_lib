/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.exceptions;

/**
 *
 * @author proveedor_hhurtado
 */
public class DataConnectorResultException extends Exception {

    /**
     * Creates a new instance of <code>DataConnectorResultException</code>
     * without detail message.
     */
    public DataConnectorResultException() {
    }

    /**
     * Constructs an instance of <code>DataConnectorResultException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DataConnectorResultException(String msg) {
        super(msg);
    }
}
