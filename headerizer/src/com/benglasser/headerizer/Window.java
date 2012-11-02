package com.benglasser.headerizer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.Window.Type;

public class Window {

	private JFrame frmHeaderizer;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmHeaderizer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHeaderizer = new JFrame();
		frmHeaderizer.setResizable(false);
		frmHeaderizer.setTitle("Headerizer");
		frmHeaderizer.setBounds(100, 100, 575, 598);
		frmHeaderizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHeaderizer.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Headerize!");
		btnNewButton.setBounds(429, 526, 120, 23);
		frmHeaderizer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setBounds(304, 526, 120, 23);
		frmHeaderizer.getContentPane().add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 539, 504);
		frmHeaderizer.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		tabbedPane.addTab("General", null, panel, null);
		panel.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBorder(new LineBorder(new Color(100, 100, 100)));
		tree.setBounds(264, 75, 260, 390);
		panel.add(tree);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 415, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Display");
		btnNewButton_2.setBounds(435, 43, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblDestinationPath = new JLabel("Destination Path or File");
		lblDestinationPath.setBounds(10, 19, 222, 14);
		panel.add(lblDestinationPath);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 75, 244, 158);
		panel.add(editorPane);
	}
}
