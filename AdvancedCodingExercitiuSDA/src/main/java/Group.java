import java.util.Set;

public class Group {

    public Group(){

    }

    private String groupName;
    private Trainer groupTrainer;
    private Set<Trainee> groupTrainees;

    public Group(String groupName, Trainer groupTrainer){
        this.groupName = groupName;
        this.groupTrainer= groupTrainer;
    }

    public String getGroupName() {
        return groupName;
    }

    public Trainer getGroupTrainer() {
        return groupTrainer;
    }

    public void setGroupTrainees(Set<Trainee> groupTrainees) {
        this.groupTrainees = groupTrainees;
    }

    public Set<Trainee> getGroupTrainees() {
        return groupTrainees;
    }

    public String toString(){
        return this.groupName + " - " + this.groupTrainer;
    }
}
