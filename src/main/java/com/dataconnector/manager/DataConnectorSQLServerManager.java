/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.manager;

import com.dataconnector.query.Query;
import com.dataconnector.query.SQLServerQuery;
import com.dataconnector.criteria.CriteriaQuery;
import com.dataconnector.criteria.delete.CriteriaDeleteSQLServer;
import com.dataconnector.criteria.insert.CriteriaInsertSQLServer;
import com.dataconnector.criteria.update.CriteriaUpdateSQLServer;



/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 23/02/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface DataConnectorSQLServerManager extends AbstractDataConnectorManager{

    SQLServerQuery createQuery(CriteriaQuery q);

    Query createQuery(CriteriaInsertSQLServer q);

    Query createQuery(CriteriaDeleteSQLServer q);

    Query createQuery(CriteriaUpdateSQLServer q);
}
