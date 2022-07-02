 package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Search_JF extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private Vector vD, vT;
	private int t=-1;
	private JCheckBox chckbxNewCheckBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_JF frame = new Search_JF(new Vector(), new Vector());
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
	public Search_JF(Vector vT, Vector vD) {
		setTitle("Search_HocVien");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		this.vD = vD;
		this.vT = vT;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbmahv = new JLabel("Mahv:");
		lbmahv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmahv.setBounds(10, 30, 100, 25);
		contentPane.add(lbmahv);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(10, 65, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbtenhv = new JLabel("Tenhv:");
		lbtenhv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbtenhv.setBounds(191, 30, 100, 25);
		contentPane.add(lbtenhv);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(191, 65, 150, 30);
		contentPane.add(textField_1);
		
		JLabel lbsdt = new JLabel("Sdt:");
		lbsdt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbsdt.setBounds(369, 30, 100, 25);
		contentPane.add(lbsdt);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(369, 65, 150, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(551, 65, 150, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(736, 65, 150, 30);
		contentPane.add(textField_4);
		
		JLabel lbngayvaohoc = new JLabel("Ngayvaohoc:");
		lbngayvaohoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbngayvaohoc.setBounds(551, 30, 150, 25);
		contentPane.add(lbngayvaohoc);
		
		JLabel lbmahv_1_1_2 = new JLabel("Makh:");
		lbmahv_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmahv_1_1_2.setBounds(736, 30, 100, 25);
		contentPane.add(lbmahv_1_1_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector v = new Vector();
				v.add(textField.getText());
				v.add(textField_1.getText());
				v.add(textField_2.getText());
				v.add(textField_3.getText());
				v.add(textField_4.getText());
				
				Vector vD2 = new Vector();
				for (int i = 0; i < vD.size(); i++) {
					Vector row = (Vector)vD.get(i);
					if (checkVector(v, row, chckbxNewCheckBox.isSelected()))
						vD2.add(vD.get(i));
				}
				table.setModel(new DefaultTableModel(vD2, vT));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(389, 115, 110, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 876, 312);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(vD, vT));
		
		 chckbxNewCheckBox = new JCheckBox("Kh\u00F4ng ph\u00E2n bi\u1EC7t ch\u1EEF hoa hay th\u01B0\u1EDDng");
		 chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(10, 491, 341, 25);
		contentPane.add(chckbxNewCheckBox);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
	
	public boolean checkVector(Vector v, Vector row, boolean selected) {
		for (int i = 0; i < v.size(); i++)  {
			String s = v.get(i) + "";
			String p = row.get(i) + "";
			if (selected) {
				s = s.toUpperCase();
				p = p.toUpperCase();
			}
			if (s.length() != 0 && !s.equals(p))
				return false;
		}
		
		return true;
	}
}
