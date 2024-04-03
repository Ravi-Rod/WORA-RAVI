package com.groupeisi.ws.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String date;
    private String dayOfWeek;

    @ManyToOne
    private SearchHistory search;

    public Calendar(String date, String dayOfWeek) {
        this.date = date.replace("-", "/");
        this.dayOfWeek = dayOfWeek;
    }
}
