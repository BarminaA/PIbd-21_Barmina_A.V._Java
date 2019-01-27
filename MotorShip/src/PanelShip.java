import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelShip extends JPanel{
	private ITransport ship;
	
	public void AddShip(ITransport ship2) {
		this.ship = ship2;
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
