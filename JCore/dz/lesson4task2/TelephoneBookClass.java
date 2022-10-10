package lessonsJCore.JCore.dz.lesson4task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TelephoneBookClass {
    private HashMap<String,String> stringStringHashMap = new HashMap<>();

    public void add(String phone, String fio){
        stringStringHashMap.put(phone,fio);
    }

    public String getPhoneByFIO(String fio){
        if(stringStringHashMap.containsValue(fio)){
            String result = "Phone numbers: ";
            for(String key: stringStringHashMap.keySet()){
                if(stringStringHashMap.get(key).equals(fio)) result += key + "; ";
            }
            return result;
        } else return "Can't find";

    }


    }

