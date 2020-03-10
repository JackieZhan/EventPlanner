package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "events")
public class Event {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "event")
   private String event;
   
   @Column(name = "people")
   private Integer people;

   @Column(name = "date")
   private String date;

   public Event() {
   }

   public Event(Integer id, String event, String date, Integer people) {
      this.id = id;
      this.event = event;
      this.date = date;
      this.people = people;
   }

   public Event(String event, String date, Integer people) {
      this.event = event;
      this.date = date;
      this.people = people;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return event;
   }

   public void setName(String event) {
      this.event = event;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }
   
   public Integer getPeople() {
	   return people;
   }

   public void setPeople(Integer people) {
	   this.people = people;
   }

   
   @Override
   public String toString() {
      return "Event: " + this.id + ", " + this.event + ", " + this.date + ", " + this.people;
   }
}