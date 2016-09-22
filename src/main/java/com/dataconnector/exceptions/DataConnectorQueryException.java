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
public class DataConnectorQueryException extends Exception {

    /**
     * Creates a new instance of
     * <code>DataConnectorEnsambleQueryException</code> without detail message.
     */
    public DataConnectorQueryException() {
    }

    /**
     * Constructs an instance of
     * <code>DataConnectorEnsambleQueryException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DataConnectorQueryException(String msg) {
        super(msg);
    }
}
