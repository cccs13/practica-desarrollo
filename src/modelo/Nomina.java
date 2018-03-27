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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nomina.findAll", query = "SELECT n FROM Nomina n")
    , @NamedQuery(name = "Nomina.findByIdnomina", query = "SELECT n FROM Nomina n WHERE n.idnomina = :idnomina")})
public class Nomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnomina")
    private Integer idnomina;
    @JoinColumn(name = "gastos_idgastos", referencedColumnName = "idgastos")
    @ManyToOne(optional = false)
    private Gastos gastosIdgastos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnomina")
    private Collection<Empleados> empleadosCollection;

    public Nomina() {
    }

    public Nomina(Integer idnomina) {
        this.idnomina = idnomina;
    }

    public Integer getIdnomina() {
        return idnomina;
    }

    public void setIdnomina(Integer idnomina) {
        this.idnomina = idnomina;
    }

    public Gastos getGastosIdgastos() {
        return gastosIdgastos;
    }

    public void setGastosIdgastos(Gastos gastosIdgastos) {
        this.gastosIdgastos = gastosIdgastos;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnomina != null ? idnomina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nomina)) {
            return false;
        }
        Nomina other = (Nomina) object;
        if ((this.idnomina == null && other.idnomina != null) || (this.idnomina != null && !this.idnomina.equals(other.idnomina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Nomina[ idnomina=" + idnomina + " ]";
    }
    
}
