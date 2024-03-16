package org.example.threading;


class A extends Thread {
    @Override
    public void run() {
        for (int i=0; i<50; i++) {
            System.out.println("A");
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}

class B extends Thread {
    @Override
    public void run() {
        for (int i=0; i<50; i++) {
            System.out.println("B");
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}

class C implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<50; i++) {
            System.out.println("C");
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

public class Threading {
    public static void main(String[] args) {
        System.out.println("Threading practice!");

        // extends Thread class
        A a = new A();
        B b = new B();

        // implements Runnable interface
        C c = new C(); // or, Runnable c = new C();
        Thread tc = new Thread(c); // accepts classes that implements Runnable interface

        // using Runnable interface, Lambda expression
        Runnable d = () -> {
            for (int i=0; i<50; i++) {
                System.out.println("D");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        Thread td = new Thread(d);

        a.start();
        b.start();
        tc.start();
        td.start();

    }
}
