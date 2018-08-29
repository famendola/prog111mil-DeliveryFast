/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao;

import com.prog111mil.deliveryfast.entity.Pedido;

/**
 *
 * @author Familia
 */
public interface PedidoDao {
    int guardarNuevoPedido(Pedido p);
}
