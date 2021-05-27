package com.svaps.trello;

import java.util.ArrayList;
import java.util.List;

/**
 * Board
 */
class Board {

    private List<Column> columns = new ArrayList<Column>();

    public Column getColumnById(int id) {
        for (Column column : columns) {
            if (column.getId() == id) {
                return column;
            }
        }
        return null;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }
}
