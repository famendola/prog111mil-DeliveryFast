/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao;

import com.prog111mil.deliveryfast.entity.FormasPago;
import java.util.List;


/**
 *
 * @author Federico
 */
public interface FormasPagoDao {
    List<FormasPago> obtenerFormasDePago();
}
