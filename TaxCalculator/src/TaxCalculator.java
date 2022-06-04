import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;



public class TaxCalculator implements ActionListener{

	JFrame frame;
	Font myFont = new Font("Arial", Font.BOLD, 20);
	Font font = new Font("Arial", Font.BOLD, 18);
	
	
	JLabel incLabel = new JLabel("Income: ");
	JLabel sssLabel = new JLabel("SSS Contributionn:");
	JLabel philLabel = new JLabel("Philhealth Contribution: ");
	JLabel ibigLabel = new JLabel("Pag-Ibig Contribution: ");
	JLabel taxLabel = new JLabel("Taxable Income: ");
	JLabel netLabel = new JLabel("Net Pay: ");
	JLabel imageLabel = new JLabel("");
	JLabel kaltaxLabel = new JLabel("");
	
	
	JTextField[] textfield = new JTextField[6]; 
	JTextField incField, sssField, philField, ibigField, taxField, netField;
	JButton[] funcButton = new JButton[2];
	JButton calcButton, clrButton;
	JPanel panel;
	
	
	
	
	ImageIcon image = new ImageIcon("C:\\\\Users\\\\YUGHIE\\\\eclipse-workspace\\\\TaxCalculator\\\\src\\\\taxcalcu.png");
	ImageIcon icon = new ImageIcon("C:\\Users\\YUGHIE\\eclipse-workspace\\TaxCalculator\\src\\taxcalcc.png");
	ImageIcon background = new ImageIcon("C:\\Users\\YUGHIE\\eclipse-workspace\\TaxCalculator\\src\\backgoround.png");
	ImageIcon kaltax = new ImageIcon("C:\\Users\\YUGHIE\\eclipse-workspace\\TaxCalculator\\src\\caltax.png");
	

	
	TaxCalculator() {
		frame = new JFrame("KalTax");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 780);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0x5918C9));
		frame.setIconImage(icon.getImage());
		
		
	
		
		
		incField = new JTextField("");
		incField.setFont(myFont);
		incField.setForeground(new Color(0x5918C9));
		sssField = new JTextField("");
		philField = new JTextField("");
		ibigField = new JTextField("");
		taxField = new JTextField("");
		netField = new JTextField("");
		
		textfield[0] = incField;
		textfield[1] = sssField;
		textfield[2] = philField;
		textfield[3] = ibigField;
		textfield[4] = taxField;
		textfield[5] = netField;
		
		for(int i = 1; i < 6; i++) {
			textfield[i].setFont(myFont);
			textfield[i].setFocusable(false);
			textfield[i].setSize(18, 100);
			textfield[i].setForeground(new Color(0x779cf2));
			
		}
		
		
		
		calcButton = new JButton("Calculate");
		clrButton = new JButton("Clear");
		
		
		funcButton[0] = calcButton;
		funcButton[1] = clrButton;
		
		
		for(int i = 0; i < 2; i++) {
			funcButton[i].setFont(myFont);
			funcButton[i].setFocusable(false);
			funcButton[i].addActionListener(this);
		}
		
		calcButton.setBounds(90,630,150,50);
		calcButton.setBackground(Color.YELLOW);
		calcButton.setForeground(new Color(0x5918C9));
		
		
		clrButton.setBounds(245,630,150,50);
		clrButton.setBackground(new Color(0xaee8f2));
		clrButton.setForeground(new Color(0x421c94));
		
		
		
		incLabel.setForeground(Color.YELLOW);
		sssLabel.setForeground(Color.YELLOW);
		philLabel.setForeground(Color.YELLOW);
		ibigLabel.setForeground(Color.YELLOW);
		taxLabel.setForeground(Color.YELLOW);
		netLabel.setForeground(Color.YELLOW);
		incLabel.setFont(font);
		sssLabel.setFont(font);
		philLabel.setFont(font);
		ibigLabel.setFont(font);
		taxLabel.setFont(font);
		netLabel.setFont(font);
		
		
		kaltaxLabel.setIcon(kaltax);
		kaltaxLabel.setBounds(0,10, 500, 600);
		
		imageLabel.setIcon(image);
		imageLabel.setBounds(-60, 480, 400, 400);
		
		
		incLabel.setBounds(20,165,150,50);
		incField.setBounds(240,165,220,50);
		incField.setEditable(true);
		incField.setFocusable(true);
		
		sssLabel.setBounds(20,235,200,50);
		sssField.setBounds(240,235,220,50);
		
		philLabel.setBounds(20,305,220,50);
		philField.setBounds(240,305,220,50);
		
		ibigLabel.setBounds(20,375,200,50);
		ibigField.setBounds(240,375,220,50);
		
		taxLabel.setBounds(20,445,200,50);
		taxField.setBounds(240,445,220,50);
		
		netLabel.setBounds(20,515,200,50);
		netField.setBounds(240,515,220,50);
		
		
		
		/*
		panel = new JPanel();
		panel.setBounds(20,100, 440, 375);
		panel.setBackground(new Color(0x5918C9));
		panel.setLayout(new GridLayout(5,2, 0, 30));
		
		
		
		panel.add(sssLabel);
		panel.add(sssField);
		panel.add(philLabel);
		panel.add(philField);
		panel.add(ibigLabel);
		panel.add(ibigField);
		panel.add(taxLabel);
		panel.add(taxField);
		panel.add(netLabel);
		panel.add(netField);
		
		
		
		frame.add(panel);*/
		frame.add(kaltaxLabel);
		frame.add(imageLabel);
		frame.add(incLabel);
		frame.add(incField);
		frame.add(sssLabel);
		frame.add(sssField);
		frame.add(philLabel);
		frame.add(philField);
		frame.add(ibigLabel);
		frame.add(ibigField);
		frame.add(taxLabel);
		frame.add(taxField);
		frame.add(netLabel);
		frame.add(netField);
		frame.add(calcButton);
		frame.add(clrButton);
		
		frame.setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaxCalculator calc = new TaxCalculator();
	

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double income, sssCon = 0, philCon, ibigCon, taxableIncome, incomeTax, netPay;
		
		if(e.getSource()==calcButton) {
			income = Double.parseDouble(incField.getText());
			
			//SSS CONTRIBUTION
			
			if(income < 999.99) {
				sssField.setText("0");
			}
			else if(income >= 100 && income <= 1249.99){
				sssField.setText("36.30");
				sssCon = 36.30;
			}
			else if(income >= 1250 && income <= 1749.99){
				sssField.setText("54.50");
				sssCon = 54.50;
			}
			else if(income >= 1750 && income <= 2249.99){
				sssField.setText("72.70");
				sssCon = 72.70;
			}
			else if(income >= 2250 && income <= 2749.99){
				sssField.setText("90.80");
				sssCon = 90.80;
			}
			else if(income >= 2750 && income <= 3249.99){
				sssField.setText("109.00");
				sssCon = 109.00;
			}
			else if(income >= 3250 && income <= 3749.99){
				sssField.setText("127.20");
				sssCon = 127.20;
			}
			else if(income >= 3750 && income <= 4249.99){
				sssField.setText("145.30");
				sssCon = 145.30;
			}
			else if(income >= 4250 && income <= 4749.99){
				sssField.setText("163.50");
				sssCon = 163.50;
			}
			else if(income >= 4750 && income <= 5249.99){
				sssField.setText("181.70");
				sssCon = 181.70;
			}
			else if(income >= 5250 && income <= 5749.99){
				sssField.setText("199.80");
				sssCon = 199.80;
			}
			else if(income >= 5750 && income <= 6249.99){
				sssField.setText("218.00");
				sssCon = 218.00;
			}
			else if(income >= 6250 && income <= 6749.99){
				sssField.setText("236.20");
				sssCon = 236.20;
			}
			else if(income >= 6750 && income <= 7249.99){
				sssField.setText("254.30");
				sssCon = 254.30;
			}
			else if(income >= 7250 && income <= 7749.99){
				sssField.setText("272.50");
				sssCon = 272.50;
			}
			else if(income >= 7750 && income <= 8249.99){
				sssField.setText("290.70");
				sssCon = 290.70;
			}
			else if(income >= 8250 && income <= 8749.99){
				sssField.setText("308.80");
				sssCon = 308.80;
			}
			else if(income >= 8750 && income <= 9249.99){
				sssField.setText("327.00");
				sssCon = 	327.00;
			}
			else if(income >= 9250 && income <= 9749.99){
				sssField.setText("345.20");
				sssCon = 345.20;
			}
			else if(income >= 9750 && income <= 10249.99){
				sssField.setText("363.30");
				sssCon = 363.30;
			}
			else if(income >= 10250 && income <= 10749.99){
				sssField.setText("381.50");
				sssCon = 381.50;
			}
			else if(income >= 10750 && income <= 11249.99){
				sssField.setText("399.70");
				sssCon = 399.70;
			}
			else if(income >= 11250 && income <= 11749.99){
				sssField.setText("417.80");
				sssCon = 417.80;
			}
			else if(income >= 11750 && income <= 12249.99){
				sssField.setText("436.00");
				sssCon = 436.00;
			}
			else if(income >= 12250 && income <= 12749.99){
				sssField.setText("454.20");
				sssCon = 454.20;
			}
			else if(income >= 12750 && income <= 13249.99){
				sssField.setText("472.30");
				sssCon = 472.30;
			}
			else if(income >= 13250 && income <= 13749.99){
				sssField.setText("490.50");
				sssCon = 490.50;
			}
			else if(income >= 13750 && income <= 14249.99){
				sssField.setText("508.70");
				sssCon = 508.70;
			}
			else if(income >= 14250 && income <= 14749.99){
				sssField.setText("526.80");
				sssCon = 526.80;
			}
			else if(income >= 14750 && income <= 15249.99){
				sssField.setText("545.00");
				sssCon = 545.00;
			}
			else if(income >= 15250 && income <= 15749.99){
				sssField.setText("563.20");
				sssCon = 563.20;
			}
			else {
				sssField.setText("581.30");
				sssCon = 581.30;
			}
			
			
			
			
			//PHILHEALTH CONTRIBUTON
			
			if(income <= 10000) {
				philCon = 275.00;
			}
			else if(income >= 10000.01 && income < 39999.99) {
				philCon = income*.0275;
			}
			else {
				philCon = 1100;
				
			}
			philCon = Math.round(philCon*100);
			philCon = philCon/100;
			philField.setText(String.valueOf(philCon));
			
			
			//PAG-IBIIG CONTRIBUTION
			
			if(income < 5000){
				ibigCon = income*.02;
				//ibigCon = Math.round(ibigCon*100);
				//ibigCon = ibigCon/100;
				
				ibigField.setText(String.valueOf(ibigCon));
			}
			else {
				ibigField.setText("100");
				ibigCon = 100;
			}
			
			
			//taxable income
			taxableIncome = income - (sssCon + philCon + ibigCon);
			
			taxableIncome = Math.round(taxableIncome*100);
			taxableIncome = taxableIncome/100;
			
			taxField.setText(String.valueOf(taxableIncome));
			
			
			
			//BIR TAX
			double annualSalary = taxableIncome*12;
			
			if(annualSalary <= 250000) {
				incomeTax = 0;
				
			}
			else if(annualSalary >= 250000.01 && annualSalary <= 400000) {
				incomeTax = ((annualSalary - 250000)*.20)/12;
				
			}
			else if(annualSalary >= 400000.01 && annualSalary <= 800000) {
				incomeTax = (30000 + ((annualSalary - 400000)*.25))/12;
				
			}
			else if(annualSalary >= 800000.01 && annualSalary <= 2000000) {
				incomeTax = (130000 + ((annualSalary - 800000)*.30))/12;
				
			}
			else if(annualSalary >= 2000000.01 && annualSalary <= 8000000) {
				incomeTax = (490000 + ((annualSalary - 2000000)*.32))/12;
				
			}
			else {
				incomeTax = (2410000 +((annualSalary - 8000000)*.35))/12;
			}
			
			
			//NET PAY CALCULATION
			
			netPay = taxableIncome  - incomeTax;
			netPay = Math.round(netPay*100);
			netPay = netPay/100;
			netField.setText(String.valueOf(netPay));
			
			
		}
		
		if(e.getSource()==clrButton) {
			incField.setText("");
			sssField.setText("");
			philField.setText("");
			ibigField.setText("");
			taxField.setText("");
			netField.setText("");
				
		}
		
	}

}
