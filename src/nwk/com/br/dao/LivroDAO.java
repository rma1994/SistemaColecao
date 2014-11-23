/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.dao;

import nwk.com.br.model.Livro;
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
public class LivroDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    //Função para inserir o livro no banco de dados
    public boolean inserir(Livro livro){
        boolean result = false;
        
        String sql = "INSERT INTO Livro(nome, pagina, dcadastro)"
                                                + " VALUES('" + livro.getNome()+ "',"
                                                       + "'" + livro.getPaginas()+ "',"
                                                       + "'" + formatDate.format(livro.getData() ) + "') ";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Livro inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Retorna o nome do Livro que tem o mesmo numero do id
    public int getQuantiaLinhas(){
        int qtd = 0;
        String sql = "SELECT COUNT(*) AS qtd FROM Livro";
        
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
    public List<Livro> getTodosLivros(){     
                
        List<Livro> result = new ArrayList<Livro>();
        String sql = "SELECT * FROM livro ORDER BY cod";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Livro livro = new Livro();
                
                livro.setCod(rs.getInt("Cod"));
                livro.setNome(rs.getString("Nome"));
                livro.setDataSelect(rs.getString("dcadastro"));
                livro.setPaginas(rs.getString("pagina"));
                
                result.add(livro);
            }
            
        }catch(Exception e){
            e.printStackTrace();  
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return result;
    }
    
    //Retorna o ultimo id cadastrado no programa
    public int getMaxCod(){
        int cod = 0;
        
        String sql = "SELECT MAX(cod) AS cod FROM livro";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                cod = rs.getInt("cod");
            }
            
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar consultar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }         
        return cod;
    }
    
    //Atualiza o livro ja cadastrao no banco de dados
    public boolean atualizar(Livro livro){
        boolean result = false;
        
        String sql = "UPDATE livro"
                    + " SET nome = '" + livro.getNome() + "',"
                    + "pagina = '" + livro.getPaginas() + "' "
                + "WHERE cod = '" + livro.getCod() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Livro Atualizado Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar atualizar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Exclui o usuario ja cadastrao no banco de dados
    public boolean excluir(Livro livro){
        boolean result = false;
        
        String sql = "DELETE FROM livro "
                + "WHERE cod = '" + livro.getCod() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Livro Excluido Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar excluir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
}
