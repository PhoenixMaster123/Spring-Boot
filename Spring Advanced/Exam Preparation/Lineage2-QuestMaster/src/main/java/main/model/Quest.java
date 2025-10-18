package main.model;

import jakarta.persistence.*;
import lombok.*;
import main.model.enums.PlayerClass;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private double xp;

    @Column(nullable = false)
    private String bannerUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlayerClass eligibleClass;

    @ManyToOne(optional = false)
    private Item rewardItem;

    @ManyToOne
    private Player capturer;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String updatedBy;

    @PreUpdate
    private void preUpdate() {
        if (bannerUrl == null || bannerUrl.isBlank()) {
            bannerUrl = "/images/default-banner.png";
        }
        if (updatedBy == null || updatedBy.isBlank()) {
            updatedBy = "system";
        }
        updatedOn = LocalDateTime.now();
    }
}

