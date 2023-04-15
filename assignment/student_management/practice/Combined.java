package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Combined extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combined frame = new Combined();
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
	public Combined() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(43, 91, 125, 31);
		contentPane.add(btnNewButton);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DepositLog_in().setVisible(true);
				
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCustomer.setBounds(226, 91, 133, 31);
		contentPane.add(btnCustomer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\360_F_323124237_SfGqpttZqU2mrMm61VPSWA2tKvc95l9O.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}

}
