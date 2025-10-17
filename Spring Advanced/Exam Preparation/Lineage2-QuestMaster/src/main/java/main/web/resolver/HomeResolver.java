package main.web.resolver;

import main.model.Player;
import main.model.enums.PlayerRole;

import java.util.Map;

// Strategy Design Pattern
public interface HomeResolver {

    boolean supports(PlayerRole playerRole);

    String getViewName();

    Map<String, Object> getModelData(Player player);
}
