package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectData.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Update_Phieu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_2;
	private boolean checkOk = false;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	int q;
	String u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Phieu frame = new Update_Phieu();
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
	public Update_Phieu() {
		setTitle("Update_PhieuNop");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 416);
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMHcVin = new JLabel("M\u00E3 H\u1ECDc Vi\u00EAn: ");
		lblMHcVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMHcVin.setBounds(39, 32, 110, 30);
		contentPane.add(lblMHcVin);
		
		JLabel lblNgyThngNp = new JLabel("Ng\u00E0y Th\u00E1ng N\u1ED9p: ");
		lblNgyThngNp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgyThngNp.setBounds(39, 95, 144, 30);
		contentPane.add(lblNgyThngNp);
		
		JLabel lblNpChoThng = new JLabel("N\u1ED9p Cho Th\u00E1ng:");
		lblNpChoThng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNpChoThng.setBounds(39, 157, 144, 30);
		contentPane.add(lblNpChoThng);
		
		JLabel lblSTin = new JLabel("S\u1ED1 Ti\u1EC1n: ");
		lblSTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSTin.setBounds(39, 224, 110, 30);
		contentPane.add(lblSTin);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(188, 225, 230, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(188, 158, 230, 30);
		contentPane.add(textField_2);
		String sql = "SELECT * from yy";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				u=rs.getString(1);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sqlq = "SELECT hocphi from khoahoc inner join hocvien on hocvien.makh=khoahoc.makh where mahv = '"+u+"'";
		PreparedStatement stmq;
		try {
			stmq = conn.prepareStatement(sqlq);
			ResultSet rs = stmq.executeQuery();
			while (rs.next()) {
				q=rs.getInt(1);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCheckOk(true);
				int y=Integer.parseInt(textField_3.getText());
				int e1 =q-y;
				if(e1>0) {
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền nộp còn thiếu: "+e1+"","có muốn cập nhật không?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}
				}
				if(e1<0) {
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền nộp còn thừa: "+e1*(-1)+"","có muốn cập nhật không?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}
				}
				if(e1==0) {
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền nộp đủ ","có muốn cập nhật không?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}
				}
				
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("Image/update.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(173, 304, 130, 35);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(186, 32, 232, 30);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(188, 95, 230, 30);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public Vector getData() {
		Vector v = new Vector();
		v.add(lblNewLabel.getText());
		v.add(lblNewLabel_1.getText());
		v.add(textField_2.getText());
		v.add(textField_3.getText());
		return v;
	}
	
	public void clearTexifield() {
		lblNewLabel.setText("");
		lblNewLabel_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
	}
	
	public void setData(Vector data) {
		while (data.size() < 4)
			data.add(null);
//		System.out.println(data);
		lblNewLabel.setText((data.get(0) + ""));
		lblNewLabel_1.setText(data.get(1) + "");
		textField_2.setText(data.get(2) + "");
		textField_3.setText(data.get(3) + "");
	}
	public boolean isCheckOk() {
		return checkOk;
	}

	public void setCheckOk(boolean checkOk) {
		this.checkOk = checkOk;
	}
}
