package visao;

import dao.CadastrarProdutoDao;
import javax.swing.table.DefaultTableModel;
import modelo.CadastrarProduto;

/**
 * Formulário para adicionar quantidade ao estoque de um produto existente.
 * Esta classe representa a interface gráfica (JFrame) que permite ao usuário
 * visualizar os produtos cadastrados em uma tabela, selecionar um produto e
 * adicionar uma quantidade ao seu estoque atual, atualizando a informação
 * no banco de dados.
 */
public class FrmAdicionarEstoque extends javax.swing.JFrame {

    CadastrarProduto cadprod = new CadastrarProduto();

    /**
     * Creates new form FrmAdicionarEstoque
     */
    public FrmAdicionarEstoque() {
        initComponents();
    }

    /**
     * Objeto de modelo para o produto, usado para operações.
     * Este campo não é utilizado ativamente na lógica atual,
     * a manipulação é feita com objetos obtidos diretamente do DAO.
     */
    @SuppressWarnings("unchecked")

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        modelo.setNumRows(0);

        CadastrarProdutoDao dao = new CadastrarProdutoDao();
        for (CadastrarProduto produto : dao.getListaProdutos()) {
            String categoriaFormatada = produto.getCategoria().getNome()
                    + " - " + produto.getCategoria().getEmbalagem()
                    + " - " + produto.getCategoria().getTamanho();

            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getMin(),
                produto.getMax(),
                categoriaFormatada
            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextAdd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSairAdd = new javax.swing.JButton();
        jAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Estoque");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Estoque atual", "Estoque mínimo", "Estoque máximo"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Adicionar ao estoque");

        jSairAdd.setText("Sair");
        jSairAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairAddActionPerformed(evt);
            }
        });

        jAdd.setText("Adicionar");
        jAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextAdd)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSairAdd)
                    .addComponent(jAdd))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSairAdd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAddActionPerformed

    private void jSairAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairAddActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jSairAddActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        carregaTabela();
    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (this.jTable1.getSelectedRow() != -1) {
            String id = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString();
            String nome = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString();
            String quantidadeAtual = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString();
            this.jLabel1.setText("Adicionar ao estoque de: " + nome + " (Atual: " + quantidadeAtual + ")");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddActionPerformed
        try {
            int linhaSelecionada = jTable1.getSelectedRow();
            if (linhaSelecionada == -1) {
                throw new Exception("Selecione um produto na tabela.");
            }

            String texto = jTextAdd.getText().trim();
            if (texto.isEmpty()) {
                throw new NumberFormatException();
            }

            int estoqueAtual = Integer.parseInt(jTable1.getValueAt(linhaSelecionada, 2).toString());
            int valorAdicionado = Integer.parseInt(texto);
            int maximo = Integer.parseInt(jTable1.getValueAt(linhaSelecionada, 4).toString());

            int novoEstoque = estoqueAtual + valorAdicionado;
            if (novoEstoque > maximo) {
                throw new Exception("Estoque não pode ultrapassar o limite máximo (" + maximo + ").");
            }

            jTable1.setValueAt(String.valueOf(novoEstoque), linhaSelecionada, 2);

            CadastrarProdutoDao dao = new CadastrarProdutoDao();
            CadastrarProduto produto = dao.getListaProdutos().get(linhaSelecionada);
            produto.setQuantidade(novoEstoque);

            dao.atualizarProduto(produto);

            jTextAdd.setText("");
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Digite um valor numérico válido.");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAdicionarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdicionarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdicionarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdicionarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdicionarEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jSairAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAdd;
    // End of variables declaration//GEN-END:variables
}
