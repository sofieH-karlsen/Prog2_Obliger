package Oblig.seks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Zoo {
    private HashMap<Integer,Animal> zooList;

    public Zoo(HashMap<Integer, Animal> zooList) {
        this.zooList = zooList;
    }

    public void addAnimal(Animal dyr){
        if (zooList.isEmpty()){
            zooList.put(1,dyr);
        } else {
            for (Integer key : zooList.keySet()) {
                if (!zooList.containsKey(key)) {
                    zooList.put(key, dyr);
                } else if (!zooList.containsKey(key + 1)) {
                    zooList.put(key + 1, dyr);
                }
            }
        }
    }

    public ArrayList<Animal> zooAnimalsInfo(){
        return new ArrayList<>(zooList.values());
    }
}
