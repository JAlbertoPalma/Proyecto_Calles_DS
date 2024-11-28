/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.callesproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import presentacion.frmInicioSesion;

/**
 *
 * @author Beto_
 */
public class CallesProject {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionBD");
        EntityManager em = emf.createEntityManager();
        frmInicioSesion frmInicioSesion = new frmInicioSesion(em);
        frmInicioSesion.setVisible(true);
    }
}
