import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Second extends JPanel implements ActionListener, KeyListener {

	Timer t = new Timer(5, this);// every 5 seconds
	int x = 50;
	int y = 40;
	int velx = 0;
	int vely = 0;
	int colx = 0;
	int coly = 0;
	int xPos=2;//(int)Math.random()*(4-0+1);
	int yPos=4;//(int)Math.random()*(6-0+1);
	boolean down = false;
	boolean up = false;
	boolean right = false;
	boolean left = false;
	int[][] board;
	int[][] collision;
	ImageIcon treeImage;
	BufferedImage chimneyImage = null;
	BufferedImage santa = null;
	ImageIcon icon;

	public Second() {

		t.start();
		
		this.resetGame();
		icon = new ImageIcon("santa-claus.png");
		treeImage=new ImageIcon("christmas-tree.png");
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		board = new int[][] { { 1, -1, 1, -1, 1, -1, 1, -1 }, { 1, -1, 1, 1, -1, 1, 1, 1 },
				{ 1, 1, -1, 1, 1, 1, -1, 1 }, { -1, 1, 1, 1, 1, 1, 1, 1, 1 }, { -1, -1, 1, -1, 1, -1, -1, -1 }

		};
		collision = new int[5][8];
		try {
			
			chimneyImage = ImageIO.read(new File("D:\\Java workspace\\SantaTracking\\src\\img3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		down = false;
		up = false;
		right = false;
		left = false;

		g2.setPaint(Color.LIGHT_GRAY);

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		int startRow = 0, startCol = 0;
	

		for (int row = 0; row < 5; row++) {
			startRow = 0;
			for (int col = 0; col < 7; col++) {
					if (row == xPos && col == yPos) {
					g2.drawImage(chimneyImage, row + 30 + startRow, col + startCol + 10, null);
					collision[row][col] = 0;
				} else if (board[row][col] > 0) {
					g2.fillRoundRect(row + 30 + startRow, col + startCol + 10, 100, 100, 10, 10);
					collision[row][col] = 0;

				} else {
					// g2.drawImage(treeImage,row + 30 + startRow, col + startCol+ 10 ,null);
					treeImage.paintIcon(this, g2, row + 45 + startRow, col + startCol+ 25);
					collision[row][col] = 1;
				}

				// g2.drawImage(santaImage, startPosX, startPosY, null);
				startRow += 103;
			}
			startCol += 103;
		}

		// g2.fill(new Ellipse2D.Double(x, y, 40, 40));

		// g2.drawImage(santa,(int)x,(int)y, null);

		/*
		 * for(int i=0;i<5;i++) { for(int j=0;j<8;j++) System.out.print(collision[i][j]+
		 * " "); System.out.println(); }
		 */
		icon.paintIcon(this, g2, (int) x, (int) y);

	}

	public boolean isCollision() {
		 
		if(isInside()==true)
		if (collision[colx][coly] == 1)
			return true;
		return false;

	}

	public boolean isInside() {
		if (colx <= 4 && colx >= 0 && coly >= 0 && coly <= 6)
			return true;
		return false;
	}

	public boolean win() {
		if (colx == xPos && coly == yPos)
			return true;
		return false;
	}
	

	
	public void resetGame()
	{
		xPos=(int)(Math.random()*(4-0+1));
		yPos=(int)(Math.random()*(6-0+1));
		x=50;
		y=40;
		velx=0;
		colx=0;
		vely=0;
		coly=0;
		repaint();
	}
	public void actionPerformed(ActionEvent e) {

		t.stop();
		
		if(this.isInside()==true) {
		if (isCollision() == false) {

			System.out.println(colx + " " + coly);
			x += velx;
			y += vely;
			repaint();
			if(win()==true)
			{
				System.out.println("WIN");
				JOptionPane.showMessageDialog(this,"Congratulation! YOU WON","",JOptionPane.INFORMATION_MESSAGE,icon);
				this.resetGame();

				
				
			}
		} else {

			System.out.println("COLLISION " + colx + " " + coly);
			if (down == true) {
				colx--;
				down = false;
			} else if (up == true) {
				colx++;
				up = false;
			} else if (left == true) {
				coly++;
				left = false;
			} else if (right == true) {
				coly--;
				right = false;
			}
			System.out.println(colx + " " + coly);
			// repaint();

		}
		}
		else
			System.out.println("OUT");
		
	}

	public void up() {
		up = true;
		colx--;
		if (isInside()) {
			if (isCollision() == false) {
				vely = -100;
				velx = 0;
			}
		} else {
			up = false;
			vely = 0;
			velx = 0;
			colx = 0;
		}
	}

	public void down() {
		down = true;
		colx++;
		if (isInside()) {
			if (isCollision() == false) {
				vely = 100;
				velx = 0;
			}
		} else {
			down = false;
			colx = 4;
			velx = 0;
			vely = 0;
		}

	}

	public void left() {
		left = true;
		coly--;
		if (isInside()) {
			if (isCollision() == false) {
				velx = -100;
				vely = 0;
			}
		} else {
			left = false;
			coly = 0;
			velx = 0;
			vely = 0;
		}
	}

	public void right() {
		right = true;
		coly++;
		if (isInside()) {
			if (isCollision() == false) {
				velx = 100;
				vely = 0;
			}
		} else {
			coly--;
			velx = 0;
			vely = 0;
			right = false;
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		t.stop();
		if (code == KeyEvent.VK_UP) {

			t.start();
			up();
		}
		if (code == KeyEvent.VK_DOWN) {

			t.start();
			down();
		}
		if (code == KeyEvent.VK_LEFT) {

			t.start();
			left();
		}
		if (code == KeyEvent.VK_RIGHT) {

			t.start();
			right();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		t.stop();
		if (code == KeyEvent.VK_UP)
			t.stop();
		if (code == KeyEvent.VK_DOWN)
			t.stop();
		if (code == KeyEvent.VK_LEFT)
			t.stop();
		if (code == KeyEvent.VK_RIGHT)
			t.stop();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
