package entity;

public class TypeQuestion {
    int id;
    TypeName name;
    Question[] questions;

    enum TypeName {
        ESSAY, MULTIPLE_CHOICE
    }
}
