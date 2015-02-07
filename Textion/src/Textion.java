import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Textion extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextArea text;
	
	public static void main(String[] args) {
		new Textion().setVisible(true);
		
		
		}
	private Textion() {
		super("Textion");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		initialize();
	}
	
	private void initialize() {
	    text = new JTextArea();
	    JScrollPane scroll = new JScrollPane(text);
	    
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveas = new JMenuItem("Save as");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem extra = new JMenuItem("HelloSonaBayya");
		
		JMenuItem[] items = {open, save ,saveas, exit};
		for(JMenuItem item : items) {
			item.addActionListener(this);
			
		}
		
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.addSeparator();
		file.add(exit);
		file.add(extra);
		
		bar.add(file);
		

		
		add(scroll);
		setJMenuBar(bar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Open")) {
			open();
		} else if(e.getActionCommand().equals("Save")) {
			save();
		} else if(e.getActionCommand().equals("Save as")) {
			save();
		} else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
	}
			
		
		private void open() {
			JFileChooser chooser = new JFileChooser("./");
			
			int returned = chooser.showOpenDialog(this);
			
			if(returned == JFileChooser.APPROVE_OPTION) {
			    File file = chooser.getSelectedFile();
				
			try {
				BufferedReader br = new BufferedReader(new FileReader("file.txt"));
				
				String line;
				while((line = br.readLine()) != null) {
					text.append(line + "\n");
				}
				
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	
		}
			} 
		
		private void save() {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
				
				bw.write(text.getText());
				
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}


