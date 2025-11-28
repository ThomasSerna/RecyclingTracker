import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecyclingTracker {

    HashMap<Integer, Household> households = StoreData.loadHouseholdMap();
    ArrayList<RecyclingEvent> logRecyclingEvents = StoreData.loadRecyclingEvents();
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
                        // displayRecords();
                        break;
                    case 4:
                        // generateReports();
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




    private void saveData(){
        System.out.println("Saving data...\n");
        StoreData.saveHouseholds(households);
        StoreData.saveRecyclingEvent(logRecyclingEvents);
    }

    private void loadData(){

    }











    public static void main(String[] args) {
        RecyclingTracker main = new RecyclingTracker();
        main.run();
    }

}
