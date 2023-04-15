package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Loader extends JFrame {

	private JPanel contentPane;
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loader frame = new Loader();
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
	public Loader() {
		setTitle("LoadingBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar(0,100);
		progressBar.setIndeterminate(true);
		progressBar.setForeground(new Color(0, 255, 0));
		progressBar.setBounds(137, 200, 174, 21);
		contentPane.add(progressBar);
		
		Thread thread = new Thread(    
				()->{
					for(int i=0;i<=100;i++) {
						progressBar.setValue(i);
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
						if(i==100) {
							dispose();
							new Combined().setVisible(true);
						}
					}
	}
				
				
				);
		thread.start();
				
		
		JLabel lblNewLabel = new JLabel("Loading..........");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(147, 218, 164, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Camera Roll\\OIP.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
				}
	}

	
