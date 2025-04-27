package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    private String body;

    private Float score;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();
}
