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
public class InitialCtxDataConnectorException extends Exception {

    /**
     * Creates a new instance of <code>InitialCtxDataConnectorException</code>
     * without detail message.
     */
    public InitialCtxDataConnectorException() {
    }

    /**
     * Constructs an instance of <code>InitialCtxDataConnectorException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InitialCtxDataConnectorException(String msg) {
        super(msg);
    }
}
