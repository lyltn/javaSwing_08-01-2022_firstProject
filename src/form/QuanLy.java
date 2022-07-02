package form;

import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class QuanLy extends JFrame {

	private JPanel contentPane;
	private NopHocPhi nhp;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private ChiHocPhi chp;
	private PanelHocVien panelhv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLy frame = new QuanLy();
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
	public QuanLy() {
		setTitle("QuanLy");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 556);
		 ImageIcon webIcon = new ImageIcon("Image/ql.png");
		 
	        setIconImage(webIcon.getImage());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 196, 222));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("H\u1EC7 Th\u1ED1ng");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
		mntmNewMenuItem_1.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DangNhap dn = new DangNhap();
					setVisible(false);
		 			dn.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("Image/dx.png"));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tho\u00E1t");
		mntmNewMenuItem_2.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("Image/exit.png"));
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Qu\u1EA3n L\u00FD");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("N\u1ED9p H\u1ECDc Ph\u00ED");
		mntmNewMenuItem_3.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(nhp == null) {
					 nhp = new NopHocPhi();
			    	 tabbedPane.addTab("Nộp Học Phí", nhp);
			     }
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Chi H\u1ECDc Ph\u00ED");
		mntmNewMenuItem_4.setBackground(new Color(248, 248, 255));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				
				 if(chp == null) {
					 chp = new ChiHocPhi();
			    	 tabbedPane.addTab("Chi Học Phí", chp);
			     }
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 847, 486);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 0, 847, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chương trình quản lý thu chi học phí");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(115, 30, 592, 75);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("B\u1EA1n \u0111\u00E3 \u0111\u0103ng nh\u1EADp v\u1EDBi vai tr\u00F2 l\u00E0 qu\u1EA3n l\u00FD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(190, 115, 461, 53);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon("Image/centre.png"));
		lblNewLabel_3.setBounds(220, 170, 400, 200);
		panel.add(lblNewLabel_3);
		
		setLocationRelativeTo(null);
		setResizable(false); // k cho phép người dùng thay đổi kích thước của JFrame bất kỳ trường hợp nào
	}
}
