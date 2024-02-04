package skill;

import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {
    public Skill rootSkill;

    public SkillTree() {
        this.rootSkill = null;
    }

    // Public Methods

    /**
     * Adds a skill to the skill tree.
     *
     * @param value the value of the skill to be added
     */
    public void learnSkill(int value) {
        rootSkill = learnSkillRecursive(rootSkill, value);
    }

    /**
     * Deletes a skill from the skill tree.
     *
     * @param value the value of the skill to be deleted
     */
    public void forgetSkill(int value) {
        rootSkill = forgetSkillRecursive(rootSkill, value);
    }

    /**
     * Checks if the skill tree contains a skill with the specified value.
     *
     * @param value the value of the skill to search for
     * @return true if the skill tree contains the skill, false otherwise
     */
    public boolean knowsSkill(int value) {
        return containsSkillRecursive(rootSkill, value);
    }

    /**
     * Performs an in-order traversal of the skill tree.
     */
    public void displayLearnedSkills() {
        knowsSkillRecursive(rootSkill);
    }

    /**
     * Performs a reverse in-order traversal of the skill tree.
     */
    public void displayLearnedSkillsInReverse() {
        traverseSkillsInReverseOrder(rootSkill);
    }

    /**
     * Performs a post-order traversal of the skill tree.
     *
     * @param current the current node in the traversal
     */
    public void displayLearnedSkillsPostOrder(Skill current) {
        traverseSkillsPostOrder(current);
    }

    /**
     * Performs a level-order traversal of the skill tree.
     */
    public void displayLearnedSkillsLevelOrder() {
        traverseSkillsLevelOrder(rootSkill);
    }

    // Private Methods

    /**
     * Recursively adds a skill to the skill tree.
     *
     * @param current the current node in the traversal
     * @param value   the value of the skill to be added
     * @return the root node of the updated skill tree
     */
    private Skill learnSkillRecursive(Skill current, int value) {
        if (current == null) {
            return new Skill(value);
        }

        if (value < current.value) {
            if (current.children.isEmpty()) {
                current.children.add(new Skill(value));
            } else {
                current.children.set(0, learnSkillRecursive(current.children.get(0), value));
            }
        } else if (value > current.value) {
            if (current.children.size() < 2) {
                current.children.add(new Skill(value));
            } else {
                current.children.set(1, learnSkillRecursive(current.children.get(1), value));
            }
        } else {
            return current; // Value already exists in the tree
        }

        return current;
    }

    /**
     * Recursively deletes a skill from the skill tree.
     *
     * @param current the current node in the traversal
     * @param value   the value of the skill to be deleted
     * @return the root node of the updated skill tree
     */
    private Skill forgetSkillRecursive(Skill current, int value) {
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

            // More than one child, find the inorder successor (smallest node in the right
            // subtree)
            current.value = findSmallestSkillValue(current.children.get(1));
            current.children.set(1, forgetSkillRecursive(current.children.get(1), current.value));
            return current;
        }

        if (value < current.value) {
            current.children.set(0, forgetSkillRecursive(current.children.get(0), value));
        } else {
            current.children.set(1, forgetSkillRecursive(current.children.get(1), value));
        }

        return current;
    }

    /**
     * Recursively performs an in-order traversal of the skill tree.
     *
     * @param current the current node in the traversal
     */
    private void knowsSkillRecursive(Skill current) {
        if (current != null) {
            if (!current.children.isEmpty()) {
                knowsSkillRecursive(current.children.get(0)); // Visit left subtree
            }
            System.out.print(current.value + " "); // Visit current node
            if (current.children.size() > 1) {
                knowsSkillRecursive(current.children.get(1)); // Visit right subtree
            }
        }
    }

    /**
     * Recursively finds the smallest value in the skill tree.
     *
     * @param current the current node in the traversal
     * @return the smallest value in the tree
     */
    private int findSmallestSkillValue(Skill current) {
        while (!current.children.isEmpty()) {
            current = current.children.get(0);
        }
        return current.value;
    }

    /**
     * Recursively checks if the skill tree contains a skill with the specified
     * value.
     *
     * @param current the current node in the traversal
     * @param value   the value of the skill to search for
     * @return true if the skill tree contains the skill, false otherwise
     */
    private boolean containsSkillRecursive(Skill current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        for (Skill skill : current.children) {
            if (containsSkillRecursive(skill, value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Recursively performs a reverse in-order traversal of the skill tree.
     *
     * @param current the current node in the traversal
     */
    private void traverseSkillsInReverseOrder(Skill current) {
        if (current != null) {
            for (int i = current.children.size() - 1; i >= 0; i--) {
                traverseSkillsInReverseOrder(current.children.get(i));
            }
            System.out.print(current.value + " ");
        }
    }

    /**
     * Recursively performs a post-order traversal of the skill tree.
     *
     * @param current the current node in the traversal
     */
    private void traverseSkillsPostOrder(Skill current) {
        if (current != null) {
            for (Skill skill : current.children) {
                traverseSkillsPostOrder(skill);
            }
            System.out.print(current.value + " ");
        }
    }

    /**
     * Recursively performs a level-order traversal of the skill tree.
     *
     * @param current the current node in the traversal
     */
    private void traverseSkillsLevelOrder(Skill current) {
        if (rootSkill == null) {
            return;
        }

        System.out.println("Level Order Traversal:");
        Queue<Skill> nodes = new LinkedList<>();
        nodes.add(rootSkill);

        while (!nodes.isEmpty()) {
            Skill node = nodes.remove();
            System.out.print(node.value + " ");
            nodes.addAll(node.children);
        }
        System.out.println();
    }
}