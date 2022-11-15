package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE User (
  id INT NOT NULL AUTO_INCREMENT,    
  first name VARCHAR(30) NOT NULL,
  last name VARCHAR(30) NOT NULL,
  User Name VARCHAR(30) NOT NULL,   
  Console (ex: PS, XBOX, PC) VARCHAR(30) NOT NULL,
  Games VARCHAR(50) NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "User")
public class User {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "firstName")
   private String first_name;

   @Column(name = "lastName")
   private String last_name;
   
   @Column(name = "UserName")
   private String User_Name;
   
   @Column(name = "Console")
   private String Console;
   
   @Column(name = "games")
   private String games;

   public User() {
   }

   public User(Integer id, String firstName, String lastName, String userName, String console, String games) {
      this.id = id;
      this.first_name = firstName;
      this.last_name = lastName;
      this.User_Name = userName;
      this.Console= console;
      this.games = games;
   }

   public User(String firstName, String lastName,String userName, String console, String games) {
	  this.first_name = firstName;
      this.last_name = lastName;
      this.User_Name = userName;
      this.Console= console;
      this.games = games;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getFirstName() {
      return first_name;
   }

   public void setFirstName(String firstName) {
	   this.first_name = firstName;
   }

   public String getLastName() {
	      return last_name;
	   }
   public void setLaststName(String lastName) {
	   this.last_name = lastName;
   }
   public void setUserName(String userName) {
		   this.User_Name = userName;
	   }
   public String getUserName() {
	      return User_Name;
	   }
   public void setconsole(String console) {
	   this.Console = console;
   }
   public String getconsole() {
      return Console;
   }

   public void setgames(String games) {
	   this.games = games;
   }
   public String getgames() {
   return games;
   }

   @Override
   public String toString() {
      return "User: " + this.id + ", " + this.first_name + ", " + this.last_name + ", " + this.User_Name + ", " + this.Console + ", " + this.games;
   }
}