public enum Operation {

    CANADA("+"),
    POLAND("-"),
    GERMANY("*");

    String currency;

    Operation(String currency) {
        this.currency = currency;
    }
//    ADD {
//        ArithmeticCalculator add = new ArithmeticCalculator();
//        int result = add.getFirstNum() + add.getSecondNum();
//    }, SUBTRACT{
//        ArithmeticCalculator sub = new ArithmeticCalculator();
//        int result = sub.getFirstNum() - sub.getSecondNum();
//    }, MULTIPLY{
//        ArithmeticCalculator mul = new ArithmeticCalculator();
//        int result = mul.getFirstNum() * mul.getSecondNum();
//    }
}
