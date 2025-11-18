package model.components;

import java.util.Objects;
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

    public String getDescription() {return description;}

    public String getDuration()  {return duration;}

    public int getSets() {return sets;}

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrainingExercise that = (TrainingExercise) o;
        return sets == that.sets &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, duration, sets);
    }

    @Override
    public String toString() {
        return "TrainingExercise {" +
                "id: " + id + ",\n" +
                "name: " + name + ",\n" +
                "description: " +description + ",\n" +
                "duration: " + duration + ",\n" +
                "sets: " + sets + ",\n" +
                '}';
    }
}
