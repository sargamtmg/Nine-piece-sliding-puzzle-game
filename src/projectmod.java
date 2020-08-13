import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class projectmod extends JFrame implements ActionListener
{
	 private Label movesLabel=new Label();
	 private Label bestmove=new Label();
	private JButton restart;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,hint,sample;
	private Icon ic1= new ImageIcon(getClass().getClassLoader().getResource("img/1.jpg"));
	private Icon ic2= new ImageIcon(getClass().getClassLoader().getResource("img/2.jpg"));
	private Icon ic3= new ImageIcon(getClass().getClassLoader().getResource("img/3.jpg"));
	private Icon ic4= new ImageIcon(getClass().getClassLoader().getResource("img/4.jpg"));
	private Icon ic5= new ImageIcon(getClass().getClassLoader().getResource("img/5.jpg"));
	private Icon ic6= new ImageIcon(getClass().getClassLoader().getResource("img/6.jpg"));
	private Icon ic7= new ImageIcon(getClass().getClassLoader().getResource("img/7.jpg"));
	private Icon ic8= new ImageIcon(getClass().getClassLoader().getResource("img/8.jpg"));
	private Icon ic9= new ImageIcon(getClass().getClassLoader().getResource("img/9.jpg"));
	private Icon ic10= new ImageIcon(getClass().getClassLoader().getResource("img/9a.jpg"));
	private ImageIcon icon= new ImageIcon(getClass().getClassLoader().getResource("img/hint.jpg"));
	private ImageIcon sam =new ImageIcon(getClass().getClassLoader().getResource("img/sample.jpg"));
	private ImageIcon hurray=new ImageIcon(getClass().getClassLoader().getResource("img/hurray.jpg"));
	private ImageIcon resat=new ImageIcon(getClass().getClassLoader().getResource("img/restart.jpg"));
	 private int moves;
	 private int sc;

	projectmod(){
		setTitle("puzzle");
		setLayout(null);
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		b1=new JButton(ic10);
		b2=new JButton(ic8);
		b3=new JButton(ic9);
		b4=new JButton(ic3);
		b5=new JButton(ic4);
		b6=new JButton(ic7);
		b7=new JButton(ic2);
		b8=new JButton(ic6);
		b9=new JButton(ic5);
		b10=new JButton(ic1);
		hint=new JButton(icon);
		sample=new JButton(sam);
		restart=new JButton(resat);

		


		b1.setBounds(10,200,100,100);
		b2.setBounds(110,200,100,100);
		b3.setBounds(210,200,100,100);

		b4.setBounds(10,300,100,100);
		b5.setBounds(110,300,100,100);
		b6.setBounds(210,300,100,100);

		b7.setBounds(10,400,100,100);
		b8.setBounds(110,400,100,100);
		b9.setBounds(210,400,100,100);

		b10.setBounds(10,100,100,100);
		hint.setBounds(470,10,140,140);
		sample.setBounds(420,150,220,220);
		restart.setBounds(210,30,150,70);
		
		 moves=0;
        movesLabel.setText("Moves: "+moves);
        movesLabel.setBounds(230,120, 150,30);
        Font f=new Font("Forte",Font.BOLD,20);
        movesLabel.setFont(f);
        movesLabel.setForeground(Color.BLUE);


        try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzle","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select score from bestmove where id=2");
				while(rs.next()){
				 sc=rs.getInt("score");
				}
				}catch(Exception ex){
				System.out.println("Exception : "+ex);
				}
        bestmove.setText("bestmove : "+sc);
        bestmove.setBounds(430,400,250,40);
        Font f2=new Font("Forte",Font.BOLD,30);
        bestmove.setFont(f2);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(hint);
		add(sample);
		add(restart);
		add(movesLabel);
		add(bestmove);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		restart.addActionListener(this);
		

	}

	public static void main(String args[])
	{
		projectmod p=new projectmod();
	}


	public void swap(JButton b1,JButton b2)
	{
		Icon t=b1.getIcon();
		b1.setIcon(b2.getIcon());
		b2.setIcon(t);
		moves++;
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(b2.getIcon()==ic10)
			{
				swap(b1,b2);
			}
			else if(b4.getIcon()==ic10)
			{
				swap(b1,b4);
			}
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b2)
		{
			if(b1.getIcon()==ic10)
				swap(b1,b2);
			else if(b3.getIcon()==ic10)
				swap(b2,b3);
			else if(b5.getIcon()==ic10)
				swap(b2,b5);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b3)
		{
			if(b2.getIcon()==ic10)
				swap(b2,b3);
			else if(b6.getIcon()==ic10)
				swap(b3,b6);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b4)
		{
			if(b1.getIcon()==ic10)
				swap(b1,b4);
			else if(b5.getIcon()==ic10)
				swap(b4,b5);
			else if(b7.getIcon()==ic10)
				swap(b7,b4);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b5)
		{
			if(b2.getIcon()==ic10)
				swap(b2,b5);
			else if(b4.getIcon()==ic10)
				swap(b4,b5);
			else if(b6.getIcon()==ic10)
				swap(b5,b6);
			else if(b8.getIcon()==ic10)
				swap(b5,b8);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b6)
		{
			if(b3.getIcon()==ic10)
				swap(b3,b6);
			else if(b5.getIcon()==ic10)
				swap(b6,b5);
			else if(b9.getIcon()==ic10)
				swap(b9,b6);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b7)
		{
			if(b4.getIcon()==ic10)
				swap(b4,b7);
			else if(b8.getIcon()==ic10)
				swap(b8,b7);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b8)
		{
			if(b7.getIcon()==ic10)
				swap(b7,b8);
			else if(b5.getIcon()==ic10)
				swap(b8,b5);
			else if(b9.getIcon()==ic10)
				swap(b9,b8);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==b9)
		{
			if(b8.getIcon()==ic10)
				swap(b8,b9);
			else if(b6.getIcon()==ic10)
				swap(b6,b9);
			 movesLabel.setText("Moves: "+moves);
		}
		else if(e.getSource()==restart)
		{
			b1.setIcon(ic10);
		b2.setIcon(ic8);
		b3.setIcon(ic9);
		b4.setIcon(ic3);
		b5.setIcon(ic4);
		b6.setIcon(ic7);
		b7.setIcon(ic2);
		b8.setIcon(ic6);
		b9.setIcon(ic5);
		b10.setIcon(ic1);
		 moves=0;
		 movesLabel.setText("Moves: "+moves);
		}

		if(b1.getIcon()==ic10 && b2.getIcon()==ic2 && b3.getIcon()==ic3 && b4.getIcon()==ic4 && b5.getIcon()==ic5 && b6.getIcon()==ic6 && b7.getIcon()==ic7 && b8.getIcon()==ic8 && b9.getIcon()==ic9)
			{
				swap(b1,b10);
				moves--;
				try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzle","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select score from bestmove where id=2");
				while(rs.next()){
				int sc=rs.getInt("score");

					if(moves<sc)
					{
						int z=st.executeUpdate("UPDATE bestmove set score="+moves+" where score="+sc);
						bestmove.setText("bestmove : "+moves);
						JOptionPane.showMessageDialog(null,"\tCONGRATULAION !\n\nYOU SCORE BEST MOVES WITH "+moves+" MOVES");
					}
					else{
						JOptionPane.showMessageDialog(null,"You solve the puzzle in "+moves+" moves");
					}
				}
				}catch(Exception ex){
				System.out.println("Exception : "+ex);
				}
			}
	}

}



