package com.lamda.web.soccer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity (name ="stadium")

public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 10) @NotNull
    private String stadiumId,stadiumName , hometeamId,seatCount,ddd,tel;
    @Column(length = 80) @NotNull
    private String address;

    @Builder
    public Stadium(String stadiumId, String stadiumName, String hometeamId, String seatCount, String ddd, String tel, String address){
        this.address = address;
        this.ddd = ddd;
        this.hometeamId = hometeamId;
        this.seatCount = seatCount;
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.tel = tel;
    }

    @OneToMany(mappedBy = "stadiumOfTeam")
    private List<Team> teams;
    @OneToMany(mappedBy = "stadiumOfSchedule")
    private List<Schedule> schedules;

}
