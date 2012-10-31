package com.benglasser.headerizer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MainWindow {

	protected Shell shell;
	private Text text;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Group grpHeaderizer = new Group(shell, SWT.NONE);
		grpHeaderizer.setText("Headerizer");
		grpHeaderizer.setBounds(10, 10, 414, 242);
		
		Tree tree = new Tree(grpHeaderizer, SWT.BORDER);
		tree.setBounds(10, 48, 122, 184);
		
		text = new Text(grpHeaderizer, SWT.BORDER);
		text.setBounds(10, 21, 122, 21);

	}
}
