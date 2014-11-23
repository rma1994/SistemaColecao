/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.LivroDAO;
import nwk.com.br.model.Livro;

/**
 *
 * @author Richard Matheus
 */
public class LivroStru {
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");//formato de data
    
     public DefaultTableModel getTable() {
        
        LivroDAO livrodao = new LivroDAO();
        int l = 0;
        
        //PEGA A QUANTIA DE LINHAS DA TABELA
        int max = livrodao.getQuantiaLinhas();
        
        String[] colunas = new String[]{"ID", "Nome", "Paginas","Data"};
        String[][] dados = new String[max][16];
        
        //Para cada livro em getTodosLivros, coloque esses dados na tabela
        for (Livro livro : livrodao.getTodosLivros()){
            dados[l][0] = Integer.toString(livro.getCod());
            dados[l][1] = livro.getNome();
            dados[l][2] = livro.getPaginas();
            dados[l][3] = sdf1.format(livro.getData()).toString();
            
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
