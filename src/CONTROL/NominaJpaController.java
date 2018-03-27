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
import modelo.Gastos;
import modelo.Empleados;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Nomina;

/**
 *
 * @author luis-
 */
public class NominaJpaController implements Serializable {

    public NominaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nomina nomina) {
        if (nomina.getEmpleadosCollection() == null) {
            nomina.setEmpleadosCollection(new ArrayList<Empleados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gastos gastosIdgastos = nomina.getGastosIdgastos();
            if (gastosIdgastos != null) {
                gastosIdgastos = em.getReference(gastosIdgastos.getClass(), gastosIdgastos.getIdgastos());
                nomina.setGastosIdgastos(gastosIdgastos);
            }
            Collection<Empleados> attachedEmpleadosCollection = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionEmpleadosToAttach : nomina.getEmpleadosCollection()) {
                empleadosCollectionEmpleadosToAttach = em.getReference(empleadosCollectionEmpleadosToAttach.getClass(), empleadosCollectionEmpleadosToAttach.getIdempleados());
                attachedEmpleadosCollection.add(empleadosCollectionEmpleadosToAttach);
            }
            nomina.setEmpleadosCollection(attachedEmpleadosCollection);
            em.persist(nomina);
            if (gastosIdgastos != null) {
                gastosIdgastos.getNominaCollection().add(nomina);
                gastosIdgastos = em.merge(gastosIdgastos);
            }
            for (Empleados empleadosCollectionEmpleados : nomina.getEmpleadosCollection()) {
                Nomina oldIdnominaOfEmpleadosCollectionEmpleados = empleadosCollectionEmpleados.getIdnomina();
                empleadosCollectionEmpleados.setIdnomina(nomina);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
                if (oldIdnominaOfEmpleadosCollectionEmpleados != null) {
                    oldIdnominaOfEmpleadosCollectionEmpleados.getEmpleadosCollection().remove(empleadosCollectionEmpleados);
                    oldIdnominaOfEmpleadosCollectionEmpleados = em.merge(oldIdnominaOfEmpleadosCollectionEmpleados);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nomina nomina) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nomina persistentNomina = em.find(Nomina.class, nomina.getIdnomina());
            Gastos gastosIdgastosOld = persistentNomina.getGastosIdgastos();
            Gastos gastosIdgastosNew = nomina.getGastosIdgastos();
            Collection<Empleados> empleadosCollectionOld = persistentNomina.getEmpleadosCollection();
            Collection<Empleados> empleadosCollectionNew = nomina.getEmpleadosCollection();
            List<String> illegalOrphanMessages = null;
            for (Empleados empleadosCollectionOldEmpleados : empleadosCollectionOld) {
                if (!empleadosCollectionNew.contains(empleadosCollectionOldEmpleados)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empleados " + empleadosCollectionOldEmpleados + " since its idnomina field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (gastosIdgastosNew != null) {
                gastosIdgastosNew = em.getReference(gastosIdgastosNew.getClass(), gastosIdgastosNew.getIdgastos());
                nomina.setGastosIdgastos(gastosIdgastosNew);
            }
            Collection<Empleados> attachedEmpleadosCollectionNew = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionNewEmpleadosToAttach : empleadosCollectionNew) {
                empleadosCollectionNewEmpleadosToAttach = em.getReference(empleadosCollectionNewEmpleadosToAttach.getClass(), empleadosCollectionNewEmpleadosToAttach.getIdempleados());
                attachedEmpleadosCollectionNew.add(empleadosCollectionNewEmpleadosToAttach);
            }
            empleadosCollectionNew = attachedEmpleadosCollectionNew;
            nomina.setEmpleadosCollection(empleadosCollectionNew);
            nomina = em.merge(nomina);
            if (gastosIdgastosOld != null && !gastosIdgastosOld.equals(gastosIdgastosNew)) {
                gastosIdgastosOld.getNominaCollection().remove(nomina);
                gastosIdgastosOld = em.merge(gastosIdgastosOld);
            }
            if (gastosIdgastosNew != null && !gastosIdgastosNew.equals(gastosIdgastosOld)) {
                gastosIdgastosNew.getNominaCollection().add(nomina);
                gastosIdgastosNew = em.merge(gastosIdgastosNew);
            }
            for (Empleados empleadosCollectionNewEmpleados : empleadosCollectionNew) {
                if (!empleadosCollectionOld.contains(empleadosCollectionNewEmpleados)) {
                    Nomina oldIdnominaOfEmpleadosCollectionNewEmpleados = empleadosCollectionNewEmpleados.getIdnomina();
                    empleadosCollectionNewEmpleados.setIdnomina(nomina);
                    empleadosCollectionNewEmpleados = em.merge(empleadosCollectionNewEmpleados);
                    if (oldIdnominaOfEmpleadosCollectionNewEmpleados != null && !oldIdnominaOfEmpleadosCollectionNewEmpleados.equals(nomina)) {
                        oldIdnominaOfEmpleadosCollectionNewEmpleados.getEmpleadosCollection().remove(empleadosCollectionNewEmpleados);
                        oldIdnominaOfEmpleadosCollectionNewEmpleados = em.merge(oldIdnominaOfEmpleadosCollectionNewEmpleados);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nomina.getIdnomina();
                if (findNomina(id) == null) {
                    throw new NonexistentEntityException("The nomina with id " + id + " no longer exists.");
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
            Nomina nomina;
            try {
                nomina = em.getReference(Nomina.class, id);
                nomina.getIdnomina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nomina with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Empleados> empleadosCollectionOrphanCheck = nomina.getEmpleadosCollection();
            for (Empleados empleadosCollectionOrphanCheckEmpleados : empleadosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nomina (" + nomina + ") cannot be destroyed since the Empleados " + empleadosCollectionOrphanCheckEmpleados + " in its empleadosCollection field has a non-nullable idnomina field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Gastos gastosIdgastos = nomina.getGastosIdgastos();
            if (gastosIdgastos != null) {
                gastosIdgastos.getNominaCollection().remove(nomina);
                gastosIdgastos = em.merge(gastosIdgastos);
            }
            em.remove(nomina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nomina> findNominaEntities() {
        return findNominaEntities(true, -1, -1);
    }

    public List<Nomina> findNominaEntities(int maxResults, int firstResult) {
        return findNominaEntities(false, maxResults, firstResult);
    }

    private List<Nomina> findNominaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nomina.class));
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

    public Nomina findNomina(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nomina.class, id);
        } finally {
            em.close();
        }
    }

    public int getNominaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nomina> rt = cq.from(Nomina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
