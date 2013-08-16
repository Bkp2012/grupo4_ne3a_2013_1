/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "Contato")
public class Contato implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "telefoneA", length = 20, nullable = true)
    private String telefoneA;
    
    @Column(name = "telefoneB", length = 20, nullable = true)
    private String telefoneB;
    
    @Column(name = "telefoneC", length = 20, nullable = true)
    private String telefoneC;
    
    @Column(name = "eMail", length = 200, nullable = true)
    private String eMail;
    
    @Column(name = "reponsavel", length = 30, nullable = true)
    private String responsavel;

//------------------------------------------------------------------------------
    
    
    public long getId() {
        return id;
    }

    public String getTelefoneA() {
        return telefoneA;
    }

    public String getTelefoneB() {
        return telefoneB;
    }

    public String getTelefoneC() {
        return telefoneC;
    }

    public String geteMail() {
        return eMail;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }
//------------------------------------------------------------------------------

    
    public void setTelefoneA(String telefoneA) {
        this.telefoneA = telefoneA;
    }

    public void setTelefoneB(String telefoneB) {
        this.telefoneB = telefoneB;
    }

    public void setTelefoneC(String telefoneC) {
        this.telefoneC = telefoneC;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }  
    
//------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", telefoneA=" + telefoneA + ", telefoneB=" + telefoneB + ", telefoneC=" + telefoneC + ", eMail=" + eMail + ", responsavel=" + responsavel + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.telefoneA);
        hash = 79 * hash + Objects.hashCode(this.telefoneB);
        hash = 79 * hash + Objects.hashCode(this.telefoneC);
        hash = 79 * hash + Objects.hashCode(this.eMail);
        hash = 79 * hash + Objects.hashCode(this.responsavel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.telefoneA, other.telefoneA)) {
            return false;
        }
        if (!Objects.equals(this.telefoneB, other.telefoneB)) {
            return false;
        }
        if (!Objects.equals(this.telefoneC, other.telefoneC)) {
            return false;
        }
        if (!Objects.equals(this.eMail, other.eMail)) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
}
