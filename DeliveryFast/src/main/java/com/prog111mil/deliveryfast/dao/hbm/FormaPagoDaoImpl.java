/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao.hbm;

import com.prog111mil.deliveryfast.entity.FormaPago;
import com.prog111mil.deliveryfast.entity.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.prog111mil.deliveryfast.dao.FormaPagoDao;

/**
 *
 * @author Federico
 */
public class FormaPagoDaoImpl implements FormaPagoDao {

    private final SessionFactory sessionFactory;

    public FormaPagoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<FormaPago> obtenerFormasDePago() {
        List<FormaPago> formas;
        try (Session session = sessionFactory.openSession()) {
            Query q = session.createQuery("from FormaPago", FormaPago.class);
            formas = q.list();
        }
        return formas;        
    }
    
}
