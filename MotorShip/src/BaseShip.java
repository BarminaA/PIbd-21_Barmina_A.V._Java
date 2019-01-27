import java.awt.Color;
import java.awt.Graphics;

public class BaseShip extends Vehicle {
	private int shipWidth = 100;
	private int shipHeight = 80;
	public Color MainColor;

	public BaseShip(int maxSpeed, float weight, Color mainColor) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
	}

	@Override
	public void MoveTransport(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - shipWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - shipHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	@Override
	public void DrawShip(Graphics g) {
		int PosX = (int) _startPosX;
		int PosY = (int) _startPosY;
		g.setColor(MainColor);
		g.drawLine(PosX + 40, PosY - 20, PosX + 130, PosY - 20);
		g.drawLine(PosX + 60, PosY + 10, PosX + 110, PosY + 10);
		g.drawLine(PosX + 60, PosY + 10, PosX + 40, PosY - 20);
		g.drawLine(PosX + 130, PosY - 20, PosX + 110, PosY + 10);

		g.drawRect(PosX + 60, PosY - 40, 50, 20);
		g.drawRect(PosX + 70, PosY - 55, 10, 15);
		g.drawRect(PosX + 90, PosY - 55, 10, 15);

		g.drawOval(PosX + 80, PosY - 35, 10, 10);
		g.drawOval(PosX + 60, PosY - 35, 10, 10);
		g.drawOval(PosX + 100, PosY - 35, 10, 10);
		g.drawOval(PosX + 50, PosY - 15, 10, 10);
		g.drawOval(PosX + 70, PosY - 15, 10, 10);
		g.drawOval(PosX + 90, PosY - 15, 10, 10);
		g.drawOval(PosX + 110, PosY - 15, 10, 10);

		g.fillOval(PosX + 80, PosY - 35, 10, 10);
		g.fillOval(PosX + 60, PosY - 35, 10, 10);
		g.fillOval(PosX + 100, PosY - 35, 10, 10);
		g.fillOval(PosX + 50, PosY - 15, 10, 10);
		g.fillOval(PosX + 70, PosY - 15, 10, 10);
		g.fillOval(PosX + 90, PosY - 15, 10, 10);
		g.fillOval(PosX + 110, PosY - 15, 10, 10);
	}
}
