/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class Consumo {
    
    private long id;
    private Date dataAbastecimento;
    private int quilometragem;
    private float litros;
    private float preco;
    private String combustivel;
    private Fornecedor local;

    public long getId() {
        return id;
    }

    public Date getDataAbastecimento() {
        return dataAbastecimento;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public float getLitros() {
        return litros;
    }

    public float getPreco() {
        return preco;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public Fornecedor getLocal() {
        return local;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataAbastecimento(Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setLocal(Fornecedor local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Consumo{" + "id=" + id + ", dataAbastecimento=" + dataAbastecimento + ", quilometragem=" + quilometragem + ", litros=" + litros + ", preco=" + preco + ", combustivel=" + combustivel + ", local=" + local + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.dataAbastecimento);
        hash = 61 * hash + this.quilometragem;
        hash = 61 * hash + Float.floatToIntBits(this.litros);
        hash = 61 * hash + Float.floatToIntBits(this.preco);
        hash = 61 * hash + Objects.hashCode(this.combustivel);
        hash = 61 * hash + Objects.hashCode(this.local);
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
        final Consumo other = (Consumo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dataAbastecimento, other.dataAbastecimento)) {
            return false;
        }
        if (this.quilometragem != other.quilometragem) {
            return false;
        }
        if (this.litros != other.litros) {
            return false;
        }
        if (Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.combustivel, other.combustivel)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }

    
}
