package interfac.grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\coinIcon.png"));
		setBackground(new Color(255, 255, 255));
		
		setResizable(false);
		getContentPane().setBackground(new Color(0, 128, 192));
		setBounds(100, 100, 450, 260);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bem vindo ao conversor de Moédas! ");
		getContentPane().setLayout(null);
		
		JButton btn_dollar = new JButton("DOLLAR");
		btn_dollar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_dollar.setBackground(new Color(0, 0, 0));
		btn_dollar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			  TelaModoDollar tela = new TelaModoDollar();
			  tela.setVisible(true);
			}
		});
		btn_dollar.setForeground(new Color(255, 255, 255));
		btn_dollar.setBounds(94, 122, 102, 37);
		getContentPane().add(btn_dollar);
		
		JButton btn_euro = new JButton("EURO");
		btn_euro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_euro.setForeground(new Color(255, 255, 255));
		btn_euro.setBackground(new Color(0, 0, 0));
		btn_euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaModoEuro tela = new TelaModoEuro();
				tela.setVisible(true);
			}
		});
		btn_euro.setBounds(237, 122, 113, 37);
		getContentPane().add(btn_euro);
		
		JLabel lblNewLabel = new JLabel("- SELECIONE A MOEDA PARA CONVERSÃO - ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(94, 67, 254, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de conversão baseado na taxa comercial atual");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(0, 207, 350, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("conversaosys");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(359, 207, 95, 14);
		getContentPane().add(lblNewLabel_2);
		
	}

}
