import java.util.*;

public class RecyclingTracker {

    HashMap<Integer, Household> households = StoreData.loadHouseholdMap();
    Scanner sc = new Scanner(System.in);
    int selectedOption = 0;

    public void run(){
        while (selectedOption != 6){

            try{
                System.out.println("\nWelcome to recycling tracker\n");

                System.out.println(
                        "1. Create a new household profile\n" +
                        "2. Log recycling events\n" +
                        "3. Display records\n" +
                        "4. Generate reports\n" +
                        "5. Save data\n" +
                        "6. Exit\n" +
                        "Select an option: "
                );

                selectedOption = Integer.parseInt(sc.nextLine());

                switch (selectedOption) {
                    case 1:
                        createHousehold();
                        break;
                    case 2:
                        logRecyclingEvent();
                        break;
                    case 3:
                        displayRecords();
                        break;
                    case 4:
                        generateReports();
                        break;
                    case 5:
                        saveData();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Option not recognized");
                        break;
                }

            } catch (NumberFormatException e){
                System.out.println("Invalid input");
            }

        }
    }

    // option 1
    private void createHousehold(){
        System.out.println("Creating a new household...\n");

        System.out.println("--------------------------------------------");
        int id = households.keySet().toArray().length;
        System.out.println("ID: " + id + "\n");

        System.out.println("Name of the household: ");
        String name = sc.nextLine().trim();

        System.out.println("Address of the household");
        String address = sc.nextLine().trim();
        System.out.println("--------------------------------------------");

        Household household = new Household(id, name, address);
        households.put(id, household);
    }

    // Option 2
    private void logRecyclingEvent(){
        System.out.println("Creating a new recycling event...\n");

        System.out.println("--------------------------------------------");
        System.out.println("Enter household ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (!households.containsKey(id)){
            System.out.println("invalid id");
            return;
        }

        try{
            System.out.println("Enter material type: " + RecyclingEvent.MATERIALS);
            String materialType = sc.nextLine().trim();

            System.out.println("Enter recycled weight (in kg): ");
            double weight = Double.parseDouble(sc.nextLine());
            System.out.println("--------------------------------------------");

            RecyclingEvent recyclingEvent = new RecyclingEvent(materialType, weight);
            households.get(id).addRecyclingEvent(recyclingEvent);

        } catch (RecyclingEventException e){
            System.out.println(e.getMessage());
        }
    }

    // Option 3
    private void displayRecords(){
        System.out.println("Records menu: ");
        System.out.println(
                "1. Show all recycling events for a household\n" +
                "2. Show total weight recycled by a household\n" +
                "3. Show total eco points earned by a household\n"
        );

        int option = Integer.parseInt(sc.nextLine());

        System.out.println("Enter household ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (!households.containsKey(id)){
            System.out.println("invalid id");
            return;
        }

        switch (option){
            case 1:
                System.out.println("--------------------------------------------");
                for (RecyclingEvent x : households.get(id).getRecyclingEvents()){
                    System.out.println(x.toString());
                    System.out.println("--------------------------------------------");
                }

                break;
            case 2:
                System.out.println("--------------------------------------------");
                System.out.println("Total weight: " + households.get(id).getTotalWeight());
                System.out.println("--------------------------------------------");

                break;
            case 3:
                System.out.println("--------------------------------------------");
                System.out.println("Total points: " + households.get(id).getHouseholdEcoPoints());
                System.out.println("--------------------------------------------");

                break;
            default:
                System.out.println("Option not recognized");
                break;

        }

    }

    // Option 4
    private void generateReports(){
        System.out.println("Reports menu: ");
        System.out.println(
                "1. Household with the highest total points\n" +
                "2. Total community recycling weight"
        );

        int option = Integer.parseInt(sc.nextLine());
        double totalWeight = 0;

        switch (option){
            case 1:
                System.out.println("---------------------------------------------------------------------");
                System.out.printf("%-5s | %-25s | %-12s | %-15s%n", "ID", "Name", "Total Points", "Total Weight(kg)");
                System.out.println("---------------------------------------------------------------------");

                ArrayList<Household> list = new ArrayList<>(households.values());

                list.sort((a, b) -> Double.compare(b.getHouseholdEcoPoints(), a.getHouseholdEcoPoints()));

                for (Household h : list) {
                    int id = h.getId();
                    String name = h.getName();
                    double points = h.getHouseholdEcoPoints();
                    double weight = h.getTotalWeight();
                    System.out.printf("%-5d | %-25s | %-12.1f | %-15.1f%n", id, name, points, weight);
                }
                System.out.println("---------------------------------------------------------------------");

                break;
            case 2:
                System.out.println("--------------------------------------------");
                for (Household h : households.values()) {
                    totalWeight += h.getTotalWeight();
                }
                System.out.println("Total Community Recycling Weight: " + totalWeight + " kg");
                System.out.println("--------------------------------------------");

                break;
            default:
                System.out.println("Option not recognized");
                break;

        }

    }

    // Option 5
    private void saveData(){
        System.out.println("Saving data...\n");
        StoreData.saveHouseholds(households);
    }

    public static void main(String[] args) {
        RecyclingTracker main = new RecyclingTracker();
        main.run();
    }

}
