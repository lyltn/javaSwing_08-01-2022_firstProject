package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectData.Connect;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ChiHocPhi extends JPanel {
	private JTable table;
	private Vector vT, vD;
	private Timer timerUpdate;
	private int selectRowUpdate = -1;
	private int row = -1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JCheckBox chckbxNewCheckBox;

	/**
	 * Create the panel.
	 */
	public ChiHocPhi() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 241, 808, 167);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		vD = new Vector();

		vT = new Vector();
		vT.add("ID_Phieu");
		vT.add("ID_NhanVien");
		vT.add("Tên Nhân Viên");
		vT.add("Ngày Chi");
		vT.add("Số Tiền");
		vT.add("Lý Do");
		table.setModel(new DefaultTableModel(vD, vT));
		
		JLabel lblNewLabel = new JLabel("Mã Phiếu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(48, 40, 110, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(464, 40, 141, 30);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(191, 40, 180, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(609, 40, 180, 30);
		add(textField_1);
		
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnNhnVin.setBounds(48, 102, 131, 30);
		add(lblTnNhnVin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(191, 102, 180, 30);
		add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày Chi:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(464, 102, 110, 30);
		add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(609, 102, 180, 30);
		add(textField_3);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector v = new Vector();
				v.add(textField.getText());
				v.add(textField_1.getText());
				v.add(textField_2.getText());
				v.add(textField_3.getText());
				
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
		btnNewButton.setBounds(348, 167, 110, 40);
		add(btnNewButton);
		
		chckbxNewCheckBox = new JCheckBox("Không phân biệt chữ hoa hay thường");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(20, 424, 283, 21);
		add(chckbxNewCheckBox);
		String sql = "SELECT maphieuchi  ,nhanvien.manv,tennv ,ngaychi, sotien, lydo FROM chihocphi inner join nhanvien on chihocphi.manv= nhanvien.manv";
		PreparedStatement stm;
		/*
		 * Prepared statement là một tính năng được sử dụng để thực hiện lặp lại các câu lệnh SQL tương tự
		 *  nhau với hiệu quả cao. Đối với prepared statement, quá trình hoạt động 
		 * sẽ diễn ra như sau: Prepare: đầu tiên, ứng dụng tạo ra 1 statement template và gửi nó cho DBMS
		 */
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			/*
			 * ResultSet interface đại diện cho một tập kết quả trả về từ câu truy vấn SELECT này. ... 
			 * Tương ứng với mỗi dòng sẽ có các cột tương ứng mà mệnh đề SELECT trả về.
			 *  Trong ResultSet có 3 hoạt động chính
			 * : Navigational methods – dùng để duy chuyển con trỏ đến các dòng dữ liệu khác trong tập kết quả
			 */
			//ExecuteQuery (chỉ lấy hàng trong kho): sử dụng chủ yếu cho các câu query select.
			while (rs.next()) {
				/*
				 * Ban đầu con trỏ được đặt trước hàng đầu tiên. Phương thức tiếp theo di chuyển 
				 * con trỏ đến hàng tiếp theo và nó trả về false khi không còn hàng nào 
				 * trong đối tượng ResultSet, nên nó có thể được sử dụng trong một vòng lặp while để lặp qua tập kết quả.
				 */
				Vector t1 = new Vector();
				t1.add(rs.getString(1));
				t1.add(rs.getString(2));
				t1.add(rs.getString(3));
				t1.add(rs.getString(4));
				t1.add(rs.getInt(5));
				t1.add(rs.getString(6));
				vD.add(t1);
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\java\\tttt.png"));
		lblNewLabel_2.setBounds(810, 5, 30, 30);
		add(lblNewLabel_2);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		//Mỗi một ô trong bảng JTable được vẽ nên bởi một đối tượng gọi là cell renderer. 
		//Đối tượng này sinh ra từ các lớp có cài đặt interface là TableCellRenderer
		//chức năng vẽ nên hình hài cho cái ô của bảng
		for (int i = 0; i < vT.size(); i++)
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		if (vT.size() != 0) {
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(4).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(120);
			
			
		}

	}
	public boolean checkVector(Vector v, Vector row, boolean selected) {
		for (int i = 0; i < v.size(); i++)  {
			String s = v.get(i) + "";
			String p = row.get(i) + "";
			if (selected) {
				s = s.toUpperCase();
				p = p.toUpperCase();
				//s.toUpperCase() Nó chuyển đổi tất cả ký tự trong chuỗi từ chữ thường trở thành chữ Hoa
			}
			if (s.length() != 0 && !s.equals(p))
				return false;
		}
		
		return true;
	}
}
