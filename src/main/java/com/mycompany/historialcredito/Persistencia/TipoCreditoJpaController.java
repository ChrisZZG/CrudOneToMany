/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.historialcredito.Persistencia;

import com.mycompany.historialcredito.Logica.TipoCredito;
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
public class TipoCreditoJpaController implements Serializable {

    public TipoCreditoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TipoCreditoJpaController(){
        emf = Persistence.createEntityManagerFactory("historialCrediticio");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoCredito tipoCredito) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoCredito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoCredito tipoCredito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoCredito = em.merge(tipoCredito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoCredito.getId();
                if (findTipoCredito(id) == null) {
                    throw new NonexistentEntityException("The tipoCredito with id " + id + " no longer exists.");
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
            TipoCredito tipoCredito;
            try {
                tipoCredito = em.getReference(TipoCredito.class, id);
                tipoCredito.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoCredito with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoCredito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoCredito> findTipoCreditoEntities() {
        return findTipoCreditoEntities(true, -1, -1);
    }

    public List<TipoCredito> findTipoCreditoEntities(int maxResults, int firstResult) {
        return findTipoCreditoEntities(false, maxResults, firstResult);
    }

    private List<TipoCredito> findTipoCreditoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoCredito.class));
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

    public TipoCredito findTipoCredito(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoCredito.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCreditoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoCredito> rt = cq.from(TipoCredito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
