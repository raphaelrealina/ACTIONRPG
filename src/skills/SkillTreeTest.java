public class SkillTreeTest {
    public static void main(String[] args) {
        //Test SkillTree class

        SkillTree tree = new SkillTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.traverseInOrder();
    }
}