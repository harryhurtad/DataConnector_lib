/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.helper.DataConnectorHelper;
import com.dataconnector.object.ProvidersSupportEnum;
import com.dataconnector.sql.ProviderDataConnector;
import com.dataconnector.sql.ProviderDataConnector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author proveedor_hhurtado
 */
public class DataConnector {

    // private String provider="com.prueba.orquestation.provider.OrquestationProvider";
    private DataConnector() {

    }

    public static DataConnectorFactory createDataConnectorFactory(String unidad, ProvidersSupportEnum providerEnum) throws Exception {
        DataConnectorFactory interfaceType = null;
        try {
            // Se realiza la instanciacion del provider
            String provider = "com.dataconnector.core.DataConnectorFactoryImpl";
            Class c = Class.forName(provider);
            interfaceType = (DataConnectorFactory) c.newInstance();
            //Inicializa el contexto
            ((DataConnectorFactory) interfaceType).initialContext();
            //Invoca la instancia de manager correspondiente al driver 
            AbstractDataConnectorManager manager = (AbstractDataConnectorManager) DataConnectorHelper.getInstance().invokeMethod(interfaceType, provider, new Class[]{ProvidersSupportEnum.class}, "getDataConnectorManager", providerEnum);
            //setDataConnectorManager
            DataConnectorHelper.getInstance().invokeMethod(interfaceType, provider, new Class[]{AbstractDataConnectorManager.class}, "setDataConnectorManager", manager);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interfaceType;
    }
}
