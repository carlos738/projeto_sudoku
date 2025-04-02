package org.example.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// enum para opções do menu
enum MenuOption{
    SELECT,
    START_GAME,
    ADD_NUMBER,
    REMOVE_NUMBER,
    VIEW_GAME,
    CHECK_STATUS,
    CLEAR_GAME,
    FINALIZE,
    EXIT
}
// CLASSE PRINCIPAL
public class IntegratedSudokuGame {
    private final JFrame frame;
    private final JPanel boardPanel;
    private final JButton[][] cells;
    private final int[][] board;

    public IntegratedSudokuGame(){
        frame = new JFrame("Sudoku");
        boardPanel = new JPanel(new GridLayout(9,9));
        cells = new JButton[9][9];
        board = new int[9][9];// Representa o estado do tabuleiro

        initializeBoard();

        // configurando o tabuleiro visual
        for (int row = 0;row < 9;row++){
            for (int col = 0;col < 9;col++){
                cells[row][col] = new JButton(board[row][col] == 0 ? "" : String.valueOf(board[row][col]));
                cells[row][col].setFont(new Font("Arial",Font.BOLD,20));
                cells[row][col].setEnabled(false);// desativa edição manual
                boardPanel.add(cells[row][col]);
            }
        }
        // PAINEL DO MENU
        JPanel menuPanel = new JPanel(new GridLayout(8,1));
        for (MenuOption option : MenuOption.values()){
            JButton button = new JButton(option.name());
            button.addActionListener(new MenuActionListener(option));
            menuPanel.add(button);
        }
        // Layout principal
        frame.setLayout(new BorderLayout());
        frame.add(boardPanel,BorderLayout.CENTER);
        frame.add(menuPanel,BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void initializeBoard(){
        // nºs iniciais do tabuleiro
        board[0][0] = 9;
        board[0][1] = 2;
        board[1][0] = 5;
        board[1][1] = 6;
        board[3][1] = 1;
    }
    // Listener do Menu
    private class MenuActionListener implements ActionListener{
        private final MenuOption option;

        public MenuActionListener(MenuOption option){
            this.option = option;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (option){
                case START_GAME -> JOptionPane.showMessageDialog(frame,"Jogo iniciado!");
                case ADD_NUMBER -> addNumber();
                case REMOVE_NUMBER -> removeNumber();
                case VIEW_GAME -> JOptionPane.showMessageDialog(frame,"Estado do tabuleiro atualizado!");
                case CHECK_STATUS -> checkGameStatus();
                case CLEAR_GAME -> clearBoard();
                case FINALIZE -> JOptionPane.showMessageDialog(frame,"Finalizando o jogo!");
                case EXIT -> frame.dispose();// fecha o programa
                default -> JOptionPane.showMessageDialog(frame,"Selecione uma opção válida!");

            }
        }
        private void addNumber(){
            String input = JOptionPane.showInputDialog(frame,"Digite linha, coluna e número (ex: 1,1,6)");
            if (input != null && !input.isBlank()){
               String[] parts = input.split(",");
               try{
                   int row = Integer.parseInt(parts[0]) - 1;
                   int col = Integer.parseInt(parts[1]) - 1;
                   int num = Integer.parseInt(parts[2]);
                   if (num >= 1 && num <= 9){
                       board[row][col] = num;
                       cells[row][col].setText(String.valueOf(num));
                   }else {
                       JOptionPane.showMessageDialog(frame,"Número inválido!");
                   }
               }catch (Exception ex){
                   JOptionPane.showMessageDialog(frame,"Entrada inválida!");

               }
            }
        }
        private void removeNumber() {
            String input = JOptionPane.showInputDialog(frame, "Digite linha e coluna para remover (ex: 1,1):");
            if (input != null && !input.isBlank()) {
                String[] parts = input.split(",");
                try {
                    int row = Integer.parseInt(parts[0]) - 1;
                    int col = Integer.parseInt(parts[1]) - 1;
                    board[row][col] = 0;
                    cells[row][col].setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                }
            }
        }
        private void clearBoard(){
            for (int row = 0;row < 9;row++){
                for (int col = 0;col < 9;col++){
                    board[row][col] = 0;
                    cells[row][col].setText("");
                }
            }

        }
        private void checkGameStatus(){
            boolean isComplete = true;
            for (int row = 0;row < 9;row++){
                for (int col = 0;col < 9;col++){
                    if (board[row][col] == 0){
                        isComplete = false;
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(frame,isComplete ? "O tabuleiro esta incompleto!" : "O tabuleiro não está completo. ");
        }


    }

    public static void main(String[] args) {
        new IntegratedSudokuGame();
    }
}
