/**
 * @Author: Sujan Rokad, 000882948
 * ParrotCraft simulates a program where users can interact with parrots by feeding, commanding, playing, and hitting them.
 */
import java.util.Scanner;

public class ParrotCraft {
    /**
     * Main method to run the ParrotCraft program.
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Parrot p1 = new Parrot();
        Parrot p2 = new Parrot();
        Parrot p3 = new Parrot();

        System.out.println("Enter name for Parrot 1");
        String parrot1 = input.next();
        System.out.println("Enter name for Parrot 2");
        String parrot2 = input.next();
        System.out.println("Enter name for Parrot 3");
        String parrot3 = input.next();

        p1.setName(parrot1);
        p2.setName(parrot2);
        p3.setName(parrot3);

        while (true) {
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
            System.out.println("1. FEED 2. COMMAND 3. PLAY 4. HIT 5. QUIT");
            System.out.println("Select one option from above");

            int option;
            try {
                option = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear the buffer
                continue;
            }

            if (option == 5)
                break;

            System.out.println("Which Parrot?");
            int p;
            try {
                p = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear the buffer
                continue;
            }

            Parrot selectedParrot;
            switch (p) {
                case 1:
                    selectedParrot = p1;
                    break;
                case 2:
                    selectedParrot = p2;
                    break;
                case 3:
                    selectedParrot = p3;
                    break;
                default:
                    System.out.println("Choose a valid Parrot");
                    continue;
            }

            switch (option) {
                case 1:
                    System.out.println("How much do you want to feed?");
                    double food;
                    try {
                        food = input.nextDouble();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.nextLine(); // Clear the buffer
                        continue;
                    }
                    System.out.println(selectedParrot.feed(food));
                    break;
                case 2:
                    System.out.println("Fly or Stay?");
                    String flying = input.next();
                    System.out.println(selectedParrot.command(flying));
                    break;
                case 3:
                    if (selectedParrot.getAlive_dead().equals("dead")) {
                        System.out.println("A dead parrot cannot play");
                    } else {
                        System.out.println("Which parrot do you want to play with?");
                        int parrotPlay;
                        try {
                            parrotPlay = input.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.nextLine(); // Clear the buffer
                            continue;
                        }

                        if (parrotPlay == p) {
                            System.out.println("Parrot cannot play with itself");
                            continue;
                        } else if (parrotPlay == 1) {
                            System.out.println(selectedParrot.play(p1));
                        } else if (parrotPlay == 2) {
                            System.out.println(selectedParrot.play(p2));
                        } else if (parrotPlay == 3) {
                            System.out.println(selectedParrot.play(p3));
                        }
                    }
                    break;
                case 4:
                    System.out.println(selectedParrot.hit());
                    break;
                default:
                    System.out.println("Select a valid choice");
            }
        }
    }
}
