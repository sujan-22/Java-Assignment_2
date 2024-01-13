/**
 * Author:                 Sujan Rokad, 000882948
 * Authorship statement:   I, Sujan Rokad, 000882948, certify that this material is my original work.
 *                         No other person's work has been used without due acknowledgement.
 * Purpose:                Define a Parrot class to simulate interactions with parrots.
 */

public class Parrot {

    // Properties of the Parrot class
    private String name = "Julius";
    private int health = 3;
    private double crumbs = 0.1;
    private String tamed_untamed = "untamed";
    private String alive_dead = "alive";
    private String flying_sitting = "flying";

    // Methods for various interfaces

    /**
     * Simulate hitting the parrot.
     *
     * @return A log message indicating the result of hitting the parrot.
     */
    public String hit() {
        String log = "";
        if (this.alive_dead.equals("alive")) {
            if (this.health >= 1) {
                this.health -= 1;
                this.tamed_untamed = "untamed";
                this.flying_sitting = "flying";
                log = "Parrot is untamed now";
            }
            if (this.health == 0) {
                this.alive_dead = "dead";
            }
        } else {
            this.health = 0;
            log = "Parrot is already dead";
        }
        return log;
    }

    /**
     * Command the parrot to fly or stay.
     *
     * @param action The action to command the parrot.
     * @return A log message indicating the result of the command.
     */
    public String command(String action) {
        String log = "";
        if (this.alive_dead.equals("dead")) {
            log = "You cannot command this parrot because it is dead";
        } else {
            if (this.tamed_untamed.equals("tamed")) {
                if (action.equals("fly")) {
                    this.flying_sitting = "flying";
                    log = "Wohoo, parrot is flying";
                } else {
                    this.flying_sitting = "stay";
                    log = "Parrot stayed";
                }
            } else {
                log = "Parrot is untamed and so cannot command";
            }
        }
        return log;
    }

    /**
     * Feed the parrot with the specified amount of food.
     *
     * @param food The amount of food to feed the parrot.
     * @return A log message indicating the result of feeding the parrot.
     */
    public String feed(double food) {
        String log = "";
        if (this.alive_dead.equals("dead")) {
            log = "You cannot feed this because it is dead";
        } else {
            this.health = Math.min(this.health + 1, 3);
            this.crumbs += food;

            double prob = food * 20;
            if (prob > 50.0) {
                this.tamed_untamed = "tamed";
            }

            if (this.crumbs > 2.5) {
                this.health = Math.max(0, this.health - 2);

                if (this.health > 0) {
                    log = "Parrot is sick";
                }

                if (this.health == 0) {
                    this.alive_dead = "dead";
                    log = "Parrot is dead";
                }
            } else {
                log = "Parrot has been fed";
            }
        }
        return log;
    }

    /**
     * Simulate playing between two parrots.
     *
     * @param p The other parrot to play with.
     * @return A log message indicating the result of the play interaction.
     */
    public String play(Parrot p) {
        String log = "Both parrots are busy enjoying their own company";
        if (this.tamed_untamed.equals("tamed") && p.getTamed_untamed().equals("tamed")) {
            this.tamed_untamed = "untamed";
            p.setTamed_untamed("untamed");
            return log;
        } else {
            log = "Parrots are not tamed";
            return log;
        }
    }

    // Getters and setters for the properties of the Parrot class

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getCrumbs() {
        return crumbs;
    }

    public void setCrumbs(double crumbs) {
        this.crumbs = crumbs;
    }

    public String getTamed_untamed() {
        return tamed_untamed;
    }

    public void setTamed_untamed(String tamed_untamed) {
        this.tamed_untamed = tamed_untamed;
    }

    public String getAlive_dead() {
        return alive_dead;
    }

    public void setAlive_dead(String alive_dead) {
        this.alive_dead = alive_dead;
    }

    public String getFlying_sitting() {
        return flying_sitting;
    }

    public void setFlying_sitting(String flying_sitting) {
        this.flying_sitting = flying_sitting;
    }

    /**
     * Override the toString() method to return a formatted string representing the Parrot object.
     *
     * @return A string representation of the Parrot object.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + " --- Health: " + this.health + " --- crumbs: " + this.crumbs
                + " --- Status: " + this.alive_dead + "..." + this.tamed_untamed + "..." + this.flying_sitting;
    }
}
