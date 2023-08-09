package mvc.controller;

import mvc.view.impl.GameArea;

/**
 * GameLoop class, it controls the flow of the game.
 */
public interface GameLoop {
    /**
     * Loop method.
     * @param area the GameScreen that creates the GameArea.
     */
    void loop(GameArea area);

    /*/**
     * Setting up the game loop to be repeated every 2.5 seconds.
     * @param area GameArea to be painted.
     */
    /*void setupGameLoop(GameArea area);*/
}
