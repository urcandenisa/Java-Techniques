import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Board extends JPanel{
	
	int [][]board;
	int startPosX=10;
	int startPosY=10;
	JLabel label;
	BufferedImage treeImage=null;
	BufferedImage chimneyImage=null;
	BufferedImage santaImage=null;
	
	
	public Board()
	{
		
		board= new int[][]
				{
					{1,-1,1,-1,1},
					{1,-1,1,1,-1},
					{1,1,-1,1,1},
					{-1,1,1,1,1,1},
					{-1,-1,1,-1,1},
					{1,-1,1,-1,1},
					{1,-1,1,-1,1}
				
				};
				
		try
		{
			treeImage=ImageIO.read(new File("D:\\Java workspace\\SantaTracking\\src\\img.png"));
			chimneyImage=ImageIO.read(new File("D:\\Java workspace\\SantaTracking\\src\\img3.png"));
			santaImage=ImageIO.read(new File("D:\\Java workspace\\SantaTracking\\src\\img2.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		g2.setPaint(Color.LIGHT_GRAY);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		int startRow = 0, startCol = 0;
		
		for( int row = 0; row < 5; row++)
		{
			startRow=0;
			for(int col = 0; col <7; col++)
			{
	
				if(row==2 && col==4)
				{
					g2.drawImage(chimneyImage,row + 10 + startRow, col + startCol+ 10, null);
				}
				else
				if(board[row][col]>0)
				{
					g2.fillRoundRect(row + 10 + startRow, col + startCol+ 10, 100, 100, 10, 10);
							
				}
				else
				{
					g2.drawImage(treeImage,row + 10 + startRow, col + startCol+ 10 ,null);
				}
				
				//g2.drawImage(santaImage, startPosX, startPosY, null);
				startRow+=103;
			}
			startCol+=103;
		}
	}
	
	public static void main(String[] args)
	{
		Board v=new Board();
	}
}
