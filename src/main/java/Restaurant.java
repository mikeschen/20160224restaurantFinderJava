import org.sql2o.*;
import java.util.List;

public class Restaurant {
  private int id;
  private String name;
  private int cuisineId;

  public Restaurant (String name, int cuisineId) {
    this.name = name;
    this.cuisineId = cuisineId;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getCuisineId() {
    return cuisineId;
}

public static Restaurant find(int id){
  try(Connection con = DB.sql2o.open()){
  String sql = "SELECT * FROM restaurants where id=:id";
  Restaurant task = con.createQuery(sql)
    .addParameter("id", id)
    .executeAndFetchFirst(Restaurant.class);
  return task;
  }
}

  @Override
  public boolean equals(Object otherRestaurant){
    if (!(otherRestaurant instanceof Restaurant)) {
      return false;
    } else {
      Restaurant newRestaurant = (Restaurant) otherRestaurant;
      return this.getName().equals(newRestaurant.getName()) &&
        this.getId() == newRestaurant.getId() && this.getCuisineId() == newRestaurant.getCuisineId();
    }
  }

  //CREATE
  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Restaurants(name, cuisineId) VALUES (:name, :cuisineId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("cuisineId", this.cuisineId)
        .executeUpdate()
        .getKey();
    }
  }

  //READ
  public static List<Restaurant> all() {
    String sql = "SELECT id, name, cuisineId FROM restaurants";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Restaurant.class);
      }
    }

  //UPDATE
  public void update(String newName) {
    this.name = newName;
    try(Connection con = DB.sql2o.open()) {
      /******************************************************
        Students: TODO: Display all restaurants on main page
      *******************************************************/
      }
  }

  //DELETE
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      /******************************************************
        Students: TODO: Display all restaurants on main page
      *******************************************************/
    }
  }

  /******************************************************
    Students:
    TODO: Create find method
    TODO: Create method to get cuisine type
  *******************************************************/

}
