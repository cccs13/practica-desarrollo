/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis-
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByIdbuses", query = "SELECT f FROM Factura f WHERE f.idbuses = :idbuses")
    , @NamedQuery(name = "Factura.findByIdcliente", query = "SELECT f FROM Factura f WHERE f.idcliente = :idcliente")
    , @NamedQuery(name = "Factura.findByPrecio", query = "SELECT f FROM Factura f WHERE f.precio = :precio")
    , @NamedQuery(name = "Factura.findByFechahora", query = "SELECT f FROM Factura f WHERE f.fechahora = :fechahora")
    , @NamedQuery(name = "Factura.findByDestino", query = "SELECT f FROM Factura f WHERE f.destino = :destino")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Basic(optional = false)
    @Column(name = "idbuses")
    private int idbuses;
    @Basic(optional = false)
    @Column(name = "idcliente")
    private int idcliente;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "fechahora")
    private String fechahora;
    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(Integer idfactura, int idbuses, int idcliente, String destino) {
        this.idfactura = idfactura;
        this.idbuses = idbuses;
        this.idcliente = idcliente;
        this.destino = destino;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdbuses() {
        return idbuses;
    }

    public void setIdbuses(int idbuses) {
        this.idbuses = idbuses;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
