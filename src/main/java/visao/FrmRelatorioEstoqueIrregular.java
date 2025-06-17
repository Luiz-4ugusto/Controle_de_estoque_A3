package visao;

// Importa a classe DAO para acessar os dados dos produtos no banco de dados.
import dao.CadastrarProdutoDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * Classe FrmRelatorioEstoqueIrregular responsável por exibir o relatório de
 * produtos com estoque abaixo / iguais ao mínimo ou acima do máximo permitido.
 * Permite ao usuário visualizar rapidamente quais produtos necessitam de
 * atenção para manter o estoque em níveis ideais.
 */
public class FrmRelatorioEstoqueIrregular extends javax.swing.JFrame {

    /**
     * Construtor padrão da classe FrmRelatorioEstoqueIrregular. Inicializa os
     * componentes da interface gráfica e centraliza a janela na tela.
     */
    public FrmRelatorioEstoqueIrregular() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela FrmRelatorioEstoqueIrregular na tela.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRelatorioEstoqueMinimo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableRelatorioEstoqueMaximo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JButtonCarregaTabelaEstoqueMaximo = new javax.swing.JButton();
        JButtonCarregaTabelaEstoqueMinimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório Estoque Irregular");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        JTableRelatorioEstoqueMinimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Produto", "Produto", "Estoque atual", "Estoque Mínimo"
            }
        ));
        jScrollPane1.setViewportView(JTableRelatorioEstoqueMinimo);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JTableRelatorioEstoqueMaximo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Produto", "Produto", "Estoque atual", "Estoque Máximo"
            }
        ));
        jScrollPane2.setViewportView(JTableRelatorioEstoqueMaximo);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Produtos acima ou iguais ao estoque máximo permitido");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Produtos abaixo ou iguais ao estoque mínimo permitido");

        JButtonCarregaTabelaEstoqueMaximo.setText("Gerar");
        JButtonCarregaTabelaEstoqueMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCarregaTabelaEstoqueMaximoActionPerformed(evt);
            }
        });

        JButtonCarregaTabelaEstoqueMinimo.setText("Gerar");
        JButtonCarregaTabelaEstoqueMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCarregaTabelaEstoqueMinimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(JButtonCarregaTabelaEstoqueMaximo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JButtonCarregaTabelaEstoqueMinimo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonCarregaTabelaEstoqueMinimo)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonCarregaTabelaEstoqueMaximo)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose(); // Fecha a tela atual.
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Método acionado quando o botão "Gerar" do relatório de Estoque Mínimo é clicado.
     * Carrega os dados dos produtos com estoque abaixo ou igual ao mínimo permitido
     * na tabela JTableRelatorioEstoqueMinimo.
     * 1. Limpa as linhas existentes na tabela.
     * 2. Cria uma instância de CadastrarProdutoDao para acessar os dados.
     * 3. Executa a consulta para obter produtos com estoque irregular (mínimo).
     * 4. Adiciona cada produto encontrado como uma nova linha na tabela.
     * 5. Trata possíveis erros de SQL durante o carregamento dos dados.
     */
    private void JButtonCarregaTabelaEstoqueMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCarregaTabelaEstoqueMinimoActionPerformed
        // Obtém o modelo da tabela para manipular seus dados.
        DefaultTableModel modelo = (DefaultTableModel) JTableRelatorioEstoqueMinimo.getModel();
        modelo.setNumRows(0); // Limpa todas as linhas existentes na tabela.
        CadastrarProdutoDao dao = new CadastrarProdutoDao();

        try {
            // Chama o método do DAO para obter o ResultSet com os produtos.
            ResultSet rs = dao.contarProdutosEstoqueMinimo();
            while (rs.next()) {
                // Adiciona uma nova linha à tabela com os dados do produto.
                modelo.addRow(new Object[]{
                    rs.getInt("codigo"),         // Coluna 1: Cód. Produto
                    rs.getString("produto"),     // Coluna 2: Produto
                    rs.getInt("estoque"),        // Coluna 3: Estoque atual
                    rs.getInt("estoque_min")     // Coluna 4: Estoque Mínimo
                });
            }
        } catch (SQLException ex) {
            // Em caso de erro SQL, imprime uma mensagem no console.
            System.err.println("Erro ao carregar dados: " + ex.getMessage());
        }
    }//GEN-LAST:event_JButtonCarregaTabelaEstoqueMinimoActionPerformed

    /**
     * Método acionado quando o botão "Gerar" do relatório de Estoque Máximo é clicado.
     * Carrega os dados dos produtos com estoque acima ou igual ao máximo permitido
     * na tabela JTableRelatorioEstoqueMaximo.
     * 1. Limpa as linhas existentes na tabela.
     * 2. Cria uma instância de CadastrarProdutoDao para acessar os dados.
     * 3. Executa a consulta para obter produtos com estoque irregular (máximo).
     * 4. Adiciona cada produto encontrado como uma nova linha na tabela.
     * 5. Trata possíveis erros de SQL durante o carregamento dos dados.
     */
    private void JButtonCarregaTabelaEstoqueMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCarregaTabelaEstoqueMaximoActionPerformed
        // Obtém o modelo da tabela para manipular seus dados.
        DefaultTableModel modelo = (DefaultTableModel) JTableRelatorioEstoqueMaximo.getModel();
        modelo.setNumRows(0);
        CadastrarProdutoDao dao = new CadastrarProdutoDao();

        try {
            // Chama o método do DAO para obter o ResultSet com os produtos.
            ResultSet rs = dao.contarProdutosEstoqueMaximo();
            while (rs.next()) {
                // Adiciona uma nova linha à tabela com os dados do produto.
                modelo.addRow(new Object[]{
                    rs.getInt("codigo"),         // Coluna 1: Cód. Produto
                    rs.getString("produto"),     // Coluna 2: Produto
                    rs.getInt("estoque"),        // Coluna 3: Estoque atual
                    rs.getInt("estoque_max")     // Coluna 4: Estoque Mínimo
                });
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getMessage());
        }
    }//GEN-LAST:event_JButtonCarregaTabelaEstoqueMaximoActionPerformed
    /**
     * Método principal para iniciar a aplicação.
     * É o ponto de entrada do relatório.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorioProdutosPorCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCarregaTabelaEstoqueMaximo;
    private javax.swing.JButton JButtonCarregaTabelaEstoqueMinimo;
    private javax.swing.JTable JTableRelatorioEstoqueMaximo;
    private javax.swing.JTable JTableRelatorioEstoqueMinimo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
