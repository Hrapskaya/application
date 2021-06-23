package fintech.test.application.constant;

public class Regexp {

    public static final String USER_NAME = "[A-Za-z]+";
    public static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,16}$";
    public static final String LAST_NAME = "[a-zA-Z]+";
    public static final String FIRST_NAME = "[a-zA-Z]+";
    private Regexp() {
    }
}
