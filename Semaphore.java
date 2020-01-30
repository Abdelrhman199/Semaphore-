package com.company;

public class Semaphore {
    private int value;

    public Semaphore(int initial) {
        this.value = initial;
    }

    public synchronized void P() {
        --this.value;
        if (this.value < 0) {
            try {
                this.wait();
            } catch (InterruptedException var2) {
            }
        }

    }

    public synchronized void V() {
        ++this.value;
        if (this.value <= 0) {
            this.notify();
        }

    }
}
