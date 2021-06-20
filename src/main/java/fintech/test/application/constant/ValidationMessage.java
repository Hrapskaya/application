package fintech.test.application.constant;

public class ValidationMessage {

    public static final String USER_NAME_BLANCK = "Please fill User name.";
    public static final String USER_NAME_WRONG_LENGTH = "User name must be at least 3 letters and no more than 16";
    public static final String USER_NAME_MISMATCH_REGEXP = "Please use only latin letters";

    public static final String PASSWORD_BLANCK = "Please fill password.";
    public static final String PASSWORD_WRONG_LENGTH = "Password must be at least 3 letters and no more than 16";
    public static final String PASSWORD_MISMATCH_REGEXP = "Please use only numbers and latin letters. At least one character and at least one letter.";

    public static final String REPEAT_PASSWORD_BLANCK = "Please repeat password.";

    public static final String FIRST_NAME_BLANCK = "Please fill first name.";
    public static final String FIRST_NAME_WRONG_LENGTH = "first name must be at least 1 letters and no more than 16";
    public static final String FIRST_NAME_MISMATCH_REGEXP = "Please use only latin letters";

    public static final String LAST_NAME_BLANCK = "Please fill last name.";
    public static final String LAST_NAME_WRONG_LENGTH = "Last name must be at least 1 letters and no more than 16";
    public static final String LAST_NAME_MISMATCH_REGEXP = "Please use only latin letters";



    private ValidationMessage() {
    }
}
