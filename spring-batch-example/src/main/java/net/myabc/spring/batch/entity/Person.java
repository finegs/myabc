package net.myabc.spring.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PERSION_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
     @Id
     @Column(name = "PERSION_ID")
     private Integer personId;

     @Column(name = "FIRST_NAME")
     private String firstName;

     @Column(name = "LAST_NAME")
     private String lastName;

     @Column(name = "EMAIL")
     private String email;

     @Column(name = "AGE")
     private Integer age;
}
