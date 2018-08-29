/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao.hbm;

import com.prog111mil.deliveryfast.dao.FormasPagoDao;
import com.prog111mil.deliveryfast.entity.FormasPago;
import com.prog111mil.deliveryfast.entity.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Federico
 */
public class FormasPagoDaoImpl implements FormasPagoDao {

    private final SessionFactory sessionFactory;

    public FormasPagoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<FormasPago> obtenerFormasDePago() {
        List<FormasPago> formas;
        try (Session session = sessionFactory.openSession()) {
            Query q = session.createQuery("from formas_pago", FormasPago.class);
            formas = q.list();
        }
        
        return formas;        
    }
    
}
