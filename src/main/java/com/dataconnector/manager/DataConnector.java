/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.exceptions.InitialCtxDataConnectorException;
import com.dataconnector.helper.DataConnectorHelper;
import com.dataconnector.constans.ProvidersSupportEnum;
import com.dataconnector.helper.DataConnectorConWrap;
import com.dataconnector.sql.ProviderDataConnector;
import com.dataconnector.sql.ProviderDataConnector;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author proveedor_hhurtado
 */
public class DataConnector {

    // private String provider="com.prueba.orquestation.provider.OrquestationProvider";
    private DataConnector() {

    }

    /**
     *
     * @param dataSource
     * @param providerEnum
     * @return
     */
    public static InitialContextDataConnector getInitialContextDataConnector(DataSource dataSource, ProvidersSupportEnum providerEnum) {
        InitialContextDataConnector initialContextDataConnector = null;
        try {
            //Crea Wrapper del driver
            String classNameWrapper = "com.dataconnector.helper.DataConnectorConWrap";
            Class classWrapper = Class.forName(classNameWrapper);
            Object connWrapper = classWrapper.getConstructor(new Class[]{String.class, DataSource.class, ProvidersSupportEnum.class}).newInstance(null, dataSource, providerEnum);

            String classContext = "com.dataconnector.context.InitialContextDataconnectorImpl";
            Class classInitialContext = Class.forName(classContext);
            initialContextDataConnector = (InitialContextDataConnector) classInitialContext.getConstructor(new Class[]{classWrapper}).newInstance(connWrapper);
            initialContextDataConnector.initialContext();

            return initialContextDataConnector;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InitialCtxDataConnectorException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return initialContextDataConnector;
    }

    /**
     * Realiza la creación de la clase factory del DataConnector
     * @param providerEnum
     * @param context
     * @return DataConnectorFactory
     */
    public static DataConnectorFactory createDataConnectorFactory(ProvidersSupportEnum providerEnum, InitialContextDataConnector context) {

        DataConnectorFactory interfaceType = null;

        try {

            interfaceType = getDataConnectorFactory(providerEnum, context.getDataConnectorConWrap(), context);

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interfaceType;
    }

    /**
     * Realiza la creación de la clase factory del DataConnector
     * @param driver
     * @param providerEnum
     * @return DataConnectorFactory
     * @throws Exception
     */
    public static DataConnectorFactory createDataConnectorFactory(String driver, ProvidersSupportEnum providerEnum) throws Exception {
        DataConnectorFactory interfaceType = null;
        InitialContextDataConnector initialContextDataConnector = null;
        try {
            //Crea Wrapper del driver
            String classNameWrapper = "com.dataconnector.helper.DataConnectorConWrap";
            Class classWrapper = Class.forName(classNameWrapper);
            Object connWrapper = classWrapper.getConstructor(new Class[]{String.class, DataSource.class, ProvidersSupportEnum.class}).newInstance(driver, null, providerEnum);
            //Inicializa el contexto
            String classContext = "com.dataconnector.context.InitialContextDataconnectorImpl";
            Class classInitialContext = Class.forName(classContext);
            initialContextDataConnector = (InitialContextDataConnector) classInitialContext.getConstructor(new Class[]{classWrapper}).newInstance(connWrapper);
            initialContextDataConnector.initialContext();
            interfaceType = getDataConnectorFactory(providerEnum, initialContextDataConnector.getDataConnectorConWrap(), initialContextDataConnector);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InitialCtxDataConnectorException ex) {
            throw ex;
        }
        return interfaceType;
    }

    /**
     * Realiza la invocación y configruación del factory
     * @param providerEnum
     * @param wrapper
     * @param context
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws Exception 
     */
    private static DataConnectorFactory getDataConnectorFactory(ProvidersSupportEnum providerEnum, DataConnectorConWrap wrapper, InitialContextDataConnector context) throws ClassNotFoundException, NoSuchMethodException, Exception {
        DataConnectorFactory interfaceType = null;

        // Se realiza la instanciacion del provider
        String provider = "com.dataconnector.core.DataConnectorFactoryImpl";
        Class c = Class.forName(provider);
        interfaceType = (DataConnectorFactory) c.getConstructor(InitialContextDataConnector.class).newInstance(context);
            //    objClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{""+rs.getString(param.getNombreParametro())});

        //Invoca la instancia de manager correspondiente al driver 
        AbstractDataConnectorManager manager = (AbstractDataConnectorManager) DataConnectorHelper.getInstance().invokeMethod(interfaceType, provider, new Class[]{ProvidersSupportEnum.class, wrapper.getClass()}, "getDataConnectorManager", new Object[]{providerEnum, wrapper});
        //setDataConnectorManager
        DataConnectorHelper.getInstance().invokeMethod(interfaceType, provider, new Class[]{AbstractDataConnectorManager.class}, "setDataConnectorManager", new Object[]{manager});

        return interfaceType;
    }
}
