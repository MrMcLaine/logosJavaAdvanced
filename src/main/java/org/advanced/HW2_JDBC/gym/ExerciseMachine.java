package org.advanced.HW2_JDBC.gym;

public class ExerciseMachine {
    private int id;
    private String name;
    private int weight;
    private int number;

    public ExerciseMachine(int id, String name, int weight, int number) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.number = number;
    }

    public ExerciseMachine(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ExerciseMachine{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", weight=" + weight +
               ", number=" + number +
               '}';
    }
}
