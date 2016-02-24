/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnector.criteria.CriteriaQuery;

/**
 *
 * @author proveedor_hhurtado
 */
public interface CriteriaBuilder {
    Predicate and(Expression param1 ,Expression param2 );
    Predicate and(Predicate... parametros  );
    Predicate or(Expression param1 ,Expression param2);
    Predicate or(Predicate... parametros );
    Predicate getConjuncion();
    Predicate getDiyuncion();
    //Operaciones lo
    Predicate equal(Expression param1,Expression param2);
    Predicate notEqual(Expression param1,Expression param2);
    Predicate mayorQue(Expression param1,Expression param2);
    Predicate mayorIgualQue(Expression param1,Expression param2);
    Predicate menorQue(Expression param1,Expression param2);
    Predicate menorIgualQue(Expression param1,Expression param2);
    Predicate between(Expression param1,Expression param2);
    Predicate isNull(Expression param1,Expression param2);
    Predicate isNotNull(Expression param1,Expression param2);
    Predicate IN(String[] value);
    
    CriteriaQuery createQuery();
    
}
