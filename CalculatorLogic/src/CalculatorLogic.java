//CalculatorLogic.java
//Lớp này xử lý các phép toán và tính toán các giá trị.
//
//java
//Sao chép
//Chỉnh sửa
public class CalculatorLogic {
    public double calculate(double a, double b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) return a / b;
                else throw new ArithmeticException("Không thể chia cho 0");
            case "^":
                return Math.pow(a, b);
            case "√":
                if (a < 0) throw new ArithmeticException("Không thể tính căn bậc 2 của số âm");
                return Math.sqrt(a);
            default:
                throw new IllegalArgumentException("Phép toán không hợp lệ");
        }
    }
}