/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.query;

import com.dataconnector.object.ValueRoot;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @param <X>
 * @since build 22/03/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface SQLServerQuery<X extends Object> extends Query<X>{

    void setFieldRowNumber(ValueRoot field);
    void setWithNotLock(boolean root);
}
