public class CheckMethod {

    public static boolean checkEnter( String login, String password, String confirmPassword ) {
        try {
            if (checkLine(login, password, confirmPassword)) {
                return true;
            } else {
                return false;
            }
        } catch (WrongLoginException e) {
            throw new WrongLoginException(e.getMessage());
        } catch (WrongPasswordException e) {
            throw new WrongPasswordException(e.getMessage());
        }
    }

    private static boolean checkLine( String login, String password, String confirmPassword ) {
        if (!checkSecurity(login)) {
            throw new WrongLoginException("Login must have [a-zA-Z0-9] and not longer than 20 pcs");
        } else if (!checkSecurity(password)) {
            throw new WrongPasswordException("Password must have [a-zA-Z0-9] and not longer than 20 pcs");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password must be the same with confirmPassword");
        }
        return true;
    }

    private static boolean checkSecurity( String data ) {
        String regex = "^\\w{0,20}$";
        return data.matches(regex);
    }

}
