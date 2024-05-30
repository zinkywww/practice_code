package factoryPattern.abstractFactory;

import factoryPattern.simple.IPhone;
import factoryPattern.simple.Phone;

public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public PersonalComputer makePC() {
        return new MAC();
    }
}
