package factoryPattern.factoryMethod;

import factoryPattern.simple.MiPhone;
import factoryPattern.simple.Phone;

public class MiFactory implements AbstractFactory{
    @Override
    public Phone createPhone() {
        return new MiPhone();
    }
}
