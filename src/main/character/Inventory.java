import java.util.ArrayList;

public class Inventory {
    public static final int MAX_SIZE = 5;
    private static ArrayList<Lootable> items = new ArrayList<>(MAX_SIZE);
    private static int size = 0;

    public static String print() {
        return items.toString();
    }

    public static ArrayList<Lootable> getItems() {
        return items;
    }

    public static int size() {
        return size;
    }

    public static void add(Lootable loot) {
        if (size == MAX_SIZE) {
            throw new TooManyItemsException("You cannot have more than 5 items in your inventory");
        }
        items.add(loot);
        size++;
    }

    public static Lootable get(int index) {
        return items.get(index);
    }

    public static void remove(int index) {
        if (isEmpty()) {
            throw new TooFewItemsException("You cannot have less than 0 items in your inventory");
        }
        items.remove(index);
        size--;
    }
    
    public static boolean contains(Lootable l) {
        return items.contains(l);
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        size = 0;
        items = new ArrayList<>(MAX_SIZE);
    }
}
