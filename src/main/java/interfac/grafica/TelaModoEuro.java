package interfac.grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.dao.ConversoesDAO;
import model.view.MenuEuro;
import java.awt.Toolkit;

public class TelaModoEuro extends JFrame {

	private JPanel contentPane;
	private JTextField euro_real_camp;
	private JTextField real_euro_camp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaModoEuro frame = new TelaModoEuro();
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
	public TelaModoEuro() {
		setTitle("Euro");
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\coinIcon.png"));
		
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(0, 128, 192));
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btn_euro_real = new JButton("EURO PARA REAL");
		btn_euro_real.setBackground(new Color(0, 0, 0));
		btn_euro_real.setForeground(new Color(255, 255, 255));
		btn_euro_real.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("00");
				ConversoesDAO conversao = new ConversoesDAO();
				double valorEuro = conversao.valorDoEuroBanco();
				MenuEuro calculo = new MenuEuro();
				double valorDigitado = Double.parseDouble(euro_real_camp.getText());
				String valorFormatado = df.format(valorDigitado);
				
				double resultado = calculo.converterEuroParaReal(valorEuro, Double.parseDouble(valorFormatado));
				JOptionPane.showMessageDialog(null, "Valor convertido = R$ "+resultado, "Conversor de moedas - Dollar", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btn_euro_real.setBounds(47, 98, 136, 23);
		getContentPane().add(btn_euro_real);
		
		JButton btn_real_euro = new JButton("REAL PARA EURO");
		btn_real_euro.setBackground(new Color(0, 0, 0));
		btn_real_euro.setForeground(new Color(255, 255, 255));
		btn_real_euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("00");
				ConversoesDAO conversao = new ConversoesDAO();
				double valorEuro = conversao.valorDoEuroBanco();
				MenuEuro calculo = new MenuEuro();
				double valorDigitado = Double.parseDouble(real_euro_camp.getText());
				String valorFormatado = df.format(valorDigitado);
				
				double resultado = calculo.converterRealParaEuro(valorEuro, Double.parseDouble(valorFormatado));
				JOptionPane.showMessageDialog(null, "Valor convertido = € "+resultado, "Conversor de moedas - Dollar", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_real_euro.setBounds(239, 98, 144, 23);
		getContentPane().add(btn_real_euro);
		
		JButton visualizarTaxaEuro = new JButton("Visualizar taxa");
		visualizarTaxaEuro.setForeground(new Color(255, 255, 255));
		visualizarTaxaEuro.setBackground(new Color(0, 0, 0));
		visualizarTaxaEuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversoesDAO conversao = new ConversoesDAO();
				double valorEuro = conversao.valorDoEuroBanco();
				JOptionPane.showMessageDialog(null, "Taxa atual = R$ "+valorEuro, "Conversor de moedas - Dollar", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		visualizarTaxaEuro.setBounds(137, 187, 167, 23);
		getContentPane().add(visualizarTaxaEuro);
		
		JLabel lblNewLabel = new JLabel("- Selecione o modo de conversão - ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(108, 56, 228, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(117, 163, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(277, 163, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("€");
		lblNewLabel_3.setBounds(79, 135, 15, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R$");
		lblNewLabel_4.setBounds(229, 135, 20, 14);
		getContentPane().add(lblNewLabel_4);
		
		euro_real_camp = new JTextField();
		euro_real_camp.setBounds(89, 132, 86, 20);
		getContentPane().add(euro_real_camp);
		euro_real_camp.setColumns(10);
		
		real_euro_camp = new JTextField();
		real_euro_camp.setBounds(249, 132, 86, 20);
		getContentPane().add(real_euro_camp);
		real_euro_camp.setColumns(10);
		
		JButton voltar = new JButton("<");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial tela = new TelaInicial();
				tela.setVisible(true);
			}
		});
		voltar.setBackground(new Color(0, 0, 0));
		voltar.setForeground(new Color(255, 255, 255));
		voltar.setBounds(0, 238, 46, 23);
		getContentPane().add(voltar);
	}
}
