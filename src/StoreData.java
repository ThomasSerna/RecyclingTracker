import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class StoreData {

    public static void saveHouseholds(HashMap<Integer, Household> householdsMap){
        Collection<Household> households = householdsMap.values();
        ObjectOutputStream storer = null;

        try {
            System.out.println("Trying to save households...");

            storer = new ObjectOutputStream(
                    new FileOutputStream("data/Households.ser")
            );

            storer.writeObject(householdsMap);

            System.out.println("Households saved");

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

    public static HashMap<Integer, Household> loadHouseholdMap(){
        ObjectInputStream loader = null;

        try {
            System.out.println("Trying to load households...");

            loader = new ObjectInputStream(
                    new FileInputStream("data/Households.ser")
            );

            HashMap<Integer, Household> householdHashMap = (HashMap<Integer, Household>) loader.readObject();

            System.out.println("Households loaded");
            return householdHashMap;

        } catch (IOException | ClassNotFoundException e){
            System.out.println("Couldnt load household data. Error: " + e.getMessage());
        } finally {

            // Closing FilePrinter
            try {
                loader.close();
            } catch (Exception e){
                System.out.println("Couldnt load household data. Error: " + e.getMessage());
            }
        }
        return new HashMap<Integer, Household>();
    }

}
