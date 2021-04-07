package PatternMediator;

import PatternMediator.Components.*;
import PatternMediator.Mediator.Editor;
import PatternMediator.Mediator.Mediator;

import javax.swing.*;

/**
 * Демо-класс. Здесь всё сводится воедино.
 */
public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}