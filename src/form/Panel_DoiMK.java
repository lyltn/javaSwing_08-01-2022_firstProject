package form;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import connectData.Connect;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Panel_DoiMK extends JPanel {
	String t;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Panel_DoiMK() {
		setBackground(Color.WHITE);
		setLayout(null);
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		
		JLabel lblMtKhuC = new JLabel("M\u1EADt Kh\u1EA9u C\u0169:");
		lblMtKhuC.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMtKhuC.setBounds(115, 145, 155, 40);
		add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("M\u1EADt Kh\u1EA9u M\u1EDBi:");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMtKhuMi.setBounds(115, 211, 155, 40);
		add(lblMtKhuMi);
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBounds(306, 145, 343, 35);
		add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_2.setBounds(306, 211, 343, 35);
		add(passwordField_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hiển thị");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}
				else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(576, 123, 73, 16);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hiển thị");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					passwordField_2.setEchoChar((char)0);
				}
				else {
					passwordField_2.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(576, 189, 73, 16);
		add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setIcon(new ImageIcon("Image/update.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql6 = "SELECT * from yy";
				PreparedStatement stm6;
				try {
					stm6 = conn.prepareStatement(sql6);
					ResultSet rs = stm6.executeQuery();
					while (rs.next()) {
						t=rs.getString(1);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(passwordField.getText().equals(passwordField_2.getText())) {
					

				String query = "update nguoidung set  taikhoan=?, matkhau=?  where taikhoan = '"+t+"'and"
						+ " matkhau = '"+passwordField_1.getText()+"'";
				PreparedStatement stm1;
				try {
					stm1 = conn.prepareStatement(query);
					stm1.setString(1, t);
					stm1.setString(2, passwordField_2.getText());
					String sql = "SELECT * FROM nguoidung where taikhoan = '"+t+"'";
					PreparedStatement stm;
					try {
						stm = conn.prepareStatement(sql);
						ResultSet rs = stm.executeQuery();
						rs.next();
						System.out.println(rs.getString(2));
						if(rs.getString(2).equals(passwordField_1.getText()) ){
							
							passwordField_1.setText("");
							passwordField_2.setText("");
							passwordField.setText("");
							JOptionPane.showMessageDialog(null,  "Update successful!","Announcement", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Nhập mật khẩu cũ sai.","Lỗi", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (SQLException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
						JOptionPane.showMessageDialog(null,  e4.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					stm1.executeUpdate();
					/*
					 * ExecuteUpdate (chỉ thêm hàng, hủy hàng, cập nhật hàng): phương thức này sử dụng cho 
					 * các câu insert, update, delete, 
					 * chỉ trả về giá trị row count hoặc 0 cho các câu SQL không trả về kết quả gì
					 */

				} catch (SQLException e9) {
					// TODO Auto-generated catch block
					e9.printStackTrace();
					JOptionPane.showMessageDialog(null,  e9.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
				}}else {
					JOptionPane.showMessageDialog(null,  "xác nhận mật khẩu không đúng vui lòng thử lại","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(314, 357, 131, 40);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Image/mk.png"));
		lblNewLabel_1.setBounds(245, 22, 260, 101);
		add(lblNewLabel_1);
		
		JLabel lblNhpLiMk = new JLabel("Nhập lại MK mới:");
		lblNhpLiMk.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNhpLiMk.setBounds(115, 278, 184, 40);
		add(lblNhpLiMk);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(306, 278, 343, 35);
		add(passwordField);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Hiển thị");
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1_1.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		rdbtnNewRadioButton_1_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1_1.setBounds(576, 256, 73, 16);
		add(rdbtnNewRadioButton_1_1);
	}
}
