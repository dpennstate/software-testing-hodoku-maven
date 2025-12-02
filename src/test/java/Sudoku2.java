import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Sudoku2 {

    // Test 1: setSudoku loads a valid puzzle
    //
    @Test
    void SetSudokuLoadValidPuzzle() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        // This is an example
        String init =
        """
        +-------+-------+-------+
        | 5 3 0 | . 7 . | . . . |
        | 6 . . | 1 . . | . . . |
        | . . . | . . . | . . . |
        +-------+-------+-------+
        | . . . | . . . | . . . |
        | . . . | . . . | . . . |
        | . . . | . . . | . . . |
        +-------+-------+-------+
        | . . . | . . . | . . . |
        | . . . | . . . | . . . |
        | . . . | . . . | . 7 9 |
        +-------+-------+-------+
        """;

        // Act

        testSudoku2.setSudoku(init, true);

        // Assert

        assertEquals(testSudoku2.getValue(0, 0), 5);
        assertEquals(testSudoku2.getValue(0, 1), 3);
        assertEquals(testSudoku2.getValue(0, 2), 0);
        assertEquals(testSudoku2.getValue(0, 4), 7);
        assertEquals(testSudoku2.getValue(1, 0), 6);
        assertEquals(testSudoku2.getValue(1, 3), 1);
        assertEquals(testSudoku2.getValue(8, 7), 7);
        assertEquals(testSudoku2.getValue(8, 8), 9);
    }
}
