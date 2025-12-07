import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class Sudoku2 {

    // Test S1: setSudoku loads an invalid puzzle
    // Parameters: init = "abcd", saveInitialState = false
    @Test
    void SetSudokuLoadInValidPuzzle() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                abcd
                """;

        // Act

        // Assert

        // Note that a null pointer exception which would cause the application to crash
        // Don't do this Assertion. We want this to fail like it does. Assert that the application doesn't crash?
        assertThrows(NullPointerException.class,
                () -> {
                    testSudoku2.setSudoku(init, false);
                });
    }

    // Test S2: setSudoku loads an invalid puzzle
    // Parameters: init = "abcd", saveInitialState = true
    @Test
    void SetSudokuLoadInValidPuzzle2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                abcd
                """;

        // Act

        // Assert
        // Note that a null pointer exception which would cause the application to crash
        assertThrows(NullPointerException.class,
                () -> {
                    testSudoku2.setSudoku(init, true);
                });
    }

    // Test S3: setSudoku loads a valid 81 character puzzle
    // Parameters: init = 81 character string with givens (line may contain comments started with '#'),
    // saveInitialState = false
    @Test
    void SetSudokuLoadValid81Puzzle() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init = "530.7....6..1..................................................................79";

        // Act

        testSudoku2.setSudoku(init, false);

        // Assert
        assertEquals(5,testSudoku2.getValue(0, 0));
        assertEquals(3, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(7, testSudoku2.getValue(0, 4));
        assertEquals(0, testSudoku2.getValue(0, 5));
        assertEquals(0, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(0, testSudoku2.getValue(0, 8));

        assertEquals(6, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(1, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(0, testSudoku2.getValue(1, 6));
        assertEquals(0, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(0, testSudoku2.getValue(2, 1));
        assertEquals(0, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(0, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(0, testSudoku2.getValue(2, 6));
        assertEquals(0, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(0, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(0, testSudoku2.getValue(3, 4));
        assertEquals(0, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(0, testSudoku2.getValue(4, 1));
        assertEquals(0, testSudoku2.getValue(4, 2));
        assertEquals(0, testSudoku2.getValue(4, 3));
        assertEquals(0, testSudoku2.getValue(4, 4));
        assertEquals(0, testSudoku2.getValue(4, 5));
        assertEquals(0, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(0, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(0, testSudoku2.getValue(5, 3));
        assertEquals(0, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(0, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(0, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(0, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(0, testSudoku2.getValue(6, 6));
        assertEquals(0, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(0, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(0, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(0, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(0, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(0, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(0, testSudoku2.getValue(8, 6));
        assertEquals(7, testSudoku2.getValue(8, 7));
        assertEquals(9, testSudoku2.getValue(8, 8));
    }

    // Test S4: setSudoku loads a valid 81 character puzzle
    // Parameters: init = 81 character string with givens (line may contain comments started with '#'),
    // saveInitialState = true
    @Test
    void SetSudokuLoadValid81Puzzle2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init = "530.7....6..1..................................................................79";


        // Act

        testSudoku2.setSudoku(init, true);

        // Assert
        // Assert

        assertEquals(5,testSudoku2.getValue(0, 0));
        assertEquals(3, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(7, testSudoku2.getValue(0, 4));
        assertEquals(0, testSudoku2.getValue(0, 5));
        assertEquals(0, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(0, testSudoku2.getValue(0, 8));

        assertEquals(6, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(1, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(0, testSudoku2.getValue(1, 6));
        assertEquals(0, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(0, testSudoku2.getValue(2, 1));
        assertEquals(0, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(0, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(0, testSudoku2.getValue(2, 6));
        assertEquals(0, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(0, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(0, testSudoku2.getValue(3, 4));
        assertEquals(0, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(0, testSudoku2.getValue(4, 1));
        assertEquals(0, testSudoku2.getValue(4, 2));
        assertEquals(0, testSudoku2.getValue(4, 3));
        assertEquals(0, testSudoku2.getValue(4, 4));
        assertEquals(0, testSudoku2.getValue(4, 5));
        assertEquals(0, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(0, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(0, testSudoku2.getValue(5, 3));
        assertEquals(0, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(0, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(0, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(0, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(0, testSudoku2.getValue(6, 6));
        assertEquals(0, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(0, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(0, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(0, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(0, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(0, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(0, testSudoku2.getValue(8, 6));
        assertEquals(7, testSudoku2.getValue(8, 7));
        assertEquals(9, testSudoku2.getValue(8, 8));
    }

    // Test S5: setSudoku loads a HoDoKuLine puzzle
    // Parameters: init = HoDoKuLine string
    // saveInitialState = false
    @Test
    void SetSudokuLoadHoDoKuLinePuzzle() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init = ":0003:8:6...+53+4.7....4+2+56.+254867+3+9+1.+4..+9+6.1.162+38+5749.3..+1+4.+5....42193..1.+57...+44+2.6+3.+1+75:::829:";

        // Note above init create this grid from the string: "6...534.7....4256.254867391.4..96.1.162385749.3..14.5....42193..1.57...442.63.175"

        //                +-------+-------+-------+
        //                | 6 . . | . 5 3 | 4 . 7 |
        //                | . . . | . 4 2 | 5 6 . |
        //                | 2 5 4 | 8 6 7 | 3 9 1 |
        //                +-------+-------+-------+
        //                | . 4 . | . 9 6 | . 1 . |
        //                | 1 6 2 | 3 8 5 | 7 4 9 |
        //                | . 3 . | . 1 4 | . 5 . |
        //                +-------+-------+-------+
        //                | . . . | 4 2 1 | 9 3 . |
        //                | . 1 . | 5 7 . | . . 4 |
        //                | 4 2 . | 6 3 . | 1 7 5 |
        //                +-------+-------+-------+
        //                """;

        // Act

        testSudoku2.setSudoku(init, false);

        // Assert
        assertEquals(6,testSudoku2.getValue(0, 0));
        assertEquals(0, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(5, testSudoku2.getValue(0, 4));
        assertEquals(3, testSudoku2.getValue(0, 5));
        assertEquals(4, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(7, testSudoku2.getValue(0, 8));

        assertEquals(0, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(0, testSudoku2.getValue(1, 3));
        assertEquals(4, testSudoku2.getValue(1, 4));
        assertEquals(2, testSudoku2.getValue(1, 5));
        assertEquals(5, testSudoku2.getValue(1, 6));
        assertEquals(6, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(2, testSudoku2.getValue(2, 0));
        assertEquals(5, testSudoku2.getValue(2, 1));
        assertEquals(4, testSudoku2.getValue(2, 2) );
        assertEquals(8, testSudoku2.getValue(2, 3));
        assertEquals(6, testSudoku2.getValue(2, 4));
        assertEquals(7, testSudoku2.getValue(2, 5));
        assertEquals(3, testSudoku2.getValue(2, 6));
        assertEquals(9, testSudoku2.getValue(2, 7));
        assertEquals(1, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(4, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(9, testSudoku2.getValue(3, 4));
        assertEquals(6, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(1, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(1, testSudoku2.getValue(4, 0));
        assertEquals(6, testSudoku2.getValue(4, 1));
        assertEquals(2, testSudoku2.getValue(4, 2));
        assertEquals(3, testSudoku2.getValue(4, 3));
        assertEquals(8, testSudoku2.getValue(4, 4));
        assertEquals(5, testSudoku2.getValue(4, 5));
        assertEquals(7, testSudoku2.getValue(4, 6));
        assertEquals(4, testSudoku2.getValue(4, 7));
        assertEquals(9, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(3, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(0, testSudoku2.getValue(5, 3));
        assertEquals(1, testSudoku2.getValue(5, 4));
        assertEquals(4, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(5, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(0, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(4, testSudoku2.getValue(6, 3));
        assertEquals(2, testSudoku2.getValue(6, 4));
        assertEquals(1, testSudoku2.getValue(6, 5));
        assertEquals(9, testSudoku2.getValue(6, 6));
        assertEquals(3, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(1, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(5, testSudoku2.getValue(7, 3));
        assertEquals(7, testSudoku2.getValue(7, 4));
        assertEquals(0, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(4, testSudoku2.getValue(7, 8));

        assertEquals(4, testSudoku2.getValue(8, 0));
        assertEquals(2, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(6, testSudoku2.getValue(8, 3));
        assertEquals(3, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(1, testSudoku2.getValue(8, 6));
        assertEquals(7, testSudoku2.getValue(8, 7));
        assertEquals(5, testSudoku2.getValue(8, 8));
    }

    // Test S6: setSudoku loads a HoDoKuLine puzzle
    // Parameters: init = HoDoKuLine string
    // saveInitialState = true    //
    @Test
    void SetSudokuLoadHoDoKuLinePuzzle2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init = ":0003:8:6...+53+4.7....4+2+56.+254867+3+9+1.+4..+9+6.1.162+38+5749.3..+1+4.+5....42193..1.+57...+44+2.6+3.+1+75:::829:";

        // Note above init create this grid from the string: "6...534.7....4256.254867391.4..96.1.162385749.3..14.5....42193..1.57...442.63.175"

        //                +-------+-------+-------+
        //                | 6 . . | . 5 3 | 4 . 7 |
        //                | . . . | . 4 2 | 5 6 . |
        //                | 2 5 4 | 8 6 7 | 3 9 1 |
        //                +-------+-------+-------+
        //                | . 4 . | . 9 6 | . 1 . |
        //                | 1 6 2 | 3 8 5 | 7 4 9 |
        //                | . 3 . | . 1 4 | . 5 . |
        //                +-------+-------+-------+
        //                | . . . | 4 2 1 | 9 3 . |
        //                | . 1 . | 5 7 . | . . 4 |
        //                | 4 2 . | 6 3 . | 1 7 5 |
        //                +-------+-------+-------+
        //                """;

        // Act

        testSudoku2.setSudoku(init, true);

        // Assert
        assertEquals(6,testSudoku2.getValue(0, 0));
        assertEquals(0, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(5, testSudoku2.getValue(0, 4));
        assertEquals(3, testSudoku2.getValue(0, 5));
        assertEquals(4, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(7, testSudoku2.getValue(0, 8));

        assertEquals(0, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(0, testSudoku2.getValue(1, 3));
        assertEquals(4, testSudoku2.getValue(1, 4));
        assertEquals(2, testSudoku2.getValue(1, 5));
        assertEquals(5, testSudoku2.getValue(1, 6));
        assertEquals(6, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(2, testSudoku2.getValue(2, 0));
        assertEquals(5, testSudoku2.getValue(2, 1));
        assertEquals(4, testSudoku2.getValue(2, 2) );
        assertEquals(8, testSudoku2.getValue(2, 3));
        assertEquals(6, testSudoku2.getValue(2, 4));
        assertEquals(7, testSudoku2.getValue(2, 5));
        assertEquals(3, testSudoku2.getValue(2, 6));
        assertEquals(9, testSudoku2.getValue(2, 7));
        assertEquals(1, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(4, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(9, testSudoku2.getValue(3, 4));
        assertEquals(6, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(1, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(1, testSudoku2.getValue(4, 0));
        assertEquals(6, testSudoku2.getValue(4, 1));
        assertEquals(2, testSudoku2.getValue(4, 2));
        assertEquals(3, testSudoku2.getValue(4, 3));
        assertEquals(8, testSudoku2.getValue(4, 4));
        assertEquals(5, testSudoku2.getValue(4, 5));
        assertEquals(7, testSudoku2.getValue(4, 6));
        assertEquals(4, testSudoku2.getValue(4, 7));
        assertEquals(9, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(3, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(0, testSudoku2.getValue(5, 3));
        assertEquals(1, testSudoku2.getValue(5, 4));
        assertEquals(4, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(5, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(0, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(4, testSudoku2.getValue(6, 3));
        assertEquals(2, testSudoku2.getValue(6, 4));
        assertEquals(1, testSudoku2.getValue(6, 5));
        assertEquals(9, testSudoku2.getValue(6, 6));
        assertEquals(3, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(1, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(5, testSudoku2.getValue(7, 3));
        assertEquals(7, testSudoku2.getValue(7, 4));
        assertEquals(0, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(4, testSudoku2.getValue(7, 8));

        assertEquals(4, testSudoku2.getValue(8, 0));
        assertEquals(2, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(6, testSudoku2.getValue(8, 3));
        assertEquals(3, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(1, testSudoku2.getValue(8, 6));
        assertEquals(7, testSudoku2.getValue(8, 7));
        assertEquals(5, testSudoku2.getValue(8, 8));
    }

    // Test S7: setSudoku loads a Q2 puzzle
    // Parameters: init = Q2 string
    // saveInitialState = false    //
    @Test
    void SetSudokuLoadQ2Puzzle() throws IOException {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        Path filePath = Path.of("src/test/resources/q2-taxonomy.txt");

        String q2Data = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] q2DataArray = q2Data.split("\\R", -1);

        String init = q2DataArray[0];

        // This is the data for the grid that will be set
        // 100000002090400050006000700050903000000070000000850040700000600030009080002000001

        // Act

        testSudoku2.setSudoku(init, false);

        // Assert

        // Assert
        assertEquals(1,testSudoku2.getValue(0, 0));
        assertEquals(0, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(0, testSudoku2.getValue(0, 4));
        assertEquals(0, testSudoku2.getValue(0, 5));
        assertEquals(0, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(2, testSudoku2.getValue(0, 8));

        assertEquals(0, testSudoku2.getValue(1, 0));
        assertEquals(9, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(4, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(0, testSudoku2.getValue(1, 6));
        assertEquals(5, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(0, testSudoku2.getValue(2, 1));
        assertEquals(6, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(0, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(7, testSudoku2.getValue(2, 6));
        assertEquals(0, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(5, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(9, testSudoku2.getValue(3, 3));
        assertEquals(0, testSudoku2.getValue(3, 4));
        assertEquals(3, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(0, testSudoku2.getValue(4, 1));
        assertEquals(0, testSudoku2.getValue(4, 2));
        assertEquals(0, testSudoku2.getValue(4, 3));
        assertEquals(7, testSudoku2.getValue(4, 4));
        assertEquals(0, testSudoku2.getValue(4, 5));
        assertEquals(0, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(0, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(8, testSudoku2.getValue(5, 3));
        assertEquals(5, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(4, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(7, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(0, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(6, testSudoku2.getValue(6, 6));
        assertEquals(0, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(3, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(0, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(9, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(8, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(0, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(2, testSudoku2.getValue(8, 2));
        assertEquals(0, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(0, testSudoku2.getValue(8, 6));
        assertEquals(0, testSudoku2.getValue(8, 7));
        assertEquals(1, testSudoku2.getValue(8, 8));
    }

    // Test S8: setSudoku loads a Q2 puzzle
    // Parameters: init = Q2 string
    // saveInitialState = true    //
    @Test
    void SetSudokuLoadQ2Puzzle2() throws IOException {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        Path filePath = Path.of("src/test/resources/q2-taxonomy.txt");

        String q2Data = Files.readString(filePath, StandardCharsets.UTF_8);

        String[] q2DataArray = q2Data.split("\\R", -1);

        String init = q2DataArray[0];

        // This is the data for the grid that will be set
        // 100000002090400050006000700050903000000070000000850040700000600030009080002000001

        // Act

        testSudoku2.setSudoku(init, true);

        // Assert

        // Assert
        assertEquals(1,testSudoku2.getValue(0, 0));
        assertEquals(0, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(0, testSudoku2.getValue(0, 4));
        assertEquals(0, testSudoku2.getValue(0, 5));
        assertEquals(0, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(2, testSudoku2.getValue(0, 8));

        assertEquals(0, testSudoku2.getValue(1, 0));
        assertEquals(9, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(4, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(0, testSudoku2.getValue(1, 6));
        assertEquals(5, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(0, testSudoku2.getValue(2, 1));
        assertEquals(6, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(0, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(7, testSudoku2.getValue(2, 6));
        assertEquals(0, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(5, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(9, testSudoku2.getValue(3, 3));
        assertEquals(0, testSudoku2.getValue(3, 4));
        assertEquals(3, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(0, testSudoku2.getValue(4, 1));
        assertEquals(0, testSudoku2.getValue(4, 2));
        assertEquals(0, testSudoku2.getValue(4, 3));
        assertEquals(7, testSudoku2.getValue(4, 4));
        assertEquals(0, testSudoku2.getValue(4, 5));
        assertEquals(0, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(0, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(8, testSudoku2.getValue(5, 3));
        assertEquals(5, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(4, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(7, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(0, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(6, testSudoku2.getValue(6, 6));
        assertEquals(0, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(3, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(0, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(9, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(8, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(0, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(2, testSudoku2.getValue(8, 2));
        assertEquals(0, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(0, testSudoku2.getValue(8, 6));
        assertEquals(0, testSudoku2.getValue(8, 7));
        assertEquals(1, testSudoku2.getValue(8, 8));
    }

    // Test S9: setSudoku loads a SimpleGrid puzzle
    // Parameters: init = SimpleGrid string
    // saveInitialState = false    //
    @Test
    void SetSudokuLoadSimpleGridPuzzle() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

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

        testSudoku2.setSudoku(init, false);

        // Assert
        assertEquals(5,testSudoku2.getValue(0, 0));
        assertEquals(3, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(7, testSudoku2.getValue(0, 4));
        assertEquals(0, testSudoku2.getValue(0, 5));
        assertEquals(0, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(0, testSudoku2.getValue(0, 8));

        assertEquals(6, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(1, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(0, testSudoku2.getValue(1, 6));
        assertEquals(0, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(0, testSudoku2.getValue(2, 1));
        assertEquals(0, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(0, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(0, testSudoku2.getValue(2, 6));
        assertEquals(0, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(0, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(0, testSudoku2.getValue(3, 4));
        assertEquals(0, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(0, testSudoku2.getValue(4, 1));
        assertEquals(0, testSudoku2.getValue(4, 2));
        assertEquals(0, testSudoku2.getValue(4, 3));
        assertEquals(0, testSudoku2.getValue(4, 4));
        assertEquals(0, testSudoku2.getValue(4, 5));
        assertEquals(0, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(0, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(0, testSudoku2.getValue(5, 3));
        assertEquals(0, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(0, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(0, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(0, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(0, testSudoku2.getValue(6, 6));
        assertEquals(0, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(0, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(0, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(0, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(0, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(0, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(0, testSudoku2.getValue(8, 6));
        assertEquals(7, testSudoku2.getValue(8, 7));
        assertEquals(9, testSudoku2.getValue(8, 8));
    }

    // Test S10: setSudoku loads a SimpleGrid puzzle
    // Parameters: init = SimpleGrid string
    // saveInitialState = true    //
    @Test
    void SetSudokuLoadSimpleGridPuzzle2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

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

        assertEquals(5,testSudoku2.getValue(0, 0));
        assertEquals(3, testSudoku2.getValue(0, 1));
        assertEquals(0, testSudoku2.getValue(0, 2));
        assertEquals(0, testSudoku2.getValue(0, 3));
        assertEquals(7, testSudoku2.getValue(0, 4));
        assertEquals(0, testSudoku2.getValue(0, 5));
        assertEquals(0, testSudoku2.getValue(0, 6));
        assertEquals(0, testSudoku2.getValue(0, 7));
        assertEquals(0, testSudoku2.getValue(0, 8));

        assertEquals(6, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(0, testSudoku2.getValue(1, 2));
        assertEquals(1, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(0, testSudoku2.getValue(1, 6));
        assertEquals(0, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(0, testSudoku2.getValue(2, 1));
        assertEquals(0, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(0, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(0, testSudoku2.getValue(2, 6));
        assertEquals(0, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(0, testSudoku2.getValue(3, 0));
        assertEquals(0, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(0, testSudoku2.getValue(3, 4));
        assertEquals(0, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(0, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(0, testSudoku2.getValue(4, 1));
        assertEquals(0, testSudoku2.getValue(4, 2));
        assertEquals(0, testSudoku2.getValue(4, 3));
        assertEquals(0, testSudoku2.getValue(4, 4));
        assertEquals(0, testSudoku2.getValue(4, 5));
        assertEquals(0, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(0, testSudoku2.getValue(5, 0));
        assertEquals(0, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(0, testSudoku2.getValue(5, 3));
        assertEquals(0, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(0, testSudoku2.getValue(5, 7));
        assertEquals(0, testSudoku2.getValue(5, 8));

        assertEquals(0, testSudoku2.getValue(6, 0));
        assertEquals(0, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(0, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(0, testSudoku2.getValue(6, 6));
        assertEquals(0, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(0, testSudoku2.getValue(7, 0));
        assertEquals(0, testSudoku2.getValue(7, 1));
        assertEquals(0, testSudoku2.getValue(7, 2));
        assertEquals(0, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(0, testSudoku2.getValue(7, 5));
        assertEquals(0, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(0, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(0, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(0, testSudoku2.getValue(8, 5));
        assertEquals(0, testSudoku2.getValue(8, 6));
        assertEquals(7, testSudoku2.getValue(8, 7));
        assertEquals(9, testSudoku2.getValue(8, 8));
    }

    // Test S11: setSudoku loads a PMGrid puzzle
    // Parameters: init = PMGrid string
    // saveInitialState = false    //
    @Test
    void SetSudokuLoadPMGridPuzzle() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        // Act

        testSudoku2.setSudoku(init, false);

        // Assert

        assertEquals(6,testSudoku2.getValue(0, 0));
        assertEquals(0, testSudoku2.getValue(0, 1));
        assertEquals(2, testSudoku2.getValue(0, 2));
        assertEquals(3, testSudoku2.getValue(0, 3));
        assertEquals(0, testSudoku2.getValue(0, 4));
        assertEquals(5, testSudoku2.getValue(0, 5));
        assertEquals(4, testSudoku2.getValue(0, 6));
        assertEquals(8, testSudoku2.getValue(0, 7));
        assertEquals(7, testSudoku2.getValue(0, 8));

        assertEquals(0, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(4, testSudoku2.getValue(1, 2));
        assertEquals(0, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(3, testSudoku2.getValue(1, 6));
        assertEquals(0, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(3, testSudoku2.getValue(2, 1));
        assertEquals(0, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(4, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(0, testSudoku2.getValue(2, 6));
        assertEquals(6, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(3, testSudoku2.getValue(3, 0));
        assertEquals(0, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(2, testSudoku2.getValue(3, 4));
        assertEquals(0, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(4, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(4, testSudoku2.getValue(4, 1));
        assertEquals(1, testSudoku2.getValue(4, 2));
        assertEquals(6, testSudoku2.getValue(4, 3));
        assertEquals(0, testSudoku2.getValue(4, 4));
        assertEquals(8, testSudoku2.getValue(4, 5));
        assertEquals(2, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(9, testSudoku2.getValue(5, 0));
        assertEquals(2, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(4, testSudoku2.getValue(5, 3));
        assertEquals(5, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(0, testSudoku2.getValue(5, 7));
        assertEquals(8, testSudoku2.getValue(5, 8));

        assertEquals(2, testSudoku2.getValue(6, 0));
        assertEquals(5, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(8, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(0, testSudoku2.getValue(6, 6));
        assertEquals(4, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(4, testSudoku2.getValue(7, 0));
        assertEquals(0, testSudoku2.getValue(7, 1));
        assertEquals(9, testSudoku2.getValue(7, 2));
        assertEquals(5, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(2, testSudoku2.getValue(7, 5));
        assertEquals(8, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(1, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(9, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(4, testSudoku2.getValue(8, 5));
        assertEquals(5, testSudoku2.getValue(8, 6));
        assertEquals(2, testSudoku2.getValue(8, 7));
        assertEquals(6, testSudoku2.getValue(8, 8));
    }

    // Test S12: setSudoku loads a PMGrid puzzle
    // Parameters: init = PMGrid string
    // saveInitialState = true    //
    @Test
    void SetSudokuLoadPMGridPuzzle2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        // Act
        testSudoku2.setSudoku(init, true);

        // Assert
        assertEquals(6,testSudoku2.getValue(0, 0));
        assertEquals(0, testSudoku2.getValue(0, 1));
        assertEquals(2, testSudoku2.getValue(0, 2));
        assertEquals(3, testSudoku2.getValue(0, 3));
        assertEquals(0, testSudoku2.getValue(0, 4));
        assertEquals(5, testSudoku2.getValue(0, 5));
        assertEquals(4, testSudoku2.getValue(0, 6));
        assertEquals(8, testSudoku2.getValue(0, 7));
        assertEquals(7, testSudoku2.getValue(0, 8));

        assertEquals(0, testSudoku2.getValue(1, 0));
        assertEquals(0, testSudoku2.getValue(1, 1));
        assertEquals(4, testSudoku2.getValue(1, 2));
        assertEquals(0, testSudoku2.getValue(1, 3));
        assertEquals(0, testSudoku2.getValue(1, 4));
        assertEquals(0, testSudoku2.getValue(1, 5));
        assertEquals(3, testSudoku2.getValue(1, 6));
        assertEquals(0, testSudoku2.getValue(1, 7));
        assertEquals(0, testSudoku2.getValue(1, 8));

        assertEquals(0, testSudoku2.getValue(2, 0));
        assertEquals(3, testSudoku2.getValue(2, 1));
        assertEquals(0, testSudoku2.getValue(2, 2) );
        assertEquals(0, testSudoku2.getValue(2, 3));
        assertEquals(4, testSudoku2.getValue(2, 4));
        assertEquals(0, testSudoku2.getValue(2, 5));
        assertEquals(0, testSudoku2.getValue(2, 6));
        assertEquals(6, testSudoku2.getValue(2, 7));
        assertEquals(0, testSudoku2.getValue(2, 8));

        assertEquals(3, testSudoku2.getValue(3, 0));
        assertEquals(0, testSudoku2.getValue(3, 1));
        assertEquals(0, testSudoku2.getValue(3, 2));
        assertEquals(0, testSudoku2.getValue(3, 3));
        assertEquals(2, testSudoku2.getValue(3, 4));
        assertEquals(0, testSudoku2.getValue(3, 5));
        assertEquals(0, testSudoku2.getValue(3, 6));
        assertEquals(0, testSudoku2.getValue(3, 7));
        assertEquals(4, testSudoku2.getValue(3, 8));

        assertEquals(0, testSudoku2.getValue(4, 0));
        assertEquals(4, testSudoku2.getValue(4, 1));
        assertEquals(1, testSudoku2.getValue(4, 2));
        assertEquals(6, testSudoku2.getValue(4, 3));
        assertEquals(0, testSudoku2.getValue(4, 4));
        assertEquals(8, testSudoku2.getValue(4, 5));
        assertEquals(2, testSudoku2.getValue(4, 6));
        assertEquals(0, testSudoku2.getValue(4, 7));
        assertEquals(0, testSudoku2.getValue(4, 8));

        assertEquals(9, testSudoku2.getValue(5, 0));
        assertEquals(2, testSudoku2.getValue(5, 1));
        assertEquals(0, testSudoku2.getValue(5, 2));
        assertEquals(4, testSudoku2.getValue(5, 3));
        assertEquals(5, testSudoku2.getValue(5, 4));
        assertEquals(0, testSudoku2.getValue(5, 5));
        assertEquals(0, testSudoku2.getValue(5, 6));
        assertEquals(0, testSudoku2.getValue(5, 7));
        assertEquals(8, testSudoku2.getValue(5, 8));

        assertEquals(2, testSudoku2.getValue(6, 0));
        assertEquals(5, testSudoku2.getValue(6, 1));
        assertEquals(0, testSudoku2.getValue(6, 2));
        assertEquals(0, testSudoku2.getValue(6, 3));
        assertEquals(8, testSudoku2.getValue(6, 4));
        assertEquals(0, testSudoku2.getValue(6, 5));
        assertEquals(0, testSudoku2.getValue(6, 6));
        assertEquals(4, testSudoku2.getValue(6, 7));
        assertEquals(0, testSudoku2.getValue(6, 8));

        assertEquals(4, testSudoku2.getValue(7, 0));
        assertEquals(0, testSudoku2.getValue(7, 1));
        assertEquals(9, testSudoku2.getValue(7, 2));
        assertEquals(5, testSudoku2.getValue(7, 3));
        assertEquals(0, testSudoku2.getValue(7, 4));
        assertEquals(2, testSudoku2.getValue(7, 5));
        assertEquals(8, testSudoku2.getValue(7, 6));
        assertEquals(0, testSudoku2.getValue(7, 7));
        assertEquals(0, testSudoku2.getValue(7, 8));

        assertEquals(1, testSudoku2.getValue(8, 0));
        assertEquals(0, testSudoku2.getValue(8, 1));
        assertEquals(0, testSudoku2.getValue(8, 2));
        assertEquals(9, testSudoku2.getValue(8, 3));
        assertEquals(0, testSudoku2.getValue(8, 4));
        assertEquals(4, testSudoku2.getValue(8, 5));
        assertEquals(5, testSudoku2.getValue(8, 6));
        assertEquals(2, testSudoku2.getValue(8, 7));
        assertEquals(6, testSudoku2.getValue(8, 8));
    }


    // Test G1: getValue returns index out of bounds exception
    // Parameters: line = -1 col = -1
    //
    @Test
    void GetValueLineOutOfRangeColOutOfRange() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(-1, -1);
                });

    }


    // Test G2: getValue returns index out of bounds exception
    // Parameters: line = -1 col = 0
    @Test
    void GetValueLineOutOfRangeCol0() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(-1, 0);
                });
    }

    // Test G3: getValue returns index out of bounds exception
    // Parameters: line = -1 col = 8
    @Test
    void GetValueLineOutOfRangeCol8() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(-1, 8);
                });
    }

    // Test G4: getValue returns 5
    // Parameters: line = -1 col = 9
    @Test
    void GetValueLineOutOfRangeCol9() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(-1, 9);

        // Assert

        assertEquals(5, result);

    }

    // Test G5: getValue returns index out of bounds exception
    // Parameters: line = 0 col = -1
    @Test
    void GetValueLine0ColOutOfRange() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(0, -1);
                });
    }

    // Test G6: getValue returns 5
    // Parameters: line = 0 col = 0
    @Test
    void GetValueLine0Col0() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(0, 0);

        // Assert

        assertEquals(5, result);
    }

    // Test G7: getValue returns 0 for an empty cell
    // Parameters: line = 0 col = 8
    @Test
    void GetValueLine0Col8() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(0, 8);

        // Assert

        assertEquals(0, result);
    }

    // Test G8: getValue returns 6
    // Parameters: line = 0 col = 9
    @Test
    void GetValueLine0Col9() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(0, 9);

        // Assert

        assertEquals(6, result);

    }

    // Test G9: getValue returns 0
    // Parameters: line = 8 col = -1
    @Test
    void GetValueLine8ColOutOfRange() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(8, -1);

        // Assert

        assertEquals(0, result);
    }

    // Test G10: getValue returns 0 for an empty cell
    // Parameters: line = 8 col = 0
    @Test
    void GetValueLine8Col0() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(8, 0);

        // Assert

        assertEquals(0, result);
    }

    // Test G11: getValue returns 9
    // Parameters: line = 8 col = 8
    @Test
    void GetValueLine8Col8() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(8, 8);

        // Assert

        assertEquals(9, result);
    }

    // Test G12: getValue returns index out of bounds exception
    // Parameters: line = 8 col = 9
    @Test
    void GetValueLine8Col9() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(8, 9);
                });
    }

    // Test G13: getValue returns 9
    // Parameters: line = 9 col = -1
    @Test
    void GetValueLine9ColOutOfRange() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        int result = testSudoku2.getValue(9, -1);

        // Assert

        assertEquals(9, result);
    }

    // Test G14: getValue returns index out of bounds exception
    // Parameters: line = 9 col = 0
    @Test
    void GetValueLine9Col0() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(9, 0);
                });
    }

    // Test G15: getValue returns index out of bounds exception
    // Parameters: line = 9 col = 8
    @Test
    void GetValueLine9Col8() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(9, 8);
                });
    }

    // Test G16: getValue returns index out of bounds exception
    // Parameters: line = 9 col = 9
    @Test
    void GetValueLine9Col9() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                +-------+-------+-------+
                | 5 . 0 | . 7 . | . . . |
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

        testSudoku2.setSudoku(init, false);


        // Act

        // Assert

        // Expect this to fail because it out of range
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.getValue(9, 9);
                });
    }

    // Test C1: isCandidate throws Index Out Of Bounds
    // Parameters: index = -1 cand = -1
    @Test
    void ISCandidateOutOfRangeForIndexAndCandidate() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(-1, -1);
                });

    }

    // Test C2: isCandidate throws Index Out Of Bounds
    // Parameters: index = -1 cand = 0
    @Test
    void ISCandidateOutOfRangeForIndexAndCandidate2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(-1, 0);
                });

    }

    // Test C3: isCandidate throws Index Out Of Bounds
    // Parameters: index = -1 cand = 1
    @Test
    void ISCandidateOutOfRangeForIndex() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(-1, 1);
                });

    }

    // Test C4: isCandidate throws Index Out Of Bounds
    // Parameters: index = -1 cand = 9
    @Test
    void ISCandidateOutOfRangeForIndex2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(-1, 9);
                });

    }

    // Test C5: isCandidate throws Index Out Of Bounds
    // Parameters: index = -1 cand = 10
    @Test
    void ISCandidateOutOfRangeForIndexAndCandidate3() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(-1, 10);
                });

    }

    // Test C6: isCandidate throws Index Out Of Bounds
    // Parameters: index = 0 cand = -1
    @Test
    void ISCandidateOutOfRangeForCandidate() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(0, -1);
                });

    }

    // Test C7: isCandidate returns false
    // Parameters: index = 0 cand = 0
    @Test
    void ISCandidateOutOfRangeForCandidate2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        boolean result = testSudoku2.isCandidate(0, 0);

        // Assert

        assertFalse(result);

    }

    // Test C8: isCandidate
    // Parameters: index = 0 cand = 1
    @Test
    void ISCandidate() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 12     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act
        boolean result = testSudoku2.isCandidate(0, 1);
        // Assert

        assertTrue(result);

    }

    // Test C9: isCandidate
    // Parameters: index = 0 cand = 9
    @Test
    void ISCandidate2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 26     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act
        boolean result = testSudoku2.isCandidate(0, 9);
        // Assert

        assertFalse(result);

    }

    // Test C10: isCandidate is out of bounds
    // Parameters: index = 0 cand = 10
    @Test
    void ISCandidateOutOfBoundsForCandidate() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(0, 10);
                });

    }



    // Test C11: isCandidate throws Index Out Of Bounds
    // Parameters: index = 80 cand = -1
    @Test
    void ISCandidateOutOfRangeForCandidate5() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(80, -1);
                });

    }

    // Test C12: isCandidate returns false
    // Parameters: index = 80 cand = 0
    @Test
    void ISCandidateOutOfRangeForCandidate3() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     7     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        boolean result = testSudoku2.isCandidate(80, 0);

        // Assert
        assertFalse(result);

    }

    // Test C13: isCandidate returns false
    // Parameters: index = 80 cand = 1
    @Test
    void ISCandidate3() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     36     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act
        boolean result = testSudoku2.isCandidate(80, 1);
        // Assert

        assertFalse(result);

    }

    // Test C14: isCandidate
    // Parameters: index = 80 cand = 9
    @Test
    void ISCandidate4() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     49     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act
        boolean result = testSudoku2.isCandidate(80, 9);
        // Assert

        assertTrue(result);

    }

    // Test C15: isCandidate is out of bounds
    // Parameters: index = 80 cand = 10
    @Test
    void ISCandidateOutOfBoundsForCandidate2() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(80, 10);
                });

    }

    // Test C16: isCandidate throws Index Out Of Bounds
    // Parameters: index = 81 cand = -1
    @Test
    void ISCandidateOutOfRangeForIndexAndCandidate8() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(81, -1);
                });

    }

    // Test C17: isCandidate throws Index Out Of Bounds
    // Parameters: index = 81 cand = 0
    @Test
    void ISCandidateOutOfRangeForIndexAndCandidate4() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(81, 0);
                });

    }

    // Test C18: isCandidate throws Index Out Of Bounds
    // Parameters: index = 81 cand = 1
    @Test
    void ISCandidateOutOfRangeForIndex4() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(81, 1);
                });

    }

    // Test C19: isCandidate throws Index Out Of Bounds
    // Parameters: index = 81 cand = 9
    @Test
    void ISCandidateOutOfRangeForIndex5() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();


        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(81, 9);
                });

    }

    // Test C20: isCandidate throws Index Out Of Bounds
    // Parameters: index = 81 cand = 10
    @Test
    void ISCandidateOutOfRangeForIndexAndCandidate10() {

        // Arrange

        // Need to make an instance of Sudoku2?
        sudoku.Sudoku2 testSudoku2 = new sudoku.Sudoku2();

        String init =
                """
                *-----------------------------------------------------------*
                | 6     19    2     | 3     19    5     | 4     8     7     |
                | 578   19    4     | 28    67    1679  | 3     159   1259  |
                | 578   3     57    | 28    4     179   | 19    6     1259  |
                |-------------------+-------------------+-------------------|
                | 3    *678   568   |*17    2     179   | 1679  159   4     |
                | 57    4     1     | 6     379   8     | 2     3579  359   |
                | 9     2     67    | 4     5     137   | 167   137   8     |
                |-------------------+-------------------+-------------------|
                | 2     5   #367    |*17    8     1367  | 179   4     139   |
                | 4    *67   9      | 5     1367  2     | 8     137   13    |
                | 1    *78   378    | 9     37    4     | 5     2     6     |
                *-----------------------------------------------------------*        
                """;

        testSudoku2.setSudoku(init, false);

        // Act

        // Assert

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {
                    testSudoku2.isCandidate(81, 10);
                });

    }
}
