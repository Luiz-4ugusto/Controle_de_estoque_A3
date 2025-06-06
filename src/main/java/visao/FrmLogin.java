package visao;

import javax.swing.JOptionPane;
import dao.LoginDAO; // Importa a classe DAO responsável pela lógica de autenticação.

/**
 * Classe FrmLogin responsável pela interface gráfica de login da aplicação.
 * Permite ao usuário inserir suas credenciais (usuário e senha) para acessar o
 * sistema, ou navegar para a tela de cadastro de novos usuários.
 */
public class FrmLogin extends javax.swing.JFrame {

    // Declara uma instância da classe LoginDAO para lidar com a comunicação com o banco de dados
    // e a validação do login.
    private LoginDAO loginDAO;

    /**
     * Construtor padrão da classe FrmLogin. Inicializa os componentes da
     * interface gráfica (elementos visuais) e centraliza a janela de login na
     * tela do usuário. Também inicializa a instância de LoginDAO.
     */
    public FrmLogin() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela FrmLogin na tela.
        loginDAO = new LoginDAO();   // Instancia o objeto LoginDAO para usar suas funcionalidades.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        JTextLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JButtonEntrar = new javax.swing.JButton();
        JButtonCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JPasswordLogin = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Estoque - Acesso");

        JTextLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        JButtonEntrar.setText("Entrar");
        JButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonEntrarActionPerformed(evt);
            }
        });

        JButtonCadastrar.setText("Cadastrar-se");
        JButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setText("CONTROLE DE ESTOQUE");

        JPasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPasswordLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(JTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JButtonCadastrar))
                                .addComponent(JPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonEntrar)
                    .addComponent(JButtonCadastrar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEntrarActionPerformed
        try {
            // Obtém o texto do campo de login e remove espaços em branco extras.
            String username = JTextLogin.getText().trim();
            // Obtém a senha do campo de senha (JPasswordField) como String e remove espaços.
            // Converte JPasswordField.getPassword() para String para uso.
            String senha = new String(JPasswordLogin.getPassword()).trim();

            // Validação: verifica se o campo de usuário está vazio.
            if (username.isEmpty()) {
                throw new MensagemLogin("Por favor, informe o nome de usuário.");
            }

            // Validação: verifica se o nome de usuário tem ao menos 2 caracteres.
            if (username.length() < 2) {
                throw new MensagemLogin("O nome de usuário deve conter ao menos 2 caracteres.");
            }

            // Validação: verifica se o campo de senha está vazio.
            if (senha.isEmpty()) {
                throw new MensagemLogin("Por favor, informe a senha.");
            }

            // Chama o método validarLogin do LoginDAO para verificar as credenciais no banco.
            if (loginDAO.validarLogin(username, senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                this.dispose(); // Fecha a tela de login.
                new FrmPrincipal().setVisible(true); // Abre a tela principal (FrmPrincipal).
            } else {
                // Se o login falhar, lança uma exceção com a mensagem de erro.
                throw new MensagemLogin("Usuário ou senha incorretos.");
            }
        } catch (MensagemLogin erro) {
            // Captura e exibe mensagens de erro personalizadas (MensagemLogin).
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_JButtonEntrarActionPerformed

    private void JTextLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextLoginActionPerformed

    private void JButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCadastrarActionPerformed
        this.dispose(); // Fecha a tela de login.
        new FrmCadastrarUsuario().setVisible(true); // Abre a tela de Cadastro de Usuários.
    }//GEN-LAST:event_JButtonCadastrarActionPerformed

    private void JPasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPasswordLoginActionPerformed
        JButtonEntrarActionPerformed(evt);    }//GEN-LAST:event_JPasswordLoginActionPerformed

    /**
     * Método principal para iniciar a aplicação. É o ponto de entrada do
     * programa.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true); // Cria e torna a janela FrmLogin visível.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCadastrar;
    private javax.swing.JButton JButtonEntrar;
    private javax.swing.JPasswordField JPasswordLogin;
    private javax.swing.JTextField JTextLogin;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
