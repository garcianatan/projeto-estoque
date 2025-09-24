import java.awt.*;
import javax.swing.*;

import classes.Produto;
import banco.ProdutoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// adicionar botão sair em cima
// implentar função dos botões pesquisar alterar e excluir


public class TelaCadastroProduto{
    private JFrame tela;
    private JLabel lblTitulo, lblCodigo, lblNome, lblDescricao, lblCategoria, lblFornecedor, lblPrecoCusto, lblPrecoVenda;
	private JTextField txtCodigo, txtNome, txtCategoria, txtFornecedor, txtPrecoCusto, txtPrecoVenda;
	private JTextArea txtDescricao;
	private JButton btnSair, btnNovo, btnSalvar, btnCancelar, btnPesquisar, btnAlterar, btnExcluir; 
	private ProdutoDAO produtoDAO;

	private void estilizarLabel(JLabel label) {
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 14));
	}

	public void abrirTela() {
		txtCodigo.setEnabled(false);
		txtNome.requestFocus();

		txtNome.setEnabled(false);
		txtDescricao.setEnabled(false);
		txtCategoria.setEnabled(false);
		txtFornecedor.setEnabled(false);
		txtPrecoCusto.setEnabled(false);
		txtPrecoVenda.setEnabled(false);

		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnPesquisar.setEnabled(true);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}

	private void habilitar() {
		txtNome.setEnabled(true);
		txtDescricao.setEnabled(true);
		txtCategoria.setEnabled(true);
		txtFornecedor.setEnabled(true);
		txtPrecoCusto.setEnabled(true);
		txtPrecoVenda.setEnabled(true);
	}

	private void desabilitar(){
		abrirTela();
		limpar();
	}

	private void limpar() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtDescricao.setText("");
		txtCategoria.setText("");
		txtFornecedor.setText("");
		txtPrecoCusto.setText("");
		txtPrecoVenda.setText("");
	}

	public void validarCampos() {
		if (txtNome.getText().equals("") || txtDescricao.getText().equals("") || txtCategoria.getText().equals("") || txtFornecedor.getText().equals("") || txtPrecoCusto.getText().equals("") || txtPrecoVenda.getText().equals("")) {
			JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
		} else {
			desabilitar();
			JOptionPane.showMessageDialog(tela, "Salvo com sucesso!");
		}
	}

	public void validarCargo(boolean cargo){
		if(cargo){
			new Menu(true);
		}else {
			new Menu(false);
		}
	}

    public TelaCadastroProduto(boolean Cargo) {
		produtoDAO = new ProdutoDAO();
        tela = new JFrame("Cadastro de Produtos");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(700, 600);
		tela.setLayout(new GridBagLayout());
		tela.setResizable(false);
		// tela.setBackground(new java.awt.Color(100,0, 3));
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
		lblTitulo = new JLabel("Cadastro de Produtos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(Color.WHITE);
		tela.add(lblTitulo, gbc);
		
		gbc.insets = new Insets(5, 5, 10, 5); 
		// gbc.anchor = GridBagConstraints.WEST;
		btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(81, 112, 255));
        btnSair.setForeground(Color.white);
        btnSair.setFocusPainted(false);
		gbc.gridx = 3;
		tela.add(btnSair);


		linha++;
		gbc.gridy = linha;
		gbc.gridx = 1;
		gbc.gridwidth = 3;
        lblCodigo = new JLabel("Código:");
		estilizarLabel(lblCodigo);
        tela.add(lblCodigo, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		txtCodigo = new JTextField(10);
		gbc.insets = new Insets(5, 50, 5, 5);
		tela.add(txtCodigo, gbc);

		linha++;


		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblNome = new JLabel("Nome:");
		estilizarLabel(lblNome);
		tela.add(lblNome, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtNome = new JTextField(20);
		tela.add(txtNome, gbc);

		linha++;

		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblDescricao = new JLabel("Descrição:");
		estilizarLabel(lblDescricao);
		tela.add(lblDescricao, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtDescricao = new JTextArea(4, 20);
		// tela.add(txtDescricao, gbc);
		txtDescricao.setLineWrap(true); // Quebra de linha automática
        txtDescricao.setWrapStyleWord(true);    // Quebra por palavra, não por caractere

        // Adiciona JTextArea dentro de um JScrollPane
        JScrollPane scroll = new JScrollPane(txtDescricao);

        // configura as barras de rolagem
        // scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Adiciona o JScrollPane a tela
        tela.add(scroll, gbc);
		

		linha++;

		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblCategoria = new JLabel("Categoria:");
		estilizarLabel(lblCategoria);
		tela.add(lblCategoria, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtCategoria = new JTextField(15);
		tela.add(txtCategoria, gbc);

		linha++;

		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblFornecedor = new JLabel("Fornecedor:");
		estilizarLabel(lblFornecedor);
		tela.add(lblFornecedor, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtFornecedor = new JTextField(15);
		tela.add(txtFornecedor, gbc);

		linha++;

		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblPrecoCusto = new JLabel("Preço de Custo:");
		estilizarLabel(lblPrecoCusto);
		tela.add(lblPrecoCusto, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtPrecoCusto = new JTextField(10);
		tela.add(txtPrecoCusto, gbc);

		linha++;

		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblPrecoVenda = new JLabel("Preço de Venda:");
		estilizarLabel(lblPrecoVenda);
		tela.add(lblPrecoVenda, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		txtPrecoVenda = new JTextField(10);
		tela.add(txtPrecoVenda, gbc);

		linha++; 

		gbc.gridwidth = 1;

		gbc.gridx = 0;
		gbc.gridy = linha;
		gbc.insets = new Insets(40, 5, 5, 5); 
		btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(128, 128, 128));
        btnNovo.setForeground(Color.WHITE);
        btnNovo.setFocusPainted(false);
		tela.add(btnNovo, gbc);

		gbc.gridx = 1;
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(128, 128, 128));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
		tela.add(btnSalvar, gbc);

		gbc.gridx = 2;
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(128, 128, 128));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
		tela.add(btnCancelar, gbc);

		gbc.gridx = 3;
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(new Color(128, 128, 128));
        btnPesquisar.setForeground(Color.WHITE);
        btnPesquisar.setFocusPainted(false);
		tela.add(btnPesquisar, gbc);

		gbc.gridx = 4;
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(128, 128, 128));
        btnAlterar.setForeground(Color.WHITE);
        btnAlterar.setFocusPainted(false);
		tela.add(btnAlterar, gbc);

		gbc.gridx = 5;
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(128, 128, 128));
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.setFocusPainted(false);
		tela.add(btnExcluir, gbc);

		abrirTela();

		btnNovo.addActionListener(e -> {
			habilitar();

			btnNovo.setEnabled(false);
			btnSalvar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnPesquisar.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().equals("")){
                JOptionPane.showMessageDialog(tela, "Campo Nome é Obrigatório!");
            }
            else if (txtDescricao.getText().equals("")) {
                JOptionPane.showMessageDialog(tela, "Campo Descrição é Obrigatório!");
            }
            else if(txtCategoria.getText().equals("")) {
                JOptionPane.showMessageDialog(tela, "Campo Categoria é obrigatório!");
            }
            else if(txtFornecedor.getText().equals("")){
                JOptionPane.showMessageDialog(tela, "Campo Fornecedor é Obrigatório!");
            } else if(txtPrecoCusto.getText().equals("")){
				JOptionPane.showMessageDialog(tela, "Campo Preço de Custo é Obrigatório!");
			} else if(txtPrecoVenda.getText().equals("")){
				JOptionPane.showMessageDialog(tela, "Campo Preço de Venda é Obrigatório!");
			}
			else{
                try {
                    Produto produto = new Produto();
                    produto.setNome(txtNome.getText());
                    produto.setDesc(txtDescricao.getText());
                    produto.setCategoria(txtCategoria.getText());
                    produto.setFornecedor(txtFornecedor.getText());
					produto.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText()));
					produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
                    
                    produtoDAO.salvar(produto);
                    JOptionPane.showMessageDialog(tela, "Salvo com sucesso!");
                    limpar();
                    abrirTela();
                // } catch (Exception ex) {
                //     JOptionPane.showMessageDialog(tela, "Erro ao salvar: " + ex.getMessage());
                // }
				} catch (Exception ex) {
					String msg = ex.getMessage();
				
					if (msg != null && msg.contains("fkDOC_FORNECEDOR")) {
						JOptionPane.showMessageDialog(tela, "Fornecedor inexistente no banco da dados!");
					} else {
						JOptionPane.showMessageDialog(tela, "Erro ao salvar: " + msg);
					}
				}
            }
			}
		});

		btnCancelar.addActionListener(e -> {
			desabilitar();
		});

		btnPesquisar.addActionListener(e -> {
			//codigo
			btnSalvar.setEnabled(false);
			if(txtCodigo.getText().equals("")){
                JOptionPane.showMessageDialog(tela, "Preencha o código do produto para pesquisar.");
				if (!txtCodigo.isEnabled()) {
					txtCodigo.setEnabled(true);
					txtCodigo.requestFocus();
					txtNome.setEnabled(false);
					txtDescricao.setEnabled(false);
					txtCategoria.setEnabled(false);
					txtFornecedor.setEnabled(false);
					txtPrecoCusto.setEnabled(false);
					txtPrecoVenda.setEnabled(false);
					limpar();    
				}                                  
            }else{
                try {
                    Produto produto = produtoDAO.buscarPorCodigo(Integer.parseInt(txtCodigo.getText()));
                    if(produto != null){
                        txtCodigo.setText(String.valueOf(produto.getCodigo()));
                        txtNome.setText(produto.getNome());
						txtDescricao.setText(produto.getDesc());
						txtCategoria.setText(produto.getCategoria());
						txtFornecedor.setText(produto.getFornecedor());
						txtPrecoCusto.setText(Double.toString(produto.getPrecoCusto()));
						txtPrecoVenda.setText(Double.toString(produto.getPrecoVenda()));
                        
                        txtCodigo.setEnabled(false);
                        btnCancelar.setEnabled(true);
                        btnNovo.setEnabled(false);
                        btnAlterar.setEnabled(true);
                        btnExcluir.setEnabled(true);

						txtNome.setEnabled(true);
						txtDescricao.setEnabled(true);
						txtCategoria.setEnabled(true);
						txtFornecedor.setEnabled(true);
						txtPrecoCusto.setEnabled(true);
						txtPrecoVenda.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(tela, "Produto não encontrado!");  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro ao pesquisar: " + ex.getMessage());
                }
			}
		});

		btnAlterar.addActionListener(e -> {
			//talvez fazer a implementação correta
			try {
                // implentar a função certa
                // liberar para alterar campos
                // talvez melhorar o funcionamento
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
                produto.setNome(txtNome.getText());
                produto.setDesc(txtDescricao.getText());
                produto.setCategoria(txtCategoria.getText());
                produto.setFornecedor(txtFornecedor.getText());
                produto.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText()));
                produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
                
                produtoDAO.atualizar(produto);
                JOptionPane.showMessageDialog(tela, "Atualizado com sucesso!");
                abrirTela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tela, "Erro ao atualizar: " + ex.getMessage());
            }
            limpar();
            abrirTela();
		});

		btnExcluir.addActionListener(e -> {
			//codigo
			try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                produtoDAO.excluir(codigo);
                JOptionPane.showMessageDialog(tela, "Produto excluído com sucesso!");
                limpar();
                abrirTela();            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tela, "Erro ao excluir: " + ex.getMessage());
            }
		});

		btnSair.addActionListener(e -> {
			tela.dispose();
			validarCargo(Cargo);
		});


        tela.setVisible(true);
    }

}