package principal;

import visao.FrmLogin;

/**
 * Classe principal responsável por iniciar a execução de toda a aplicação.
 * A sua única finalidade é ser o ponto de entrada (entry point) do sistema,
 * instanciando e exibindo a tela inicial de login para o usuário.
 */


public class Principal {

    public static void main(String[] args) {
        FrmLogin objetotela = new FrmLogin();
        objetotela.setVisible(true);
    }
}
