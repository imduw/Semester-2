package client.view.ui;

import java.awt.EventQueue;
import javax.swing.text.*;

import client.controller.UserController;
import client.controller.ProductController;
import common.model.Product;

import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import client.view.renderers.CustomTableHeaderRenderer;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;



public class ShopUI extends JFrame {

	private static final long serialVersionUID = 1L;	
	private JPanel contentPane;
	private JScrollPane ListProduct;	
	private JTable Table_dasboard;
	private JTextField IPsearch_dashboard;
	private JScrollPane ListProductToInvoice;
	private JTable Table_invoice;
	private JScrollPane ListTable_product;
	private JTable Table_product;
	private JTextField IPsearch_product;
	private JTextField IPproduct;
	private JTextField IPprice;
	private JButton BdashboardForm;
	private JButton BhomeForm;
	private JButton BproductForm;
	private JButton BsalesOrder;
	private JPanel CardPanel;
	private JPanel DashboardPanel;
	private JPanel ProductPanel;
	private JPanel SettingPanel;
	private JPanel HomePanel;
	private JButton Bpayment;
	private JButton Badd;
	private JButton Bdelete;
	private JButton Bupdate;
	private JButton Bsignout;
	private ButtonGroup group_category;
	private ButtonGroup group_status;
	private JRadioButton RBavailable;
	private JRadioButton RBdrink;
	private JRadioButton RBfood;
	private JRadioButton RBnotAvailable;
	private JLabel LBwarning;
	private JLabel LBnotificate;
	private JButton Brefresh;
	private JTextField IPquantity;
	private JButton Badd_invoice;
	private JButton Brefresh_invoice;
	private JLabel LBshowProduct;
	private JLabel LBshowPrice;
	private JLabel LBwarning_dashboard;
	private JLabel LBtotal;
	private JButton Bremove_invoice;
	private JPanel SalesOrderPanel;
	private JScrollPane ListTable_order;
	private JTable Table_order;
	private JLabel LBnameuser;
	private JTextField IPreceive;
	private JLabel LBrefund;
	private JTextField IPsearch_order;
	private JTextField IPday;
	private JLabel LBmonth;
	private JTextField IPmonth;
	private JLabel LByear;
	private JTextField IPyear;
	private JLabel LBnotificate_order;
	private JButton Bsearch_order;
	private JButton BrefreshOrder;
	private JLabel LBbanner_home;
	private JLabel LBwarning_invoice;
	private JLabel LBidProduct;
	private JLabel LBnameshop;
	private JLabel LBproduct;
	private JLabel LBprice;
	private JLabel LBcategory;
	private JLabel LBstatus;
	private JLabel LBday;
	private JLabel LBusername;
	private JButton Byes;
	private JButton Bno;
	




	public ShopUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(17, 236, 231));
		contentPane.setBorder(new LineBorder(new Color(17, 236, 231), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(32, 36, 38));
		MenuPanel.setBounds(0, 0, 235, 782);
		contentPane.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel LBlogo = new JLabel("");
		LBlogo.setBounds(12, 12, 45, 37);
		MenuPanel.add(LBlogo);
		LBlogo.setHorizontalAlignment(SwingConstants.CENTER);
		LBlogo.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/logo.png"))));
		
		 LBnameshop = new JLabel("Shop Manager");
		 LBnameshop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBnameshop.setForeground(new Color(28,233,255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBnameshop.setForeground(new Color(245, 245, 245));
				
			}
		});
		LBnameshop.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 21));
		LBnameshop.setForeground(new Color(245, 245, 245));
		LBnameshop.setBounds(62, 22, 168, 30);
		MenuPanel.add(LBnameshop);
		
		BhomeForm = new JButton("   Home");
		BhomeForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BhomeForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BhomeForm.setBackground(new Color(20, 23, 24)); 
            	BhomeForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BhomeForm.setBackground(new Color(32, 36, 38));
            	BhomeForm.setForeground(new Color(195, 195, 195));
            }
        });

		BhomeForm.setFocusable(false);
		BhomeForm.setMargin(new Insets(2, 20, 0, 14));
		BhomeForm.setForeground(new Color(195, 195, 195));
		BhomeForm.setBorderPainted(false);
		BhomeForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BhomeForm.setHorizontalAlignment(SwingConstants.LEADING);
		BhomeForm.setBackground(new Color(32, 36, 38));
		BhomeForm.setBounds(0, 133, 233, 45);
		BhomeForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/home1.png"))));
		MenuPanel.add(BhomeForm);
		
		BdashboardForm = new JButton("    Dashboard");
		BdashboardForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BdashboardForm.setBackground(new Color(20, 23, 24));
            	BdashboardForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BdashboardForm.setBackground(new Color(32, 36, 38));
            	BdashboardForm.setForeground(new Color(195, 195, 195));
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
        });
		BdashboardForm.setMargin(new Insets(2, 14, 0, 14));
		BdashboardForm.setFocusable(false);
		BdashboardForm.setHorizontalAlignment(SwingConstants.LEADING);
		BdashboardForm.setForeground(new Color(195, 195, 195));
		BdashboardForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BdashboardForm.setBorderPainted(false);
		BdashboardForm.setBackground(new Color(32, 36, 38));
		BdashboardForm.setBounds(7, 190, 227, 45);
		BdashboardForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/product.png"))));
		MenuPanel.add(BdashboardForm);
		
		BsalesOrder = new JButton("   Sales Order");
		BsalesOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BsalesOrder.setBackground(new Color(20, 23, 24));  
            	BsalesOrder.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BsalesOrder.setBackground(new Color(32, 36, 38));
            	BsalesOrder.setForeground(new Color(195, 195, 195));
            }
        });
		BsalesOrder.setFocusable(false);
		BsalesOrder.setMargin(new Insets(2, 14, 0, 14));
		BsalesOrder.setHorizontalAlignment(SwingConstants.LEADING);
		BsalesOrder.setForeground(new Color(195, 195, 195));
		BsalesOrder.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BsalesOrder.setBorderPainted(false);
		BsalesOrder.setBackground(new Color(32, 36, 38));
		BsalesOrder.setBounds(4, 305, 230, 45);
		BsalesOrder.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/invoice.png"))));
		MenuPanel.add(BsalesOrder);
		
		BproductForm = new JButton("  Product");
		BproductForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BproductForm.setBackground(new Color(20, 23, 24)); 
            	BproductForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BproductForm.setBackground(new Color(32, 36, 38));
            	BproductForm.setForeground(new Color(195, 195, 195));
            }
        });
		BproductForm.setMargin(new Insets(2, 14, 0, 14));
		BproductForm.setHorizontalAlignment(SwingConstants.LEADING);
		BproductForm.setForeground(new Color(195, 195, 195));
		BproductForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BproductForm.setFocusable(false);
		BproductForm.setBorderPainted(false);
		BproductForm.setBackground(new Color(32, 36, 38));
		BproductForm.setBounds(3, 246, 230, 45);
		BproductForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/product-management.png"))));
		MenuPanel.add(BproductForm);
		
		Bsignout = new JButton("");
		Bsignout.setMargin(new Insets(2, 2, 2, 2));
		Bsignout.setForeground(new Color(195, 195, 195));
		Bsignout.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		Bsignout.setHorizontalAlignment(SwingConstants.LEFT);
		Bsignout.setFocusable(false);
		Bsignout.setBorderPainted(false);
		Bsignout.setBackground(new Color(32, 36, 38));
		Bsignout.setBounds(10, 704, 57, 47);
		Bsignout.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/exit.png"))));
		MenuPanel.add(Bsignout);
		
		Byes = new JButton("Yes");
		Byes.setAlignmentY(0.0f);
		Byes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Byes.setForeground(new Color(28,233,255));
				Byes.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Byes.setForeground(new Color(32, 36, 34));
				Byes.setBorderPainted(true);
			}
		});
		Byes.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(28, 32, 34)));
		Byes.setMargin(new Insets(0, 0, 0, 0));
		Byes.setFocusable(false);
		Byes.setForeground(new Color(28, 32, 34));
		Byes.setBackground(new Color(32, 36, 38));
		Byes.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Byes.setBounds(17, 716, 100, 30);
		Byes.setVisible(false);
		MenuPanel.add(Byes);
		
		Bno = new JButton("No");
		Bno.setAlignmentY(0.0f);
		Bno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bno.setForeground(new Color(28,233,255));
				Bno.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bno.setForeground(new Color(32, 36, 34));
				Bno.setBorderPainted(true);
			}
		});
		Bno.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(28, 32, 34)));
		Bno.setMargin(new Insets(0, 0, 0, 0));
		Bno.setFocusable(false);
		Bno.setForeground(new Color(28, 32, 34));
		Bno.setBackground(new Color(32, 36, 38));
		Bno.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bno.setBounds(120, 716, 100, 30);
		Bno.setVisible(false);
		MenuPanel.add(Bno);
		
		
		 LBusername = new JLabel("admin");
		 LBusername.setBounds(64, 47, 130, 22);
		 MenuPanel.add(LBusername);
		 LBusername.setHorizontalAlignment(SwingConstants.LEFT);
		 LBusername.setForeground(new Color(245, 245, 245));
		 LBusername.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 13));
		 LBusername.setBackground(new Color(238, 240, 240));
		
		CardPanel = new JPanel();
		CardPanel.setBackground(new Color(20, 23, 24));
		CardPanel.setBounds(233, 0, 1101, 798);
		contentPane.add(CardPanel);
		CardPanel.setLayout(new CardLayout(0, 0));
		
		DashboardPanel = new JPanel();
		DashboardPanel.setBorder(null);
		DashboardPanel.setBounds(233, 54, 1101, 657);
		DashboardPanel.setBackground(new Color(20, 23, 24));
		DashboardPanel.setLayout(null);
		
		//------------------------------------------Table ở Dashboard------------------------------------------------------------------------------------//
		
		ListProduct = new JScrollPane();
		ListProduct.getVerticalScrollBar().setBackground(new Color(20,23,24));
		ListProduct.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListProduct.setBackground(new Color(20, 23, 24));
		ListProduct.setBounds(52, 130, 573, 479);
		DashboardPanel.add(ListProduct);
		
		Table_dasboard = new JTable();
		Table_dasboard.setBorder(new LineBorder(new Color(32, 36, 38), 1, true));
		Table_dasboard.setFocusable(false);
		Table_dasboard.setRowMargin(0);
		Table_dasboard.setGridColor(new Color(128, 128, 128));
		Table_dasboard.setSelectionForeground(new Color(48, 200, 200));
		Table_dasboard.setForeground(new Color(255, 255, 255));
		Table_dasboard.setBackground(new Color(128, 128, 128));
		Table_dasboard.setSelectionBackground(new Color(40, 40, 40));
		Table_dasboard.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_dasboard.setRowHeight(50);
		Table_dasboard.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product", "Category", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_dasboard.getColumnModel().getColumn(0).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(0).setPreferredWidth(37);
		Table_dasboard.getColumnModel().getColumn(1).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(1).setPreferredWidth(128);
		Table_dasboard.getColumnModel().getColumn(2).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(2).setPreferredWidth(64);
		Table_dasboard.getColumnModel().getColumn(3).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(3).setPreferredWidth(112);
		ListProduct.setViewportView(Table_dasboard);
		
		JTableHeader header_product = Table_dasboard.getTableHeader();		
		header_product.setResizingAllowed(false);		
		header_product.setReorderingAllowed(false);
		header_product.setDefaultRenderer(new client.view.renderers.CustomTableHeaderRenderer());
		JViewport viewport = ListProduct.getViewport();
		viewport.setBackground(new Color(20, 23, 24));
		Table_dasboard.setDefaultRenderer(Object.class, new client.view.renderers.CustomTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		//------------------------------------------------------------------------------------------------------------------------------//
		
		JPanel invPanel = new JPanel();
		invPanel.setBackground(new Color(20, 23, 24));
		invPanel.setBounds(724, 0, 377, 824);
		DashboardPanel.add(invPanel);
		invPanel.setLayout(null);
		
		//-------------------------------------------Table-Invoice-----------------------------------------------------------------------------//
		
		ListProductToInvoice = new JScrollPane();
		ListProductToInvoice.setBorder(new LineBorder(new Color(32, 36, 38), 6, true));
		ListProductToInvoice.setBackground(new Color(28, 32, 34));
		ListProductToInvoice.setBounds(10,127, 333, 400); 
		
		Table_invoice = new JTable();
		Table_invoice.setFocusable(false);
		Table_invoice.setRowMargin(0);
		Table_invoice.setGridColor(new Color(128, 128, 128));
		Table_invoice.setSelectionForeground(new Color(48, 200, 200));
		Table_invoice.setForeground(new Color(255, 255, 255));
		Table_invoice.setBackground(new Color(128, 128, 128));
		Table_invoice.setSelectionBackground(new Color(40, 40, 40));
		Table_invoice.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_invoice.setRowHeight(50);
		Table_invoice.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_invoice.getColumnModel().getColumn(0).setResizable(false);
		Table_invoice.getColumnModel().getColumn(0).setPreferredWidth(89);
		Table_invoice.getColumnModel().getColumn(1).setResizable(false);
		Table_invoice.getColumnModel().getColumn(1).setPreferredWidth(52);
		Table_invoice.getColumnModel().getColumn(2).setResizable(false);
		ListProductToInvoice.setViewportView(Table_invoice);
		
		JTableHeader header_invoice = Table_invoice.getTableHeader();		
		header_invoice.setResizingAllowed(false);		
		header_invoice.setReorderingAllowed(false);
		header_invoice.setDefaultRenderer(new client.view.renderers.CustomTableHeaderRenderer());
		JViewport viewport1 = ListProductToInvoice.getViewport();
		viewport1.setBackground(new Color(20, 23, 24));
		Table_invoice.setDefaultRenderer(Object.class, new client.view.renderers.CustomTableCellRenderer());
		ListProductToInvoice.setBounds(10, 127, 360, 400);
		invPanel.add(ListProductToInvoice);
		
		//----------------------------------------------------------------------------------------------------------------//
		
		JLabel LBtotaltext = new JLabel("Total :");
		LBtotaltext.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext.setForeground(new Color(245, 245, 245));
		LBtotaltext.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		LBtotaltext.setBackground(new Color(238, 240, 240));
		LBtotaltext.setBounds(51, 561, 76, 28);
		invPanel.add(LBtotaltext);
		
		 LBtotal = new JLabel("");
		LBtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		LBtotal.setForeground(new Color(245, 245, 245));
		LBtotal.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		LBtotal.setBackground(new Color(238, 240, 240));
		LBtotal.setBounds(139, 563, 144, 28);
		invPanel.add(LBtotal);
		
		JLabel lblVnd = new JLabel("vnd");
		lblVnd.setHorizontalAlignment(SwingConstants.LEFT);
		lblVnd.setForeground(new Color(245, 245, 245));
		lblVnd.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblVnd.setBackground(new Color(238, 240, 240));
		lblVnd.setBounds(293, 569, 32, 16);
		invPanel.add(lblVnd);
		
		Bpayment = new JButton("Payment");
		Bpayment.setAlignmentY(0.0f);
		Bpayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bpayment.setForeground(new Color(28,233,255));
				Bpayment.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bpayment.setForeground(new Color(28, 32, 34));
				Bpayment.setBorderPainted(true);
			}
		});
		Bpayment.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(28, 32, 34)));
		Bpayment.setMargin(new Insets(0, 0, 0, 0));
		Bpayment.setFocusable(false);
		Bpayment.setForeground(new Color(28, 32, 34));
		Bpayment.setBackground(new Color(20, 23, 24));
		Bpayment.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 21));
		Bpayment.setBounds(53, 690, 274, 44);
		invPanel.add(Bpayment);
		
		JLabel LBtotaltext_1 = new JLabel("INVOICE");
		LBtotaltext_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_1.setBounds(145, 27, 110, 32);
		invPanel.add(LBtotaltext_1);
		
		JLabel LBtotaltext_2 = new JLabel("Receive :");
		LBtotaltext_2.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_2.setForeground(new Color(245, 245, 245));
		LBtotaltext_2.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		LBtotaltext_2.setBackground(new Color(238, 240, 240));
		LBtotaltext_2.setBounds(27, 631, 81, 28);
		invPanel.add(LBtotaltext_2);
		
		JLabel lblVnd_1 = new JLabel("vnd");
		lblVnd_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblVnd_1.setForeground(new Color(245, 245, 245));
		lblVnd_1.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblVnd_1.setBackground(new Color(238, 240, 240));
		lblVnd_1.setBounds(291, 635, 32, 16);
		invPanel.add(lblVnd_1);
		
		IPreceive = new JTextField();
		IPreceive.setHorizontalAlignment(SwingConstants.RIGHT);
		IPreceive.setForeground(new Color(245, 245, 245));
		IPreceive.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		IPreceive.setColumns(10);
		IPreceive.setCaretColor(Color.WHITE);
		IPreceive.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPreceive.setBackground(new Color(20, 23, 24));
		IPreceive.setBounds(113, 635, 172, 23);
		invPanel.add(IPreceive);
		
		JLabel LBtotaltext_2_1 = new JLabel("Refund :");
		LBtotaltext_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_2_1.setForeground(new Color(245, 245, 245));
		LBtotaltext_2_1.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		LBtotaltext_2_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_2_1.setBounds(32, 596, 81, 28);
		invPanel.add(LBtotaltext_2_1);
		
		JLabel lblVnd_1_1 = new JLabel("vnd");
		lblVnd_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblVnd_1_1.setForeground(new Color(245, 245, 245));
		lblVnd_1_1.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblVnd_1_1.setBackground(new Color(238, 240, 240));
		lblVnd_1_1.setBounds(292, 604, 32, 16);
		invPanel.add(lblVnd_1_1);
		
		 LBrefund = new JLabel("");
		LBrefund.setHorizontalAlignment(SwingConstants.RIGHT);
		LBrefund.setForeground(new Color(245, 245, 245));
		LBrefund.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		LBrefund.setBackground(new Color(238, 240, 240));
		LBrefund.setBounds(138, 596, 144, 28);
		invPanel.add(LBrefund);
		
		LBwarning_invoice = new JLabel("");
		LBwarning_invoice.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarning_invoice.setForeground(new Color(220, 14, 19));
		LBwarning_invoice.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBwarning_invoice.setBackground(new Color(236, 15, 20));
		LBwarning_invoice.setBounds(21, 86, 344, 30);
		invPanel.add(LBwarning_invoice);
		
		//-----------------------------------------------------------------------------------------------------------------------//
		
		IPsearch_dashboard = new JTextField();
		IPsearch_dashboard.setCaretColor(new Color(240, 240, 240));
		IPsearch_dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch_dashboard.setText("");
				IPsearch_dashboard.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch_dashboard.setText("Search");
				IPsearch_dashboard.setCaretPosition(0);
				IPsearch_dashboard.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch_dashboard.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch_dashboard.setForeground(new Color(240, 240, 240));
		IPsearch_dashboard.setText("Search");
		IPsearch_dashboard.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch_dashboard.setBackground(new Color(20, 23, 24));
		IPsearch_dashboard.setBounds(161, 55, 381, 40);
		IPsearch_dashboard.setCaretColor(new Color(20,23,24));
		DashboardPanel.add(IPsearch_dashboard);
		IPsearch_dashboard.setColumns(10);
		
		ProductPanel = new JPanel();
		ProductPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(ProductPanel, "name_18041534092000");
		ProductPanel.setLayout(null);
		//------------------------------------Table ở ProductPanel------------------------------------------------------------------------------------------//
		ListTable_product = new JScrollPane();		
		ListTable_product.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListTable_product.setBackground(new Color(20, 23, 24));
		ListTable_product.setBounds(55, 130, 682, 606);
		ProductPanel.add(ListTable_product);
		
		Table_product = new JTable();
		Table_product.setFocusable(false);
		Table_product.setRowMargin(0);
		Table_product.setGridColor(new Color(128, 128, 128));
		Table_product.setSelectionForeground(new Color(50, 210, 210));
		Table_product.setForeground(new Color(255, 255, 255));
		Table_product.setBackground(new Color(128, 128, 128));
		Table_product.setSelectionBackground(new Color(40, 40, 40));
		Table_product.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_product.setRowHeight(50);
		Table_product.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product", "Category", "Price", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_product.getColumnModel().getColumn(0).setResizable(false);
		Table_product.getColumnModel().getColumn(0).setPreferredWidth(32);
		Table_product.getColumnModel().getColumn(1).setResizable(false);
		Table_product.getColumnModel().getColumn(2).setResizable(false);
		Table_product.getColumnModel().getColumn(2).setPreferredWidth(55);
		Table_product.getColumnModel().getColumn(3).setResizable(false);
		Table_product.getColumnModel().getColumn(3).setPreferredWidth(59);
		Table_product.getColumnModel().getColumn(4).setResizable(false);
		Table_product.getColumnModel().getColumn(4).setPreferredWidth(60);
		ListTable_product.setViewportView(Table_product);
		
		JTableHeader header_product_1 = Table_product.getTableHeader();		
		header_product_1.setResizingAllowed(false);		
		header_product_1.setReorderingAllowed(false);
		header_product_1.setDefaultRenderer(new client.view.renderers.CustomTableHeaderRenderer());
		JViewport viewport_1 = ListTable_product.getViewport();
		viewport_1.setBackground(new Color(20, 23, 24));
		Table_product.setDefaultRenderer(Object.class, new client.view.renderers.CustomTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------//
		
		IPsearch_product = new JTextField();
		IPsearch_product.setCaretColor(new Color(240, 240, 240));
		IPsearch_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch_product.setText("");
				IPsearch_product.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch_product.setText("Search");
				IPsearch_product.setCaretPosition(0);
				IPsearch_product.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch_product.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch_product.setForeground(new Color(240, 240, 240));
		IPsearch_product.setText("Search");
		IPsearch_product.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch_product.setBackground(new Color(20, 23, 24));
		IPsearch_product.setBounds(190, 56, 381, 40);
		IPsearch_product.setCaretColor(new Color(20,23,24));
		ProductPanel.add(IPsearch_product);
		IPsearch_product.setColumns(10);
		
		IPproduct = new JTextField();
		IPproduct.setCaretColor(new Color(255, 255, 255));
		
		IPproduct.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPproduct.setForeground(new Color(245, 245, 245));
		IPproduct.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPproduct.setBackground(new Color(20, 23, 24));
		IPproduct.setBounds(875, 186, 187, 24);
		ProductPanel.add(IPproduct);
		IPproduct.setColumns(10);
		
		 LBproduct = new JLabel("Product -");
		LBproduct.setHorizontalAlignment(SwingConstants.RIGHT);
		LBproduct.setForeground(new Color(245, 245, 245));
		LBproduct.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBproduct.setBounds(784, 181, 81, 30);
		ProductPanel.add(LBproduct);
		//----------------------------------------------------------------------------//
		
		IPproduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBproduct.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBproduct.setForeground(new Color(245, 245, 245));
			}
		});
		
		
		//----------------------------------------------------------------------------//
		 LBcategory = new JLabel("Category -");
		LBcategory.setHorizontalAlignment(SwingConstants.RIGHT);
		LBcategory.setForeground(new Color(245, 245, 245));
		LBcategory.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBcategory.setBounds(776, 297, 92, 30);
		ProductPanel.add(LBcategory);
		
		 LBprice = new JLabel("Price -");
		LBprice.setHorizontalAlignment(SwingConstants.RIGHT);
		LBprice.setForeground(new Color(245, 245, 245));
		LBprice.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBprice.setBounds(801, 234, 64, 30);
		ProductPanel.add(LBprice);
		
		
		
		 LBstatus = new JLabel("Status -");
		LBstatus.setHorizontalAlignment(SwingConstants.RIGHT);
		LBstatus.setForeground(new Color(245, 245, 245));
		LBstatus.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBstatus.setBounds(788, 398, 80, 30);
		ProductPanel.add(LBstatus);
		
		IPprice = new JTextField();
		IPprice.setCaretColor(new Color(255, 255, 255));
		IPprice.setForeground(new Color(245, 245, 245));
		IPprice.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPprice.setColumns(10);
		IPprice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPprice.setBackground(new Color(20, 23, 24));
		IPprice.setBounds(878, 239, 187, 24);
		ProductPanel.add(IPprice);
		
		//----------------------------------------------------------------------------//
		
		IPprice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBprice.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBprice.setForeground(new Color(245, 245, 245));
			}
		});
		
		
		//----------------------------------------------------------------------------//
		
		RBfood = new JRadioButton("  Food");
		RBfood.setFocusable(false);
		RBfood.setMargin(new Insets(2, 2, 0, 2));
		RBfood.setForeground(new Color(240, 240, 240));
		RBfood.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBfood.setBackground(new Color(20, 23, 24));
		RBfood.setBounds(888, 298, 174, 23);
		ProductPanel.add(RBfood);
		
		
		RBdrink = new JRadioButton("  Drink");
		RBdrink.setFocusable(false);
		RBdrink.setForeground(UIManager.getColor("Button.background"));
		RBdrink.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBdrink.setBackground(new Color(20, 23, 24));
		RBdrink.setBounds(888, 343, 174, 23);
		ProductPanel.add(RBdrink);
		
		group_category = new ButtonGroup();
		group_category.add(RBdrink);
		group_category.add(RBfood);
		
		
		
		RBavailable = new JRadioButton("  Available");
		RBavailable.setFocusable(false);
		RBavailable.setForeground(UIManager.getColor("Button.background"));
		RBavailable.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBavailable.setBackground(new Color(20, 23, 24));
		RBavailable.setBounds(887, 403, 174, 23);
		ProductPanel.add(RBavailable);
		
		
		RBnotAvailable = new JRadioButton("  Not available");
		RBnotAvailable.setFocusable(false);
		RBnotAvailable.setForeground(UIManager.getColor("Button.background"));
		RBnotAvailable.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBnotAvailable.setBackground(new Color(20, 23, 24));
		RBnotAvailable.setBounds(887, 439, 174, 23);
		ProductPanel.add(RBnotAvailable);
		
		JLabel LBtotaltext_1_1 = new JLabel("DASHBOARD");
		LBtotaltext_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1.setBackground(new Color(245, 195, 34));
		LBtotaltext_1_1.setBounds(275, 20, 154, 32);
		DashboardPanel.add(LBtotaltext_1_1);
		
		 LBshowProduct = new JLabel("");
		LBshowProduct.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(248, 248, 248)));
		LBshowProduct.setHorizontalAlignment(SwingConstants.CENTER);
		LBshowProduct.setForeground(new Color(248, 248, 248));
		LBshowProduct.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		LBshowProduct.setBounds(115, 649, 140, 32);
		DashboardPanel.add(LBshowProduct);
		
		 LBshowPrice = new JLabel("");
		LBshowPrice.setHorizontalAlignment(SwingConstants.CENTER);
		LBshowPrice.setForeground(new Color(248, 248, 248));
		LBshowPrice.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		LBshowPrice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(248, 248, 248)));
		LBshowPrice.setBounds(274, 649, 116, 32);
		DashboardPanel.add(LBshowPrice);
		
		IPquantity = new JTextField();
		IPquantity.setHorizontalAlignment(SwingConstants.CENTER);
		IPquantity.setForeground(new Color(245, 245, 245));
		IPquantity.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPquantity.setColumns(10);
		IPquantity.setCaretColor(Color.WHITE);
		IPquantity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPquantity.setBackground(new Color(20, 23, 24));
		IPquantity.setBounds(573, 656, 59, 23);
		DashboardPanel.add(IPquantity);
		
		JLabel lblNewLabel = new JLabel("Enter a quantity :");
		lblNewLabel.setForeground(new Color(248, 248, 248));
		lblNewLabel.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblNewLabel.setBounds(443, 645, 128, 36);
		DashboardPanel.add(lblNewLabel);
		
		Badd_invoice = new JButton("");
		Badd_invoice.setBorderPainted(false);
		Badd_invoice.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(ShopUI.class.getResource("/image/plus.png"))));
		
		Badd_invoice.setMargin(new Insets(8, 14, 2, 14));
		Badd_invoice.setForeground(new Color(20, 23, 24));
		Badd_invoice.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 14));
		Badd_invoice.setFocusable(false);
		Badd_invoice.setBackground(new Color(20, 23, 24));
		Badd_invoice.setBounds(651, 201, 71, 67);
		DashboardPanel.add(Badd_invoice);
		
		Brefresh_invoice = new JButton("");
		
		Brefresh_invoice.setBorderPainted(false);
		Brefresh_invoice.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(ShopUI.class.getResource("/image/refresh.png"))));
		
		Brefresh_invoice.setMargin(new Insets(8, 14, 2, 14));
		Brefresh_invoice.setForeground(new Color(20, 23, 24));
		Brefresh_invoice.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 14));
		Brefresh_invoice.setFocusable(false);
		Brefresh_invoice.setBackground(new Color(20, 23, 24));
		Brefresh_invoice.setBounds(652, 284, 67, 66);
		DashboardPanel.add(Brefresh_invoice);
		
		 LBwarning_dashboard = new JLabel("");
		LBwarning_dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarning_dashboard.setForeground(new Color(220, 14, 19));
		LBwarning_dashboard.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBwarning_dashboard.setBackground(new Color(236, 15, 20));
		LBwarning_dashboard.setBounds(158, 615, 344, 30);
		DashboardPanel.add(LBwarning_dashboard);
		
		 Bremove_invoice = new JButton("");
		 Bremove_invoice.setBorderPainted(false);
		 Bremove_invoice.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(ShopUI.class.getResource("/image/delete.png"))));
		
		Bremove_invoice.setMargin(new Insets(8, 14, 2, 14));
		Bremove_invoice.setForeground(new Color(20, 23, 24));
		Bremove_invoice.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 14));
		Bremove_invoice.setFocusable(false);
		Bremove_invoice.setBackground(new Color(20, 23, 24));
		Bremove_invoice.setBounds(653, 366, 67, 63);
		DashboardPanel.add(Bremove_invoice);
		
		group_status = new ButtonGroup();
		group_status.add(RBavailable);
		group_status.add(RBnotAvailable);
		
		RBdrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBcategory.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBcategory.setForeground(new Color(245, 245, 245));
			}
		});
		
		RBfood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBcategory.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBcategory.setForeground(new Color(245, 245, 245));
			}
		});
		
		RBavailable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBstatus.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBstatus.setForeground(new Color(245, 245, 245));
			}
		});
		
		RBnotAvailable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBstatus.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBstatus.setForeground(new Color(245, 245, 245));
			}
		});
		
		Badd = new JButton("Add");
		Badd.setFocusable(false);
		Badd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Badd.setForeground(new Color(28,233,255));
				Badd.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Badd.setForeground(new Color(20, 23, 24));
				Badd.setBorderPainted(true);
			}
		});
		Badd.setMargin(new Insets(8, 14, 2, 14));
		Badd.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Badd.setForeground(new Color(20, 23, 24));
		Badd.setBackground(new Color(20, 23, 24));
		Badd.setBounds(759, 519, 101, 30);
		ProductPanel.add(Badd);
		
		Bdelete = new JButton("Delele");
		Bdelete.setFocusable(false);
		Bdelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bdelete.setForeground(new Color(28,233,255));
				Bdelete.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bdelete.setForeground(new Color(20, 23, 24));
				Bdelete.setBorderPainted(true);
			}
		});
		Bdelete.setMargin(new Insets(8, 14, 2, 14));
		Bdelete.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bdelete.setForeground(new Color(20, 23, 24));
		Bdelete.setBackground(new Color(20, 23, 24));
		Bdelete.setBounds(875, 519, 105, 30);
		ProductPanel.add(Bdelete);
		
		Bupdate = new JButton("Update");
		Bupdate.setFocusable(false);
		Bupdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bupdate.setForeground(new Color(28,233,255));
				Bupdate.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bupdate.setForeground(new Color(20, 23, 24));
				Bupdate.setBorderPainted(true);
			}
		});
		Bupdate.setMargin(new Insets(8, 14, 2, 14));
		Bupdate.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bupdate.setForeground(new Color(20, 23, 24));
		Bupdate.setBackground(new Color(20, 23, 24));
		Bupdate.setBounds(990, 519, 101, 30);
		ProductPanel.add(Bupdate);
		
		JLabel LBtotaltext_1_1_1 = new JLabel("PRODUCT");
		LBtotaltext_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		LBtotaltext_1_1_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_1_1_1.setBounds(292, 13, 154, 32);
		ProductPanel.add(LBtotaltext_1_1_1);
		
		LBwarning = new JLabel("");
		LBwarning.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarning.setBackground(new Color(236, 15, 20));
		LBwarning.setForeground(new Color(220, 14, 19));
		LBwarning.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBwarning.setBounds(747, 597, 344, 30);
		ProductPanel.add(LBwarning);
		
		LBnotificate = new JLabel("");
		LBnotificate.setHorizontalAlignment(SwingConstants.CENTER);
		LBnotificate.setForeground(new Color(56, 185, 199));
		LBnotificate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBnotificate.setBackground(new Color(56, 185, 199));
		LBnotificate.setBounds(747, 630, 344, 30);
		ProductPanel.add(LBnotificate);
		
		Brefresh = new JButton("Refresh");
		Brefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Brefresh.setForeground(new Color(28,233,255));
				Brefresh.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Brefresh.setForeground(new Color(20, 23, 24));
				Brefresh.setBorderPainted(true);
			}
		});
		Brefresh.setMargin(new Insets(8, 14, 2, 14));
		Brefresh.setForeground(new Color(20, 23, 24));
		Brefresh.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Brefresh.setFocusable(false);
		Brefresh.setBackground(new Color(20, 23, 24));
		Brefresh.setBounds(875, 568, 105, 30);
		ProductPanel.add(Brefresh);
		
		JLabel lblId = new JLabel("*  ID -");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(new Color(245, 245, 245));
		lblId.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		lblId.setBounds(784, 130, 81, 30);
		ProductPanel.add(lblId);
		
		LBidProduct = new JLabel("");
		LBidProduct.setForeground(new Color(255, 255, 255));
		LBidProduct.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		LBidProduct.setBounds(875, 130, 187, 30);
		ProductPanel.add(LBidProduct);
		
		SettingPanel = new JPanel();
		SettingPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(SettingPanel, "name_25910368055600");
		SettingPanel.setLayout(null);
		
		JLabel LBtotaltext_1_1_2 = new JLabel("SETTING");
		LBtotaltext_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		LBtotaltext_1_1_2.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_2.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_2.setBackground(new Color(238, 240, 240));
		LBtotaltext_1_1_2.setBounds(298, 13, 154, 32);
		SettingPanel.add(LBtotaltext_1_1_2);
		
		HomePanel = new JPanel();
		HomePanel.setForeground(new Color(58, 197, 193));
		HomePanel.setBackground(new Color(5, 4, 5));
		CardPanel.add(HomePanel, "name_26379143641400");
		HomePanel.setLayout(null);
		
		LBnameuser = new JLabel("admin");
		LBnameuser.setHorizontalAlignment(SwingConstants.RIGHT);
		LBnameuser.setForeground(new Color(245, 245, 245));
		LBnameuser.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 13));
		LBnameuser.setBackground(new Color(238, 240, 240));
		LBnameuser.setBounds(869, 23, 179, 22);
		HomePanel.add(LBnameuser);
		
		LBbanner_home = new JLabel("");
		LBbanner_home.setBounds(-26, 56, 1127, 706);
		HomePanel.add(LBbanner_home);
		LBbanner_home.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(ShopUI.class.getResource("/image/banner_home.png"))));
		
		JLabel LBlogoclient = new JLabel("");
		LBlogoclient.setBounds(1058, 15, 32, 36);
		HomePanel.add(LBlogoclient);
		LBlogoclient.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginUI.class.getResource("/image/unknown.png"))));
		
		SalesOrderPanel = new JPanel();
		SalesOrderPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(SalesOrderPanel, "name_1678656511700");
		SalesOrderPanel.setLayout(null);
		
		JLabel LBtotaltext_1_1_3 = new JLabel("SALES ORDER");
		LBtotaltext_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1_1_3.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_3.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_3.setBackground(new Color(245, 195, 34));
		LBtotaltext_1_1_3.setBounds(316, 23, 169, 32);
		SalesOrderPanel.add(LBtotaltext_1_1_3);
		
		//---------------------------------------------------------------------------------------------//
		
		ListTable_order = new JScrollPane();		
		ListTable_order.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListTable_order.setBackground(new Color(20, 23, 24));
		ListTable_order.setBounds(55, 130, 702, 606);
		SalesOrderPanel.add(ListTable_order);
		
		Table_order = new JTable();
		Table_order.setFocusable(false);
		Table_order.setRowMargin(0);
		Table_order.setGridColor(new Color(128, 128, 128));
		Table_order.setSelectionForeground(new Color(50, 210, 210));
		Table_order.setForeground(new Color(255, 255, 255));
		Table_order.setBackground(new Color(128, 128, 128));
		Table_order.setSelectionBackground(new Color(40, 40, 40));
		Table_order.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_order.setRowHeight(50);
		Table_order.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Creator", "Total", "Time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_order.getColumnModel().getColumn(0).setResizable(false);
		Table_order.getColumnModel().getColumn(0).setPreferredWidth(32);
		Table_order.getColumnModel().getColumn(1).setResizable(false);
		Table_order.getColumnModel().getColumn(2).setResizable(false);
		Table_order.getColumnModel().getColumn(2).setPreferredWidth(55);
		Table_order.getColumnModel().getColumn(3).setResizable(false);
		Table_order.getColumnModel().getColumn(3).setPreferredWidth(59);
		ListTable_order.setViewportView(Table_order);
		
		JTableHeader header_order_1 = Table_order.getTableHeader();		
		header_order_1.setResizingAllowed(false);		
		header_order_1.setReorderingAllowed(false);
		header_order_1.setDefaultRenderer(new client.view.renderers.CustomTableHeaderRenderer());
		JViewport viewport_order = ListTable_order.getViewport();
		viewport_order.setBackground(new Color(20, 23, 24));
		Table_order.setDefaultRenderer(Object.class, new client.view.renderers.CustomTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		IPsearch_order = new JTextField();
		IPsearch_order.setCaretColor(new Color(240, 240, 240));
		IPsearch_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch_order.setText("");
				IPsearch_order.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch_order.setText("Search");
				IPsearch_order.setCaretPosition(0);
				IPsearch_order.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch_order.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch_order.setForeground(new Color(240, 240, 240));
		IPsearch_order.setText("Search");
		IPsearch_order.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch_order.setBackground(new Color(20, 23, 24));
		IPsearch_order.setBounds(206, 68, 381, 40);
		IPsearch_order.setCaretColor(new Color(20,23,24));
		
		SalesOrderPanel.add(IPsearch_order);
		
		 LBday = new JLabel("Day");
		LBday.setHorizontalAlignment(SwingConstants.CENTER);
		LBday.setForeground(new Color(245, 245, 245));
		LBday.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 14));
		LBday.setBounds(811, 183, 48, 30);
		SalesOrderPanel.add(LBday);
		
		IPday = new JTextField();
		IPday.setHorizontalAlignment(SwingConstants.CENTER);
		IPday.setForeground(new Color(245, 245, 245));
		IPday.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPday.setColumns(10);
		IPday.setCaretColor(Color.WHITE);
		IPday.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPday.setBackground(new Color(20, 23, 24));
		IPday.setBounds(814, 212, 48, 24);
		SalesOrderPanel.add(IPday);
		IPday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBday.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBday.setForeground(new Color(245, 245, 245));
			}
		});
		
		Bsearch_order = new JButton("Search");
		Bsearch_order.setMargin(new Insets(8, 14, 2, 14));
		Bsearch_order.setForeground(new Color(20, 23, 24));
		Bsearch_order.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bsearch_order.setFocusable(false);
		Bsearch_order.setBackground(new Color(20, 23, 24));
		Bsearch_order.setBounds(814, 290, 101, 30);
		SalesOrderPanel.add(Bsearch_order);
		Bsearch_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bsearch_order.setForeground(new Color(28,233,255));
				Bsearch_order.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bsearch_order.setForeground(new Color(28, 32, 34));
				Bsearch_order.setBorderPainted(true);
			}
		});
		
		LBmonth = new JLabel("Month");
		LBmonth.setHorizontalAlignment(SwingConstants.CENTER);
		LBmonth.setForeground(new Color(245, 245, 245));
		LBmonth.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 14));
		LBmonth.setBounds(889, 183, 60, 30);
		SalesOrderPanel.add(LBmonth);
		
		IPmonth = new JTextField();
		IPmonth.setHorizontalAlignment(SwingConstants.CENTER);
		IPmonth.setForeground(new Color(245, 245, 245));
		IPmonth.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPmonth.setColumns(10);
		IPmonth.setCaretColor(Color.WHITE);
		IPmonth.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPmonth.setBackground(new Color(20, 23, 24));
		IPmonth.setBounds(892, 213, 59, 24);
		SalesOrderPanel.add(IPmonth);
		IPmonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBmonth.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBmonth.setForeground(new Color(245, 245, 245));
			}
		});
		
		LByear = new JLabel("Year");
		LByear.setHorizontalAlignment(SwingConstants.CENTER);
		LByear.setForeground(new Color(245, 245, 245));
		LByear.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 14));
		LByear.setBounds(980, 183, 48, 30);
		SalesOrderPanel.add(LByear);
		
		IPyear = new JTextField();
		IPyear.setHorizontalAlignment(SwingConstants.CENTER);
		IPyear.setForeground(new Color(245, 245, 245));
		IPyear.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPyear.setColumns(10);
		IPyear.setCaretColor(Color.WHITE);
		IPyear.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPyear.setBackground(new Color(20, 23, 24));
		IPyear.setBounds(980, 213, 55, 24);
		SalesOrderPanel.add(IPyear);
		IPyear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LByear.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LByear.setForeground(new Color(245, 245, 245));
			}
		});
		
		JLabel LBsince = new JLabel("SINCE");
		LBsince.setHorizontalAlignment(SwingConstants.CENTER);
		LBsince.setForeground(new Color(56, 185, 199));
		LBsince.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 23));
		LBsince.setBounds(881, 137, 81, 30);
		SalesOrderPanel.add(LBsince);
		
		LBnotificate_order = new JLabel("");
		LBnotificate_order.setHorizontalAlignment(SwingConstants.CENTER);
		LBnotificate_order.setForeground(new Color(56, 185, 199));
		LBnotificate_order.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBnotificate_order.setBackground(new Color(56, 185, 199));
		LBnotificate_order.setBounds(767, 350, 324, 30);
		SalesOrderPanel.add(LBnotificate_order);
		
		BrefreshOrder = new JButton("Refresh");
		BrefreshOrder.setMargin(new Insets(8, 14, 2, 14));
		BrefreshOrder.setForeground(new Color(20, 23, 24));
		BrefreshOrder.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		BrefreshOrder.setFocusable(false);
		BrefreshOrder.setBackground(new Color(20, 23, 24));
		BrefreshOrder.setBounds(935, 290, 110, 30);
		SalesOrderPanel.add(BrefreshOrder);
		BrefreshOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BrefreshOrder.setForeground(new Color(28,233,255));
				BrefreshOrder.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BrefreshOrder.setForeground(new Color(28, 32, 34));
				BrefreshOrder.setBorderPainted(true);
			}
		});
		
		//--------------------------------Add Listener-------------------------------------------//
		
	}	
	
	
	
	public JScrollPane getListProduct() {
		return ListProduct;
	}

	public JTable getTable_dasboard() {
		return Table_dasboard;
	}

	public JTextField getIPsearch_dashboard() {
		return IPsearch_dashboard;
	}

	public JScrollPane getListProductToInvoice() {
		return ListProductToInvoice;
	}

	public JTable getTable_invoice() {
		return Table_invoice;
	}

	public JScrollPane getListTable_product() {
		return ListTable_product;
	}

	public JTable getTable_product() {
		return Table_product;
	}

	public JTextField getIPsearch_product() {
		return IPsearch_product;
	}

	public JTextField getIPproduct() {
		return IPproduct;
	}

	public JTextField getIPprice() {
		return IPprice;
	}

	public JButton getBdashboardForm() {
		return BdashboardForm;
	}

	public JButton getBhomeForm() {
		return BhomeForm;
	}

	public JButton getBproductForm() {
		return BproductForm;
	}

	public JButton getBsalesOrder() {
		return BsalesOrder;
	}

	public JPanel getDashboardPanel() {
		return DashboardPanel;
	}

	public JPanel getProductPanel() {
		return ProductPanel;
	}

	public JPanel getSettingPanel() {
		return SettingPanel;
	}

	public JPanel getHomePanel() {
		return HomePanel;
	}

	public JButton getBpayment() {
		return Bpayment;
	}

	public JButton getBadd() {
		return Badd;
	}

	public JButton getBdelete() {
		return Bdelete;
	}

	public JButton getBupdate() {
		return Bupdate;
	}

	public JButton getBsignout() {
		return Bsignout;
	}

	
	public JPanel getCardPanel() {
		return CardPanel;
	}



	public ButtonGroup getGroup_category() {
		return group_category;
	}

	public ButtonGroup getGroup_status() {
		return group_status;
	}

	public JRadioButton getRBavailable() {
		return RBavailable;
	}

	public JRadioButton getRBdrink() {
		return RBdrink;
	}

	public JRadioButton getRBfood() {
		return RBfood;
	}

	public JRadioButton getRBnotAvailable() {
		return RBnotAvailable;
	}

	public JLabel getLBwarning() {
		return LBwarning;
	}

	public JLabel getLBnotificate() {
		return LBnotificate;
	}

	public JButton getBrefresh() {
		return Brefresh;
	}

	public JTextField getIPquantity() {
		return IPquantity;
	}

	public JButton getBadd_invoice() {
		return Badd_invoice;
	}

	public JButton getBrefresh_invoice() {
		return Brefresh_invoice;
	}

	public JLabel getLBshowProduct() {
		return LBshowProduct;
	}

	public JLabel getLBshowPrice() {
		return LBshowPrice;
	}

	public JLabel getLBwarning_dashboard() {
		return LBwarning_dashboard;
	}

	public JLabel getLBtotal() {
		return LBtotal;
	}

	public JButton getBremove_invoice() {
		return Bremove_invoice;
	}

	public JPanel getSalesOrderPanel() {
		return SalesOrderPanel;
	}

	public JScrollPane getListTable_order() {
		return ListTable_order;
	}

	public JTable getTable_order() {
		return Table_order;
	}

	public JLabel getLBnameuser() {
		return LBnameuser;
	}

	public JTextField getIPreceive() {
		return IPreceive;
	}

	public JLabel getLBrefund() {
		return LBrefund;
	}

	public JTextField getIPsearch_order() {
		return IPsearch_order;
	}

	public JTextField getIPday() {
		return IPday;
	}

	public JLabel getLBmonth() {
		return LBmonth;
	}

	public JTextField getIPmonth() {
		return IPmonth;
	}

	public JLabel getLByear() {
		return LByear;
	}

	public JTextField getIPyear() {
		return IPyear;
	}

	public JLabel getLBnotificate_order() {
		return LBnotificate_order;
	}

	public JButton getBsearch_order() {
		return Bsearch_order;
	}

	public JButton getBrefreshOrder() {
		return BrefreshOrder;
	}

	public JLabel getLBbanner_home() {
		return LBbanner_home;
	}

	public JLabel getLBwarning_invoice() {
		return LBwarning_invoice;
	}

	public JLabel getLBidProduct() {
		return LBidProduct;
	}
	public JLabel getLBusername() {
		return LBusername;
	}

	public JButton getByes() {
		return Byes;
	}

	public JButton getBno() {
		return Bno;
	}
}

