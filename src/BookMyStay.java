import java.util.HashMap;
import java.util.Map;

abstract class Room {

    protected String roomType;
    protected int beds;
    protected int size;
    protected double price;

    public Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayRoom() {
        System.out.println(roomType + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}

class SingleRoom extends Room {

    public SingleRoom() {
        super("Single", 1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double", 2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite", 3, 750, 5000.0);
    }
}


class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
    }

    public void registerRoom(String type, int count) {
        roomAvailability.put(type, count);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get("Single") > 0) {

            singleRoom.displayRoom();
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        if (availability.get("Double") > 0) {

            doubleRoom.displayRoom();
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        if (availability.get("Suite") > 0) {

            suiteRoom.displayRoom();
            System.out.println("Available: " + availability.get("Suite"));
            System.out.println();
        }
    }
}

public class BookMyStay {

    public static void main(String[] args) {

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        inventory.registerRoom("Single", 5);
        inventory.registerRoom("Double", 3);
        inventory.registerRoom("Suite", 3);

        RoomSearchService searchService = new RoomSearchService();

        System.out.println("Room Search\n");

        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}