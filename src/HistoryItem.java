//Lớp này đại diện cho một mục lịch sử và chứa thông tin về phép tính.
//
//java
//Sao chép
//Chỉnh sửa
public class HistoryItem {
    private double a, b, result;
    private String operation;

    public HistoryItem(double a, double b, String operation, double result) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        this.result = result;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return a + " " + operation + " " + b + " = " + result;
    }
}