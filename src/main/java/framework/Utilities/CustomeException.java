package framework.Utilities;

public class CustomeException extends Exception{

    public static class IDNotFoundException extends Exception {
        public IDNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}
