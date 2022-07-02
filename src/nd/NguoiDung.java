package nd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectData.Connect;

public class NguoiDung {
	Connect cn = new Connect();
	String query;
	Vector y;

	public Vector checkLogin(String taikhoan, String matkhau) throws Exception {
		// throws Exception khai báo 1 ngoại lệ
		query = " select taikhoan, matkhau, vaitro from nguoidung " + "where taikhoan=? and matkhau=?";
		try (

				Connection conn = cn.getConnection();
				PreparedStatement stm = conn.prepareStatement(query);) {
			    stm.setString(1, taikhoan);
			    stm.setString(2, matkhau);
			    try {
					ResultSet rs = stm.executeQuery();
					while (rs.next()) {
						Vector a = new Vector();
						a.add(rs.getString(1));
						a.add(rs.getString(2));
						a.add(rs.getString(3));
						return a;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;

	}	
}
