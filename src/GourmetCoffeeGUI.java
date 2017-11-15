package GourmetCoffee;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


import java.io.*;
import java.text.*;

/**
 * Gourmet Coffee System.
 *
 * @author iCarnegie
 * @version 1.1.0
 * @see Product
 * @see Coffee
 * @see CoffeeBrewer
 * @see Catalog
 * @see OrderItem
 * @see Order
 * @see Sales
 * @see CatalogLoader
 * @see FileCatalogLoader
 * @see DataFormatException
 * @see SalesFormatter
 * @see PlainTextSalesFormatter
 * @see HTMLSalesFormatter
 * @see XMLSalesFormatter
 * @see DataField
 */
/**
 * @author Andrew
 *
 */

public class GourmetCoffeeGUI extends JPanel {
	/*Language option*/
	public static boolean isEnglish = true; //if isEnglish is true, the language will be English. else the language will be Chinese

	/*Vip option*/
	public static boolean notVip = true; //if notVip is true, the catalog will load catalog.dat, else it will load VipCatalog.dat
	
	/* Standard error stream */
	static private PrintWriter  stdErr = new  PrintWriter(System.err, true);

	/* Window width in pixels */
	static private int WIDTH = 620;

	/* Window height in pixels */
	static private int HEIGHT = 530;

	/* Size of the catalog list cell in pixels */
	static private int CATALOG_CELL_SIZE = 50;

	/* Visible rows in catalog list */
	static private int CATALOG_LIST_ROWS = 14;

	/* Size of the order list cell in pixels */
	static private int ORDER_CELL_SIZE = 100;

	/* Visible rows in order list */
	static private int ORDER_LIST_ROWS = 6;

	/* Size quantity text field */
	static private int QUANTITY__TEXTFIELD_SIZE = 5;

	/* Size total text field */
	static private int TOTAL__TEXTFIELD_SIZE = 8;

	/* Rows in status text area rows */
	static private int STATUS_ROWS = 10;

	/* Rows in status text area cols */
	static private int STATUS_COLS = 40;

	private JCheckBox vipBox; //建立vip checkbox
	private JList catalogList;
	private JList orderList;
	private JButton addModifyButton;
	private JButton removeButton;
	private JButton registerSaleButton;
	private JButton displaySalesButton;
	private JButton saveSalesButton;  
	private JButton convertButton;  //add a convert Button to change language
	private JPanel productPanel;
	private JLabel quantityLabel;
	private JLabel totalLabel;
	private JTextField quantityTextField;
	private JTextField totalTextField;
	private JTextArea statusTextArea;
	private static JFrame frame = new JFrame("Gourmet Coffee");
	
	JPanel orderPanel = new JPanel(new BorderLayout());
	JPanel bottomPanel = new JPanel(new BorderLayout());
	JPanel catalogPanel = new JPanel();

	private JFileChooser  fileChooser;

	private Catalog catalog;
	private Order  currentOrder;
	private Sales  sales;
	private PlainTextSalesFormatter salesFormatter;
	private NumberFormat dollarFormatter;

	/**
	 * User Login Interface
	 * 
	 * @throws IOException
	 */
	public static void  main(String[]  args) throws IOException {
		//绘制登陆界面//绘制登陆界面
				String account[]= new String[2];
				
				JFrame enterFrame = new JFrame();
				// 取消frame默认的布局管理器
				enterFrame.setLayout(null);
				
				try {
				BufferedReader bufferReader = new BufferedReader(new FileReader("accountinformation.dat"));
				// 定义一个临时变量用于存储每个变量
				String content = null;
				int i=0;
				while((content = bufferReader.readLine()) != null) {
					account[i++] = content;
				}
				bufferReader.readLine();
				
				
				bufferReader.close();
				} catch(IOException exception) {
					System.out.println("Something wrong with I/O");
				}
				
				JLabel status = new JLabel("Wrong Password!");
				status.setSize(150, 50);
				status.setLocation(210, 60);
				
				JLabel userLabel = new JLabel("User:");
				userLabel.setSize(100,50);
				userLabel.setLocation(170, 90);
				
				JLabel passwordLabel = new JLabel("Password:");
				passwordLabel.setSize(100,50);
				passwordLabel.setLocation(140, 120);
				
				JTextField userField = new JTextField();
				userField.setSize(100,30);
				userField.setLocation(210, 100);
				
				JPasswordField passwordField = new JPasswordField(); //让密码的输入变得不可见
				passwordField.setSize(100,30);
				passwordField.setLocation(210, 130);
				
				JButton enterBotton = new JButton("Enter");
				enterBotton.setSize(80,30);
				enterBotton.setLocation(140, 170);
				
				JButton exitButton = new JButton("Exit");
				exitButton.setSize(80,30);
				exitButton.setLocation(230, 170);
				
				JButton enconvertButton = new JButton("Convertion");
				enconvertButton.setSize(100,30);
				enconvertButton.setLocation(400, 250);
				
				enterFrame.add(status);
				enterFrame.add(userLabel);
				enterFrame.add(userField);
				enterFrame.add(passwordLabel);
				enterFrame.add(passwordField);
				enterFrame.add(enterBotton);
				enterFrame.add(exitButton);
				enterFrame.add(enconvertButton);
				
				status.setVisible(false);
				
				//添加背景图片
				ImageIcon imageIcon = new ImageIcon("errorCoffee.jpg");
				JLabel jLabel = new JLabel(imageIcon);
				jLabel.setSize(500,300);
				jLabel.setLocation(0,0);
				enterFrame.add(jLabel);
				
				enterFrame.setBounds(100, 60, 500, 300);
				enterFrame.setVisible(true);
				enterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				enterFrame.setResizable(false);

				exitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				
				enterBotton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String b1 = userField.getText();
						char[] cs = passwordField.getPassword();
						String b2 = new String(cs);             //读取JPassword类型的密码时的方法
						if(b1.equals(account[0]) && b2.equals(account[1])){
		//密码正确进入选择界面	//密码正确进入选择界面	
							JFrame choiceFrame = new JFrame();
							//取消frame默认的布局管理器
							choiceFrame.setLayout(null);

							JButton enterinButton = new JButton("Enter the management interface");
							enterinButton.setSize(220,40);
							enterinButton.setLocation(130, 70);

							JButton changeButton = new JButton("Change the password");
							changeButton.setSize(220,40);
							changeButton.setLocation(130, 130);

							JButton chconvertButton = new JButton("Convertion");
							chconvertButton.setSize(100,30);
							chconvertButton.setLocation(400, 250);

							choiceFrame.add(changeButton);
							choiceFrame.add(enterinButton);
							choiceFrame.add(chconvertButton);

							//添加背景图片
							ImageIcon imageIcon = new ImageIcon("choiceCoffee.jpg");
							JLabel jLabel = new JLabel(imageIcon);
							jLabel.setSize(500,300);
							jLabel.setLocation(0,0);
							choiceFrame.add(jLabel);
							
							if(!isEnglish){
								enterinButton.setText("进 入 管 理 界 面");
								changeButton.setText("修 改 账 户 信 息");
								chconvertButton.setText("切换英文");
							}
							
							enterFrame.dispose();	//关闭登陆界面

							choiceFrame.setBounds(100, 60, 500, 300);
							choiceFrame.setVisible(true);
							choiceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							choiceFrame.setResizable(false);

							changeButton.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent exit) {
		 //修改密码界面				//修改密码界面						
									JFrame changeFrame = new JFrame();
									// 取消frame默认的布局管理器
									changeFrame.setLayout(null);
									
									JLabel status = new JLabel("Two Passwords are not same!");
									status.setSize(200, 50);
									status.setLocation(200, 60);
									
									JLabel status2 = new JLabel("The TextFields can not be empty!");
									status2.setSize(250, 50);
									status2.setLocation(200, 60);
									
									JLabel changeUserLabel = new JLabel("NewUser:");
									changeUserLabel.setSize(100,50);
									changeUserLabel.setLocation(140, 90);
									
									JLabel changePasswordLabel = new JLabel("NewPassword:");
									changePasswordLabel.setSize(100,50);
									changePasswordLabel.setLocation(110, 120);
									
									JLabel changePasswordLabel2 = new JLabel("InputPasswordAgain:");
									changePasswordLabel2.setSize(150, 50);
									changePasswordLabel2.setLocation(68, 150);
									
									JTextField changeUserField = new JTextField();
									changeUserField.setSize(160,30);
									changeUserField.setLocation(200, 100);
									
									JPasswordField changePasswordField = new JPasswordField();
									changePasswordField.setSize(160,30);
									changePasswordField.setLocation(200, 130);
									
									JPasswordField changePasswordField2 = new JPasswordField();
									changePasswordField2.setSize(160, 30);
									changePasswordField2.setLocation(200, 160);
									
									JButton changeEnterButton = new JButton("Change and Enter");
									changeEnterButton.setSize(150,30);
									changeEnterButton.setLocation(100, 200);
									
									JButton changeExitButton = new JButton("Change and Exit");
									changeExitButton.setSize(150,30);
									changeExitButton.setLocation(250, 200);
									
									JButton changeConvertButton = new JButton("Convertion");
									changeConvertButton.setSize(100,30);
									changeConvertButton.setLocation(400, 250);
									
									changeFrame.add(status);
									changeFrame.add(status2);
									changeFrame.add(changeUserLabel);
									changeFrame.add(changeUserField);
									changeFrame.add(changePasswordLabel);
									changeFrame.add(changePasswordLabel2);
									changeFrame.add(changePasswordField);
									changeFrame.add(changePasswordField2);
									changeFrame.add(changeEnterButton);
									changeFrame.add(changeExitButton);
									changeFrame.add(changeConvertButton);
									
									status.setVisible(false);
									status2.setVisible(false);
									
									// 添加背景图片
									ImageIcon imageIcon = new ImageIcon("changeCoffee.jpg");
									JLabel jLabel = new JLabel(imageIcon);
									jLabel.setSize(500,300);
									jLabel.setLocation(0,0);
									changeFrame.add(jLabel);
									
									if(!isEnglish){
										status.setText("两次输入的密码不一致！");
										status2.setText("用户名和密码不能为空！");
										changeUserLabel.setText("新用户名:");
										changePasswordLabel.setText("新密码:");
										changePasswordLabel.setLocation(150, 120);
										changePasswordLabel2.setText("请再次输入:");
										changePasswordLabel2.setLocation(120, 150);
										changeEnterButton.setText("修改并进入");
										changeEnterButton.setSize(120,30);
										changeEnterButton.setLocation(130, 200);
										changeExitButton.setText("修改并退出");
										changeExitButton.setSize(120,30);
										changeExitButton.setLocation(250, 200);
										changeConvertButton.setText("切换英文");
									}
									
									choiceFrame.dispose();		//关闭选择界面
									
									changeFrame.setBounds(100, 60, 500, 300);
									changeFrame.setVisible(true);
									changeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									changeFrame.setResizable(false);
									
									changeEnterButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											//写入新的账户数据信息
											String b1 = changeUserField.getText();
											System.out.println(b1);
											char[] cs1 = changePasswordField.getPassword();
											String b2 = new String(cs1); 
											char[] cs2 = changePasswordField2.getPassword();
											String b3 = new String(cs2);
											
											if(changePasswordField.getPassword().length == 0)
											{
												System.out.println(1);
											}
											
											if(changeUserField.getText().equals("")||(changePasswordField.getPassword().length==0)||(changePasswordField2.getPassword().length==0))
											{
												status2.setVisible(true);
												changeUserField.setText(null);
												changePasswordField.setText(null);
												changePasswordField2.setText(null);
											}
											else if(!(b2.equals(b3)))
												{
													status.setVisible(true);
													changeUserField.setText(null);
													changePasswordField.setText(null);
													changePasswordField2.setText(null);
												}
												else
												{
													System.out.println(b1);
													System.out.println(b2);
													
													try {
														BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("accountinformation.dat"));
														bufferWriter.write(b1);
														bufferWriter.append("\n");
														bufferWriter.write(b2);
														bufferWriter.close();
														} catch(IOException exception) {
															System.out.println("Something wrong with I/O");
														}
													//写入新的账户数据后进入管理界面
				//进入管理界面							//进入管理界面
													String filename = "";
													if (args.length != 1) {
														filename = "catalog.dat";
													} else {
														filename = args[0];
													}
													try {
														Catalog catalog =
																(new FileCatalogLoader()).loadCatalog(filename);
														frame.setContentPane(new GourmetCoffeeGUI());
														frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														frame.setSize(WIDTH, HEIGHT);
														frame.setResizable(true);
														frame.setVisible(true);
														
		
													} catch (FileNotFoundException fnfe) {
														stdErr.println("The file does not exist");
		
														System.exit(1);
		
													} catch (DataFormatException dfe) {
														stdErr.println("The file contains malformed data: "
														               + dfe.getMessage());
		
														System.exit(1);
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													changeFrame.dispose();		//关闭修改界面
				//管理界面下界							//管理界面下界
												}
											
										}
									});

									changeExitButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											//写入新的账户数据信息
											String b1 = changeUserField.getText();
											char[] cs1 = changePasswordField.getPassword();
											String b2 = new String(cs1); 
											char[] cs2 = changePasswordField2.getPassword();
											String b3 = new String(cs2);
											
											if(changeUserField.getText().equals("")||(changePasswordField.getPassword().length==0)||(changePasswordField2.getPassword().length==0))
											{
												status2.setVisible(true);
												changeUserField.setText(null);
												changePasswordField.setText(null);
												changePasswordField2.setText(null);
											}
											else if(!(b2.equals(b3)))
												{
													status.setVisible(true);
													changeUserField.setText(null);
													changePasswordField.setText(null);
													changePasswordField2.setText(null);
												}
												else
												{
													System.out.println(b1);
													System.out.println(b2);
													
													try {
														BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("accountinformation.dat"));
														bufferWriter.write(b1);
														bufferWriter.append("\n");
														bufferWriter.write(b2);
														bufferWriter.close();
														} catch(IOException exception) {
															System.out.println("Something wrong with I/O");
														}
													//写入新的账户数据后退出
													System.exit(0);
												}
											
										}
									});
									
									changeConvertButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											if(isEnglish){
												status.setText("两次输入的密码不一致！");
												status2.setText("用户名和密码不能为空！");
												changeUserLabel.setText("新用户名:");
												changePasswordLabel.setText("新密码:");
												changePasswordLabel.setLocation(150, 120);
												changePasswordLabel2.setText("请再次输入:");
												changePasswordLabel2.setLocation(120, 150);
												changeEnterButton.setText("修改并进入");
												changeEnterButton.setSize(120,30);
												changeEnterButton.setLocation(130, 200);
												changeExitButton.setText("修改并退出");
												changeExitButton.setSize(120,30);
												changeExitButton.setLocation(250, 200);
												changeConvertButton.setText("切换英文");
												isEnglish=false;
											}
											else{
												status.setText("Two Passwords are not same!");
												status2.setText("The TextFields can not be empty!");
												changeUserLabel.setText("NewUser:");
												changePasswordLabel.setText("NewPassword:");
												changePasswordLabel.setLocation(110, 120);
												changePasswordLabel2.setText("InputPasswordAgain:");
												changePasswordLabel2.setLocation(68,150);
												changeEnterButton.setText("Change and Enter");
												changeEnterButton.setSize(150,30);
												changeEnterButton.setLocation(100, 200);
												changeExitButton.setText("Change and Exit");
												changeExitButton.setSize(150,30);
												changeExitButton.setLocation(250, 200);
												changeConvertButton.setText("Convertion");
												isEnglish=true;
											}
										}
									});
									
		//修改密码界面下界				//修改密码界面下界
								}
							});
							
							enterinButton.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent exit) {
		//进入管理界面					//进入管理界面
									String filename = "";
									if (args.length != 1) {
										filename = "catalog.dat";
									} else {
										filename = args[0];
									}
									try {
										Catalog catalog =
												(new FileCatalogLoader()).loadCatalog(filename);
										frame.setContentPane(new GourmetCoffeeGUI());
										frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										frame.setSize(WIDTH, HEIGHT);
										frame.setResizable(true);
										frame.setVisible(true);
										

									} catch (FileNotFoundException fnfe) {
										stdErr.println("The file does not exist");

										System.exit(1);

									} catch (DataFormatException dfe) {
										stdErr.println("The file contains malformed data: "
										               + dfe.getMessage());

										System.exit(1);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									choiceFrame.dispose();		//关闭选择界面
		//管理界面下界					//管理界面下界
								}
							});

							chconvertButton.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent exit) {
									if(isEnglish){
										enterinButton.setText("进 入 管 理 界 面");
										changeButton.setText("修 改 账 户 信 息");
										chconvertButton.setText("切换英文");
										isEnglish=false;
									}
									else{
										changeButton.setText("Change the password");
										enterinButton.setText("Enter the management interface");
										chconvertButton.setText("Convertion");
										isEnglish=true;
									}
								}
							});
		//选择界面下界			//选择界面下界
						}
						else{
							status.setVisible(true);
							userField.setText(null);
							passwordField.setText(null);
						}
						
					}
				});
				
				enconvertButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {		//切换登陆界面语言
						if(isEnglish){
							status.setText("密码错误！");
							userLabel.setText("用户:");
							passwordLabel.setText("密码:");
							passwordLabel.setLocation(170, 120);		//中英文长度不同，改变位置，显示的好看
							enterBotton.setText("登陆");
							enterBotton.setLocation(160, 170);
							exitButton.setText("退出");
							enconvertButton.setText("切换英文");
							isEnglish=false;
						}
						else{
							status.setText("Wrong Password!");
							userLabel.setText("User:");
							passwordLabel.setText("Password:");
							passwordLabel.setLocation(140, 120);		//中英文长度不同，改变位置，显示的好看
							enterBotton.setText("Enter");
							enterBotton.setLocation(140, 170);					
							exitButton.setText("Exit");
							enconvertButton.setText("Convertion");
							isEnglish=true;
						}
					}
				});
				
				
			}

	/**
	 * Instantiates the components and arranges them in a window.
	 *
	 * @throws IOException        //add an IOException
	 */
	public  GourmetCoffeeGUI() throws IOException {

		// create the components
		vipBox = new JCheckBox("VIP");
		vipBox.setSelected(false);
		catalogList = new JList();
		orderList = new JList();
		catalogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		catalogList.setVisibleRowCount(CATALOG_LIST_ROWS);
		catalogList.setFixedCellWidth(CATALOG_CELL_SIZE);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList.setVisibleRowCount(ORDER_LIST_ROWS);
		orderList.setFixedCellWidth(ORDER_CELL_SIZE);
		addModifyButton = new JButton("Add|Modify Order Item");
		removeButton = new JButton("Remove Order Item");
		registerSaleButton = new JButton("Register Sale of Current Order");
		displaySalesButton = new JButton("Display Sales");
		saveSalesButton = new JButton("Save Sales");
		convertButton = new JButton("Convertion");  //切换语言
		quantityLabel = new JLabel("Quantity:");
		totalLabel = new JLabel("Total:");
		quantityTextField = new JTextField("", QUANTITY__TEXTFIELD_SIZE);
		totalTextField = new JTextField("$0.00", TOTAL__TEXTFIELD_SIZE);
		totalTextField.setEditable(false);
		statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
		statusTextArea.setEditable(false);

		// Product Information panel
		productPanel = new JPanel();
		productPanel.setBorder(
				BorderFactory.createTitledBorder("Product Information"));

		// Catalog panel

		catalogPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));
		catalogPanel.add (
			new JScrollPane(catalogList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// "Add|Modify Product" panel
		JPanel centralPanel = new JPanel(new BorderLayout());
		JPanel addModifyPanel = new JPanel(new GridLayout(2, 1));
		JPanel quantityPanel = new JPanel();

		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityTextField);
		addModifyPanel.add(quantityPanel);
		addModifyPanel.add(addModifyButton);
		centralPanel.add(productPanel, BorderLayout.CENTER);
		centralPanel.add(addModifyPanel, BorderLayout.SOUTH);

		// Order panel

		orderPanel.setBorder(BorderFactory.createTitledBorder("Order"));

		JPanel totalPanel = new JPanel();

		totalPanel.add(vipBox);
		totalPanel.add(totalLabel);
		totalPanel.add(totalTextField);

		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));

		buttonsPanel.add(removeButton);
		buttonsPanel.add(registerSaleButton);
		orderPanel.add(totalPanel, BorderLayout.NORTH);
		orderPanel.add(new JScrollPane(orderList,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		orderPanel.add(buttonsPanel, BorderLayout.SOUTH);

		// Status panel

		bottomPanel.setBorder(BorderFactory.createTitledBorder("Status"));

		JPanel salesButtonsPanel = new JPanel(new GridLayout(1,6));

		salesButtonsPanel.add(displaySalesButton);
		salesButtonsPanel.add(saveSalesButton);
		salesButtonsPanel.add(convertButton);
		bottomPanel.add (new JScrollPane(statusTextArea,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		bottomPanel.add(salesButtonsPanel, BorderLayout.SOUTH);

		// arrange panels in window
		setLayout(new BorderLayout());
		add(catalogPanel, BorderLayout.WEST);
		add(centralPanel, BorderLayout.CENTER);
		add(orderPanel, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
				
		// start listening for list and buttons events
		catalogList.addListSelectionListener(new DisplayProductListener());
		addModifyButton.addActionListener(new AddModifyListener());
		removeButton.addActionListener(new RemoveListener());
		registerSaleButton.addActionListener(new RegisterSaleListener());
		displaySalesButton.addActionListener(new DisplaySalesListener());
		saveSalesButton.addActionListener(new SaveSalesListener());
		convertButton.addActionListener(new convertListener());
		vipBox.addItemListener(new VipChargeListener());

		catalog = upDateCatalog();
		catalogList.setListData(catalog.getCodes());

		currentOrder = new Order();
		sales = new Sales();
		salesFormatter = PlainTextSalesFormatter.getSingletonInstance();
		fileChooser = new JFileChooser();
		dollarFormatter = NumberFormat.getCurrencyInstance();
		

		if(!isEnglish){
		addModifyButton.setText("添加|修改订单项目");
		removeButton.setText("删除订单项目");
		registerSaleButton.setText("注册当前订单");
		displaySalesButton.setText("显示销售");
		totalLabel.setText("总价:");
		convertButton.setText("切换英语");
		saveSalesButton.setText("保存销售");
		quantityLabel.setText("数量:");
		orderPanel.setBorder(BorderFactory.createTitledBorder("订单"));
		bottomPanel.setBorder(BorderFactory.createTitledBorder("状态"));
		catalogPanel.setBorder(BorderFactory.createTitledBorder("目录"));
		productPanel.setBorder(
				BorderFactory.createTitledBorder("产品信息"));	
		}
	}

	/*
	 * Obtains a {@link JPanel} object with the information of a product.
	 *
	 * @param dataFields  an {@link ArrayList} of {@link DataField}
	 *                    with the product information.
	 * @return  a {@link JPanel} with the product information.
	 */
	private JPanel getDataFieldsPanel(ArrayList<DataField> dataFields) {

		/* COPY YOUR CODE FROM PREVIOUS EXERCISE */

		JPanel dataFieldsPanel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		dataFieldsPanel.setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(dataFields.size(),1));
		panel2.setLayout(new GridLayout(dataFields.size(),1));
		
		for (DataField data : dataFields ){
			JLabel name = new JLabel(data.getName(isEnglish) + ":");//翻译商品信息属性
			JTextField value = new JTextField(data.getValue(isEnglish),20);
			value.setEditable(false);
			panel1.add(name);
			panel2.add(value);
		}
		
		dataFieldsPanel.add(panel1,"West");
		dataFieldsPanel.add(panel2,"Center");
		return dataFieldsPanel;
		// REMOVE; USED SO THIS FILE COMPILES
	}

	/**
	 * This inner class handles list-selection events.
	 */
	class DisplayProductListener implements ListSelectionListener {

		/**
		 * Displays the information of the selected product.
		 *
		 * @param event  the event object.
		 * @throws IOException 
		 */
		
		public void valueChanged(ListSelectionEvent event) {

//			try {
//				catalog = upDateCatalog();
//				catalogList.setListData(catalog.getCodes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			if (! catalogList.getValueIsAdjusting()) {

				String code = (String) catalogList.getSelectedValue();
				Product product = catalog.getProduct(code);

				productPanel.removeAll();
				productPanel.setVisible(false);                   // Use this
				productPanel.add(                                 // to update
					getDataFieldsPanel(product.getDataFields())); // the panel
				productPanel.setVisible(true);                    // correctly

				if(isEnglish)
					statusTextArea.setText("Product " + code + " has been displayed");
				else
					statusTextArea.setText("产品 " + code + " 已显示");
			}
		}
	}

	/**
	 * This inner class processes <code>addModifyButton</code> events.
	 */
	class AddModifyListener implements ActionListener {

		/**
		 * Adds an order item to the current order.
		 *
		 * @param event  the event object.
		 */
		public void actionPerformed(ActionEvent event) { 


			/* PLACE YOUR CODE HERE */
            String code = (String)catalogList.getSelectedValue();
			
			if (code == null) {
				if(isEnglish)
					statusTextArea.setText("Please select a product code from the catalog list.");
				else
					statusTextArea.setText("请从目录列表中选择一个产品代码。");
				return;
			}
			
			int quantity = 0;
			try {
				quantity = Integer.parseInt(quantityTextField.getText());
			} catch (NumberFormatException e) {
				if(isEnglish)
					statusTextArea.setText("Please enter an integer.");
				else
					statusTextArea.setText("请输入一个整数数字。");
				return;
			}
			if (quantity<=0) {
				if(isEnglish)
					statusTextArea.setText("Please enter an integer.");
				else
					statusTextArea.setText("请输入一个整数数字。");
				return;
			}
			
			Product product = catalog.getProduct(code);
			OrderItem item = currentOrder.getItem(product);
			if (item == null) {
				item = new OrderItem(product, quantity);
				currentOrder.addItem(item);
				if(isEnglish)
					statusTextArea.setText("The product has been added.");
				else
					statusTextArea.setText("该产品已添加。");
			}else {
				item.setQuantity(quantity);
				if(isEnglish)
					statusTextArea.setText("The product has been modified.");
				else
					statusTextArea.setText("产品已修改。");
			}
			
			totalTextField.setText(dollarFormatter.format(currentOrder.getTotalCost()));
			orderList.setListData(currentOrder.getItems());
			quantityTextField.setText("");
		}
	}

	/**
	 * This inner class processes <code>removeButton</code> events.
	 */
	class RemoveListener implements ActionListener {

		/**
		 * Removes an order item from the current order.
		 *
		 * @param event  the event object.
		 */
		public void actionPerformed(ActionEvent event) {


			/* PLACE YOUR CODE HERE */
			if(currentOrder.getNumberOfItems() == 0){
				if(isEnglish)
					statusTextArea.setText("The order is empty.");
				else
					statusTextArea.setText("空订单。");
				return;
			}
			
			OrderItem item = (OrderItem) orderList.getSelectedValue();
			if (item == null) {
				if(isEnglish)
					statusTextArea.setText("Please select an item from the order list.");
				else
					statusTextArea.setText("请从订单列表中选择一个项目。");
				return;
			}
			
			currentOrder.removeItem(item);
			orderList.setListData(currentOrder.getItems());
			totalTextField.setText(dollarFormatter.format(currentOrder.getTotalCost()));
			if(isEnglish)
				statusTextArea.setText("The product has been removed.");
			else
				statusTextArea.setText("该产品已删除。");


		}
	}

	/**
	 * This inner class processes <code>registerSaleButton</code> button events.
	 */
	class RegisterSaleListener implements ActionListener {

		/**
		 * Registers the sale of the current order.
		 *
		 * @param event  the event object.
		 */
		public void actionPerformed(ActionEvent event) {

			if (currentOrder.getNumberOfItems() == 0) {
				if(isEnglish)
					statusTextArea.setText("The order is empty.");
				else
					statusTextArea.setText("订单是空的。");
			} else {
				sales.addOrder(currentOrder);
				currentOrder = new Order();
				orderList.setListData(currentOrder.getItems());
				totalTextField.setText(dollarFormatter.format(0));
				if(isEnglish)
					statusTextArea.setText("The sale has been registered.");
				else
					statusTextArea.setText("销售已经注册。");
			}
		}
	}

	/**
	 * This inner class processes <code>displaySalesButton</code>events.
	 */
	class DisplaySalesListener implements ActionListener {

		/**
		 * Displays the sales information.
		 *
		 * @param event  the event object.
		 */
		public void actionPerformed(ActionEvent event) {

			if (sales.getNumberOfOrders() == 0) {
				if(isEnglish)
					statusTextArea.setText("No orders have been sold.");
				else
					statusTextArea.setText("无已售出订单。");
			} else {
				statusTextArea.setText(salesFormatter.formatSales(sales));
			}
		}
	}

	/**
	 * This inner class processes <code>saveSalesButton</code>  events.
	 */
	class SaveSalesListener implements ActionListener {

		/**
		 * Saves the sales informations in a file.
		 *
		 * @param event  the event object.
		 */
		public void actionPerformed(ActionEvent event) {


			/* PLACE YOUR CODE HERE */
			if(sales.getNumberOfOrders() == 0){
				if(isEnglish)
					statusTextArea.setText("No orders have been sold.");
				else
					statusTextArea.setText("无已售出订单。");
				return;
			}
			
			int result = fileChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					PrintWriter out = new PrintWriter(new FileWriter(file));
					out.print(salesFormatter.formatSales(sales));
					out.close();
					if(isEnglish)
						statusTextArea.setText("The sales information has been saved.");
					else
						statusTextArea.setText("销售信息已保存。");
				} catch (IOException e) {
					if(isEnglish)
						statusTextArea.setText("Error: Problem with I/O");
					else
						statusTextArea.setText("错误 : I / O问题");
				}
			}else {
				if(isEnglish)
					statusTextArea.setText("The sales information has been saved.");
				else
					statusTextArea.setText("销售信息已保存。");
			}
		}
	}
	
	class convertListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			//切换语言
			if(isEnglish){
				addModifyButton.setText("添加|修改订单项目");
				removeButton.setText("删除订单项目");
				registerSaleButton.setText("注册当前订单");
				displaySalesButton.setText("显示销售");
				totalLabel.setText("总价:");
				convertButton.setText("切换英语");
				saveSalesButton.setText("保存销售");
				quantityLabel.setText("数量:");
				orderPanel.setBorder(BorderFactory.createTitledBorder("订单"));
				bottomPanel.setBorder(BorderFactory.createTitledBorder("状态"));
				catalogPanel.setBorder(BorderFactory.createTitledBorder("目录"));
				productPanel.setBorder(
						BorderFactory.createTitledBorder("产品信息"));						
				isEnglish=false;
			}else{
				addModifyButton.setText("Add|Modify Order Item");
				removeButton.setText("Remove Order Item");
				registerSaleButton.setText("Register Sale of Current Order");
				displaySalesButton.setText("Display Sales");
				totalLabel.setText("Total:");
				convertButton.setText("Convertion");
				saveSalesButton.setText("Save Sales");
				quantityLabel.setText("Quantity:");
				orderPanel.setBorder(BorderFactory.createTitledBorder("Order"));
				bottomPanel.setBorder(BorderFactory.createTitledBorder("Status"));
				catalogPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));
				productPanel.setBorder(
						BorderFactory.createTitledBorder("Product Information"));
				isEnglish=true;
			}
		}
		
	}



	
	/**
	 * This method will update the data of Catalog.
	 */
    public Catalog upDateCatalog() throws IOException {

    	if(notVip == true)
		{
    		try {
				catalog =
					(new FileCatalogLoader()).loadCatalog("catalog.dat");
				return catalog;
			} catch (FileNotFoundException fnfe) {
				stdErr.println("The file does not exist.");

				System.exit(1);

			} catch (DataFormatException dfe) {
				stdErr.println("The file contains malformed data: "
				               + dfe.getMessage());

				System.exit(1);
			}
		}
    	else
    	{
    		try {
				catalog =
					(new FileCatalogLoader()).loadCatalog("VIPcatalog.dat");
				return catalog;
			} catch (FileNotFoundException fnfe) {
				stdErr.println("The file does not exist.");

				System.exit(1);

			} catch (DataFormatException dfe) {
				stdErr.println("The file contains malformed data: "
				               + dfe.getMessage());

				System.exit(1);
			}
    	}
    	return null;
	}
    
    /**
     * This inner class processes vipBox events.
     */
    class VipChargeListener implements ItemListener {
		
		public void itemStateChanged(ItemEvent event) {
			
			if(event.getStateChange() == ItemEvent.SELECTED) {
				notVip = false;
			}  else {
				notVip = true;
			}
			
			try {
				upDateCatalog();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}