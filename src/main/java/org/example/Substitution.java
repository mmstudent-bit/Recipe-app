package org.example;

public class Substitution {
    private int substitutionID;
    private Ingredient originalIngredient;
    private Ingredient substituteIngredient;
    private String note;

    public Substitution(){}
    public Substitution(int substitutionID, Ingredient originalIngredient, Ingredient substituteIngredient){
        this.substitutionID = substitutionID;
        this.setOriginalIngredient(originalIngredient);
        this.setsubstituteIngredient(substituteIngredient);
    }

    public int getSubstitutionID(){
        return substitutionID;
    }

    public void setSubstitutionID()
}
