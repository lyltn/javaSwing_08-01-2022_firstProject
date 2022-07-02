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
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;

public class NhanVien extends JFrame {
	private PanelHocVien panelhv;
	private PanelPhieuNop panlenop;
	private Panel_DoiMK paneldoimk;
	private PanelPhieuChi panlechi;
	private JTabbedPane tab;
	private JPanel panel;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVien() {
		setBackground(new Color(255, 255, 255));
		setTitle("NhanVien");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
		setBounds(100, 100, 773, 643);
		contentPane = new JPanel();
		
		 ImageIcon webIcon = new ImageIcon("Image/nvl.png");
		 
	        setIconImage(webIcon.getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 196, 222));
		menuBar.setBounds(0, 0, 756, 35);
		contentPane.add(menuBar);
		
		JMenu mnhethong = new JMenu("H\u1EC7 Th\u1ED1ng");
		mnhethong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnhethong);
		
		JMenuItem mntmthoat = new JMenuItem("Tho\u00E1t");
		mntmthoat.setBackground(new Color(248, 248, 255));
		mntmthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmthoat.setIcon(new ImageIcon("Image/exit.png"));
		JMenuItem mntmdoimatkhau = new JMenuItem("Đổi Mật Khẩu");
		mntmdoimatkhau.setBackground(new Color(248, 248, 255));
		mntmdoimatkhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(paneldoimk == null) {
					 paneldoimk = new Panel_DoiMK();
			    	 tab.addTab("Đổi mật khẩu", paneldoimk);
			     }
			}
		});
		mntmdoimatkhau.setIcon(new ImageIcon("Image/pass.png"));
		mntmdoimatkhau.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnhethong.add(mntmdoimatkhau);
		
		JMenuItem mntmdangxuat =  new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
		mntmdangxuat.setBackground(new Color(248, 248, 255));
		mntmdangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DangNhap dn = new DangNhap();
				setVisible(false);
				dn.setVisible(true);
			}
		});
		mntmdangxuat.setIcon(new ImageIcon("Image/dx.png"));
		mntmdangxuat.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnhethong.add(mntmdangxuat);
		mntmthoat.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnhethong.add(mntmthoat);
		JMenu mnnhap = new JMenu("Nh\u1EADp");
		mnnhap.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnnhap);
//		panlenop.setVisible(false);
//		 panelhv.setVisible(false);

		JMenuItem mntmphieunop = new JMenuItem("Học Viên");
		mntmphieunop.setBackground(new Color(248, 248, 255));
		mntmphieunop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
			     if(panelhv == null) {
			    	 panelhv = new PanelHocVien();
			    	 tab.addTab("Học Viên", panelhv);
			     }
			}
		});
		mntmphieunop.setIcon(new ImageIcon("Image/st.png"));
		mntmphieunop.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnnhap.add(mntmphieunop);
		
		JMenuItem mntmphieuchi = new JMenuItem("Phi\u1EBFu Chi");
		mntmphieuchi.setBackground(new Color(248, 248, 255));
		mntmphieuchi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(panlechi == null) {
					 panlechi = new PanelPhieuChi();
			    	 tab.addTab("Chi Học Phí", panlechi);
			     }
			}
		});
		mntmphieuchi.setIcon(new ImageIcon("Image/note.png"));
		mntmphieuchi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnnhap.add(mntmphieuchi);
		
		 tab = new JTabbedPane(JTabbedPane.TOP);
		 tab.setBounds(0, 35, 769, 571);
		contentPane.add(tab);
		
		 panel = new JPanel();
		 panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 35, 756, 569);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chương trình quản lý thu chi học phí ");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(100, 25, 578, 107);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bạn đã đăng nhập với vai trò là \r\nnhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(158, 122, 444, 62);
		panel.add(lblNewLabel_1);
		
		JLabel Icon = new JLabel(new ImageIcon("Image/centre.png"));
		Icon.setBounds(177, 180, 400, 271);
		panel.add(Icon);
		
		JTabbedPane tab1 = new JTabbedPane(JTabbedPane.TOP);
		tab1.setBounds(0, 35, 756, 569);
		contentPane.add(tab1);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
