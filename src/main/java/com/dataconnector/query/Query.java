/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.query;

import com.dataconnector.annotation.DataConnectorPOJO;
import com.dataconnector.exceptions.DataConnectorResultException;
import com.dataconnector.object.TemporalTypeEnum;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author proveedor_hhurtado
 * @param <X>
 */
public interface Query<X extends Object> {

    Query setParameter(String name, Object value);

    public Query setParameter(String name, Calendar value, TemporalTypeEnum temporalType);

    X getSingleResult();

    List<X> getResultList() throws DataConnectorResultException;

    void setMaxResult(int result);
     void excuteMultiThread(boolean value);
     void setNumeroRegistrosHilo(int value);
    
    Map<String,Object> getMapParameters();
}
