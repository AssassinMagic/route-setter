package com.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;

    @Lob
    private String routeData;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @JsonIgnore
    private User createdBy;

    private LocalDateTime createdAt;
    private boolean isActive = true;
    private String grade;
    private String gradeConsensus;
    private String routeType; // boulder, lead
    private String location;
    private Double routeLength;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    private int likesCount = 0;
    private int dislikesCount = 0;
    private int commentCount = 0;
    private int favoritesCount = 0;
    private int viewsCount = 0;

    @ElementCollection
    private List<Long> likesList = new ArrayList<>();

    @ElementCollection
    private List<Long> dislikeList = new ArrayList<>();

    @ElementCollection
    private List<Long> favoriteList = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
