/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materiaxestudiante;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "materiaxestudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiaxestudiante.findAll", query = "SELECT m FROM Materiaxestudiante m")
    , @NamedQuery(name = "Materiaxestudiante.findById", query = "SELECT m FROM Materiaxestudiante m WHERE m.id = :id")
    , @NamedQuery(name = "Materiaxestudiante.findByCedula", query = "SELECT m FROM Materiaxestudiante m WHERE m.cedula = :cedula")
    , @NamedQuery(name = "Materiaxestudiante.findByCodigo", query = "SELECT m FROM Materiaxestudiante m WHERE m.codigo = :codigo")})
public class Materiaxestudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)

    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)

    @Column(name = "codigo")
    private String codigo;

    public Materiaxestudiante() {
    }

    public Materiaxestudiante(Integer id) {
        this.id = id;
    }

    public Materiaxestudiante(Integer id, String cedula, String codigo) {
        this.id = id;
        this.cedula = cedula;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiaxestudiante)) {
            return false;
        }
        Materiaxestudiante other = (Materiaxestudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "materiaxestudiante.Materiaxestudiante[ id=" + id + " ]";
    }
    
}
