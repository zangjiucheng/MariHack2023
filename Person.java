class Person{
    int age;
    String name, conditionName;
    boolean[] condition;

    // Constructor
    public Person(int age, String name, boolean[] condition) {
        this.age = age;
        this.name = name;
        this.condition = condition;

        /* Having a string with the name of the condition so we can use contains() */
        conditionName = "";
        for (int i = 0; i < condition.length; i++) {
            if (condition[i]) {
                switch (i) {
                    case 0:
                        conditionName += "Diabete ";
                        break;

                    case 1:
                        conditionName += "Obesity ";
                        break;

                    case 2:
                        conditionName += "Staying healthy ";
                        break;
                }
            }
        }
    }

    public boolean isGoodCalorie() {
        if () {
            
        } else {
            
        }
    }

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
}