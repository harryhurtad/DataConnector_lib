/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.object;

/**
 * Enum que representa los tipos de Joins posibles a realizar en sql
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public enum JoinsTypeEnum {
    INNER_JOIN("INNER"),RIGTH_JOIN("RIGTH"),LEFT_JOIN("LEFT");
     private final String nameElement;

    private JoinsTypeEnum(String nameElement) {
        this.nameElement = nameElement;
    }

    public String getNameElement() {
        return nameElement;
    }
     
     
}
