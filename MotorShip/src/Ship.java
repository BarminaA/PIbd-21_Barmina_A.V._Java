import java.awt.Color;
import java.awt.Graphics;

public class Ship extends BaseShip {
	private int shipWidth = 100;
	private int shipHeight = 80;
	public Color MainColor;
	public Color DopColor;
	public boolean Tube;
	public boolean Window;

	public Ship(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean tube, boolean window) {
		super(maxSpeed, weight, mainColor);
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;
		Tube = tube;
		Window = window;
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

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

		if (Window) {
			g.setColor(DopColor);
			g.fillOval(PosX + 80, PosY - 35, 10, 10);
			g.fillOval(PosX + 60, PosY - 35, 10, 10);
			g.fillOval(PosX + 100, PosY - 35, 10, 10);
			g.fillOval(PosX + 50, PosY - 15, 10, 10);
			g.fillOval(PosX + 70, PosY - 15, 10, 10);
			g.fillOval(PosX + 90, PosY - 15, 10, 10);
			g.fillOval(PosX + 110, PosY - 15, 10, 10);
		}
		if (Tube) {
			g.setColor(DopColor);
			g.fillOval(PosX + 50, PosY - 65, 15, 10);
			g.fillOval(PosX + 55, PosY - 60, 15, 10);
			g.fillOval(PosX + 70, PosY - 65, 15, 10);
			g.fillOval(PosX + 75, PosY - 60, 15, 10);
		}
	}
}
