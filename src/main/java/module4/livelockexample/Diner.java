package module4.livelockexample;

public class Diner {
    private String name;
    private boolean isHungry;

    public Diner(String name) {
        this.name = name;
        this.isHungry = true;
    }

    public String getName() {
        return name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void eatWith(Spoon spoon, Diner spouse) {
        while (isHungry) {
            if (spoon.getOwner() != this) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            if (spouse.isHungry()) {
                System.out.println(name + ": Пожалуйста, возьми ложку, " + spouse.getName() + "!");
                spoon.setOwner(spouse);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            spoon.use();
            isHungry = false;
            System.out.println(name + ": Я наелся!");
            spoon.setOwner(spouse);
        }
    }
}