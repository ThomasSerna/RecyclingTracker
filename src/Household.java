import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Household implements Serializable {

    // Attributes

    private int id;
    private String name;
    private String address;
    private LocalDate joiningDate;
    private ArrayList<RecyclingEvent> recyclingEvents;
    private double householdEcoPoints;

    // Constructors

    public Household(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
        this.joiningDate = LocalDate.now();
        this.recyclingEvents = new ArrayList<>();
        this.householdEcoPoints = 0;
    }

    public Household(int id, String name, String address, LocalDate joiningDate){
        this.id = id;
        this.name = name;
        this.address = address;
        this.joiningDate = joiningDate;
        this.recyclingEvents = new ArrayList<>();
        this.householdEcoPoints = 0;
    }

    // Class methods
    public void addEcoPoint(double ecoPointsEarned){
        householdEcoPoints += ecoPointsEarned;
    }

    public void addRecyclingEvent(RecyclingEvent event){
        recyclingEvents.add(event);
        addEcoPoint(event.ecoPointsEarned);
    }

    @Override
    public String toString(){
        return id + "," + name + "," + address + "," + joiningDate.toString() + "," + householdEcoPoints;
    }

    // Attributes setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public ArrayList<RecyclingEvent> getRecyclingEvents() {
        return recyclingEvents;
    }

    public void setRecyclingEvents(ArrayList<RecyclingEvent> recyclingEvents) {
        this.recyclingEvents = recyclingEvents;
    }

    public double getHouseholdEcoPoints() {
        return householdEcoPoints;
    }

    public void setHouseholdEcoPoints(double householdEcoPoints) {
        this.householdEcoPoints = householdEcoPoints;
    }

}
