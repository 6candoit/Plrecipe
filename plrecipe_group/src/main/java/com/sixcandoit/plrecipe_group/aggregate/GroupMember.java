package com.sixcandoit.plrecipe_group.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group_member")
@Getter
@Setter
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private int memberId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
