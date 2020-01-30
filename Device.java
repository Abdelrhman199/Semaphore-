//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.company;
public class Device extends Thread {
    private String name;
    private String type;
    private static Router router;
    private int connectionNumber;
    private static WriteOnFile writeOnFile;

    public Device(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static void setWriteOnFile(WriteOnFile writeOnFile) {
        Device.writeOnFile = writeOnFile;
    }

    public static void setRouter(Router router) {
        Device.router = router;
    }

    private void connect() {
        //System.out.print("(" + this.name + ")(" + this.type + ")");
        writeOnFile.writeToFile("(" + this.name + ")(" + this.type + ")");
        this.connectionNumber = router.openConnection();
        //System.out.println("Connection " + this.connectionNumber + " : " + this.name + " Occupied");
        writeOnFile.writeToFileln("Connection " + this.connectionNumber + " : " + this.name + " Occupied");
    }

    private void performsOnlineActivity() {
        //System.out.println("Connection " + this.connectionNumber + " : " + this.name + " performs online activity");
        writeOnFile.writeToFileln("Connection " + this.connectionNumber + " : " + this.name + " performs online activity");
    }

    private void logout() {
        //System.out.println("Connection " + this.connectionNumber + " : " + this.name + " Logged out");
        writeOnFile.writeToFileln("Connection " + this.connectionNumber + " : " + this.name + " Logged out");
        router.closeConnection(this.connectionNumber);
    }

    public String getDeviceName() {
        return this.name;
    }

    public String getDeviceType() {
        return this.type;
    }

    public void run() {
        this.connect();
        this.performsOnlineActivity();
        int randomWaitTime = (int)(Math.random() * 10.0D * 100.0D);

        try {
            sleep((long)randomWaitTime);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        this.logout();
    }
}
