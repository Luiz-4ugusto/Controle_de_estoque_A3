package visao;

import dao.CadastrarUsuarioDAO; // Importa a classe DAO responsável pela lógica de autenticação.
import javax.swing.JOptionPane;

import modelo.CadastrarUsuario;

/**
 * Classe responsável por representar a tela de cadastro de usuários da
 * aplicação de Controle de Estoque. Permite ao usuário inserir um novo nome de
 * usuário, e-mail e senha para criar uma nova conta no sistema.
 */
public class FrmCadastrarUsuario extends javax.swing.JFrame {

    /**
     * Construtor padrão da classe FrmCadastrarUsuario. Inicializa os
     * componentes da interface gráfica e centraliza a janela na tela.
     */
    public FrmCadastrarUsuario() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        JTextSenha = new javax.swing.JTextField();
        JTextLogin = new javax.swing.JTextField();
        jLabelEsqueci = new javax.swing.JLabel();
        JButtonCadastrarUsuario = new javax.swing.JButton();
        JButtonVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTextEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Estoque - Cadastro");

        jLabel3.setText("CADASTRO DE USUÁRIOS");

        JTextSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextSenhaActionPerformed(evt);
            }
        });

        jLabelEsqueci.setAutoscrolls(true);

        JButtonCadastrarUsuario.setText("Cadastrar");
        JButtonCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCadastrarUsuarioActionPerformed(evt);
            }
        });

        JButtonVoltar.setText("Voltar");
        JButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome de usuário");

        jLabel1.setText("Senha");

        jLabel4.setText("E-mail");

        JTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabelEsqueci))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JButtonCadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                    .addComponent(JButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(JTextEmail))
                            .addComponent(JTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(JTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonCadastrarUsuario)
                    .addComponent(JButtonVoltar))
                .addGap(13, 13, 13)
                .addComponent(jLabelEsqueci)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTextSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextSenhaActionPerformed
        // Este método é acionado quando uma ação é realizada no campo de texto da senha.
        // Atualmente não há lógica específica implementada para este evento,
        // mas pode ser usado para validação ou foco em outro campo.
    }//GEN-LAST:event_JTextSenhaActionPerformed

    private void JButtonCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCadastrarUsuarioActionPerformed
        // Lógica para o botão "Cadastrar".
        // 1. Coleta os dados dos campos de texto (usuário, e-mail, senha).
        // 2. Realiza validações básicas dos campos (ex: comprimento do nome de usuário, campos vazios).
        // 3. Verifica se o nome de usuário ou e-mail já existem no banco de dados.
        // 4. Se os dados forem válidos e únicos, insere o novo usuário no banco de dados.
        // 5. Exibe mensagens de sucesso ou erro ao usuário.
        // 6. Limpa os campos de texto após um cadastro bem-sucedido.
        try {
            // Obtém e remove espaços em branco dos dados inseridos pelo usuário
            String username = JTextLogin.getText().trim();
            String email = JTextEmail.getText().trim();
            String senha = JTextSenha.getText().trim(); // A senha é lida como String

            // Validação: verifica se o nome de usuário tem ao menos 2 caracteres
            if (username.length() < 2) {
                throw new MensagemLogin("O nome de usuário deve conter ao menos 2 caracteres.");
            }
            // Validação: verifica se o campo E-mail está vazio
            if (email.isEmpty()) {
                throw new MensagemLogin("O campo E-mail não pode estar vazio.");
            }
            // Validação: verifica se o campo Senha está vazio
            if (senha.isEmpty()) {
                throw new MensagemLogin("A senha não pode estar vazia.");
            }

            CadastrarUsuarioDAO cadastrarDAO = new CadastrarUsuarioDAO();

            // Busca por um usuário com o mesmo nome de usuário para evitar duplicidade
            CadastrarUsuario usuarioExistentePorNome = cadastrarDAO.buscarUsername(username);
            if (usuarioExistentePorNome != null) {
                throw new MensagemLogin("O nome de usuário informado já está sendo usado.");
            }

            // Cria um novo objeto CadastrarUsuario com os dados informados
            CadastrarUsuario novoUsuario = new CadastrarUsuario();
            novoUsuario.setNome(username);
            novoUsuario.setEmail(email);
            novoUsuario.setSenha(senha); // A senha é setada como String no ModeloCadastrar

            // Tenta inserir o novo usuário no banco de dados
            if (cadastrarDAO.inserirUsuario(novoUsuario)) {
                // Exibe mensagem de sucesso e limpa os campos
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                JTextLogin.setText("");
                JTextEmail.setText("");
                JTextSenha.setText("");
            } else {
                // Mensagem para o caso de o e-mail já estar em uso (lógica do DAO)
                throw new MensagemLogin("O e-mail informado já está sendo usado.");
            }

        } catch (MensagemLogin erro) {
            // Captura e exibe mensagens de erro específicas da validação de login
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (Exception e) {
            // Captura e exibe outros erros inesperados durante o processo de cadastro
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace(); // Imprime o stack trace para depuração
        }
    }//GEN-LAST:event_JButtonCadastrarUsuarioActionPerformed

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonVoltarActionPerformed
        // Lógica para o botão "Voltar".
        // Fecha a janela atual de cadastro e abre a tela de login.
        this.dispose(); // Fecha a tela de cadastro
        new FrmLogin().setVisible(true); // Abre a tela de login
    }//GEN-LAST:event_JButtonVoltarActionPerformed

    private void JTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextEmailActionPerformed
        // Este método é acionado quando uma ação é realizada no campo de texto do e-mail.
        // Atualmente não há lógica específica implementada para este evento.
    }//GEN-LAST:event_JTextEmailActionPerformed

    /**
     * Método principal para iniciar a aplicação. É o ponto de entrada da tela de
     * cadastro de usuários.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarUsuario().setVisible(true); // Cria e torna a janela FrmCadastrarUsuario visível.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCadastrarUsuario;
    private javax.swing.JButton JButtonVoltar;
    private javax.swing.JTextField JTextEmail;
    private javax.swing.JTextField JTextLogin;
    private javax.swing.JTextField JTextSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEsqueci;
    // End of variables declaration//GEN-END:variables
}
