package com.vti.frontend;

import com.vti.backend.controller.IUserController;
import com.vti.backend.controller.UserController;
import com.vti.utils.OutputUtils;
import com.vti.utils.ScannerUtils;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFunction {
    private final IUserController controller = new UserController();

    public void showMenu() {
        while (true) {
            System.out.println("1. Đăng nhập.");
            System.out.println("2. Hiển thị danh sách user.");
            System.out.println("3. Tìm kiếm user theo id.");
            System.out.println("4. Thoát chương trình.");
            System.out.println("Mời bạn chọn chức năng:");
            int menu = ScannerUtils.inputInt();
            try {
                if (menu == 1) {
                    login();
                } else if (menu == 2) {
                    findAll();
                } else if (menu == 3) {
                    findById();
                } else if (menu == 4) {
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

    public void showMenuForAdmin() {
        while (true) {
            System.out.println("1. Hiển thị danh sách user.");
            System.out.println("2. Tìm kiếm user theo id.");
            System.out.println("3. Thêm user.");
            System.out.println("4. Xóa user theo id.");
            System.out.println("5. Đăng xuất.");
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
                    System.out.println("Đăng xuất thành công.");
                    return;
                } else {
                    System.out.println("Vui lòng chọn đúng chức năng.");
                }
            } catch (SQLException | IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void showMenuForEmployee() {
        while (true) {
            System.out.println("1. Hiển thị danh sách user.");
            System.out.println("2. Tìm kiếm user theo id.");
            System.out.println("3. Đăng xuất.");
            System.out.println("Mời bạn chọn chức năng:");
            int menu = ScannerUtils.inputInt();
            try {
                if (menu == 1) {
                    findAll();
                } else if (menu == 2) {
                    findById();
                } else if (menu == 3) {
                    System.out.println("Đăng xuất thành công.");
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
        List<User> users = controller.findAll();
        System.out.println("Danh sách user.");
        showUsers(users);
    }

    private void findById() throws SQLException, IOException {
        System.out.println("Nhập vào id cần tìm kiếm:");
        int id = ScannerUtils.inputPositiveInt();
        List<User> users = controller.findById(id);
        System.out.printf("Danh sách user có id = %d.%n", id);
        showUsers(users);
    }

    private void login() throws SQLException, IOException {
        System.out.println("Nhập vào email:");
        String email = ScannerUtils.inputEmail();
        System.out.println("Nhập vào password:");
        String password = ScannerUtils.inputPassword();
        List<User> users = controller.findByEmailAndPassword(email, password);
        if (users.isEmpty()) {
            System.err.println("Tài khoản hoặc mật khẩu không đúng.");
        } else {
            User user = users.get(0);
            User.Role role = user.getRole();
            System.out.printf("Đăng nhập thành công: %s - %s.%n", user.getEmail(), role);
            if (role == User.Role.ADMIN) {
                showMenuForAdmin();
            } else {
                showMenuForEmployee();
            }
        }
    }

    private void create() throws SQLException, IOException {
        System.out.println("Mời bạn nhập vào thông tin user.");
        User user = new User();
        System.out.println("Nhập vào full name:");
        user.setFullName(ScannerUtils.inputFullName());
        System.out.println("Nhập vào email:");
        user.setEmail(ScannerUtils.inputEmail());
        int row = controller.create(user);
        System.out.printf("Thêm thành công %d user(s).%n", row);
    }

    private void deleteById() throws SQLException, IOException {
        System.out.println("Nhập vào id cần xóa:");
        int id = ScannerUtils.inputPositiveInt();
        int row = controller.deleteById(id);
        System.out.printf("Xóa thành công %d user(s) có id = %d.%n", row, id);
    }

    private void showUsers(List<User> users) {
        List<List<Object>> table = new ArrayList<>();
        table.add(Arrays.asList("ID", "FULL NAME", "EMAIL", "PASSWORD", "ROLE"));
        if (users.isEmpty()) {
            table.add(convertToRow(null));
        } else {
            for (User user : users) {
                table.add(convertToRow(user));
            }
        }
        OutputUtils.showTable(table);
    }

    private List<Object> convertToRow(User user) {
        List<Object> row = new ArrayList<>();
        if (user == null) {
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
            row.add("NULL");
        } else {
            row.add(user.getId());
            row.add(user.getFullName());
            row.add(user.getEmail());
            row.add(user.getPassword());
            row.add(user.getRole());
        }
        return row;
    }
}
