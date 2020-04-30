package hangman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Gamemenu extends JFrame implements ActionListener
{
    JButton option1;
    JButton option2;
    JButton option3;
    JLabel name;

    public Gamemenu()  
    {
                
        option1=new JButton("Instructions");
        option2=new JButton("Play Game");
        option3=new JButton("Exit");
        name=new JLabel("HANGMAN GAME");
        
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);

        setTitle("Hangman game");
        setSize(300,200);
        setVisible(true);
    }
    
    public void addmenucomponent()
    {
        
        
        GridBagConstraints gc=new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        gc.gridx=0;
        gc.gridy=0;
        gc.weighty=0.1;
        gc.anchor=gc.CENTER;
        add(name,gc);
        
        gc.gridx=0;
        gc.gridy=1;
        gc.fill=gc.HORIZONTAL;
        add(option1,gc);
        
        gc.gridx=0;
        gc.gridy=2;
        gc.fill=gc.HORIZONTAL;
        add(option2,gc);
        
        gc.gridx=0;
        gc.gridy=3;
        gc.fill=GridBagConstraints.HORIZONTAL;
        add(option3,gc);

    }

   
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==option1)
        {
            JOptionPane.showMessageDialog(this, " 1.You can guess the word by clicking the character from the virtual keypad. \n2. You can select a macimum of "
                    + "5 incorrect letters. \n3.Theincorrect guess will be highlighted with red color,and the correct one will be highlighted with green color", "Instruction", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource()==option2)
        {
            Gamewindow obj=new Gamewindow();
            obj.startgame();
        }
        else if(e.getSource()==option3)
        {
            System.exit(0);
        }
        
    }

}
