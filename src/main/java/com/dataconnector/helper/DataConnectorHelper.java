/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public class DataConnectorHelper {

    private static DataConnectorHelper instance;

    private DataConnectorHelper() {

    }

    public static DataConnectorHelper getInstance() {
        if (instance == null) {
            instance = new DataConnectorHelper();
        }

        return instance;
    }

    public Object invokeMethod(Object instance,String nombreClase, Class[] parameters, String nameMethod, Object value) throws Exception {
        Object retorno=null;
        try {
            //Invoca y crea una instancia de la clase
            Class cls = Class.forName(nombreClase);
            //Object obj = cls.newInstance();

            //invoca el metodo de la clase
            Method method = cls.getDeclaredMethod(nameMethod, parameters);
            if(parameters.length==0 && value==null){
                retorno=method.invoke(instance, null);
            }else if (value!=null){
                retorno=method.invoke(instance, value);
            }
             
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DataConnectorHelper.class.getName()).log(Level.SEVERE, null, ex);
            Exception e = new Exception("Problemas al invocar la clase: " + nombreClase);
            throw e;
        }
        return retorno;
    }
}
