package factoryPattern.factoryMethod;

public class Test {
    public static void main(String[] args) {
        AbstractFactory miFactory = new MiFactory();
        AbstractFactory iFactory = new IphoneFactory();
        miFactory.createPhone();
        iFactory.createPhone();
    }
}
