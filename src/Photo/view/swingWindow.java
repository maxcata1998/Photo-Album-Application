package Photo.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Photo.model.Snapshot;

/**
 * The type Swing window.
 */
public class swingWindow extends JFrame {
  private int WIDTH;
  private int HEIGHT;
  private JPanel pinkPanel;
  private JPanel yellowPanel;
  private paint paintPanel;
  private JButton previousButton;
  private JButton selectButton;
  private JButton nextButton;
  private JButton quitButton;
  private Snapshot snapshot;
  private JLabel label;


  /**
   * Instantiates a new Swing window.
   *
   * @param s      the s
   * @param WIDTH  the width
   * @param HEIGHT the height
   */
  public swingWindow(Snapshot s, int WIDTH, int HEIGHT) {
    this.snapshot = s;
    this.setVisible(true);
    this.setSize(WIDTH, HEIGHT);
    super.getContentPane().setBackground(Color.blue);
    setTitle("CS5004 Shapes Photo Album Viewer");
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    label = new JLabel();
    label.setText(this.snapshot.getID());
    label.setOpaque(true);
    label.setBackground(Color.pink);

    paintPanel = new paint(this.snapshot.getShape());

    JPanel yellowPanel = new JPanel();
    yellowPanel.setBackground(Color.orange);
    this.yellowPanel = yellowPanel;

    JButton previousButton = new JButton("<<Prev<<");
    JButton selectButton = new JButton("^^Select^^");
    JButton nextButton = new JButton(">>Next>>");
    JButton quitButton = new JButton("xxQuitxx");

    previousButton.setActionCommand("Prev");
    selectButton.setActionCommand("Select");
    nextButton.setActionCommand("Next");
    quitButton.setActionCommand("Quit");

    yellowPanel.add(previousButton);
    yellowPanel.add(selectButton);
    yellowPanel.add(nextButton);
    yellowPanel.add(quitButton);

    this.add(label, BorderLayout.NORTH);
    this.add(yellowPanel, BorderLayout.SOUTH);
    this.add(paintPanel, BorderLayout.CENTER);
    this.previousButton = previousButton;
    this.nextButton = nextButton;
    this.selectButton = selectButton;
    this.quitButton = quitButton;
  }

  /**
   * Sets action listener.
   *
   * @param listener the listener
   */
  public void setActionListener(ActionListener listener) {
    previousButton.addActionListener(listener);
    selectButton.addActionListener(listener);
    nextButton.addActionListener(listener);
    quitButton.addActionListener(listener);
  }

  /**
   * Reset panel.
   *
   * @param s the s
   */
  public void resetPanel(Snapshot s) {
    this.snapshot = s;
    this.label.setText("<html>" + s.getID() + "<br/>" + s.getDescription() + "</html>");
    this.paintPanel.setRepaint(this.snapshot.getShape());

  }
}
