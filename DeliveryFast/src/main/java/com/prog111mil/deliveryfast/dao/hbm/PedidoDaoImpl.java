/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao.hbm;

import com.prog111mil.deliveryfast.dao.PedidoDao;
import com.prog111mil.deliveryfast.entity.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Familia
 */
public class PedidoDaoImpl implements PedidoDao {

    private final SessionFactory sessionFactory;

    public PedidoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int guardarNuevoPedido(Pedido p) {
        int key = 0;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            if (p.getDireccionOrigen() != null) {
                session.save(p.getDireccionOrigen());
            }
            if (p.getDireccionDestino() != null) {
                session.save(p.getDireccionDestino());
            }
            session.save(p);
            session.getTransaction().commit();
            key = p.getId();
        }
        return key;
    }

}
