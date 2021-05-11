package models;

import org.sql2o.Connection;

import java.util.Objects;

public class Animal {
    public int id;
    public String name;
    public String age;
    public String  health;
    public String type;


    public static void update(int id, String name, String health, String age) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name, health = :health, age = :age WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }

    public String getHealth() {
        return health;
    }

    public String getType(){
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getId(), animal.getId()) &&
                Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getAge(), animal.getAge()) &&
                Objects.equals(getHealth(), animal.getHealth()) &&
                Objects.equals(getType(), animal.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getHealth(), getType());
    }

}
