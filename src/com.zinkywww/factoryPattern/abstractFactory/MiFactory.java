package factoryPattern.abstractFactory;

import factoryPattern.simple.MiPhone;
import factoryPattern.simple.Phone;

public class MiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PersonalComputer makePC() {
        return new MiPC();

    }
}
