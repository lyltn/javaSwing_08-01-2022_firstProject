package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectData.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ql extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField mahv;
	private JTextField tenhv;
	private JTextField sdt;
	private JTextField ngayvaohoc;
	private JTextField makh;
	private Vector vT, vD, vT1, vD1, vT2, vD2, vD4, vD5 ;
	private Timer timerUpdate;
	private int selectRowUpdate = -1;
	private int row = -1;
	private int row1 = -1;
	private int row2 = -1;
	private JTable table_1;
	private JTable table_2;
	private boolean s = false;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ql frame = new ql();
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
	public ql() {
		setBackground(new Color(70, 130, 180));
		setTitle("QuanLy");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 ImageIcon webIcon = new ImageIcon("Image/ql.png");
		 
	        setIconImage(webIcon.getImage());
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		Update_JFrame ThreadUpdate = new Update_JFrame();
		setBounds(100, 100, 1368, 780);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\Copy of school admission - Made with PosterMyWall (1).jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(309, 10, 382, 152);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 1019, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		vD = new Vector();

		vT = new Vector();
		vT.add("ID_HocVien");
		vT.add("Tên Học Viên");
		vT.add("Tên Khóa Học");
		vT.add("Ngày Vào Học");
		vT.add("Số Điện Thoại");
		vT.add("Ngày Tháng Nộp");
		vT.add("Nộp Cho Tháng Thứ");
		vT.add("Số Tiền");
		table.setModel(new DefaultTableModel(vD, vT));
		String sql = "SELECT hocvien.mahv, tenhv, tenkh, ngayvaohoc,sdt, thangnop, nopthang, sotien FROM nophocphi right join hocvien on nophocphi.mahv= hocvien.mahv"
				+ " inner join khoahoc on khoahoc.makh= hocvien.makh order by   mahv asc, nopthang asc";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vector t1 = new Vector();
				t1.add(rs.getString(1));
				t1.add(rs.getString(2));
				t1.add(rs.getString(3));
				t1.add(rs.getString(4));
				t1.add(rs.getString(5));
				t1.add(rs.getString(6));
				t1.add(rs.getInt(7));
				t1.add(rs.getInt(8));
				vD.add(t1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		for (int i = 0; i < vT.size(); i++)
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		table.setFont(new Font("Verdana", Font.PLAIN, 13));
		
//		lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
//		lblNewLabel.setBounds(810, 5, 30, 30);
//		add(lblNewLabel);
		if (vT.size() != 0) {
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(1).setPreferredWidth(110);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(45);
			table.getColumnModel().getColumn(4).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(45);
			table.getColumnModel().getColumn(6).setPreferredWidth(65);
			table.getColumnModel().getColumn(7).setPreferredWidth(25);
		}
		setVisible(true);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 h\u1ECDc vi\u00EAn: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(1053, 34, 214, 28);
		contentPane.add(lblNewLabel_1);
		
		mahv = new JTextField();
		mahv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mahv.setBounds(1053, 75, 291, 32);
		contentPane.add(mahv);
		mahv.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn h\u1ECDc vi\u00EAn:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(1053, 119, 214, 28);
		contentPane.add(lblNewLabel_1_1);
		
		tenhv = new JTextField();
		tenhv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenhv.setColumns(10);
		tenhv.setBounds(1053, 164, 291, 32);
		contentPane.add(tenhv);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(1053, 215, 214, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		sdt = new JTextField();
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sdt.setColumns(10);
		sdt.setBounds(1053, 257, 291, 32);
		contentPane.add(sdt);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ng\u00E0y v\u00E0o h\u1ECDc:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(1053, 306, 214, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		ngayvaohoc = new JTextField();
		ngayvaohoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ngayvaohoc.setColumns(10);
		ngayvaohoc.setBounds(1053, 349, 291, 32);
		contentPane.add(ngayvaohoc);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("M\u00E3 kh\u00F3a h\u1ECDc:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(1053, 403, 214, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		makh = new JTextField();
		makh.setBackground(Color.WHITE);
		makh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		makh.setColumns(10);
		makh.setBounds(1053, 446, 291, 32);
		contentPane.add(makh);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setIcon(new ImageIcon("Image/save.png"));
		btnNewButton.addActionListener(new ActionListener() {
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
					String sqle = "SELECT hocvien.mahv, tenhv, tenkh, ngayvaohoc,sdt, thangnop, nopthang, sotien FROM nophocphi right join hocvien on nophocphi.mahv= hocvien.mahv inner join khoahoc on khoahoc.makh= hocvien.makh WHERE hocvien.mahv='"+mahv.getText()+"' order by mahv asc, nopthang asc;";
					PreparedStatement stme;
					try {
						stme = conn.prepareStatement(sqle);
						ResultSet rs = stme.executeQuery();
						while (rs.next()) {
							Vector t1 = new Vector();
							t1.add(rs.getString(1));
							t1.add(rs.getString(2));
							t1.add(rs.getString(3));
							t1.add(rs.getString(4));
							t1.add(rs.getString(5));
							t1.add(rs.getString(6));
							t1.add(rs.getInt(7));
							t1.add(rs.getInt(8));
							vD.add(t1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				table.setModel(new DefaultTableModel(vD, vT));
				
				String sqly = "SELECT * FROM hocvien where mahv= '"+mahv.getText()+"'";
				PreparedStatement stmy;
				try {
					stmy = conn.prepareStatement(sqly);
					ResultSet rs = stmy.executeQuery();
					while (rs.next()) {
						Vector t = new Vector();
						t.add(rs.getString(1));
						t.add(rs.getString(2));
						t.add(rs.getString(3));
						t.add(rs.getString(4));
						t.add(rs.getString(5));
						vD2.add(t);
					}
				} catch (SQLException eh) {
					// TODO Auto-generated catch block
					eh.printStackTrace();
				}
				table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				for (int i = 0; i < vT.size(); i++)
					table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
				table.setFont(new Font("Verdana", Font.PLAIN, 13));
				
//				
				if (vT.size() != 0) {
					table.getColumnModel().getColumn(0).setPreferredWidth(25);
					table.getColumnModel().getColumn(1).setPreferredWidth(110);
					table.getColumnModel().getColumn(2).setPreferredWidth(130);
					table.getColumnModel().getColumn(3).setPreferredWidth(45);
					table.getColumnModel().getColumn(4).setPreferredWidth(50);
					table.getColumnModel().getColumn(5).setPreferredWidth(45);
					table.getColumnModel().getColumn(6).setPreferredWidth(65);
					table.getColumnModel().getColumn(7).setPreferredWidth(25);
				}
				mahv.setText("");
				tenhv.setText("");
				sdt.setText("");
				ngayvaohoc.setText("");
				makh.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1136, 508, 125, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 538, 260, 187);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnHvChaNp = new JButton("HV chưa nộp học phí");
		btnHvChaNp.setBackground(new Color(240, 248, 255));
		btnHvChaNp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SELECT mahv, tenhv from hocvien where mahv not in (SELECT mahv from nophocphi);
				vD1 = new Vector();

				vT1 = new Vector();
				vT1.add("ID_HocVien");
				vT1.add("Tên Học Viên");
				
				table_1.setModel(new DefaultTableModel(vD1, vT1));
				String sql = "SELECT mahv, tenhv from hocvien where mahv not in (SELECT mahv from nophocphi)";
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(sql);
					ResultSet rs = stm.executeQuery();
					while (rs.next()) {
						Vector t1 = new Vector();
						t1.add(rs.getString(1));
						t1.add(rs.getString(2));
						vD1.add(t1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				for (int i = 0; i < vT1.size(); i++)
					table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
				table_1.setFont(new Font("Verdana", Font.PLAIN, 13));
				
//				
				if (vT1.size() != 0) {
					table_1.getColumnModel().getColumn(0).setPreferredWidth(25);
					table_1.getColumnModel().getColumn(1).setPreferredWidth(110);
				}
				
			}
		});
		btnHvChaNp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHvChaNp.setBounds(39, 487, 200, 35);
		contentPane.add(btnHvChaNp);
		
		JButton btnTm = new JButton("Search");
		btnTm.setIcon(new ImageIcon("Image/search.png"));
		btnTm.setBackground(new Color(240, 248, 255));
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s=true;
				Vector v = new Vector();
				v.add(mahv.getText());
				v.add(tenhv.getText());
				v.add(sdt.getText());
				v.add(ngayvaohoc.getText());
				v.add(makh.getText());
				
				 vD4 = new Vector();
				for (int i = 0; i < vD.size(); i++) {
					Vector row = (Vector)vD.get(i);
					if (checkVector(v, row))
						vD4.add(vD.get(i));
				}
				 vD5 = new Vector();
				for (int i = 0; i < vD2.size(); i++) {
					Vector row = (Vector)vD2.get(i);
					if (checkVector(v, row))
						vD5.add(vD2.get(i));
				}
				table.setModel(new DefaultTableModel(vD4, vT));
				table_2.setModel(new DefaultTableModel(vD5, vT2));
				
				DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
				for (int u = 0; u < vT.size(); u++)
					table.getColumnModel().getColumn(u).setCellRenderer( centerRenderer1 );
				table.setFont(new Font("Verdana", Font.PLAIN, 13));
			
				if (vT.size() != 0) {
					table.getColumnModel().getColumn(0).setPreferredWidth(25);
					table.getColumnModel().getColumn(1).setPreferredWidth(110);
					table.getColumnModel().getColumn(2).setPreferredWidth(130);
					table.getColumnModel().getColumn(3).setPreferredWidth(45);
					table.getColumnModel().getColumn(4).setPreferredWidth(50);
					table.getColumnModel().getColumn(5).setPreferredWidth(45);
					table.getColumnModel().getColumn(6).setPreferredWidth(65);
					table.getColumnModel().getColumn(7).setPreferredWidth(25);
				}
				
			}
		});
		btnTm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTm.setBounds(689, 487, 125, 35);
		contentPane.add(btnTm);
		
		JButton btnXa = new JButton("Delete");
		btnXa.setIcon(new ImageIcon("Image/delete.png"));
		btnXa.setBackground(new Color(240, 248, 255));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				row = table.getSelectedRow();
				int o=0;
				if(row != -1) {
					Vector i;
					if(s==true) {
						i = (Vector) vD4.get(row);
					}else {
						i = (Vector) vD.get(row);
					}
					
					String p = i.get(0) + "";
					String sql4 = "SELECT sum(sotien) from nophocphi where mahv = '"+p+"' ";
					PreparedStatement stm4;
					try {
						stm4 = conn.prepareStatement(sql4);
						ResultSet rs = stm4.executeQuery();
						while (rs.next()) {
							
							o=rs.getInt(1);
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền đã nộp của học viên này: "+o+"","có chắc chắn muốn xóa không ?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}

					try {
						
						String sql = "DELETE FROM hocvien WHERE mahv =(?)";
						PreparedStatement stm = conn.prepareStatement(sql);
						
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
						//JOptionPane.showMessageDialog(null,  e1.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					if (row != -1) {
						vD.remove(row);
						table.setModel(new DefaultTableModel(vD, vT));
					}
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					for (int y = 0; y < vT1.size(); y++)
						table_1.getColumnModel().getColumn(y).setCellRenderer( centerRenderer );
					table_1.setFont(new Font("Verdana", Font.PLAIN, 13));
					
//					
					if (vT1.size() != 0) {
						table_1.getColumnModel().getColumn(0).setPreferredWidth(25);
						table_1.getColumnModel().getColumn(1).setPreferredWidth(110);
					}
					DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
					for (int u = 0; u < vT.size(); u++)
						table.getColumnModel().getColumn(u).setCellRenderer( centerRenderer1 );
					table.setFont(new Font("Verdana", Font.PLAIN, 13));
				
					if (vT.size() != 0) {
						table.getColumnModel().getColumn(0).setPreferredWidth(25);
						table.getColumnModel().getColumn(1).setPreferredWidth(110);
						table.getColumnModel().getColumn(2).setPreferredWidth(130);
						table.getColumnModel().getColumn(3).setPreferredWidth(45);
						table.getColumnModel().getColumn(4).setPreferredWidth(50);
						table.getColumnModel().getColumn(5).setPreferredWidth(45);
						table.getColumnModel().getColumn(6).setPreferredWidth(65);
						table.getColumnModel().getColumn(7).setPreferredWidth(25);
					}
				}
				row1 = table_1.getSelectedRow();
				if(row1 != -1) {
					
					Vector i = (Vector) vD1.get(row1);
					String p3 = i.get(0) + "";
					String sql4 = "SELECT sum(sotien) from nophocphi where mahv = '"+p3+"' ";
					PreparedStatement stm4;
					try {
						stm4 = conn.prepareStatement(sql4);
						ResultSet rs = stm4.executeQuery();
						while (rs.next()) {
							
							o=rs.getInt(1);
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền đã nộp của học viên này: "+o+"","có chắc chắn muốn xóa không ?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}

					try {
						Vector i6 = (Vector) vD1.get(row1);
						String sql = "DELETE FROM hocvien WHERE mahv =(?)";
						PreparedStatement stm = conn.prepareStatement(sql);
						String p6 = i.get(0) + "";
						stm.setString(1, p3);

						System.out.println(p6);
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
						//JOptionPane.showMessageDialog(null,  e1.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					if (row1 != -1) {
						vD1.remove(row1);
						table_1.setModel(new DefaultTableModel(vD1, vT1));
						
					}
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					for (int y = 0; y < vT1.size(); y++)
						table_1.getColumnModel().getColumn(y).setCellRenderer( centerRenderer );
					table_1.setFont(new Font("Verdana", Font.PLAIN, 13));
					
//					
					if (vT1.size() != 0) {
						table_1.getColumnModel().getColumn(0).setPreferredWidth(25);
						table_1.getColumnModel().getColumn(1).setPreferredWidth(110);
					}
					DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
					for (int u = 0; u < vT.size(); u++)
						table.getColumnModel().getColumn(u).setCellRenderer( centerRenderer1 );
					table.setFont(new Font("Verdana", Font.PLAIN, 13));
				
					if (vT.size() != 0) {
						table.getColumnModel().getColumn(0).setPreferredWidth(25);
						table.getColumnModel().getColumn(1).setPreferredWidth(110);
						table.getColumnModel().getColumn(2).setPreferredWidth(130);
						table.getColumnModel().getColumn(3).setPreferredWidth(45);
						table.getColumnModel().getColumn(4).setPreferredWidth(50);
						table.getColumnModel().getColumn(5).setPreferredWidth(45);
						table.getColumnModel().getColumn(6).setPreferredWidth(65);
						table.getColumnModel().getColumn(7).setPreferredWidth(25);
					}
				}
				row2 = table_2.getSelectedRow();
				if(row2 != -1) {
					Vector i;
					if(s==true) {
						i = (Vector) vD5.get(row2);
					}else {
						i = (Vector) vD2.get(row2);
					}
					
					String p2 = i.get(0) + "";
					String sql4 = "SELECT sum(sotien) from nophocphi where mahv = '"+p2+"' ";
					PreparedStatement stm4;
					try {
						stm4 = conn.prepareStatement(sql4);
						ResultSet rs = stm4.executeQuery();
						while (rs.next()) {
							
							o=rs.getInt(1);
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(JOptionPane.showConfirmDialog(null, 
							"số tiền đã nộp của học viên này: "+o+"","có chắc chắn muốn xóa không ?",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE)== JOptionPane.NO_OPTION) {
						return;
					}

					try {
						
						String sql = "DELETE FROM hocvien WHERE mahv =(?)";
						PreparedStatement stm = conn.prepareStatement(sql);
						
						stm.setString(1, p2);

						System.out.println(p2);
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
						//JOptionPane.showMessageDialog(null,  e1.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					if (row2 != -1) {
						vD2.remove(row2);
						table_2.setModel(new DefaultTableModel(vD2, vT2));
					
						
						
					 
						
					}
					
				}
				
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXa.setBounds(309, 487, 125, 35);
		contentPane.add(btnXa);
		
		JButton btnSa = new JButton("Update");
		btnSa.setIcon(new ImageIcon("Image/update.png"));
		btnSa.setBackground(new Color(240, 248, 255));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectRowUpdate = table_2.getSelectedRow();
				Vector row1;
				if (selectRowUpdate != -1) {
					if(s==true) {
						row1 = (Vector) vD5.get(selectRowUpdate);
					}else {
						row1 = (Vector) vD2.get(selectRowUpdate);
					}
					
					ThreadUpdate.setData(row1);
					ThreadUpdate.setVisible(true);
					timerUpdate.start();
				}
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSa.setBounds(502, 487, 125, 35);
		contentPane.add(btnSa);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(296, 546, 733, 172);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		vD2 = new Vector();

		vT2 = new Vector();
		vT2.add("ID_hocvien");
		vT2.add("Tên học Viên");
		vT2.add("sdt");
		vT2.add("Ngày vào học");
		vT2.add("ID_khoahoc");
		table_2.setModel(new DefaultTableModel(vD2, vT2));
		String sqly = "SELECT * FROM hocvien";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getString(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				vD2.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnRe = new JButton("Refresh");
		btnRe.setBackground(new Color(240, 248, 255));
		btnRe.setIcon(new ImageIcon("Image/refresh.png"));
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vD.clear();
				vD2.clear();
				String sqly = "SELECT * FROM hocvien";
				PreparedStatement stmy;
				try {
					stmy = conn.prepareStatement(sqly);
					ResultSet rs = stmy.executeQuery();
					while (rs.next()) {
						Vector t = new Vector();
						t.add(rs.getString(1));
						t.add(rs.getString(2));
						t.add(rs.getString(3));
						t.add(rs.getString(4));
						t.add(rs.getString(5));
						vD2.add(t);
					}
				} catch (SQLException et) {
					// TODO Auto-generated catch block
					et.printStackTrace();
				}
				table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				String sqle = "SELECT hocvien.mahv, tenhv, tenkh, ngayvaohoc,sdt, thangnop, nopthang, sotien FROM nophocphi right join hocvien on nophocphi.mahv= hocvien.mahv"
						+ " inner join khoahoc on khoahoc.makh= hocvien.makh order by   mahv asc, nopthang asc";
				PreparedStatement stme;
				try {
					stme = conn.prepareStatement(sqle);
					ResultSet rs = stme.executeQuery();
					while (rs.next()) {
						Vector t1 = new Vector();
						t1.add(rs.getString(1));
						t1.add(rs.getString(2));
						t1.add(rs.getString(3));
						t1.add(rs.getString(4));
						t1.add(rs.getString(5));
						t1.add(rs.getString(6));
						t1.add(rs.getInt(7));
						t1.add(rs.getInt(8));
						vD.add(t1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(new DefaultTableModel(vD, vT));
				table_2.setModel(new DefaultTableModel(vD2, vT2));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				for (int i = 0; i < vT.size(); i++)
					table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
				table.setFont(new Font("Verdana", Font.PLAIN, 13));
				
//				lblNewLabel = new JLabel("");
//				lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
//				lblNewLabel.setBounds(810, 5, 30, 30);
//				add(lblNewLabel);
				if (vT.size() != 0) {
					table.getColumnModel().getColumn(0).setPreferredWidth(25);
					table.getColumnModel().getColumn(1).setPreferredWidth(110);
					table.getColumnModel().getColumn(2).setPreferredWidth(130);
					table.getColumnModel().getColumn(3).setPreferredWidth(45);
					table.getColumnModel().getColumn(4).setPreferredWidth(50);
					table.getColumnModel().getColumn(5).setPreferredWidth(45);
					table.getColumnModel().getColumn(6).setPreferredWidth(65);
					table.getColumnModel().getColumn(7).setPreferredWidth(25);
				}
				
			}
		});
		btnRe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRe.setBounds(878, 487, 125, 35);
		contentPane.add(btnRe);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(240, 248, 255));
		btnNewButton_1.setIcon(new ImageIcon("Image/exit.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(0, 0, 48, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setBackground(new Color(240, 248, 255));
		btnNewButton_1_1.setIcon(new ImageIcon("Image/dx.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				setVisible(false);
	 			dn.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(52, 0, 48, 21);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng học phí ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(1053, 553, 155, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(1113, 593, 231, 32);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Từ:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(1053, 593, 66, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Đến:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(1053, 635, 66, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(1113, 635, 231, 32);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Là:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(1053, 679, 48, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(1113, 679, 155, 30);
		contentPane.add(lblNewLabel_2_2);
		
		JButton btnTnh = new JButton("calulate");
		btnTnh.setBackground(new Color(240, 248, 255));
		btnTnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int b= 0;
				String sql4 = "SELECT sum(sotien) FROM `nophocphi` WHERE thangnop> '"+textField.getText()+"' and thangnop<'"+textField_1.getText()+"';";
				PreparedStatement stm4;
				try {
					stm4 = conn.prepareStatement(sql4);
					ResultSet rs = stm4.executeQuery();
					while (rs.next()) {
						
						b=rs.getInt(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String s = String.valueOf(b);
				lblNewLabel_2_2.setText(s);
			}
		});
		btnTnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTnh.setBounds(1265, 677, 79, 35);
		contentPane.add(btnTnh);
		setLocationRelativeTo(null);
		setResizable(false);
		
		timerUpdate = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ThreadUpdate.isCheckOk()) {
					ThreadUpdate.setCheckOk(false);
					vD2.set(selectRowUpdate, ThreadUpdate.getData());
					
					table_2.setModel(new DefaultTableModel(vD2, vT2));
					
					Vector i = (Vector) vD2.get(selectRowUpdate);
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
					String sqle = "SELECT hocvien.mahv, tenhv, tenkh, ngayvaohoc,sdt, thangnop, nopthang, sotien FROM nophocphi right join hocvien on nophocphi.mahv= hocvien.mahv"
							+ " inner join khoahoc on khoahoc.makh= hocvien.makh order by   mahv asc, nopthang asc";
					PreparedStatement stme;
					try {
						stme = conn.prepareStatement(sqle);
						ResultSet rs = stme.executeQuery();
						while (rs.next()) {
							Vector t1 = new Vector();
							t1.add(rs.getString(1));
							t1.add(rs.getString(2));
							t1.add(rs.getString(3));
							t1.add(rs.getString(4));
							t1.add(rs.getString(5));
							t1.add(rs.getString(6));
							t1.add(rs.getInt(7));
							t1.add(rs.getInt(8));
							vD.add(t1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					for (int i1 = 0; i1 < vT.size(); i1++)
						table.getColumnModel().getColumn(i1).setCellRenderer( centerRenderer );
					table.setFont(new Font("Verdana", Font.PLAIN, 13));
					
//					lblNewLabel = new JLabel("");
//					lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
//					lblNewLabel.setBounds(810, 5, 30, 30);
//					add(lblNewLabel);
					if (vT.size() != 0) {
						table.getColumnModel().getColumn(0).setPreferredWidth(25);
						table.getColumnModel().getColumn(1).setPreferredWidth(110);
						table.getColumnModel().getColumn(2).setPreferredWidth(130);
						table.getColumnModel().getColumn(3).setPreferredWidth(45);
						table.getColumnModel().getColumn(4).setPreferredWidth(50);
						table.getColumnModel().getColumn(5).setPreferredWidth(45);
						table.getColumnModel().getColumn(6).setPreferredWidth(65);
						table.getColumnModel().getColumn(7).setPreferredWidth(25);
					}
					timerUpdate.stop();
				}
			}
		});
	}
	public boolean checkVector(Vector v, Vector row) {
		for (int i = 0; i < v.size(); i++)  {
			String s = v.get(i) + "";
			String p = row.get(i) + "";
			
			if (s.length() != 0 && !s.equals(p))
				return false;
		}
		
		return true;
	}
}
