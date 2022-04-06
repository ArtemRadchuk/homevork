package practice;

import org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private HashMap<String, String> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (nameValidate(name) && phoneValidate(phone)) {
            if (phoneBook.containsValue(phone)) {
                phoneBook.remove(getName(phone));
                phoneBook.put(name, phone);
            } else if (phoneBook.containsKey(name)) {
                String addPhone = phoneBook.get(name) + ", " + phone;
                phoneBook.put(name, addPhone);
            } else if (phone != "" && name != "") {
                phoneBook.put(name, phone);
            }
        } else {
            System.out.println("Некорректный формат имени или номера");
        }
    }

    private boolean phoneValidate(String phone) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }

    private boolean nameValidate(String name) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public String getName(String phone) {
        String output = "";
        Collection<String> collection = phoneBook.keySet();
        for (String key : collection) {
            String find = phoneBook.get(key);
            if (key != null && phone.equals(find)) {
                output = output + key;
            }
        }
        return output;
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String output = "";
        Collection<String> collection = phoneBook.keySet();
        for (String key : collection) {
            String find = phoneBook.get(key);
            if (key != null && phone.equals(find)) {
                output = output + key;
            }
        }
        return output + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        String contactPhone = phoneBook.get(name);
        Set<String> phone = new TreeSet<>();
        phone.add(name + " - " + contactPhone);
        return phone;

    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> List = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            List.add(key + " - " + value);
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