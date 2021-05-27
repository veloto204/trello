A trello board. It includes columns an cards inside each column. Every column and card has unique integer id

Please look into classes Board, Column and Card pf com.svaps.trello interface which describes trello board
You can use the these classes and their functions, you can add more properties (member variables) to the classes if needed, but not functions.

You need implement implement the following functions:

- com.svaps.trello.App.moveCard(int cardId, int sourceColumnId, int targetColumnId,  int position)
- com.svaps.trello.App.getColumnCards(int columnId)
- add tests into com.svaps.trello.App for testing them (3+ tests for moveCard and 3+ tests for getColumnCards)