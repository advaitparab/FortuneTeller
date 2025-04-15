import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea textArea;
    private final ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");

        // 🖥️ Set window size to 3/4 of screen and center it
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);

        // 📐 Layout for GUI parts
        setLayout(new BorderLayout());

        // 🔝 Top panel with label + image
        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon("resources/fortuneteller.png"); // Make sure image path is correct
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // 📜 Middle panel with scrollable text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // 🔘 Bottom panel with buttons
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        // Add buttons to panel
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 📋 Load fortunes
        fortunes = new ArrayList<>();
        populateFortunes();

        // 🔄 Button functionality using Java 8 lambda
        readButton.addActionListener(e -> displayNewFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void populateFortunes() {
        fortunes.add("You will find a lucky penny... and immediately lose it.");
        fortunes.add("Avoid elevators today.");
        fortunes.add("You will dream in Java tonight.");
        fortunes.add("Beware of cats crossing your path.");
        fortunes.add("Someone will compliment your socks.");
        fortunes.add("You will ace your next quiz (hopefully).");
        fortunes.add("An alien may contact you—or maybe it's spam.");
        fortunes.add("You will crave pizza tonight.");
        fortunes.add("Today is not the day to do laundry.");
        fortunes.add("Something wonderful will happen... maybe.");
        fortunes.add("You will code a masterpiece.");
        fortunes.add("Expect the unexpected, and donuts.");
    }

    private void displayNewFortune() {
        if (fortunes.isEmpty()) {
            System.out.println("No fortunes loaded!");
            return;
        }

        Random rand = new Random();
        int index;

        do {
            index = rand.nextInt(fortunes.size());
        } while (index == lastIndex && fortunes.size() > 1);

        lastIndex = index;
        String newFortune = fortunes.get(index);
        System.out.println("New fortune: " + newFortune); // For debugging
        textArea.append(newFortune + "\n");
    }
}
