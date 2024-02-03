import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkillTreeTest {
    public static void main(String[] args) {
        SkillTree skillTree = new SkillTree();
        skillTree.add(6);
        skillTree.add(4);
        skillTree.add(8);
        skillTree.add(3);
        skillTree.add(5);
        skillTree.add(7);
        skillTree.add(9);
        skillTree.traverseInOrder();
        System.out.println("\n");
        skillTree.traverseInReverse();

        assertTrue(skillTree.containsSkill(6));
        assertTrue(skillTree.containsSkill(4));
        assertTrue(skillTree.containsSkill(8));
        assertTrue(skillTree.containsSkill(3));
        assertTrue(skillTree.containsSkill(5));
        assertTrue(skillTree.containsSkill(7));
        assertTrue(skillTree.containsSkill(9));

        //go through tree and add all values to a list
        //then check if list contains all values

        for (int i = 0; i < 10; i++) {
            skillTree.add(i);
        }

        for (int i = 0; i < 10; i++) {
            assertTrue(skillTree.containsSkill(i));
        }


    }
}