package HomeworkSpaghetti;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/*
 * LayeredPaneDemo.java requires
 * components/images/dukeWaveRed.gif.
 *
 * The meat of the example is in OurActionListener, where you will find
 * calls to theses methods:
 *   moveToFront()
 *   moveToBack()
 *   setLayer()
 * and in the OurLayeredPane() constructor, where you will find calls to add
 * JComponents to the JLayeredPane.
 */
public class LayeredPaneDemoAfter {

  public static void main(String[] args) {
    OurWindow.run();
  }
}

//============================================================================

class OurWindow extends JFrame {

  public static void run() {
    // Do all Swing manipulation, even initialization, in the event thread.
    SwingUtilities.invokeLater(new Runnable() { public void run() {
      new OurWindow().display();
    }});
  }

  private OurWindow() {
    super("LayeredPaneDemo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new OurContentPane());
  }

  void display() {
    pack();
    setVisible(true);
  }
}

//==============================================================================

class OurContentPane extends JPanel {

  OurContentPane() {
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    final OurLayeredPane layeredPane = new OurLayeredPane();

    add(Box.createRigidArea(new Dimension(0, 10)));
    add(layeredPane.getControlPanel());

    add(Box.createRigidArea(new Dimension(0, 10)));
    add(layeredPane);

    setOpaque(true); // Content panes must be opaque
  }
}

//==============================================================================

class OurLayeredPane extends JLayeredPane {

  OurLayeredPane() {
    setPreferredSize(new Dimension(300, 310));
    setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move Duke"));
    controlPanel = new ControlPanel(new OurActionListener());
    addColoredPanels();
    duke = addDuke();
  }

  private final ControlPanel controlPanel;
  private final JComponent duke;

  enum ActionCommand { Layer, PositionInLayer }

  // These should be in JLayeredPane.
  // 0 is actually the front potition; higher numbers are farther back.
  public static final int FRONT_POSITION =  0;
  // -1 has special meaning; the resulting layer position will be nonnegative.
  public static final int  BACK_POSITION = -1;

  ControlPanel getControlPanel() { return controlPanel; }

  private void addColoredPanels() {
    // Add several overlapping, colored labels to the layered pane
    // using absolute positioning/sizing.
    for (Panel panel : Panel.values()) {
      // Add the component at the specified layer number.
      // Don't try autoboxing here; an int arg will select a different method.
      add(panel.component(), new Integer(panel.ordinal()));
    }
  }

  private JComponent addDuke() {
    // Create and add the Duke to the layered pane.
    final JComponent result = new DukeComponent();
    addMouseMotionListener(new OurMouseMotionListener());
    final int positionAsInt = controlPanel.getSelectedPosition();
    add(result, Panel.getDefault().ordinal(), positionAsInt);
    return result;
  }

  //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

  private class OurMouseMotionListener extends MouseMotionAdapter {

    // Make Duke follow the cursor.
    public void mouseMoved(MouseEvent e) {
      duke.setLocation(DukeComponent.pointingAtDukesToe(e.getX(), e.getY()));
    }
  }

  //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

  private class OurActionListener implements ActionListener {

    // Handle user interaction with the check box and combo box.
    public void actionPerformed(ActionEvent e) {
      final String command = e.getActionCommand();
      final int           layer = controlPanel.getSelectedLayer();
      final int positionInLayer = controlPanel.getSelectedPosition();
      switch (ActionCommand.valueOf(command)) {
      case Layer:
        setLayer(duke, layer, positionInLayer);
        break;
      case PositionInLayer:
        switch (positionInLayer) {
        case FRONT_POSITION:
          moveToFront(duke);
          break;
        case BACK_POSITION:
          moveToBack(duke);
          break;
        default:
          // We don't use this case at all.
          // We show all three cases only because this is a tutorial.
          setLayer(duke, layer, positionInLayer);
        }
        break;
      }
      printPositions();
    }

    private void printPositions() {
      final int layer = getLayer(duke);
      final Panel panel = Panel.values()[layer];
      System.out.println("Positions within layer " + layer + " are now"
                       + " Duke: "        + getPosition(duke)
                       + " Colored box: " + getPosition(panel.component()));
    }
  }
}

//============================================================================

class ControlPanel extends JPanel {

  ControlPanel(ActionListener actionListener) {
    final String title = "Choose Duke's Layer and Position";
    setBorder(BorderFactory.createTitledBorder(title));
    layerList = new LayerListComboBox();
    layerList.addActionListener(actionListener);
    add(layerList);
    inFront = new PositionCheckBox();
    inFront.addActionListener(actionListener);
    add(inFront);
  }

  private final PositionCheckBox inFront;
  private final LayerListComboBox layerList;

  int getSelectedLayer() {
    return layerList.getSelectedIndex();
  }

  int getSelectedPosition() {
    return inFront.getSelectedPosition();
  }
}

//==========================================================================

class LayerListComboBox extends JComboBox {

  LayerListComboBox() {
    super(Panel.namesForUI());
    setSelectedIndex(Panel.getDefault().ordinal());
    setActionCommand(OurLayeredPane.ActionCommand.Layer.name());
  }
}

//==========================================================================

class PositionCheckBox extends JCheckBox {

  PositionCheckBox() {
    super("Front Position in Layer");
    setSelected(true);
    setActionCommand(OurLayeredPane.ActionCommand.PositionInLayer.name());
  }

  int getSelectedPosition() {
    return isSelected()
         ? OurLayeredPane.FRONT_POSITION
         : OurLayeredPane.BACK_POSITION;
  }
}

//============================================================================

class DukeComponent extends JLabel {

  DukeComponent() {
    final ImageIcon dukeIcon = createIcon("images/dukeWaveRed.gif");
    if (dukeIcon != null) {
      setIcon(dukeIcon);
      setBounds(15, 225,
                dukeIcon.getIconWidth(),
                dukeIcon.getIconHeight());
    } else {
      System.err.println("Duke icon not found; using black square instead.");
      setBounds(15, 225, 30, 30);
      setOpaque(true);
      setBackground(Color.BLACK);
    }
  }

  static Point pointingAtDukesToe(int x, int y) {
    return new Point(x - 40, y - 57);
  }

  /** Returns null if the path was invalid. */
  private static ImageIcon createIcon(String path) {
    final java.net.URL imgURL = ColoredPanel.LayeredPaneDemo.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}

//============================================================================

enum Panel {

  Yellow, Magenta, Cyan, Red, Green;

  static Panel    getDefault() { return Cyan; }

  static String[] namesForUI() { return namesForUI; }

  ColoredPanel    component()  { return comps[ordinal()]; }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  private static final ColoredPanel[] comps;
  private static final String[] namesForUI;
  private static final Color[] colors = {
      Color.yellow,
      Color.magenta,
      Color.cyan,
      Color.red,
      Color.green
  };

  static {
    assert colors.length == values().length;
    namesForUI =  new String[values().length];
    makeNamesForUI();
    comps = new ColoredPanel[values().length];
    makeColoredPanels();
  }

  Color getColor() { return colors[ordinal()]; }

  String getName() { return namesForUI[ordinal()]; }

  private static void makeColoredPanels() {
    // Starting at origin, each panel is translated over and down by offset.
    // so the result is a cascade of operlapping panels.
    final Point origin = new Point(10, 20);
    final int offset = 35;

    for (Panel panel : values()) {
      comps[panel.ordinal()] = new ColoredPanel(panel, origin);
      origin.translate(offset, offset);
    }
  }

  private static void makeNamesForUI() {
    for (Panel panel : values()) {
      final int index = panel.ordinal();
      namesForUI[index] = index + ". " + panel.name();
    }
  }
}

//==========================================================================

class ColoredPanel extends JLabel {

  ColoredPanel(Panel panelColor, Point origin) {
    super(panelColor.getName());
    setBackground(panelColor.getColor());
    setForeground(Color.black);
    setVerticalAlignment  (JLabel.TOP);
    setHorizontalAlignment(JLabel.CENTER);
    setOpaque(true);
    setBorder(BorderFactory.createLineBorder(Color.black));
    setBounds(origin.x, origin.y, 140, 140);
  }

  /*
   * LayeredPaneDemo.java requires
   * images/dukeWaveRed.gif.
   */
  public static class LayeredPaneDemo extends JPanel
                               implements ActionListener,
                                          MouseMotionListener {
    private String[] layerStrings = { "Yellow (0)", "Magenta (1)",
                                      "Cyan (2)",   "Red (3)",
                                      "Green (4)" };
    private Color[] layerColors = { Color.yellow, Color.magenta,
                                    Color.cyan,   Color.red,
                                    Color.green };

    private JLayeredPane layeredPane;
    private JLabel dukeLabel;
    private JCheckBox onTop;
    private JComboBox layerList;

    //Action commands
    private static String ON_TOP_COMMAND = "ontop";
    private static String LAYER_COMMAND = "layer";

    //Adjustments to put Duke's toe at the cursor's tip.
    private static final int XFUDGE = 40;
    private static final int YFUDGE = 57;

    public LayeredPaneDemo() {
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

      //Create and load the duke icon.


      final ImageIcon icon = createImageIcon("images/dukeWaveRed.gif");

      //Create and set up the layered pane.
      layeredPane = new JLayeredPane();
      layeredPane.setPreferredSize(new Dimension(300, 310));
      layeredPane.setBorder(BorderFactory.createTitledBorder(
                            "Move the Mouse to Move Duke"));
      layeredPane.addMouseMotionListener(this);

      //This is the origin of the first label added.
      Point origin = new Point(10, 20);

      //This is the offset for computing the origin for the next label.
      int offset = 35;

      //Add several overlapping, colored labels to the layered pane
      //using absolute positioning/sizing.
      for (int i = 0; i < layerStrings.length; i++) {
        JLabel label = createColoredLabel(layerStrings[i],
                                          layerColors[i], origin);
        layeredPane.add(label, new Integer(i));
        origin.x += offset;
        origin.y += offset;
      }

      //Create and add the Duke label to the layered pane.
      dukeLabel = new JLabel(icon);
      if (icon != null) {
        dukeLabel.setBounds(15, 225,
                            icon.getIconWidth(),
                            icon.getIconHeight());
      } else {
        System.err.println("Duke icon not found; using black square instead.");
        dukeLabel.setBounds(15, 225, 30, 30);
        dukeLabel.setOpaque(true);
        dukeLabel.setBackground(Color.BLACK);
      }
      layeredPane.add(dukeLabel, new Integer(2), 0);

      //Add control pane and layered pane to this JPanel.
      add(Box.createRigidArea(new Dimension(0, 10)));
      add(createControlPanel());
      add(Box.createRigidArea(new Dimension(0, 10)));
      add(layeredPane);
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
      java.net.URL imgURL = LayeredPaneDemo.class.getResource(path);
      if (imgURL != null) {
        return new ImageIcon(imgURL);
      } else {
        System.err.println("Couldn't find file: " + path);
        return null;
      }
    }

    //Create and set up a colored label.
    private JLabel createColoredLabel(String text,
                                      Color color,
                                      Point origin) {
      JLabel label = new JLabel(text);
      label.setVerticalAlignment(TOP);
      label.setHorizontalAlignment(CENTER);
      label.setOpaque(true);
      label.setBackground(color);
      label.setForeground(Color.black);
      label.setBorder(BorderFactory.createLineBorder(Color.black));
      label.setBounds(origin.x, origin.y, 140, 140);
      return label;
    }

    //Create the control pane for the top of the frame.
    private JPanel createControlPanel() {
      onTop = new JCheckBox("Top Position in Layer");
      onTop.setSelected(true);
      onTop.setActionCommand(ON_TOP_COMMAND);
      onTop.addActionListener(this);

      layerList = new JComboBox(layerStrings);
      layerList.setSelectedIndex(2); //cyan layer
      layerList.setActionCommand(LAYER_COMMAND);
      layerList.addActionListener(this);

      JPanel controls = new JPanel();
      controls.add(layerList);
      controls.add(onTop);
      controls.setBorder(BorderFactory.createTitledBorder(
                         "Choose Duke's Layer and Position"));
      return controls;
    }

    //Make Duke follow the cursor.
    public void mouseMoved(MouseEvent e) {
      dukeLabel.setLocation(e.getX()-XFUDGE, e.getY()-YFUDGE);
    }
    public void mouseDragged(MouseEvent e) {} //do nothing

    //Handle user interaction with the check box and combo box.
    public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();

      if (ON_TOP_COMMAND.equals(cmd)) {
        if (onTop.isSelected())
          layeredPane.moveToFront(dukeLabel);
        else
          layeredPane.moveToBack(dukeLabel);

      } else if (LAYER_COMMAND.equals(cmd)) {
        int position = onTop.isSelected() ? 0 : 1;
        layeredPane.setLayer(dukeLabel,
                             layerList.getSelectedIndex(),
                             position);
      }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
      //Create and set up the window.
      JFrame frame = new JFrame("LayeredPaneDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      JComponent newContentPane = new LayeredPaneDemo();
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
    }

    public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          createAndShowGUI();
        }
      });
    }
  }
}

//==========================================================================
