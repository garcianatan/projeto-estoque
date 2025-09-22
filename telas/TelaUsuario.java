import javax.swing.*;

import banco.UsuarioDAO;
import classes.Usuario;

import java.awt.*;

// criar tela login
// alterar tipo saida na tela saidaEstoque pra combobox

public class TelaUsuario {
    private JTextField txtnome;
    private JTextField txtid;
    private String[] cargo = {
        "--Selecionar Cargo--", "Administrador", "Funcionário"
    };
    private JComboBox<String> cbcargo = new JComboBox<>(cargo);
    private JTextField txtemail;
    private JPasswordField txtsenha;

    private JButton btnnovo;
    private JButton btnsalvar;
    private JButton btncancelar;
    private JButton btnpesquisar;
    private JButton btnalterar;
    private JButton btnexcluir;
    private JButton btnSair;

    private UsuarioDAO usuarioDAO;
    
    public void habilitar(){
        txtnome.setEnabled(true);
        txtid.setEnabled(true);
        cbcargo.setEnabled(true);
        txtemail.setEnabled(true);
        txtsenha.setEnabled(true);

        btnnovo.setEnabled(true);
        btncancelar.setEnabled(true);
        btnsalvar.setEnabled(true);
        btnpesquisar.setEnabled(true);
        btnalterar.setEnabled(true);
        btnexcluir.setEnabled(true);
    }

    public void limparCampos(){
        txtnome.setText("");
        txtid.setText("");
        cbcargo.setSelectedIndex(0);
        txtemail.setText("");
        txtsenha.setText("");
    }

    public void abrirTela(){
        habilitar();
        txtid.setEnabled(false);
        txtnome.setEnabled(false);
        cbcargo.setEnabled(false);
        txtemail.setEnabled(true);
        txtsenha.setEnabled(false);

        btncancelar.setEnabled(false);
        btnsalvar.setEnabled(false);
        btnalterar.setEnabled(false);
        btnexcluir.setEnabled(false);
    }

    private void estilizarLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public void validarCargo(boolean cargo){
		if(cargo){
			new Menu(true);
		}else {
			new Menu(false);
		}
	}

    public TelaUsuario(boolean Cargo){
        usuarioDAO = new UsuarioDAO();
        JFrame telaUsuario = new JFrame("Cadastro de Usuários");
        telaUsuario.setSize(700, 600);
        telaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaUsuario.setResizable(false);
        telaUsuario.setLayout(new GridBagLayout());
        GridBagConstraints A = new GridBagConstraints();
        A.insets = new Insets(5, 5, 5, 5);
        telaUsuario.getContentPane().setBackground(new Color(5, 5, 50));
        A.anchor = GridBagConstraints.WEST;
        A.fill = GridBagConstraints.HORIZONTAL;

        int linha = 0;

        btnSair = new JButton("Sair");
		A.gridx = 5;
        A.gridy = linha;
        A.gridwidth = 1;
		telaUsuario.add(btnSair, A);
        linha++;

        JLabel lbltitulo = new JLabel("Gerenciador de Usuários");
        lbltitulo.setFont(new Font("Arial", Font.BOLD, 30));
        lbltitulo.setForeground(Color.WHITE);
        A.gridx = 2;
        A.gridy = linha;
        telaUsuario.add(lbltitulo, A);
        linha++;
        
        JLabel lblid = new JLabel("Id: ");
        estilizarLabel(lblid);
        A.gridx = 1;
        A.gridy = linha;
        A.gridwidth = 1;
        telaUsuario.add(lblid, A);

        txtid = new JTextField(10);
        A.gridx = 2;
        A.gridwidth = 3;
        telaUsuario.add(txtid, A);
        linha++;


        JLabel lblnome = new JLabel("Nome: ");
        estilizarLabel(lblnome);
        A.gridx = 1;
        A.gridy = linha;
        A.gridwidth = 1;
        telaUsuario.add(lblnome, A);

        txtnome = new JTextField(10);
        A.gridx = 2;
        A.gridwidth = 3;
        telaUsuario.add(txtnome, A);
        linha++;

        JLabel lblcargo = new JLabel("Cargo: ");
        estilizarLabel(lblcargo);
        A.gridx = 1;
        A.gridy = linha;
        A.gridwidth = 1;
        telaUsuario.add(lblcargo, A);

        A.gridx = 2;
        A.gridwidth = 3;
        telaUsuario.add(cbcargo, A);
        linha++;

        JLabel lblemail = new JLabel("Email: ");
        estilizarLabel(lblemail);
        A.gridx = 1;
        A.gridy = linha;
        A.gridwidth = 1;
        telaUsuario.add(lblemail, A);

        txtemail = new JTextField(15);
        A.gridx = 2;
        A.gridwidth = 3;
        telaUsuario.add(txtemail, A);
        linha++;

        JLabel lblsenha = new JLabel("Senha: ");
        estilizarLabel(lblsenha);
        A.gridx = 1;
        A.gridy = linha;
        A.gridwidth = 1;
        telaUsuario.add(lblsenha, A);

        txtsenha = new JPasswordField(10);
        A.gridx = 2;
        A.gridwidth = 3;
        telaUsuario.add(txtsenha, A);
        linha++;


        // Botão Novo
        btnnovo = new JButton("Novo");
		telaUsuario.add(btnnovo, A);
		
		//Botão Cancelar
		btncancelar = new JButton("Cancelar");
		telaUsuario.add(btncancelar, A);
		
		//Botão Alterar
		btnalterar = new JButton("Alterar");
		A.gridy = linha;
		telaUsuario.add(btnalterar, A);
		
		//Botão Salvar
		btnsalvar = new JButton("Salvar");
		telaUsuario.add(btnsalvar, A);
		
		//Botão Pesquisar
		btnpesquisar = new JButton("Pesquisar");
		telaUsuario.add(btnpesquisar, A);
		
		//Botão Excluir
		btnexcluir = new JButton("Excluir");
		telaUsuario.add(btnexcluir, A);

        JPanel AlinharBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JPanel AlinharBotoes2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        AlinharBotoes.add(btnnovo);
        AlinharBotoes.add(btnsalvar);
        AlinharBotoes.add(btncancelar);
        AlinharBotoes2.add(btnpesquisar);
        AlinharBotoes2.add(btnalterar);
        AlinharBotoes2.add(btnexcluir);


        AlinharBotoes.setBackground(new Color(5, 5, 50));
        AlinharBotoes2.setBackground(new Color(5, 5, 50));
        A.gridx = 0;
        telaUsuario.add(AlinharBotoes, A);
        linha++;
        A.gridy = linha;
        telaUsuario.add(AlinharBotoes2, A);

        btnnovo.addActionListener(e -> {
                habilitar();
                limparCampos();
                btnnovo.setEnabled(false);
                btnpesquisar.setEnabled(false);
                btnalterar.setEnabled(false);
                btnexcluir.setEnabled(false);

                txtid.setEnabled(false);
            }
        );

        btncancelar.addActionListener(e -> {
            limparCampos();
            abrirTela();
            }
        );

        btnsalvar.addActionListener(e -> {
            if(txtnome.getText().equals("")){
                JOptionPane.showMessageDialog(telaUsuario, "Campo Nome Obrigatório!");
            }
            // else if(txtid.getText().equals("")){
            //     JOptionPane.showMessageDialog(telaUsuario, "Campo Login Obrigatório!");
            // }
            else if (cbcargo.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(telaUsuario, "Campo Cargo Obrigatório!");
            }
            else if(txtemail.getText().equals("")) {
                JOptionPane.showMessageDialog(telaUsuario, "Campo Email é obrigatório!");
            }
            else if(txtsenha.getPassword().length == 0){
                JOptionPane.showMessageDialog(telaUsuario, "Campo Senha Obrigatório!");
            }else{
                try {
                    Usuario usuario = new Usuario();
                    usuario.setNome(txtnome.getText());
                    if(cbcargo.getSelectedIndex() == 1){
                        usuario.setCargo("Administrador");
                    }else{
                        usuario.setCargo("Funcionario");
                    }
                    
                    usuario.setEmail(txtemail.getText());
                    usuario.setSenha(new String(txtsenha.getPassword()));
                    
                    usuarioDAO.salvar(usuario);
                    JOptionPane.showMessageDialog(telaUsuario, "Salvo com sucesso!");
                    limparCampos();
                    abrirTela();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(telaUsuario, "Erro ao salvar: " + ex.getMessage());
                }
            }

            
        }
        );

        btnpesquisar.addActionListener(e -> {
            if(txtemail.getText().equals("")){
                JOptionPane.showMessageDialog(telaUsuario, "Preencher o campo Email!");                                      
            }else{
                try {
                    Usuario usuario = usuarioDAO.buscarPorEmail(txtemail.getText());
                    if(usuario != null){
                        txtid.setText(String.valueOf(usuario.getId()));
                        txtnome.setText(usuario.getNome());
                    
                        if(usuario.getCargo().equals("Administrador")){
                            cbcargo.setSelectedIndex(1);
                        } else{
                            cbcargo.setSelectedIndex(2);
                        }
                        
                        
                        txtemail.setText(usuario.getEmail());
                        txtsenha.setText(usuario.getSenha());
                        // txtemail.setEnabled(false);
                        btncancelar.setEnabled(true);
                        btnnovo.setEnabled(false);
                        btnalterar.setEnabled(true);
                        btnexcluir.setEnabled(true);
                        txtnome.setEnabled(true);
                        cbcargo.setEnabled(true);
                        txtemail.setEnabled(true);
                        txtsenha.setEnabled(true);

                    }else{
                        JOptionPane.showMessageDialog(telaUsuario, "Usuário não encontrado!");  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(telaUsuario, "Erro ao pesquisar: " + ex.getMessage());
                }
            }           
        });

        btnalterar.addActionListener(e -> {
            try {
                // implentar a função certa
                // liberar para alterar campos
                // talvez melhorar o funcionamento
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(txtid.getText()));
                usuario.setNome(txtnome.getText());
                if(cbcargo.getSelectedIndex() == 1){
                    usuario.setCargo("Administrador");
                }else{
                    usuario.setCargo("Funcionario");
                }
                usuario.setEmail(txtemail.getText());
                usuario.setSenha(new String(txtsenha.getPassword()));
                
                usuarioDAO.atualizar(usuario);
                JOptionPane.showMessageDialog(telaUsuario, "Atualizado com sucesso!");
                abrirTela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaUsuario, "Erro ao atualizar: " + ex.getMessage());
            }
            limparCampos();
            abrirTela();
        });

        btnexcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtid.getText());
                usuarioDAO.excluir(id);
                JOptionPane.showMessageDialog(telaUsuario, "Usuário excluído com sucesso!");
                limparCampos();
                abrirTela();            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaUsuario, "Erro ao excluir: " + ex.getMessage());
            }
        });

        btnSair.addActionListener(e -> {
            telaUsuario.dispose();
            validarCargo(Cargo);
        });

        abrirTela();
        telaUsuario.setVisible(true);
    }
}
