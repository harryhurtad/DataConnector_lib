/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.sql;

import com.dataconnectorcommons.sql.Expression;
import com.dataconnector.criteria.AbstractQuery;
import com.dataconnector.criteria.CriteriaQuery;
import com.dataconnector.criteria.SubQuery;
import com.dataconnector.criteria.delete.CommonAbstractDelete;
import com.dataconnector.criteria.insert.CommonAbstractInsert;
import com.dataconnector.criteria.update.CommonAbstractUpdate;
import com.dataconnector.object.ValueExpression;
import com.dataconnector.object.ValueParam;
import com.dataconnector.object.ValueRoot;

/**
 * Clase que permite usar los predicados que conforman una sentencia sql
 *
 * @version $Revision: 1.1.1 (UTF-8)
 * @since build 23/02/2016
 * @author proveedor_hhurtado email: proveedor_hhurtad@ath.com.co
 */
public interface CriteriaBuilder {

    Predicate and(Expression param1, Expression param2);

    Predicate and(Predicate... parametros);
    
    JoinPredicate and(JoinPredicate... parametros);
    JoinPredicate and(JoinPredicate param1, JoinPredicate param2);

    Predicate or(Expression param1, Expression param2);

    Predicate or(Predicate... parametros);
    
    JoinPredicate or(JoinPredicate... parametros);
    JoinPredicate or(JoinPredicate param1, JoinPredicate param2);

    Predicate getConjuncion();

    Predicate getDiyuncion();
    //Operaciones lo

    Predicate equal(Expression param1, Expression param2);

    JoinPredicate equal(ValueRoot param1, ValueRoot param2);

    JoinPredicate equal(ValueRoot param1, Expression param2);
    Predicate notEqual(Expression param1, Expression param2);

    JoinPredicate notEqual(ValueRoot param1, ValueRoot param2);

    Predicate mayorQue(Expression param1, Expression param2);

    JoinPredicate mayorQue(ValueRoot param1, ValueRoot param2);

    Predicate mayorIgualQue(Expression param1, Expression param2);

    JoinPredicate mayorIgualQue(ValueRoot param1, ValueRoot param2);

    Predicate menorQue(Expression param1, Expression param2);

    JoinPredicate menorQue(ValueRoot param1, ValueRoot param2);

    Predicate menorIgualQue(Expression param1, Expression param2);

    JoinPredicate menorIgualQue(ValueRoot param1, ValueRoot param2);

    Predicate between(ValueRoot field, ValueParam param1, ValueParam param2);

    Predicate isNull(Expression param1, Expression param2);

    Predicate isNotNull(Expression param1, Expression param2);

    Predicate IN(ValueRoot field,String[] value);

    <X extends Object> ParameterExpression<X> parameter(Class<X> obj, String nameParam);
    
    SubQuery createSubQuery(Class typeValueReturn);

    ValueExpression value(Class obj, Object element);

    AbstractQuery createQuery(Class paramRetorno);

    CommonAbstractInsert createInserQuery();

    CommonAbstractDelete createDeleterQueryFactory();

    CommonAbstractUpdate createUpdaterQueryFactory();
}
