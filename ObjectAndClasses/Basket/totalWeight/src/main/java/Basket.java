public class Basket {
    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0; //Итоговый вес
    private double weight = 0;//Инициализация переменной weight
    static int totalCost = 0; //Общая стоимость всех корзин
    static int quantity = 0; //Количество товаров во всех корзинах
    static int totalBasket = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void addBasket(int quantity, int totalCost) {
        this.quantity = this.quantity + quantity;
        this.totalCost = this.totalCost + totalCost;
        return quantity;
        return totalCost;
    }

    public static void averagePrice(int quantity, int totalCost) {
        quantity = this.quantity;
        totalCost = this.totalCost;
        System.out.println("Средняя цена товаров корзины - " + totalCost / quantity);
    }

    public static void busketCost(int totalCost, int totalBasket){ //Средняя стоимость корзины
        totalBasket = this.totalBasket;
        totalCost = this.totalCost;
        System.out.println("Средняя стоимость корзины - " + totalCost / totalBasket );
    }

    public void add(String name, int price) { //нужно ли прописать totalBasket++ при добавление корзины чтобы знать их количество
        add(name, price, 1);
    }

    public void add(String name, int price, int count, double weight) {   //add с добавленным параметром  weight
        add(name, price, 1, weight);
        this.weight = weight;
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight; //Рассчет веса корзины
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public double getTotalWeight() {  //Итоговый вес корзины
        return totalWeight;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
