package com.example.application.views.component.formStepper;

public class FormFields {

    private String peanuts = "";
    private String fish = "";
    private String eggs = "";
    private String butter = "";
    private String soyProducts = "";
    private String milk = "";
    private String otherNuts = "";
    private String sugar = "";
    private String mushroom = "";
    private String gluten = "";
    private String mustard = "";
    private String otherReaction = "";
    private String timesOfReaction = "";
    private String lastReaction = "";
    private String causeOfReaction = "";
    private String symptomsExperienced = "";
    private String medicationAllergy = "";
    private String additionalNotes = "";
    public FormFields () {

    }

    public FormFields(String peanuts, String fish, String eggs, String butter, String soyProducts, String milk, String otherNuts, String sugar, String mushroom, String gluten, String mustard, String otherReaction, String timesOfReaction, String lastReaction, String causeOfReaction, String symptomsExperienced, String medicationAllergy, String additionalNotes, String riskLevel) {
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
        this.otherReaction = otherReaction;
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

    public String getFish() {
        return fish;
    }

    public String getEggs() {
        return eggs;
    }

    public String getButter() {
        return butter;
    }

    public String getSoyProducts() {
        return soyProducts;
    }

    public String getMilk() {
        return milk;
    }

    public String getOtherNuts() {
        return otherNuts;
    }

    public String getSugar() {
        return sugar;
    }

    public String getMushroom() {
        return mushroom;
    }

    public String getGluten() {
        return gluten;
    }

    public String getMustard() {
        return mustard;
    }

    public String getOtherReaction() {
        return otherReaction;
    }

    public String getTimesOfReaction() {
        return timesOfReaction;
    }

    public String getLastReaction() {
        return lastReaction;
    }

    public String getCauseOfReaction() {
        return causeOfReaction;
    }

    public String getSymptomsExperienced() {
        return symptomsExperienced;
    }

    public String getMedicationAllergy() {
        return medicationAllergy;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setPeanuts(String peanuts) {
        this.peanuts = peanuts;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }

    public void setButter(String butter) {
        this.butter = butter;
    }

    public void setSoyProducts(String soyProducts) {
        this.soyProducts = soyProducts;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public void setOtherNuts(String otherNuts) {
        this.otherNuts = otherNuts;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public void setMushroom(String mushroom) {
        this.mushroom = mushroom;
    }

    public void setGluten(String gluten) {
        this.gluten = gluten;
    }

    public void setMustard(String mustard) {
        this.mustard = mustard;
    }

    public void setOtherReaction(String otherReaction) {
        this.otherReaction = otherReaction;
    }

    public void setTimesOfReaction(String timesOfReaction) {
        this.timesOfReaction = timesOfReaction;
    }

    public void setLastReaction(String lastReaction) {
        this.lastReaction = lastReaction;
    }

    public void setCauseOfReaction(String causeOfReaction) {
        this.causeOfReaction = causeOfReaction;
    }

    public void setSymptomsExperienced(String symptomsExperienced) {
        this.symptomsExperienced = symptomsExperienced;
    }

    public void setMedicationAllergy(String medicationAllergy) {
        this.medicationAllergy = medicationAllergy;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public void setReactionRiskLevel(String reaction, String riskLevel) {
        switch (reaction.toLowerCase().trim()) {
            case "peanuts":
                setPeanuts(riskLevel);
                break;
            case "fish/shellfish":
                setFish(riskLevel);
                break;
            case "peanutornutbutter":
                setButter(riskLevel);
                break;
            case "soyproducts":
                setSoyProducts(riskLevel);
                break;
            case "eggs":
                setEggs(riskLevel);
                break;
            case "milk":
                setMilk(riskLevel);
                break;
            case "treenuts(Walnuts,almonds,pecansetc.)":
                setOtherNuts(riskLevel);
                break;
            case "sugar":
                setSugar(riskLevel);
                break;
            case "mushroom":
                setMushroom(riskLevel);
                break;
            case "gluten":
                setGluten(riskLevel);
                break;
            case "mustard":
                setMustard(riskLevel);
                break;
            default:
                setOtherReaction(riskLevel);
                break;
        }
    }

    public void setDefaultValues() {
        peanuts = null;
        fish = null;
        eggs = null;
        butter = null;
        soyProducts = null;
        milk = null;
        otherNuts = null;
        sugar = null;
        mushroom = null;
        gluten = null;
        mustard = null;
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
                ", otherReaction='" + otherReaction + '\'' +
                ", timesOfReaction='" + timesOfReaction + '\'' +
                ", lastReaction='" + lastReaction + '\'' +
                ", causeOfReaction='" + causeOfReaction + '\'' +
                ", symptomsExperienced='" + symptomsExperienced + '\'' +
                ", medicationAllergy='" + medicationAllergy + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }
}
