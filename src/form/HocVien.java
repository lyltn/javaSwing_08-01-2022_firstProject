package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class HocVien extends JFrame {

	private JPanel contentPane;
	private PanelPhieuNop panlenop;
	private JTabbedPane tab;
	private JPanel panel;
	private XemThongTin panlex;
	private Panel_DoiMK paneldoimk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HocVien frame = new HocVien();
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
	public HocVien() {
		setTitle("HocVien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 523);
		 ImageIcon webIcon = new ImageIcon("Image/st.png");
		 
	        setIconImage(webIcon.getImage());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 196, 222));
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("H\u1EC7 Th\u1ED1ng");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
		mntmNewMenuItem.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				setVisible(false);
	 			dn.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("Image/dx.png"));
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Đổi Mật Khẩu");
		mntmNewMenuItem_4.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(paneldoimk == null) {
					 paneldoimk = new Panel_DoiMK();
			    	 tab.addTab("Đổi mật khẩu", paneldoimk);
			     }
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon("Image/pass.png"));
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tho\u00E1t");
		mntmNewMenuItem_1.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("Image/exit.png"));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("File");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("N\u1ED9p H\u1ECDc Ph\u00ED");
		mntmNewMenuItem_2.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(panlenop == null) {
					 panlenop = new PanelPhieuNop();
			    	 tab.addTab("Nộp Học Phí", panlenop);
			     }
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Xem Th\u00F4ng Tin");
		mntmNewMenuItem_3.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(panlex == null) {
					 panlex = new XemThongTin();
			    	 tab.addTab("Xem Thông Tin", panlex);
			     }
			}
		});
		
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		 tab = new JTabbedPane(JTabbedPane.TOP);
		 tab.setBounds(5, 0, 740, 445);
		contentPane.add(tab);
		
		 panel = new JPanel();
		 panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(5, 0, 750, 457);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chương trình quản lý thu chi học phí");
		lblNewLabel.setBounds(90, 65, 604, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bạn đã đăng nhập với vai trò là học viên");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(135, 115, 461, 53);
		panel.add(lblNewLabel_1);
		
		JLabel Icon = new JLabel(new ImageIcon("Image/centre.png"));
		Icon.setBounds(210, 160, 300, 230);
		panel.add(Icon);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
