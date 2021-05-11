package models;

import org.sql2o.Connection;

import java.util.List;

public class Endangered extends Animal {
    public static final String animalType = "Endangered";

    public Endangered(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = animalType;
    }

    public static Endangered findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endangered.class);
        }
    }

    public static List<Endangered> getAll() {
        String sql = "SELECT * FROM animals WHERE type = 'Endangered';";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }
}
