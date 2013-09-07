/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *import java.sql.Date;
 * @author fernando
 */
@Entity
@Table(name = "Fornecedor")
public class Fornecedor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    
    @Column(name = "cnpj", unique = false, length = 14, nullable = false)
    private String cnpj;
    
    @Column(name = "endereco", length = 200, nullable = false)
    private String endereco;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
    private Contato contato = new Contato();    
    
    //@Enumerated(EnumType.STRING)
    //@Column(name = "grupo", length = 20, nullable = false)
    //@OneToMany(cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
    //private List<GrupoENUM> grupos = new ArrayList<>();    
    
    @Column(name = "comentario", length = 200, nullable = false)
    private String comentario;

//------------------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }

    /*
    public List<GrupoENUM> getGrupos() {
        return grupos;
    }
    */
    
    public String getComentario() {
        return comentario;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /*
    public void setGrupos(List<GrupoENUM> grupos) {
        this.grupos = grupos;
    }
    */

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.cnpj);
        hash = 37 * hash + Objects.hashCode(this.endereco);
        hash = 37 * hash + Objects.hashCode(this.contato);
        //hash = 37 * hash + Objects.hashCode(this.grupos);
        hash = 37 * hash + Objects.hashCode(this.comentario);
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
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        
        /*
        if (!Objects.equals(this.contato, other.contato)) {
            retugruporn false;
        }
        
        if (!Objects.equals(this.grupos, other.grupos)) {
            return false;
        }
        */
        
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", contato=" + contato +", comentario=" + comentario + '}';
    }
    
    
}
