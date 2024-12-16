import java.util.Stack;

public class CreatureSorter {

    // Class to represent a creature with name and power level
    static class Creature {
        String name;
        int powerLevel;

        Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return name + " " + powerLevel;
        }
    }

    public static void main(String[] args) {
        // Fixed input data
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        // Bubble Sort (Descending)
        bubbleSortDescending(creatures);
        System.out.println("***Bubble Sort: Descending Order by Power Level");
        displayCreatures(creatures);

        // Selection Sort (Ascending)
        selectionSortAscending(creatures);
        System.out.println("\nSelection Sort: Ascending Order by Power Level");
        displayCreatures(creatures);

        // Stack Implementation
        System.out.println("\n***Stack Implementation: Popping Creatures");
        bubbleSortDescending(creatures); // Sort in descending order first
        stackImplementation(creatures);
    }

    // Bubble Sort: Sorts creatures in descending order by power level
    public static void bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    // Swap the creatures
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort: Sorts creatures in ascending order by power level
    public static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap the smallest element found with the first element of the unsorted part
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Stack Implementation: Pushes creatures onto a stack and pops them in order
    public static void stackImplementation(Creature[] creatures) {
        Stack<Creature> stack = new Stack<>();

        // Push all creatures onto the stack
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        // Pop each creature and display it
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    // Utility method to display creatures
    public static void displayCreatures(Creature[] creatures) {
        for (Creature creature : creatures) {
            System.out.println(creature);
        }
    }
          }
                      
