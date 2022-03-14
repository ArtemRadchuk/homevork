public class Basket {
    private static int count = 0; //2
    private String items = "";
    private int totalPrice = 0; //114
    private int limit;
    private double totalWeight = 0; //Итоговый вес
    private double weight = 0;//Инициализация переменной weight
    private static int totalCost = 0; //Общая стоимость всех корзин
    private static int quantity = 0; //Количество товаров во всех корзинах
    private static int totalBasket = 0;

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

    public static void addProduct(int price, int count) { //Добавление к общей стоимости корзин и количеству товаров
        quantity = quantity + count;
        totalCost = totalCost + price;
    }

    public static double averagePrice() { //Метод рассчета средней цены товара во всех корзинах
        return totalCost / quantity;
    }

    public static int busketCost(int totalCost, int totalBasket) { //Средняя стоимость корзины
        return totalCost / totalBasket;
    }

    public void add(String name, int price) { //нужно ли прописать totalBasket++ при добавление корзины чтобы знать их количество
        add(name, price, 1);
        addProduct(price, count)
    }

    public void add(String name, int price, int count, double weight) {   //add с добавленным параметром  weight
        add(name, price, 1, weight);
        addProduct(price, count)
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
        public static void total () {
            totalPrice = totalPrice + count * price;
            totalWeight = totalWeight + count * weight; //Рассчет веса корзины
        }
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
