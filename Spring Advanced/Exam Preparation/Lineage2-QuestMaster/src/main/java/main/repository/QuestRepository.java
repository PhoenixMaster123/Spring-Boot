package main.repository;

import main.model.Quest;
import main.model.enums.PlayerClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestRepository extends JpaRepository<Quest, UUID> {
    List<Quest> findAllByOrderByCreatedOnDescXpDesc();

    List<Quest> findAllByEligibleClassOrderByCreatedOnDesc(PlayerClass playerClass);
}
