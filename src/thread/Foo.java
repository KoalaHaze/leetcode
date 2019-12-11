package thread;

import java.util.concurrent.locks.Lock;

public class Foo {

    private boolean threadA = false;
    private boolean threadB = false;
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock){
            printFirst.run();
            threadA = true;
            lock.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock){
            while (!threadA){
                lock.wait();
            }
            printSecond.run();
            threadB = true;
            lock.notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (!threadB){
                lock.wait();
            }
            printThird.run();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}
