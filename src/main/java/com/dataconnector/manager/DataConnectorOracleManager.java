/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.query.Query;
import com.dataconnector.criteria.CriteriaQuery;
import com.dataconnector.criteria.delete.CriteriaDeleteOracle;
import com.dataconnector.criteria.insert.CriteriaInsertOracle;
import com.dataconnector.criteria.update.CriteriaUpdateOracle;

/**
 *
 * @author proveedor_hhurtado
 */
public interface DataConnectorOracleManager extends AbstractDataConnectorManager {

    Query  createQuery(CriteriaQuery q);

    Query createQuery(CriteriaInsertOracle q);

    Query createQuery(CriteriaDeleteOracle q);

    Query createQuery(CriteriaUpdateOracle q);

}
