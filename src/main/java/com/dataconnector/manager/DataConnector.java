/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.manager;

import com.dataconnector.context.InitialContextDataConnector;
import com.dataconnector.exceptions.InitialCtxDataConnectorException;
import com.dataconnector.commons.helper.DataConnectorHelper;
import com.dataconnector.constans.ProvidersSupportEnum;
import com.dataconnector.sql.ProviderDataConnector;
import com.dataconnector.sql.ProviderDataConnector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    public static InitialContextDataConnector getInitialContextDataConnector() {
        InitialContextDataConnector initialContextDataConnector = null;  
        try {
            //Crea Wrapper del driver
           // String classNameWrapper = "com.dataconnector.helper.DataConnectorConWrap";
           // Class classWrapper = Class.forName(classNameWrapper);
           // Object connWrapper = classWrapper.getConstructor(new Class[]{String.class, DataSource.class, ProvidersSupportEnum.class}).newInstance(null, dataSource, providerEnum);
        //    File descrDataConnector=new File(DataConnector.class.getResource("/META-INF/DataConnector-conf.xml").getFile());
            InputStream in =DataConnector.class.getResourceAsStream("/META-INF/DataConnector-conf.xml"); 
            String classContext = "com.dataconnector.context.InitialContextDataconnectorImpl";
            Class classInitialContext = Class.forName(classContext);
            initialContextDataConnector = (InitialContextDataConnector) classInitialContext.getConstructor(new Class[]{InputStream.class,ClassLoader.class}).newInstance(in,classInitialContext.getClassLoader());
            initialContextDataConnector.initialContext();
            in.close();
            return initialContextDataConnector;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InitialCtxDataConnectorException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return initialContextDataConnector;
    }

    /**
     * Realiza la creación de la clase factory del DataConnector
     * @param providerEnum
     * @param context
     * @param dataConnectorUnitName
     * @return DataConnectorFactory
     */
    public static DataConnectorFactory createDataConnectorFactory(String dataConnectorUnitName) {

        DataConnectorFactory interfaceType = null;

        try {

            interfaceType = getDataConnectorFactory( dataConnectorUnitName);

        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
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
  /*  public static DataConnectorFactory createDataConnectorFactory(String driver, ProvidersSupportEnum providerEnum) throws Exception {
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
    }*/

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
    private static DataConnectorFactory getDataConnectorFactory( String dataConnectorUnitName ) throws ClassNotFoundException, NoSuchMethodException, Exception {
        DataConnectorFactory interfaceType = null;

        // Se realiza la instanciacion del provider
        String provider = "com.dataconnector.core.DataConnectorFactoryImpl";
        Class c = Class.forName(provider);
        interfaceType = (DataConnectorFactory) c.getConstructor(String.class).newInstance(dataConnectorUnitName);
            //    objClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{""+rs.getString(param.getNombreParametro())});

        //Invoca la instancia de manager correspondiente al driver 
        AbstractDataConnectorManager manager = (AbstractDataConnectorManager) DataConnectorHelper.getInstance().invokeMethod(interfaceType, provider, new Class[]{ dataConnectorUnitName.getClass()}, "getDataConnectorManager", new Object[]{ dataConnectorUnitName});
        //setDataConnectorManager
        DataConnectorHelper.getInstance().invokeMethod(interfaceType, provider, new Class[]{AbstractDataConnectorManager.class}, "setDataConnectorManager", new Object[]{manager});

        return interfaceType;
    }
}
