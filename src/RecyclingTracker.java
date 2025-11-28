import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecyclingTracker {

    HashMap<Integer, Household> households = new HashMap<>();
    ArrayList<RecyclingEvent> logRecyclingEvents = new ArrayList<>();
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
                        // createHousehold();
                        break;
                    case 2:
                        // logRecyclingEvent();
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

    private void saveData(){
        System.out.println("Saving data...\n");
        StoreData.saveHouseholds(households);
        StoreData.saveRecyclingEvent(logRecyclingEvents);
    }











    public static void main(String[] args) {
        RecyclingTracker main = new RecyclingTracker();
        main.run();
    }

}
