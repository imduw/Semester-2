package client.view.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import client.controller.OrderController;
import client.controller.ProductController;
import client.controller.UserController;
import client.view.ui.LoginUI;

public class LoginUI extends JFrame {

		private static final long serialVersionUID = 1L;
		private UserController userController;
		private ProductController productController;
		private OrderController orderController;
		
		private JPanel contentPane;
		private JTextField IPusername;
		private JPasswordField IPpassword;
		private JTextField IPuserSU;
		private JPasswordField IPpasswordSU;
		private JPasswordField IPpasswordSU2;
		private JTextField IPfirstName;
		private JButton Blogin;
		private JButton BsignupSU;
		private JButton Bsignup;
		private JPanel Psignup;
		private JPanel Plogin;
		private JPanel CardPanel_login;
		private JButton BloginSU;
		private JLabel LBwarning_login;
		private JLabel LBwarningSU;
		private JLabel LBfirstName;
		private JTextField IPlastName;
		private JLabel LBlastName;
		
		
		public LoginUI() {
			//------------------------------------------------------------//
			setBounds(new Rectangle(100, 100, 1080, 630));
			setTitle("Coffee Shop");
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 getContentPane().setLayout(null);
			
			 Plogin = new JPanel();
			Plogin.setLayout(null);
			
			JLabel LBimage = new JLabel("");
			LBimage.setBounds(-680, -1, 1309, 588);
			LBimage.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/banner.png"))));
			Plogin.add(LBimage);
			
			JPanel PloginArea = new JPanel();
			PloginArea.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(248, 248, 248)));
			PloginArea.setBackground(new Color(30, 39, 49));
			PloginArea.setBounds(629, -1, 435, 588);
			Plogin.add(PloginArea);
			PloginArea.setLayout(null);
			
			JLabel LBlogin = new JLabel("Login");
			LBlogin.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 60));
			LBlogin.setForeground(new Color(255, 255, 255));
			LBlogin.setBounds(137, 53, 166, 80);
			PloginArea.add(LBlogin);
			
			JLabel LBuser = new JLabel("");
			LBuser.setBounds(38, 214, 39, 33);
			PloginArea.add(LBuser);
			LBuser.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/user.png"))));
			Plogin.add(LBimage);
			
			JLabel LBpassword = new JLabel("");
			LBpassword.setBounds(43, 296, 29, 39);
			PloginArea.add(LBpassword);
			LBpassword.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/password.png"))));
			
			IPusername = new JTextField();
			IPusername.setCaretColor(new Color(255, 255, 255));
			IPusername.setHorizontalAlignment(SwingConstants.LEFT);
			IPusername.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
			IPusername.setForeground(new Color(255, 255, 255));
			IPusername.setColumns(10);
			IPusername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPusername.setBackground(new Color(30, 39, 49));
			IPusername.setBounds(86, 210, 276, 36);
			
			PloginArea.add(IPusername);
			
			IPpassword = new JPasswordField();
			IPpassword.setCaretColor(new Color(255, 255, 255));
			IPpassword.setForeground(new Color(255, 255, 255));
			IPpassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPpassword.setBackground(new Color(30, 39, 49));
			IPpassword.setBounds(86, 286, 276, 42);
			PloginArea.add(IPpassword);
			
			JLabel lblDontHaveAn = new JLabel("Don't have an account ?");
			lblDontHaveAn.setForeground(Color.WHITE);
			lblDontHaveAn.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
			lblDontHaveAn.setBounds(59, 535, 154, 14);
			PloginArea.add(lblDontHaveAn);
			
			 Blogin = new JButton("Login");		
			Blogin.setForeground(new Color(30, 39, 49));
			Blogin.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 19));
			Blogin.setBackground(new Color(30, 39, 49));
			Blogin.setBounds(137, 405, 177, 39);
			Blogin.setFocusable(false);
			PloginArea.add(Blogin);
			Blogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Blogin.setForeground(new Color(245,195,34));
					Blogin.setBorderPainted(false);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					Blogin.setForeground(new Color(30, 39, 49));
					Blogin.setBorderPainted(true);
				}
			});
			
			Bsignup = new JButton("Sign up");
			Bsignup.setForeground(new Color(30, 39, 49));
			Bsignup.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 13));
			Bsignup.setBackground(new Color(30, 39, 49));
			Bsignup.setBounds(214, 529, 84, 22);
			Bsignup.setFocusable(false);
			PloginArea.add(Bsignup);
			Bsignup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Bsignup.setForeground(new Color(245,195,34));
					Bsignup.setBorderPainted(false);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					Bsignup.setForeground(new Color(30, 39, 49));
					Bsignup.setBorderPainted(true);
				}
			});
			
			LBwarning_login = new JLabel("");
			LBwarning_login.setHorizontalAlignment(SwingConstants.CENTER);
			LBwarning_login.setForeground(new Color(236, 15, 20));
			LBwarning_login.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
			LBwarning_login.setBounds(20, 339, 383, 14);
			PloginArea.add(LBwarning_login);
			Plogin.add(LBimage);
			
			CardPanel_login = new JPanel();
			CardPanel_login.setBounds(0, 0, 1064, 591);
			CardPanel_login.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			getContentPane().add(CardPanel_login);
			CardPanel_login.setLayout(new CardLayout(0, 0));
			CardPanel_login.add(Plogin);		
			
			 Psignup = new JPanel();
			CardPanel_login.add(Psignup, "name_10636029098600");
			Psignup.setLayout(null);
			
			JLabel imagesignup = new JLabel("");
			imagesignup.setBounds(-680, -1, 1309, 588);
			Psignup.add(imagesignup);
			imagesignup.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/banner.png"))));
			
			JPanel Psu = new JPanel();
			Psu.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(248, 248, 248)));
			Psu.setBackground(new Color(30, 39, 49));
			Psu.setBounds(629, -1, 435, 588);
			Psignup.add(Psu);
			Psu.setLayout(null);
			
			JLabel LBsignup = new JLabel("Sign up");
			LBsignup.setHorizontalAlignment(SwingConstants.CENTER);
			LBsignup.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 60));
			LBsignup.setForeground(new Color(255, 255, 255));
			LBsignup.setBounds(15, 28, 403, 85);
			Psu.add(LBsignup);
			
			JLabel LBusersignup = new JLabel("");
			LBusersignup.setBounds(41, 204, 37, 40);
			Psu.add(LBusersignup);
			LBusersignup.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/user.png"))));
			Plogin.add(LBimage);
			
			JLabel LBpasswordsignup = new JLabel("");
			LBpasswordsignup.setBounds(44, 270, 28, 40);
			Psu.add(LBpasswordsignup);
			LBpasswordsignup.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/password.png"))));
			
			JLabel LBpasswordsignup_1 = new JLabel("");
			LBpasswordsignup_1.setBounds(45, 350, 28, 40);
			Psu.add(LBpasswordsignup_1);
			LBpasswordsignup_1.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/password.png"))));
			
			IPuserSU = new JTextField();
			IPuserSU.setCaretColor(new Color(255, 255, 255));
			IPuserSU.setForeground(new Color(255, 255, 255));
			IPuserSU.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
			IPuserSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPuserSU.setBackground(new Color(30, 39, 49));
			IPuserSU.setBounds(86, 201, 275, 41);
			Psu.add(IPuserSU);
			IPuserSU.setColumns(10);
			
			 BsignupSU = new JButton("Signup\r\n");
			BsignupSU.setForeground(new Color(30, 39, 49));
			BsignupSU.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 19));
			BsignupSU.setBackground(new Color(30, 39, 49));
			BsignupSU.setBounds(142, 435, 152, 40);
			BsignupSU.setFocusable(false);
			Psu.add(BsignupSU);
			BsignupSU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BsignupSU.setForeground(new Color(245,195,34));
					BsignupSU.setBorderPainted(false);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BsignupSU.setForeground(new Color(30, 39, 49));
					BsignupSU.setBorderPainted(true);
				}
			});
			
			IPpasswordSU = new JPasswordField();
			IPpasswordSU.setForeground(new Color(255, 255, 255));
			IPpasswordSU.setCaretColor(new Color(255, 255, 255));
			IPpasswordSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPpasswordSU.setBackground(new Color(30, 39, 49));
			IPpasswordSU.setBounds(86, 270, 275, 40);
			Psu.add(IPpasswordSU);
			
			IPpasswordSU2 = new JPasswordField();
			IPpasswordSU2.setForeground(new Color(255, 255, 255));
			IPpasswordSU2.setText("");
			IPpasswordSU2.setCaretColor(Color.WHITE);
			IPpasswordSU2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPpasswordSU2.setBackground(new Color(30, 39, 49));
			IPpasswordSU2.setBounds(86, 345, 275, 40);
			Psu.add(IPpasswordSU2);
			
			JLabel lblNewLabel = new JLabel("Already have an account ?");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
			lblNewLabel.setBounds(53, 530, 172, 21);
			Psu.add(lblNewLabel);
			
			 BloginSU = new JButton("Login");
			BloginSU.setBackground(new Color(30, 39, 49));
			BloginSU.setForeground(new Color(30, 39, 49));
			BloginSU.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 13));
			BloginSU.setBounds(225, 529, 75, 21);
			BloginSU.setFocusable(false);
			Psu.add(BloginSU);
			BloginSU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BloginSU.setForeground(new Color(245,195,34));
					BloginSU.setBorderPainted(false);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BloginSU.setForeground(new Color(30, 39, 49));
					BloginSU.setBorderPainted(true);
				}
			});
			
			IPfirstName = new JTextField();
			IPfirstName.setHorizontalAlignment(SwingConstants.CENTER);
			IPfirstName.setForeground(Color.WHITE);
			IPfirstName.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 15));
			IPfirstName.setColumns(10);
			IPfirstName.setCaretColor(Color.WHITE);
			IPfirstName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPfirstName.setBackground(new Color(30, 39, 49));
			IPfirstName.setBounds(85, 157, 125, 32);
			Psu.add(IPfirstName);
			IPfirstName.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					LBfirstName.setForeground(new Color(245,195,34));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					LBfirstName.setForeground(Color.WHITE);
				}
			});
			
			LBwarningSU = new JLabel("");
			LBwarningSU.setHorizontalAlignment(SwingConstants.CENTER);
			LBwarningSU.setForeground(new Color(236, 15, 20));
			LBwarningSU.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
			LBwarningSU.setBounds(31, 403, 387, 21);
			Psu.add(LBwarningSU);
			
			LBfirstName = new JLabel("First Name");
			LBfirstName.setHorizontalAlignment(SwingConstants.CENTER);
			LBfirstName.setForeground(Color.WHITE);
			LBfirstName.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
			LBfirstName.setBounds(101, 141, 87, 21);
			Psu.add(LBfirstName);
			
			 LBlastName = new JLabel("Last Name");
			LBlastName.setHorizontalAlignment(SwingConstants.CENTER);
			LBlastName.setForeground(Color.WHITE);
			LBlastName.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
			LBlastName.setBounds(247, 141, 87, 21);
			Psu.add(LBlastName);
			
			IPlastName = new JTextField();
			IPlastName.setHorizontalAlignment(SwingConstants.CENTER);
			IPlastName.setForeground(Color.WHITE);
			IPlastName.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 15));
			IPlastName.setColumns(10);
			IPlastName.setCaretColor(Color.WHITE);
			IPlastName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			IPlastName.setBackground(new Color(30, 39, 49));
			IPlastName.setBounds(231, 157, 125, 32);
			Psu.add(IPlastName);
			IPlastName.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					LBlastName.setForeground(new Color(245,195,34));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					LBlastName.setForeground(Color.WHITE);
				}
			});
			
			

		}
		
		




		public void setLBwarning_login(JLabel lBwarning_login) {
			LBwarning_login = lBwarning_login;
		}

		public void setLBwarningSU(JLabel lBwarningSU) {
			LBwarningSU = lBwarningSU;
		}

		public JTextField getIPusername() {
			return IPusername;
		}
		public JPasswordField getIPpassword() {
			return IPpassword;
		}
		public JTextField getIPuserSU() {
			return IPuserSU;
		}
		public JPasswordField getIPpasswordSU() {
			return IPpasswordSU;
		}
		public JPasswordField getIPpasswordSU2() {
			return IPpasswordSU2;
		}
		public JTextField getIPfirstName() {
			return IPfirstName;
		}
		public JButton getBlogin() {
			return Blogin;
		}
		public JButton getBsignupSU() {
			return BsignupSU;
		}
		public JButton getBsignup() {
			return Bsignup;
		}
		public JPanel getPsignup() {
			return Psignup;
		}
		public JPanel getPlogin() {
			return Plogin;
		}
		public JPanel getCardPanel_login() {
			return CardPanel_login;
		}
		public JButton getBloginSU() {
			return BloginSU;
		}
		public JLabel getLBwarning_login() {
			return LBwarning_login;
		}
		public JLabel getLBwarningSU() {
			return LBwarningSU;
		}
		public JLabel getLBfirstName() {
			return LBfirstName;
		}
		public JTextField getIPlastName() {
			return IPlastName;
		}
		
	}
