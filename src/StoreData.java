import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class StoreData {

    public void saveHouseholds(HashMap<Integer, Household> householdsMap){
        Collection<Household> households = householdsMap.values();
        PrintWriter storer = null;

        try {
            storer = new PrintWriter(new FileWriter("Data/Households.csv"));

            // Header
            storer.println("id,name,address,joiningDate,householdEcoPoints");

            // Printing all households
            for (Household x : households){
                storer.println(x.toString());
            }

        } catch (IOException e){
            System.out.println("Couldnt save household data. Error: " + e.getMessage());
        } finally {

            // Closing FilePrinter
            try {
                storer.close();
            } catch (Exception e){
                System.out.println("Couldnt save household data. Error: " + e.getMessage());
            }
        }
    }

    public void saveRecyclingEvent(ArrayList<RecyclingEvent> recyclingEvents){
        PrintWriter storer = null;

        try {
            storer = new PrintWriter(new FileWriter("Data/RecyclingEvents.csv"));

            // Header
            storer.println("householdID,materialType,weight,recyclingDate,ecoPointsEarned");

            // Printing all recycling events
            for (RecyclingEvent x : recyclingEvents){
                storer.println(x.toString());
            }

        } catch (IOException e){
            System.out.println("Couldnt save recycling events data. Error: " + e.getMessage());
        } finally {

            // Closing FilePrinter
            try {
                storer.close();
            } catch (Exception e){
                System.out.println("Couldnt save recycling events data. Error: " + e.getMessage());
            }
        }
    }

}
