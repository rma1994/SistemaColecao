/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.frame;

import javax.swing.JDesktopPane;
import javax.swing.table.TableModel;
import nwk.com.br.documents.ControleSenhaTabela;
import nwk.com.br.structures.LivroStru;
import nwk.com.br.model.Livro;

/**
 *
 * @author Richard Matheus
 */
public class ConsultaLivro extends javax.swing.JInternalFrame {
    private LivroStru stru = new LivroStru();
    private JDesktopPane jDesktopPanePrincipal = new JDesktopPane();
    /**
     * Creates new form ConsultaUsuario
     */
    public ConsultaLivro() {
        initComponents();
        atualizaTable();
    }
    
    //Carrega os dados na tabela
    private void atualizaTable(){
        TableModel model = (TableModel) (stru.getTable());
        jTableLivros.setModel(model);
        
        //Seta as dimensões das colunas
        jTableLivros.getColumnModel().getColumn(0).setMinWidth(35);
        jTableLivros.getColumnModel().getColumn(0).setMaxWidth(35);
        
        jTableLivros.getColumnModel().getColumn(2).setMinWidth(100);
        jTableLivros.getColumnModel().getColumn(2).setMaxWidth(100);
        //jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(350);
    }
    
    //recebe a desktoppane do mainframe
    public void addConsultaLivro(JDesktopPane frame){
        
        this.jDesktopPanePrincipal = frame;
        jDesktopPanePrincipal.add(this);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jButtonInserir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta Livro");

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLivros);

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        // TODO add your handling code here:
        CadLivro cadLivro = new CadLivro();
        dispose();
        cadLivro.addCadLivroNew(jDesktopPanePrincipal);
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jTableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivrosMouseClicked
        Livro livro = new Livro();
        CadLivro cadLivro = new CadLivro();
        
        int linhaSelecionada = jTableLivros.getSelectedRow();
        
        livro.setCod(Integer.parseInt(jTableLivros.getValueAt(linhaSelecionada, 0).toString()));
        livro.setNome(jTableLivros.getValueAt(linhaSelecionada, 1).toString());
        livro.setPaginas(jTableLivros.getValueAt(linhaSelecionada, 2).toString());
        livro.setData(jTableLivros.getValueAt(linhaSelecionada, 3).toString());
        
        livro.setUpdate(true);
        
        dispose();
        cadLivro.addCadLivroUpdate(jDesktopPanePrincipal, livro);
    }//GEN-LAST:event_jTableLivrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    // End of variables declaration//GEN-END:variables
}
