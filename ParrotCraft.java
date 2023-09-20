
public class ParrotCraft {
    public class Parrot {

        public String hit() {
            String log = "";
            if (this.alive_dead == "alive") {
                if (this.health >= 1) {
                    this.health -= 1;
                    this.tamed_untamed = "untamed";
                    log = "Parrot is untamed now";
                }
            }
            else {
                this.health = 0;
                this.alive_dead = "dead";
                log = "parrot is already dead";

            }
            return log;
        }

        public String command(String action) {
            String log="";
            if (this.alive_dead=="dead"){
                log="you can not command this parrot because it is dead";
            }
            else {
                if (action == "fly") {
                    this.flying_sitting = "flying";
                    log = "parrot is flying";
                } else {
                    this.flying_sitting = "stay";
                    log = "parrot stayed";
                }
            }
            return log;
        }

        public String feed(double food) {
            String log= "";
            if (this.alive_dead == "dead") {
                log = "You cannot feed this";
            }
            else {
                if (food > 3) {
                    log = "you cannot feed more than 3";
                } else {
                    this.health += food;
                    this.crumbs += food;
                }
            }
            if (this.crumbs >= 2.5 && this.health != 0 && this.health != 1 && this.health != 2) {
                this.health -= 2;
                log = "parrot is sick";
            }
            if (this.crumbs >= 2.5 && (this.health == 1 || this.health == 2)) {
                this.health = 0;
                this.alive_dead = "dead";
                log = "dead";
            }
            return log;
        }

        public String play(Parrot p) {
            String log="";
            log = "Both parrots are busy enjoying their own company";
            this.tamed_untamed = "untamed";
            p.setTamed_untamed("untamed");
            return log;


        }
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

        String name = "Julius";
        int health = 3;

        double crumbs = 0.1;
        String tamed_untamed = "untamed";
        String alive_dead = "alive";
        String flying_sitting = "flying";

        public String toString() {
            return ((String)(this.name) + "" + (int)(this.health) + "" + (String)(this.alive_dead));
        }




    }

    public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Parrot p1 = new Parrot();
        Parrot p2 = new Parrot();
        Parrot p3 = new Parrot();
        System.out.println("Enter name for Parrot 1");
        p1 = input.next();
        System.out.println("Enter name for Parrot 2");
        p2 = input.next();
        System.out.println("Enter name for Parrot 3");
        p3 = input.next();
        p1.setName(Parrot1);
        p2.setName(Parrot2);
        p3.setName(Parrot3);

//javac ParrotCraft.java
//
        while (true) {
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
            System.out.println("1.FEED 2.COMMAND 3.PLAY 4.HIT 5.QUIT");
            int option;
            System.out.println("Select one option from above");
            option = input.nextInt();
            if (option == 5)
                break;
            System.out.println("Which Parrot?");
            int p = input.nextInt();

            Parrot selectedParrot = new Parrot();
            switch (p) {
                case 1: selectedParrot = p1;
                break;
                case 2: selectedParrot = p2;
                break;
                case 3: selectedParrot = p3;
                break;
                default:
                    System.out.println("Choose valid Parrot");
                    continue;
            }
            switch (option) {
                case 1:
                    System.out.println("How much do you want to feed?");
                    double food = input.nextDouble();
                    System.out.println(selectedParrot.feed(food));
                    break;
                case 2:
                    System.out.println("Fly or Stay");
                    String flying = input.next();
                    System.out.println(selectedParrot.command(log));
                    break;
                case 3:
                    if (selectedParrot.alive_dead == "dead") {
                        System.out.println("A dead parrot cannot feed");
                    }
                    else {
                        System.out.println("Which parrot do you want to play");
                        int parrotPlay = input.nextInt();
                        if (parrotPlay==p) {
                            System.out.println("Parrot cannot play with itself");
                            continue;
                        }
                        else if (parrotPlay==1) {
                            System.out.println(selectedParrot.play(p1));
                        }
                        else if (parrotPlay==2){
                            System.out.println(selectedParrot.play(p2));
                        }
                        else if (parrotPlay==3) {
                            System.out.println(selectedParrot.play(p3));
                        }
                    }
                    break;
                case 4:
                    System.out.println(selectedParrot.hit());
                    break;
                default:
                    System.out.println("Select valid choice");
            }
        }


    }


}
