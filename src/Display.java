import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Display implements Runnable {
	
	
	private int tab = -1;
	
	private JFrame window;
	private Container tabs;
	private Container[] screens;
	
	
	public Display ()
	{
		
		window = new JFrame ("Only War Creation Wizard");
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		tabs = new Container();
		screens = new Container[3];
		
		JButton tabButtons[] = new JButton[4];
		tabButtons[0] = new JButton("Main Menu");
		tabButtons[1] = new JButton("Regiment");
		tabButtons[2] = new JButton("Character");
		tabButtons[3] = new JButton("Settings");
		
		//The following looks stupid, but is the only way I know how to do this
		//I would put this in the for loop below, but I can't take the index from display() and put it into actionPerformed()
		tabButtons[0].addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						changeTab(0);
					}
				});
		tabButtons[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changeTab(1);
			}
		});
		tabButtons[2].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changeTab(2);
			}
		});
		tabButtons[3].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changeTab(3);
			}
		});
		
		for (int i=0;i<4;i++)
		{
			tabButtons[i].setBounds(100*i, 0, 100, 100);
			tabs.add(tabButtons[i]);
		}
		
		window.add(tabs);
		
		FileOps settings = new FileOps("settings.cwf");
		
		if (settings.getContents().equals(""))
		{
			firstTimeSetup(settings);
		}
		changeTab(0);
		
		window.setVisible(true);
	}
	
	
	private void changeTab (int newTab)
	{
		if (tab == -1)
		{
			//do nothing
		}
		else
		{
			window.remove(screens[tab]);
		}
		
		window.add(screens[newTab]);
		tab = newTab;
	}
	
	
	private void firstTimeSetup(FileOps settings)
	{
		settings.writeFile("SETTINGS" + '\n' +
				"Regiment Points: 12" + '\n' +
				"Equipment Points: 30" + '\n' +
				"Training/Equipment Doctorines: 2" + '\n' +
				"Characteristic Allocation: Point Buy" + '\n' +
				"Points: 100" + '\n' +
				"Starting Characteristic Score: 20" + '\n' +
				"Natural Characteristic Max: 40" + '\n' +
				/* THIS IS WHERE MORE SETTINGS WOULD GO */
				'\n');
	}
	
	
	public void run() 
	{
		
		
	}
	
}
