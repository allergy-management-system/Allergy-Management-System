package com.example.application.views.component.formStepper;

public class FormFields {

    private String peanuts;
    private String fish;
    private String eggs;
    private String butter;
    private String soyProducts;
    private String milk;
    private String otherNuts;
    private String sugar;
    private String mushroom;
    private String gluten;
    private String mustard;
    private String other;
    private String otherFoods;
    private String timesOfReaction;
    private String lastReaction;
    private String causeOfReaction;
    private String symptomsExperienced;
    private String medicationAllergy;
    private String additionalNotes;


    public FormFields () {

    }

    public FormFields(String peanuts, String fish, String eggs, String butter, String soyProducts, String milk, String otherNuts, String sugar, String mushroom, String gluten, String mustard, String other, String otherFoods, String timesOfReaction, String lastReaction, String causeOfReaction, String symptomsExperienced, String medicationAllergy, String additionalNotes) {
        this.peanuts = peanuts;
        this.fish = fish;
        this.eggs = eggs;
        this.butter = butter;
        this.soyProducts = soyProducts;
        this.milk = milk;
        this.otherNuts = otherNuts;
        this.sugar = sugar;
        this.mushroom = mushroom;
        this.gluten = gluten;
        this.mustard = mustard;
        this.other = other;
        this.otherFoods = otherFoods;
        this.timesOfReaction = timesOfReaction;
        this.lastReaction = lastReaction;
        this.causeOfReaction = causeOfReaction;
        this.symptomsExperienced = symptomsExperienced;
        this.medicationAllergy = medicationAllergy;
        this.additionalNotes = additionalNotes;
    }

    public String getPeanuts() {
        return peanuts;
    }

    public void setPeanuts(String peanuts) {
        this.peanuts = peanuts;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public String getEggs() {
        return eggs;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }

    public String getButter() {
        return butter;
    }

    public void setButter(String butter) {
        this.butter = butter;
    }

    public String getSoyProducts() {
        return soyProducts;
    }

    public void setSoyProducts(String soyProducts) {
        this.soyProducts = soyProducts;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getOtherNuts() {
        return otherNuts;
    }

    public void setOtherNuts(String otherNuts) {
        this.otherNuts = otherNuts;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getMushroom() {
        return mushroom;
    }

    public void setMushroom(String mushroom) {
        this.mushroom = mushroom;
    }

    public String getGluten() {
        return gluten;
    }

    public void setGluten(String gluten) {
        this.gluten = gluten;
    }

    public String getMustard() {
        return mustard;
    }

    public void setMustard(String mustard) {
        this.mustard = mustard;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOtherFoods() {
        return otherFoods;
    }

    public void setOtherFoods(String otherFoods) {
        this.otherFoods = otherFoods;
    }

    public String getTimesOfReaction() {
        return timesOfReaction;
    }

    public void setTimesOfReaction(String timesOfReaction) {
        this.timesOfReaction = timesOfReaction;
    }

    public String getLastReaction() {
        return lastReaction;
    }

    public void setLastReaction(String lastReaction) {
        this.lastReaction = lastReaction;
    }

    public String getCauseOfReaction() {
        return causeOfReaction;
    }

    public void setCauseOfReaction(String causeOfReaction) {
        this.causeOfReaction = causeOfReaction;
    }

    public String getSymptomsExperienced() {
        return symptomsExperienced;
    }

    public void setSymptomsExperienced(String symptomsExperienced) {
        this.symptomsExperienced = symptomsExperienced;
    }

    public String getMedicationAllergy() {
        return medicationAllergy;
    }

    public void setMedicationAllergy(String medicationAllergy) {
        this.medicationAllergy = medicationAllergy;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @Override
    public String toString() {
        return "FormFields{" +
                "peanuts='" + peanuts + '\'' +
                ", fish='" + fish + '\'' +
                ", eggs='" + eggs + '\'' +
                ", butter='" + butter + '\'' +
                ", soyProducts='" + soyProducts + '\'' +
                ", milk='" + milk + '\'' +
                ", otherNuts='" + otherNuts + '\'' +
                ", sugar='" + sugar + '\'' +
                ", mushroom='" + mushroom + '\'' +
                ", gluten='" + gluten + '\'' +
                ", mustard='" + mustard + '\'' +
                ", other='" + other + '\'' +
                ", otherFoods='" + otherFoods + '\'' +
                ", timesOfReaction='" + timesOfReaction + '\'' +
                ", lastReaction='" + lastReaction + '\'' +
                ", causeOfReaction='" + causeOfReaction + '\'' +
                ", symptomsExperienced='" + symptomsExperienced + '\'' +
                ", medicationAllergy='" + medicationAllergy + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }
}
