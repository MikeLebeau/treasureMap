package fr.mike.treasurMap;

import java.util.Arrays;
import java.util.List;

public class Sequence {

    private String actions;

    private List<Character> allowedAction = Arrays.asList('A', 'D', 'G');

    public Sequence(String actions) {
        for (char c : actions.toCharArray()) {
            if(!allowedAction.contains(c)){
                throw new UnsupportedOperationException("You're trying to execute an unsupported actions");
            }
        }

        this.actions = actions;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public List<Character> getAllowedAction() {
        return allowedAction;
    }

    public void setAllowedAction(List<Character> allowedAction) {
        this.allowedAction = allowedAction;
    }
}
