package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithDraw extends JFrame {

	private JPanel contentPane;
	public JTextField accountNumtextField;
	JTextField nametextField_1;
	private JTextField withdrawtextField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithDraw frame = new WithDraw();
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
	public WithDraw() {
		setTitle("WithDraw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AccountNumber");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 27, 148, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(10, 71, 148, 22);
		contentPane.add(lblName);
		
		JLabel lblWithdrawamount = new JLabel("WithDrawAmount");
		lblWithdrawamount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWithdrawamount.setBounds(10, 125, 148, 22);
		contentPane.add(lblWithdrawamount);
		
		accountNumtextField = new JTextField();
		accountNumtextField.setEditable(false);
		accountNumtextField.setBounds(257, 31, 106, 29);
		contentPane.add(accountNumtextField);
		accountNumtextField.setColumns(10);
		
		nametextField_1 = new JTextField();
		nametextField_1.setEditable(false);
		nametextField_1.setColumns(10);
		nametextField_1.setBounds(257, 75, 106, 29);
		contentPane.add(nametextField_1);
		
		withdrawtextField_2 = new JTextField();
		withdrawtextField_2.setColumns(10);
		withdrawtextField_2.setBounds(257, 125, 106, 26);
		contentPane.add(withdrawtextField_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bank bank = new BankImp();
				String accountnum = accountNumtextField.getText();
	            int accountNumber = Integer.parseInt(accountnum);
	            String name=nametextField_1.getText();
				double amount = Double.parseDouble(withdrawtextField_2.getText());
	            try {
	              bank.decreaseBalance(accountNumber,amount,name);
	                new BankDetails().setVisible(true);
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(200, 256, 89, 23);
		contentPane.add(btnNewButton);
	}

}
