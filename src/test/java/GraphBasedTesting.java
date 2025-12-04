import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

import sudoku.Sudoku2;

public class GraphBasedTesting {
    private Sudoku2 sdk;

    @BeforeEach
    void setup() {
        sdk = new Sudoku2(); // calls clearSudoku: all candidates allowed by default
    }

    // ----------------------------
    // Reflection helpers
    // ----------------------------

    private short[] getCells() {
        try {
            Field f = Sudoku2.class.getDeclaredField("cells");
            f.setAccessible(true);
            return (short[]) f.get(sdk);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[][] getFree() {
        try {
            Field f = Sudoku2.class.getDeclaredField("free");
            f.setAccessible(true);
            return (byte[][]) f.get(sdk);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] getConstraints() {
        try {
            Field f = Sudoku2.class.getDeclaredField("CONSTRAINTS");
            f.setAccessible(true);
            return (int[][]) f.get(null); // static field
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellMask(int index, int... candidates) {
        short mask = 0;
        for (int c : candidates) {
            mask |= Sudoku2.MASKS[c];
        }
        getCells()[index] = mask;
    }

    private void setFreePreValuesForIndex(int index, int value, int pre0, int pre1, int pre2) {
        // index belongs to 3 houses; force each to a different pre-free value
        int[] houses = getConstraints()[index];
        byte[][] free = getFree();

        // Safety: Sudoku2 CONSTRAINTS[index] length is 3 for a cell (row, col, box).
        // We set the first three.
        free[houses[0]][value] = (byte) pre0;
        free[houses[1]][value] = (byte) pre1;
        free[houses[2]][value] = (byte) pre2;
    }

    // ----------------------------
    // ADD BRANCH TESTS (set == true)
    // ----------------------------

    @Test
    void A1_addAbsent_becomesOnlyCandidate_hitsNewAnz1_andFreeBranches() {
        int index = 0;
        int value = 5;

        // Cell starts empty -> adding makes newAnz == 1
        setCellMask(index); // {}

        // Force free++ outcomes in 3 houses:
        // pre 0 -> newFree 1  (hits newFree==1)
        // pre 1 -> newFree 2  (hits newFree==2)
        // pre 2 -> newFree 3+ (hits neither edge)
        setFreePreValuesForIndex(index, value, 0, 1, 2);

        boolean r = sdk.setCandidate(index, value, true);

        assertTrue(r);
        assertTrue(sdk.isCandidate(index, value));
        // Only candidate left should be {5}
        for (int c = 1; c <= 9; c++) {
            if (c == value) continue;
            assertFalse(sdk.isCandidate(index, c));
        }
    }

    @Test
    void A2_addAbsent_becomesSecondCandidate_hitsNewAnz2() {
        int index = 0;
        int value = 5;

        // Cell has exactly one candidate already {3}
        setCellMask(index, 3);

        boolean r = sdk.setCandidate(index, value, true);

        assertTrue(r);
        assertTrue(sdk.isCandidate(index, 3));
        assertTrue(sdk.isCandidate(index, value)); // now {3,5}
    }

    @Test
    void A3_addAbsent_becomesThirdCandidate_hitsNeitherNewAnz1Nor2() {
        int index = 0;
        int value = 5;

        // Cell has two candidates already {1,3}
        setCellMask(index, 1, 3);

        boolean r = sdk.setCandidate(index, value, true);

        assertTrue(r);
        assertTrue(sdk.isCandidate(index, 1));
        assertTrue(sdk.isCandidate(index, 3));
        assertTrue(sdk.isCandidate(index, value)); // now {1,3,5}
    }

    @Test
    void A4_addAlreadyPresent_noOpAdd_hitsAbsentFalseEdge() {
        int index = 0;
        int value = 5;

        // Candidate already present
        setCellMask(index, 5, 7);

        boolean r = sdk.setCandidate(index, value, true);

        assertTrue(r);
        assertTrue(sdk.isCandidate(index, 5));
        assertTrue(sdk.isCandidate(index, 7));
        // no-op: still only {5,7}
        for (int c = 1; c <= 9; c++) {
            if (c == 5 || c == 7) continue;
            assertFalse(sdk.isCandidate(index, c));
        }
    }

    // ----------------------------
    // REMOVE BRANCH TESTS (set == false)
    // ----------------------------

    @Test
    void R1_removeAbsent_noOpRemove_hitsPresentFalseEdge() {
        int index = 0;
        int value = 5;

        // Candidate absent
        setCellMask(index, 2, 7);

        boolean r = sdk.setCandidate(index, value, false);

        assertTrue(r);
        assertTrue(sdk.isCandidate(index, 2));
        assertTrue(sdk.isCandidate(index, 7));
        assertFalse(sdk.isCandidate(index, value));
    }

    @Test
    void R2_removeLastCandidate_returnsFalse_hitsInvalidEdge() {
        int index = 0;
        int value = 5;

        // Only one candidate {5}
        setCellMask(index, value);

        boolean r = sdk.setCandidate(index, value, false);

        assertFalse(r);
        // cell mask becomes empty
        for (int c = 1; c <= 9; c++) {
            assertFalse(sdk.isCandidate(index, c));
        }
    }

    @Test
    void R3_removeLeavesOneCandidate_hitsAnzValues1TrueEdge() {
        int index = 0;
        int value = 5;

        // Two candidates {5,9} -> removing 5 leaves {9}
        setCellMask(index, value, 9);

        boolean r = sdk.setCandidate(index, value, false);

        assertTrue(r);
        assertFalse(sdk.isCandidate(index, value));
        assertTrue(sdk.isCandidate(index, 9));
        for (int c = 1; c <= 9; c++) {
            if (c == 9) continue;
            assertFalse(sdk.isCandidate(index, c));
        }
    }

    @Test
    void R4_removeLeavesTwoCandidates_hitsFree1_andFree0Branches() {
        int index = 0;
        int value = 5;

        // Three candidates {1,5,9} -> removing 5 leaves {1,9}
        setCellMask(index, 1, value, 9);

        // Force free-- outcomes in 3 houses:
        // pre 2 -> newFree 1  (hits newFree==1)
        // pre 1 -> newFree 0  (hits newFree==0)
        // pre 3 -> newFree 2+ (hits neither edge)
        setFreePreValuesForIndex(index, value, 2, 1, 3);

        boolean r = sdk.setCandidate(index, value, false);

        assertTrue(r);
        assertTrue(sdk.isCandidate(index, 1));
        assertTrue(sdk.isCandidate(index, 9));
        assertFalse(sdk.isCandidate(index, value));
        // still two candidates
        int count = 0;
        for (int c = 1; c <= 9; c++) {
            if (sdk.isCandidate(index, c)) count++;
        }
        assertEquals(2, count);
    }
}
