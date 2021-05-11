package models;

import org.sql2o.Connection;

import java.util.List;

public class NonEndangered extends Animal{
    public static final String animalType = "Non-Endangered";

    public NonEndangered(String name){
        this.name = name;
        this.type = animalType;
    }

    public static List<NonEndangered> getAll() {
        String sql = "SELECT * FROM animals WHERE type = 'Non-Endangered';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangered.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type, age, health) VALUES (:name, :type, 'null', 'null')";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Animal findById(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }

    public static void update(int id, String name) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }


}
