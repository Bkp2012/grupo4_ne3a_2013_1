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
import sigmav.entity.Fornecedor;

/**
 *
 * @author fernando
 */
public class DaoFornecedor implements DaoInterface<Fornecedor>{

    private static Fornecedor converteRsParaFornecedor(ResultSet rs) throws SQLException{
        
        Fornecedor fTemp = new Fornecedor();
        
        
    private long id;
    private String nome;
    private String cnjp;
    private String endereço;
    private Contato contato;
    private List <String> grupoArea = new ArrayList<>();
    private String comentario;
        cTemp.setId(rs.getLong("id"));
        cTemp.setTelefoneA(rs.getString("telefoneA"));
        cTemp.setTelefoneB(rs.getString("telefoneB"));
        cTemp.setTelefoneC(rs.getString("telefoneC"));
        cTemp.seteMail(rs.getString("eMail"));
        cTemp.setResponsavel(rs.getString("responsavel"));
                  
        return fTemp;
    }

    public DaoFornecedor() {
    }
    
    
    //##########################################################################
    @Override
    public void persist(Fornecedor fTemp) throws SQLException {
        
        if(fTemp.getId() == 0){
            insert(fTemp);
        }
        else{
            update(fTemp);
        }
    }
    
    private void insert(Fornecedor fTemp) throws SQLException{
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("INSERT INTO Fornecedor (telefoneA, telefoneB, telefoneC, eMail, responsavel) VALUES (?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, cTemp.getTelefoneA());
        pst.setString(2, cTemp.getTelefoneB());
        pst.setString(3, cTemp.getTelefoneC());
        pst.setString(4, cTemp.geteMail());
        pst.setString(5, cTemp.getResponsavel());
        
        pst.execute();
        
        //Atribui a fornecedor na memoria a id que ela recebeu no banco, gambi?
        ResultSet key = pst.getGeneratedKeys();
        key.next();
        fTemp.setId(key.getLong(1));        
    }
    
    private void update(Fornecedor fTemp) throws SQLException{
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("UPDATE Fornecedor SET telefoneA = ?, telefoneB = ?, telefoneC = ?, eMail = ?, responsavel = ? WHERE id = ?");
        
        pst.setString(1, cTemp.getTelefoneA());
        pst.setString(2, cTemp.getTelefoneB());
        pst.setString(3, cTemp.getTelefoneC());
        pst.setString(4, cTemp.geteMail());
        pst.setString(5, cTemp.getResponsavel());
        
        pst.execute();
    }
    //##########################################################################
    @Override
    public void delete(Fornecedor fTemp) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("DELETE FROM Fornecedor WHERE id = "+ fTemp.getId());
    }
    //##########################################################################
    @Override
    public Fornecedor retrieve(long id) throws SQLException {
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        st.execute("SELECT * FROM Fornecedor WHERE ID = "+ id );
        
        ResultSet rs =  st.getResultSet();
        rs.next();
        
        Fornecedor aux = converteRsParaFornecedor(rs);
        return aux;        
    }

    @Override
    public List<Fornecedor> list() throws SQLException {
        List<Fornecedor> fornecedorLista = new ArrayList();
        
        Statement st = ConnectionFactory.preparedConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Fornecedor");
        
        while(rs.next()){
            Fornecedor aux = converteRsParaFornecedor(rs);
            fornecedorLista.add(aux);
        }
        
        return fornecedorLista;        
    }
    
}