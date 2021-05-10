package models;

import java.util.Objects;

public class Ranger {
    private String name;
    private int id;

    public Ranger(String name){
        this.name = name;
    }

    public String getName() { return name; }

    public int getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return getId() == ranger.getId() &&
                Objects.equals(getName(), ranger.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
