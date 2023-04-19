package frontend;

import backend.controller.AdminController;
import entity.Admin;
import utils.ScannerUtils;
import utils.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminFunction {
    private final String[] titles = {"ID", "FULL NAME", "EMAIL", "PASSWORD", "ROLE", "EXP IN YEAR"};
    private final int[] widths = {4, 25, 25, 15, 15, 15};

    private final AdminController controller = new AdminController();

    public void showMenu() {
        try (ScannerUtils scanner = new ScannerUtils()) {
            while (true) {
                System.out.println("1. Hiển thị danh sách admin.");
                System.out.println("2. Tìm kiếm admin theo id.");
                System.out.println("3. Thoát chương trình.");
                System.out.println("Mời bạn chọn chức năng:");
                int menu = scanner.inputInt();
                if (menu == 1) {
                    showAll();
                } else if (menu == 2) {
                    showById(scanner);
                } else if (menu == 3) {
                    return;
                } else {
                    System.out.println("Vui lòng chọn đúng chức năng.");
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showAll() throws SQLException, IOException {
        List<Admin> admins = controller.findAll();
        showHeader();
        showAdmins(admins);
        showFooter();
    }

    private void showById(ScannerUtils scanner) throws SQLException, IOException {
        System.out.println("Nhập vào id cần tìm:");
        int id = scanner.inputPositiveInt();
        Admin admin = controller.findById(id);
        showHeader();
        showAdmin(admin);
        showFooter();
    }

    private void showHeader() {
        TableUtils.showBorder('-', widths);
        TableUtils.showHeader(titles, widths);
        TableUtils.showBorder('-', widths);
    }

    private void showAdmins(List<Admin> admins) {
        if (admins.isEmpty()) {
            showAdmin(null);
            return;
        }
        for (Admin admin : admins) {
            showAdmin(admin);
        }
    }

    private void showAdmin(Admin admin) {
        if (admin == null) {
            TableUtils.showData(null, widths);
            return;
        }
        Object[] bodies = {
                admin.getId(),
                admin.getFullName(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getRole(),
                admin.getExpInYear()
        };
        TableUtils.showData(bodies, widths);
    }

    private void showFooter() {
        TableUtils.showBorder('-', widths);
    }
}
