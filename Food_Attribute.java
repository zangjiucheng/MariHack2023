public class Food_Attribute {
    protected int calories, fat, sodium, sugar;

    /* Constructor */
    public Food_Attribute() {
    }

    public Food_Attribute(int calories, int fat, int sodium, int sugar) {
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.sugar = sugar;
    }

    /* Getter setters */
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Food_Attribute)) {
            return false;
        }
        Food_Attribute food_Attribute = (Food_Attribute) o;
        return calories == food_Attribute.calories && fat == food_Attribute.fat && sodium == food_Attribute.sodium
                && sugar == food_Attribute.sugar;
    }

    @Override
    public String toString() {
        return "{" +
                " calories='" + getCalories() + "'" +
                ", fat='" + getFat() + "'" +
                ", sodium='" + getSodium() + "'" +
                ", sugar='" + getSugar() + "'" +
                "}";
    }

}