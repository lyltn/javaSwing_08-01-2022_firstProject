package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
public class Update_Chi extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private boolean checkOk = false;
	private JLabel lblMPhiu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Chi frame = new Update_Chi();
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
	public Update_Chi() {
		setTitle("Update_PhieuChi");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn: ");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMNhnVin.setBounds(30, 97, 122, 30);
		contentPane.add(lblMNhnVin);
		
		JLabel lblNgy = new JLabel("Ng\u00E0y Chi:");
		lblNgy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgy.setBounds(30, 156, 110, 30);
		contentPane.add(lblNgy);
		
		JLabel lblSTin = new JLabel("S\u1ED1 Ti\u1EC1n:");
		lblSTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSTin.setBounds(30, 223, 90, 30);
		contentPane.add(lblSTin);
		
		JLabel lblLDo = new JLabel("L\u00FD Do:");
		lblLDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLDo.setBounds(30, 286, 76, 30);
		contentPane.add(lblLDo);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(162, 98, 240, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(162, 157, 240, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(162, 223, 240, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(162, 286, 240, 30);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCheckOk(true);
				if(JOptionPane.showConfirmDialog(null, 
						"có muốn cập nhật không","Hỏi",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
					return;
				}
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(155, 342, 120, 35);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(162, 35, 240, 30);
		contentPane.add(lblNewLabel);
		
		lblMPhiu = new JLabel("Mã Phiếu:");
		lblMPhiu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMPhiu.setBounds(30, 35, 122, 30);
		contentPane.add(lblMPhiu);
		setLocationRelativeTo(null);
		setResizable(false);
	
	}
	public Vector getData() {
		Vector v = new Vector();
		v.add(lblNewLabel.getText());
		v.add(textField_1.getText());
		v.add(textField_2.getText());
		v.add(textField_3.getText());
		v.add(textField_4.getText());
		return v;
	}
	
	public void clearTexifield() {
		lblNewLabel.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
	}
	
	public void setData(Vector data) {
		while (data.size() < 5)
			data.add(null);
//		System.out.println(data);
		lblNewLabel.setText((String) data.get(0));
		textField_1.setText(data.get(1) + "");
		textField_2.setText(data.get(2) + "");
		textField_3.setText(data.get(3) + "");
		textField_4.setText(data.get(4) + "");
	}
	public boolean isCheckOk() {
		return checkOk;
	}

	public void setCheckOk(boolean checkOk) {
		this.checkOk = checkOk;
	}
}
