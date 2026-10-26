package org.example;
import java.util.ArrayList;
import java.util.List;

public class Recipe {


    private int recipeID;
    private String recipeName;
    private String description;
    private int prepTimeMins;
    private int cookTimeMins;
    private int servings;
    private List<RecipeIngredient> ingredients;
    private List<String> steps;
    private List<String> tags;


    public Recipe() {
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.tags = new ArrayList<>();
    }


    public Recipe(int recipeId, String recipeName, String description, int prepTimeMins, int cookTimeMins, int servings) {
        this.recipeID = recipeId;
        this.recipeName = recipeName;
        this.description = description;
        this.prepTimeMins = prepTimeMins;
        this.cookTimeMins = cookTimeMins;
        this.servings = servings;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public void scalePortions(double scaleFactor) {
        if (scaleFactor <= 0) {
            throw new IllegalArgumentException("Scale factor must be greater than 0.");
        }
        this.servings = (int) Math.round(this.servings * scaleFactor);
        for (RecipeIngredient ingredient : ingredients) {
            double currentQty = ingredient.getQuantity();
            ingredient.setQuantity(currentQty * scaleFactor);
        }
    }


    public double calculateTotalCalories() {
        double totalCalories = 0.0;
        for (RecipeIngredient ri : ingredients) {
            totalCalories += ri.getIngredient().getCalories() * ri.getQuantity();
        }
        return totalCalories;
    }

    public void addIngredient(RecipeIngredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addStep(String step) {
        this.steps.add(step);
    }

    public int getRecipeID(){
        return recipeID;
    }
    public void setRecipeID(int recipeID){
        this.recipeID = recipeID;
    }

    public String getRecipeName(){
        return recipeName;
    }
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public int getPrepTimeMins(){
        return prepTimeMins;
    }
    public void setPrepTimeMins(int prepTimeMins){
        this.prepTimeMins = prepTimeMins;
    }

    public int getCookTimeMins(){
        return cookTimeMins;
    }
    public void setCookTimeMins(int cookTimeMins){
        this.cookTimeMins = cookTimeMins;
    }

    public int getServings(){
        return servings;
    }
    public void setServings(int servings){
        this.servings = servings;
    }

    public List<RecipeIngredient> getIngredients(){
        return ingredients;
    }
    public void setIngredients(List<RecipeIngredient> ingredients){
        this.ingredients = ingredients;
    }

    public List<String> getSteps(){
        return steps;
    }
    public void setSteps(List<String> steps){
        this.steps = steps;
    }

    public List<String> getTags(){
        return tags;
    }
    public void setTags(List<String> tags){
        this.tags = tags;
    }
}