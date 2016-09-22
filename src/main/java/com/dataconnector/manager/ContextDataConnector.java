/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.manager;

import com.dataconnector.constans.ProvidersSupportEnum;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 10/06/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface ContextDataConnector {
    public DataConnectorConnection getConnection() ;
    ProvidersSupportEnum getProvider();
}
