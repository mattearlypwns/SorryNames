package com.mattearlypwns.SorryNames;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static int selectedCheckbox = 0;

	private Container contentPane = getContentPane();
	private JTextField output;
	private JLabel link;
	public String version = "1.0.1";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread io = new Thread(new IO());
					io.start();
					new MainFrame();
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setResizable(false);
		setTitle("Sorry Names " + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JCheckBox p1 = new JCheckBox("Period 1");
		p1.setBounds(45, 40, 90, 23);
		p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedCheckbox = 1;
			}
		});

		JCheckBox p2 = new JCheckBox("Period 2");
		p2.setBounds(181, 40, 80, 23);
		p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedCheckbox = 2;
			}
		});

		JCheckBox p3 = new JCheckBox("Period 3");
		p3.setBounds(317, 40, 80, 23);
		p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedCheckbox = 3;
			}
		});

		JCheckBox p4 = new JCheckBox("Period 4");
		p4.setBounds(45, 89, 90, 23);
		p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedCheckbox = 4;

			}
		});

		JCheckBox p5 = new JCheckBox("Period 5");
		p5.setBounds(181, 89, 90, 23);
		p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedCheckbox = 5;
			}
		});

		JCheckBox p6 = new JCheckBox("Period 6");
		p6.setBounds(317, 89, 90, 23);
		p6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedCheckbox = 6;
			}
		});

		output = new JTextField();
		output.setEditable(false);
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setBounds(250, 177, 139, 20);
		output.setBackground(Color.WHITE);
		output.setForeground(Color.BLACK);

		JButton genName = new JButton("Generate Name");
		genName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				output.setText(IO.generateNewName(selectedCheckbox));
			}

		});
		genName.setBounds(250, 146, 139, 20);

		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(274, 210, 90, 25);

		link = new JLabel("Learn How To Use");
		link.setForeground(Color.BLUE);
		link.setHorizontalTextPosition(SwingConstants.CENTER);
		link.setBounds(269, 240, 103, 25);
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				link.setText("<html><u>Learn How To Use</u></html>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				link.setText("Learn How To Use");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop()
							.browse(new URI(
									"http://sorrynames.wikispaces.com"));
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(
									null,
									"Cannot open for some reason... \n go to \"http://sorrynames.wikispaces.com\" instead");
					e1.printStackTrace();
				}
			}
		});

		ButtonGroup bg = new ButtonGroup();
		bg.add(p1);
		bg.add(p2);
		bg.add(p3);
		bg.add(p4);
		bg.add(p5);
		bg.add(p6);

		contentPane.add(p1);
		contentPane.add(p2);
		contentPane.add(p3);
		contentPane.add(p4);
		contentPane.add(p5);
		contentPane.add(p6);
		contentPane.add(link);
		contentPane.add(output);
		contentPane.add(genName);
		contentPane.add(btnClose);
		setVisible(true);
	}
}
