package form;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectData.Connect;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelHocVien extends JPanel {
	private JTextField mahv;
	private JTextField tenhv;
	private JTextField sdt;
	private JTextField ngayvaohoc;
	private JTextField makh;
	private JTable table;
	private Vector vT, vD;
	private Timer timerUpdate;
	private int selectRowUpdate = -1;
	private int row = -1;

	/**
	 * Create the panel.
	 */
	public PanelHocVien() {
		setBackground(new Color(255, 255, 255));
		System.out.println("ok");
		setLayout(null);
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		Update_JFrame ThreadUpdate = new Update_JFrame();
		JLabel lbmahv = new JLabel("M\u00E3 H\u1ECDc Vi\u00EAn: ");
		lbmahv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmahv.setBounds(10, 30, 120, 25);
		add(lbmahv);

		JLabel lbtenhv = new JLabel("T\u00EAn H\u1ECDc Vi\u00EAn: ");
		lbtenhv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbtenhv.setBounds(10, 77, 120, 25);
		add(lbtenhv);

		JLabel lbsdt = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");
		lbsdt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbsdt.setBounds(10, 125, 140, 25);
		add(lbsdt);

		JLabel lbngayvaohoc = new JLabel("Ng\u00E0y V\u00E0o H\u1ECDc: ");
		lbngayvaohoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbngayvaohoc.setBounds(10, 173, 140, 25);
		add(lbngayvaohoc);

		JLabel lbmkh = new JLabel("M\u00E3 Kh\u00F3a H\u1ECDc:");
		lbmkh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbmkh.setBounds(10, 222, 120, 25);
		add(lbmkh);

		mahv = new JTextField();
		mahv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mahv.setBounds(140, 28, 269, 27);
		add(mahv);
		mahv.setColumns(10);

		tenhv = new JTextField();
		tenhv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tenhv.setColumns(10);
		tenhv.setBounds(140, 77, 269, 27);
		add(tenhv);

		sdt = new JTextField();
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sdt.setColumns(10);
		sdt.setBounds(140, 125, 269, 27);
		add(sdt);

		ngayvaohoc = new JTextField();
		ngayvaohoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ngayvaohoc.setColumns(10);
		ngayvaohoc.setBounds(140, 171, 269, 27);
		add(ngayvaohoc);

		makh = new JTextField();
		makh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		makh.setColumns(10);
		makh.setBounds(140, 219, 269, 27);
		add(makh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 737, 253);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		vD = new Vector();

		vT = new Vector();
		vT.add("ID_hocvien");
		vT.add("Tên học Viên");
		vT.add("sdt");
		vT.add("Ngày vào học");
		vT.add("ID_khoahoc");
		table.setModel(new DefaultTableModel(vD, vT));
		

		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "insert into hocvien(mahv, tenhv, sdt, ngayvaohoc, makh) values(?,?,?,?,?)";
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1, mahv.getText());
					stm.setString(2, tenhv.getText());
					stm.setString(3, sdt.getText());
					stm.setString(4, ngayvaohoc.getText());
					stm.setString(5, makh.getText());
					stm.execute();
					String sql2 = "insert into nguoidung(taikhoan, matkhau, vaitro) values(?,?,?)";
					PreparedStatement lll = conn.prepareStatement(sql2);
					lll.setString(1, mahv.getText());
					lll.setString(2, mahv.getText());
					lll.setString(3, "hocvien");
					lll.execute();
					System.out.println("da them");
					String sql1 = "SELECT * FROM hocvien where mahv ='" + mahv.getText() + "'";
					PreparedStatement stm1;
					try {
						stm1 = conn.prepareStatement(sql1);
						ResultSet rs = stm1.executeQuery();
						rs.next();
						Vector t = new Vector();
						t.add(rs.getString(1));
						t.add(rs.getString(2));
						t.add(rs.getString(3));
						t.add(rs.getString(4));
						t.add(rs.getString(5));
						vD.add(t);

					} catch (SQLException e9) {
						// TODO Auto-generated catch block
						e9.printStackTrace();
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(new DefaultTableModel(vD, vT));
				mahv.setText("");
				tenhv.setText("");
				sdt.setText("");
				ngayvaohoc.setText("");
				makh.setText("");
			}

		});
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnsave.setBounds(510, 30, 113, 35);
		add(btnsave);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectRowUpdate = table.getSelectedRow();
				if (selectRowUpdate != -1) {
					Vector row1 = (Vector) vD.get(selectRowUpdate);
					ThreadUpdate.setData(row1);
					ThreadUpdate.setVisible(true);
					timerUpdate.start();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(510, 199, 113, 35);
		add(btnUpdate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search_JF(vT, vD);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(510, 143, 113, 35);
		add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = table.getSelectedRow();
				if(JOptionPane.showConfirmDialog(null, 
						"có chắc chắn muốn xóa không ?","Hỏi",JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
					return;
				}

				try {
					Vector i = (Vector) vD.get(row);
					String sql = "DELETE FROM hocvien WHERE mahv =(?)";
					PreparedStatement stm = conn.prepareStatement(sql);
					String p = i.get(0) + "";
					stm.setString(1, p);

					System.out.println(p);
					stm.executeUpdate();
					String sql8 = "DELETE FROM nguoidung WHERE taikhoan =(?)";
					PreparedStatement stm8 = conn.prepareStatement(sql8);
					String p1 = i.get(0) + "";
					stm8.setString(1, p1);
					stm8.executeUpdate();
					System.out.println("Đã xóa.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,  e1.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				if (row != -1) {
					vD.remove(row);
					table.setModel(new DefaultTableModel(vD, vT));
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(510, 88, 113, 35);
		add(btnDelete);

		String sql = "SELECT * FROM hocvien";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getString(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				vD.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
		lblNewLabel.setBounds(720, 5, 30, 30);
		add(lblNewLabel);

		timerUpdate = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ThreadUpdate.isCheckOk()) {
					ThreadUpdate.setCheckOk(false);
					vD.set(selectRowUpdate, ThreadUpdate.getData());
					
					table.setModel(new DefaultTableModel(vD, vT));
					
					Vector i = (Vector) vD.get(selectRowUpdate);
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
					timerUpdate.stop();
				}
			}
		});
	}
}
