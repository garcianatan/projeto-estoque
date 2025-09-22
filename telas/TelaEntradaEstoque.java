import javax.swing.*;

import banco.EntradaEstoqueDAO;
import classes.EntradaEstoque;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class TelaEntradaEstoque {
    // Declaração dos componentes como variáveis de instância para acesso nos
    // métodos
    private JTextField txtN_Doc;
    private JTextField txtDate;
    private JTextField txtFornecedor;
    private JTextField txtProduto;
    private JTextField textquant;
    private JComboBox<String> cbtipos;
    private JPanel AlinharBotoes;
    private JButton btnNovo, btnConfirmar,btnCancelar,btnSair;
    private EntradaEstoqueDAO entradaEstoqueDAO;

    public void validarCargo(boolean cargo){
		if(cargo){
			new Menu(true);
		}else {
			new Menu(false);
		}
	}

    public void limpar() {
        txtN_Doc.setText("");
        txtDate.setText("");
        txtFornecedor.setText("");
        txtProduto.setText("");
        textquant.setText("");
        cbtipos.setSelectedIndex(0);
    }

    public void abrirTela() {
        txtN_Doc.setEnabled(false);
        txtDate.setEnabled(false);
        txtFornecedor.setEnabled(false);
        txtProduto.setEnabled(false);
        textquant.setEnabled(false);
        cbtipos.setEnabled(false);

        btnNovo.setEnabled(true);   
        btnConfirmar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    public void habilitar() {
        txtN_Doc.setEnabled(true);
        txtDate.setEnabled(true);
        txtFornecedor.setEnabled(true);
        txtProduto.setEnabled(true);
        textquant.setEnabled(true);
        cbtipos.setEnabled(true);
    }

    public void desabilitar() {
        abrirTela();
        limpar();
    }
 
    public TelaEntradaEstoque(boolean Cargo) {
        entradaEstoqueDAO = new EntradaEstoqueDAO();
        JFrame tela = new JFrame("Entrada de Estoque");
        tela.setSize(700, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.getContentPane().setBackground(new Color(5, 5, 50));
        tela.setLayout(new GridBagLayout());
 
        GridBagConstraints organizar = new GridBagConstraints();
        organizar.insets = new Insets(10, 5, 15, 5);
 
        organizar.anchor = GridBagConstraints.WEST;
        organizar.fill = GridBagConstraints.HORIZONTAL;
 
        int linha = 0;
 
        btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(81, 112, 255));
        btnSair.setForeground(Color.white);
        btnSair.setFocusPainted(false);
        organizar.gridx = 5;
        organizar.gridy = linha;
        organizar.anchor = GridBagConstraints.EAST;
        tela.add(btnSair, organizar);
        linha++;
       
        organizar.gridx = 0;
        organizar.gridy = linha;
        organizar.gridwidth = 2;
        organizar.anchor = GridBagConstraints.CENTER;
        organizar.insets = new Insets(5, 50, 20, 5);
       
        JLabel lbltitulo = new JLabel("Entrada de Estoque");
        lbltitulo.setForeground(Color.white);
        lbltitulo.setFont(new Font("Arial", Font.BOLD, 24));
        tela.add(lbltitulo, organizar);
 
       
 
        linha++;
       
        // N de documento
        organizar.anchor = GridBagConstraints.WEST;
        organizar.gridwidth = 1;
        organizar.gridx = 0;
        organizar.gridy = linha;
        organizar.insets = new Insets(5, 5, 20, 5);
        JLabel lblndoc = new JLabel("N°de Documento");
        lblndoc.setForeground(Color.white);
        tela.add(lblndoc, organizar);
        txtN_Doc = new JTextField(20);
        organizar.gridx = 1;
        tela.add( txtN_Doc , organizar);
       
        linha++;
    // Data de Entrada
    organizar.gridwidth = 1;
    organizar.gridx = 0;
    organizar.gridy = linha;
    JLabel lbldate = new JLabel("Data de Entrada:");
    lbldate.setForeground(Color.white);
    tela.add(lbldate, organizar);
    txtDate= new JTextField(20);
    organizar.gridx = 1;
    tela.add( txtDate , organizar);
 
     linha++;
     // Fornecedor
    organizar.gridwidth = 1;
    organizar.gridx = 0;
    organizar.gridy = linha;
    JLabel lblfornecedor = new JLabel("Fornecedor:");
    lblfornecedor.setForeground(Color.white);
    tela.add(lblfornecedor, organizar);
    txtFornecedor= new JTextField(20);
    organizar.gridx = 1;
    tela.add( txtFornecedor , organizar);
 
  linha++;
 
     // Produtos
    organizar.gridwidth = 1;
    organizar.gridx = 0;
    organizar.gridy = linha;
    JLabel lblproduto = new JLabel("Código do produto:");
    lblproduto.setForeground(Color.white);
    tela.add(lblproduto, organizar);
    txtProduto= new JTextField(20);
    organizar.gridx = 1;
    tela.add( txtProduto , organizar);
 
  linha++;
    // Quantidade
    organizar.gridwidth = 1;
    organizar.gridx = 0;
    organizar.gridy = linha;
    JLabel lblqaunt = new JLabel("Quantidade:");
    lblqaunt.setForeground(Color.white);
    tela.add(lblqaunt, organizar);
    textquant= new JTextField(20);
    organizar.gridx = 1;
    tela.add( textquant, organizar);
 
//tipos de entrada
    linha++;
    organizar.gridwidth = 1;
    organizar.gridx = 0;
    organizar.gridy = linha;
    JLabel lbltipo = new JLabel("Tipo de Entrada:");
    lbltipo.setForeground(Color.white);
    tela.add(lbltipo, organizar);
    String[] tipos = {
            "--Selecione o Tipo--", "Aquisição","Devolução","Armazenamento"
    };
    cbtipos = new JComboBox<>(tipos);
    organizar.gridx = 1;
    tela.add(cbtipos, organizar);
 
    //Botoes
   
    //novo
    linha++;
    organizar.gridx = 0;
        organizar.gridy = linha;
        organizar.gridwidth = 2;
        organizar.anchor = GridBagConstraints.CENTER;
 
        AlinharBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        AlinharBotoes.setBackground(new Color(5, 5, 50));
        btnNovo = new JButton("Novo");
        btnConfirmar = new JButton("Confirmar");
        btnCancelar = new JButton("Cancelar");
 
        AlinharBotoes.add(btnNovo);
        AlinharBotoes.add(btnConfirmar);
        AlinharBotoes.add(btnCancelar);
 
        tela.add(AlinharBotoes, organizar);
 
        btnSair.addActionListener(e -> {
            tela.dispose();
            validarCargo(Cargo);
        });

        btnNovo.addActionListener(e -> {
            habilitar();

            btnNovo.setEnabled(false);
            btnConfirmar.setEnabled(true);
            btnCancelar.setEnabled(true);
        });

        btnCancelar.addActionListener(e -> {
            desabilitar();
        });

        btnConfirmar.addActionListener(e -> {
            if(txtN_Doc.getText().equals("")){
                JOptionPane.showMessageDialog(tela, "Campo N° de documento é Obrigatório!");
            }
            else if (txtDate.getText().equals("")) {
                JOptionPane.showMessageDialog(tela, "Campo Data de Entrada é Obrigatório!");
            }
            else if(txtFornecedor.getText().equals("")) {
                JOptionPane.showMessageDialog(tela, "Campo Fornecedor é obrigatório!");
            }
            else if(txtProduto.getText().equals("")){
                JOptionPane.showMessageDialog(tela, "Campo Código do produto é Obrigatório!");
            } else if(textquant.getText().equals("")){
				JOptionPane.showMessageDialog(tela, "Campo Quantidade é Obrigatório!");
			} else if(cbtipos.getSelectedIndex() == 0){
				JOptionPane.showMessageDialog(tela, "Campo Tipo de Entrada é Obrigatório!");
			}
			else{
                try {
                    EntradaEstoque entrada = new EntradaEstoque();
                    entrada.setDocumento(txtN_Doc.getText());
                    entrada.setDataEntrada(txtDate.getText());
                    entrada.setFornecedor(txtFornecedor.getText());
                    entrada.setCod_produto(Integer.parseInt(txtProduto.getText()));
					entrada.setQuantidade(Integer.parseInt(textquant.getText()));
					if(cbtipos.getSelectedIndex() == 1){
                        entrada.setTipoEntrada("Aquisição");
                    }else if(cbtipos.getSelectedIndex() == 2){
                        entrada.setTipoEntrada("Devolução");
                    } else if(cbtipos.getSelectedIndex() == 3) {
                        entrada.setTipoEntrada("Armazenamento");
                    }
                    
                    entradaEstoqueDAO.confirmarEntrada(entrada);
                    JOptionPane.showMessageDialog(tela, "Entrada confirmada.");
                    limpar();
                    abrirTela();
				} catch (Exception ex) {
					String msg = ex.getMessage();
				
					if (msg != null && msg.contains("fkENTRADA_DOC_FORNECEDOR")) {
						JOptionPane.showMessageDialog(tela, "Fornecedor inexistente no banco da dados!");
					} else if(msg != null && msg.contains("fkENTRADA_COD_PRODUTO")) {
                        JOptionPane.showMessageDialog(tela, "Produto inexistente no banco da dados!");
                    } else {
						JOptionPane.showMessageDialog(tela, "Erro ao confirmar: " + msg);
					}
				}
            }
        });
        abrirTela();
        tela.setVisible(true);
 
    }
}
 
   // private JPasswordField jpfSenha;
   /*  private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JButton btnPesquisar;
    private JButton btnAlterar;
    private JButton btnExcluir;
*/
 
 
 
 
/*
        // Configurar estado inicial
        setEstadoInicial();
 
        // Adicionar ActionListeners
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitarCampos(true);
                btnSalvar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnNovo.setEnabled(false);
                btnPesquisar.setEnabled(false);
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
                txtId.setEnabled(false);
            }
        });
 
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
                setEstadoInicial();
            }
        });
 
    btnSalvar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtNome.getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Campo Nome Obrigatório!");
            }
            else if(txtLogin.getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Campo Login Obrigatório!");
            }
            else if(jpfSenha.getPassword().length == 0){
                JOptionPane.showMessageDialog(frame, "Campo Senha Obrigatório!");
            }else{
                try {
                    Usuario usuario = new Usuario();
                    usuario.setNome(txtNome.getText());
                    usuario.setLogin(txtLogin.getText());
                    usuario.setSenha(new String(jpfSenha.getPassword()));
                   
                    usuarioDAO.salvar(usuario);
                    JOptionPane.showMessageDialog(frame, "Salvo com sucesso!");
                    limparCampos();
                    setEstadoInicial();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao salvar: " + ex.getMessage());
                }
            }
        }
    });
 
    btnPesquisar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtLogin.getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Preencher o campo Login!");                                      
            }else{
                try {
                    Usuario usuario = usuarioDAO.buscarPorLogin(txtLogin.getText());
                    if(usuario != null){
                        txtId.setText(String.valueOf(usuario.getId()));
                        txtNome.setText(usuario.getNome());
                        txtLogin.setText(usuario.getLogin());
                        jpfSenha.setText(usuario.getSenha());
                        txtLogin.setEnabled(false);
                        btnCancelar.setEnabled(true);
                        btnNovo.setEnabled(false);
                        btnAlterar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Usuário não encontrado!");  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao pesquisar: " + ex.getMessage());
                }
            }                
        }
    });
 
    btnAlterar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(txtId.getText()));
                usuario.setNome(txtNome.getText());
                usuario.setLogin(txtLogin.getText());
                usuario.setSenha(new String(jpfSenha.getPassword()));
               
                usuarioDAO.atualizar(usuario);
                JOptionPane.showMessageDialog(frame, "Atualizado com sucesso!");
                setEstadoInicial();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao atualizar: " + ex.getMessage());
            }
        }
    });
 
    btnExcluir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(txtId.getText());
                usuarioDAO.excluir(id);
                JOptionPane.showMessageDialog(frame, "Usuário excluído com sucesso!");
                limparCampos();
                setEstadoInicial();            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao excluir: " + ex.getMessage());
            }
        }
    });
        frame.setVisible(true);
    }
 
    private void setEstadoInicial() {
        // Campos: apenas login habilitado
        txtId.setEnabled(false);
        txtNome.setEnabled(false);
        txtLogin.setEnabled(true);
        jpfSenha.setEnabled(false);
 
        // Botões: novo e pesquisar habilitados; outros desabilitados
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
 
        limparCampos();
    }
 
    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtLogin.setText("");
        jpfSenha.setText("");
    }
 
    private void habilitarCampos(boolean habilitar) {
        txtId.setEnabled(habilitar);
        txtNome.setEnabled(habilitar);
        txtLogin.setEnabled(habilitar);
        jpfSenha.setEnabled(habilitar);
    }
 
}
*/
 