package com.ghazlane.projectweb.web_project_ghazlane.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void deleteAllHeaterInRoom(Long id) {
        String jpql = "delete from Heater h where h.room.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }
}
