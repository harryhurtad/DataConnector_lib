/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.criteria;

import com.dataconnector.sql.AliasExpression;
import com.dataconnector.sql.Expression;
import com.dataconnector.sql.Order;
import com.dataconnector.sql.Predicate;
import com.dataconnector.sql.Root;
import com.dataconnector.sql.Selection;

/**
 *Clase que represneta un Subquery SQL
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 26/02/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface SubQuery extends AbstractQuery,Expression,AliasExpression  {

    
    SubQuery select(Selection params);

    @Override
    SubQuery where(Predicate params);

    @Override
    Root from(String nombreTabla);

    @Override
    SubQuery orderBy(Order... ord);

}
