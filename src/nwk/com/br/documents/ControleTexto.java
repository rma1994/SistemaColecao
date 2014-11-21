/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nwk.com.br.documents;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Richard Matheus
 */
public class ControleTexto extends PlainDocument{
    Character chs[] = {'\'','\"'}; //Coloque aqui todos os caracteres válidos  
    Set<Character> validos = new HashSet<Character>(Arrays.asList(chs));  
    
    private int iMaxLength;  
   
    //Construtor que obriga uma entrada do tamanho do campo de textos
    public ControleTexto(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
    
    @Override  
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{  
        if (str == null) return;  
  
        if (iMaxLength <= 0){        // aceitara qualquer no. de caracteres  
            StringBuilder inserted = setCaracInvaliEMaiusc(str);
            
            super.insertString(offs, inserted.toString(), a);
            return;  
        }  

        int ilen = (getLength() + str.length());  
        if (ilen <= iMaxLength){    // se o comprimento final for menor...
            StringBuilder inserted = setCaracInvaliEMaiusc(str);
            
            super.insertString(offs, inserted.toString(), a);
        }
        
        else{  
            if (getLength() == iMaxLength) return; // nada a fazer  
            String newStr = str.substring(0, (iMaxLength - getLength()));  
            
            StringBuilder inserted = setCaracInvaliEMaiusc(newStr);
            super.insertString(offs, inserted.toString(), a);
        }  
       
    }
    
    
    //Chega a existencia de caracteres e torna os demais em maiusculos.
    private StringBuilder setCaracInvaliEMaiusc(String str) {
        
    char[] chars = str.toUpperCase().toCharArray();  
        StringBuilder inserted = new StringBuilder();  
        for (char ch : chars) {
            if (!validos.contains(ch)) {  
                inserted.append(ch);
            }else if (validos.contains(ch)){
                JOptionPane.showMessageDialog(null, "Caractere Invalido Digitado");
            }
        }
        return inserted;
}
}
