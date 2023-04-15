package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DepositLog_in extends JFrame {

	private JPanel contentPane;
	 JTextField nametextField;
	 JTextField accountNumtextField_1;
	 JTextField  accounttextField_1;
	private String name;
    private String accountNum;
    PreparedStatement ps=null;
    private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositLog_in frame = new DepositLog_in();
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
	public DepositLog_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 36, 90, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblAccountnum = new JLabel("AccountNum");
		lblAccountnum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccountnum.setBounds(27, 92, 106, 30);
		contentPane.add(lblAccountnum);
		
		nametextField = new JTextField();
		nametextField.setBounds(212, 36, 154, 28);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		accountNumtextField_1 = new JTextField();
		accountNumtextField_1.setColumns(10);
		accountNumtextField_1.setBounds(212, 92, 154, 28);
		contentPane.add(accountNumtextField_1);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    String name = nametextField.getText();
				    long accountNum = Long.parseLong(accountNumtextField_1.getText());
				    
				    Bank bank = new BankImp();
				    boolean result=bank.login(name,accountNum);
				    if (result) {
			        	
				    BankDTO response=	bank.getCustomerDetail(accountNum);
			        	PersonDetail obj= new PersonDetail();
			        	obj.idLabel.setText(String.valueOf(response.getId()));
			        	obj.nameLabel.setText(response.getName());
			        	obj.addressLabel.setText(response.getAddress());
			        	obj.contactLabel.setText(String.valueOf(response.getContactNumber()));
			        	obj.genderLabel.setText(response.getGender());
			        	obj.accountnumLabel.setText(String.valueOf(response.getAccountnum()));
			        	obj.accounttypeLabel.setText(String.valueOf(response.getAccounttype()));
			        	obj.amountLabel.setText(String.valueOf(response.getAmount()));
			        	dispose();
			        	obj.setVisible(true);
			        	
			        } 
			        else {
			            JOptionPane.showMessageDialog(null, "Name & AccountNum don't match!", "Error", JOptionPane.ERROR_MESSAGE);
			        }
				   
				}

		});
			
		btnNewButton.setBounds(230, 190, 89, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Camera Roll\\maxresdefault.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
	

}


