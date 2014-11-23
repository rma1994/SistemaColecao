/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.structures;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import nwk.com.br.dao.UsuarioDAO;
import nwk.com.br.model.Usuario;

/**
 *
 * @author Richard Matheus
 */
public class UsuarioStru {
    private SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");//formato de data
    
     public DefaultTableModel getTable() {
        
        UsuarioDAO usuariodao = new UsuarioDAO();
        int l = 0;
        
        //PEGA A QUANTIA DE LINHAS DA TABELA
        int max = usuariodao.getQuantiaLinhas();
        
        String[] colunas = new String[]{"ID", "Nome", "Cadastro","Senha"};
        String[][] dados = new String[max][16];
        
        //Para cada usuario em getTodosUsuarios, coloque esses dados na tabela
        for (Usuario usuario : usuariodao.getTodosUsuarios()){
            dados[l][0] = Integer.toString(usuario.getCod());
            dados[l][1] = usuario.getNome();
            dados[l][2] = sdf1.format(usuario.getData()).toString();
            dados[l][3] = usuario.getSenha();
            
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
