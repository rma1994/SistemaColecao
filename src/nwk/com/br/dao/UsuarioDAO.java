/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.dao;

import nwk.com.br.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nwk.com.br.repository.Database;


/**
 *
 * @author Richard Matheus
 */
public class UsuarioDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    //Função para inserir o usuario no banco de dados
    public boolean inserir(Usuario usuario){
        boolean result = false;
        
        String sql = "INSERT INTO Usuario(nome, senha, data)"
                                                + "VALUES('" + usuario.getNome()+ "',"
                                                       + "'" + usuario.getSenha()+ "',"
                                                       + "'" + formatDate.format(usuario.getData() ) + "') ";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Usuario inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Confere se a senha e id do usuario batem e retorna verdadeiro caso esteja tudo ok
    public boolean usuarioValido(Usuario usuario){
        boolean result = false;
        
        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE cod = '" + usuario.getCod () + "'"
                + "AND senha = '" + usuario.getSenha() + "'";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            //Caso o cliente exista, muda o resultado para verdadeiro.
            result = rs.next();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Retorna o nome do cliente que tem o mesmo numero do id
    public int getQuantiaLinhas(){
        int qtd = 0;
        String sql = "SELECT COUNT(*) AS qtd FROM usuario";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            //Caso o cliente exista, muda o resultado para verdadeiro.
            while(rs.next()){
                qtd = rs.getInt("qtd");
            }
            
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return qtd;
    }
    
    //Pega todos os Usuarios cadastrados no banco de dados
    public List<Usuario> getTodosUsuarios(){     
                
        List<Usuario> result = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuario ORDER BY cod";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setCod(rs.getInt("Cod"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setData(rs.getString("Data"));
                
                result.add(usuario);
            }
            
        }catch(Exception e){
            e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    
    //Retorna o nome do usuario que tem o mesmo numero do id
    public Usuario nomeUsuario(Usuario usuario){
        String sql = "SELECT nome "
                + "FROM usuario "
                + "WHERE cod = '" + usuario.getCod () + "'";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            //Caso o cliente exista, muda o resultado para verdadeiro.
            while(rs.next()){
                usuario.setNome(rs.getString("nome"));
            }
            
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return usuario;
    }
    
}
