public enum Operation {
    ADD {
        ArithmeticCalculator add = new ArithmeticCalculator();
        int result = add.getFirstNum() + add.getSecondNum();
    }, SUBTRACT{
        ArithmeticCalculator sub = new ArithmeticCalculator();
        int result = sub.getFirstNum() - sub.getSecondNum();
    }, MULTIPLY{
        ArithmeticCalculator mul = new ArithmeticCalculator();
        int result = mul.getFirstNum() * mul.getSecondNum();
    }
}
