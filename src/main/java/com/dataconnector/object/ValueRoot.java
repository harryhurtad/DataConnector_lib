/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.object;

import com.dataconnector.commons.metadata.MetadataFieldDataConnector;
import com.dataconnectorcommons.sql.AliasExpression;
import com.dataconnectorcommons.sql.Expression;
import com.dataconnectorcommons.sql.Selection;


/**
 * Clase que representa una tributo de una tabla(Campos)
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public class ValueRoot implements Expression,AliasExpression {

    private final StringBuilder concat;
    private final String aliasTable;
    private  String aliasField="";
    private final String ALIAS_SIMBOLO="AS";
    

    public ValueRoot(String alias, MetadataFieldDataConnector nameField) {
        this.aliasTable = alias;
        concat = new StringBuilder();
        concat.append(alias);
        concat.append(".");
        concat.append(nameField.nameField());
    }

    public String getAliasTable() {
        return aliasTable;
    }

    
    
    public void proccessAlias(){
        concat.append(" ");
        concat.append(ALIAS_SIMBOLO);
        concat.append(" ");
        concat.append(getAlias());
    }
    
    
    @Override
    public String getAlias() {

        return aliasField;
    }

    @Override
    public StringBuilder getSQLTransalte() {
        return concat;
    }

    @Override
    public Selection alias(String value) {
       this.aliasField=value;
       return this;
    }

}
