/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnector.commons.metadata.MetadataFieldDataConnector;
import com.dataconnectorcommons.sql.Expression;
import com.dataconnector.object.JoinsTypeEnum;
import com.dataconnector.object.ValueRoot;
import java.util.List;

/**
 *
 * @author proveedor_hhurtado
 */
public interface Root extends Expression {
    ValueRoot get(MetadataFieldDataConnector nombreParametro);
    Join joinTable(String nameTableJoin,JoinsTypeEnum typeJoin); 
    String getNombreTabla();
    List<Join> getListJoins();
   
}
