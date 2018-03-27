/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import CONTROL.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Buses;
import modelo.Cargo;
import modelo.Empleados;
import modelo.Nomina;

/**
 *
 * @author luis-
 */
public class EmpleadosJpaController implements Serializable {

    public EmpleadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleados empleados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Buses busesIdbuses = empleados.getBusesIdbuses();
            if (busesIdbuses != null) {
                busesIdbuses = em.getReference(busesIdbuses.getClass(), busesIdbuses.getIdbuses());
                empleados.setBusesIdbuses(busesIdbuses);
            }
            Cargo idcargo = empleados.getIdcargo();
            if (idcargo != null) {
                idcargo = em.getReference(idcargo.getClass(), idcargo.getIdcargo());
                empleados.setIdcargo(idcargo);
            }
            Nomina idnomina = empleados.getIdnomina();
            if (idnomina != null) {
                idnomina = em.getReference(idnomina.getClass(), idnomina.getIdnomina());
                empleados.setIdnomina(idnomina);
            }
            em.persist(empleados);
            if (busesIdbuses != null) {
                busesIdbuses.getEmpleadosCollection().add(empleados);
                busesIdbuses = em.merge(busesIdbuses);
            }
            if (idcargo != null) {
                idcargo.getEmpleadosCollection().add(empleados);
                idcargo = em.merge(idcargo);
            }
            if (idnomina != null) {
                idnomina.getEmpleadosCollection().add(empleados);
                idnomina = em.merge(idnomina);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getIdempleados());
            Buses busesIdbusesOld = persistentEmpleados.getBusesIdbuses();
            Buses busesIdbusesNew = empleados.getBusesIdbuses();
            Cargo idcargoOld = persistentEmpleados.getIdcargo();
            Cargo idcargoNew = empleados.getIdcargo();
            Nomina idnominaOld = persistentEmpleados.getIdnomina();
            Nomina idnominaNew = empleados.getIdnomina();
            if (busesIdbusesNew != null) {
                busesIdbusesNew = em.getReference(busesIdbusesNew.getClass(), busesIdbusesNew.getIdbuses());
                empleados.setBusesIdbuses(busesIdbusesNew);
            }
            if (idcargoNew != null) {
                idcargoNew = em.getReference(idcargoNew.getClass(), idcargoNew.getIdcargo());
                empleados.setIdcargo(idcargoNew);
            }
            if (idnominaNew != null) {
                idnominaNew = em.getReference(idnominaNew.getClass(), idnominaNew.getIdnomina());
                empleados.setIdnomina(idnominaNew);
            }
            empleados = em.merge(empleados);
            if (busesIdbusesOld != null && !busesIdbusesOld.equals(busesIdbusesNew)) {
                busesIdbusesOld.getEmpleadosCollection().remove(empleados);
                busesIdbusesOld = em.merge(busesIdbusesOld);
            }
            if (busesIdbusesNew != null && !busesIdbusesNew.equals(busesIdbusesOld)) {
                busesIdbusesNew.getEmpleadosCollection().add(empleados);
                busesIdbusesNew = em.merge(busesIdbusesNew);
            }
            if (idcargoOld != null && !idcargoOld.equals(idcargoNew)) {
                idcargoOld.getEmpleadosCollection().remove(empleados);
                idcargoOld = em.merge(idcargoOld);
            }
            if (idcargoNew != null && !idcargoNew.equals(idcargoOld)) {
                idcargoNew.getEmpleadosCollection().add(empleados);
                idcargoNew = em.merge(idcargoNew);
            }
            if (idnominaOld != null && !idnominaOld.equals(idnominaNew)) {
                idnominaOld.getEmpleadosCollection().remove(empleados);
                idnominaOld = em.merge(idnominaOld);
            }
            if (idnominaNew != null && !idnominaNew.equals(idnominaOld)) {
                idnominaNew.getEmpleadosCollection().add(empleados);
                idnominaNew = em.merge(idnominaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleados.getIdempleados();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getIdempleados();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            Buses busesIdbuses = empleados.getBusesIdbuses();
            if (busesIdbuses != null) {
                busesIdbuses.getEmpleadosCollection().remove(empleados);
                busesIdbuses = em.merge(busesIdbuses);
            }
            Cargo idcargo = empleados.getIdcargo();
            if (idcargo != null) {
                idcargo.getEmpleadosCollection().remove(empleados);
                idcargo = em.merge(idcargo);
            }
            Nomina idnomina = empleados.getIdnomina();
            if (idnomina != null) {
                idnomina.getEmpleadosCollection().remove(empleados);
                idnomina = em.merge(idnomina);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
