// import java.awt.*;
// import java.awt.event.FocusAdapter;
// import java.awt.event.FocusEvent;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
 
// public class Movimentacoes {
 
//     private JTextField Campo_Pesquisa;
//     private JButton Botao_Sair, Botao_Pesquisa, Botao_Detalhar, Botao_Exportar, Botao_Imprimir;
//     private JTable Tabela_Movimentacoes;
//     private DefaultTableModel df;
//     private Object[] coluna = {"Data", "Movimento", "Tipo", "Nº do Documento", "Produto", "Quantidade", "Usuário Responsável"};
//     private Object[][] linha_tabela = {{"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""},
//     {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""},
//     {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""},
//     {"", "", "", null, null, ""}, {"", "", "", null, null, ""}, {"", "", "", null, null, ""}};
 
//     public void validarCargo(boolean cargo){
// 		if(cargo){
// 			new Menu(true);
// 		}else {
// 			new Menu(false);
// 		}
// 	}

//     public void AbrirTela() {
//         Campo_Pesquisa.setEnabled(false);
//         Botao_Detalhar.setEnabled(false);
//         Botao_Exportar.setEnabled(false);
//         Botao_Imprimir.setEnabled(false);
//     }
 
//     public Movimentacoes(boolean cargo) {
 
//         JFrame Tela = new JFrame("Movimentações");
 
//         Tela.setSize(800, 600);
//         Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         Tela.setResizable(false);
//         Tela.setLayout(new GridBagLayout());
//         Tela.getContentPane().setBackground(new Color(5, 5, 50));
 
//         GridBagConstraints GBC = new GridBagConstraints();
//         GBC.insets = new Insets(20, 10, 10, 10);
//         GBC.anchor = GridBagConstraints.WEST;
 
//         int linha = 0;
 
//         JLabel Label_Titulo = new JLabel("Movimentações");
//         Label_Titulo.setForeground(Color.white);
//         Label_Titulo.setFont(new Font("Calibri", Font.BOLD, 30));
//         GBC.gridx = 0;
//         GBC.gridy = linha;
//         Tela.add(Label_Titulo, GBC);
 
//         Campo_Pesquisa = new JTextField(36);

//         //
//         Campo_Pesquisa.setText("Pesquisar por Nº de documento");
//         Campo_Pesquisa.setForeground(Color.GRAY);
//         Campo_Pesquisa.addFocusListener(new FocusAdapter() {
//             @Override
//             public void focusGained(FocusEvent e) {
//                 if (Campo_Pesquisa.getText().equals("Pesquisar por Nº de documento")) {
//                     Campo_Pesquisa.setText("");
//                     Campo_Pesquisa.setForeground(Color.BLACK);
//                 }
//             }
//             @Override
//             public void focusLost(FocusEvent e) {
//                 if (Campo_Pesquisa.getText().isEmpty()) {
//                     Campo_Pesquisa.setText("Pesquisar por Nº de documento");
//                     Campo_Pesquisa.setForeground(Color.GRAY);
//                 }
//             }
//         });
//         //

//         GBC.gridx = 1;
//         GBC.gridy = linha;
//         Tela.add(Campo_Pesquisa, GBC);
 
//         Botao_Pesquisa = new JButton("🔍");
//         Botao_Pesquisa.setBackground(new Color(81, 112, 255));
//         Botao_Pesquisa.setForeground(Color.white);
//         Botao_Pesquisa.setFocusPainted(false);
//         GBC.gridx = 4;
//         GBC.gridy = linha;
//         GBC.anchor = GridBagConstraints.EAST;
//         Tela.add(Botao_Pesquisa, GBC);
 
//         Botao_Sair = new JButton("Sair");
//         Botao_Sair.setBackground(new Color(81, 112, 255));
//         Botao_Sair.setForeground(Color.white);
//         Botao_Sair.setFocusPainted(false);
//         GBC.gridx = 5;
//         GBC.gridy = linha;
//         GBC.anchor = GridBagConstraints.EAST;
//         Tela.add(Botao_Sair, GBC);
//         linha++;
 
//         df = new DefaultTableModel(linha_tabela, coluna);
//         Tabela_Movimentacoes = new JTable(df) {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return false; // Bloquear edição
//             }
//         };
//         Tabela_Movimentacoes.getTableHeader().setReorderingAllowed(false); // Não permitir mover colunas
//         Tabela_Movimentacoes.getTableHeader().setResizingAllowed(false);
       
//         JScrollPane Scroll = new JScrollPane(Tabela_Movimentacoes);
//         Scroll.setPreferredSize(new Dimension(750, 300));
//         GBC.gridx = 0;
//         GBC.gridy = linha;
//         GBC.gridwidth = 6;
//         GBC.fill = GridBagConstraints.BOTH;
//         Tela.add(Scroll, GBC);
//         linha++;
 
//         Botao_Detalhar = new JButton("Detalhar");
//         Botao_Detalhar.setBackground(new Color(128, 128, 128));
//         Botao_Detalhar.setForeground(Color.WHITE);
//         Botao_Detalhar.setFocusPainted(false);
 
//         Botao_Exportar = new JButton("Exportar (PDF/Excel)");
//         Botao_Exportar.setBackground(new Color(128, 128, 128));
//         Botao_Exportar.setForeground(Color.WHITE);
//         Botao_Exportar.setFocusPainted(false);
 
//         Botao_Imprimir = new JButton("Imprimir");
//         Botao_Imprimir.setBackground(new Color(128, 128, 128));
//         Botao_Imprimir.setForeground(Color.WHITE);
//         Botao_Imprimir.setFocusPainted(false);
 
//         JPanel AlinharBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0));
//         AlinharBotoes.setBackground(new Color(5, 5, 50));
//         AlinharBotoes.add(Botao_Detalhar);
//         AlinharBotoes.add(Botao_Exportar);
//         AlinharBotoes.add(Botao_Imprimir);
 
//         GBC.gridx = 0;
//         GBC.gridy = linha;
//         GBC.gridwidth = 6;
//         GBC.anchor = GridBagConstraints.CENTER;
//         GBC.insets = new Insets(5, 5, 5, 5);
//         Tela.add(AlinharBotoes, GBC);
 
//         Botao_Sair.addActionListener(e -> {
//             Tela.dispose();
//             validarCargo(cargo);
//         });

//         Tela.setVisible(true);
//         // Tirar foco inicial do campo
//         SwingUtilities.invokeLater(() -> Tela.requestFocusInWindow());
//     }
 
    
 
// }

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import banco.MovimentacoesDAO;

public class Movimentacoes {

    private JTextField Campo_Pesquisa;
    private JButton Botao_Sair, Botao_Pesquisa, Botao_Atualizar, Botao_Exportar, Botao_Imprimir;
    private JTable Tabela_Movimentacoes;
    private DefaultTableModel df;
    private MovimentacoesDAO movimentacoesDAO;

    public void validarCargo(boolean cargo){
        if(cargo){
            new Menu(true);
        }else {
            new Menu(false);
        }
    }

    public Movimentacoes(boolean cargo) {
        movimentacoesDAO = new MovimentacoesDAO();
        JFrame Tela = new JFrame("Movimentações");
        Tela.setSize(1200, 600);
        Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tela.setResizable(false);
        Tela.setLayout(new GridBagLayout());
        Tela.getContentPane().setBackground(new Color(5, 5, 50));

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.insets = new Insets(20, 10, 10, 10);
        GBC.anchor = GridBagConstraints.WEST;

        int linha = 0;

        // 🔹 Título
        JLabel Label_Titulo = new JLabel("Movimentações");
        Label_Titulo.setForeground(Color.white);
        Label_Titulo.setFont(new Font("Calibri", Font.BOLD, 30));
        GBC.gridx = 0;
        GBC.gridy = linha;
        Tela.add(Label_Titulo, GBC);

        // 🔹 Campo de pesquisa
        Campo_Pesquisa = new JTextField(72);
        Campo_Pesquisa.setText("Pesquisar por Nº de documento...");
        Campo_Pesquisa.setForeground(Color.GRAY);
        Campo_Pesquisa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Campo_Pesquisa.getText().equals("Pesquisar por Nº de documento...")) {
                    Campo_Pesquisa.setText("");
                    Campo_Pesquisa.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (Campo_Pesquisa.getText().isEmpty()) {
                    Campo_Pesquisa.setText("Pesquisar por Nº de documento...");
                    Campo_Pesquisa.setForeground(Color.GRAY);
                }
            }
        });
        GBC.gridx = 1;
        GBC.gridy = linha;
        Tela.add(Campo_Pesquisa, GBC);

        // 🔹 Botão Pesquisar
        Botao_Pesquisa = new JButton("🔍");
        Botao_Pesquisa.setBackground(new Color(81, 112, 255));
        Botao_Pesquisa.setForeground(Color.white);
        Botao_Pesquisa.setFocusPainted(false);
        GBC.gridx = 4;
        GBC.gridy = linha;
        GBC.anchor = GridBagConstraints.EAST;
        Tela.add(Botao_Pesquisa, GBC);

        // 🔹 Botão Sair
        Botao_Sair = new JButton("Sair");
        Botao_Sair.setBackground(new Color(81, 112, 255));
        Botao_Sair.setForeground(Color.white);
        Botao_Sair.setFocusPainted(false);
        GBC.gridx = 5;
        GBC.gridy = linha;
        Tela.add(Botao_Sair, GBC);
        linha++;

        // 🔹 Carregar dados iniciais do DAO
        df = MovimentacoesDAO.carregarMovimentacoes();

        // 🔹 Tabela
        Tabela_Movimentacoes = new JTable(df) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tabela_Movimentacoes.getTableHeader().setReorderingAllowed(false);
        Tabela_Movimentacoes.getTableHeader().setResizingAllowed(false);

        JScrollPane scroll = new JScrollPane(Tabela_Movimentacoes);
        scroll.setPreferredSize(new Dimension(1150, 400));
        GBC.gridx = 0;
        GBC.gridy = linha;
        GBC.gridwidth = 6;
        GBC.fill = GridBagConstraints.BOTH;
        Tela.add(scroll, GBC);
        linha++;

        // 🔹 Botões inferiores
        Botao_Atualizar = new JButton("Atualizar");
        Botao_Atualizar.setBackground(new Color(128, 128, 128));
        Botao_Atualizar.setForeground(Color.WHITE);
        Botao_Atualizar.setFocusPainted(false);

        Botao_Exportar = new JButton("Exportar (PDF/Excel)");
        Botao_Exportar.setBackground(new Color(128, 128, 128));
        Botao_Exportar.setForeground(Color.WHITE);
        Botao_Exportar.setFocusPainted(false);

        Botao_Imprimir = new JButton("Imprimir");
        Botao_Imprimir.setBackground(new Color(128, 128, 128));
        Botao_Imprimir.setForeground(Color.WHITE);
        Botao_Imprimir.setFocusPainted(false);

        JPanel AlinharBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0));
        AlinharBotoes.setBackground(new Color(5, 5, 50));
        AlinharBotoes.add(Botao_Atualizar);
        AlinharBotoes.add(Botao_Exportar);
        AlinharBotoes.add(Botao_Imprimir);

        GBC.gridx = 0;
        GBC.gridy = linha;
        GBC.gridwidth = 6;
        GBC.anchor = GridBagConstraints.CENTER;
        GBC.insets = new Insets(5, 5, 5, 5);
        Tela.add(AlinharBotoes, GBC);

        // 🔹 Ações
        Botao_Pesquisa.addActionListener(e -> {
            String texto = Campo_Pesquisa.getText().trim();
            if (!texto.isEmpty() && !texto.equals("Pesquisar por código do produto")) {
                try {
                    int codigo = Integer.parseInt(texto);
                    MovimentacoesDAO.buscarPorDocumento(df, codigo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Tela, "Digite um número válido para o código!");
                }
            }
        });

        Botao_Sair.addActionListener(e -> {
            Tela.dispose();
            validarCargo(cargo);
        });

        Botao_Atualizar.addActionListener(e -> {
            Tela.dispose();
            new Movimentacoes(cargo);
        });

        SwingUtilities.invokeLater(() -> Tela.requestFocusInWindow());

        Tela.setVisible(true);
    }
}
