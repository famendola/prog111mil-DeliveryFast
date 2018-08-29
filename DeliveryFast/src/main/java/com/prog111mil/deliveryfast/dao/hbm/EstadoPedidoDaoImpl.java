/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao.hbm;

import com.prog111mil.deliveryfast.dao.EstadoPedidoDao;
import com.prog111mil.deliveryfast.entity.EstadoPedido;
import com.prog111mil.deliveryfast.entity.EstadoPedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Familia
 */
public class EstadoPedidoDaoImpl implements EstadoPedidoDao {

    private final SessionFactory sessionFactory;

    public EstadoPedidoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public EstadoPedido obtenerEstado(String estado) {
        EstadoPedido e = null;
        try (Session session = sessionFactory.openSession()) {
            Query q = session.createQuery("from EstadoPedido where estado = :estado", EstadoPedido.class);
            q.setParameter("estado", estado);
            e = (EstadoPedido)q.uniqueResult();
        }
        return e;
    }
    
}
