//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.company;
import java.util.ArrayList;
import java.util.Iterator;

import static com.company.Gui.*;

public class Network {
    public Network() {
    }
    static Gui obj = new Gui();
    public static void networkUtilization() {
        int maxNumberOfWifiConnections = numberOfWifiConnections;

        System.out.println("wifi "+maxNumberOfWifiConnections);

        Router router = new Router(maxNumberOfWifiConnections);
        int numberOfClientDevices = numberOfDevicesToConnect;

        System.out.println("devices "+numberOfClientDevices);

        ArrayList<Device> listOfDevice = arr2;
        WriteOnFile writeOnFile = new WriteOnFile();
        router.setWriteOnFile(writeOnFile);
        Device.setWriteOnFile(writeOnFile);
        Device.setRouter(router);
        Iterator var7 = listOfDevice.iterator();

        Device device;
        while(var7.hasNext()) {
            device = (Device)var7.next();
            device.start();
        }

        var7 = listOfDevice.iterator();

        while(var7.hasNext()) {
            device = (Device)var7.next();

            try {
                device.join();
            } catch (InterruptedException var10) {
                var10.printStackTrace();
            }
        }

        writeOnFile.closeWriting();

    }
}
