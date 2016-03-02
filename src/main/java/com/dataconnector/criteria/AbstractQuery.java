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
 * Interfaz que representa los elementos esenciales para la creacion del query SQL
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 26/02/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface AbstractQuery {

    

    AbstractQuery where(Predicate params);

    Root from(String nombreTabla);

    AbstractQuery orderBy(Order... ord);
}
