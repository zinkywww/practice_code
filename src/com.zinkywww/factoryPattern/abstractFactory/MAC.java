package factoryPattern.abstractFactory;

public class MAC implements PersonalComputer{
    public MAC(){
        this.make();
    }

    @Override
    public void make() {
        System.out.println("MAC make");
    }
}
