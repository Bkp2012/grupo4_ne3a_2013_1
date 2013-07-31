/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *import java.sql.Date;
 * @author fernando
 */
public class Fornecedor implements Serializable{

    private long id;
    private String nome;
    private String cnjp;
    private String endereço;
    private Contato contato;
    private List <String> grupoArea = new ArrayList<>();
    private String comentario;

//------------------------------------------------------------------------------

    
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnjp() {
        return cnjp;
    }

    public String getEndereço() {
        return endereço;
    }

    public Contato getContato() {
        return contato;
    }

    public List getGrupoArea() {
        return grupoArea;
    }

    public String getComentario() {
        return comentario;
    }

    //------------------------------------------------------------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnjp(String cnjp) {
        this.cnjp = cnjp;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setGrupoArea(List grupoArea) {
        this.grupoArea = grupoArea;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.cnjp);
        hash = 29 * hash + Objects.hashCode(this.endereço);
        hash = 29 * hash + Objects.hashCode(this.contato);
        hash = 29 * hash + Objects.hashCode(this.grupoArea);
        hash = 29 * hash + Objects.hashCode(this.comentario);
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cnjp, other.cnjp)) {
            return false;
        }
        if (!Objects.equals(this.endereço, other.endereço)) {
            return false;
        }
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        if (!Objects.equals(this.grupoArea, other.grupoArea)) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nome=" + nome + ", cnjp=" + cnjp + ", endere\u00e7o=" + endereço + ", contato=" + contato + ", grupoArea=" + grupoArea + ", comentario=" + comentario + '}';
    }
    
    
}
