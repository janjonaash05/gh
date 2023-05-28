import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class House extends JLabel {

	private boolean destroyed, ready, readyToDispose, killing, houseVisible;

	private int casualties;
	private	String struct;
	private int speed = 2;
	private	long waitTime;
	int a;
	int hp;
	
	public void setDestroyed() {
	
		destroyed = true;
		
	}
	
	

	public int getCasualties() {
		return casualties;
	}


	public boolean isDestroyed() {
		return destroyed;
	}
	public boolean isKilling() {
		return killing;
	}

	public boolean isReadyToDispose() {
		return readyToDispose;
	}
private Point[] Locations;

	public House(long waitTime, Point[] locs, int speed) {
		
		ready = false;
		destroyed = false;
		a = 0;
		Locations = locs;
		this.waitTime = waitTime;
		Timer wait = new Timer("housewait");
		TimerTask waitTask = new TimerTask() {

			@Override
			public void run() {
				ready = true;
				if(ready) {spawn();} //works for some reason
			}
		};
		
		
		wait.schedule(waitTask, waitTime);
		
		
	}
	Timer move, check;
	public int getA() {return a;}
		
		
		void spawn() {
			readyToDispose = false;
		

			//System.out.println("spawn" + waitTime);
			
			String[] Structures = { "school", "nuke", "military", "regular" };

			int inY = -80;

			 

			Random r = new Random();
			this.setLocation(Locations[r.nextInt(Locations.length)]);
			this.setOpaque(true);
			
	this.setVisible(true);
			

			struct = Structures[r.nextInt(Structures.length)];

			switch (getStruct()) {

			case "school":
				Dimension[] schoolSizes = { new Dimension(80, 40), new Dimension(40, 80) };
				Color[] schoolColors = { Color.lightGray, new Color(255, 140, 0), new Color(188, 74, 60) };
				this.setSize(schoolSizes[r.nextInt(schoolSizes.length)]);
				this.setBackground(schoolColors[r.nextInt(schoolColors.length)]);

				casualties = r.nextInt(600) + 300;
				break;

			case "nuke":
				Dimension[] nukeSizes = { new Dimension(200, 100), new Dimension(100, 200) };
				Color nukeColor = new Color(0, 100, 0);
				this.setSize(nukeSizes[r.nextInt(nukeSizes.length)]);
				this.setBackground(nukeColor);

				casualties = r.nextInt(1000) + 6000;
				break;

			case "military":
				Dimension[] militarySizes = { new Dimension(100, 80), new Dimension(80, 100) };
				Color militaryColors[] = { new Color(114, 107, 104), new Color(178, 172, 171), };
				this.setSize(militarySizes[r.nextInt(militarySizes.length)]);
				this.setBackground(militaryColors[r.nextInt(militaryColors.length)]);
			//	this.setBorder(new LineBorder(Color.RED));
				casualties = r.nextInt(20) + 10;

				break;
			case "regular":
				Dimension[] regularSizes = { new Dimension(60, 60), new Dimension(80, 80) };
				Color regularColors[] = { new Color(129, 146, 152), new Color(70, 52, 36), new Color(137, 70, 70) };
				this.setSize(regularSizes[r.nextInt(regularSizes.length)]);
				this.setBackground(regularColors[r.nextInt(regularColors.length)]);
				
				casualties = r.nextInt(10) + 1;

				break;

			}
			 move = new Timer("housemove");
			TimerTask moveTask = new TimerTask() {

				@Override
				public void run() {
					setLocation(getX(), getY() + speed);
					
					
					if(getY() > 900) { readyToDispose = true; move.cancel(); check.cancel();}
				}
			};

			move.scheduleAtFixedRate(moveTask, 0, 10);
			
			 check = new Timer("housecheck");
			TimerTask checkTask = new TimerTask() {
				@Override
				public void run() {
					if(destroyed) {
						a++;
					//	if(a< 3) {System.out.println(a);}
						setBackground(Color.black);
						
					}
				}};
				
				check.scheduleAtFixedRate(checkTask, 0, 1);
		}



		public String getStruct() {
			return struct;
		}

		}


