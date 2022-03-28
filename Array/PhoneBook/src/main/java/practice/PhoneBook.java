package practice;

import org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    HashMap<String, String> PhoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (unCorrectName(name) == false && unCorrectPhone(phone) == false) {
            if (PhoneBook.containsValue(phone) == true) {
                PhoneBook.remove(getKey(phone));
                PhoneBook.put(name, phone);
            } else if (PhoneBook.containsKey(name) == true){
               String addPhone = PhoneBook.get(name) + ", " + phone;
                PhoneBook.put(name,addPhone);
            }else if (phone != "" && name != "") {
                PhoneBook.put(name, phone);
            }
        } else {
            System.out.println("Некорректный формат имени");
        }
    }

    public boolean unCorrectPhone(String phone) {
        Pattern pattern = Pattern.compile("[\\D]");
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }

    public boolean unCorrectName(String name) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public String getKey(String phone) {
        String output = "";
        Collection<String> collection = PhoneBook.keySet();
        for (String key : collection) {
            String find = PhoneBook.get(key);
            if (key != null) {
                if (phone.equals(find)) {
                    output = output + key;
                }
            }
        }
        return output;
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String output = "";
        Collection<String> collection = PhoneBook.keySet();
        for (String key : collection) {
            String find = PhoneBook.get(key);
            if (key != null) {
                if (phone.equals(find)) {
                    output = output + key;
                }
            }
        }
        return output + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        String contactPhone = PhoneBook.get(name);
        Set<String> phone = new TreeSet<>();
        phone.add(name + " - " + contactPhone);
        return phone;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> List = new TreeSet<>();
        for (Map.Entry<String, String> entry : PhoneBook.entrySet()) {
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