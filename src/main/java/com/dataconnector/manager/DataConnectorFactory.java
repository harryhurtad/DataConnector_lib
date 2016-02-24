/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.sql.CriteriaBuilder;
import com.dataconnector.criteria.CriteriaQuery;

/**
 *
 * @author proveedor_hhurtado
 */
public interface DataConnectorFactory {

    AbstractDataConnectorManager getDataConnectorManager();
    void initialContext();
    
  
}
