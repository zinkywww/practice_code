package factoryPattern.abstractFactory;

public class Test {
    public static void main(String[] args) {
        MiFactory miFactory = new MiFactory();
        AppleFactory appleFactory = new AppleFactory();
        miFactory.makePC();
        appleFactory.makePC();
        miFactory.makePhone();
        appleFactory.makePhone();
    }
}
