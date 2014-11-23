/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.documents;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Richard Matheus
 */
public class ControleSenhaTabela extends DefaultTableCellRenderer implements TableCellRenderer{

    private static final String ASTERISKS = "\u2022\u2022\u2022\u2022\u2022\u2022\u2022\u2022";

    @Override
    public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
        int length =0;
        if (arg1 instanceof String) {
            length =  ((String) arg1).length();
        } else if (arg1 instanceof char[]) {
            length = ((char[])arg1).length;
        }
        setText(asterisks(length));
        return this;
    }

    private String asterisks(int length) {
        if (length > ASTERISKS.length()) {
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append('\u2022');
            }
            return sb.toString();
        } else {
            return ASTERISKS.substring(0, length);
        }
    }
    
}
