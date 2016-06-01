/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.helper;

import com.dataconnector.helper.DataConnectorHelper;
import com.dataconnector.constans.ProvidersSupportEnum;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 26/04/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public class DataConnectorConWrap {

    private final String driverName;
    private final DataSource datasource;
    private static final String FILE_NAME_PROPERTIES_DATACONNECTOR = "conf/dataconnector.properties";
    private final ProvidersSupportEnum provider;
    private String driverNameDatasource;

    public DataConnectorConWrap(String driverName, DataSource datasource, ProvidersSupportEnum provider) {
        this.driverName = driverName;
        this.datasource = datasource;
        this.provider = provider;
        Properties prop;
        try {
            prop = DataConnectorHelper.getInstance().readPropertiesDataConnector(FILE_NAME_PROPERTIES_DATACONNECTOR);
            driverNameDatasource = prop.getProperty("driver_datasource");
        } catch (IOException ex) {
            Logger.getLogger(DataConnectorConWrap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("empty-statement")
    public Connection getConnection() {
        Connection con = null;

        try {
            Properties prop = DataConnectorHelper.getInstance().readPropertiesDataConnector(FILE_NAME_PROPERTIES_DATACONNECTOR);
            if (driverName != null) {
                String url = prop.getProperty("url");
                String dbUser = prop.getProperty("dbUser");;
                String dbPassword = prop.getProperty("dbPassword");
                Class.forName(driverName);
                con = DriverManager.getConnection(url,
                        dbUser,
                        dbPassword);

                //   con=driver.connect(null, null)
            } else if (datasource != null) {
                con = datasource.getConnection();
                //  driverName=provider.toString();
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(DataConnectorConWrap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public ProvidersSupportEnum getProvider() {
        return provider;
    }

    public String getDriverName() {
        return driverName == null ? driverNameDatasource : driverName;
    }

}
