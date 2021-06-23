package fintech.test.application.constant;

public class RegexpConstant {

    public static final String USER_NAME_REGEX = "[A-Za-z]+";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,16}$";
    public static final String LAST_NAME_REGEX = "[a-zA-Z]+";
    public static final String FIRST_NAME_REGEX = "[a-zA-Z]+";

    public static final int MIN_USER_NAME_SIZE = 3;
    public static final int MIN_FIRST_NAME = 1;
    public static final int MIN_LAST_NAME = 1;
    public static final int MAX_NAME_SIZE = 16;

    private RegexpConstant() {
    }
}
