package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.Player;
import main.model.enums.PlayerClass;
import main.model.enums.PlayerRole;
import main.repository.PlayerRepository;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createNewPlayer(RegisterRequest registerRequest) {
        Player player = Player.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .nickname(registerRequest.getNickname())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        playerRepository.save(player);

        log.info("New player created: {}", player);
    }

    public Player login(LoginRequest loginRequest) {

        Player player = playerRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        String rawPassword = loginRequest.getPassword();
        String encodedPassword = player.getPassword();

        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new RuntimeException("Invalid username or password");
        }

        return player;
    }

    public void selectRole(UUID playerId, PlayerRole playerRole) {
        
        Player player = getById(playerId);

        player.setRole(playerRole);
        player.setUpdatedOn(LocalDateTime.now());

        if(playerRole == PlayerRole.ADVENTURER) {
            int randomIndex = new Random().nextInt(0, PlayerClass.values().length);
            PlayerClass randomClass = PlayerClass.values()[randomIndex];
            player.setPlayerClass(randomClass);
        }

        playerRepository.save(player);
    }

    public Player getById(UUID playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public List<Player> getAllAdventures() {
        return playerRepository.findAllByRoleOrderByXpDesc(PlayerRole.ADVENTURER);
    }
}
