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
import sigmav.entity.Consumo;
import sigmav.entity.Manutencao;
import sigmav.entity.Veiculo;

/**
 *
 * @author fernando
 */
public class DaoVeiculo implements DaoInterface<Veiculo>{
    
    private static Veiculo converteRsParaVeiculo(ResultSet rs) throws SQLException{
        
        //private long id;
        //private List<Manutencao> manutencoes = new ArrayList<>();
        //private List<Consumo> consumo = new ArrayList<>();
        //private float mediaConsumo;
        //private String marca;
        //private String modelo;
        //private String versao;
        //private String combustivel;
        //private String anoModelo;
        //private String responsavel;

        Veiculo vTemp = new Veiculo();
        DaoManutencao dManutencao = new DaoManutencao();
        DaoConsumo dConsumo = new DaoConsumo();
        
        vTemp.setId(rs.getLong("id"));
        vTemp.setMediaConsumo(rs.getFloat("mediaConsumo"));
        vTemp.setMarca(rs.getString("marca"));
        vTemp.setModelo(rs.getString("modelo"));
        vTemp.setVersao(rs.getString("versao"));
        vTemp.setCombustivel(rs.getString("combustivel"));
        vTemp.setAnoModelo(rs.getString("anoModelo"));
        vTemp.setResponsavel(rs.getString("responsavel"));
        
        //Chama o DManutencao e manda ele buscar uma lista delas por id do veiculo
        //Joga esta lista na lista de manutencoes do veiculo
        vTemp.setManutencoes(dManutencao.retrieveHistorico(rs.getLong("id")));
        vTemp.setConsumo(dConsumo.retrieveHistorico(rs.getLong("id")));
                
        return vTemp;
    }

    public DaoVeiculo() {
    }
    
    
    //##########################################################################
    @Override
    public void persist(Veiculo vTemp) throws SQLException {
        
        if(vTemp.getId() == 0){
            insert(vTemp);
        }
        else{
            update(vTemp);
        }
    }
    
    //##########################################################################
    
    private void insert(Veiculo vTemp) throws SQLException{
            
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        insert(vTemp, conGer);
        
        conGer.commit();
     
    }
    
    private void insert(Veiculo vTemp, Connection con) throws SQLException{
                
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
