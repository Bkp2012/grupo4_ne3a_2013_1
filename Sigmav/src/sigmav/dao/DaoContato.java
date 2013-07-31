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
import sigmav.entity.Contato;

/**
 *
 * @author fernando
 */
public class DaoContato implements DaoInterface<Contato>{

//    private long id;
//    private String telefoneA;
//    private String telefoneB;
//    private String telefoneC;
//    private String eMail;
//    private String responsavel;

    private static Contato converteRsParaContato(ResultSet rs) throws SQLException{
        
        Contato cTemp = new Contato(); 
        cTemp.setId(rs.getLong("id"));
        cTemp.setTelefoneA(rs.getString("telefoneA"));
        cTemp.setTelefoneB(rs.getString("telefoneB"));
        cTemp.setTelefoneC(rs.getString("telefoneC"));
        cTemp.seteMail(rs.getString("eMail"));
        cTemp.setResponsavel(rs.getString("responsavel"));
                  
        return cTemp;
    }

    public DaoContato() {
    }
    
    
    //##########################################################################
    @Override
    public void persist(Contato cTemp) throws SQLException {
        
        if(cTemp.getId() == 0){
            insert(cTemp);
        }
        else{
            update(cTemp);
        }
    }
    
    private void insert(Contato cTemp) throws SQLException{
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("INSERT INTO Contato (telefoneA, telefoneB, telefoneC, eMail, responsavel) VALUES (?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, cTemp.getTelefoneA());
        pst.setString(2, cTemp.getTelefoneB());
        pst.setString(3, cTemp.getTelefoneC());
        pst.setString(4, cTemp.geteMail());
        pst.setString(5, cTemp.getResponsavel());
        
        pst.execute();
        
        //Atribui a contato na memoria a id que ela recebeu no banco, gambi?
        ResultSet key = pst.getGeneratedKeys();
        key.next();
        cTemp.setId(key.getLong(1));        
    }
    
    private void update(Contato cTemp) throws SQLException{
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("UPDATE Contato SET telefoneA = ?, telefoneB = ?, telefoneC = ?, eMail = ?, responsavel = ? WHERE id = ?");
        
        pst.setString(1, cTemp.getTelefoneA());
        pst.setString(2, cTemp.getTelefoneB());
        pst.setString(3, cTemp.getTelefoneC());
        pst.setString(4, cTemp.geteMail());
        pst.setString(5, cTemp.getResponsavel());
        
        pst.execute();
    }
    //##########################################################################
    @Override
    public void delete(Contato cTemp) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("DELETE FROM Contato WHERE id = "+ cTemp.getId());
    }
    //##########################################################################
    @Override
    public Contato retrieve(long id) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("SELECT * FROM Contato WHERE ID = "+ id );
        
        ResultSet rs =  st.getResultSet();
        rs.next();
        
        Contato aux = converteRsParaContato(rs);
        return aux;        
    }

    @Override
    public List<Contato> list() throws SQLException {
        List<Contato> contatoLista = new ArrayList();
        
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Contato");
        
        while(rs.next()){
            Contato aux = converteRsParaContato(rs);
            contatoLista.add(aux);
        }
        
        return contatoLista;        
    }
    
}