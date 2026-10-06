package se.systementor.hmsax.lektion12.ovningsuppgifter.strategy;

import se.systementor.hmsax.lektion12.ovningsuppgifter.model.BattleAction;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.FleeAction;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.Pokemon;

import java.util.List;

public class DefensiveStrategy implements CpuStrategy {
    @Override
    public BattleAction chooseAction(List<BattleAction> availableActions, Pokemon self, Pokemon opponent) {
        // VG2: Flyr/byter om HP är under 20%
        if (self.getCurrentHp() < self.getMaxHp() * 0.20) {
            for (BattleAction action : availableActions) {
                if (action instanceof FleeAction) {
                    return action;
                }
            }
        }
        return availableActions.get(0);
    }
}