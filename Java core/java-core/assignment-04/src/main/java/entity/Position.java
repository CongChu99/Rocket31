package entity;

public class Position {
    int id;
    PositionName name;
    Account[] accounts;

    enum PositionName {
        DEVELOPER, TESTER, SCRUM_MASTER, PROJECT_MANAGER
    }
}
