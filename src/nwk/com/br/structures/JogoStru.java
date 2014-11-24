/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.JogoDAO;
import nwk.com.br.model.Jogo;

/**
 *
 * @author Richard Matheus
 */
public class JogoStru {
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");//formato de data
    
     public DefaultTableModel getTable() {
        
        JogoDAO jogodao = new JogoDAO();
        int l = 0;
        
        //PEGA A QUANTIA DE LINHAS DA TABELA
        int max = jogodao.getQuantiaLinhas();
        
        String[] colunas = new String[]{"ID", "Nome", "Cadastro","Plataforma"};
        String[][] dados = new String[max][16];
        
        //Para cada usuario em getTodosUsuarios, coloque esses dados na tabela
        for (Jogo jogo : jogodao.getTodosJogos()){
            dados[l][0] = Integer.toString(jogo.getCod());
            dados[l][1] = jogo.getNome();
            dados[l][2] = sdf1.format(jogo.getData()).toString();
            dados[l][3] = jogo.getPlataforma();
            
            l++;
        }
       
    
    //Linhas não editaveis.
    DefaultTableModel model = new DefaultTableModel(dados , colunas ){
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    
    
    //Retorna o modelo gerado aqui
    return model;
    }
}
