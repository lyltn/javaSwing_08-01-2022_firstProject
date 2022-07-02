package form;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import connectData.Connect;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
public class PanelPhieuNop extends JPanel {
	private JTextField nopthang;
	private JTextField sotien;
	private JTable table;
	private Vector vT, vD;
	private Timer timerUpdate;
	private int selectRowUpdate = -1;
	private int row = -1;
	private String u;
	private int q;

	/**
	 * Create the panel.
	 */
	public PanelPhieuNop() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		Update_Phieu t = new Update_Phieu();

		JLabel lbmaphieu_1_1 = new JLabel("N\u1ED9p cho Th\u00E1ng:");
		lbmaphieu_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmaphieu_1_1.setBounds(39, 69, 127, 30);
		add(lbmaphieu_1_1);

		JLabel lbmaphieu_1_2 = new JLabel("S\u1ED1 Ti\u1EC1n:");
		lbmaphieu_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmaphieu_1_2.setBounds(435, 70, 105, 30);
		add(lbmaphieu_1_2);

		nopthang = new JTextField();
		nopthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nopthang.setColumns(10);
		nopthang.setBounds(180, 70, 180, 30);
		add(nopthang);

		sotien = new JTextField();
		sotien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sotien.setColumns(10);
		sotien.setBounds(523, 70, 180, 30);
		add(sotien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 250, 699, 115);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		vD = new Vector();

		vT = new Vector();
		vT.add("ID_HocVien");
		vT.add("Ngày Tháng Nộp");
		vT.add("Nộp Cho Tháng Thứ");
		vT.add("Số Tiền");
		table.setModel(new DefaultTableModel(vD, vT));
		
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
		String sql1 = "SELECT *  FROM nophocphi where mahv ='" + u + "'";
		PreparedStatement stm1;
		try {
			
			stm1 = conn.prepareStatement(sql1);
			ResultSet rs = stm1.executeQuery();
			while (rs.next()) {
			Vector t1 = new Vector();
			t1.add(rs.getString(1));
			t1.add(rs.getString(2));
			t1.add(rs.getInt(3));
			t1.add(rs.getInt(4));
			vD.add(t1);
			}

		} catch (SQLException e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		table.setModel(new DefaultTableModel(vD, vT));

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setIcon(new ImageIcon("Image/save.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int y=Integer.parseInt(sotien.getText());
				int e1 =q-y;
				if(e1>0) {
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền nộp còn thiếu: "+e1+"","có chắc chắn muốn nộp không ?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}
				}
				if(e1<0) {
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền nộp còn thừa: "+e1*(-1)+"","có chắc chắn muốn nộp không ?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}
				}
				if(e1==0) {
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền nộp đủ ","có chắc chắn muốn nộp không ?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}
				}
				try {

					String sql = "insert into nophocphi values(?,CURDATE(),?,?,?)";
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1,u);
					stm.setInt(2, Integer.parseInt(nopthang.getText()));
					stm.setInt(3, Integer.parseInt(sotien.getText()));
					stm.setString(4,u);
					stm.execute();

					System.out.println("da them");
					String sql1 = "SELECT *  FROM nophocphi where mahv ='" + u + "' and nopthang ='" + nopthang.getText() + "' "
							+ "and sotien ='" + sotien.getText() + "'";
					PreparedStatement stm1;
					try {
						stm1 = conn.prepareStatement(sql1);
						ResultSet rs = stm1.executeQuery();
						rs.next();
						Vector t1 = new Vector();
						t1.add(rs.getString(1));
						t1.add(rs.getString(2));
						t1.add(rs.getInt(3));
						t1.add(rs.getInt(4));
						vD.add(t1);

					} catch (SQLException e9) {
						// TODO Auto-generated catch block
						e9.printStackTrace();
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,  e2.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				table.setModel(new DefaultTableModel(vD, vT));
				
				nopthang.setText("");
				sotien.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(180, 151, 100, 30);
		add(btnNewButton);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(240, 248, 255));
		btnUpdate.setIcon(new ImageIcon("Image/update.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectRowUpdate = table.getSelectedRow();
				if (selectRowUpdate != -1) {
					Vector row1 = (Vector) vD.get(selectRowUpdate);
					t.setData(row1);
					t.setVisible(true);
					timerUpdate.start();
				}
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(459, 151, 113, 30);
		add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
		lblNewLabel.setBounds(700, 5, 30, 30);
		add(lblNewLabel);
		/*
		 * là lớp tiện ích có thể được sử dụng để lên 
		 * lịch cho một luồng được thực thi tại một thời điểm nhất định trong tương lai.
		 */
		timerUpdate = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t.isCheckOk()) {
					t.setCheckOk(false);
					vD.set(selectRowUpdate, t.getData());
					table.setModel(new DefaultTableModel(vD, vT));
					Vector i = (Vector) vD.get(selectRowUpdate);
					
					String query = "update nophocphi set mahv=?, thangnop=CURDATE(), nopthang=?, sotien=?  where mahv ='" + u + "' and nopthang ='" + i.get(2) + "' ";
					PreparedStatement stm1;
					try {
						stm1 = conn.prepareStatement(query);
						stm1.setString(1, u);
						stm1.setInt(2,Integer.parseInt(i.get(2)+""));
						stm1.setInt(3,Integer.parseInt(i.get(3)+""));
		
						stm1.executeUpdate();

					} catch (SQLException e9) {
						// TODO Auto-generated catch block
						e9.printStackTrace();
						JOptionPane.showMessageDialog(null,  e9.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					timerUpdate.stop();
				}
			}
		});

	}

}
