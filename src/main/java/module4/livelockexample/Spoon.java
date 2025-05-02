package module4.livelockexample;

public class Spoon {
    private Diner owner;

    public Spoon(Diner owner) {
        this.owner = owner;
    }

    public Diner getOwner() {
        return owner;
    }

    public synchronized void setOwner(Diner owner) {
        this.owner = owner;
    }

    // Method to use the spoon
    public synchronized void use() {
        System.out.println(owner.getName() + " is eating.");
    }
}
