package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;

public class BishopBlackTest {

    @Test
    public void whenPositionC1() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell c1 = bishopBlack.position();
        Assert.assertThat(c1, is(Cell.C1));
    }

    @Test
    public void whenWayC1ThenD2E3F4G5() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] cells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(rsl, is(cells));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.A2);
    }

    @Test
    public void whenDiagonalThenTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean rsl = bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        Assert.assertThat(rsl, is(true));
    }

    @Test
    public void whenNotDiagonalThenFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean rsl = bishopBlack.isDiagonal(Cell.C1, Cell.C5);
        Assert.assertThat(rsl, is(false));
    }

    @Test
    public void whenCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure figure = bishopBlack.copy(Cell.G5);
        Assert.assertThat(figure.position(), is(Cell.G5));
    }
}