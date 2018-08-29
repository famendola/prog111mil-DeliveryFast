/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog111mil.deliveryfast;

import com.prog111mil.deliveryfast.controller.PedidosController;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author famendola <Federico Améndola>
 */
public class Main {

    public static void main(String[] args) {
            //String url = "jdbc:mysql://localhost:3306/deliveryfast?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // obtiene los valores de hibernate.cfg.xml
            .build();
        SessionFactory sessionFactory = null;    
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory(); 
                
            new PedidosController(sessionFactory).run();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
