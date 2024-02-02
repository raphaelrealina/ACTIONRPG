public class SkillTree {
    Skill rootSkill;

    private Skill addRecursive(Skill current, int value) {
        if (current == null) {
            return new Skill(value);
        }

        if (value < current.value) {
            current.children.add(addRecursive(current, value));
        } else if (value > current.value) {
            current.children.add(addRecursive(current, value));
        } else {
            return current;
        }

        return current;
    }

    private Skill deleteRecursive(Skill current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.children.isEmpty()) {
                return null;
            }

            if (current.children.size() == 1) {
                return current.children.get(0);
            }
        }

        if (value < current.value) {
            current.children.add(deleteRecursive(current, value));
            return current;
        }

        return current;
    }

    private int findSmallestValue(Skill rootSkill) {
        return rootSkill.children.isEmpty() ? rootSkill.value : findSmallestValue(rootSkill.children.get(0));
    }

    private SkillTree createSkillTree() {
        SkillTree skillTree = new SkillTree();
        skillTree.add(6);
        skillTree.add(4);
        skillTree.add(8);
        skillTree.add(3);
        skillTree.add(5);
        skillTree.add(7);
        skillTree.add(9);

        return skillTree;
    }

    private boolean containsSkillRecursive(Skill current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        for (Skill Skill : current.children) {
            if (containsSkillRecursive(Skill, value)) {
                return true;
            }
        }

        return false;
    }

    public void add(int value) {
        rootSkill = addRecursive(rootSkill, value);
    }

    public void delete(int value) {
        rootSkill = deleteRecursive(rootSkill, value);
    }

    public boolean containsSkill(int value) {
        return containsSkillRecursive(rootSkill, value);
    }

}
