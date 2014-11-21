/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.documents;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Richard Matheus
 */
public class ControleTextoId  extends PlainDocument{
    Character chs[] = {'0','1','2','3','4','5','6','7','8','9'}; //Coloque aqui todos os caracteres válidos  
    Set<Character> validos = new HashSet<Character>(Arrays.asList(chs));  
    
    @Override  
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{  
        char[] chars = str.toUpperCase().toCharArray();  
        StringBuilder inserted = new StringBuilder();  
        for (char ch : chars) {  
            if (validos.contains(ch)) {  
                inserted.append(ch); //Filtramos só o que é válido  
            }  
        }
        
        super.insertString(offs, inserted.toString(), a);  
    }
}
