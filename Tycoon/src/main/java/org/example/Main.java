package org.example;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.example.controllers.GameController;
import org.example.view.console.GameMenu;
import org.example.view.console.GameSecondView;
import org.example.view.console.GameView;
import org.example.view.console.LeaveGame;

public class Main {
    public static void main(String[] args) {


        try {
            // Tworzenie terminala
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            TerminalScreen screen = new TerminalScreen(terminal);
            screen.startScreen();

            // Ustawienia menu
            GameView gameView = new GameView(screen);
            GameSecondView gameSecondView = new GameSecondView(screen);
            GameMenu menu = new GameMenu(screen);
            LeaveGame leaveGame = new LeaveGame(screen);
            GameController gameController = new GameController(gameView, gameSecondView, menu, leaveGame, screen);

            gameController.startGameLoop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


