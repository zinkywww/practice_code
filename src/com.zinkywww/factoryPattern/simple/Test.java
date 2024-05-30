package factoryPattern.simple;

public class Test {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone p1 = phoneFactory.makePhone("MiPhone");
        Phone p2 = phoneFactory.makePhone("IPhone");

    }
}
