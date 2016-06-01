/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.manager;

import com.dataconnector.exceptions.InitialCtxDataConnectorException;
import com.dataconnector.helper.DataConnectorConWrap;
import java.util.Map;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 26/04/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface InitialContextDataConnector {

     Map getMapObjectProccess();
     void initialContext() throws InitialCtxDataConnectorException;
     DataConnectorConWrap getDataConnectorConWrap();
    
}
