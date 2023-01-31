package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();
    static Exception ioException = new IOException();
    static Exception aeException = new ArithmeticException();
    static Exception nfException = new NumberFormatException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try  {
            riskyMethod();
        } catch (FileNotFoundException exception) {
            throw new IllegalArgumentException("Resource is missing", exception);
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Resource error", ioException);
        } catch (ArithmeticException aeException) {
            System.err.println(aeException.getMessage());
        } catch (NumberFormatException nfException) {
            System.err.println(nfException.getMessage());
        }
    }
}
