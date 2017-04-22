/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumah;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naga
 */
@Entity
@Table(name = "tarifkamar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifkamar.findAll", query = "SELECT t FROM Tarifkamar t"),
    @NamedQuery(name = "Tarifkamar.findByKodekamar", query = "SELECT t FROM Tarifkamar t WHERE t.kodekamar = :kodekamar"),
    @NamedQuery(name = "Tarifkamar.findByKelaskamar", query = "SELECT t FROM Tarifkamar t WHERE t.kelaskamar = :kelaskamar"),
    @NamedQuery(name = "Tarifkamar.findByTarifkamar", query = "SELECT t FROM Tarifkamar t WHERE t.tarifkamar = :tarifkamar")})
public class Tarifkamar implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kodekamar")
    private String kodekamar;
    @Column(name = "kelaskamar")
    private String kelaskamar;
    @Column(name = "tarifkamar")
    private Integer tarifkamar;

    public Tarifkamar() {
    }

    public Tarifkamar(String kodekamar) {
        this.kodekamar = kodekamar;
    }

    public String getKodekamar() {
        return kodekamar;
    }

    public void setKodekamar(String kodekamar) {
        String oldKodekamar = this.kodekamar;
        this.kodekamar = kodekamar;
        changeSupport.firePropertyChange("kodekamar", oldKodekamar, kodekamar);
    }

    public String getKelaskamar() {
        return kelaskamar;
    }

    public void setKelaskamar(String kelaskamar) {
        String oldKelaskamar = this.kelaskamar;
        this.kelaskamar = kelaskamar;
        changeSupport.firePropertyChange("kelaskamar", oldKelaskamar, kelaskamar);
    }

    public Integer getTarifkamar() {
        return tarifkamar;
    }

    public void setTarifkamar(Integer tarifkamar) {
        Integer oldTarifkamar = this.tarifkamar;
        this.tarifkamar = tarifkamar;
        changeSupport.firePropertyChange("tarifkamar", oldTarifkamar, tarifkamar);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodekamar != null ? kodekamar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifkamar)) {
            return false;
        }
        Tarifkamar other = (Tarifkamar) object;
        if ((this.kodekamar == null && other.kodekamar != null) || (this.kodekamar != null && !this.kodekamar.equals(other.kodekamar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rumah.Tarifkamar[ kodekamar=" + kodekamar + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
