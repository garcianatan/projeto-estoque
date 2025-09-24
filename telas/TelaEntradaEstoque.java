import javax.swing.*;

import banco.EntradaEstoqueDAO;
import classes.EntradaEstoque;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 
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
        
        txtDate.setText("");
        txtFornecedor.setText("");
        txtProduto.setText("");
        textquant.setText("");
        cbtipos.setSelectedIndex(0);
    }

    public void abrirTela() {
    
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
        organizar.insets = new Insets(5, 150, 20, 5);
       
        JLabel lbltitulo = new JLabel("Entrada de Estoque");
        lbltitulo.setForeground(Color.white);
        lbltitulo.setFont(new Font("Arial", Font.BOLD, 24));
        tela.add(lbltitulo, organizar);
 
       
       
        linha++;
    // Data de Entrada
    organizar.insets = new Insets(5, 50, 20, 5);
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
    JLabel lblfornecedor = new JLabel("Documento do Fornecedor:");
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
    JLabel lblproduto = new JLabel("Código do Produto:");
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
    String[] tipos = {"-- Selecione o Tipo --", "Aquisição","Devolução","Armazenamento"};
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
        btnNovo.setBackground(new Color(128, 128, 128));
        btnNovo.setForeground(Color.WHITE);
        btnNovo.setFocusPainted(false);
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBackground(new Color(128, 128, 128));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(128, 128, 128));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        
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

            LocalDate hoje = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // ou ""
			txtDate.setText(hoje.format(formatter));


            btnNovo.setEnabled(false);
            btnConfirmar.setEnabled(true);
            btnCancelar.setEnabled(true);
        });

        btnCancelar.addActionListener(e -> {
            desabilitar();
        });

        btnConfirmar.addActionListener(e -> {
            
            if(txtFornecedor.getText().equals("")) {
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
                    
                    entrada.setDataEntrada(java.time.LocalDate.now());
                    entrada.setFornecedor(txtFornecedor.getText());
                    entrada.setCod_produto(Integer.parseInt(txtProduto.getText()));


					// entrada.setQuantidade(Integer.parseInt(textquant.getText()));

                    int quantidade;
                    try {
                        quantidade = Integer.parseInt(textquant.getText());
                        if (quantidade <= 0) {
                            JOptionPane.showMessageDialog(tela, "A quantidade deve ser maior que zero!");
                            return; // impede continuar
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(tela, "Informe um número válido na quantidade!");
                        return; // impede continuar
                    }
                    entrada.setQuantidade(quantidade);


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
 