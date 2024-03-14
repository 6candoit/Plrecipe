package com.sixcandoit.plrecipe_member.query.aggregate;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Follow {

    private int followId;

    private int userFollow;

    private int userFollower;

}
