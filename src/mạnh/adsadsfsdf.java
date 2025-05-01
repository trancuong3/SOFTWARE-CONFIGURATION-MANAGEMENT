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