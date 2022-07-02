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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectData.Connect;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelPhieuChi extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private Vector vT, vD;
	private Timer timerUpdate;
	private int selectRowUpdate = -1;
	private int row = -1;

	/**
	 * Create the panel.
	 */
	public PanelPhieuChi() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		Update_Chi t = new Update_Chi();
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMNhnVin.setBounds(49, 55, 124, 30);
		add(lblMNhnVin);
		
		JLabel lblNgyChi = new JLabel("Ng\u00E0y Chi:");
		lblNgyChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgyChi.setBounds(49, 140, 110, 30);
		add(lblNgyChi);
		
		JLabel lblSTin = new JLabel("S\u1ED1 Ti\u1EC1n:");
		lblSTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSTin.setBounds(432, 55, 93, 30);
		add(lblSTin);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 312, 702, 194);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		vD = new Vector();

		vT = new Vector();
		vT.add("ID_Phieu");
		vT.add("ID_NhanVien");
		vT.add("Ngày Chi");
		vT.add("Số Tiền");
		vT.add("Lý Do");
		table.setModel(new DefaultTableModel(vD, vT));

		String sql = "SELECT * FROM chihocphi";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vector t1 = new Vector();
				t1.add(rs.getString(1));
				t1.add(rs.getString(2));
				t1.add(rs.getString(3));
				t1.add(rs.getInt(4));
				t1.add(rs.getString(5));
				vD.add(t1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(183, 56, 180, 30);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(183, 141, 180, 30);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(521, 56, 180, 30);
		add(textField_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("L\u00FD Do:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(432, 140, 83, 30);
		add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(521, 141, 180, 30);
		add(textField_4);
		Vector rr = (Vector) vD.get(vD.size()-1);
		table();
		System.out.println(Integer.parseInt((String) rr.get(0))+1);
		int tt = Integer.parseInt((String) rr.get(0))+1;
		JButton btnNewButton = new JButton("Save");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					String sql = "insert into chihocphi values(?,?,?,?,?)";
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setInt(1, tt);
					stm.setString(2, textField_1.getText());
					stm.setString(3, textField_2.getText());
					stm.setInt(4, Integer.parseInt(textField_3.getText()));
					stm.setString(5, textField_4.getText());
					stm.execute();

					System.out.println("da them");
					String sql1 = "SELECT * FROM chihocphi where 	maphieuchi  =" + tt +"";
					PreparedStatement stm1;
					try {
						stm1 = conn.prepareStatement(sql1);
						ResultSet rs = stm1.executeQuery();
						rs.next();
						Vector t1 = new Vector();
						t1.add(rs.getInt(1));
						t1.add(rs.getString(2));
						t1.add(rs.getString(3));
						t1.add(rs.getInt(4));
						t1.add(rs.getString(5));
						vD.add(t1);

					} catch (SQLException e9) {
						// TODO Auto-generated catch block
						e9.printStackTrace();
						JOptionPane.showMessageDialog(null,  e9.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
						
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,  e2.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				table.setModel(new DefaultTableModel(vD, vT));
				
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				table();
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(164, 225, 110, 35);
		add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectRowUpdate = table.getSelectedRow();
				if (selectRowUpdate != -1) {
					Vector row1 = (Vector) vD.get(selectRowUpdate);
					t.setData(row1);
					t.setVisible(true);
					timerUpdate.start();
				}
				table();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(483, 225, 110, 35);
		add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
		lblNewLabel.setBounds(720, 5, 30, 30);
		add(lblNewLabel);
		
		
		
		
		
		timerUpdate = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t.isCheckOk()) {
					t.setCheckOk(false);
					vD.set(selectRowUpdate, t.getData());
					table.setModel(new DefaultTableModel(vD, vT));
					Vector i = (Vector) vD.get(selectRowUpdate);
					String p = i.get(0) + "";
					
					System.out.println(selectRowUpdate);
					String query = "update chihocphi set maphieuchi=?,  manv=?, ngaychi=?, sotien=?, "
							+ "lydo=?   where 	maphieuchi = '"+p+"'";
					PreparedStatement stm1;
					try {
						stm1 = conn.prepareStatement(query);
						stm1.setInt(1, Integer.parseInt(p));
						stm1.setString(2,i.get(1)+"");
						stm1.setString(3, i.get(2)+"");
						stm1.setInt(4,Integer.parseInt(i.get(3)+""));
						stm1.setString(5, i.get(4)+"");
		
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
		
		System.out.println(vD.size());
		System.out.println(selectRowUpdate);


	}
	public void table() {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		for (int i = 0; i < vT.size(); i++)
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		if (vT.size() != 0) {
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(3).setPreferredWidth(70);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			
		}
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
}
