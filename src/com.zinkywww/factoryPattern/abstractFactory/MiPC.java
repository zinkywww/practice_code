package factoryPattern.abstractFactory;

public class MiPC implements PersonalComputer{
    public MiPC() {
        this.make();
    }
    @Override
    public void make() {
        System.out.println("MiPC make");
    }
}
