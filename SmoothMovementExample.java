import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmoothMovementExample extends JFrame {
    private int x = 50;
    private int y = 50;
    private int dx = 1;
    private int dy = 10;

    public SmoothMovementExample() {
        setTitle("Smooth Movement Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBall();
                repaint();
            }
        });
        timer.start();
    }

    private void moveBall() {
        x += dx;
        y += dy;

        if (x >= getWidth() - 20 || x <= 0) {
            dx = -dx;
        }

        if (y >= getHeight() - 20 || y <= 0) {
            dy = -dy;
        }
    }//bound

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SmoothMovementExample example = new SmoothMovementExample();
                example.setVisible(true);
            }
        });
    }
}

