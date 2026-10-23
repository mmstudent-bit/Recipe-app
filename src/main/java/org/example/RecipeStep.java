package org.example;

public class RecipeStep {
    private int stepID;
    private int recipeID;
    private int stepNumber;
    private String instruction;

    public RecipeStep(){}

    public RecipeStep(int stepID, int recipeID, int stepNumber, String instruction){
        this.stepID = stepID;
        this.recipeID = recipeID;
        this.setStepNumber(stepNumber);
        this.setInstruction(instruction);
    }

    public int getStepID(){
        return stepID;
    }

    public void setStepID(int stepID) {
        this.stepID = stepID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getStepNumber(){
        return stepID;
    }

    public void setStepNumber(int stepNumber){
        this.stepNumber = stepNumber;
    }

    public String getInstruction(){
        return instruction;
    }

    public void setInstruction(String instruction){
        this.instruction = instruction;
    }

    public String getForrmattedStep(){
        if (instruction == null || instruction.trim().isEmpty()){
            return String.format("Step %d. [No Instruction Provided", stepNumber);
        }
        return String.format("step %d. %s", stepNumber, instruction.trim());
    }

    public boolean isValidStep(){
        return stepNumber > 0 && instruction != null && !instruction.trim().isEmpty();
    }
}
