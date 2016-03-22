/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.criteria;

import com.dataconnector.sql.Order;
import com.dataconnector.sql.Predicate;
import com.dataconnector.sql.Root;
import com.dataconnector.sql.Selection;

/**
 *Interfaz que representa y permite la creación de un query adaptado a la BD SQLServer
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 26/02/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface CriteriaQuerySQLServer extends AbstractQuery{
    
    
    CriteriaQuerySQLServer select(Selection... params);

    @Override
    CriteriaQuerySQLServer where(Predicate params);
    
    @Override
    Root from(String nombreTabla);
    
    @Override
    CriteriaQuerySQLServer orderBy(Order... ord);
    
    
    
    
}
