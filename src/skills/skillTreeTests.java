import org.junit.jupiter.api.Test;

public class skillTreeTests {
    @Test
    public void testAdd() {
        SkillTree skillTree = createSkillTree();
        assertTrue(skillTree.contains(6));
        assertTrue(skillTree.contains(4));
        assertTrue(skillTree.contains(8));
        assertTrue(skillTree.contains(3));
        assertTrue(skillTree.contains(5));
        assertTrue(skillTree.contains(7));
        assertTrue(skillTree.contains(9));
    }

    @Test
    public void testDelete() {
        SkillTree skillTree = createSkillTree();
        assertTrue(skillTree.contains(6));
        skillTree.delete(6);
        assertFalse(skillTree.contains(6));
    }

    @Test
    public void testFindSmallestValue() {
        SkillTree skillTree = createSkillTree();
        assertEquals(3, skillTree.findSmallestValue());
    }

    @Test
    public void testContains() {
        SkillTree skillTree = createSkillTree();
        assertTrue(skillTree.contains(6));
        assertFalse(skillTree.contains(1));
    }
}
