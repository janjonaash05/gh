import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Projectile extends JLabel {

	private boolean readyToDispose;
	private boolean exploding;
	private int expT = 0;

	boolean killing;
	int a;

	public boolean isKilling() {
		return killing;
	}

	private Point wind;

	public boolean isReadyToDispose() {
		return readyToDispose;
	}

	public boolean isExploding() {
		return exploding;
	}

	public Projectile(Point loc, Point w, int speed) {

		wind = w;
		readyToDispose = false;
		exploding = false;

		this.setSize(40, 80);
		this.setLocation((int) loc.getX() - this.getWidth() / 2 + 16, (int) loc.getY() - this.getHeight() / 2 + 16);
		this.setOpaque(true);
		this.setBackground(Color.gray);

		Timer move = new Timer("proj");

		TimerTask moveTask = new TimerTask() {

			@Override
			public void run() {

				loc.setLocation(loc.getX() + wind.getX(), loc.getY() - wind.getY());

				setSize(getWidth() - 1, getHeight() - (getHeight() / getWidth()));
				setLocation((int) loc.getX() - getWidth() / 2 + 16, (int) loc.getY() - getHeight() / 2 + 16);

				Dimension size = new Dimension(8, 16);

				if (getSize().equals(size)) {

					move.cancel();
					exploding = true;

					Timer moveDown = new Timer();

					TimerTask moveDownTask = new TimerTask() {

						@Override
						public void run() {
							expT++;
							loc.setLocation(loc.getX(), loc.getY() + speed);
							setLocation(getX(), getY() + speed);
							
							setLocation((int) loc.getX() - getWidth() / 2 + 16,
									(int) loc.getY() - getHeight() / 2 + 16);

						}

					};

					moveDown.scheduleAtFixedRate(moveDownTask, 100, 10);

				}
			}

		};

		move.scheduleAtFixedRate(moveTask, 0, 30);

		Timer checkDes = new Timer("proj checkdes");
		TimerTask checkDesTask = new TimerTask() {

			int chunk = 7;
			int width_phase1 = getWidth() + 10;

			@Override
			public void run() {

				if (exploding) {
					a++;
					
					if (a > 1 && a < chunk) {
						setSize(getWidth() + 1, getWidth() + 1);
						setBackground(Color.yellow);
					}
					if (a > chunk && a < chunk * 2) {
						setSize(getWidth() + 1, getWidth() + 1);
						setBackground(Color.orange);
					}
					if (a > chunk * 2 && a < chunk * 3) {
						setSize(getWidth() + 1, getWidth() + 1);
						setBackground(Color.red);
					}

					if (a > chunk * 3 && a < chunk * 4) {
						setSize(getWidth() - 2, getWidth() - 2);
						setBackground(Color.red);
					}
					if (a > chunk * 4 && a < chunk * 5) {
						setSize(getWidth() - 2, getWidth() - 2);
						setBackground(Color.orange);
					}
					if (a > chunk * 5 && a < chunk * 6) {
						setSize(getWidth() - 2, getWidth() - 2);
						setBackground(Color.yellow);
					}

					
					if (a > chunk * 6) {
						setBackground(Color.black);
						checkDes.cancel();
						readyToDispose = true;

					}
				}

			}
		};

		checkDes.scheduleAtFixedRate(checkDesTask, 0, 10);

	}
}
