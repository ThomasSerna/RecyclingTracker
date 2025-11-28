# RecyclingTracker

Small Java console application to track household recycling and award eco-points.  
This project was built as part of the **IBM Java Developer** certification.

---

## Overview

RecyclingTracker lets a community:

- Register households.
- Log recycling events by material and weight.
- Automatically calculate eco-points.
- View basic reports about the most active households and total recycled weight.
- Persist data locally between runs using Java serialization.

---

## Features

- **Household management**
  - Create a new household with `id`, `name`, `address`, and `joiningDate`.

- **Recycling events**
  - Supported materials: `plastic`, `glass`, `metal`, `paper`.
  - Weight in kilograms.
  - Eco-points are calculated as `10 * weight`.

- **Console menu**
  1. Create a new household profile  
  2. Log recycling events  
  3. Display records  
     - All recycling events for a household  
     - Total recycled weight per household  
     - Total eco-points per household  
  4. Generate reports  
     - Household with the highest total points (ranked table)  
     - Total community recycling weight  
  5. Save data  
  6. Exit

- **Persistence**
  - Households are stored in `data/Households.ser` using `ObjectOutputStream`.
  - On startup, the app tries to load existing data; if not available, it starts with an empty map.

---

## Tech Stack

- **Language:** Java  
- **Paradigm:** Object-oriented  
- **Main concepts used:**
  - Collections API (`HashMap`, `ArrayList`, `Set`)
  - Custom exceptions (`RecyclingEventException`)
  - Serialization (`ObjectInputStream`, `ObjectOutputStream`)
  - `java.time.LocalDate` for dates

---

## Project Structure

```text
RecyclingTracker/
├── src/
│   ├── Household.java            # Household entity and eco-points/weight aggregation
│   ├── RecyclingEvent.java       # Recycling event with validation and eco-points logic
│   ├── RecyclingEventException.java
│   ├── RecyclingTracker.java     # Main console app and menu logic (entry point)
│   └── StoreData.java            # Load / save households to data/Households.ser
└── data/
    └── Households.ser            # Serialized data file (created at runtime)
