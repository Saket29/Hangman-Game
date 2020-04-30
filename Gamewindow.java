package hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Gamewindow extends JFrame implements ActionListener
{
    JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    JLabel jlmessage,jlword;
    
    JPanel keys1,keys2,keys3,screen,notify,keypad;

    String words[]={"saket","sanjay","sanika","parineeta"};
    Random rd=new Random();
    int flag,rnd,count,len,chance=5;
    StringBuilder blanks=new StringBuilder();
        
    public Gamewindow()
    {
         a=new JButton("A");
         b=new JButton("B");
         c=new JButton("C");
         d=new JButton("D");
         e=new JButton("E");
         f=new JButton("F");
         g=new JButton("G");
         h=new JButton("H");
         i=new JButton("I");
         j=new JButton("J");
         k=new JButton("K");
         l=new JButton("L");
         m=new JButton("M");
         n=new JButton("N");
         o=new JButton("O");
         p=new JButton("P");
         q=new JButton("Q");
         r=new JButton("R");
         s=new JButton("S");
         t=new JButton("T");
         u=new JButton("U");
         v=new JButton("V");
         w=new JButton("W");
         x=new JButton("X");
         y=new JButton("Y");
         z=new JButton("Z");
       
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
        h.addActionListener(this);
        i.addActionListener(this);
        j.addActionListener(this);
        k.addActionListener(this);
        l.addActionListener(this);
        m.addActionListener(this);
        n.addActionListener(this);
        o.addActionListener(this);
        p.addActionListener(this);
        q.addActionListener(this);
        r.addActionListener(this);
        s.addActionListener(this);
        t.addActionListener(this);
        u.addActionListener(this);
        v.addActionListener(this);
        w.addActionListener(this);
        x.addActionListener(this);
        y.addActionListener(this);
        z.addActionListener(this);
       
        jlmessage=new JLabel("Guess a Name");
        jlword=new JLabel();
        
        notify=new JPanel();
        notify.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        
        screen=new JPanel();
        screen.setBackground(Color.WHITE);
        screen.setSize(0, 200);
        
        keypad=new JPanel();
        keypad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        keypad.setBackground(Color.black);
        
        keys1=new JPanel();
        keys1.setBackground(Color.BLACK);
        
        keys2=new JPanel();
        keys2.setBackground(Color.BLACK);
        
        keys3=new JPanel();
        keys3.setBackground(Color.BLACK);
        
        setTitle("Hangman Game");
        setSize(500,400);
        setVisible(true);
                    
    }
    
    public void addgamecomponent()
    {
        GridBagConstraints gc=new GridBagConstraints();
        
        notify.setLayout(new FlowLayout());
        notify.add(jlmessage);
        
        screen.setLayout(new GridBagLayout());
        screen.add(jlword, gc);
        
        keypad.setLayout(new GridBagLayout());
        
        keys1.setLayout(new FlowLayout());
        keys1.add(q);
        keys1.add(w);
        keys1.add(e);
        keys1.add(r);
        keys1.add(t);
        keys1.add(y);
        keys1.add(u);
        keys1.add(i);
        keys1.add(o);
        keys1.add(p);
        
        gc.gridx=0;       
        gc.gridy=0;
        keypad.add(keys1, gc);
        
        keys2.setLayout(new FlowLayout());
        keys2.add(a);
        keys2.add(s);
        keys2.add(d);
        keys2.add(f);
        keys2.add(g);
        keys2.add(h);
        keys2.add(j);
        keys2.add(k);
        keys2.add(l);
        
        gc.gridx=0;
        gc.gridy=1;
        keypad.add(keys2, gc);
        
        keys3.setLayout(new FlowLayout());
        keys3.add(z);
        keys3.add(x);
        keys3.add(c);
        keys3.add(v);
        keys3.add(b);
        keys3.add(n);
        keys3.add(m);
        
        gc.gridx=0;
        gc.gridy=2;
        keypad.add(keys3, gc);
        
        setLayout(new BorderLayout());
        add(notify, BorderLayout.NORTH);
        add(screen, BorderLayout.CENTER);
        add(keypad, BorderLayout.SOUTH);
        
    }
   
    public void startgame()
    {
    	int qo=1;
        addgamecomponent();
        rnd=rd.nextInt(4);
        len=words[rnd].length();
        
        if(qo==1)
        {
        for (int j = 0; j < len; j++)
        {
            blanks.append("_ ");
        }
        qo++;
        jlword.setText(blanks.toString());
        }
    }
    
   
    

    public void actionPerformed(ActionEvent ae)
    {
        JButton jb=(JButton) ae.getSource();
        String letter=ae.getActionCommand();
        flag=0;
        
        for (int i = 0; i < len; i++) 
        {
            if(letter.toLowerCase().charAt(0)==words[rnd].charAt(i))
            {
            flag=1;
            blanks.replace((i*2), ((i*2)+1), letter);
            count++;
            }
        }
        if(flag==1)
        {
            jlword.setText(blanks.toString());
            jb.setBackground(Color.GREEN);
            jb.setEnabled(false);
        }
        else
        {
        	chance--;
        	if(chance != 0)
        	{
        		JOptionPane.showMessageDialog(this, "Wrong guess\nOnly "+chance+" lifes left");
        	}
            jb.setBackground(Color.RED);
            jb.setEnabled(false);
            
        }
        
        if(count==len)
        {
            JOptionPane.showMessageDialog(this, "Congrats You Guessed the Word Correctly");
            int n=JOptionPane.showConfirmDialog(this, "Do you want to play again?","Restart Game", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(n==JOptionPane.YES_OPTION)
            {
                Gamewindow obj=new Gamewindow();
                obj.startgame();
                this.dispose();
            }
            else
            {
                this.dispose();
                Gamemenu obj=new Gamemenu();
                obj.addmenucomponent();
            }
        }
        
        if(chance<1)
        {
            JOptionPane.showMessageDialog(this, "GAME OVER");
            int n=JOptionPane.showConfirmDialog(this, "Do you want to play again?","Restart Game", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(n==JOptionPane.YES_OPTION)
            {
                Gamewindow obj=new Gamewindow();
                obj.startgame();
                this.dispose();
            }
            else
            {
                this.dispose();
                Gamemenu obj=new Gamemenu();
                obj.addmenucomponent();
            }
        }
    }
}
