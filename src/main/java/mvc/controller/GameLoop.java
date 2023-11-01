package mvc.controller;

import mvc.view.GameArea;

/**
 * GameLoop class, it controls the flow of the game.
 */
public interface GameLoop {
    /**
     * Loop method.
     * @param area the GameScreen that creates the GameArea.
     */
    void loop(GameArea area);
}
