import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("To Do List", SwingConstants.LEFT);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Üst ve alt boşluk

        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskPanel);

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    addTask(taskPanel, task);
                    taskField.setText("");
                    taskPanel.revalidate();
                } else {
                    JOptionPane.showMessageDialog(frame, "The task cannot be empty!");
                }
            }
        });
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        frame.add(headerLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void addTask(JPanel taskPanel, String taskText) {
        JPanel taskItemPanel = new JPanel(new BorderLayout());
        taskItemPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JCheckBox taskCheckbox = new JCheckBox(taskText);

        taskCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taskCheckbox.isSelected()) {
                    taskCheckbox.setText("<html><s>" + taskText + "</s></html>");
                } else {
                    taskCheckbox.setText(taskText);
                }
            }
        });
        taskItemPanel.add(taskCheckbox, BorderLayout.CENTER);
        taskPanel.add(taskItemPanel);
    }
}
