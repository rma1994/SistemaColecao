/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.PlataformaDAO;
import nwk.com.br.model.Plataforma;

/**
 *
 * @author Richard Matheus
 */
public class PlataformaStru {
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");//formato de data
    
     public DefaultTableModel getTable() {
        
        PlataformaDAO plataformadao = new PlataformaDAO();
        int l = 0;
        
        //PEGA A QUANTIA DE LINHAS DA TABELA
        int max = plataformadao.getQuantiaLinhas();
        
        String[] colunas = new String[]{"ID", "Nome", "Cadastro"};
        String[][] dados = new String[max][3];
        
        //Para cada plataforma em getTodosplataformas, coloque esses dados na tabela
        for (Plataforma plataforma : plataformadao.getTodasPlataformas()){
            dados[l][0] = Integer.toString(plataforma.getCod());
            dados[l][1] = plataforma.getNome();
            dados[l][2] = sdf1.format(plataforma.getData()).toString();
            
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
