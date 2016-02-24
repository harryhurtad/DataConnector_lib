/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataconnector.criteria;

import com.dataconnector.sql.Predicate;
import com.dataconnector.sql.Root;
import com.dataconnector.sql.Selection;
import java.util.List;

/**
 *
 * @author proveedor_hhurtado
 */
public interface CriteriaQuery {

    CriteriaQuery select(Selection... params);

    CriteriaQuery where(Predicate... params);

    CriteriaQuery from(List<Root> entities);
}
