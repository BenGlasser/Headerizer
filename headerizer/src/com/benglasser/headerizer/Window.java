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
import javax.swing.JMenu;
import java.awt.TextField;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Label;
import javax.swing.JCheckBox;

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
		frmHeaderizer.setBounds(100, 100, 819, 688);
		frmHeaderizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHeaderizer.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Headerize!");
		btnNewButton.setBounds(683, 626, 120, 23);
		frmHeaderizer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setBounds(553, 626, 120, 23);
		frmHeaderizer.getContentPane().add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 793, 604);
		frmHeaderizer.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		tabbedPane.addTab("General", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 244, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDestinationPath = new JLabel("Destination Path or File");
		lblDestinationPath.setBounds(10, 11, 222, 14);
		panel.add(lblDestinationPath);
		
		JLabel lblEnterTheHeader = new JLabel("Enter the Header you would like to insert here:");
		lblEnterTheHeader.setBounds(264, 11, 244, 14);
		panel.add(lblEnterTheHeader);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(264, 391, 111, 174);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFileTypes = new JLabel("File Types");
		lblFileTypes.setBounds(28, 12, 48, 14);
		panel_1.add(lblFileTypes);
		
		JCheckBox chckbxcpp = new JCheckBox("cpp");
		chckbxcpp.setBounds(4, 85, 97, 23);
		panel_1.add(chckbxcpp);
		
		JCheckBox chckbxjava = new JCheckBox("java");
		chckbxjava.setBounds(4, 111, 97, 23);
		panel_1.add(chckbxjava);
		
		JCheckBox chckbxXml = new JCheckBox("xml");
		chckbxXml.setBounds(4, 137, 97, 23);
		panel_1.add(chckbxXml);
		
		JCheckBox chckbxC = new JCheckBox("c");
		chckbxC.setBounds(4, 33, 97, 23);
		panel_1.add(chckbxC);
		
		JCheckBox chckbxCs = new JCheckBox("cs");
		chckbxCs.setBounds(4, 59, 97, 23);
		panel_1.add(chckbxCs);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(264, 36, 472, 202);
		panel.add(textArea);


	}
}
