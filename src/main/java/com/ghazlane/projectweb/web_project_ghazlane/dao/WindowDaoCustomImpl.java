package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Window;
import com.ghazlane.projectweb.web_project_ghazlane.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public void deleteAllWindowInRoom(Long id) {
        //Query query = em.createNativeQuery("DELETE FROM DEPARTMENT WHERE ID = " + departmentId);
        //  query.executeUpdate();
        String jpql = "delete from Window w where w.room.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }
}
