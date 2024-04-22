import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Khởi tạo 10 nhân viên ban đầu
        for (int i = 1; i <= 10; i++) {
            employees.add(new Employee(i, "Employee " + i, 25 + i, "Department " + i, "Code " + i, 1000 + i * 100));
        }
    }

    public void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void addEmployee(int id, String name, int age, String department, String code, double salaryRate) {
        employees.add(new Employee(id, name, age, department, code, salaryRate));
    }

    public void removeEmployee(int id) {
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (removed) {
            System.out.println("Employee with ID " + id + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm nhân viên mới");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Thoát");

            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    system.displayEmployees();
                    break;
                case 2:
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Nhập phòng ban: ");
                    String department = scanner.nextLine();
                    System.out.print("Nhập mã: ");
                    String code = scanner.nextLine();
                    System.out.print("Nhập lương: ");
                    double salaryRate = scanner.nextDouble();

                    system.addEmployee(id, name, age, department, code, salaryRate);
                    System.out.println("Đã thêm nhân viên mới.");
                    break;
                case 3:
                    System.out.print("Nhập ID của nhân viên cần xóa: ");
                    int removeId = scanner.nextInt();
                    system.removeEmployee(removeId);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }

        scanner.close();
    }
}
