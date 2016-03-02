/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.object;

import com.dataconnector.sql.Expression;

/**
 * Clase que representa una tributo de una tabla(Campos)
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public class ValueRoot implements Expression {

    private final StringBuilder concat;
    private final String alias;

    public ValueRoot(String alias, String nameTable) {
        this.alias = alias;
        concat = new StringBuilder();
        concat.append(alias);
        concat.append(".");
        concat.append(nameTable);
    }

    @Override
    public String getAlias() {

        return alias;
    }

    @Override
    public StringBuilder getSQLTransalte() {
        return concat;
    }

}
