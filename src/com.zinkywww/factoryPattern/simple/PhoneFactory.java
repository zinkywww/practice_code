package factoryPattern.simple;

public class PhoneFactory {
    public Phone makePhone(String name){
        if(name.equals("MiPhone")){
            return new MiPhone();
        }else if(name.equals("IPhone")){
            return new IPhone();
        }else {
            return null;
        }
    }

}
