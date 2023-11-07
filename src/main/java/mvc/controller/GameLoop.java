package mvc.controller;

import mvc.view.GameArea;

/**
 * GameLoop class, it controls the flow of the game.
 */
public interface GameLoop {
    /**
     * Loop method.
     * @param area the GameArea.
     */
    void loop(GameArea area);
    /**
     * Redraw the game area method.
     * @param area the middle area to redraw.
     */
    void redraw(GameArea area);
}
