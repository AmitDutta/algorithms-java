package ThreadingTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	MyWorker worker;
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("Thread Test");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		contentPane.add(btnStart, BorderLayout.WEST);
		
		JLabel lblStatus = new JLabel("Status");
		contentPane.add(lblStatus, BorderLayout.CENTER);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		contentPane.add(btnStop, BorderLayout.EAST);
		
		worker = new MyWorker(lblStatus);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton){
			JButton btn = (JButton) e.getSource();
			if (btn.getText().equals("Start")){
				worker.runWorkerAsync();
			}
			else{
				worker.tryStop();
			}
		}
		
	}
}
