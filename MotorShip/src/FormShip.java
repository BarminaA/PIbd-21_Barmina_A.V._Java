import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormShip {

	public JFrame frame;
	private PanelShip panel;
	private Ship ship;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormShip window = new FormShip();
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
	public FormShip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new PanelShip();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(30, 30, 930, 530);
		frame.getContentPane().add(panel);

		JButton buttonCreate = new JButton("Create");
		buttonCreate.setBounds(10, 10, 80, 21);
		frame.getContentPane().add(buttonCreate);
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rnd = new Random();
				ship = new Ship(100 + rnd.nextInt(300), 1000 + rnd.nextInt(2000), Color.darkGray);
				ship.SetPosition(rnd.nextInt(150) + 50, rnd.nextInt(150) + 50, 473, 376);
				panel.AddShip(ship);
				panel.repaint();
			}
		});
		buttonCreate.setVerticalAlignment(SwingConstants.BOTTOM);

		JButton btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ship.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		btnUp.setBounds(974, 552, 45, 45);
		frame.getContentPane().add(btnUp);

		JButton btnDown = new JButton("v");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ship.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		btnDown.setBounds(974, 597, 45, 45);
		frame.getContentPane().add(btnDown);

		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ship.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		btnLeft.setBounds(929, 597, 45, 45);
		frame.getContentPane().add(btnLeft);

		JButton btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ship.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		btnRight.setBounds(1020, 597, 45, 45);
		frame.getContentPane().add(btnRight);
	}
}
