package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    protected int id;
    protected String fullName;
    protected String email;
    protected String password;
    protected Role role;

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    public enum Role {
        EMPLOYEE, ADMIN
    }
}
