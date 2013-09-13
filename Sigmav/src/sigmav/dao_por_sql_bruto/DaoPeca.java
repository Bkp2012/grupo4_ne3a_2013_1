/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sigmav.entity.GrupoENUM;
import sigmav.entity.Peca;

/**
 *
 * @author fernando
 */
public class DaoPeca implements DaoInterface<Peca>{

    public DaoPeca() {
    }    
    
    private static Peca converteRsParaPeca(ResultSet rs) throws SQLException{
        
        Peca pTemp = new Peca();
        pTemp.setId(rs.getLong("id"));
        pTemp.setDescricao(rs.getString("descricao"));
        pTemp.setGrupo(GrupoENUM.valueOf(rs.getString("grupo")));
        pTemp.setCodigoReferencia(rs.getString("codigoReferencia"));
        
        return pTemp;
    }
    
    //##########################################################################
    @Override
    public void persist(Peca pTemp) throws SQLException {
        
        if(pTemp.getId() == 0){
            insert(pTemp);
        }
        else{
            update(pTemp);
        }
    }
    
    private void insert(Peca pTemp) throws SQLException{
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("INSERT INTO Peca (descricao, codigoReferencia, grupo) VALUES (?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, pTemp.getDescricao());
        pst.setString(2, pTemp.getCodigoReferencia());
        pst.setString(3, pTemp.getGrupo().name());
                
        pst.execute();
        
        //Atribui a peca na memoria a id que ela recebeu no banco, gambi?
        ResultSet key = pst.getGeneratedKeys();
        key.next();
        pTemp.setId(key.getLong(1));        
    }
    
    private void update(Peca pTemp) throws SQLException{
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("UPDATE Peca SET descricao = ?, codigoReferencia = ?, grupo = ? WHERE id = ?");
        
        pst.setString(1, pTemp.getDescricao());
        pst.setString(2, pTemp.getCodigoReferencia());
        pst.setString(3, pTemp.getGrupo().name());
        pst.setLong(4, pTemp.getId());
        
        pst.execute();
    }
    //##########################################################################
    @Override
    public void delete(Peca pTemp) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("DELETE FROM Peca WHERE id = "+ pTemp.getId());
    }
    //##########################################################################
    @Override
    public Peca retrieve(long id) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("SELECT * FROM Peca WHERE ID = "+ id );
        
        ResultSet rs =  st.getResultSet();
        rs.next();
        
        Peca aux = converteRsParaPeca(rs);
        return aux;        
    }

    @Override
    public List<Peca> list() throws SQLException {
        List<Peca> pecas = new ArrayList();
        
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Peca");
        
        while(rs.next()){
            Peca aux = converteRsParaPeca(rs);
            pecas.add(aux);
        }
        
        return pecas;        
    }
    
    public List<Peca> buscaCodigo(String chave) throws SQLException {
        List<Peca> pecas = new ArrayList();
                
        //Statement st = ConnectionFactory.preparedConnection().createStatement();
        //ResultSet rs = st.executeQuery("SELECT * FROM Peca WHERE codigoReferencia = %"+chave+"%");
        
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("SELECT * FROM Peca WHERE codigoReferencia LIKE ?");
        pst.setString(1, "%"+chave+"%");
        
        System.out.println(pst.toString());
        ResultSet rs;
        rs = pst.executeQuery();
        
        while(rs.next()){
            Peca aux = converteRsParaPeca(rs);
            pecas.add(aux);
        }
        
        return pecas;
    }
    
    public List<Peca> buscaDescricao(String chave) throws SQLException{
        List<Peca> pecas = new ArrayList();
        
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("SELECT * FROM Peca WHERE descricao LIKE ?");
        pst.setString(1, "%"+chave+"%");
        
        System.out.println(pst.toString());
        ResultSet rs;
        rs = pst.executeQuery();
        
        while(rs.next()){
            Peca aux = converteRsParaPeca(rs);
            pecas.add(aux);
        }
        
        return pecas;
    }
}