import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        if (emailValidate(components[INDEX_EMAIL]) && phoneValidate(components[INDEX_PHONE]) && components.length == 4) {
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        } else if (!emailValidate(components[INDEX_EMAIL])) {
            throw new RuntimeException("thisIsNotAnEmail");
        } else if (!phoneValidate(components[INDEX_PHONE])) {
            throw new RuntimeException("+thisIsNotANumber");
        } else if (components.length > 4) {
            throw new RuntimeException();
        }
    }

    public boolean emailValidate(String email) {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    public boolean phoneValidate(String phone) {
        Pattern phonePattern = Pattern.compile("^\\+\\d{11}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = phonePattern.matcher(phone);
        return matcher.matches();
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}