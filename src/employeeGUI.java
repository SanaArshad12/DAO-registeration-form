import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

class employeeGUI extends JFrame {

    JPanel panel = new JPanel();
    JLabel userName = new JLabel("Name:");
    JLabel id = new JLabel("ID:");
    JLabel NO = new JLabel("No:");
    JTextField field1 = new JTextField(10);
    JTextField field2 = new JTextField(10);
    JTextField field = new JTextField(10);
    JButton b1 = new JButton("Insert");
    JButton b2 = new JButton("Update");
    JButton b3 = new JButton("Delete");
    JButton b4 = new JButton("Read");

    public employeeGUI() {
        // Set layout manager
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Adding padding around components

        // Adding userName JLabel and JTextField
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(userName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(field1, gbc);

        // Adding id JLabel and JTextField
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(field2, gbc);

        // Adding NO JLabel and JTextField
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(NO, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(field, gbc);

        // Adding buttons
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(b2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(b3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(b4, gbc);

        // Set default close operation and add panel to frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(400, 300);
        setTitle("Employee GUI");
        setVisible(true);

        // Action Listener for Insert button
        b1.addActionListener(e -> {
            try {
                String name = field1.getText();
                int id = Integer.parseInt(field2.getText());
                employee emp = new employee(Integer.parseInt(field.getText()), id, name);
                DAOimplementation daoImplementation = new DAOimplementation();
                if (daoImplementation.insert(emp, new DB()) == -1) {
                    JOptionPane.showMessageDialog(this, "You can't book more than 8 tickets");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action Listener for Delete button
        b3.addActionListener(e -> {
            try {
                int id = Integer.parseInt(field2.getText());
                DAOimplementation daoImplementation = new DAOimplementation();
                daoImplementation.delete(id);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Main method to run the application

}
