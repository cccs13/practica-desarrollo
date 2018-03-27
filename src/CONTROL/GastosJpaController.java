/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import CONTROL.exceptions.IllegalOrphanException;
import CONTROL.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Buses;
import modelo.Nomina;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Gastos;

/**
 *
 * @author luis-
 */
public class GastosJpaController implements Serializable {

    public GastosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gastos gastos) {
        if (gastos.getNominaCollection() == null) {
            gastos.setNominaCollection(new ArrayList<Nomina>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Buses idbuses = gastos.getIdbuses();
            if (idbuses != null) {
                idbuses = em.getReference(idbuses.getClass(), idbuses.getIdbuses());
                gastos.setIdbuses(idbuses);
            }
            Collection<Nomina> attachedNominaCollection = new ArrayList<Nomina>();
            for (Nomina nominaCollectionNominaToAttach : gastos.getNominaCollection()) {
                nominaCollectionNominaToAttach = em.getReference(nominaCollectionNominaToAttach.getClass(), nominaCollectionNominaToAttach.getIdnomina());
                attachedNominaCollection.add(nominaCollectionNominaToAttach);
            }
            gastos.setNominaCollection(attachedNominaCollection);
            em.persist(gastos);
            if (idbuses != null) {
                idbuses.getGastosCollection().add(gastos);
                idbuses = em.merge(idbuses);
            }
            for (Nomina nominaCollectionNomina : gastos.getNominaCollection()) {
                Gastos oldGastosIdgastosOfNominaCollectionNomina = nominaCollectionNomina.getGastosIdgastos();
                nominaCollectionNomina.setGastosIdgastos(gastos);
                nominaCollectionNomina = em.merge(nominaCollectionNomina);
                if (oldGastosIdgastosOfNominaCollectionNomina != null) {
                    oldGastosIdgastosOfNominaCollectionNomina.getNominaCollection().remove(nominaCollectionNomina);
                    oldGastosIdgastosOfNominaCollectionNomina = em.merge(oldGastosIdgastosOfNominaCollectionNomina);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gastos gastos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gastos persistentGastos = em.find(Gastos.class, gastos.getIdgastos());
            Buses idbusesOld = persistentGastos.getIdbuses();
            Buses idbusesNew = gastos.getIdbuses();
            Collection<Nomina> nominaCollectionOld = persistentGastos.getNominaCollection();
            Collection<Nomina> nominaCollectionNew = gastos.getNominaCollection();
            List<String> illegalOrphanMessages = null;
            for (Nomina nominaCollectionOldNomina : nominaCollectionOld) {
                if (!nominaCollectionNew.contains(nominaCollectionOldNomina)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nomina " + nominaCollectionOldNomina + " since its gastosIdgastos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idbusesNew != null) {
                idbusesNew = em.getReference(idbusesNew.getClass(), idbusesNew.getIdbuses());
                gastos.setIdbuses(idbusesNew);
            }
            Collection<Nomina> attachedNominaCollectionNew = new ArrayList<Nomina>();
            for (Nomina nominaCollectionNewNominaToAttach : nominaCollectionNew) {
                nominaCollectionNewNominaToAttach = em.getReference(nominaCollectionNewNominaToAttach.getClass(), nominaCollectionNewNominaToAttach.getIdnomina());
                attachedNominaCollectionNew.add(nominaCollectionNewNominaToAttach);
            }
            nominaCollectionNew = attachedNominaCollectionNew;
            gastos.setNominaCollection(nominaCollectionNew);
            gastos = em.merge(gastos);
            if (idbusesOld != null && !idbusesOld.equals(idbusesNew)) {
                idbusesOld.getGastosCollection().remove(gastos);
                idbusesOld = em.merge(idbusesOld);
            }
            if (idbusesNew != null && !idbusesNew.equals(idbusesOld)) {
                idbusesNew.getGastosCollection().add(gastos);
                idbusesNew = em.merge(idbusesNew);
            }
            for (Nomina nominaCollectionNewNomina : nominaCollectionNew) {
                if (!nominaCollectionOld.contains(nominaCollectionNewNomina)) {
                    Gastos oldGastosIdgastosOfNominaCollectionNewNomina = nominaCollectionNewNomina.getGastosIdgastos();
                    nominaCollectionNewNomina.setGastosIdgastos(gastos);
                    nominaCollectionNewNomina = em.merge(nominaCollectionNewNomina);
                    if (oldGastosIdgastosOfNominaCollectionNewNomina != null && !oldGastosIdgastosOfNominaCollectionNewNomina.equals(gastos)) {
                        oldGastosIdgastosOfNominaCollectionNewNomina.getNominaCollection().remove(nominaCollectionNewNomina);
                        oldGastosIdgastosOfNominaCollectionNewNomina = em.merge(oldGastosIdgastosOfNominaCollectionNewNomina);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gastos.getIdgastos();
                if (findGastos(id) == null) {
                    throw new NonexistentEntityException("The gastos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gastos gastos;
            try {
                gastos = em.getReference(Gastos.class, id);
                gastos.getIdgastos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gastos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Nomina> nominaCollectionOrphanCheck = gastos.getNominaCollection();
            for (Nomina nominaCollectionOrphanCheckNomina : nominaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Gastos (" + gastos + ") cannot be destroyed since the Nomina " + nominaCollectionOrphanCheckNomina + " in its nominaCollection field has a non-nullable gastosIdgastos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Buses idbuses = gastos.getIdbuses();
            if (idbuses != null) {
                idbuses.getGastosCollection().remove(gastos);
                idbuses = em.merge(idbuses);
            }
            em.remove(gastos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gastos> findGastosEntities() {
        return findGastosEntities(true, -1, -1);
    }

    public List<Gastos> findGastosEntities(int maxResults, int firstResult) {
        return findGastosEntities(false, maxResults, firstResult);
    }

    private List<Gastos> findGastosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gastos.class));
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

    public Gastos findGastos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gastos.class, id);
        } finally {
            em.close();
        }
    }

    public int getGastosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gastos> rt = cq.from(Gastos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
