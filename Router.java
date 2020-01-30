package com.company;

public class Router {
    private static Semaphore semaphore;
    private int maxNumberOfWifiConnection;
    private int availableConnectionNumber;
    private boolean isRouterFull = false;
    private WriteOnFile writeOnFile;

    public Router(int maxNumberOfWifiConnection) {
        semaphore = new Semaphore(maxNumberOfWifiConnection);
        this.maxNumberOfWifiConnection = maxNumberOfWifiConnection;
    }

    public int openConnection() {
        if (!this.isRouterFull) {
            //System.out.println(" Arrived");
            this.writeOnFile.writeToFileln(" Arrived");
        } else {
            // System.out.println(" Arrived and waiting");
            this.writeOnFile.writeToFileln(" Arrived and waiting");
        }

        semaphore.P();
        if (!this.isRouterFull && this.availableConnectionNumber < this.maxNumberOfWifiConnection) {
            ++this.availableConnectionNumber;
            if (this.availableConnectionNumber == this.maxNumberOfWifiConnection) {
                this.isRouterFull = true;
            }
        }

        return this.availableConnectionNumber;
    }

    public void closeConnection(int connectionNumber) {
        semaphore.V();
        this.availableConnectionNumber = connectionNumber;
    }

    public void setWriteOnFile(WriteOnFile writeOnFile) {
        this.writeOnFile = writeOnFile;
    }
}
