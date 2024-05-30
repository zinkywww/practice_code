package factoryPattern.factoryMethod;

import factoryPattern.simple.IPhone;
import factoryPattern.simple.Phone;

public class IphoneFactory implements AbstractFactory{
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
