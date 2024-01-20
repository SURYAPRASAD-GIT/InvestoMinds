/*
package com.java.Investominds.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "UserInvestedPlans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInvestedPlans {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<User> user;


    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "plans_id", referencedColumnName = "id")
    private List<Plans> plans;


}

*/
