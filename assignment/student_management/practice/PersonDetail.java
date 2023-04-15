package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PersonDetail extends JFrame {
	JLabel nametextField = null;
	JLabel accounttextField_1 = null;
	JLabel amounttextField_2 = null;
	private JPanel contentPane;
public JLabel lblNewLabel;
public JLabel lblName;
public JLabel lblAddress ;
public JLabel lblContact;
 public JLabel lblGender;
 public static JLabel lblAccountnumber;
 public JLabel lblAccountType;
  public JLabel lblAmount,idLabel,nameLabel,accountnumLabel,accounttypeLabel,genderLabel,addressLabel,contactLabel,amountLabel;
  private JLabel lblNewLabel_1;
  private JTextField withDrawtextField;
protected Object accountNumberTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonDetail frame = new PersonDetail();
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
	public PersonDetail() {
		setTitle("PersonDetail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 83, 27);
		contentPane.add(lblNewLabel);
		
		 lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(10, 49, 83, 27);
		contentPane.add(lblName);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(10, 89, 83, 27);
		contentPane.add(lblAddress);
		
		 lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContact.setBounds(10, 138, 83, 27);
		contentPane.add(lblContact);
		
		 lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(10, 176, 63, 27);
		contentPane.add(lblGender);
		
	 lblAccountnumber = new JLabel("Account Number");
		lblAccountnumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccountnumber.setBounds(10, 214, 153, 27);
		contentPane.add(lblAccountnumber);
		
		 lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccountType.setBounds(10, 252, 129, 27);
		contentPane.add(lblAccountType);
		
	 lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAmount.setBounds(10, 293, 83, 27);
		contentPane.add(lblAmount);
		
		 idLabel = new JLabel("");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idLabel.setBounds(172, 11, 169, 23);
		contentPane.add(idLabel);
		
		 nameLabel = new JLabel("");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameLabel.setBounds(172, 49, 169, 23);
		contentPane.add(nameLabel);
		
		 addressLabel = new JLabel("");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addressLabel.setBounds(172, 91, 169, 23);
		contentPane.add(addressLabel);
		
		 contactLabel = new JLabel("");
		contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contactLabel.setBounds(172, 142, 169, 23);
		contentPane.add(contactLabel);
		
		 genderLabel = new JLabel("");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genderLabel.setBounds(172, 185, 169, 23);
		contentPane.add(genderLabel);
		
		 accountnumLabel = new JLabel("");
		accountnumLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		accountnumLabel.setBounds(173, 223, 169, 23);
		contentPane.add(accountnumLabel);
		
		 accounttypeLabel = new JLabel("");
		accounttypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		accounttypeLabel.setBounds(172, 261, 169, 23);
		contentPane.add(accounttypeLabel);
		
	    amountLabel = new JLabel("");
		amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amountLabel.setBounds(172, 302, 169, 23);
		contentPane.add(amountLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			private JLabel accountNumTextField;
			private JLabel amountTextField;

			public void actionPerformed(ActionEvent e) {
				dispose();
				new Combined().setVisible(true);
		    }
		});
		






		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(208, 395, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("WithDraw");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 331, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		withDrawtextField = new JTextField();
		withDrawtextField.setBounds(182, 331, 159, 24);
		contentPane.add(withDrawtextField);
		withDrawtextField.setColumns(10);
		
}
}
		
	
