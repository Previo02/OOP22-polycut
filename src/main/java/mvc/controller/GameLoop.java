package mvc.controller;

import mvc.view.impl.GameScreen;

/**
 * GameLoop class, it controls the flow of the game.
 */
public interface GameLoop {
    /**
     * Loop method.
     * @param screen the GameScreen that creates the GameArea.
     */
    void loop(GameScreen screen);
}
