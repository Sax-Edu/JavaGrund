package se.systementor.hmsax.lektion12.ovningsuppgifter.player;

import se.systementor.hmsax.lektion12.ovningsuppgifter.model.BattleAction;
import se.systementor.hmsax.lektion12.ovningsuppgifter.model.Pokemon;
import se.systementor.hmsax.lektion12.ovningsuppgifter.strategy.CpuStrategy;

import java.util.List;

public class CpuPlayer {
    private final CpuStrategy strategy;

    // G9: Dependency Injection via konstruktorn
    public CpuPlayer(CpuStrategy strategy) {
        this.strategy = strategy;
    }

    public BattleAction selectAction(List<BattleAction> actions, Pokemon self, Pokemon opponent) {
        System.out.println("CPU:n funderar...");
        return strategy.chooseAction(actions, self, opponent); // Degelerar till strategin
    }
}
