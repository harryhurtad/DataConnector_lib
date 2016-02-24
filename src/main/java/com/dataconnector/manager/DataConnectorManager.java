/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.criteria.CriteriaQuery;
import com.dataconnector.criteria.delete.CriteriaDelete;
import com.dataconnector.criteria.insert.CriteriaInsert;
import com.dataconnector.criteria.update.CriteriaUpdate;
import com.dataconnector.sql.CriteriaBuilder;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 23/02/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface DataConnectorManager extends AbstractDataConnectorManager{

   
   
    Query createQuery(CriteriaQuery q);

    Query createQuery(CriteriaInsert q);

    Query createQuery(CriteriaDelete q);

    Query createQuery(CriteriaUpdate q);
    
 
}
