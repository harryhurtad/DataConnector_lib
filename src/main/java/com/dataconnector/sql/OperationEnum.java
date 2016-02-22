/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

/**
 *
 * @author proveedor_hhurtado
 */
public enum OperationEnum {

    AND("AND"), OR("OR"), EQUALS("="), NOTEQUALS("=!"), MAYORQUE(">"),
    MENORQUE("<"), MAYOR_IGUAL_QUE(">="), MENOR_IGUAL_QUE("<="),
    BETWEEN("BETWEEN"), IS_NULL("NULL"), IS_NOT_NULL("NOT NULL"), IN("IN");

    private final String simboloOper;

    private OperationEnum(String simbolo) {
        this.simboloOper = simbolo;
    }

    @SuppressWarnings("empty-statement")
    
    
    public static String getSimboloOper(OperationEnum constantes) {
        String simbolo = null;
        switch (constantes) {
            case AND:
                simbolo = AND.simboloOper;
                break;
            case OR:
                simbolo = OR.simboloOper;
                break;
            case EQUALS:

                simbolo = EQUALS.simboloOper;
                break;
            case NOTEQUALS:

                simbolo = NOTEQUALS.simboloOper;
                break;

            case MAYORQUE:

                simbolo = MAYORQUE.simboloOper;
                break;

            case MENORQUE:

                simbolo = MENORQUE.simboloOper;
                break;
            case MAYOR_IGUAL_QUE:

                simbolo = MAYOR_IGUAL_QUE.simboloOper;
                break;
            case BETWEEN:

                simbolo = BETWEEN.simboloOper;
                break;
            case IS_NULL:

                simbolo = IS_NULL.simboloOper;
                break;

            case IS_NOT_NULL:

                simbolo = IS_NOT_NULL.simboloOper;
                break;
            case IN:

                simbolo = IN.simboloOper;
                break;
        };
        return simbolo;
    }

}
