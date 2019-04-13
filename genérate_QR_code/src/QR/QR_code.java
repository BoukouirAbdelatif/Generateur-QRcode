package QR;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class QR_code {

	private JFrame frame;
	private JTextField txt;
	JLabel lblNewLabel;
    int i=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QR_code window = new QR_code();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QR_code() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setBounds(100, 34, 229, 20);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		JButton btnNewButton = new JButton("G\u00E9n\u00E9rate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String chaine=txt.getText();
				ByteArrayOutputStream out=QRCode.from(chaine).to(ImageType.JPG).stream();
				File f=new File("lib/"+i+".jpg");
				try {
					FileOutputStream fos=new FileOutputStream(f);
					fos.write(out.toByteArray());
					fos.flush();
					txt.setText("");
					lblNewLabel.setIcon(new ImageIcon("lib/"+i+".jpg"));
                    i++;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		});
		btnNewButton.setBounds(100, 95, 229, 23);
		frame.getContentPane().add(btnNewButton);

	    lblNewLabel = new JLabel();
		lblNewLabel.setBounds(111, 152, 189, 134);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(44, 37, 46, 14);
		frame.getContentPane().add(lblCode);
	
	}
}
