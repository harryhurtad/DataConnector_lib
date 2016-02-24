/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.criteria.AbstractQuery;
import com.dataconnector.criteria.delete.CommonAbstractDelete;
import com.dataconnector.criteria.update.CommonAbstractUpdate;
import com.dataconnector.sql.CriteriaBuilder;

/**
 *
 * @author proveedor_hhurtado
 */
public interface AbstractDataConnectorManager {

    CriteriaBuilder getCriterialBuilder();

   
    
    String QuiEst();

    //Query createQuery(CriteriaUpdate q);
}
