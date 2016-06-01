/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.sql;

import com.dataconnector.object.ValueRoot;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 23/03/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface CriteriaSQLServerBuilder extends CriteriaBuilder{

    Expression rowNumber(ValueRoot field,String alias);
}
