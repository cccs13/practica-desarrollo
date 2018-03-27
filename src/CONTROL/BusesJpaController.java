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
import modelo.Empleados;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Buses;
import modelo.Gastos;

/**
 *
 * @author luis-
 */
public class BusesJpaController implements Serializable {

    public BusesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Buses buses) {
        if (buses.getEmpleadosCollection() == null) {
            buses.setEmpleadosCollection(new ArrayList<Empleados>());
        }
        if (buses.getGastosCollection() == null) {
            buses.setGastosCollection(new ArrayList<Gastos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Empleados> attachedEmpleadosCollection = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionEmpleadosToAttach : buses.getEmpleadosCollection()) {
                empleadosCollectionEmpleadosToAttach = em.getReference(empleadosCollectionEmpleadosToAttach.getClass(), empleadosCollectionEmpleadosToAttach.getIdempleados());
                attachedEmpleadosCollection.add(empleadosCollectionEmpleadosToAttach);
            }
            buses.setEmpleadosCollection(attachedEmpleadosCollection);
            Collection<Gastos> attachedGastosCollection = new ArrayList<Gastos>();
            for (Gastos gastosCollectionGastosToAttach : buses.getGastosCollection()) {
                gastosCollectionGastosToAttach = em.getReference(gastosCollectionGastosToAttach.getClass(), gastosCollectionGastosToAttach.getIdgastos());
                attachedGastosCollection.add(gastosCollectionGastosToAttach);
            }
            buses.setGastosCollection(attachedGastosCollection);
            em.persist(buses);
            for (Empleados empleadosCollectionEmpleados : buses.getEmpleadosCollection()) {
                Buses oldBusesIdbusesOfEmpleadosCollectionEmpleados = empleadosCollectionEmpleados.getBusesIdbuses();
                empleadosCollectionEmpleados.setBusesIdbuses(buses);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
                if (oldBusesIdbusesOfEmpleadosCollectionEmpleados != null) {
                    oldBusesIdbusesOfEmpleadosCollectionEmpleados.getEmpleadosCollection().remove(empleadosCollectionEmpleados);
                    oldBusesIdbusesOfEmpleadosCollectionEmpleados = em.merge(oldBusesIdbusesOfEmpleadosCollectionEmpleados);
                }
            }
            for (Gastos gastosCollectionGastos : buses.getGastosCollection()) {
                Buses oldIdbusesOfGastosCollectionGastos = gastosCollectionGastos.getIdbuses();
                gastosCollectionGastos.setIdbuses(buses);
                gastosCollectionGastos = em.merge(gastosCollectionGastos);
                if (oldIdbusesOfGastosCollectionGastos != null) {
                    oldIdbusesOfGastosCollectionGastos.getGastosCollection().remove(gastosCollectionGastos);
                    oldIdbusesOfGastosCollectionGastos = em.merge(oldIdbusesOfGastosCollectionGastos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Buses buses) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Buses persistentBuses = em.find(Buses.class, buses.getIdbuses());
            Collection<Empleados> empleadosCollectionOld = persistentBuses.getEmpleadosCollection();
            Collection<Empleados> empleadosCollectionNew = buses.getEmpleadosCollection();
            Collection<Gastos> gastosCollectionOld = persistentBuses.getGastosCollection();
            Collection<Gastos> gastosCollectionNew = buses.getGastosCollection();
            List<String> illegalOrphanMessages = null;
            for (Gastos gastosCollectionOldGastos : gastosCollectionOld) {
                if (!gastosCollectionNew.contains(gastosCollectionOldGastos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Gastos " + gastosCollectionOldGastos + " since its idbuses field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Empleados> attachedEmpleadosCollectionNew = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionNewEmpleadosToAttach : empleadosCollectionNew) {
                empleadosCollectionNewEmpleadosToAttach = em.getReference(empleadosCollectionNewEmpleadosToAttach.getClass(), empleadosCollectionNewEmpleadosToAttach.getIdempleados());
                attachedEmpleadosCollectionNew.add(empleadosCollectionNewEmpleadosToAttach);
            }
            empleadosCollectionNew = attachedEmpleadosCollectionNew;
            buses.setEmpleadosCollection(empleadosCollectionNew);
            Collection<Gastos> attachedGastosCollectionNew = new ArrayList<Gastos>();
            for (Gastos gastosCollectionNewGastosToAttach : gastosCollectionNew) {
                gastosCollectionNewGastosToAttach = em.getReference(gastosCollectionNewGastosToAttach.getClass(), gastosCollectionNewGastosToAttach.getIdgastos());
                attachedGastosCollectionNew.add(gastosCollectionNewGastosToAttach);
            }
            gastosCollectionNew = attachedGastosCollectionNew;
            buses.setGastosCollection(gastosCollectionNew);
            buses = em.merge(buses);
            for (Empleados empleadosCollectionOldEmpleados : empleadosCollectionOld) {
                if (!empleadosCollectionNew.contains(empleadosCollectionOldEmpleados)) {
                    empleadosCollectionOldEmpleados.setBusesIdbuses(null);
                    empleadosCollectionOldEmpleados = em.merge(empleadosCollectionOldEmpleados);
                }
            }
            for (Empleados empleadosCollectionNewEmpleados : empleadosCollectionNew) {
                if (!empleadosCollectionOld.contains(empleadosCollectionNewEmpleados)) {
                    Buses oldBusesIdbusesOfEmpleadosCollectionNewEmpleados = empleadosCollectionNewEmpleados.getBusesIdbuses();
                    empleadosCollectionNewEmpleados.setBusesIdbuses(buses);
                    empleadosCollectionNewEmpleados = em.merge(empleadosCollectionNewEmpleados);
                    if (oldBusesIdbusesOfEmpleadosCollectionNewEmpleados != null && !oldBusesIdbusesOfEmpleadosCollectionNewEmpleados.equals(buses)) {
                        oldBusesIdbusesOfEmpleadosCollectionNewEmpleados.getEmpleadosCollection().remove(empleadosCollectionNewEmpleados);
                        oldBusesIdbusesOfEmpleadosCollectionNewEmpleados = em.merge(oldBusesIdbusesOfEmpleadosCollectionNewEmpleados);
                    }
                }
            }
            for (Gastos gastosCollectionNewGastos : gastosCollectionNew) {
                if (!gastosCollectionOld.contains(gastosCollectionNewGastos)) {
                    Buses oldIdbusesOfGastosCollectionNewGastos = gastosCollectionNewGastos.getIdbuses();
                    gastosCollectionNewGastos.setIdbuses(buses);
                    gastosCollectionNewGastos = em.merge(gastosCollectionNewGastos);
                    if (oldIdbusesOfGastosCollectionNewGastos != null && !oldIdbusesOfGastosCollectionNewGastos.equals(buses)) {
                        oldIdbusesOfGastosCollectionNewGastos.getGastosCollection().remove(gastosCollectionNewGastos);
                        oldIdbusesOfGastosCollectionNewGastos = em.merge(oldIdbusesOfGastosCollectionNewGastos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = buses.getIdbuses();
                if (findBuses(id) == null) {
                    throw new NonexistentEntityException("The buses with id " + id + " no longer exists.");
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
            Buses buses;
            try {
                buses = em.getReference(Buses.class, id);
                buses.getIdbuses();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The buses with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Gastos> gastosCollectionOrphanCheck = buses.getGastosCollection();
            for (Gastos gastosCollectionOrphanCheckGastos : gastosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Buses (" + buses + ") cannot be destroyed since the Gastos " + gastosCollectionOrphanCheckGastos + " in its gastosCollection field has a non-nullable idbuses field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Empleados> empleadosCollection = buses.getEmpleadosCollection();
            for (Empleados empleadosCollectionEmpleados : empleadosCollection) {
                empleadosCollectionEmpleados.setBusesIdbuses(null);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
            }
            em.remove(buses);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Buses> findBusesEntities() {
        return findBusesEntities(true, -1, -1);
    }

    public List<Buses> findBusesEntities(int maxResults, int firstResult) {
        return findBusesEntities(false, maxResults, firstResult);
    }

    private List<Buses> findBusesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Buses.class));
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

    public Buses findBuses(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Buses.class, id);
        } finally {
            em.close();
        }
    }

    public int getBusesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Buses> rt = cq.from(Buses.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
