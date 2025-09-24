import java.awt.*;
import javax.swing.*;

import banco.FornecedorDAO;
import classes.Fornecedor;
 
public class CadastroFornecedor {
	private JTextField Campo_Nome, Campo_CPFCNPJ, Campo_Telefone, Campo_Email, Campo_Endereco;
	private JButton Botao_Sair, Botao_Novo, Botao_Salvar, Botao_Cancelar, Botao_Pesquisar, Botao_Alterar, Botao_Excluir;
	private FornecedorDAO fornecedorDAO;
	
	public void AbrirTela() {

		Campo_Nome.setEnabled(false);
		Campo_CPFCNPJ.setEnabled(false);
		Campo_Telefone.setEnabled(false);
		Campo_Email.setEnabled(false);
		Campo_Endereco.setEnabled(false);
		Botao_Sair.setEnabled(true);
		Botao_Novo.setEnabled(true);
		Botao_Salvar.setEnabled(false);
		Botao_Cancelar.setEnabled(false);
		Botao_Pesquisar.setEnabled(true);
		Botao_Alterar.setEnabled(false);
		Botao_Excluir.setEnabled(false);
	}

	public void LimparCampos() {

		Campo_Nome.setText("");
		Campo_CPFCNPJ.setText("");
		Campo_Telefone.setText("");
		Campo_Email.setText("");
		Campo_Endereco.setText("");

	}

	public void HabilitarCampos() {

		Campo_Nome.setEnabled(true);
		Campo_CPFCNPJ.setEnabled(true);
		Campo_Telefone.setEnabled(true);
		Campo_Email.setEnabled(true);
		Campo_Endereco.setEnabled(true);

	}

	public void DesabilitarCampos() {

		Campo_Nome.setEnabled(false);
		Campo_CPFCNPJ.setEnabled(false);
		Campo_Telefone.setEnabled(false);
		Campo_Email.setEnabled(false);
		Campo_Endereco.setEnabled(false);

	}

	public void validarCargo(boolean cargo){
		if(cargo){
			new Menu(true);
		}else {
			new Menu(false);
		}
	}

	public CadastroFornecedor(boolean Cargo) {
		fornecedorDAO = new FornecedorDAO();
		JFrame Tela = new JFrame("Cadastro de Fornecedores");

		Tela.setSize(700, 600);
		Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tela.setResizable(false);
		Tela.setLayout(new GridBagLayout());
		Tela.getContentPane().setBackground(new Color(5, 5, 50));

		GridBagConstraints GBC = new GridBagConstraints();
		GBC.insets = new Insets(20, 10, 10, 10);
		GBC.anchor = GridBagConstraints.WEST;

		int linha = 0;

		Botao_Sair = new JButton("Sair");
		Botao_Sair.setBackground(new Color(81, 112, 255));
        Botao_Sair.setForeground(Color.white);
        Botao_Sair.setFocusPainted(false);
		GBC.gridx = 5;
		GBC.gridy = linha;
		GBC.anchor = GridBagConstraints.EAST;
		Tela.add(Botao_Sair, GBC);
		linha++;

		JLabel Label_Titulo = new JLabel("Cadastro de Fornecedores");
		GridBagConstraints gbcTitulo = new GridBagConstraints(); // NOVO CONSTRAINT
		gbcTitulo.gridx = 0;
		gbcTitulo.gridy = linha;
		gbcTitulo.gridwidth = 2; // ocupa todas as colunas
		gbcTitulo.anchor = GridBagConstraints.CENTER;
		gbcTitulo.insets = new Insets(20, 10, 30, 10);
		Tela.add(Label_Titulo, gbcTitulo);
		Label_Titulo.setForeground(Color.white);
		Label_Titulo.setFont(new Font("Calibri", Font.BOLD, 30));
		linha++;

		JLabel Label_CPFCNPJ = new JLabel("CPF/CNPJ:");
		Label_CPFCNPJ.setForeground(Color.white);
		GBC.anchor = GridBagConstraints.WEST;
		GBC.gridx = 0;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 100, 10, 10); // margem esquerda maior
		Tela.add(Label_CPFCNPJ, GBC);

		Campo_CPFCNPJ = new JTextField(20);
		GBC.anchor = GridBagConstraints.EAST;
		GBC.gridx = 1;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 10, 10, 100); // margem direita maior
		Tela.add(Campo_CPFCNPJ, GBC);
		linha++;

		JLabel Label_Nome = new JLabel("Nome:");
		Label_Nome.setForeground(Color.white);
		GBC.anchor = GridBagConstraints.WEST; // ALINHADO À DIREITA
		GBC.gridx = 0;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 100, 10, 10); // margem esquerda maior
		Tela.add(Label_Nome, GBC);

		Campo_Nome = new JTextField(20);
		GBC.anchor = GridBagConstraints.EAST; // ALINHADO À ESQUERDA
		GBC.gridx = 1;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 10, 10, 100); // margem direita maior
		Tela.add(Campo_Nome, GBC);
		linha++;

		JLabel Label_Telefone = new JLabel("Telefone:");
		Label_Telefone.setForeground(Color.white);
		GBC.anchor = GridBagConstraints.WEST; // ALINHADO À DIREITA
		GBC.gridx = 0;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 100, 10, 10); // margem esquerda maior
		Tela.add(Label_Telefone, GBC);

		Campo_Telefone = new JTextField(20);
		GBC.anchor = GridBagConstraints.EAST; // ALINHADO À ESQUERDA
		GBC.gridx = 1;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 10, 10, 100); // margem direita maior
		Tela.add(Campo_Telefone, GBC);
		linha++;

		JLabel Label_Email = new JLabel("E-mail:");
		Label_Email.setForeground(Color.white);
		GBC.anchor = GridBagConstraints.WEST; // ALINHADO À DIREITA
		GBC.gridx = 0;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 100, 10, 10); // margem esquerda maior
		Tela.add(Label_Email, GBC);

		Campo_Email = new JTextField(20);
		GBC.anchor = GridBagConstraints.EAST; // ALINHADO À ESQUERDA
		GBC.gridx = 1;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 10, 10, 100); // margem direita maior
		Tela.add(Campo_Email, GBC);
		linha++;

		JLabel Label_Endereco = new JLabel("Endereço:");
		Label_Endereco.setForeground(Color.white);
		GBC.anchor = GridBagConstraints.WEST; // ALINHADO À DIREITA
		GBC.gridx = 0;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 100, 10, 10); // margem esquerda maior
		Tela.add(Label_Endereco, GBC);

		Campo_Endereco = new JTextField(20);
		GBC.anchor = GridBagConstraints.EAST; // ALINHADO À ESQUERDA
		GBC.gridx = 1;
		GBC.gridy = linha;
		GBC.insets = new Insets(10, 10, 10, 100); // margem direita maior
		Tela.add(Campo_Endereco, GBC);
		linha++;

		Botao_Novo = new JButton("Novo");
		Botao_Novo.setBackground(new Color(128, 128, 128));
        Botao_Novo.setForeground(Color.WHITE);
        Botao_Novo.setFocusPainted(false);

		Botao_Salvar = new JButton("Salvar");
		Botao_Salvar.setBackground(new Color(128, 128, 128));
        Botao_Salvar.setForeground(Color.WHITE);
        Botao_Salvar.setFocusPainted(false);

		Botao_Cancelar = new JButton("Cancelar");
		Botao_Cancelar.setBackground(new Color(128, 128, 128));
        Botao_Cancelar.setForeground(Color.WHITE);
        Botao_Cancelar.setFocusPainted(false);

		Botao_Pesquisar = new JButton("Pesquisar");
		Botao_Pesquisar.setBackground(new Color(128, 128, 128));
        Botao_Pesquisar.setForeground(Color.WHITE);
        Botao_Pesquisar.setFocusPainted(false);

		Botao_Alterar = new JButton("Alterar");
		Botao_Alterar.setBackground(new Color(128, 128, 128));
        Botao_Alterar.setForeground(Color.WHITE);
        Botao_Alterar.setFocusPainted(false);

		Botao_Excluir = new JButton("Excluir");
		Botao_Excluir.setBackground(new Color(128, 128, 128));
        Botao_Excluir.setForeground(Color.WHITE);
        Botao_Excluir.setFocusPainted(false);

		JPanel AlinharBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
		AlinharBotoes.setBackground(new Color(5, 5, 50));
		AlinharBotoes.add(Botao_Novo);
		AlinharBotoes.add(Botao_Salvar);
		AlinharBotoes.add(Botao_Cancelar);
		AlinharBotoes.add(Botao_Pesquisar);
		AlinharBotoes.add(Botao_Alterar);
		AlinharBotoes.add(Botao_Excluir);

		GBC.gridx = 0;
		GBC.gridy = linha;
		GBC.gridwidth = 2;
		GBC.anchor = GridBagConstraints.CENTER;
		GBC.insets = new Insets(5, 5, 5, 5);
		Tela.add(AlinharBotoes, GBC);

		Botao_Novo.addActionListener(e -> {
			HabilitarCampos();
			LimparCampos();
			Botao_Novo.setEnabled(false);
			Botao_Salvar.setEnabled(true);
			Botao_Cancelar.setEnabled(true);
			Botao_Pesquisar.setEnabled(false);
			Botao_Alterar.setEnabled(false);
			Botao_Excluir.setEnabled(false);
		});

		Botao_Salvar.addActionListener(e -> {
			if(Campo_CPFCNPJ.getText().equals("")){
                JOptionPane.showMessageDialog(Tela, "Campo CPF/CNPJ é Obrigatório!");
            }
            else if (Campo_Nome.getText().equals("")) {
                JOptionPane.showMessageDialog(Tela, "Campo Nome é Obrigatório!");
            }
            else if(Campo_Telefone.getText().equals("")) {
                JOptionPane.showMessageDialog(Tela, "Campo Telefone é obrigatório!");
            }
            else if(Campo_Email.getText().equals("")){
                JOptionPane.showMessageDialog(Tela, "Campo E-mail é Obrigatório!");
            } else if(Campo_Endereco.getText().equals("")){
				JOptionPane.showMessageDialog(Tela, "Campo Endereço é Obrigatório!");
			} else{
                try {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setDocumento(Campo_CPFCNPJ.getText());
                    fornecedor.setNome(Campo_Nome.getText());
                    fornecedor.setTelefone(Campo_Telefone.getText());
                    fornecedor.setEmail(Campo_Email.getText());
					fornecedor.setEndereco(Campo_Endereco.getText());
                    
                    fornecedorDAO.salvar(fornecedor);
                    JOptionPane.showMessageDialog(Tela, "Salvo com sucesso!");
                    LimparCampos();
			AbrirTela();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Tela, "Erro ao salvar: " + ex.getMessage());
                }
            }


			
		});

		Botao_Cancelar.addActionListener(e -> {
			LimparCampos();
			AbrirTela();
		});

		Botao_Pesquisar.addActionListener(e -> {
			if(Campo_CPFCNPJ.getText().equals("")){
                JOptionPane.showMessageDialog(Tela, "Preencher o campo CPF/CNPJ!");
				Campo_CPFCNPJ.setEnabled(true);
				Campo_CPFCNPJ.requestFocus();
				                                      
            }else{
                try {
                    Fornecedor fornecedor = fornecedorDAO.buscarPorDocumento(Campo_CPFCNPJ.getText());
                    if(fornecedor != null){
                        Campo_CPFCNPJ.setText(fornecedor.getDocumento());
                        Campo_Nome.setText(fornecedor.getNome());
                        Campo_Telefone.setText(fornecedor.getTelefone());
                        Campo_Email.setText(fornecedor.getEmail());
                        Campo_Endereco.setText(fornecedor.getEndereco());
                        
						Botao_Novo.setEnabled(false);
						Botao_Salvar.setEnabled(false);
						Botao_Cancelar.setEnabled(true);
						Botao_Pesquisar.setEnabled(false);
						Botao_Alterar.setEnabled(true);
						Botao_Excluir.setEnabled(true);

                        Campo_CPFCNPJ.setEnabled(true);
                        Campo_Nome.setEnabled(true);
                        Campo_Telefone.setEnabled(true);
                        Campo_Email.setEnabled(true);
                        Campo_Endereco.setEnabled(true);

                    }else{
                        JOptionPane.showMessageDialog(Tela, "Fornecedor não encontrado!");  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Tela, "Erro ao pesquisar: " + ex.getMessage());
                }
            }
		});

		Botao_Alterar.addActionListener(e -> {
			//talvez fazer a implementação correta
			try {
                // implentar a função certa
                // liberar para alterar campos
                // talvez melhorar o funcionamento
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setDocumento(Campo_CPFCNPJ.getText());
            	fornecedor.setNome(Campo_Nome.getText());
            	fornecedor.setTelefone(Campo_Telefone.getText());
            	fornecedor.setEmail(Campo_Email.getText());
            	fornecedor.setEndereco(Campo_Endereco.getText());
                
                fornecedorDAO.atualizar(fornecedor);
                JOptionPane.showMessageDialog(Tela, "Atualizado com sucesso!");
                AbrirTela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Tela, "Erro ao atualizar: " + ex.getMessage());
            }
            LimparCampos();
            AbrirTela();
		});

		Botao_Excluir.addActionListener(e -> {
			

			try {
                String documento = Campo_CPFCNPJ.getText();
                fornecedorDAO.excluir(documento);
                JOptionPane.showMessageDialog(Tela, "Fornecedor excluído com sucesso!");
                LimparCampos();
                AbrirTela();            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Tela, "Erro ao excluir: " + ex.getMessage());
            }
		});

        Botao_Sair.addActionListener(e -> {
            Tela.dispose();
			validarCargo(Cargo);
		});

		AbrirTela();
		Tela.setVisible(true);
	}
}
