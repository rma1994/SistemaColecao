/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.dao;

import nwk.com.br.model.Plataforma;
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
public class PlataformaDAO {
    private Connection conn;
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    //Função para inserir a plataforma no banco de dados
    public boolean inserir(Plataforma plataforma){
        boolean result = false;
        
        String sql = "INSERT INTO plataforma(nome, data)"
                                                + " VALUES('" + plataforma.getNome()+ "',"
                                                       + "'" + formatDate.format(plataforma.getData() ) + "') ";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Plataforma inserido com sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar inserir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Retorna a quantia de linhas da tabela plataforma
    public int getQuantiaLinhas(){
        int qtd = 0;
        String sql = "SELECT COUNT(*) AS qtd FROM plataforma";
        
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
    
    //Pega todos as Plataforma cadastrados no banco de dados
    public List<Plataforma> getTodasPlataformas(){     
                
        List<Plataforma> result = new ArrayList<Plataforma>();
        String sql = "SELECT * FROM Plataforma ORDER BY cod";
        
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
           
            while(rs.next()){
                Plataforma plataforma = new Plataforma();
                
                plataforma.setCod(rs.getInt("Cod"));
                plataforma.setNome(rs.getString("Nome"));
                plataforma.setDataSelect(rs.getString("Data"));
                
                result.add(plataforma);
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
        
        String sql = "SELECT MAX(cod) AS cod FROM plataforma";
        
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
    
    //Atualiza a plataforma ja cadastrao no banco de dados
    public boolean atualizar(Plataforma plataforma){
        boolean result = false;
        
        String sql = "UPDATE plataforma"
                    + " SET nome = '" + plataforma.getNome() + "' "
                + "WHERE cod = '" + plataforma.getCod() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Plataforma Atualizado Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar atualizar (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
    
    //Exclui a plataforma ja cadastrao no banco de dados
    public boolean excluir(Plataforma plataforma){
        boolean result = false;
        
        String sql = "DELETE FROM plataforma "
                + "WHERE cod = '" + plataforma.getCod() + "'";
        try{
            conn = Database.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Plataforma Excluido Com Sucesso!");
            result = true;
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir \n\n(" + this.getClass().getName().toString() + ") - " + e.getMessage()); 
            System.out.println("Erro ao tentar excluir (" + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
        return result;
    }
}
