//Lớp này quản lý giao diện chính của ứng dụng, bao gồm các panel và các thành phần UI cơ bản.
//
//java
//Sao chép
//Chỉnh sửa
import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    private JTextField txtA, txtB, txtResult;
    private JButton btnCalculate, btnClear, btnHistory;
    private JComboBox<String> operationComboBox;
private HistoryPanel historyPanel;
    private CalculatorLogic calculatorLogic;

    public CalculatorFrame() {
        setTitle("Ứng dụng tính toán nâng cao");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        calculatorLogic = new CalculatorLogic();
        historyPanel = new HistoryPanel();

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
        add(historyPanel, BorderLayout.CENTER);

        // Xử lý sự kiện khi nhấn nút Tính toán
        btnCalculate.addActionListener(e -> {
            String operation = (String) operationComboBox.getSelectedItem();
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double result = calculatorLogic.calculate(a, b, operation);
            txtResult.setText(String.valueOf(result));
            historyPanel.addToHistory(a, b, operation, result);
        });

        // Xử lý sự kiện khi nhấn nút Làm mới
        btnClear.addActionListener(e -> {
            txtA.setText("");
            txtB.setText("");
            txtResult.setText("");
        });

        // Xử lý sự kiện khi nhấn nút Lịch sử
        btnHistory.addActionListener(e -> historyPanel.showHistory());
    }
}