import java.awt.*;
import javax.swing.*;

public class Bresenhem extends JPanel {

	public static void main(String[] args) {
		Bresenhem m = new Bresenhem();
		JFrame f = new JFrame();
		f.add(m);
		f.setTitle("Bresenhem1");
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	public void paintComponent(Graphics g) {
//		g.drawLine(100, 100, 200, 400); //check
		BresenhemAlgo(g, 100, 100, 200, 400);
	}

	private void plot(Graphics g, int x, int y) {
		g.fillRect(x, y, 1, 1);
	}

	private void BresenhemAlgo(Graphics g, int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		double m = dy / dx; // หารกันยังไงก็ไม่เป็น0
		int sumy = y2 - y1;
		int sumx = x2 - x1;
		if (m > 1) {
			if (sumx >= 0) {
				SubAlgo3(g, x1, y1, x2, y2);
//				System.out.println("s11");

			} else {
				SubAlgo3(g, x2, y2, x1, y1);
//				System.out.println("s12");
			}

		} else if (m < 0) {
			if (sumx >= 0) {
				SubAlgo4(g, x2, y2, x1, y1);
//				System.out.println("s21");
			} else {
				SubAlgo4(g, x1, y1, x2, y2);
//				System.out.println("s22");
			}
		} else if (sumy >= 0) {
			if (sumx >= 0) {
				SubAlgo1(g, x1, y1, x2, y2);
//				System.out.println("s31");
			} else {
				SubAlgo2(g, x2, y1, x1, y2);
//				System.out.println("s32");
			}

		} else { // if(sumy <0)
			if (sumx >= 0) {
				SubAlgo2(g, x1, y1, x2, y2);
//				System.out.println("s41");
			} else {
				SubAlgo1(g, x2, y2, x1, y1);
//			System.out.println("s42");
			}

		}

	}

	private void SubAlgo1(Graphics g, int x1, int y1, int x2, int y2) {
		int x = x1;
		int y = y1;
		int dx = x2 - x1;
		int dy = y2 - y1;
		int D = 2 * dy - dx;
		while (x <= x2) { //loop x
			plot(g, x, y);
			x++;
			if (D >= 0) {
				y++;
				D = D - 2 * dx;
			}
			D = D + 2 * dy;
		} //loop x
	}

	private void SubAlgo2(Graphics g, int x1, int y1, int x2, int y2) {
		int x = x1;
		int y = y1;
		int dx = x2 - x1;
		int dy = y2 - y1;
		int D = 2 * dy + dx;
		while (x <= x2) {//loop x
			plot(g, x, y);
			x++;
			if (D <= 0) { // D <= 0
				y--;
				D = D + 2 * dx;
			}
			D = D + 2 * dy;
		} //loop x
	}

	private void SubAlgo3(Graphics g, int x1, int y1, int x2, int y2) {
		int x = x1;
		int y = y1;
		int dx = x2 - x1;
		int dy = y2 - y1;
		int D = 2 * dx - dy;
		while (y <= y2) { // loop y
			plot(g, x, y);
			y++;
			if (D >= 0) { 
				x++;
				D = D - 2 * dy;
			}
			D = D + 2 * dx;
		}//loop y
	}

	private void SubAlgo4(Graphics g, int x1, int y1, int x2, int y2) {
		int x = x1;
		int y = y1;
		int dx = x2 - x1;
		int dy = y2 - y1;
		int D = 2 * dx + dy;
		while (y <= y2) { // loop y
			plot(g, x, y);
			y++;
			if (D <= 0) { // D <= 0
				x--;
				D = D + 2 * dy;
			}
			D = D + 2 * dx;
		}//loop y
	}
}
