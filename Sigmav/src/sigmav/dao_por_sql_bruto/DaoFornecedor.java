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
import sigmav.entity.Fornecedor;

/**
 *
 * @author fernando
 */
public class DaoFornecedor implements DaoInterface<Fornecedor>{
    
    //private long id;
    //private String nome;
    //private String cnpj; 
    //private String endereco;
    //private Contato contato;
    //private String grupos;
    
    //private String comentario;
    
    private static Fornecedor converteRsParaFornecedor(ResultSet rs) throws SQLException{
        
        Fornecedor fTemp = new Fornecedor();
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
    
    //##########################################################################
    
    private void insert(Fornecedor fTemp) throws SQLException{
            
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        insert(fTemp, conGer);
        
        conGer.commit();
     
    }
    
    private void insert(Fornecedor fTemp, Connection con) throws SQLException{
                
        PreparedStatement pst = con.prepareStatement
                ("INSERT INTO Fornecedor (nome, cnpj, endereco, grupos, contatoId, comentario) VALUES (?,?,?,?,?,?)",
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
    
    private void update(Fornecedor fTemp) throws SQLException{
            
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        update(fTemp, conGer);
        
        conGer.commit();
     
    }
    
    private void update(Fornecedor fTemp, Connection con) throws SQLException{
        
        DaoContato dContato = new DaoContato();
        dContato.persist(fTemp.getContato());
        
        PreparedStatement pst = con.prepareStatement
                ("UPDATE Fornecedor SET nome = ?, cnpj = ?, endereco = ?, grupos = ?, contatoId = ?, comentario = ? WHERE id = ?");
         
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
    public void delete(Fornecedor fTemp) throws SQLException {
           
        Connection conGer = ConnectionFactory.preparedConnectionTransaction();
        delete(fTemp, conGer);
        
        conGer.commit();
     
        
    }
    
    public void delete(Fornecedor fTemp, Connection con) throws SQLException {
        DaoContato dContato = new DaoContato();
        dContato.delete(fTemp.getContato());
        
        Statement st = con.createStatement();
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
    
    public List<Fornecedor> buscaNome(String chave) throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList();
                
        //Statement st = ConnectionFactory.preparedConnection().createStatement();
        //ResultSet rs = st.executeQuery("SELECT * FROM Peca WHERE codigoReferencia = %"+chave+"%");
        
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("SELECT * FROM Fornecedor WHERE nome LIKE ?");
        pst.setString(1, "%"+chave+"%");
        
        System.out.println(pst.toString());
        ResultSet rs;
        rs = pst.executeQuery();
        
        while(rs.next()){
            Fornecedor aux = converteRsParaFornecedor(rs);
            fornecedores.add(aux);
        }
        
        return fornecedores;
    }
    
    public List<Fornecedor> buscaGrupo(String chave) throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList();
                
        //Statement st = ConnectionFactory.preparedConnection().createStatement();
        //ResultSet rs = st.executeQuery("SELECT * FROM Peca WHERE codigoReferencia = %"+chave+"%");
        
        PreparedStatement pst = ConnectionFactory.preparedConnection().prepareStatement
                ("SELECT * FROM Fornecedor WHERE grupos LIKE ?");
        pst.setString(1, "%"+chave+"%");
        
        System.out.println(pst.toString());
        ResultSet rs;
        rs = pst.executeQuery();
        
        while(rs.next()){
            Fornecedor aux = converteRsParaFornecedor(rs);
            fornecedores.add(aux);
        }
        
        return fornecedores;
    }
}