/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sigmav.entity.Manutencao;

/**
 *
 * @author fernando
 */
public class DaoManutencao implements DaoInterface<Manutencao>{

    public DaoManutencao() {
    }    
    
    private static Manutencao converteRsParaManutencao(ResultSet rs) throws SQLException{
        
    // private long id;
    // private int quilometragem;
    // private Date dataManutencao;
    // private String descriçao;
    // private float custoManutencao;

        Manutencao mTemp = new Manutencao(); 
        mTemp.setId(rs.getLong("id"));
        mTemp.setQuilometragem(rs.getInt("quilometragem"));
        mTemp.setDataManutencao(rs.getDate("dataManutencao"));
        mTemp.setDescriçao("descricao");
        mTemp.setCustoManutencao(rs.getFloat("custoManutencao"));
                
        return mTemp;
    }
    
    //##########################################################################
    @Override
    public void persist(Manutencao mTemp) throws SQLException {
        
        if(mTemp.getId() == 0){
            insert(mTemp);
        }
        else{
            update(mTemp);
        }
    }

    
    private void insert(Manutencao mTemp) throws SQLException{
        
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        insert(mTemp, conGer);
        
        conGer.commit();
                
    }
    
    //INSERE NA TRANSACTION, DEPENDE DE COMMIT
    private void insert(Manutencao mTemp, Connection con) throws SQLException{
        PreparedStatement pst = con.prepareStatement
                ("INSERT INTO Manutencao (quilometragem, dataManutencao, descricao, custoManutencao) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, mTemp.getQuilometragem());
        // Converte na certeza para data?
        pst.setDate(2, (Date) mTemp.getDataManutencao()); 
        pst.setString(3, mTemp.getDescriçao());
        pst.setFloat(4, mTemp.getCustoManutencao());
                
        pst.execute();
        
        //Atribui a manutencao na memoria a id que ela recebeu no banco, gambi?
        ResultSet key = pst.getGeneratedKeys();
        key.next();
        mTemp.setId(key.getLong(1));        
    }

    
    //##########################################################################
    
    private void update(Manutencao mTemp) throws SQLException{
     
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        update(mTemp, conGer);
        
        conGer.commit();
     
    }
    
    private void update(Manutencao mTemp, Connection con) throws SQLException{
        
        PreparedStatement pst = con.prepareStatement
                ("UPDATE Manutencao SET quilometragem = ?, dataMantutencao = ?, descricao = ?, custoManutencao = ? WHERE id = ?");
        
        pst.setInt(1, mTemp.getQuilometragem());
        pst.setDate(2, (Date) mTemp.getDataManutencao());
        pst.setString(3, mTemp.getDescriçao());
        pst.setFloat(4, mTemp.getCustoManutencao());
        pst.setLong(5, mTemp.getId());
        
        pst.execute();
    }
    
    //##########################################################################
    
    @Override
    public void delete(Manutencao mTemp) throws SQLException {
        
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        delete(mTemp, conGer);
        
        conGer.commit();
     
    }
    
    public void delete(Manutencao mTemp, Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.execute("DELETE FROM Manutencao WHERE id = "+ mTemp.getId());
    }
    
    //##########################################################################
    
    @Override
    public Manutencao retrieve(long id) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("SELECT * FROM Manutencao WHERE ID = "+ id );
        
        ResultSet rs =  st.getResultSet();
        rs.next();
        
        Manutencao aux = converteRsParaManutencao(rs);
        return aux;        
    }

    @Override
    public List<Manutencao> list() throws SQLException {
        List<Manutencao> manutencaoLista = new ArrayList();
        
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Manutencao");
        
        while(rs.next()){
            Manutencao aux = converteRsParaManutencao(rs);
            manutencaoLista.add(aux);
        }
        
        return manutencaoLista;        
    }
    
}