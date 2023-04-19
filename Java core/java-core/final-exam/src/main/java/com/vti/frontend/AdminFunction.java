package com.vti.frontend;

import com.vti.backend.controller.AdminController;
import com.vti.entity.Admin;
import com.vti.utils.OutputUtils;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminFunction {
    private final AdminController controller = new AdminController();

    public void showMenu() {
        while (true) {
            System.out.println("1. Hiển thị danh sách admin.");
            System.out.println("2. Tìm kiếm admin theo id.");
            System.out.println("3. Thêm admin.");
            System.out.println("4. Xóa admin theo id.");
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
        List<Admin> admins = controller.findAll();
        System.out.println("Danh sách admin.");
        showAdmins(admins);
    }

    private void findById() throws SQLException, IOException {
        System.out.println("Nhập vào id cần tìm kiếm:");
        int id = ScannerUtils.inputPositiveInt();
        List<Admin> admins = controller.findById(id);
        System.out.printf("Danh sách admin có id = %d.%n", id);
        showAdmins(admins);
    }

    private void create() throws SQLException, IOException {
        System.out.println("Mời bạn nhập vào thông tin admin.");
        Admin admin = new Admin();
        System.out.println("Nhập vào full name:");
        admin.setFullName(ScannerUtils.inputFullName());
        System.out.println("Nhập vào email:");
        admin.setEmail(ScannerUtils.inputEmail());
        System.out.println("Nhập vào password:");
        admin.setPassword(ScannerUtils.inputPassword());
        System.out.println("Nhập vào exp in year:");
        admin.setExpInYear(ScannerUtils.inputPositiveInt());
        int row = controller.create(admin);
        System.out.printf("Thêm thành công %d admin(s).%n", row);
    }

    private void deleteById() throws SQLException, IOException {
        System.out.println("Nhập vào id cần xóa:");
        int id = ScannerUtils.inputPositiveInt();
        int row = controller.deleteById(id);
        System.out.printf("Xóa thành công %d admin(s) có id = %d.%n", row, id);
    }

    private void showAdmins(List<Admin> admins) {
        List<List<Object>> table = new ArrayList<>();
        table.add(Arrays.asList("ID", "FULL NAME", "EMAIL", "PASSWORD", "ROLE", "EXP IN YEAR"));
        if (admins.isEmpty()) {
            table.add(convertToRow(null));
        } else {
            for (Admin admin : admins) {
                table.add(convertToRow(admin));
            }
        }
        OutputUtils.showTable(table);
    }

    private List<Object> convertToRow(Admin admin) {
        List<Object> row = new ArrayList<>();
        if (admin == null) {
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
        } else {
            row.add(admin.getId());
            row.add(admin.getFullName());
            row.add(admin.getEmail());
            row.add(admin.getPassword());
            row.add(admin.getRole());
            row.add(admin.getExpInYear());
        }
        return row;
    }
}
