package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectData.Connect;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NopHocPhi extends JPanel {
	private JCheckBox chckbxNewCheckBox;
	private JTable table;
	private Vector vT, vD;
	private Timer timerUpdate;
	private int selectRowUpdate = -1;
	private int row = -1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNgyVoHc;
	private JTextField textField_4;
	private JLabel lblNgyThngNp;
	private JTextField textField_5;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public NopHocPhi() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		Connect cn = new Connect();
		Connection conn = cn.getConnection();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 827, 199);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		vD = new Vector();

		vT = new Vector();
		vT.add("ID_HocVien");
		vT.add("Tên Học Viên");
		vT.add("Tên Khóa Học");
		vT.add("Ngày Vào Học");
		vT.add("Ngày Tháng Nộp");
		vT.add("Nộp Cho Tháng Thứ");
		vT.add("Số Tiền");
		table.setModel(new DefaultTableModel(vD, vT));
		
		lblNewLabel_2 = new JLabel("Mã Học Viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(20, 27, 120, 25);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(20, 65, 160, 25);
		add(textField_2);
		
		lblNewLabel_3 = new JLabel("Tên Học Viên:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(234, 27, 120, 25);
		add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(234, 65, 160, 25);
		add(textField_3);
		
		lblNgyVoHc = new JLabel("Ngày Vào Học:");
		lblNgyVoHc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyVoHc.setBounds(450, 27, 120, 25);
		add(lblNgyVoHc);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(450, 65, 160, 25);
		add(textField_4);
		
		lblNgyThngNp = new JLabel("Ngày Tháng Nộp:");
		lblNgyThngNp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyThngNp.setBounds(657, 27, 160, 25);
		add(lblNgyThngNp);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(657, 65, 160, 25);
		add(textField_5);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector v = new Vector();
				v.add(textField_2.getText());
				v.add(textField_3.getText());
				v.add(textField_4.getText());
				v.add(textField_5.getText());
				
				Vector vD2 = new Vector();
				for (int i = 0; i < vD.size(); i++) {
					Vector row = (Vector)vD.get(i);
					if (checkVector(v, row, chckbxNewCheckBox.isSelected()))
						vD2.add(vD.get(i));
				}
				table.setModel(new DefaultTableModel(vD2, vT));
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(367, 128, 115, 41);
		add(btnNewButton);
		
		chckbxNewCheckBox = new JCheckBox("Không phân biệt chữ hoa hay thường");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(10, 424, 339, 23);
		add(chckbxNewCheckBox);

		String sql = "SELECT hocvien.mahv, tenhv, tenkh, ngayvaohoc, thangnop, nopthang, sotien FROM nophocphi right join hocvien on nophocphi.mahv= hocvien.mahv"
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
				t1.add(rs.getInt(6));
				t1.add(rs.getInt(7));
				vD.add(t1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		for (int i = 0; i < vT.size(); i++)
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\java\\tttt.png"));
		lblNewLabel.setBounds(810, 5, 30, 30);
		add(lblNewLabel);
		if (vT.size() != 0) {
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(90);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(4).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(75);
			table.getColumnModel().getColumn(6).setPreferredWidth(30);
		}
		setVisible(true);}
		

	
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
