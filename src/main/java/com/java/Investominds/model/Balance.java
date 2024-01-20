package com.java.Investominds.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Balance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Balance {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        @Column
        private Double available_balance;

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;


}

