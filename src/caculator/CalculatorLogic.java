//Lớp này sẽ khởi tạo và hiển thị giao diện ứng dụng.
//
//java
//Sao chép
//Chỉnh sửa
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorFrame().setVisible(true);
        });
    }
}
