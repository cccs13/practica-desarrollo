/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis-
 */
@Entity
@Table(name = "buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b")
    , @NamedQuery(name = "Buses.findByIdbuses", query = "SELECT b FROM Buses b WHERE b.idbuses = :idbuses")
    , @NamedQuery(name = "Buses.findByPlaca", query = "SELECT b FROM Buses b WHERE b.placa = :placa")
    , @NamedQuery(name = "Buses.findByCapacidadPasajeros", query = "SELECT b FROM Buses b WHERE b.capacidadPasajeros = :capacidadPasajeros")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbuses")
    private Integer idbuses;
    @Column(name = "placa")
    private String placa;
    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;
    @OneToMany(mappedBy = "busesIdbuses")
    private Collection<Empleados> empleadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbuses")
    private Collection<Gastos> gastosCollection;

    public Buses() {
    }

    public Buses(Integer idbuses) {
        this.idbuses = idbuses;
    }

    public Integer getIdbuses() {
        return idbuses;
    }

    public void setIdbuses(Integer idbuses) {
        this.idbuses = idbuses;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(Integer capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @XmlTransient
    public Collection<Gastos> getGastosCollection() {
        return gastosCollection;
    }

    public void setGastosCollection(Collection<Gastos> gastosCollection) {
        this.gastosCollection = gastosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbuses != null ? idbuses.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.idbuses == null && other.idbuses != null) || (this.idbuses != null && !this.idbuses.equals(other.idbuses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Buses[ idbuses=" + idbuses + " ]";
    }
    
}
