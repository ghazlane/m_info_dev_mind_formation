package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Room;
import com.ghazlane.projectweb.web_project_ghazlane.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findAllWindowInBuilding(Long id) {
        String jpql = "select w from Window w where w.room.building.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }
}
