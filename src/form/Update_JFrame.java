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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Update_JFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private boolean checkOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_JFrame frame = new Update_JFrame();
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
	public Update_JFrame() {
		setTitle("Update_HocVien");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbmahv = new JLabel("M\u00E3 H\u1ECDc Vi\u00EAn:");
		lbmahv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmahv.setBounds(20, 31, 120, 30);
		contentPane.add(lbmahv);
		
		JLabel lbtenhv = new JLabel("T\u00EAn H\u1ECDc Vi\u00EAn:");
		lbtenhv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbtenhv.setBounds(20, 87, 120, 30);
		contentPane.add(lbtenhv);
		
		JLabel lbsdt = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");
		lbsdt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbsdt.setBounds(20, 137, 120, 30);
		contentPane.add(lbsdt);
		
		JLabel lbngayvaohoc = new JLabel("Ng\u00E0y V\u00E0o H\u1ECDc:");
		lbngayvaohoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbngayvaohoc.setBounds(20, 194, 120, 30);
		contentPane.add(lbngayvaohoc);
		
		JLabel lbmakh = new JLabel("M\u00E3 Kh\u00F3a H\u1ECDc:");
		lbmakh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmakh.setBounds(20, 248, 120, 30);
		contentPane.add(lbmakh);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(150, 31, 286, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(150, 87, 286, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(150, 137, 286, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(150, 194, 286, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(150, 248, 286, 30);
		contentPane.add(textField_4);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setIcon(new ImageIcon("Image/update.png"));
		btnupdate.setBackground(new Color(240, 248, 255));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCheckOk(true);
				if(JOptionPane.showConfirmDialog(null, 
						"có muốn cập nhật không","Hỏi",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
					return;
				}
				setVisible(false);
				
			}
		});
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnupdate.setBounds(165, 308, 136, 41);
		contentPane.add(btnupdate);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public boolean isCheckOk() {
		return checkOk;
	}

	public void setCheckOk(boolean checkOk) {
		this.checkOk = checkOk;
	}
	
	public Vector getData() {
		Vector v = new Vector();
		v.add(textField.getText());
		v.add(textField_1.getText());
		v.add(textField_2.getText());
		v.add(textField_3.getText());
		v.add(textField_4.getText());
		return v;
	}
	
	public void clearTexifield() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
	}
	
	public void setData(Vector data) {
		while (data.size() < 5)
			data.add(null);
//		System.out.println(data);
		textField.setText((data.get(0) + ""));
		textField_1.setText(data.get(1) + "");
		textField_2.setText(data.get(2) + "");
		textField_3.setText(data.get(3) + "");
		textField_4.setText(data.get(4) + "");
	}
}
