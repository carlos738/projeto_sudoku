1. Criação da estrutura básica
   Define a classe principal IntegratedSudokuGame, que é responsável por gerenciar toda a lógica e interface do jogo.

Utiliza um array 2D (int[][] board) para representar o estado do tabuleiro, onde cada célula pode conter números de 1 a 9 ou ser vazia (valor 0).

Inicializa os números iniciais do tabuleiro (9, 6, 5, 2, 1) em algumas células.

2. Interface gráfica com Swing
   O tabuleiro visual é implementado usando um painel (JPanel) com layout de grade (GridLayout) 9x9, preenchido com botões (JButton) que representam as células.

Cada botão exibe os números do tabuleiro ou fica vazio para células sem números.

Um painel adicional exibe as opções do menu, com botões para cada funcionalidade solicitada.

3. Enumeração para opções do menu
   Cria um enum MenuOption com as opções do menu: iniciar jogo, adicionar número, remover número, visualizar jogo, verificar status, limpar tabuleiro, finalizar e sair.

O enum organiza as ações de maneira clara e facilita a implementação dos botões.

4. Implementação das funcionalidades
   Adicionar número: Permite ao jogador inserir um número em uma célula específica, verificando se o número está no intervalo de 1 a 9.

Remover número: Remove o número de uma célula escolhida pelo jogador, tornando-a vazia.

Limpar tabuleiro: Reseta o tabuleiro inteiro, deixando todas as células vazias.

Verificar status: Checa se o tabuleiro está completo ou ainda possui células vazias.

Outras ações: Como iniciar o jogo, visualizar o estado atual e finalizar.

5. Integração de lógica e interface
   Cada ação do menu está vinculada ao tabuleiro visual e atualiza os botões (células) conforme as mudanças feitas pelo jogador.

Exibe mensagens ao jogador com JOptionPane para garantir uma interação amigável e intuitiva.