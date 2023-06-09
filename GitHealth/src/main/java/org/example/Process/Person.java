package org.example.Process;

import java.util.ArrayList;

/**
 *
 * @author Zeyu
 */

public class Person {
    int age, weight;
    String name, conditionName, gender;
    boolean[] condition;

    // // Constructor
    // public Person(ArrayList personList) {
    // name = personList.get(0);
    // age = personList.get(1);
    // gender = personList.get(2);
    // weight = personList.get(3);
    // condition = personList.get(4);

    // /*
    // * Having a string with the name of the condition so we can use contains() in
    // * the food method later
    // */
    // conditionName = "";
    // for (int i = 0; i < condition.length; i++) {
    // if (condition[i]) {
    // switch (i) {
    // case 0:
    // conditionName += "Staying healthy ";
    // break;

    // case 1:
    // conditionName += "Obesity ";
    // break;

    // case 2:
    // conditionName += "Diabete_T1 ";
    // break;

    // case 3:
    // conditionName += "Diabete_T2 ";
    // break;
    // }
    // }
    // }
    // }

    public Person(String name, int age, String gender, int weight, boolean[] condition) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.condition = condition;

        /*
         * Having a string with the name of the condition so we can use contains() in
         * the food method later
         */
        conditionName = "";
        for (int i = 0; i < condition.length; i++) {
            if (condition[i]) {
                switch (i) {
                    case 0:
                        conditionName += "Staying healthy ";
                        break;

                    case 1:
                        conditionName += "Obesity ";
                        break;

                    case 2:
                        conditionName += "Diabete_T1 ";
                        break;

                    case 3:
                        conditionName += "Diabete_T2 ";
                        break;
                }
            }
        }
    }

    /* Food Attribute methods */
    public boolean isGoodCalorie(int calorieAmount) {
        if (conditionName.contains("Diabete_T1")) {
            return calorieAmount <= (16 * KgToPound(weight)) / 6;
        } else if (conditionName.contains("Diabete_T2")) {
            return calorieAmount <= 1800 / 6;
        } else if (conditionName.contains("Obesity")) {
            return calorieAmount <= 22 * weight;
        } else {
            if (gender.contains("F")) {
                return calorieAmount <= 2000;
            } else {
                return calorieAmount <= 2500;
            }
        }
    }

    public int KgToPound(int weight) {
        return (int) (weight * 2.205);
    }

    public boolean isGoodFat(int fatIn_g) {
        int calorieAmount;
        if (conditionName.contains("Diabete")) {
            calorieAmount = ((16 * KgToPound(weight)) / 3);
            return fatIn_g * 9 <= calorieAmount * 0.35;
        } else if (conditionName.contains("Obesity")) {
            return fatIn_g <= weight;
        } else {
            if (gender.contains("F")) {
                return fatIn_g <= 67;
            } else {
                return fatIn_g <= 83;
            }
        }
    }

    // public static void main(String[] args) {
    // boolean[] b = { false, true, true };
    // Person p = new Person("smthng", 5, "M", 57, b);
    // System.out.println(p.getConditionName());
    // System.out.println(p.isGoodSodium(501));
    // }

    public boolean isGoodSodium(int sodiumIn_mg) {
        if (conditionName.contains("Diabete")) {
            return sodiumIn_mg <= 1500 / 3;
        } else {
            return sodiumIn_mg <= 2300 / 3;
        }
    }

    /* Getters setters */
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean[] getCondition() {
        return this.condition;
    }

    public void setCondition(boolean[] condition) {
        this.condition = condition;
    }

    public String getConditionName() {
        return conditionName;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
                " age='" + getAge() + "'" +
                ", weight='" + getWeight() + "'" +
                ", name='" + getName() + "'" +
                ", conditionName='" + getConditionName() + "'" +
                ", gender='" + getGender() + "'" +
                ", condition='" + getCondition() + "'" +
                "}";
    }
}
