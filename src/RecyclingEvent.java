// src/RecyclingEvent.java
import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

public class RecyclingEvent {

    // Valid materials
    private static final Set<String> MATERIALS = Set.of("plastic", "glass", "metal", "paper");

    // Attributes
    private int householdID;
    private String materialType;
    private int weight;
    LocalDate recyclingDate;
    int ecoPointsEarned;

    // Constructors

    public RecyclingEvent(int householdID, String materialType, int weight) throws RecyclingEventException{
        this.householdID = householdID;
        setMaterialType(materialType);
        setWeight(weight);
        this.ecoPointsEarned = calculateEcoPoints(weight);
    }

    public RecyclingEvent(int householdID, String materialType, int weight, LocalDate recyclingDate) throws RecyclingEventException{
        this.householdID = householdID;
        setMaterialType(materialType);
        setWeight(weight);
        this.recyclingDate = recyclingDate;
        this.ecoPointsEarned = calculateEcoPoints(weight);
    }

    @Override
    public String toString() {
        return householdID + "," + materialType + "," + weight + "," + recyclingDate.toString() + "," + ecoPointsEarned;
    }



    // Class methods

    private boolean isValidMaterial(String material) {
        if (material == null) return false;
        return MATERIALS.contains(material.toLowerCase(Locale.ROOT));
    }

    private int calculateEcoPoints(int weight){
        return 10 * weight;
    }

    // Getters and setters

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) throws RecyclingEventException{
        if (!isValidMaterial(materialType)) {
            throw new RecyclingEventException("Invalid material type. " + MATERIALS.toString());
        }
        this.materialType = materialType.toLowerCase(Locale.ROOT);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws RecyclingEventException {
        if (weight <= 0) {
            throw new RecyclingEventException("Weight must be greater than 0");
        }
        this.weight = weight;
    }

    public LocalDate getRecyclingDate() {
        return recyclingDate;
    }

    public void setRecyclingDate(LocalDate recyclingDate) {
        this.recyclingDate = recyclingDate;
    }

    public int getEcoPointsEarned() {
        return ecoPointsEarned;
    }

    public void setEcoPointsEarned(int ecoPointsEarned) {
        this.ecoPointsEarned = ecoPointsEarned;
    }

    public int getHouseholdID() {
        return householdID;
    }

    public void setHouseholdID(int householdID) throws RecyclingEventException {
        this.householdID = householdID;
    }

}