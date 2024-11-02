import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarRace extends JPanel implements ActionListener {
    private Car car1 = new Car();
    private Car car2 = new Car();
    private final int finishLine = 400;
    private Timer timer;

    public CarRace() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(car1.getPosition(), 50, 50, 30); // Carro 1
        g.setColor(Color.RED);
        g.fillRect(car2.getPosition(), 100, 50, 30); // Carro 2
        g.setColor(Color.BLACK);
        g.drawLine(finishLine, 0, finishLine, getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        car1.move();
        car2.move();

        if (car1.getPosition() >= finishLine || car2.getPosition() >= finishLine) {
            timer.stop();
            String winner = car1.getPosition() >= finishLine ? "Carro 1" : "Carro 2";
            JOptionPane.showMessageDialog(this, winner + " venceu a corrida!");
        }

        repaint();
    }
}

