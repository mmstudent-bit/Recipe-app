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

    public void setSubstitutionID(int substitutionID){}

    public Ingredient getOriginalIngredient() {
        return originalIngredient;
    }

    public void setOriginalIngredient(Ingredient originalIngredient){}

    public Ingredient getSubstituteIngredient() {
        return substituteIngredient;
    }

    public void setsubstituteIngredient(){}

    public String getNote(){
        return this.note;
    }
    public String setNote(String Note){
        this.note = note;
    }

    public String getFormattedSubstiution(){
        String origName = (originalIngredient != null) ? originalIngredient.getIngredientName(): "Original";
        String subName = (substituteIngredient != null) ? substituteIngredient.getIngredientName(): "substitute";

        if (note != null && !note.trim().isEmpty()){
            return String.format("Replace %s with %s", origName, subName, note.trim());
        }
        return String.format("Replace %s with @s", origName, subName);
    }

    public boolean isValidSubstitution{
        if (originalIngredient == null || substituteIngredient == null){
            return false;
        }
        return originalIngredient.getOriginalIngredientID != substituteIngredient.getIngredietID();
    }

}
