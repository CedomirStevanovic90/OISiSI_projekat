package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(10,23));
		JLabel labela = new JLabel("  Studentska služba");
		
		DateFormat timeFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy.  ");
		
		String currentTime = timeFormat.format(Calendar.getInstance().getTime());
		JLabel timeLabela = new JLabel(currentTime);
		
		
		ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date(System.currentTimeMillis());
                String time = timeFormat.format(date);
                timeLabela.setText(time);
            }
        };
		
        Timer timer = new Timer(0, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        
        
        
        
		labela.setFont(labela.getFont().deriveFont(16f));
		timeLabela.setFont(labela.getFont().deriveFont(16f));
		labela.setForeground(Color.BLACK);
		timeLabela.setForeground(Color.BLACK);
		
		
		add(labela,BorderLayout.WEST);
		add(timeLabela,BorderLayout.EAST);
		setBackground(new Color(175, 175, 175));
	}
}
