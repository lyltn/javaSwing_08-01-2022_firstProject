package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectData.Connect;
import connectData.DataValidator;

import nd.NguoiDung;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	 JTextField textField;
	private JPasswordField passwordField;
	public String y, r;
	private boolean checkOk = false;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	
	public DangNhap() {
		setTitle("Đăng Nhập");
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		NhanVien nv = new NhanVien();
		QuanLy ql = new QuanLy();
		ql li = new ql();
		HocVien hv = new HocVien();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setBorder đường bao quanh của JPanel
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 ImageIcon webIcon = new ImageIcon("Image/login.png");
		 //Lớp ImageIcon trong Java Swing là một trình triển khai của
		 //Icon Iterface, để vẽ các Icon từ các Image.
	     setIconImage(webIcon.getImage());
		
 
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD Thu Chi H\u1ECDc Ph\u00ED");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		/*
		 * Từ viết tắt RGB trong tiếng Anh có nghĩa là đỏ (red), xanh lục (green) và
		 *  xanh lam (blue), là ba màu gốc trong các mô hình ánh sáng bổ sung.
		 */
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(91, 22, 291, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(34, 76, 331, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(33, 106, 408, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(34, 144, 331, 25); 
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(34, 175, 408, 30);
		contentPane.add(passwordField);
		y=textField.getText();
		li.setVisible(false);
		JButton btnNewButton = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y = textField.getText();
				
				try {
					String sql8 = "DROP TABLE yy;";
					PreparedStatement stm= conn.prepareStatement(sql8);
					   stm = conn.prepareStatement(sql8);
					   stm.execute();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				try {
					String sql4 = "CREATE TABLE yy( l VARCHAR(100)) ENGINE = InnoDB";
					PreparedStatement stm= conn.prepareStatement(sql4);
					   stm = conn.prepareStatement(sql4);
					   stm.execute();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					String sql = "insert into yy(l) values(?)";
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1, textField.getText());
					stm.execute();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(textField, sb, "Tên đăng nhập không được để trống");
				DataValidator.validateEmpty(passwordField, sb, "Mật khẩu không được để trống");
				String password = new String(passwordField.getPassword());
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(null,  sb.toString(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				NguoiDung ndd = new NguoiDung();
				try {
					Vector nd = ndd.checkLogin(textField.getText(), new String(passwordField.getPassword()));
					if(nd == null) {
						JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu sai", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}else {
						setVisible(false);
						if(nd.get(2).equals("nhanvien"))
						nv.setVisible(true);
						
						if(nd.get(2).equals("quanly"))
						li.setVisible(true);
						
						
						if(nd.get(2).equals("hocvien"))
						hv.setVisible(true);
						try {
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
					}
					textField.setText(nd.get(0)+"");
					
				}catch(Exception e1) {
					e1.printStackTrace();
//					JOptionPane.showMessageDialog(null,  e1.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		}); 
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(168, 226, 130, 30);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("Image/dn.png"));
		r = textField.getText();
		JButton btnThot = new JButton("Thoát");
		btnThot.setBackground(new Color(245, 245, 245));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				//thực thi sẽ bị chấm dứt và dừng chương trình
			}
		});
		System.out.println(r);
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThot.setBounds(308, 226, 130, 30);
		contentPane.add(btnThot);
		setLocationRelativeTo(null);
		//Dòng code trên có tác dụng hiển thị cửa sổ lên vị trí giữa màn hình.
		btnThot.setIcon(new ImageIcon("Image/exit.png"));
		
		rdbtnNewRadioButton = new JRadioButton("Hiển thị mật khẩu");
		rdbtnNewRadioButton.setBackground(new Color(240, 248, 255));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(308, 149, 133, 21);
		contentPane.add(rdbtnNewRadioButton);
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
		
		return v;
	}
	public String rr() {
		return y;
	}
}
