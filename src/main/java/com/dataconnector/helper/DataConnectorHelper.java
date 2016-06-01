/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase commun con metodos de soporte de difernetes tipos
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

    public Object invokeMethod(Object instance, String nombreClase, Class[] parameters, String nameMethod, Object[] value) throws Exception {
        Object retorno = null;
        try {
            //Invoca y crea una instancia de la clase
            Class cls = Class.forName(nombreClase);
            //Object obj = cls.newInstance();

            //invoca el metodo de la clase
            Method method = cls.getDeclaredMethod(nameMethod, parameters);
            if (parameters.length == 0 && value == null) {
                retorno = method.invoke(instance, null);
            } else if (value != null) {
                retorno = method.invoke(instance, value);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DataConnectorHelper.class.getName()).log(Level.SEVERE, null, ex);
            Exception e = new Exception("Problemas al invocar la clase: " + nombreClase);
            throw e;
        }
        return retorno;
    }

    public void printInitDataConnector() {

        System.out.println(" /$$$$$$$  /$$$$$$ /$$$$$$$$/$$$$$$         /$$$$$$  /$$$$$$ /$$   /$$/$$   /$$/$$$$$$$$ /$$$$$$ /$$$$$$$$/$$$$$$ /$$$$$$$ \n"
                + "| $$__  $$/$$__  $|__  $$__/$$__  $$       /$$__  $$/$$__  $| $$$ | $| $$$ | $| $$_____//$$__  $|__  $$__/$$__  $| $$__  $$\n"
                + "| $$  \\ $| $$  \\ $$  | $$ | $$  \\ $$      | $$  \\__| $$  \\ $| $$$$| $| $$$$| $| $$     | $$  \\__/  | $$ | $$  \\ $| $$  \\ $$\n"
                + "| $$  | $| $$$$$$$$  | $$ | $$$$$$$$      | $$     | $$  | $| $$ $$ $| $$ $$ $| $$$$$  | $$        | $$ | $$  | $| $$$$$$$/\n"
                + "| $$  | $| $$__  $$  | $$ | $$__  $$      | $$     | $$  | $| $$  $$$| $$  $$$| $$__/  | $$        | $$ | $$  | $| $$__  $$\n"
                + "| $$  | $| $$  | $$  | $$ | $$  | $$      | $$    $| $$  | $| $$\\  $$| $$\\  $$| $$     | $$    $$  | $$ | $$  | $| $$  \\ $$\n"
                + "| $$$$$$$| $$  | $$  | $$ | $$  | $$      |  $$$$$$|  $$$$$$| $$ \\  $| $$ \\  $| $$$$$$$|  $$$$$$/  | $$ |  $$$$$$| $$  | $$\n"
                + "|_______/|__/  |__/  |__/ |__/  |__/       \\______/ \\______/|__/  \\__|__/  \\__|________/\\______/   |__/  \\______/|__/  |__/\n"
                + "                                                                                                                           \n"
                + "                                                                                                                         ");
    }

    /**
     *
     * @param propFileName
     * @return
     * @throws FileNotFoundException
     */
    public Properties readPropertiesDataConnector(final String propFileName) throws FileNotFoundException, IOException {
        Properties prop = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);) {

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } 

        return prop;
    }
    
    
    public String transformValue(Object value,Class type){
        String valueReturn="";
        
        if(type.equals(Date.class)){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
            valueReturn="'"+format.format((Date)value)+"'";
        }else if(type.equals(String.class)){
            valueReturn="'"+(String)value+"'";        }
        else if(type.equals(int.class)||type.equals(long.class)||type.equals(byte.class)||type.equals(double.class)){
            valueReturn=""+value;
        
        }else{
            valueReturn=value.toString();
        }
        
        return valueReturn;
    
    }
}
