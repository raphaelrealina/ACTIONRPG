package skill;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    int value;
    List<Skill> children;

    public Skill(int value) {
        this.value = value;
        this.children = new ArrayList<Skill>();
    }
}