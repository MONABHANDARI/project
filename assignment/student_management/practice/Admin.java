package com.assignment.student_management.practice;

import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
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

public class Admin extends JFrame {
	PreparedStatement ps=null;
	private JPanel contentPane;
	private JTextField nametextField;
	 
	    private String username;
	    private String password;
	    private JLabel lblNewLabel_1;
	    private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 41, 74, 28);
		contentPane.add(lblNewLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(207, 41, 125, 24);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(38, 101, 74, 28);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Log_in");
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(217, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Camera Roll\\AAEAAQAAAAAAAASRAAAAJGRiMTliNTBmLTYzYTktNDBiYy05NzU2LTM2OTY0NTEwODEzMA.png"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 108, 100, 23);
		contentPane.add(passwordField);
	}
	 public void login() {
	        String username = nametextField.getText();
	        String password = new String(passwordField.getPassword());
	        String sql = "SELECT * FROM admin WHERE name=? AND password=?";
	        try {
	            ps = DataConnection.getConnection().prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs=ps.executeQuery();
	            if (rs.next()) {
	                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                new BankDetails().setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(this, "Login failed!", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}
	




