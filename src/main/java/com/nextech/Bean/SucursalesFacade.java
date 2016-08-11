/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextech.Bean;

import com.nextech.entities.Sucursales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose_Gascon
 */
@Stateless
public class SucursalesFacade extends AbstractFacade<Sucursales> {
    @PersistenceContext(unitName = "com.nextech_WebEramir1.0_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalesFacade() {
        super(Sucursales.class);
    }
    
}
