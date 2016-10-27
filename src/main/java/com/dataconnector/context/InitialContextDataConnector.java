/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dataconnector.context;

import com.dataconnector.exceptions.InitialCtxDataConnectorException;
import com.dataconnector.manager.DataConnectorFactory;
import java.util.Map;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1  (UTF-8)
 * @since build 26/04/2016  
 * @author proveedor_hhurtado  email: proveedor_hhurtad@ath.com.co
 */
public interface InitialContextDataConnector {

   
     void initialContext() throws InitialCtxDataConnectorException;
      DataConnectorFactory createDataConnectorFactory(String dataConnectorUnitName) throws InitialCtxDataConnectorException ;
     
    
}
