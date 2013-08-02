/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sigmav.entity.Veiculo;

/**
 *
 * @author fernando
 */
public class DaoVeiculo implements DaoInterface<Veiculo>{
    
    private static Veiculo converteRsParaVeiculo(ResultSet rs) throws SQLException{
        
        Veiculo vTemp = new Veiculo();
        DaoContato dContato = new DaoContato();
        
        fTemp.setId(rs.getLong("id"));
        fTemp.setNome(rs.getString("nome"));
        fTemp.setCnpj(rs.getString("cnpj"));
        fTemp.setEndereco(rs.getString("endereco"));
        fTemp.setContato(dContato.retrieve(rs.getLong("contatoId")));
        fTemp.setGrupos(rs.getString("grupos"));
        fTemp.setComentario(rs.getString("comentario"));        
        
        return fTemp;
    }

    public DaoVeiculo() {
    }
    
    
    //##########################################################################
    @Override
    public void persist(Veiculo fTemp) throws SQLException {
        
        if(fTemp.getId() == 0){
            insert(fTemp);
        }
        else{
            update(fTemp);
        }
    }
    
    //##########################################################################
    
    private void insert(Veiculo fTemp) throws SQLException{
            
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        insert(fTemp, conGer);
        
        conGer.commit();
     
    }
    
    private void insert(Veiculo fTemp, Connection con) throws SQLException{
                
        PreparedStatement pst = con.prepareStatement
                ("INSERT INTO Veiculo (nome, cnpj, endereco, grupos, contatoId, comentario) VALUES (?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
         
        pst.setString(1, fTemp.getNome());
        pst.setString(2, fTemp.getCnpj());
        pst.setString(3, fTemp.getEndereco());
        pst.setString(4, fTemp.getGrupos());
        pst.setString(6, fTemp.getComentario());
                
        if(fTemp.getContato()!= null){
            DaoContato dContato = new DaoContato();
            dContato.persist(fTemp.getContato());
               
            pst.setLong(5, fTemp.getContato().getId());
        }else{
            pst.setObject(5, null);
            /* ou */
            //pst.setNull(4, Types.INTEGER);
        }
        
        pst.execute();
        
        //Atribui a fornecedor na memoria a id que ela recebeu no banco, gambi?
        ResultSet key = pst.getGeneratedKeys();
        key.next();
        fTemp.setId(key.getLong(1));        
        
    }
    
    //##########################################################################
    
    private void update(Veiculo fTemp) throws SQLException{
            
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        update(fTemp, conGer);
        
        conGer.commit();
     
    }
    
    private void update(Veiculo fTemp, Connection con) throws SQLException{
        
        DaoContato dContato = new DaoContato();
        dContato.persist(fTemp.getContato());
        
        PreparedStatement pst = con.prepareStatement
                ("UPDATE Veiculo SET nome = ?, cnpj = ?, endereco = ?, grupos = ?, contatoId = ?, comentario = ? WHERE id = ?");
         
        pst.setString(1, fTemp.getNome());
        pst.setString(2, fTemp.getCnpj());
        pst.setString(3, fTemp.getEndereco());
        pst.setString(4, fTemp.getGrupos());
        pst.setLong(5, fTemp.getContato().getId());
        pst.setString(6, fTemp.getComentario());
                        
        pst.execute();
    }
    
    //##########################################################################
    
    @Override
    public void delete(Veiculo fTemp) throws SQLException {
           
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        delete(fTemp, conGer);
        
        conGer.commit();
     
        
    }
    
    public void delete(Veiculo fTemp, Connection con) throws SQLException {
        DaoContato dContato = new DaoContato();
        dContato.delete(fTemp.getContato());
        
        Statement st = con.createStatement();
        st.execute("DELETE FROM Veiculo WHERE id = "+ fTemp.getId());
    }
    
    //##########################################################################
    
    @Override
    public Veiculo retrieve(long id) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("SELECT * FROM Veiculo WHERE ID = "+ id );
        
        ResultSet rs =  st.getResultSet();
        rs.next();
        
        Veiculo aux = converteRsParaVeiculo(rs);
        return aux;        
    }

    @Override
    public List<Veiculo> list() throws SQLException {
        List<Veiculo> fornecedorLista = new ArrayList();
        
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Veiculo");
        
        while(rs.next()){
            Veiculo aux = converteRsParaVeiculo(rs);
            fornecedorLista.add(aux);
        }
        
        return fornecedorLista;        
    }
    
}
