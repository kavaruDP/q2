package ru.geekbrains.q2.collection;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private String fio;
    private String number;
    private String name;
    private Map<String, String> phonebook;

    public PhoneBook(String name) {
        this.name = name;
        phonebook = new HashMap();
    }

    protected String get(String fio) {
        if(phonebook.size() == 0) {
            return "Справочник" + name + "пуст!";
        }
        String result = "По фамилии " + fio + " в справочнике "+ name + " найдены номера: ";
        boolean isFioFind = false;
        for(Map.Entry<String, String> o : phonebook.entrySet()) {
            String key = o.getKey();         // номер
            String val = o.getValue();    // фио

            if (fio.equals(val)) {
                isFioFind = true;
                result = result + " " + key;

            }
        }
       if (isFioFind) {
           return result;
       } else return "В справочнике " + name + " ничего не найдено!";
    }

    protected void add(String number, String fio) {
        phonebook.put(number, fio);
    }
}
