import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
    private JFrame tela;
    private JLabel lblTitulo, lblSubTit1, lblSubTit2, lblSubTit3;
	private JButton btnSair, btnProdutos, btnEntradaEstoque, btnEstoqueAtual, btnFornecedores, btnSaidaEstoque, btnMovimentacoes, btnUsuarios;
    
    private void estilizarLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
    }

    public boolean validarCargo(boolean validar){
        if(!validar){
            System.out.println(validar);
            btnProdutos.setEnabled(false);
            btnFornecedores.setEnabled(false);
            btnUsuarios.setEnabled(false);
            return false;
        }else{
            return true;
        }
    }

    public Menu(boolean ehAdmin) {
        tela = new JFrame("Menu");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(700, 600);
		tela.setLayout(new GridBagLayout());
		tela.setResizable(false);
		tela.getContentPane().setBackground(new Color(5, 5, 50));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		// gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;

        int linha = 0;
		gbc.gridx = 2;
		gbc.gridy = linha;
		gbc.gridwidth = 6;
		// gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 40, 5); 
		lblTitulo = new JLabel("Menu Principal");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(Color.WHITE);
		tela.add(lblTitulo, gbc);

        linha++;

        gbc.insets = new Insets(5, 40, 5, 5); 
        gbc.gridy = linha;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
        lblSubTit1 = new JLabel("Cadastros");
		estilizarLabel(lblSubTit1);
        tela.add(lblSubTit1, gbc);

        gbc.gridx = 2;
        lblSubTit2 = new JLabel("Movimentações");
		estilizarLabel(lblSubTit2);
        tela.add(lblSubTit2, gbc);

        gbc.gridx = 3;
        lblSubTit3 = new JLabel("Relatórios");
		estilizarLabel(lblSubTit3);
        tela.add(lblSubTit3, gbc);

        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		// gbc.insets = new Insets(40, 5, 5, 5); 
		btnProdutos = new JButton("Produtos");
		tela.add(btnProdutos, gbc);

        gbc.gridx = 2;
		gbc.gridy = linha; 
		btnEntradaEstoque = new JButton("Entrada de Estoque");
		tela.add(btnEntradaEstoque, gbc);

        gbc.gridx = 3;
		gbc.gridy = linha; 
		btnEstoqueAtual = new JButton("Estoque Atual");
		tela.add(btnEstoqueAtual, gbc);

        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		btnFornecedores = new JButton("Fornecedores");
		tela.add(btnFornecedores, gbc);

        gbc.gridx = 2;
		gbc.gridy = linha; 
		btnSaidaEstoque = new JButton("Saída de Estoque");
		tela.add(btnSaidaEstoque, gbc);

        gbc.gridx = 3;
		gbc.gridy = linha; 
		btnMovimentacoes = new JButton("Movimentações");
		tela.add(btnMovimentacoes, gbc);
        
        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		btnUsuarios = new JButton("Usuários");
		tela.add(btnUsuarios, gbc);

        linha++;

        gbc.gridx = 2;
		gbc.gridy = linha;
        gbc.insets = new Insets(50, 70, 5, 5); 
		btnSair = new JButton("Sair");
		tela.add(btnSair, gbc);

        btnProdutos.addActionListener(e -> {
            tela.dispose();
            new TelaCadastroProduto(validarCargo(ehAdmin));
        });

        btnFornecedores.addActionListener(e -> {
            tela.dispose();
            new CadastroFornecedor(validarCargo(ehAdmin));
        });

        btnUsuarios.addActionListener(e -> {
            tela.dispose();
            new TelaUsuario(validarCargo(ehAdmin));
        });

        btnEntradaEstoque.addActionListener(e -> {
            tela.dispose();
            new TelaEntradaEstoque(validarCargo(ehAdmin));
        });

        btnSaidaEstoque.addActionListener(e -> {
            tela.dispose();
            new SaidaEstoque(validarCargo(ehAdmin));
        });

        btnEstoqueAtual.addActionListener(e -> {
            tela.dispose();
            new EstoqueAtual(validarCargo(ehAdmin));
        });

        btnMovimentacoes.addActionListener(e -> {
            tela.dispose();
            new Movimentacoes(validarCargo(ehAdmin));
        });

        btnSair.addActionListener(e -> {
            tela.dispose();
            new Login();
        });

        validarCargo(ehAdmin);

        tela.setVisible(true);
    }
}
