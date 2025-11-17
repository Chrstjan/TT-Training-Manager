package model.components;

import java.util.UUID;

public class TrainingExercise {
    private final UUID id;

    private String name;
    private String description;
    private String duration;
    private int sets;

    public TrainingExercise(String name, String description, String duration, int sets) {
        this(UUID.randomUUID(), name, description, duration, sets);
    }

    public TrainingExercise(UUID uuid, String name, String description, String duration, int sets) {
        this.id = uuid;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.sets = sets;
    }

    public UUID getId() {return id;}

    public String getName() {return name;}
}
