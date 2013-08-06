/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class Manutencao implements Serializable{
    
    private long id;
    private int quilometragem;
    private Date dataManutencao;
    private String descriçao;
    private float custoManutencao;
    private long idVeiculo;

    public void setId(long id) {
        this.id = id;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }

    public void setCustoManutencao(float custoManutencao) {
        this.custoManutencao = custoManutencao;
    }

    public void setIdVeiculo(long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }


    public long getId() {
        return id;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public float getCustoManutencao() {
        return custoManutencao;
    }

    public long getIdVeiculo() {
        return idVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + this.quilometragem;
        hash = 67 * hash + Objects.hashCode(this.dataManutencao);
        hash = 67 * hash + Objects.hashCode(this.descriçao);
        hash = 67 * hash + Float.floatToIntBits(this.custoManutencao);
        hash = 67 * hash + (int) (this.idVeiculo ^ (this.idVeiculo >>> 32));
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
        final Manutencao other = (Manutencao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quilometragem != other.quilometragem) {
            return false;
        }
        if (!Objects.equals(this.dataManutencao, other.dataManutencao)) {
            return false;
        }
        if (!Objects.equals(this.descriçao, other.descriçao)) {
            return false;
        }
        if (Float.floatToIntBits(this.custoManutencao) != Float.floatToIntBits(other.custoManutencao)) {
            return false;
        }
        if (this.idVeiculo != other.idVeiculo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Manutencao{" + "id=" + id + ", quilometragem=" + quilometragem + ", dataManutencao=" + dataManutencao + ", descri\u00e7ao=" + descriçao + ", custoManutencao=" + custoManutencao + ", idVeiculo=" + idVeiculo + '}';
    }
    
    
}
