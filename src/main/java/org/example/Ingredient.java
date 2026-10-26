package org.example;

public class Ingredient {

    // 1. Private Instance Variables (Encapsulation - ERD Aligned)
    private int ingredientID;
    private String ingredientName;
    private String defaultUnit;
    private String category;
    private double calories;
    private double protein;
    private double fat;
    private double carbs;

    // 2. Default Constructor
    public Ingredient() {}

    // 3. Parameterized Constructor
    public Ingredient(int ingredientID, String ingredientName, String defaultUnit, String category, double calories, double protein, double fat, double carbs) {
        this.ingredientID = ingredientID;
        this.ingredientName = ingredientName;
        this.defaultUnit = defaultUnit;
        this.category = category;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    public double calculateEstimatedCalories() {
        return (this.protein * 4.0) + (this.carbs * 4.0) + (this.fat * 9.0);
    }

    public String getNutritionalSummary() {
        return String.format("%s (per %s): %.1f kcal | P: %.1fg | F: %.1fg | C: %.1fg",
                ingredientName, defaultUnit, calories, protein, fat, carbs);
    }


    public int getIngredientID() {
        return ingredientID;
    }
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }
    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public double getCalories() {
        return calories;
    }
    public void setCalories(double calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Caloric value cannot be negative.");
        }
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }
    public void setProtein(double protein) {
        if (protein < 0) {
            throw new IllegalArgumentException("Protein value cannot be negative.");
        }
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }
    public void setFat(double fat) {
        if (fat < 0) {
            throw new IllegalArgumentException("Fat value cannot be negative.");
        }
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }
    public void setCarbs(double carbs) {
        if (carbs < 0) {
            throw new IllegalArgumentException("Carbs value cannot be negative.");
        }
        this.carbs = carbs;
    }
}