/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class Peca implements Serializable{
    
    private long id;
    private String descricao;
    private String codigoReferencia;
    private String grupo;

//------------------------------------------------------------------------------

    
    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public String getGrupo() {
        return grupo;
    }

//------------------------------------------------------------------------------

    
    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

//------------------------------------------------------------------------------

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.codigoReferencia);
        hash = 89 * hash + Objects.hashCode(this.grupo);
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
        final Peca other = (Peca) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.codigoReferencia, other.codigoReferencia)) {
            return false;
        }
        if (this.grupo != other.grupo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Peca{" + "id=" + id + ", descricao=" + descricao + ", codigoReferencia=" + codigoReferencia + ", grupo=" + grupo + '}';
    }
    
    
//------------------------------------------------------------------------------    

}
