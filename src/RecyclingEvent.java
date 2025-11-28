import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

public class RecyclingEvent implements Serializable {

    // Valid materials
    public static final Set<String> MATERIALS = Set.of("plastic", "glass", "metal", "paper");

    // Attributes
    private String materialType;
    private double weight;
    LocalDate recyclingDate;
    double ecoPointsEarned;

    // Constructors

    public RecyclingEvent(String materialType, double weight) throws RecyclingEventException{
        setMaterialType(materialType);
        setWeight(weight);
        this.ecoPointsEarned = weight > 0 ? 10 * weight : 0;
        recyclingDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Date: " + this.recyclingDate +
                "\nMaterial Type: " + this.materialType +
                "\nWeight: " + this.weight +
                "\nEcopoints: " + this.ecoPointsEarned;
    }

    // Class methods

    private boolean isValidMaterial(String material) {
        if (material == null) return false;
        return MATERIALS.contains(material.toLowerCase(Locale.ROOT));
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws RecyclingEventException {
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

    public double getEcoPointsEarned() {
        return ecoPointsEarned;
    }

    public void setEcoPointsEarned(double ecoPointsEarned) {
        this.ecoPointsEarned = ecoPointsEarned;
    }

}