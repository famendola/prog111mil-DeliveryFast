/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast.controller;

import com.prog111mil.deliveryfast.dao.EstadoPedidoDao;
import com.prog111mil.deliveryfast.dao.FormaPagoDao;
import com.prog111mil.deliveryfast.dao.PedidoDao;
import com.prog111mil.deliveryfast.dao.UsuariosDao;
import com.prog111mil.deliveryfast.dao.hbm.EstadoPedidoDaoImpl;
import com.prog111mil.deliveryfast.dao.hbm.FormaPagoDaoImpl;
import com.prog111mil.deliveryfast.dao.hbm.PedidoDaoImpl;
import com.prog111mil.deliveryfast.dao.hbm.UsuariosDaoImpl;
import com.prog111mil.deliveryfast.entity.Direccion;
import com.prog111mil.deliveryfast.entity.EstadoPedido;
import com.prog111mil.deliveryfast.entity.Usuario;
import com.prog111mil.deliveryfast.entity.FormaPago;
import com.prog111mil.deliveryfast.entity.Pedido;
import com.prog111mil.deliveryfast.ui.Login;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Federico
 */
public class PedidosController {
    private final SessionFactory sessionFactory;
    
    private final UsuariosDao usuariosDao;
    private final FormaPagoDao formasPagoDao;
    private final PedidoDao pedidoDao;
    private final EstadoPedidoDao estadoPedidoDao;

    /**
     * Constructor por defecto.
     * @param sessionFactory
     */
    public PedidosController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        this.usuariosDao = new UsuariosDaoImpl(sessionFactory);
        this.formasPagoDao = new FormaPagoDaoImpl(sessionFactory);
        this.pedidoDao = new PedidoDaoImpl(sessionFactory);
        this.estadoPedidoDao = new EstadoPedidoDaoImpl(sessionFactory);
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        return this.usuariosDao.buscarPorUsuario(nombreUsuario);
    }
    public void run () {
        new Login(this).setVisible(true);
    }
    
    public double obtenerComision(Usuario usuario) {
        //Puede depender de la localidad del usuario.
        return 35;
    }
    
    public List<FormaPago> obtenerFormasDePago() {
        return this.formasPagoDao.obtenerFormasDePago();
    }
    
    public EstadoPedido obtenerEstado(String estado) {
        return this.estadoPedidoDao.obtenerEstado(estado);
    }
    public String agregarPedido(Pedido p) {
        String mensaje = null;
        try {
            int key = pedidoDao.guardarNuevoPedido(p);
            mensaje = "Pedido registrado correctamente.";
            mensaje += " Recuerdo el siguiente número de seguimiento para controlar el estado del mismo: " + String.valueOf(key);
        } catch (Exception ex) {
            mensaje = ex.toString();
        }
        return mensaje;
    }

    public String validarDireccionesUsuario(Usuario usuario, Direccion origen, Direccion destino) {
        //Verifica que las direcciones estén dentro de la localidad del usuario.
        return null;
    }
}
