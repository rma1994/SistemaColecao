/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.dao;

import nwk.com.br.model.Jogo;
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
public class JogoDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    //Função para inserir o jogo no banco de dados
    public boolean inserir(Jogo jogo){
        boolean result = false;
        
        String sql = "INSERT INTO jogo(nome, plataforma, data)"
                                                + " VALUES('" + jogo.getNome()+ "',"
                                                       + "'" + jogo.getPlataforma() + "',"
                                                       + "'" + formatDate.format(jogo.getData() ) + "') ";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Jogo inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    
    //Retorna a quantia de linhas da tabela jogo
    public int getQuantiaLinhas(){
        int qtd = 0;
        String sql = "SELECT COUNT(*) AS qtd FROM jogo";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
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
    
    //Pega todos os jogos cadastrados no banco de dados
    public List<Jogo> getTodosJogos(){     
                
        List<Jogo> result = new ArrayList<Jogo>();
        String sql = "SELECT * FROM Jogo ORDER BY cod";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Jogo jogo = new Jogo();
                
                jogo.setCod(rs.getInt("Cod"));
                jogo.setNome(rs.getString("Nome"));
                jogo.setDataSelect(rs.getString("Data"));
                jogo.setPlataforma(rs.getString("plataforma"));
                
                result.add(jogo);
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
        
        String sql = "SELECT MAX(cod) AS cod FROM jogo";
        
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
    
    //Atualiza o jogo ja cadastrao no banco de dados
    public boolean atualizar(Jogo jogo){
        boolean result = false;
        
        String sql = "UPDATE jogo"
                    + " SET nome = '" + jogo.getNome() + "',"
                    + "plataforma = '" + jogo.getPlataforma() + "' "
                + "WHERE cod = '" + jogo.getCod() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Jogo Atualizado Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar atualizar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Exclui o jogo ja cadastrao no banco de dados
    public boolean excluir(Jogo jogo){
        boolean result = false;
        
        String sql = "DELETE FROM jogo "
                + "WHERE cod = '" + jogo.getCod() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Jogo Excluido Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar excluir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
}
