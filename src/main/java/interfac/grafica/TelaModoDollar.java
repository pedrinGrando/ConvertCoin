package interfac.grafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.dao.ConversoesDAO;
import model.view.MenuDollar;
import java.awt.Toolkit;

public class TelaModoDollar extends JFrame {

	private JPanel contentPane;
	private JTextField dolar_real_camp;
	private JTextField real_dolar_camp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaModoDollar frame = new TelaModoDollar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaModoDollar() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\coinIcon.png"));
		setResizable(false);
		
		
		getContentPane().setBackground(new Color(0, 128, 192));
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Dollar");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(185, 122, -27, 128);
		getContentPane().add(verticalStrut);
		
		
		
		JButton btn_escolha_dollar_real = new JButton("DOLLAR PARA REAL");
		btn_escolha_dollar_real.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_escolha_dollar_real.setForeground(new Color(255, 255, 255));
		btn_escolha_dollar_real.setBackground(new Color(0, 0, 0));
		btn_escolha_dollar_real.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("00");
				ConversoesDAO conversao = new ConversoesDAO();
				double valorDolar = conversao.valorDoDolarBanco();
				MenuDollar calculo = new MenuDollar();
				double valorDigitado = Double.parseDouble(dolar_real_camp.getText());
				String valorFormatado = df.format(valorDigitado);
	
				double resultado = calculo.converterDollarParaReal(valorDolar, Double.parseDouble(valorFormatado));
				JOptionPane.showMessageDialog(null, "Valor convertido = R$ "+resultado, "Conversor de moedas - Dollar", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_escolha_dollar_real.setBounds(35, 90, 165, 23);
		getContentPane().add(btn_escolha_dollar_real);
		
		JButton btn_escolha_real_dollar = new JButton("REAL PARA DOLLAR");
		btn_escolha_real_dollar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_escolha_real_dollar.setForeground(new Color(255, 255, 255));
		btn_escolha_real_dollar.setBackground(new Color(0, 0, 0));
		btn_escolha_real_dollar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("00");
				ConversoesDAO conversao = new ConversoesDAO();
				double valorDolar = conversao.valorDoDolarBanco();
				MenuDollar calculo = new MenuDollar();
				double valorDigitado = Double.parseDouble(real_dolar_camp.getText());
				String valorFormatado = df.format(valorDigitado);
				
				double resultado = calculo.converterRealParaDollar(valorDolar, (Double.parseDouble(valorFormatado)));
				JOptionPane.showMessageDialog(null, "Valor convertido = $ "+resultado, "Conversor de moedas - Dollar", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_escolha_real_dollar.setBounds(235, 90, 161, 23);
		getContentPane().add(btn_escolha_real_dollar);
		
		
		
		JLabel simboloDolar = new JLabel("$");
		simboloDolar.setBounds(54, 143, 14, 14);
		getContentPane().add(simboloDolar);
		
		JLabel simboloReal = new JLabel("R$");
		simboloReal.setBounds(260, 143, 22, 14);
		getContentPane().add(simboloReal);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(84, 171, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(302, 171, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("- Escolha o modo de conversão - ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(104, 36, 240, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton view_taxDollar = new JButton("Visualizar taxa de conversão");
		view_taxDollar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		view_taxDollar.setForeground(new Color(255, 255, 255));
		view_taxDollar.setBackground(new Color(0, 0, 0));
		view_taxDollar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversoesDAO conversao = new ConversoesDAO();
				double valorDolar = conversao.valorDoDolarBanco();
				JOptionPane.showMessageDialog(null, "Taxa atual = R$ " + valorDolar, "Conversor de moedas - Dollar", JOptionPane.INFORMATION_MESSAGE );
				
			}
		});
		view_taxDollar.setBounds(123, 196, 191, 23);
		getContentPane().add(view_taxDollar);
		
		dolar_real_camp = new JTextField();
		dolar_real_camp.setBounds(64, 140, 86, 20);
		getContentPane().add(dolar_real_camp);
		dolar_real_camp.setColumns(10);
		
		real_dolar_camp = new JTextField();
		real_dolar_camp.setBounds(281, 140, 86, 20);
		getContentPane().add(real_dolar_camp);
		real_dolar_camp.setColumns(10);
		
		JButton voltar_btn = new JButton("<");
		voltar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial tela = new TelaInicial();
				tela.setVisible(true);
			}
		});
		voltar_btn.setForeground(new Color(255, 255, 255));
		voltar_btn.setBackground(new Color(0, 0, 0));
		voltar_btn.setBounds(0, 238, 46, 23);
		getContentPane().add(voltar_btn);
	}
}
