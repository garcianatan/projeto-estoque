import javax.swing.*;

import banco.UsuarioDAO;
import classes.Usuario;

import java.awt.*;

public class Login extends JFrame{
    
    private JFrame tela;
    private JLabel lblTitulo, lblLogin, lblSenha, lblImagem;
    private JTextField txtLogin;
	private String txtCargo = "Admin";
    private JPasswordField Senha;
    private JButton btnEntrar, btnSair, btnEsqueceuSenha;
    private ImageIcon imagem;
	private UsuarioDAO usuarioDAO;

    private void estilizarLabel(JLabel label) {
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 14));
	}

	public String getCargo(){
		return txtCargo;
	}
 
    public boolean validarCargo(){
        if(getCargo().equals("Administrador")){
            return true;
        }else{
            return false;
        }
    }

    public Login() {
		usuarioDAO = new UsuarioDAO();
        tela = new JFrame("Login");
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
		gbc.gridwidth = 4;
		// gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 40, 5); 
		lblTitulo = new JLabel("Sistema de Controle de Estoque");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(Color.WHITE);
		tela.add(lblTitulo, gbc);

        linha++;

        imagem = new ImageIcon("telas/imagens/Usuarios.png");
        lblImagem = new JLabel();
        lblImagem.setIcon(imagem);
        lblImagem.setHorizontalTextPosition(SwingConstants.CENTER);
        lblImagem.setVerticalTextPosition(SwingConstants.BOTTOM);
        gbc.gridx = 3;
        gbc.gridy = linha;
        gbc.insets = new Insets(5, 80, 40, 5); 
        tela.add(lblImagem, gbc);

        linha++;

        gbc.insets = new Insets(5, 5, 10, 5);
		gbc.gridy = linha;
		gbc.gridx = 1;
		gbc.gridwidth = 2;
        lblLogin = new JLabel("Email");
		estilizarLabel(lblLogin);
        tela.add(lblLogin, gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 6;
		txtLogin = new JTextField(15);
		gbc.insets = new Insets(5, 50, 5, 5);
		tela.add(txtLogin, gbc);

		linha++;


		gbc.gridx = 1;
		gbc.gridy = linha;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		lblSenha = new JLabel("Senha");
		estilizarLabel(lblSenha);
		tela.add(lblSenha, gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 6;
		gbc.insets = new Insets(5, 50, 5, 5);
		Senha = new JPasswordField(15);
		tela.add(Senha, gbc);

		linha++;

        gbc.gridx = 2;
		gbc.gridy = linha;
		gbc.insets = new Insets(40, 40, 5, 5); 
		btnEntrar = new JButton("Entrar");
		tela.add(btnEntrar, gbc);

		gbc.gridx = 3;
        gbc.insets = new Insets(40, 180, 5, 5);
		btnSair = new JButton("Sair");
		tela.add(btnSair, gbc);

        linha++; 

        gbc.insets = new Insets(40, 40, 5, 5);
		gbc.gridx = 4;
        gbc.gridy = linha;
		// btnEsqueceuSenha = new JButton("Esqueceu a senha?");
		// tela.add(btnEsqueceuSenha, gbc);

		JLabel lblEsqueceuSenha = new JLabel("Esqueceu a senha?");
		tela.add(lblEsqueceuSenha, gbc);
		lblEsqueceuSenha.setForeground(Color.WHITE);
		lblEsqueceuSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblEsqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                JOptionPane.showMessageDialog(tela, "Contate o administrador.");
            }
        });

        tela.setVisible(true);

        btnEntrar.addActionListener(e -> {
            String email = txtLogin.getText();
            String senhaDigitada = new String(Senha.getPassword());
           
            if(email.isEmpty() || senhaDigitada.isEmpty()){
                JOptionPane.showMessageDialog(tela, "Preencha usuário e senha!");
                return;
            }
           
            Usuario usuario = usuarioDAO.buscarLogin(email, senhaDigitada);
            if(usuario != null){
                tela.dispose();
                boolean ehAdmin = usuario.getCargo().equalsIgnoreCase("Administrador");
                new Menu(ehAdmin);
            } else {
                JOptionPane.showMessageDialog(tela, "Usuário ou senha inválidos!");
            }
        });

        /*btnEntrar.addActionListener(e -> {
			tela.dispose();
			new Menu(validarCargo());

			// if(txtLogin.getText().equals("")){
            //     JOptionPane.showMessageDialog(tela, "Preencher o campo Email!");                                      
            // }else{
            //     try {
            //         Usuario usuario = usuarioDAO.buscarPorLogin(txtemail.getText());
            //         if(usuario != null){
            //             txtid.setText(String.valueOf(usuario.getId()));
            //             txtnome.setText(usuario.getNome());
                    
            //             if(usuario.getCargo().equals("Administrador")){
            //                 cbcargo.setSelectedIndex(1);
            //             } else{
            //                 cbcargo.setSelectedIndex(2);
            //             }
                        
                        
            //             txtemail.setText(usuario.getEmail());
            //             txtsenha.setText(usuario.getSenha());
            //             // txtemail.setEnabled(false);
            //             btncancelar.setEnabled(true);
            //             btnnovo.setEnabled(false);
            //             btnalterar.setEnabled(true);
            //             btnexcluir.setEnabled(true);
            //             txtnome.setEnabled(true);
            //             cbcargo.setEnabled(true);
            //             txtemail.setEnabled(true);
            //             txtsenha.setEnabled(true);

            //         }else{
            //             JOptionPane.showMessageDialog(telaUsuario, "Usuário não encontrado!");  
            //         }
            //     } catch (Exception ex) {
            //         JOptionPane.showMessageDialog(telaUsuario, "Erro ao pesquisar: " + ex.getMessage());
            //     }
            // }
        });*/

        btnSair.addActionListener(e -> {
            tela.dispose();
        });

        btnEsqueceuSenha.addActionListener(e -> {
            
        });

		// lblmsn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // lblmsn2.addMouseListener(new java.awt.event.MouseAdapter() {
        //     @Override
        //     public void mouseClicked(java.awt.event.MouseEvent e) {
        //         tela.dispose(); // Fecha login
        //         new TelaUsuario(); // Abre cadastro
        //     }
        // });
 
    }
}
