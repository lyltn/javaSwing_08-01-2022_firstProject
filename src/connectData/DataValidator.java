package connectData;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DataValidator {
	public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
		if(field.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			//được sử dụng để nối thêm các chuỗi được chỉ định với chuỗi này.
			field.setBackground(Color.pink);
			field.requestFocus();
			/*
			 *  lệnh này chuyển focus sang text field Mình 
			 *  muốn có thể sử dụng selectAll() method để bôi đen toàn bộ dữ liệu trong ô text field đó.
			 */
			
		}else {
			field.setBackground(Color.white);
		}
	}
	public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
		String password = new String(field.getPassword());
		if(password.equals("")) {
			sb.append(errorMessage).append("\n");
			field.setBackground(Color.pink);
			field.requestFocus();
		}else {
			field.setBackground(Color.white);
		}
	}
}
