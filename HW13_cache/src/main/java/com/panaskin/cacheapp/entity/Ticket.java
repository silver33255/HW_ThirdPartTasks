package com.panaskin.cacheapp.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "row")
    private Integer row;

    @Column(name = "seat")
    private Integer seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="session_id")
    @ToString.Exclude
    private FilmSession filmSession;
}
