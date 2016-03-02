/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnector.object.ValueRoot;

/**
 * Interfaz que representa la sentencia JOIN de SQL
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public interface Join {

    // public <Y extends Object> CollectionJoin<X, Y> join(CollectionAttribute<? super X, Y> ca);

    Join On(JoinPredicate p);

    Join where(Predicate p);

    ValueRoot get(String nombreParametro);

    StringBuilder getSQLTransalte();
}
