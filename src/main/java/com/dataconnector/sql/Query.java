/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnector.annotation.DataConnectorPOJO;

/**
 *
 * @author proveedor_hhurtado
 * @param <X>
 */
public interface Query <X extends Object> {
    
  X  getSingleResult();
}
