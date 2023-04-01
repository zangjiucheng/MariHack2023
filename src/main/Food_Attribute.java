package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Zeyu
 * 
 */
public class Food_Attribute {

    protected int calories, fat, sodium, sugar, protein;

    public Food_Attribute(int calories, int fat, int sodium, int sugar, int protein) {
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.sugar = sugar;
        this.protein = protein;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return this.fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return this.sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getSugar() {
        return this.sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getProtein() {
        return this.protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public Food_Attribute calories(int calories) {
        setCalories(calories);
        return this;
    }

    public Food_Attribute fat(int fat) {
        setFat(fat);
        return this;
    }

    public Food_Attribute sodium(int sodium) {
        setSodium(sodium);
        return this;
    }

    public Food_Attribute sugar(int sugar) {
        setSugar(sugar);
        return this;
    }

    public Food_Attribute protein(int protein) {
        setProtein(protein);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Food_Attribute)) {
            return false;
        }
        Food_Attribute food_Attribute = (Food_Attribute) o;
        return calories == food_Attribute.calories && fat == food_Attribute.fat && sodium == food_Attribute.sodium
                && sugar == food_Attribute.sugar && protein == food_Attribute.protein;
    }

    @Override
    public String toString() {
        return "{" +
                " calories='" + getCalories() + "'" +
                ", fat='" + getFat() + "'" +
                ", sodium='" + getSodium() + "'" +
                ", sugar='" + getSugar() + "'" +
                ", protein='" + getProtein() + "'" +
                "}";
    }

}
