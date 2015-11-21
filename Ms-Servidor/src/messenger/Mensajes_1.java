/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author yamil
 */
@Entity
@Table(name = "MENSAJES", catalog = "", schema = "CHAT")
@NamedQueries({
    @NamedQuery(name = "Mensajes_1.findAll", query = "SELECT m FROM Mensajes_1 m"),
    @NamedQuery(name = "Mensajes_1.findByNumero", query = "SELECT m FROM Mensajes_1 m WHERE m.numero = :numero"),
    @NamedQuery(name = "Mensajes_1.findByTexto", query = "SELECT m FROM Mensajes_1 m WHERE m.texto = :texto"),
    @NamedQuery(name = "Mensajes_1.findByUsuario", query = "SELECT m FROM Mensajes_1 m WHERE m.usuario = :usuario"),
    @NamedQuery(name = "Mensajes_1.findByTiempo", query = "SELECT m FROM Mensajes_1 m WHERE m.tiempo = :tiempo")})
public class Mensajes_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Integer numero;
    @Basic(optional = false)
    @Column(name = "TEXTO")
    private String texto;
    @Basic(optional = false)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "TIEMPO")
    @Temporal(TemporalType.TIME)
    private Date tiempo;

    public Mensajes_1() {
    }

    public Mensajes_1(Integer numero) {
        this.numero = numero;
    }

    public Mensajes_1(Integer numero, String texto, String usuario, Date tiempo) {
        this.numero = numero;
        this.texto = texto;
        this.usuario = usuario;
        this.tiempo = tiempo;
    }
    
    public Mensajes_1(String texto, String usuario, Date tiempo) {
        this.texto = texto;
        this.usuario = usuario;
        this.tiempo = tiempo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        Integer oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        String oldTexto = this.texto;
        this.texto = texto;
        changeSupport.firePropertyChange("texto", oldTexto, texto);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        String oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        Date oldTiempo = this.tiempo;
        this.tiempo = tiempo;
        changeSupport.firePropertyChange("tiempo", oldTiempo, tiempo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes_1)) {
            return false;
        }
        Mensajes_1 other = (Mensajes_1) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "messenger.Mensajes_1[ numero=" + numero + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
