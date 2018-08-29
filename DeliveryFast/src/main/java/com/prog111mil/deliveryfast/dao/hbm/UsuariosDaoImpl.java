/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.dao.hbm;

import com.prog111mil.deliveryfast.dao.UsuariosDao;
import com.prog111mil.deliveryfast.entity.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Federico
 */
public class UsuariosDaoImpl implements UsuariosDao {
    
    private final SessionFactory sessionFactory;

    public UsuariosDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Usuario buscarPorUsuario(String usuario) {
        Usuario u;
        try (Session session = sessionFactory.openSession()) {
            Query q = session.createQuery("from Usuario where usuario = :user", Usuario.class);
            q.setParameter("user", usuario);
            u = (Usuario)q.uniqueResult();
        }
        
        return u;
    }
}
