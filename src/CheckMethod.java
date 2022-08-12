public class CheckMethod {

    public static boolean checkEnter( String login, String password, String confirmPassword ) {
        try {
            if (checkLogin(login) && checkPassword(password, confirmPassword)) {
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

    private static boolean checkPassword( String password, String confirmPassword ) {
        if (!checkSecurity(password)) {
            throw new WrongPasswordException("Password must have [a-zA-Z0-9] and not longer than 20 pcs");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password must be the same with confirmPassword");
        }
        return true;
    }

    private static boolean checkLogin( String login ) {
        if (!checkSecurity(login)) {
            throw new WrongLoginException("Login must have [a-zA-Z0-9] and not longer than 20 pcs");
        }
        return true;
    }

    private static boolean checkSecurity( String data ) {
        String regex = "^\\w{0,20}$";
        return data.matches(regex);
    }

}
