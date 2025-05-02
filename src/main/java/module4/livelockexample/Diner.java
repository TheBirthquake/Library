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

    // Method to try and eat
    public void eatWith(Spoon spoon, Diner spouse) {
        while (isHungry) {
            // Don't take the spoon if the spouse is hungry
            if (spoon.getOwner() != this) {
                try {
                    // Wait a bit before trying again
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue; // Skip to the next iteration if not the owner
            }

            // If spouse is hungry, offer the spoon
            if (spouse.isHungry()) {
                System.out.println(name + ": You can have the spoon, " + spouse.getName() + "!");
                spoon.setOwner(spouse); // Give the spoon to the spouse
                try {
                    // Wait a bit before trying again
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue; // Skip to the next iteration after offering
            }

            // If spouse is not hungry, use the spoon
            spoon.use();
            isHungry = false; // Diner is no longer hungry
            System.out.println(name + ": I'm full!");
            spoon.setOwner(spouse); // Give the spoon back after eating
        }
    }
}