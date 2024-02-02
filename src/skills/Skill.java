import java.util.ArrayList;
import java.util.List;

class Skill {
    int value;
    List<Skill> children;

    Skill(int value) {
        this.value = value;
        this.children = new ArrayList<Skill>();
    }
}