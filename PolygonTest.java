import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;
//61050192 
public class PolygonTest<E> extends JPanel {

	public static void main(String[] args) {

		PolygonTest m = new PolygonTest();
		JFrame f = new JFrame();
		f.add(m);
		f.setTitle("Polygon");
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = buffer.createGraphics();

		g2.setColor(Color.white);
		g2.fillRect(0, 0, 600, 600);

		g2.setColor(Color.black);

		int xPoly[] = { 150, 250, 325, 375, 400, 275, 100 };
		int yPoly[] = { 150, 100, 125, 225, 325, 375, 300 };

		// Draw Polygon
		Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
		g2.drawPolygon(poly);

//		g.drawImage(buffer, 0, 0, null);
		
		// Fill Color
		buffer = Floodfill(buffer, 200, 150, Color.WHITE, Color.GREEN);

		g.drawImage(buffer, 0, 0, null);

	}

	public BufferedImage Floodfill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		int rgb = replacement_colour.getRGB();  //Convert Color to int 

		
		m.setRGB(x, y, rgb);
		
		qx.add(x);
		qy.add(y);



		while (!qx.isEmpty()) {
			Integer	current_nodeX = qx.remove();
			Integer current_nodeY = qy.remove();

//			System.out.println(rgb);
			
			Color south = new Color(m.getRGB(current_nodeX, current_nodeY +1), true);
			Color north = new Color(m.getRGB(current_nodeX, current_nodeY -1), true);
			Color east = new Color(m.getRGB(current_nodeX + 1, current_nodeY ), true);
			Color west = new Color(m.getRGB(current_nodeX - 1, current_nodeY ), true);
					
//			System.out.println(target_colour)
//			System.out.println("replace " + replacement_colour);

//			System.out.println(south);
//			System.out.println(target_colour);
			if (south.equals(target_colour)) {
				m.setRGB(current_nodeX, current_nodeY + 1, rgb);
//				System.out.println("111");
				qx.add(current_nodeX);
				qy.add(current_nodeY + 1);
			}
			if (north.equals(target_colour)) {
				m.setRGB(current_nodeX, current_nodeY - 1, rgb);
//				System.out.println("222");
				qx.add(current_nodeX);
				qy.add(current_nodeY - 1);

			}
			if (east.equals(target_colour)) {
				m.setRGB(current_nodeX + 1, current_nodeY, rgb);
//				System.out.println("333");
				qx.add(current_nodeX + 1);
				qy.add(current_nodeY);

			}
			if (west.equals(target_colour)) {
				m.setRGB(current_nodeX -1, current_nodeY, rgb);
//				System.out.println("444");
				qx.add(current_nodeX - 1);
				qy.add(current_nodeY);
			}
		}
		return m;
	}

	

}
