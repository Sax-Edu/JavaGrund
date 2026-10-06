package se.systementor.hmsax.lektion12.ovningsuppgifter.strategy;

import se.systementor.hmsax.lektion12.ovningsuppgifter.model.BattleAction;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.Pokemon;

import java.util.List;

public interface CpuStrategy {
    // G8: Väljer ett drag ur listan
    BattleAction chooseAction(List<BattleAction> availableActions, Pokemon self, Pokemon opponent);
}
