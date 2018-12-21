import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelShip extends JPanel{
	private Ship ship;
	
	public void AddShip(Ship ship) {
		this.ship = ship;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (ship != null) 
		{
			ship.DrawShip(g);
		}
	}
}
