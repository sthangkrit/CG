import java.awt.*;
import javax.swing.*;
class  Bresenhem extends JPanel
{
	public static void main(String[] args) 
	{
		 Bresenhem m = new Bresenhem();

    JFrame f=new JFrame();
    f.add(m);
    f.setTitle("Bresenhem");
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
	}
	public void paintComponent(Graphics g)
		{
			
			BresAlgoF(g,100,100,400,200);
			BresAlgoF(g,400,200,100,100);
			BresAlgoF(g,100,100,200,400);
		}
	private void plot(Graphics g, int x, int y)
		{
			g.fillRect(x, y, 3, 3);
		}
	private void BresAlgoF(Graphics g,int x1,int y1,int x2,int y2)
		{
			int dx = x2-x1;
			int dy = y2-y1;
			double m = dy/dx;
			if(m>1)
			{
				if(x1<=x2)
					BresAlgo3(g,x1,y1,x2,y2);
				else
					BresAlgo3(g,x2,y2,x1,y1);
			}
			else if(m<-1)
			{
				if(x1>=x2)
					BresAlgo4(g,x1,y1,x2,y2);
				else
					BresAlgo4(g,x2,y2,x1,y1);
			}
			else if(y2>y1){
					if(x1<=x2)
						BresAlgo(g,x1,y1,x2,y2);
					else
						BresAlgo2(g,x2,y2,x1,y1);
				}
			else{
					if(x1<=x2)
						BresAlgo2(g,x1,y1,x2,y2);
					else
						BresAlgo(g,x2,y2,x1,y1);
				}
		}
	private void BresAlgo(Graphics g,int x1,int y1,int x2,int y2)
		{
			int x = x1;
			int y = y1;
			int dx = x2-x1;
			int dy = y2-y1;
			int D = 2*dy - dx;
				while(x<=x2)
				{
					plot(g,x,y);
					x++;
					if(D >= 0){
						y++;
						D = D - 2 * dx;
					}
					D = D + 2 * dy;
				}
		}
	private void BresAlgo2(Graphics g,int x1,int y1,int x2,int y2)
		{
			int x = x1;
			int y = y1;
			int dx = x2-x1;
			int dy = y2-y1;
			int D = 2*dy + dx;
				while(x<=x2)
				{
					plot(g,x,y);
					x++;
					if(D <= 0){
						y--;
						D = D + 2 * dx;
					}
					D = D + 2 * dy;
				}
		}
		private void BresAlgo3(Graphics g,int x1,int y1,int x2,int y2)
		{
			int x = x1;
			int y = y1;
			int dx = x2-x1;
			int dy = y2-y1;
			int D = 2*dx - dy;
				while(y<=y2)
				{
					plot(g,x,y);
					y++;
					if(D >= 0){
						x++;
						D = D - 2 * dy;
					}
					D = D + 2 * dx;
				}
		}
		private void BresAlgo4(Graphics g,int x1,int y1,int x2,int y2)
		{
			int x = x1;
			int y = y1;
			int dx = x2-x1;
			int dy = y2-y1;
			int D = 2*dx + dy;
				while(y<=y2)
				{
					plot(g,x,y);
					y++;
					if(D <= 0){
						x--;
						D = D + 2 * dy;
					}
					D = D + 2 * dx;
				}
		}
}
