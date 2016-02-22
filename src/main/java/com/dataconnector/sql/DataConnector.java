/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author proveedor_hhurtado
 */
public class DataConnector {
    
   // private String provider="com.prueba.orquestation.provider.OrquestationProvider";
    
    private DataConnector(){
    
    }
    
    
    
    public static FactoryDataConnectorManager createDataConnectorManager(){
    
        try {
            // Se realiza la instanciacion del provider
            String  provider="com.prueba.dataconnector.provider.DataConnectorProvider";
            Class c = Class.forName(provider);
            ProviderDataConnector interfaceType = (ProviderDataConnector)c.newInstance();
            // if (className.equals("com.path.to.ImplementationType") {
            ((ProviderDataConnector)interfaceType).initialContext();
            //}
            
        } catch (InstantiationException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
