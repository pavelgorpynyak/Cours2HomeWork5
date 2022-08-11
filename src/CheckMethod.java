public class CheckMethod {

    public static boolean CheckEnter( String login, String password, String confirmPassword ) {
        try {
            return checkLogin(login) && checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            throw new WrongLoginException(e.getMessage());
        } catch (WrongPasswordException e) {
            throw new WrongPasswordException(e.getMessage());
        }
    }

    private static boolean checkPassword( String password, String confirmPassword ) {
        if (!checkSecurity(password) && checkSecurity(confirmPassword)) {
            throw new WrongPasswordException("Password must have [a-zA-Z0-9] and not longer than 20 pcs");
        }
        return password.equals(confirmPassword);
    }


    private static boolean checkLogin( String login ) {
        if (!checkSecurity(login)) {
            throw new WrongLoginException("Login must have [a-zA-Z0-9] and not longer than 20 pcs");
        }
        return true;
    }

    private static boolean checkSecurity( String loginPassword ) {
        String regex = "^\\w{0,20}$";
        return loginPassword.matches(regex);
    }

}
