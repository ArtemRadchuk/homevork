package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private HashMap<String, String> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        if (nameValidate(name) && phoneValidate(phone)) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.remove(phone);
                phoneBook.put(phone, name);
                System.out.println("Контакт перезаписан");
            } else if (phoneBook.containsValue(name)) {
                String addPhone = phoneBook.get(name) + ", " + phone;
                phoneBook.put(phone, name);
                System.out.println("Контакт сохранен!");
            } else if (!phone.isEmpty() && !name.isEmpty()) {
                phoneBook.put(phone, name);
                System.out.println("Контакт сохранен!");
            }
        } else {
            System.out.println("Некорректный формат имени или номера");
        }
    }

    private boolean phoneValidate(String phone) {
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean nameValidate(String name) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public String getPhone(String name) {
        String output = "";
        Collection<String> phones = phoneBook.keySet();
        for (String phone : phones) {
            String find = phoneBook.get(phone);
            if (name.equals(find)) {
                output = output + phone;
            }
        }
        return output;
    }

    public String getContactByPhone(String phone) {
        return phoneBook.get(phone) + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        Set<String> phone = new TreeSet<>();
        Collection<String> collection = phoneBook.keySet();
        for (String key : collection) {
            String find = phoneBook.get(key);
            if (key != null && name.equals(find)) {
                phone.add(name + " - " + key);
            }
        }
        return phone;

    }

    public Set<String> getAllContacts() {
        Set<String> List = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String name = entry.getValue();
            String value = entry.getKey();
            List.add(name + " - " + value);
        }
        System.out.println(List);
        return List;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}