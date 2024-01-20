package com.java.Investominds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "Investment_Plans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plans {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String plan_names;
    @Column
    private String term_period;
    @Column
    private String plan_description;
    @Column
    private Float rate_of_return;
    @Column
    private Double min_amount;
    @Column
    private String url;


    @JsonIgnore
    @ManyToMany(fetch =FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "plans")
    private Set<User> user = new HashSet<>();


}


































/*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "plans_users",
            joinColumns = @JoinColumn(
                    name = "plans_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"))
    private Set<User> user = new HashSet<>() ;
*/
