import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class SniperWindow extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SniperWindow window = new SniperWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public SniperWindow() {

		frame = this;
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 903, 893);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);

		layeredPane = new JLayeredPane();
		layeredPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		layeredPane.setLayout(null);
		layeredPane.setBackground(new Color(0, 128, 0));
		layeredPane.setOpaque(true);
		layeredPane.setBounds(0, 0, 903, 810);
		frame.getContentPane().add(layeredPane);




		JLabel lblNewLabel = new JLabel("");
		layeredPane.setLayer(lblNewLabel, -1);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(339, 0, 233, 836);
		layeredPane.add(lblNewLabel);

		spawn1 = new JLabel("SPAWN1");
		spawn1.setVisible(false);
		layeredPane.setLayer(spawn1, -1);
		spawn1.setBounds(25, 11, 46, 14);
		layeredPane.add(spawn1);

		spawn2 = new JLabel("SPAWN2");
		spawn2.setVisible(false);
		layeredPane.setLayer(spawn2, -1);
		spawn2.setBounds(101, 11, 46, 14);
		layeredPane.add(spawn2);

		spawn3 = new JLabel("SPAWN3");
		spawn3.setVisible(false);
		layeredPane.setLayer(spawn3, -1);
		spawn3.setBounds(181, 11, 46, 14);
		layeredPane.add(spawn3);

		spawn4 = new JLabel("SPAWN4");
		spawn4.setVisible(false);
		layeredPane.setLayer(spawn4, -1);
		spawn4.setBounds(639, 11, 46, 14);
		layeredPane.add(spawn4);

		spawn5 = new JLabel("SPAWN5");
		spawn5.setVisible(false);
		layeredPane.setLayer(spawn5, -1);
		spawn5.setBounds(720, 11, 46, 14);
		layeredPane.add(spawn5);

		spawn6 = new JLabel("SPAWN6");
		spawn6.setVisible(false);
		layeredPane.setLayer(spawn6, -1);
		spawn6.setBounds(792, 11, 46, 14);
		layeredPane.add(spawn6);

		JLabel lblNewLabel_1 = new JLabel("");
		layeredPane.setLayer(lblNewLabel_1, 0);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(440, 0, 24, 810);
		layeredPane.add(lblNewLabel_1);

		gameOverL = new JLabel("Nuke Went Off");
		gameOverL.setVisible(false);
		layeredPane.setLayer(gameOverL, -5);
		gameOverL.setFont(new Font("Rockwell", Font.PLAIN, 42));
		gameOverL.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverL.setBounds(289, 259, 342, 259);
		layeredPane.add(gameOverL);

		Restart = new JLabel("Restart");
		Restart.setVisible(false);
		Restart.setFont(new Font("Rockwell", Font.ITALIC, 34));
		Restart.setHorizontalAlignment(SwingConstants.CENTER);
		Restart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		Restart.setBounds(362, 498, 181, 66);
		layeredPane.add(Restart);

		Exit = new JLabel("Exit");
		Exit = new JLabel("Exit");
		Exit.setVisible(false);
		Exit.setFont(new Font("Rockwell", Font.ITALIC, 34));
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		Exit.setBounds(362, 598, 181, 66);
		layeredPane.add(Exit);

		casualtiesL = new JLabel("Casualties :");
		casualtiesL.setForeground(Color.GRAY);
		casualtiesL.setFont(new Font("Rockwell", Font.PLAIN, 27));
		casualtiesL.setBounds(10, 834, 312, 31);
		frame.getContentPane().add(casualtiesL);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setOpaque(true);
		layeredPane_1.setBackground(new Color(0, 0, 0));
		layeredPane_1.setBounds(672, 830, 188, 47);
		getContentPane().add(layeredPane_1);

		JLabel bomb5 = new JLabel("");
		bomb5.setBackground(Color.GRAY);
		bomb5.setOpaque(true);
		bomb5.setBounds(112, 11, 12, 25);
		layeredPane_1.add(bomb5);

		bomb7 = new JLabel("");
		bomb7.setOpaque(true);
		bomb7.setBackground(Color.GRAY);
		bomb7.setBounds(156, 11, 12, 25);
		layeredPane_1.add(bomb7);

		JLabel bomb6 = new JLabel("");
		bomb6.setOpaque(true);
		bomb6.setBackground(Color.GRAY);
		bomb6.setBounds(134, 11, 12, 25);
		layeredPane_1.add(bomb6);

		JLabel bomb4 = new JLabel("");
		bomb4.setOpaque(true);
		bomb4.setBackground(Color.GRAY);
		bomb4.setBounds(90, 11, 12, 25);
		layeredPane_1.add(bomb4);

		JLabel bomb3 = new JLabel("");
		bomb3.setOpaque(true);
		bomb3.setBackground(Color.GRAY);
		bomb3.setBounds(68, 11, 12, 25);
		layeredPane_1.add(bomb3);

		JLabel bomb2 = new JLabel("");
		bomb2.setOpaque(true);
		bomb2.setBackground(Color.GRAY);
		bomb2.setBounds(46, 11, 12, 25);
		layeredPane_1.add(bomb2);

		JLabel bomb1 = new JLabel("");
		bomb1.setOpaque(true);
		bomb1.setBackground(Color.GRAY);
		bomb1.setBounds(24, 11, 12, 25);
		layeredPane_1.add(bomb1);

		bombDisplay = new ArrayList<>();
		bombDisplay.add(bomb7);
		bombDisplay.add(bomb6);
		bombDisplay.add(bomb5);
		bombDisplay.add(bomb4);
		bombDisplay.add(bomb3);
		bombDisplay.add(bomb2);
		bombDisplay.add(bomb1);

		wind = new Point(0, 0);

		layeredPane.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				System.out.println(bombDisplayCounter);

				if (bombDisplayCounter <= bombDisplay.size() && bombDisplayCounter >0 && shootAble) {

					bombDisplayCounter--;
					bombDisplay.get(bombDisplayCounter).setVisible(false);
					Projectile p = new Projectile(e.getPoint(), wind, speed);
					layeredPane.add(p, Integer.valueOf(2));
					pList.add(p);

					if (bombDisplayCounter == 0) {

						replenish = new Timer();
						TimerTask replenishTask = new TimerTask() {

							@Override
							public void run() {

								try {
									System.out.println(bombDisplayCounter);
									bombDisplay.get(bombDisplayCounter).setVisible(true);
									bombDisplay.get(bombDisplayCounter).setBackground(Color.darkGray);
									bombDisplayCounter++;
									
									frame.repaint();
									shootAble = false;

									if (bombDisplayCounter == 7) {
										replenish.cancel();
										shootAble = true;
										bombDisplay.forEach(d -> d.setBackground(Color.GRAY));
									}

								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						};
						
						replenish.scheduleAtFixedRate(replenishTask, 500, 500);
					}
				}
			}
		});

		// mouse listeners
		layeredPane.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {

				BufferedImage cursorImg = new BufferedImage(2, 2, BufferedImage.TYPE_3BYTE_BGR);
				Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0),
						"blank cursor");

				layeredPane.setCursor(blankCursor);
				layeredPane.repaint();
			}

		});

		layeredPane.addMouseMotionListener(new MouseAdapter() {

			public void mouseMoved(MouseEvent e) {

				if (e.getPoint().equals(null)) {
					MouseLoc = e.getPoint();
				}
			}

		});

		replenish = new Timer();
		TimerTask replenishTask = new TimerTask() {

			@Override
			public void run() {

				try {
					System.out.println(bombDisplayCounter);

					bombDisplayCounter++;
					bombDisplay.get(bombDisplayCounter).setVisible(true);
					frame.repaint();

					if (bombDisplayCounter == 7) {
						replenish.cancel();
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};

		// Timers
		spawn = new Timer("spawn");
		TimerTask spawnTask = new TimerTask() {

			Random r = new Random();

			@Override
			public void run() {
				int q = r.nextInt(3);
				boolean placeAble = true;

				if (q == 1) {
					// long interval = r.nextInt(90) + 100;
					long interval = 1;
					// int y = r.nextInt((70) + 170) * -1;
					int y = -100;
					Point[] locations = { new Point(spawn1.getX(), y), new Point(spawn2.getX(), y),
							new Point(spawn3.getX(), y), new Point(spawn4.getX(), y), new Point(spawn5.getX(), y),
							new Point(spawn6.getX(), y) };

					House h = new House(interval, locations, speed);
					for (House ha : hList) {

						if (ha.getBounds().intersects(h.getBounds())) {
							placeAble = false;
							System.out.println("cannot place");

						}
					}

					if (placeAble) {
						layeredPane.add(h, 1);
						hList.add(h);
					} else {
					}

				}

			}
		};

		spawn.scheduleAtFixedRate(spawnTask, 0, 200);

		Timer delete = new Timer("delete");
		TimerTask deleteTask = new TimerTask() {

			@Override
			public void run() {

				try {
					for (House a : hList) {

						if (a.isReadyToDispose()) {
							layeredPane.remove(a);
							hRemList.add(a);
							frame.repaint();
						}
					}

					hList.removeAll(hRemList);
					hRemList.clear();

					for (Projectile a : pList) {

						if (a.isReadyToDispose()) {
							layeredPane.remove(a);
							pRemList.add(a);
							frame.repaint();
						}
					}

					pList.removeAll(pRemList);
					pRemList.clear();

					repaint();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};

		delete.scheduleAtFixedRate(deleteTask, 0, 1);

		coll = new Timer("collision");

		TimerTask collTask = new TimerTask() {
			@Override

			public void run() {

				try {
					for (House h : hList) {
						for (Projectile p : pList) {
							if (h.getBounds().intersects(p.getBounds())) {
								if (p.isExploding()) {
									collInc++;
									h.setDestroyed();
									if (collInc == 1) {

										totalToll += h.getCasualties();
										// System.out.println("+" + h.getCasualties());

										casualtiesL.setText("Casualties: " + totalToll);

										if (h.getStruct().equals("nuke")) {

											System.out.println("nuke");
											Point loc = h.getLocation();

											JLabel nukeExp = new JLabel();
											nukeExp.setBackground(Color.white);
											nukeExp.setBounds(h.getBounds());
											nukeExp.setOpaque(true);
											nukeExp.setVisible(true);
											Timer nukeExplosion = new Timer("nuke");
											layeredPane.add(nukeExp, Integer.valueOf(4));
											TimerTask nukeExplosionTask = new TimerTask() {

												@Override
												public void run() {

													loc.setLocation(loc.getX(), loc.getY() + speed);
													nukeExp.setLocation((int) h.getX() - nukeExp.getWidth() / 2 + 16,
															(int) h.getY() - nukeExp.getHeight() / 2 + 16);
													Random r = new Random();
													totalToll += r.nextInt(1000) + 600;
													casualtiesL.setText("Casualties: " + totalToll);
													coll.cancel();
													nukeExp.setSize(nukeExp.getWidth() + 1, nukeExp.getWidth() + 1);

													if (nukeExp.getSize().equals(new Dimension(4000, 4000))) {

														nukeExplosion.cancel();
														windTimer.cancel();
														spawn.cancel();

														wind = new Point(0, 0);
														gameOverL.setVisible(true);
														layeredPane.setLayer(gameOverL, 5);

														Restart.setVisible(true);
														layeredPane.setLayer(Restart, 5);
														frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
														Restart.addMouseListener(new MouseAdapter() {
															public void mouseClicked(MouseEvent e) {

																frame.dispose();

																SniperWindow u = new SniperWindow();
																u.setVisible(true);
															}
														});
														Exit.setVisible(true);
														layeredPane.setLayer(Exit, 5);
														frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														Exit.addMouseListener(new MouseAdapter() {
															public void mouseClicked(MouseEvent e) {

																System.exit(0);
															}
														});

													}
												}
											};

											try {
												nukeExplosion.scheduleAtFixedRate(nukeExplosionTask, 0, 1);
											} catch (Exception e) {

												System.out.println("something in nuke thread fucked up");
											}
											;

										}
									}

									h.setDestroyed();
									causeOfDeath = p;
									deadHouse = h;
								}
							}

						}

					}

					if (!pList.contains(causeOfDeath)) {
						collInc = 0;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("something in coll thread fucked up" + e.getCause());

				}
			}

		};

		coll.scheduleAtFixedRate(collTask, 0, 1);
		windTimer = new Timer("wind");

		TimerTask windTask = new TimerTask() {

			Random r = new Random();

			@Override
			public void run() {

				if (pList.isEmpty()) {
					int rand = r.nextInt(4);

					if (rand == 0) {
						int wx = r.nextInt(10) - 5;
						int wy = r.nextInt(10) - 5;
						wind = new Point(wx, wy);
					}
				}
			}
		};
		windTimer.scheduleAtFixedRate(windTask, 0, 100);
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		int resize = 15, startY = 0, startX = 0;
		try {

			startX = (int) layeredPane.getMousePosition().getX() + 16;
			startY = (int) layeredPane.getMousePosition().getY() + 16;

		} catch (Exception e) {
		}

		g2d.setPaint(Color.red);
		g2d.drawLine(startX, startY, (int) (startX + wind.getX() * resize), (int) (startY + wind.getY() * -1 * resize));
	}

	ArrayList<House> hList = new ArrayList<>();
	ArrayList<House> hRemList = new ArrayList<>();
	ArrayList<Projectile> pList = new ArrayList<>();
	ArrayList<Projectile> pRemList = new ArrayList<>();

	Random r;
	Timer windTimer, spawn, coll, replenish;
	ArrayList<JLabel> bombDisplay;

	int bombDisplayCounter = 7;
	boolean shootAble = true;

	Projectile causeOfDeath;
	House deadHouse;
	boolean houseVisible;
	JLayeredPane layeredPane;
	Point wind, MouseLoc;
	int collInc = 0;
	int speed = 3, totalToll;
	public JLabel spawn1, spawn2, spawn3, spawn4, spawn5, spawn6;
	private JLabel casualtiesL, gameOverL, Restart, Exit;
	private JLabel bomb7;
}
