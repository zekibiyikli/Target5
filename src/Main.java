import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	static JFrame frame;
	static JPanel panel;
	static JLabel isim1l,isim2l,result;
	static JTextField isim1tf,isim2tf;
	static JButton start;
	static String isim1,isim2;
	static String [][] values= {
			{"-","-","-","-","-"},
			{"-","-","-","-","-"},
			{"-","-","-","-","-"},
			{"-","-","-","-","-"},
			{"-","-","-","-","-"},
	};
	static int sira1=4,sira2=4,sira3=4,sira4=4,sira5=4;
	static int boyut=100;
	static int sirakimde=0;
	static String kazanan="YOK";
	// bir numara (X) kýrmýzý iki numara(O) yeþil
	static JButton  btn11,btn12,btn13,btn14,btn15,
					btn21,btn22,btn23,btn24,btn25,
					btn31,btn32,btn33,btn34,btn35,
					btn41,btn42,btn43,btn44,btn45,
					btn51,btn52,btn53,btn54,btn55,
					btn1,btn2,btn3,btn4,btn5,restart;
	static JButton[][] btn= {
			{btn11,btn12,btn13,btn14,btn15,},
			{btn21,btn22,btn23,btn24,btn25,},
			{btn31,btn32,btn33,btn34,btn35,},
			{btn41,btn42,btn43,btn44,btn45,},
			{btn51,btn52,btn53,btn54,btn55,},
	};				
	public static void main(String[] args) {
		MainScreen();
	}
	
	public static void MainScreen() {
		frame=new JFrame("Target 5");
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setSize(700,700);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		
		isim1l=new JLabel("1. Ýsim:");
		isim1l.setSize(50,50);
		isim1l.setLocation(50,50);
		panel.add(isim1l);
		
		isim2l=new JLabel("2. Ýsim:");
		isim2l.setSize(50,50);
		isim2l.setLocation(50,100);
		panel.add(isim2l);
		
		isim1tf=new JTextField();
		isim1tf.setSize(100,30);
		isim1tf.setLocation(100,60);
		panel.add(isim1tf);
		
		isim2tf=new JTextField();
		isim2tf.setSize(100,30);
		isim2tf.setLocation(100,110);
		panel.add(isim2tf);
		
		start=new JButton("Baþla");
		start.setSize(200, 45);
		start.setLocation(200,450);
		start.addActionListener(new Action());
		panel.add(start);
		
		frame.add(panel);
		frame.repaint();
	}
	
	public static void start() {
		panel.removeAll();

		btn_tanim();
		
		isim1l=new JLabel("Kýrmýzý olan oyuncu: "+isim1);
		isim1l.setSize(250,50);
		isim1l.setLocation(550,50);
		panel.add(isim1l);
		
		isim2l=new JLabel("Yeþil olan oyuncu:    "+isim2);
		isim2l.setSize(250,50);
		isim2l.setLocation(550,100);
		panel.add(isim2l);
		
		btn1=new JButton("1");
		btn1.setSize(50,50);
		btn1.setLocation(35,525);
		btn1.addActionListener(new Action());
		panel.add(btn1);
		
		btn2=new JButton("2");
		btn2.setSize(50,50);
		btn2.setLocation(135,525);
		btn2.addActionListener(new Action());
		panel.add(btn2);
		
		btn3=new JButton("3");
		btn3.setSize(50,50);
		btn3.setLocation(235,525);
		btn3.addActionListener(new Action());
		panel.add(btn3);
		
		btn4=new JButton("4");
		btn4.setSize(50,50);
		btn4.setLocation(335,525);
		btn4.addActionListener(new Action());
		panel.add(btn4);
		
		btn5=new JButton("5");
		btn5.setSize(50,50);
		btn5.setLocation(435,525);
		btn5.addActionListener(new Action());
		panel.add(btn5);
		
		frame.add(panel);
		frame.repaint();
	}
	
	public static void result() {
		
		panel.removeAll();
		
		btn_tanim();
		
		restart=new JButton("Yeniden Oyna");
		restart.setSize(200,50);
		restart.setLocation(250,600);
		restart.addActionListener(new Action());
		panel.add(restart);

		if(kazanan.equals("YOK")) {
			result=new JLabel("KAZANAN YOK BERABERE");
		}else {
			result=new JLabel("KAZANAN: "+kazanan);
		}
		result.setSize(250,50);
		result.setLocation(250,550);
		panel.add(result);

		frame.add(panel);
		frame.repaint();
	}
	
	public static void btn_tanim() {
		int x=10,y=10;
		for(int i=0;i<btn.length;i++) {
			for(int j=0;j<btn[0].length;j++) {
				btn[i][j]=new JButton("");
				btn[i][j].setSize(boyut,boyut);
				btn[i][j].setLocation(x,y);
				btn[i][j].addActionListener(new Action());
				if(values[i][j].equals("-")) {
					btn[i][j].setBackground(Color.WHITE);
				}
				else if(values[i][j].equals("X")) {
					btn[i][j].setBackground(Color.RED);
				}
				else if(values[i][j].equals("O")) {
					btn[i][j].setBackground(Color.GREEN);
				}
				panel.add(btn[i][j]);
				x+=boyut;
			}
			x=10;
			y+=boyut;
		}
	}
	
	public static void scoreCheck() {
		if(values[0][0].equals("X") && values[0][1].equals("X") && values[0][2].equals("X") && values[0][3].equals("X") && values[0][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][0].equals("O") && values[0][1].equals("O") && values[0][2].equals("O") && values[0][3].equals("O") && values[0][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[1][0].equals("X") && values[1][1].equals("X") && values[1][2].equals("X") && values[1][3].equals("X") && values[1][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[1][0].equals("O") && values[1][1].equals("O") && values[1][2].equals("O") && values[1][3].equals("O") && values[1][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[2][0].equals("X") && values[2][1].equals("X") && values[2][2].equals("X") && values[2][3].equals("X") && values[2][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[2][0].equals("O") && values[2][1].equals("O") && values[2][2].equals("O") && values[2][3].equals("O") && values[2][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[3][0].equals("X") && values[3][1].equals("X") && values[3][2].equals("X") && values[3][3].equals("X") && values[3][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[3][0].equals("O") && values[3][1].equals("O") && values[3][2].equals("O") && values[3][3].equals("O") && values[3][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[4][0].equals("X") && values[4][1].equals("X") && values[4][2].equals("X") && values[4][3].equals("X") && values[4][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[4][0].equals("O") && values[4][1].equals("O") && values[4][2].equals("O") && values[4][3].equals("O") && values[4][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][0].equals("X") && values[1][1].equals("X") && values[2][2].equals("X") && values[3][3].equals("X") && values[4][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][0].equals("O") && values[1][1].equals("O") && values[2][2].equals("O") && values[3][3].equals("O") && values[4][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][4].equals("X") && values[1][3].equals("X") && values[2][2].equals("X") && values[3][1].equals("X") && values[4][0].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][4].equals("O") && values[1][3].equals("O") && values[2][2].equals("O") && values[3][1].equals("O") && values[4][0].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][0].equals("X") && values[1][0].equals("X") && values[2][0].equals("X") && values[3][0].equals("X") && values[4][0].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][0].equals("O") && values[1][0].equals("O") && values[2][0].equals("O") && values[3][0].equals("O") && values[4][0].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][1].equals("X") && values[1][1].equals("X") && values[2][1].equals("X") && values[3][1].equals("X") && values[4][1].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][1].equals("O") && values[1][1].equals("O") && values[2][1].equals("O") && values[3][1].equals("O") && values[4][1].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][2].equals("X") && values[1][2].equals("X") && values[2][2].equals("X") && values[3][2].equals("X") && values[4][2].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][2].equals("O") && values[1][2].equals("O") && values[2][2].equals("O") && values[3][2].equals("O") && values[4][2].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][3].equals("X") && values[1][3].equals("X") && values[2][3].equals("X") && values[3][3].equals("X") && values[4][3].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][3].equals("O") && values[1][3].equals("O") && values[2][3].equals("O") && values[3][3].equals("O") && values[4][3].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(values[0][4].equals("X") && values[1][4].equals("X") && values[2][4].equals("X") && values[3][4].equals("X") && values[4][4].equals("X")) {
			kazanan=isim1;
			result();
		}
		else if(values[0][4].equals("O") && values[1][4].equals("O") && values[2][4].equals("O") && values[3][4].equals("O") && values[4][4].equals("O")) {
			kazanan=isim2;
			result();
		}
		else if(sira1==-1 && sira2==-1 && sira3==-1 && sira4==-1 && sira5==-1) {
			result();
		}
		else {
			start();
		}
	}
	
	static class Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==start){
				 isim1=isim1tf.getText().toUpperCase();
				 isim2=isim2tf.getText().toUpperCase();
					
				 start();
			}
			else if(e.getSource()==btn1) {
				if(sira1>=0 && sira1<=5) {
					if(sirakimde==0) {
						values[sira1][0]="X";
						sirakimde=1;
						sira1--;
					}else {
						values[sira1][0]="O";
						sirakimde=0;
						sira1--;
					}
				}
				scoreCheck();
			}
			else if(e.getSource()==btn2) {
				if(sira2>=0 && sira2<=5) {
					if(sirakimde==0) {
						values[sira2][1]="X";
						sirakimde=1;
						sira2--;

					}else {
						values[sira2][1]="O";
						sirakimde=0;
						sira2--;
					}
				}
				scoreCheck();
			}
			else if(e.getSource()==btn3) {
				if(sira3>=0 && sira3<=5) {
					if(sirakimde==0) {
						values[sira3][2]="X";
						sirakimde=1;
						sira3--;
					}else {
						values[sira3][2]="O";
						sirakimde=0;
						sira3--;
					}
				}
				scoreCheck();
			}
			else if(e.getSource()==btn4) {
				if(sira4>=0 && sira4<=5) {
					if(sirakimde==0) {
						values[sira4][3]="X";
						sirakimde=1;
						sira4--;
					}else {
						values[sira4][3]="O";
						sirakimde=0;
						sira4--;
					}
				}
				scoreCheck();
			}
			else if(e.getSource()==btn5) {
				if(sira5>=0 && sira5<=5) {
					if(sirakimde==0) {
						values[sira5][4]="X";
						sirakimde=1;
						sira5--;
					}else {
						values[sira5][4]="O";
						sirakimde=0;
						sira5--;
					}
				}
				scoreCheck();
			}
			else if(e.getSource()==restart) {
				sira1=4;
				sira2=4;
				sira3=4;
				sira4=4;
				sira5=4;
				for(int i=0;i<values.length;i++) {
					for(int j=0;j<values[0].length;j++) {
						values[i][j]="-";
					}
				}
				kazanan="YOK";
				sirakimde=0;
				isim1="";
				isim2="";
				frame.dispose();
				MainScreen();
			}
		}
	}
}
