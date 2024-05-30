package factoryPattern.abstractFactory;

import factoryPattern.simple.Phone;

public interface AbstractFactory {
    Phone makePhone();
    PersonalComputer makePC();
}
