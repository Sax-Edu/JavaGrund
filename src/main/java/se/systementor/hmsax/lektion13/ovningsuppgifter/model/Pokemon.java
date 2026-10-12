package se.systementor.hmsax.lektion13.ovningsuppgifter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String id;
    private String name;
    private int hp;
    private List<String> attacks;

    // Default-konstruktor som krävs av Jackson
    public Pokemon() {
        this.id = UUID.randomUUID().toString(); // G8: Generera unikt ID
        this.attacks = new ArrayList<>();
    }

    public Pokemon(String name, int hp) {
        this();
        this.name = name;
        this.hp = hp;
    }

    public Pokemon(String name, int hp, List<String> attacks) {
        this(name, hp);
        this.attacks = attacks != null ? attacks : new ArrayList<>();
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }

    public List<String> getAttacks() { return attacks; }
    public void setAttacks(List<String> attacks) { this.attacks = attacks; }

    // G12.1 / L12: Override equals & hashCode för Set/Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon other)) return false;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " (" + hp + " HP)";
    }
}
