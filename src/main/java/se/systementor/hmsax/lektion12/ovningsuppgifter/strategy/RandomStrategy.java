package se.systementor.hmsax.lektion12.ovningsuppgifter.strategy;

import se.systementor.hmsax.lektion12.ovningsuppgifter.model.BattleAction;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.Pokemon;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements CpuStrategy {
    private final Random random = new Random();

    @Override
    public BattleAction chooseAction(List<BattleAction> availableActions, Pokemon self, Pokemon opponent) {
        int index = random.nextInt(availableActions.size());
        return availableActions.get(index);
    }
}