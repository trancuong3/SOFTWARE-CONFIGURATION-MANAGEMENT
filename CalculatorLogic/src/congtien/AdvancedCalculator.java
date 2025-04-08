package Calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class AdvancedCalculator extends JFrame {
    private JTextField txtA, txtB, txtResult;
    private JButton btnCalculate, btnClear, btnHistory;
    private JComboBox<String> operationComboBox;
    private JTextArea historyArea;
    private List<String> historyList;

    public AdvancedCalculator() {
        historyList = new ArrayList<>();
        setTitle("Ứng dụng tính toán nâng cao");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        panel.add(new JLabel("Nhập số A:"));
        txtA = new JTextField();
        panel.add(txtA);

        panel.add(new JLabel("Nhập số B:"));
        txtB = new JTextField();
        panel.add(txtB);

        panel.add(new JLabel("Chọn phép toán:"));
        String[] operations = {"+", "-", "*", "/", "^", "√"};
        operationComboBox = new JComboBox<>(operations);
        panel.add(operationComboBox);

        panel.add(new JLabel("Kết quả:"));
        txtResult = new JTextField();
        txtResult.setEditable(false);
        panel.add(txtResult);

        btnCalculate = new JButton("Tính toán");
        panel.add(btnCalculate);

        btnClear = new JButton("Làm mới");
        panel.add(btnClear);

        btnHistory = new JButton("Lịch sử");
        panel.add(btnHistory);

        add(panel, BorderLayout.NORTH);

        historyArea = new JTextArea(10, 30);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện nút Tính toán
        btnCalculate.addActionListener(e -> {
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                String operation = (String) operationComboBox.getSelectedItem();
                double result = 0;
                String calculation = a + " " + operation + " " + b + " = ";

                switch (operation) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> {
                        if (b == 0) {
                            JOptionPane.showMessageDialog(null, "Không thể chia cho 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        result = a / b;
                    }
                    case "^" -> result = Math.pow(a, b);
                    case "√" -> {
                        if (a < 0) {
JOptionPane.showMessageDialog(null, "Không thể tính căn bậc hai của số âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        result = Math.sqrt(a);
                    }
                }

                txtResult.setText(String.valueOf(result));
                historyList.add(calculation + result);
                updateHistory();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Nút Làm mới
        btnClear.addActionListener(e -> {
            txtA.setText("");
            txtB.setText("");
            txtResult.setText("");
        });

        // Nút Lịch sử
        btnHistory.addActionListener(e -> updateHistory());
    }

    private void updateHistory() {
        historyArea.setText("");
        for (String calc : historyList) {
            historyArea.append(calc + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdvancedCalculator().setVisible(true);
        });
    }
}
