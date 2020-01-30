package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOnFile {
    private PrintWriter printWriter;

    public WriteOnFile() {
        try {
            this.printWriter = new PrintWriter(new BufferedWriter(new FileWriter("/home/seif/Desktop/books/5th semester/os/osAss2/src/com/company/output.txt")));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public synchronized void writeToFileln(String message) {
        this.printWriter.println(message);
    }

    public synchronized void writeToFile(String message) {
        this.printWriter.print(message);
    }

    public void closeWriting() {
        this.printWriter.close();
    }
}
