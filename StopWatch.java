import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds =0;
	int minutes =0;
	int hours =0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
    }
	
	Timer timer = new Timer(1000, new ActionListener() {
		
                @Override
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime=elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			
		}
		
	});
	
	
	StopWatch(){
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(85,75,230,125);
		timeLabel.setFont(new Font("Times New Roman",Font.BOLD,50));
        timeLabel.setForeground(Color.green);
        timeLabel.setBackground(Color.black);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(85,200,115,50);
		startButton.setFont(new Font("Times New Roman",Font.BOLD,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200,200,115,50);
		resetButton.setFont(new Font("Times New Roman",Font.BOLD,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(420,420);

		frame.setTitle("STOP-WATCH");
		
		frame.setFocusable(false);
        frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			
			if(started==false) {
				started=true;
				startButton.setText("STOP");
				start();
			}
			else {
				started=false;
				startButton.setText("START");
				stop();
			}
			
		}
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("START");
			reset();
		}
		
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		elapsedTime=0;
		seconds =0;
		minutes=0;
		hours=0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}
}
