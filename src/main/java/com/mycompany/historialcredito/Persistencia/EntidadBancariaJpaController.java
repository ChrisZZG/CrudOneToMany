/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.historialcredito.Persistencia;

import com.mycompany.historialcredito.Logica.EntidadBancaria;
import com.mycompany.historialcredito.Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author EQUIPO
 */
public class EntidadBancariaJpaController implements Serializable {

    public EntidadBancariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntidadBancariaJpaController(){
        emf = Persistence.createEntityManagerFactory("historialCrediticio");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EntidadBancaria entidadBancaria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entidadBancaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EntidadBancaria entidadBancaria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entidadBancaria = em.merge(entidadBancaria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = entidadBancaria.getId();
                if (findEntidadBancaria(id) == null) {
                    throw new NonexistentEntityException("The entidadBancaria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EntidadBancaria entidadBancaria;
            try {
                entidadBancaria = em.getReference(EntidadBancaria.class, id);
                entidadBancaria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entidadBancaria with id " + id + " no longer exists.", enfe);
            }
            em.remove(entidadBancaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EntidadBancaria> findEntidadBancariaEntities() {
        return findEntidadBancariaEntities(true, -1, -1);
    }

    public List<EntidadBancaria> findEntidadBancariaEntities(int maxResults, int firstResult) {
        return findEntidadBancariaEntities(false, maxResults, firstResult);
    }

    private List<EntidadBancaria> findEntidadBancariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EntidadBancaria.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EntidadBancaria findEntidadBancaria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EntidadBancaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntidadBancariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EntidadBancaria> rt = cq.from(EntidadBancaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
