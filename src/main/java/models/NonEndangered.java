package models;

import org.sql2o.Connection;

import java.util.List;

public class NonEndangered extends Animal {
    public static final String animalType = "Non-Endangered";

    public NonEndangered(String name) {
        this.name = name;
        this.type = animalType;
    }

    public static NonEndangered findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NonEndangered.class);
        }
    }

    public static List<NonEndangered> getAll() {
        String sql = "SELECT * FROM animals WHERE type = 'Non-Endangered';";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangered.class);
        }
    }

    public static void update(int id, String name) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name  WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
}
