package form;

import javax.swing.JPanel;

import connectData.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class XemThongTin extends JPanel {
	private DangNhap dn;
	private Timer timerUpdate;
	String t = null;

	/**
	 * Create the panel.
	 */
	public XemThongTin() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		Update_JFrame ThreadUpdate = new Update_JFrame();
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBackground(new Color(248, 248, 255));
		lblNewLabel.setBounds(481, 126, 193, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1.setBounds(481, 166, 223, 30);
		add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBackground(new Color(240, 255, 255));
		lblNewLabel_2.setBounds(481, 206, 249, 30);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_2_1.setBounds(481, 246, 249, 30);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBackground(new Color(240, 255, 255));
		lblNewLabel_2_2.setBounds(481, 286, 234, 30);
		add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBackground(new Color(240, 255, 255));
		lblNewLabel_2_3.setBounds(481, 326, 288, 30);
		add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y V\u00E0o H\u1ECDc:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_1.setBounds(372, 246, 116, 30);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("M\u00E3 Kh\u00F3a H\u1ECDc:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_1_1.setBounds(372, 286, 123, 30);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("T\u00EAn Kh\u00F3a H\u1ECDc:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_1_2.setBounds(372, 326, 100, 30);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("M\u00E3 H\u1ECDc Vi\u00EAn:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_1_2_1.setBounds(372, 126, 99, 30);
		add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("T\u00EAn H\u1ECDc Vi\u00EAn:");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2_2.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_1_2_2.setBounds(372, 166, 100, 30);
		add(lblNewLabel_1_1_2_2);
		JLabel lblNewLabel_1_1_2_3 = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");
		lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2_3.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_1_2_3.setBounds(372, 206, 111, 30);
		add(lblNewLabel_1_1_2_3);
		
		
		String sql = "SELECT * from yy";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				t=rs.getString(1);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql4 = "SELECT mahv, tenhv, sdt, ngayvaohoc, khoahoc.makh, tenkh FROM hocvien inner join khoahoc on hocvien.makh= khoahoc.makh where mahv ='"+ t+"'";
		PreparedStatement stm4;
		try {
			stm4 = conn.prepareStatement(sql4);
			ResultSet rs = stm4.executeQuery();
			while (rs.next()) {
				lblNewLabel.setText(rs.getString(1));
				lblNewLabel_1.setText(rs.getString(2));
				lblNewLabel_2.setText(rs.getString(3));
				lblNewLabel_2_1.setText(rs.getString(4));
				lblNewLabel_2_2.setText(rs.getString(5));
				lblNewLabel_2_3.setText(rs.getString(6));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setIcon(new ImageIcon("Image/update.png"));
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Vector row1 = new Vector();
					String sql4 = "SELECT mahv, tenhv, sdt, ngayvaohoc, khoahoc.makh, tenkh FROM hocvien inner join khoahoc on hocvien.makh= khoahoc.makh where mahv ='"+ t+"'";
					PreparedStatement stm4;
					try {
						stm4 = conn.prepareStatement(sql4);
						ResultSet rs = stm4.executeQuery();
						while (rs.next()) {
							row1.add(rs.getString(1));
							row1.add(rs.getString(2));
							row1.add(rs.getString(3));
							row1.add(rs.getString(4));
							row1.add(rs.getString(5));
							row1.add(rs.getString(6));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ThreadUpdate.setData(row1);
					ThreadUpdate.setVisible(true);
					timerUpdate.start();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(320, 48, 130, 30);
		add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\java\\5596808.png"));
		lblNewLabel_3.setBounds(60, 108, 265, 261);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\java\\tttt.png"));
		lblNewLabel_4.setBounds(700, 5, 30, 30);
		add(lblNewLabel_4);
		
		
	
		timerUpdate = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ThreadUpdate.isCheckOk()) {
					ThreadUpdate.setCheckOk(false);
					
					
					Vector i = (Vector) ThreadUpdate.getData();
					String p = i.get(0) + "";
					String query = "update hocvien set mahv = ?, tenhv=?, sdt=?, ngayvaohoc=?," + " makh=?  where mahv = '"+p+"'";
					PreparedStatement stm1;
					try {
						stm1 = conn.prepareStatement(query);
						stm1.setString(1,p );
						stm1.setString(2,i.get(1)+"");
						stm1.setString(3, i.get(2)+"");
						stm1.setString(4, i.get(3)+"");
						stm1.setString(5,i.get(4)+"");
						stm1.executeUpdate();

					} catch (SQLException e9) {
						// TODO Auto-generated catch block
						e9.printStackTrace();
					}
					String sql4 = "SELECT mahv, tenhv, sdt, ngayvaohoc, khoahoc.makh, tenkh FROM hocvien inner join khoahoc on hocvien.makh= khoahoc.makh where mahv ='"+ t+"'";
					PreparedStatement stm4;
					try {
						stm4 = conn.prepareStatement(sql4);
						ResultSet rs = stm4.executeQuery();
						while (rs.next()) {
							lblNewLabel.setText(rs.getString(1));
							lblNewLabel_1.setText(rs.getString(2));
							lblNewLabel_2.setText(rs.getString(3));
							lblNewLabel_2_1.setText(rs.getString(4));
							lblNewLabel_2_2.setText(rs.getString(5));
							lblNewLabel_2_3.setText(rs.getString(6));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					timerUpdate.stop();
				}
			}
		});

	}
}
