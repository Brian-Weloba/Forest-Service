package models;

import org.sql2o.Sql2o;

public class DB {
//        public static Sql2o sql2o  = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "nyosh04", "nyongesa");
    static String connectionString = "jdbc:postgresql://ec2-52-21-153-207.compute-1.amazonaws.com:5432/dah4qv55jga49s"; //!
    public static Sql2o sql2o = new Sql2o(connectionString, "yhtjmpekdqpwgc", "9057958965ce4bf3bb1bec8174a6d64e47c89abd6442078768981144c5c566ad");
}
