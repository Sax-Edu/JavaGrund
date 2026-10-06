package se.systementor.hmsax.lektion12.ovningsuppgifter.strategy;

import se.systementor.hmsax.lektion12.ovningsuppgifter.model.BattleAction;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.DamageAttack;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.Pokemon;

import java.util.List;

public class AggressiveStrategy implements CpuStrategy {
    @Override
    public BattleAction chooseAction(List<BattleAction> availableActions, Pokemon self, Pokemon opponent) {
        // VG1: Letar upp ett skadedrag, annars tas första bästa
        for (BattleAction action : availableActions) {
            if (action instanceof DamageAttack) {
                return action;
            }
        }
        return availableActions.get(0);
    }
}
