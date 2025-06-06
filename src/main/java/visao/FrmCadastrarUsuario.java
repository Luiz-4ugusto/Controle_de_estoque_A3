package visao;
//import java.util.ArrayList;

import dao.CadastrarUsuarioDAO;
import javax.swing.JOptionPane;

import modelo.CadastrarUsuario;

public class FrmCadastrarUsuario extends javax.swing.JFrame {

    public FrmCadastrarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }
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
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextSenhaActionPerformed

    private void JButtonCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCadastrarUsuarioActionPerformed
        try {
            String username = JTextLogin.getText().trim();
            String email = JTextEmail.getText().trim();
            String senha = JTextSenha.getText().trim(); // A senha é lida como String

            if (username.length() < 2) {
                throw new MensagemLogin("O nome de usuário deve conter ao menos 2 caracteres.");
            }
            if (email.isEmpty()) {
                throw new MensagemLogin("O campo E-mail não pode estar vazio.");
            }
            if (senha.isEmpty()) {
                throw new MensagemLogin("A senha não pode estar vazia.");
            }

            CadastrarUsuarioDAO cadastrarDAO = new CadastrarUsuarioDAO();

            CadastrarUsuario usuarioExistentePorNome = cadastrarDAO.buscarUsername(username);
            if (usuarioExistentePorNome != null) {
                throw new MensagemLogin("O nome de usuário informado já está sendo usado.");
            }

            CadastrarUsuario novoUsuario = new CadastrarUsuario();
            novoUsuario.setNome(username);
            novoUsuario.setEmail(email);
            novoUsuario.setSenha(senha); // A senha é setada como String no ModeloCadastrar

            if (cadastrarDAO.inserirUsuario(novoUsuario)) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                JTextLogin.setText("");
                JTextEmail.setText("");
                JTextSenha.setText("");
            } else {
                throw new MensagemLogin("O e-mail informado já está sendo usado.");
            }

        } catch (MensagemLogin erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JButtonCadastrarUsuarioActionPerformed

    private void JButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonVoltarActionPerformed
        this.dispose(); // Fecha a tela de cadastro
        new FrmLogin().setVisible(true); // Abre a tela de login
    }//GEN-LAST:event_JButtonVoltarActionPerformed

    private void JTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextEmailActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarUsuario().setVisible(true);
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
