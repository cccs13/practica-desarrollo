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
@Table(name = "gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g")
    , @NamedQuery(name = "Gastos.findByIdgastos", query = "SELECT g FROM Gastos g WHERE g.idgastos = :idgastos")
    , @NamedQuery(name = "Gastos.findByDescripcion", query = "SELECT g FROM Gastos g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "Gastos.findByValor", query = "SELECT g FROM Gastos g WHERE g.valor = :valor")})
public class Gastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgastos")
    private Integer idgastos;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gastosIdgastos")
    private Collection<Nomina> nominaCollection;
    @JoinColumn(name = "idbuses", referencedColumnName = "idbuses")
    @ManyToOne(optional = false)
    private Buses idbuses;

    public Gastos() {
    }

    public Gastos(Integer idgastos) {
        this.idgastos = idgastos;
    }

    public Gastos(Integer idgastos, String descripcion, double valor) {
        this.idgastos = idgastos;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Integer getIdgastos() {
        return idgastos;
    }

    public void setIdgastos(Integer idgastos) {
        this.idgastos = idgastos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Nomina> getNominaCollection() {
        return nominaCollection;
    }

    public void setNominaCollection(Collection<Nomina> nominaCollection) {
        this.nominaCollection = nominaCollection;
    }

    public Buses getIdbuses() {
        return idbuses;
    }

    public void setIdbuses(Buses idbuses) {
        this.idbuses = idbuses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgastos != null ? idgastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.idgastos == null && other.idgastos != null) || (this.idgastos != null && !this.idgastos.equals(other.idgastos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Gastos[ idgastos=" + idgastos + " ]";
    }
    
}
