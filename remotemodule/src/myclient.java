import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class myclient {
    public static void main(String[] args) {
        try {
            Registry reg=LocateRegistry.getRegistry("localhost",5000);
               App ad=(App)reg.lookup("hi_server");
               System.out.println("Addition:"+ad.add(20, 30)); 

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

