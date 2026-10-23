package org.example;

public class RecipeIngredient {
    private int recipeIngredientID;
    private int recipeID;
    private Ingredient ingredient;
    private double quantity;
    private String unit;
    private String preperationNote;

    public RecipeIngredient(){}

    public RecipeIngredient(int recipeIngredientID, int recipeID, Ingredient ingredient, double quantity,String unit, String preperationNote){
        this.recipeIngredientID = recipeIngredientID;
        this.recipeID = recipeID;
        this.ingredient = ingredient;
        this.setQuantity(quantity);
        this.unit = unit;
        this.preperationNote = preperationNote;
    }

    public int getRecipeIngredientID() {
        return recipeIngredientID;
    }
    public void setRecipeIngredientID(int recipeIngredientID){
        this.recipeIngredientID = recipeIngredientID;
    }

    public int getrecipeID(){
        return recipeID;
    }

    public void setRecipeID(int recipeID){
        this.recipeID = recipeID;
    }

    public Ingredient getIngredient(){
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient){
        this.ingredient = ingredient;
    }

    public double getQuantity(){
        return quantity;
    }

    public String getUnit(){
        return unit;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getPreperationNote(){
        return preperationNote;
    }

    public void setPreperationNote(String preperationNote) {
        this.preperationNote = preperationNote;
    }

    public Double calculateItemCalories(){
        if (this.ingredient == null){
            return 0.0;
        }
        return this.ingredient.getCalories() * this.quantity;
    }

}
