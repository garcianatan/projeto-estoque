import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SaidaEstoque extends JFrame{
    private JFrame tela;
    private JLabel lblTitulo, lblCodigo, lblNomeProduto, lblQuantidade, lblTipoSaida, lblDataSaida;
	private JTextField txtCodigo, txtNomeProduto, txtQuantidade, txtTipoSaida, txtDataSaida;
	private JButton btnSair, btnNovo, btnConfirmar, btnCancelar;
	private String[] tipoSaida = {
        "--Selecione--", "Venda", "Devolução ao fornecedor", "Outro"
    };
	private JComboBox<String> cbTipoSaida = new JComboBox<>(tipoSaida);
    
    private void estilizarLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public void abrirTela() {

		txtCodigo.setEnabled(false);
        txtDataSaida.setEnabled(false);
		txtNomeProduto.setEnabled(false);
		txtQuantidade.setEnabled(false);
		cbTipoSaida.setEnabled(false);

		btnNovo.setEnabled(true);
		btnConfirmar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}

    private void habilitar() {
        txtCodigo.setEnabled(true);
        txtDataSaida.setEnabled(true);
		txtNomeProduto.setEnabled(true);
		txtQuantidade.setEnabled(true);
		cbTipoSaida.setEnabled(true);
    }

    private void desabilitar(){
		abrirTela();
		limpar();
	}

    private void limpar() {
        txtCodigo.setText("");
        txtDataSaida.setText("");
		txtNomeProduto.setText("");
		txtQuantidade.setText("");
		cbTipoSaida.setSelectedIndex(0);
    }

    public void validarCampos() {
		if (txtCodigo.getText().equals("") || txtDataSaida.getText().equals("") || txtNomeProduto.getText().equals("") || txtQuantidade.getText().equals("") || cbTipoSaida.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
		} else {
			desabilitar();
			JOptionPane.showMessageDialog(tela, "Saída confirmada.");
		}
	}

	public void validarCargo(boolean cargo){
		if(cargo){
			new Menu(true);
		}else {
			new Menu(false);
		}
	}

    public SaidaEstoque(boolean Cargo) {
        tela = new JFrame("Saída de Estoque");
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
		lblTitulo = new JLabel("Saída de Estoque");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(Color.WHITE);
		tela.add(lblTitulo, gbc);

        gbc.insets = new Insets(5, 5, 10, 5); 
		// gbc.anchor = GridBagConstraints.WEST;
		btnSair = new JButton("Sair");
		gbc.gridx = 3;
        gbc.gridwidth = 0;
		tela.add(btnSair);


		linha++;
		gbc.gridy = linha;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
        lblCodigo = new JLabel("Código");
		estilizarLabel(lblCodigo);
        tela.add(lblCodigo, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 3;
		txtCodigo = new JTextField(10);
		gbc.insets = new Insets(5, 50, 5, 5);
		tela.add(txtCodigo, gbc);

		linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblDataSaida = new JLabel("Data de saída");
		estilizarLabel(lblDataSaida);
		tela.add(lblDataSaida, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtDataSaida = new JTextField(20);
		tela.add(txtDataSaida, gbc);

		linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblNomeProduto = new JLabel("Produto");
		estilizarLabel(lblNomeProduto);
		tela.add(lblNomeProduto, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtNomeProduto = new JTextField(20);
		tela.add(txtNomeProduto, gbc);

        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblQuantidade = new JLabel("Quantidade");
		estilizarLabel(lblQuantidade);
		tela.add(lblQuantidade, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtQuantidade = new JTextField(20);
		tela.add(txtQuantidade, gbc);

        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblTipoSaida = new JLabel("Tipo de saída");
		estilizarLabel(lblTipoSaida);
		tela.add(lblTipoSaida, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(5, 50, 5, 5);
		// txtTipoSaida = new JTextField(20);

		tela.add(cbTipoSaida, gbc);

        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.insets = new Insets(40, 5, 5, 5); 
		btnNovo = new JButton("Novo");
		tela.add(btnNovo, gbc);

		gbc.gridx = 3;
		btnConfirmar = new JButton("Confirmar");
		tela.add(btnConfirmar, gbc);

		gbc.gridx = 5;
		btnCancelar = new JButton("Cancelar");
		tela.add(btnCancelar, gbc);

        abrirTela();

        btnNovo.addActionListener(e -> {
			habilitar();

            txtCodigo.requestFocus();

			btnNovo.setEnabled(false);
			btnConfirmar.setEnabled(true);
			btnCancelar.setEnabled(true);
		});

        btnConfirmar.addActionListener(e -> {
            validarCampos();
        });

        btnCancelar.addActionListener(e -> {
            desabilitar();
        });

        btnSair.addActionListener(e -> {
            tela.dispose();
			validarCargo(Cargo);
		});

        tela.setVisible(true);
    }
    
}