import javax.swing.*;

import banco.SaidaEstoqueDAO;

import classes.EntradaEstoque;
import classes.SaidaEstoque;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TelaSaidaEstoque extends JFrame{
    private JFrame tela;
    private JLabel lblTitulo, lblCodigo, lblNomeProduto, lblQuantidade, lblTipoSaida, lblDataSaida;
	private JTextField txtNumDoc, txtCodProduto, txtQuantidade, txtTipoSaida, txtDataSaida;
	private JButton btnSair, btnNovo, btnConfirmar, btnCancelar;
	private String[] tipoSaida = {
        "--Selecione--", "Venda", "Devolução ao fornecedor", "Outro"
    };
	private JComboBox<String> cbTipoSaida = new JComboBox<>(tipoSaida);
    private SaidaEstoqueDAO saidaEstoqueDAO;

    private void estilizarLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public void abrirTela() {

        txtDataSaida.setEnabled(false);
		txtCodProduto.setEnabled(false);
		txtQuantidade.setEnabled(false);
		cbTipoSaida.setEnabled(false);

		btnNovo.setEnabled(true);
		btnConfirmar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}

    private void habilitar() {
		txtCodProduto.setEnabled(true);
		txtQuantidade.setEnabled(true);
		cbTipoSaida.setEnabled(true);
    }

    private void desabilitar(){
		abrirTela();
		limpar();
	}

    private void limpar() {
        
        txtDataSaida.setText("");
		txtCodProduto.setText("");
		txtQuantidade.setText("");
		cbTipoSaida.setSelectedIndex(0);
    }

    // public void validarCampos() {
	// 	if (txtNumDoc.getText().equals("") || txtDataSaida.getText().equals("") || txtCodProduto.getText().equals("") || txtQuantidade.getText().equals("") || cbTipoSaida.getSelectedIndex() == 0) {
	// 		JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
	// 	} else {
	// 		desabilitar();
	// 		JOptionPane.showMessageDialog(tela, "Saída confirmada.");
	// 	}
	// }

	public void validarCargo(boolean cargo){
		if(cargo){
			new Menu(true);
		}else {
			new Menu(false);
		}
	}

    public TelaSaidaEstoque(boolean Cargo) {
		saidaEstoqueDAO = new SaidaEstoqueDAO();
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

		gbc.insets = new Insets(5, 5, 10, 5);
		btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(81, 112, 255));
        btnSair.setForeground(Color.white);
        btnSair.setFocusPainted(false);
		gbc.gridx = 5;
        gbc.gridwidth = 0;
		tela.add(btnSair, gbc);
		linha++;

		gbc.gridx = 2;
		gbc.gridy = linha;
		gbc.gridwidth = 6;
		// gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 40, 5); 
		lblTitulo = new JLabel("Saída de Estoque");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(Color.WHITE);
		tela.add(lblTitulo, gbc);

        
		// gbc.anchor = GridBagConstraints.WEST;
		


		linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblDataSaida = new JLabel("Data de Saída:");
		estilizarLabel(lblDataSaida);
		tela.add(lblDataSaida, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtDataSaida = new JTextField(20);
		tela.add(txtDataSaida, gbc);

		linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblNomeProduto = new JLabel("Código do Produto:");
		estilizarLabel(lblNomeProduto);
		tela.add(lblNomeProduto, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtCodProduto = new JTextField(20);
		tela.add(txtCodProduto, gbc);

        linha++;

        gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblQuantidade = new JLabel("Quantidade:");
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
		lblTipoSaida = new JLabel("Tipo de Saída:");
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
		btnNovo.setBackground(new Color(128, 128, 128));
        btnNovo.setForeground(Color.WHITE);
        btnNovo.setFocusPainted(false);

		tela.add(btnNovo, gbc);

		gbc.gridx = 3;
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(128, 128, 128));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);

		tela.add(btnConfirmar, gbc);

		gbc.gridx = 5;
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(128, 128, 128));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);

		tela.add(btnCancelar, gbc);

        abrirTela();

        btnNovo.addActionListener(e -> {
			habilitar();

			// Define a data atual no campo txtDataSaida
			LocalDate hoje = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // ou ""
			txtDataSaida.setText(hoje.format(formatter));

            txtCodProduto.requestFocus();

			btnNovo.setEnabled(false);
			btnConfirmar.setEnabled(true);
			btnCancelar.setEnabled(true);
		});

        btnConfirmar.addActionListener(e -> {
            // validarCampos();

            if (txtDataSaida.getText().equals("")) {
                JOptionPane.showMessageDialog(tela, "Campo Data de Saída é Obrigatório!");
            }
            else if(txtCodProduto.getText().equals("")) {
                JOptionPane.showMessageDialog(tela, "Campo Códgio do produto é obrigatório!");
            }
            else if(txtQuantidade.getText().equals("")){
                JOptionPane.showMessageDialog(tela, "Campo Quantidade é Obrigatório!");
            } else if(cbTipoSaida.getSelectedIndex() == 0){
				JOptionPane.showMessageDialog(tela, "Campo Tipo de saída é Obrigatório!");
			} else{
                try {
                    SaidaEstoque saida = new SaidaEstoque();
                    
                    saida.setDataSaida(txtDataSaida.getText());
                    saida.setCod_produto(Integer.parseInt(txtCodProduto.getText()));


                    // saida.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

					int quantidade;
					try {
						quantidade = Integer.parseInt(txtQuantidade.getText());
						if (quantidade <= 0) {
							JOptionPane.showMessageDialog(tela, "A quantidade deve ser maior que zero!");
							return; // não permite continuar
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(tela, "Informe um número válido na quantidade!");
						return; // não permite continuar
					}
					saida.setQuantidade(quantidade);


					if(cbTipoSaida.getSelectedIndex() == 1){
                        saida.setTipoSaida("Venda");
                    }else if(cbTipoSaida.getSelectedIndex() == 2){
                        saida.setTipoSaida("Devolução ao fornecedor");
                    } else if(cbTipoSaida.getSelectedIndex() == 3) {
                        saida.setTipoSaida("Outro");
                    }

                    saidaEstoqueDAO.confirmarSaida(saida);
                    JOptionPane.showMessageDialog(tela, "Saida confirmada.");
                    limpar();
                    abrirTela();
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(tela, "Erro ao confirmar a saída: " + msg);

				}
            }
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