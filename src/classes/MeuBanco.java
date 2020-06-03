package classes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MeuBanco {

    public static void main(String[] args) {
        System.out.println("---Sistema em Execução--");
        System.out.println("----------Menu----------");
        Banco b1 = new Banco();

        JFrame TelaPricipal = new JFrame("Sistema Bancário");
        JButton menuContaCriar = new JButton("Criar Conta");
        menuContaCriar.setPreferredSize(new Dimension(150, 100));
        JButton menuContaMovimentar = new JButton("Movimentar");
        menuContaMovimentar.setPreferredSize(new Dimension(150, 100));
        JButton menuContaRemover = new JButton("Remover");
        menuContaRemover.setPreferredSize(new Dimension(150, 100));
        JButton menuRelatorio = new JButton("Relatorio");
        menuRelatorio.setPreferredSize(new Dimension(150, 100));
        JButton menuFinalizar = new JButton("Finalizar");
        menuFinalizar.setPreferredSize(new Dimension(150, 100));
        
        JButton menuSobre = new JButton("Markus Lima");
        menuSobre.setPreferredSize(new Dimension(300, 100));
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(menuContaCriar);
        panel.add(menuContaMovimentar);
        panel.add(menuContaRemover);
        panel.add(menuRelatorio);
        panel.add(menuFinalizar);
        panel.add(menuSobre);
        TelaPricipal.add(panel);
        TelaPricipal.setSize(550, 400);
        TelaPricipal.setLocationRelativeTo(null);
        TelaPricipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaPricipal.setVisible(true);

        menuContaCriar.addActionListener((java.awt.event.ActionEvent evt) -> {
            TelaPricipal.setVisible(false);
            JFrame TelaCriarConta = new JFrame("Criar Conta");
            JPanel panelTelaCriarConta = new JPanel();
            panelTelaCriarConta.setLayout(new FlowLayout());
            JComboBox<Object> comboBoxTipoConta = new JComboBox<>();
            JLabel jLabel1 = new JLabel("Informe o numero da Conta");
            JLabel jLabel2 = new JLabel("Informe Saldo");
            JLabel jLabel3 = new JLabel("taxa");
            JButton buttonEnviar = new JButton("Enviar");
            JButton buttonSair = new JButton("Sair");
            JLabel space = new JLabel("");
            JTextField txtNumeroConta = new JTextField("", 15);
            JTextField txtSaldoConta = new JTextField("", 15);
            JTextField txtTaxaConta = new JTextField("", 15);

            panelTelaCriarConta.add(comboBoxTipoConta);
            panelTelaCriarConta.add(space);
            panelTelaCriarConta.add(jLabel1);
            panelTelaCriarConta.add(txtNumeroConta);
            panelTelaCriarConta.add(jLabel2);
            panelTelaCriarConta.add(txtSaldoConta);
            panelTelaCriarConta.add(jLabel3);
            panelTelaCriarConta.add(txtTaxaConta);
            panelTelaCriarConta.add(buttonEnviar);
            panelTelaCriarConta.add(buttonSair);

            TelaCriarConta.add(panelTelaCriarConta);
            TelaCriarConta.setSize(550, 400);
            TelaCriarConta.setLocationRelativeTo(null);
            TelaCriarConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TelaCriarConta.setVisible(true);

            comboBoxTipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Conta Corrente", "Conta Poupança"}));
            comboBoxTipoConta.addActionListener((java.awt.event.ActionEvent evt1) -> {
                String n = (String) comboBoxTipoConta.getSelectedItem();
                if (n.equals("Conta Corrente")) {
                    jLabel3.setText("Taxa");
                } else {
                    jLabel3.setText("Limite");
                }
            });

            buttonSair.addActionListener((java.awt.event.ActionEvent evt1) -> {
                TelaCriarConta.setVisible(false);
                TelaPricipal.setVisible(true);
            });

            buttonEnviar.addActionListener((java.awt.event.ActionEvent evt1) -> {
                try {
                    String n = (String) comboBoxTipoConta.getSelectedItem();

                    if ("Conta Corrente".equals(n)) {
                        ContaCorrente cc = new ContaCorrente();
                        cc.setTipo("Conta Corrente");
                        cc.setNumConta(Integer.parseInt(txtNumeroConta.getText()));
                        cc.setSaldo(Integer.parseInt(txtSaldoConta.getText()));
                        cc.setTaxaOp(Integer.parseInt(txtTaxaConta.getText()));
                        b1.inserirConta(cc);
                        cc.mostrarDados();

                    } else {
                        ContaPoupanca cp = new ContaPoupanca();
                        cp.setTipo("Conta Poupança");
                        cp.setNumConta(Integer.parseInt(txtNumeroConta.getText()));
                        cp.setSaldo(Integer.parseInt(txtSaldoConta.getText()));
                        cp.setLimite(Integer.parseInt(txtTaxaConta.getText()));
                        b1.inserirConta(cp);
                        cp.mostrarDados();
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    txtNumeroConta.setText("");
                    txtSaldoConta.setText("");
                    txtTaxaConta.setText("");
                }
            });
        });

        menuContaMovimentar.addActionListener((java.awt.event.ActionEvent evt) -> {
            TelaPricipal.setVisible(false);
            JFrame TelaCriarConta = new JFrame("Movimentar Conta");
            JPanel panelTelaCriarConta = new JPanel();
            panelTelaCriarConta.setLayout(new FlowLayout());
            JLabel jLabel1 = new JLabel("Informe o numero da Conta");
            JLabel jLabel2 = new JLabel("Informe o valor");
            JLabel jLabel3 = new JLabel("Numero da Conta");
            JLabel jLabel4 = new JLabel("Tipo de Movimentação");
            JButton buttonLocalizar = new JButton("Localizar");
            JButton buttonConfirmar = new JButton("Confirmar");
            JButton buttonSair = new JButton("Sair");
            JTextField txtNumeroConta = new JTextField("", 20);
            JTextField txtValorConta = new JTextField("", 20);
            JTextField txtOutraConta = new JTextField("", 20);
            JComboBox<Object> comboBoxMovConta = new JComboBox<>();
            comboBoxMovConta.setPreferredSize(new Dimension(200, 20));

            panelTelaCriarConta.add(jLabel1);
            panelTelaCriarConta.add(txtNumeroConta);
            panelTelaCriarConta.add(buttonLocalizar);

            panelTelaCriarConta.add(jLabel4);
            panelTelaCriarConta.add(comboBoxMovConta);
            comboBoxMovConta.setEnabled(false);
            panelTelaCriarConta.add(jLabel2);
            panelTelaCriarConta.add(txtValorConta);
            txtValorConta.setEnabled(false);
            panelTelaCriarConta.add(jLabel3);
            panelTelaCriarConta.add(txtOutraConta);
            txtOutraConta.setEnabled(false);

            panelTelaCriarConta.add(buttonConfirmar);
            buttonConfirmar.setEnabled(false);
            panelTelaCriarConta.add(buttonSair);

            TelaCriarConta.add(panelTelaCriarConta);
            TelaCriarConta.setSize(400, 400);
            TelaCriarConta.setLocationRelativeTo(null);
            TelaCriarConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TelaCriarConta.setVisible(true);

            buttonLocalizar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int resposta = Integer.parseInt(txtNumeroConta.getText());
                    ContaBancaria contaSelecionada = b1.procurarConta(resposta);
                    if (contaSelecionada != null) {
                        comboBoxMovConta.setEnabled(true);
                        txtValorConta.setEnabled(true);
                        buttonConfirmar.setEnabled(true);
                        System.out.println("Conta encontrada");
                    } else {
                        comboBoxMovConta.setEnabled(false);
                        txtValorConta.setEnabled(false);
                        buttonConfirmar.setEnabled(false);
                    }
                }
            });

            comboBoxMovConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Depositar", "Sacar", "Transferir"}));
            comboBoxMovConta.addActionListener((java.awt.event.ActionEvent evt1) -> {
                String n = (String) comboBoxMovConta.getSelectedItem();
                if (n.equals("Transferir")) {
                    txtOutraConta.setEnabled(true);
                } else {
                    txtOutraConta.setEnabled(false);
                }
            });

            buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int resposta = Integer.parseInt(txtNumeroConta.getText());
                    ContaBancaria contaSelecionada = b1.procurarConta(resposta);
                    String n = (String) comboBoxMovConta.getSelectedItem();
                    double valor = Integer.parseInt(txtValorConta.getText());

                    if (n.equals("Depositar")) {
                        double saldoAnterior = contaSelecionada.getSaldo();
                        double saldoComDeposito = contaSelecionada.depositar(valor);
                        System.out.println("------------------------");
                        System.out.println("Saldo Anterior: " + saldoAnterior);
                        System.out.println("Valor Depósito: " + valor);
                        System.out.println("Saldo com Depósito: " + saldoComDeposito);
                        System.out.println("------------------------");
                    } else if (n.equals("Sacar")) {
                        double saldoAntecedente = contaSelecionada.getSaldo();
                        double saldoComSaque = contaSelecionada.sacar(valor);
                        System.out.println("------------------------");
                        System.out.println("Saldo Anterior: " + saldoAntecedente);
                        System.out.println("Valor Saque: " + valor);
                        System.out.println("Saldo após saque: " + saldoComSaque);
                        System.out.println("------------------------");
                    } else if (n.equals("Transferir")) {
                        int resp4 = Integer.parseInt(txtOutraConta.getText());
                        ContaBancaria contaDestino = b1.procurarConta(resp4);
                        if (contaDestino != null) {
                            System.out.print("Valor: ");
                            double valorTransf = valor;
                            double saldoOrigem = contaSelecionada.getSaldo();
                            double saldoDestino = contaDestino.getSaldo();
                            contaSelecionada.transferir(valorTransf, contaDestino);
                            System.out.println("------------------------");
                            System.out.println("Conta Origem: " + contaSelecionada.getNumConta());
                            System.out.println("Saldo Anteriror: " + saldoOrigem);
                            System.out.println("Saldo Atual: " + contaSelecionada.getSaldo());
                            System.out.println("------------------------");
                            System.out.println("Conta Destino: " + contaDestino.getNumConta());
                            System.out.println("Saldo Anterior: " + saldoDestino);
                            System.out.println("Saldo Atual: " + contaDestino.getSaldo());
                        } else {
                            System.out.println("Operação Abortada!");
                        }
                        System.out.println("------------------------");
                    }
                }
            });

            buttonSair.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    TelaCriarConta.setVisible(false);
                    TelaPricipal.setVisible(true);
                }
            });

        });

        menuContaRemover.addActionListener((java.awt.event.ActionEvent evt) -> {
            TelaPricipal.setVisible(false);
            JFrame TelaCriarConta = new JFrame("Criar Conta");
            JPanel panelTelaCriarConta = new JPanel();
            panelTelaCriarConta.setLayout(new FlowLayout());
            JLabel jLabel1 = new JLabel("Informe o numero da Conta");

            JButton buttonRemover = new JButton("Remover");
            JButton buttonSair = new JButton("Sair");
            JTextField txtNumeroConta = new JTextField("", 15);
            panelTelaCriarConta.add(jLabel1);
            panelTelaCriarConta.add(txtNumeroConta);
            panelTelaCriarConta.add(buttonRemover);
            panelTelaCriarConta.add(buttonSair);
            TelaCriarConta.add(panelTelaCriarConta);
            TelaCriarConta.setSize(250, 300);
            TelaCriarConta.setLocationRelativeTo(null);
            TelaCriarConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TelaCriarConta.setVisible(true);

            buttonRemover.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int resposta = Integer.parseInt(txtNumeroConta.getText());
                    b1.removerConta(resposta);
                }
            });

            buttonSair.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    TelaCriarConta.setVisible(false);
                    TelaPricipal.setVisible(true);
                }
            });
        });

        menuRelatorio.addActionListener((java.awt.event.ActionEvent evt) -> {
            TelaPricipal.setVisible(false);
            JFrame TelaRelatorio = new JFrame("Relatorio");
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout());
            JLabel jLabel1 = new JLabel("Todas as contas?");
            JLabel jLabel2 = new JLabel("Selecione uma conta");
            JButton buttonRelatorio = new JButton("Gerar Realatorio");
            JButton buttonSair = new JButton("Fechar");

            JComboBox<Object> comboBoxSimNao = new JComboBox<>();
            JComboBox<Object> comboBoxCorrentePoupanca = new JComboBox<>();
            comboBoxCorrentePoupanca.setEnabled(false);
            panel1.add(jLabel1);
            panel1.add(comboBoxSimNao);
            panel1.add(jLabel2);
            panel1.add(comboBoxCorrentePoupanca);
            panel1.add(buttonRelatorio);
            panel1.add(buttonSair);
            TelaRelatorio.add(panel1);
            TelaRelatorio.setSize(500, 400);
            TelaRelatorio.setLocationRelativeTo(null);
            TelaRelatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TelaRelatorio.setVisible(true);

            comboBoxSimNao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Sim", "Não"}));
            comboBoxSimNao.addActionListener((java.awt.event.ActionEvent evt1) -> {
                String n = (String) comboBoxSimNao.getSelectedItem();
                if (n.equals("Sim")) {
                    comboBoxCorrentePoupanca.setEnabled(false);
                } else {
                    comboBoxCorrentePoupanca.setEnabled(true);
                }
            });

            comboBoxCorrentePoupanca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Conta Corrente", "Conta Poupança"}));

            buttonRelatorio.addActionListener((java.awt.event.ActionEvent evt1) -> {
                String sN = (String) comboBoxSimNao.getSelectedItem();
                String n = (String) comboBoxCorrentePoupanca.getSelectedItem();
                if (sN.equals("Sim")) {
                    b1.mostrarDados();
                } else {
                    b1.mostrarDadosConta(n);
                }

            });

            buttonSair.addActionListener((java.awt.event.ActionEvent evt1) -> {
                TelaRelatorio.setVisible(false);
                TelaPricipal.setVisible(true);
            });
        });

        menuFinalizar.addActionListener((java.awt.event.ActionEvent evt) -> {
            TelaPricipal.dispose();
        });

    }
}
