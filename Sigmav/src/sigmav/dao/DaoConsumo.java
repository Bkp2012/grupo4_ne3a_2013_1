/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sigmav.entity.Consumo;


/**
 *
 * @author fernando
 */
public class DaoConsumo implements DaoInterface<Consumo>{
    
    //private long id;
    //private Date dataAbastecimento;
    //private int quilometragem;
    //private int litros;
    //private float preco;
    //private String combustivel;
    //private Fornecedor local;
        
    private static Consumo converteRsParaConsumo(ResultSet rs) throws SQLException{
         
        DaoFornecedor dFornecedor = new DaoFornecedor();
        
        Consumo cTemp = new Consumo(); 
        cTemp.setId(rs.getLong("id"));
        cTemp.setDataAbastecimento(rs.getDate("dataAbastecimento"));
        cTemp.setQuilometragem(rs.getInt("quilometragem"));
        cTemp.setLitros(rs.getInt("litros"));
        cTemp.setPreco(rs.getFloat("preco"));
        cTemp.setCombustivel(rs.getString("combustivel"));
        cTemp.setLocal(dFornecedor.retrieve(rs.getLong("fornecedorId")));
                  
        return cTemp;
    }

    public DaoConsumo() {
    }
    
    
    //##########################################################################
    @Override
    public void persist(Consumo cTemp) throws SQLException {
        
        if(cTemp.getId() == 0){
            insert(cTemp);
        }
        else{
            update(cTemp);
        }
    }
    
    //##########################################################################

    private void insert(Consumo cTemp) throws SQLException{
        
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        insert(cTemp, conGer);
        
        conGer.commit();
    
    }
    
    private void insert(Consumo cTemp, Connection con) throws SQLException{
        
        PreparedStatement pst = con.prepareStatement
                ("INSERT INTO Consumo (dataAbastecimento, quilometragem, litros, preco, combustivel, localId) VALUES (?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        // id, dataAbastecimento, quilometragem, litros, preco, combustivel, local    
        pst.setDate(1, (Date)cTemp.getDataAbastecimento());
        pst.setInt(2, cTemp.getQuilometragem());
        pst.setFloat(3, cTemp.getLitros());
        pst.setFloat(4, cTemp.getPreco());
        pst.setString(5, cTemp.getCombustivel());
        
        if(cTemp.getLocal()!= null){
            DaoFornecedor dFornecedor = new DaoFornecedor();
            dFornecedor.persist(cTemp.getLocal());
               
            pst.setLong(6, cTemp.getLocal().getId());
        }else{
            pst.setObject(6, null);
            /* ou */
            //pst.setNull(4, Types.INTEGER);
        }
        
        pst.execute();
        
        //Atribui a contato na memoria a id que ela recebeu no banco, gambi?
        ResultSet key = pst.getGeneratedKeys();
        key.next();
        cTemp.setId(key.getLong(1));        
    }
    
    //##########################################################################
    
    private void update(Consumo cTemp) throws SQLException{
        
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        update(cTemp, conGer);
        
        conGer.commit();
    
    }
    
    private void update(Consumo cTemp, Connection con) throws SQLException{
        
        PreparedStatement pst = con.prepareStatement
                ("UPDATE Consumo SET dataAbastecimento =?, quilometragem = ?, litros = ?, preco = ?, combustivel = ?, localId = ? WHERE id = ?");
        // id, dataAbastecimento, quilometragem, litros, preco, combustivel, local    
        pst.setDate(1, (Date)cTemp.getDataAbastecimento());
        pst.setInt(2, cTemp.getQuilometragem());
        pst.setFloat(3, cTemp.getLitros());
        pst.setFloat(4, cTemp.getPreco());
        pst.setString(5, cTemp.getCombustivel());
        
        if(cTemp.getLocal()!= null){
            DaoFornecedor dFornecedor = new DaoFornecedor();
            dFornecedor.persist(cTemp.getLocal());
               
            pst.setLong(6, cTemp.getLocal().getId());
        }else{
            pst.setObject(6, null);
            /* ou */
            //pst.setNull(4, Types.INTEGER);
        }
        
        pst.execute();
    }
    
    //##########################################################################
    
    @Override
    public void delete(Consumo cTemp) throws SQLException {
    
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        delete(cTemp, conGer);
        
        conGer.commit();
        
    }
    
    public void delete(Consumo cTemp, Connection con) throws SQLException {
        
        Statement st = con.createStatement();
        st.execute("DELETE FROM Consumo WHERE id = "+ cTemp.getId());
    
    }
    
    //##########################################################################
    
    @Override
    public Consumo retrieve(long id) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("SELECT * FROM Consumo WHERE ID = "+ id );
        
        ResultSet rs =  st.getResultSet();
        rs.next();
        
        Consumo aux = converteRsParaConsumo(rs);
        return aux;        
    }

    @Override
    public List<Consumo> list() throws SQLException {
        List<Consumo> contatoLista = new ArrayList();
        
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Consumo");
        
        while(rs.next()){
            Consumo aux = converteRsParaConsumo(rs);
            contatoLista.add(aux);
        }
        
        return contatoLista;        
    }
    
}
