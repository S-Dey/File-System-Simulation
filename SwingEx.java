import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*; 
import java.awt.event.*;
import java.util.*;

class SwingEx 
{  
	public static void main(String[] args) 
	{  
		JFrame f=new JFrame();  
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		f.setSize(width,(int)height);  
		f.setLayout(null);
		
		JTextField textField =new JTextField("C:\\computer...");
		textField.setBounds(70,0,f.getSize().width,30);
		f.add(textField);

		JButton backBtn = new JButton("<");
		backBtn.setBounds(0,0,f.getSize().width/20,f.getSize().height/25);  
		backBtn.setForeground(Color.white);
        backBtn.setBackground(Color.blue);
		backBtn.setFocusPainted(false);
		f.add(backBtn);
		
		JPanel sidePanel=new JPanel();
		sidePanel.setLayout(null);  
        sidePanel.setBounds(0,30,f.getSize().width/6,f.getSize().height);    
        sidePanel.setBackground(Color.white); 
				
		JLabel taskLabel =new JLabel("Task"); 
		taskLabel.setFont(new Font("Georgia(Body)", Font.BOLD, 14));
		taskLabel.setForeground(Color.blue);		
        taskLabel.setBounds(0,30,f.getSize().width/6,f.getSize().height/20);
		f.add(taskLabel);
		
		Map<String,JButton> btnList = new HashMap<String,JButton>();
		btnList.put("newFileBtn",new JButton("New File"));
			btnList.get("newFileBtn").setBounds(0,69,f.getSize().width/6,f.getSize().height/20);
		
		btnList.put("newFolderBtn",new JButton("New Folder"));
			btnList.get("newFolderBtn").setBounds(0,108,f.getSize().width/6,f.getSize().height/20);
		
		btnList.put("deleteBtn",new JButton("Delete"));
			btnList.get("deleteBtn").setBounds(0,147,f.getSize().width/6,f.getSize().height/20);

		btnList.put("moveBtn",new JButton("Move"));
			btnList.get("moveBtn").setBounds(0,186,f.getSize().width/6,f.getSize().height/20);

		for(String key : btnList.keySet()){
			btnList.get(key).setBackground(Color.white);
			btnList.get(key).setFocusPainted(false);
			sidePanel.add(btnList.get(key));
		}	
		
		String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    	String column[]={"Name","Type","Size"};         
    	JTable jt=new JTable(data,column);    
    	          
    	JScrollPane sp=new JScrollPane(jt);    
    	sp.setBounds(f.getSize().width/6,30,f.getSize().width-f.getSize().width/6,f.getSize().height-30);

    	f.add(sp);

		f.add(sidePanel);
		f.addWindowListener(new WindowAdapter() {
        @Override 
        public void windowClosing(WindowEvent e) {
                System.exit(0);
        }
	 });		
		f.setVisible(true); 
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}  
}  