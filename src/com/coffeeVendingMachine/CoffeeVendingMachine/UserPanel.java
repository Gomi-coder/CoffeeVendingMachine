package com.coffeeVendingMachine.CoffeeVendingMachine;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UserPanel extends JFrame {
	JFrame frame = this;
	JButton[] selectionBtn = new JButton[4]; //4 coffee
	JButton inputBtn;
	public ImageIcon[] CoffeeImg = new ImageIcon[4]; //4 coffee
	public String coffeeName;
	JTextArea activityLog;
	public JLabel info;
	public JScrollPane jScroll;
	public int index = -1;
	JButton fillStockBtn;
	JButton withdrawBtn;
	Container contentPane;
	JTextField slot;
	int cash;
	private int selection;
	private int selectionPrice;
	
	private Controller controller;
	
	public UserPanel() {
		contentPane=getContentPane();
	    contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
	    contentPane.setBackground(new Color(150,150,150));
	    this.setTitle("Coffee Vending Machine");
	      
	    CoffeeImg[0] = new ImageIcon("americano.JPG");
	    CoffeeImg[1] = new ImageIcon("cafelatte.JPG");
	    CoffeeImg[2] = new ImageIcon("cappuchino.JPG");
	    CoffeeImg[3] = new ImageIcon("dolcelatte");
	      
	    selectionBtn[0] = new JButton("americano(£Ü2000)",CoffeeImg[0]);
	    selectionBtn[1] = new JButton("Cafe Latte(£Ü3500)",CoffeeImg[1]);
	    selectionBtn[2] = new JButton("Cappuccino(£Ü4000)",CoffeeImg[2]);  
	    selectionBtn[3] = new JButton("Dolce Latte(£Ü4500)",CoffeeImg[3]);
		
	    for(int i = 0; i < 4; i++){
			selectionBtn[i].setEnabled(false);
		}
			
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255 ,235 ,205)),"[TaeKyeong Coffee]"); 
	    border.setTitleFont(new Font("µ¸¿ò",Font.BOLD, 35));
	    border.setTitleColor(new Color(255 ,235 ,205));
	    border.setTitleJustification(TitledBorder.CENTER);
	    for(int i = 0; i < 4; i++) { 
	       selectionBtn[i].setFont(new Font("µ¸¿ò",Font.BOLD, 20));
	       selectionBtn[i].addActionListener(new CoffeeBtnActionListener());
	    }
	      
	    JPanel cashPanel = new JPanel();
	    cashPanel.setBackground(new Color(180,150,120));
	    slot = new JTextField("input Cash", 20);
	    slot.setFont(new Font("µ¸¿ò",Font.PLAIN, 25));
	    slot.addMouseListener(new MouseAdapter() {
	    @Override
		public void mouseClicked(MouseEvent e) {
			JTextField text = (JTextField)e.getSource();
				text.setText("");
				for(int i = 0; i < 4; i++)
			    	selectionBtn[i].setEnabled(true);
			} 
	      });
	      
	      inputBtn = new JButton("select");
	      inputBtn.setFont(new Font("µ¸¿ò",Font.BOLD, 25));
	      inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(slot.getText());
				
				accept(index, x);
			}
	      });
	      
	      JPanel btnPanel = new JPanel(new GridLayout(2, 2, 10, 10));
	      btnPanel.setBackground(new Color(180,150,120));
	      for(int i=0;i<2;i++) 
	         btnPanel.add(selectionBtn[i]);
	      for(int i=2;i<4;i++) 
	         btnPanel.add(selectionBtn[i]);
	      
	      cashPanel.add(slot);
	      cashPanel.add(inputBtn);
	      ((JComponent) getContentPane()).setBorder(border);
	      
	      JPanel infoPanel = new JPanel();
	      
	      Box infoBox = Box.createVerticalBox();
	      TitledBorder bord =  BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(120 ,60 ,20)),"[OUTPUT]"); 
	      bord.setTitleFont(new Font("µ¸¿ò",Font.BOLD ,25));
	      bord.setTitleColor(new Color(120 ,60 ,20));
	      bord.setTitleJustification(TitledBorder.CENTER);
	      
	      JLabel info = new JLabel("¡ØHow to Order? \n input Money -> select Coffee -> click 'select' button ");
		  
	      info.setFont(new Font("µ¸¿ò",Font.PLAIN, 25));
	      //info.setAlignmentX(CENTER_ALIGNMENT);
	      
	      activityLog = new JTextArea("Just a moment, plz", 11, 40);
	      activityLog.setEditable(false);
	      activityLog.setFont(new Font("µ¸¿ò",Font.BOLD, 25));
	      activityLog.setLineWrap(true);
	      
	      JScrollPane scroll =new JScrollPane(activityLog);
	      int pos = activityLog.getText().length();
	      activityLog.setCaretPosition(pos);
	      activityLog.requestFocus();
	      
	      fillStockBtn = new JButton("Administrator Mode");
	      fillStockBtn.setFont(new Font("µ¸¿ò",Font.ITALIC, 20));
	      fillStockBtn.setEnabled(false);
	      fillStockBtn.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
	    		String pw = JOptionPane.showInputDialog("Enter Password");
	    			 if(pw.equals("20172127")){
	    				  StockDialog sd = new StockDialog(frame, "fill Stock");
	    				  sd.setVisible(true);
	    			 }
	    			 else { 
	    				 JOptionPane.showMessageDialog(frame, "wrong. Re-enter.");
	    			 }
	    		}
	    	  });
	      
	      withdrawBtn = new JButton("Reclaim Balance For Administrator");
	      withdrawBtn.setFont(new Font("µ¸¿ò",Font.ITALIC, 20));
	      withdrawBtn.setEnabled(true);
	      withdrawBtn.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent arg0) {
		    		String pw = JOptionPane.showInputDialog("Enter Password");
		    			 if(pw.equals("20172127")){
		    				  MoneyDialog md = new MoneyDialog(frame, "Reclaim Balance");
		    				  md.setVisible(true);
		    			 }
		    			 else {
		    				 JOptionPane.showMessageDialog(frame, "wrong. Re-enter.");
		    			 }
		    		}
		    	  });
	      
	      infoBox.add(Box.createVerticalStrut(20));
	      infoBox.add(info);
	      infoBox.add(Box.createVerticalStrut(25));
	      infoBox.add(scroll);
	      infoBox.add(Box.createVerticalStrut(25));
	      infoBox.add(fillStockBtn);
	      infoBox.add(withdrawBtn);
	      fillStockBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	      withdrawBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	      infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
	      infoPanel.add(infoBox);
	      infoPanel.setBorder(bord);
	      
	      contentPane.add(btnPanel);
	      contentPane.add(cashPanel);
	      contentPane.add(infoPanel);
	      
		  setSize(1000, 1500);
		  setResizable(false);
		  setVisible(true);
	}

	private class CoffeeBtnActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				switch(cmd) {
					case "americano(£Ü2000)":
						index = 0;
						break;
					case "Cafe Latte(£Ü3500)":
						index = 1;
						break;
					case "Cappuccino(£Ü4000)":
						index = 2;
						break;
					case "Dolce Latte(£Ü4500)":
						index = 3;
						break;
				}
			}
		}
	
	   private class MoneyDialog extends JDialog{
			private JLabel moneyLabel = new JLabel("Enter Amount to Reclaim.");
			private JTextField moneyField = new JTextField(10);
			private JButton confirmBtn = new JButton("Change");
			
			public MoneyDialog(JFrame frame, String title) {
				super(frame, title, true);
				setLayout(new FlowLayout());
				moneyLabel.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
				add(moneyLabel);
				moneyField.setText(Integer.toString(MoneyManager.total));
				moneyField.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
				add(moneyField);
				add(confirmBtn);
				setSize(300, 200);
				
				confirmBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						int x = Integer.parseInt(moneyField.getText());
						
						MoneyManager.updateTotal(x);
						JOptionPane.showMessageDialog(frame, "Balance: "+Integer.toString(MoneyManager.total));
						setVisible(false);
						
						activityLog.append("Balance Reclamation Completed.\n");
						activityLog.append("Continued");
						for(int i = 0; i < 4; i++)
							selectionBtn[i].setEnabled(true);
						slot.setEnabled(true);
						inputBtn.setEnabled(true);
					}
				});
			}
		}
	   
	class StockDialog extends JDialog{
			private JLabel ingLabel[] = new JLabel[5];
			private String ingNames[] = {"cup ", "water ", "milk ", "coffee ", "cream "};
			private JTextField ingField[] = new JTextField[5];
			private JButton confirmBtn = new JButton("change");
			
			public StockDialog(JFrame frame, String title) {
				super(frame, title, true);
				setLayout(new GridLayout(6, 1, 5, 5));
				for(int i = 0; i < ingLabel.length; i++) {
					ingLabel[i]= new JLabel(ingNames[i]);
					ingLabel[i].setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
				}
				for(int j = 0; j < ingField.length; j++) {
					ingField[j] = new JTextField(8);
					ingField[j].setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
				}
				
				for(int k = 0; k < ingLabel.length; k++) {
					add(ingLabel[k]);
					ingField[k].setText(Integer.toString(Stock.getIngredient(k)));
					add(ingField[k]);
				}
				add(confirmBtn);
				setSize(600, 450);
				
				confirmBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Stock.updateStock(Integer.parseInt(ingField[0].getText()), 
												  Integer.parseInt(ingField[1].getText()), 
												  Integer.parseInt(ingField[2].getText()), 
												  Integer.parseInt(ingField[3].getText()), 
												  Integer.parseInt(ingField[4].getText()));
						setVisible(false);
						
						activityLog.append("Stock is filled.\n");
						activityLog.append("continued\n");
						for(int i = 0; i < 4; i++)
							selectionBtn[i].setEnabled(true);
						slot.setEnabled(true);
						inputBtn.setEnabled(true);
						
						fillStockBtn.setEnabled(false);
					}
				});
			}
	   }


	public void accept(int index, int cash) {
		this.selection = index;
		this.cash = cash;
		
		switch(index){
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
		}
		System.out.println("1");
		
		controller = new Controller(this);
		controller.inputInfo(selection, cash, selectionPrice);
	}
	
	public void disableBtn() {
		for(int i = 0; i < 4; i++)
				selectionBtn[i].setEnabled(false);
			slot.setEnabled(false);
			inputBtn.setEnabled(false);
			activityLog.append("Sorry, Out of stock. return your money.\n");
			activityLog.append("Discontinued\n");
				
			fillStockBtn.setEnabled(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		UserPanel userPanel = new UserPanel();
	}
}
