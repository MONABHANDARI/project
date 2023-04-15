package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.nextstep.studentmanagementsystem.practic.DataBaseConnection;

import javax.swing.*;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CustomerDetail extends JFrame {
	PreparedStatement ps=null;
	private JPanel contentPane;
	private JTextField depositeAmountTextField;
	public JTextField accountNumberTextField;
	
	JRadioButton currentRadioButton;
	JRadioButton fixedRadioButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetail frame = new CustomerDetail();
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
	
	
	
	public CustomerDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To ABC Bank");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(45, 11, 285, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AccountNum");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 71, 113, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DepositAmount");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 122, 140, 28);
		contentPane.add(lblNewLabel_1_1);
		
		
		
		depositeAmountTextField = new JTextField();
		depositeAmountTextField.setColumns(10);
		depositeAmountTextField.setBounds(173, 122, 179, 28);
		contentPane.add(depositeAmountTextField);
		
		
		
		accountNumberTextField = new JTextField();
		accountNumberTextField.setEditable(false);
		accountNumberTextField.setColumns(10);
		accountNumberTextField.setBounds(173, 75, 179, 27);
		contentPane.add(accountNumberTextField);
		
		JButton submitbtnNewButton = new JButton("Submit");
		submitbtnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		            Bank bank = new BankImp();
		            String accountnum = accountNumberTextField.getText();
		            int accountNumber = Integer.parseInt(accountnum);
		            double amount = Double.parseDouble(depositeAmountTextField.getText());
		            try {
		                bank.increaseBalance(accountNumber, amount);
		                new BankDetails().setVisible(true);
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    });
		

			
		
		submitbtnNewButton.setForeground(Color.BLUE);
		submitbtnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submitbtnNewButton.setBounds(205, 248, 95, 23);
		contentPane.add(submitbtnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Camera Roll\\header.jpg"));
		lblNewLabel_2.setBounds(0, 0, 434, 332);
		contentPane.add(lblNewLabel_2);
		
		/*currentRadioButton = new JRadioButton("Current");
		currentRadioButton.setBounds(201, 167, 69, 22);
		contentPane.add(currentRadioButton);
		
		fixedRadioButton = new JRadioButton("Fixed");
		fixedRadioButton.setBounds(281, 167, 69, 20);
		contentPane.add(fixedRadioButton);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(currentRadioButton);
		buttonGroup.add(fixedRadioButton);
		*/
	}
}
