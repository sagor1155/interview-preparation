package org.example.exception;

class CustomException extends Exception {
    CustomException(String msg) {
        super(msg);
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new CustomException("Never do this again");
        } catch (CustomException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }
}
