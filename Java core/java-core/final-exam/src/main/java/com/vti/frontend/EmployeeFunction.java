package com.vti.frontend;

import com.vti.backend.controller.EmployeeController;
import com.vti.entity.Employee;
import com.vti.utils.OutputUtils;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFunction {
    private final EmployeeController controller = new EmployeeController();

    public void showMenu() {
        while (true) {
            System.out.println("1. Hiển thị danh sách employee.");
            System.out.println("2. Tìm kiếm employee theo id.");
            System.out.println("3. Thêm employee.");
            System.out.println("4. Xóa employee theo id.");
            System.out.println("5. Thoát chương trình.");
            System.out.println("Mời bạn chọn chức năng:");
            int menu = ScannerUtils.inputInt();
            try {
                if (menu == 1) {
                    findAll();
                } else if (menu == 2) {
                    findById();
                } else if (menu == 3) {
                    create();
                } else if (menu == 4) {
                    deleteById();
                } else if (menu == 5) {
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ.");
                    return;
                } else {
                    System.out.println("Vui lòng chọn đúng chức năng.");
                }
            } catch (SQLException | IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void findAll() throws SQLException, IOException {
        List<Employee> employees = controller.findAll();
        System.out.println("Danh sách employee.");
        showEmployees(employees);
    }

    private void findById() throws SQLException, IOException {
        System.out.println("Nhập vào id cần tìm kiếm:");
        int id = ScannerUtils.inputPositiveInt();
        List<Employee> employees = controller.findById(id);
        System.out.printf("Danh sách employee có id = %d.%n", id);
        showEmployees(employees);
    }

    private void create() throws SQLException, IOException {
        System.out.println("Mời bạn nhập vào thông tin employee.");
        Employee employee = new Employee();
        System.out.println("Nhập vào full name:");
        employee.setFullName(ScannerUtils.inputFullName());
        System.out.println("Nhập vào email:");
        employee.setEmail(ScannerUtils.inputEmail());
        System.out.println("Nhập vào password:");
        employee.setPassword(ScannerUtils.inputPassword());
        System.out.println("Nhập vào pro skill:");
        employee.setProSkill(ScannerUtils.inputString());
        int row = controller.create(employee);
        System.out.printf("Thêm thành công %d employee(s).%n", row);
    }

    private void deleteById() throws SQLException, IOException {
        System.out.println("Nhập vào id cần xóa:");
        int id = ScannerUtils.inputPositiveInt();
        int row = controller.deleteById(id);
        System.out.printf("Xóa thành công %d employee(s) có id = %d.%n", row, id);
    }

    private void showEmployees(List<Employee> employees) {
        List<List<Object>> table = new ArrayList<>();
        table.add(Arrays.asList("ID", "FULL NAME", "EMAIL", "PASSWORD", "ROLE", "PRO SKILL"));
        if (employees.isEmpty()) {
            table.add(convertToRow(null));
        } else {
            for (Employee employee : employees) {
                table.add(convertToRow(employee));
            }
        }
        OutputUtils.showTable(table);
    }

    private List<Object> convertToRow(Employee employee) {
        List<Object> row = new ArrayList<>();
        if (employee == null) {
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
        } else {
            row.add(employee.getId());
            row.add(employee.getFullName());
            row.add(employee.getEmail());
            row.add(employee.getPassword());
            row.add(employee.getRole());
            row.add(employee.getProSkill());
        }
        return row;
    }
}
