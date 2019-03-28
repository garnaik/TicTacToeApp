package com.garnaik;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Garnaik This is class that implemented the test case for TiccTacToe
 *         game
 *
 */
public class TicTacToeTest {
	private TicTacToe tic;

	public TicTacToeTest() {
		tic = new TicTacToe(0, 0);
	}

	/**
	 * Positive test case
	 */
	@Test
	public void validRowColumnSize() {
		tic = new TicTacToe(3, 3);
		Assert.assertEquals(this.tic.getRow(), this.tic.getColumn());
	}

	/**
	 * Nagative test case
	 */
	@Test
	public void invalidRowColumnSizeTest() {
		tic = new TicTacToe(1, 3);
		Assert.assertEquals(this.tic.getRow(), this.tic.getColumn());
	}

	/**
	 * Positive Test case
	 */
	@Test
	public void validBoardTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();
		Assert.assertNotNull(this.tic.getBoard());
	}

	/**
	 * Nagative Test Case
	 */
	@Test
	public void gameBoardNotEmptyTest() {
		tic = new TicTacToe(0, 0);
		this.tic.constructBoard();
		Assert.assertFalse(this.tic.getBoard().length == 0);
	}

	/**
	 * Positive Test Case
	 */
	@Test
	public void validBoardDiagonalTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();
		Assert.assertEquals(this.tic.getRow(), this.tic.getBoard().length);
	}

	/**
	 * Nagative Test case
	 */
	@Test
	public void inValidBoardDiagonalTest() {
		tic = new TicTacToe(1, 3);
		this.tic.constructBoard();
		Assert.assertEquals(this.tic.getRow(), this.tic.getBoard().length);
	}

	/**
	 * Positive Test case
	 */
	@Test
	public void isPrintBoardOkTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();
		Assert.assertTrue(this.tic.printBoard());
	}

	@Test
	public void isPrintBoardNotOkTest() {
		tic = new TicTacToe(0, 0);
		this.tic.constructBoard();
		Assert.assertTrue(this.tic.printBoard());
	}

	/**
	 * Positive Test Case
	 */
	public void successfullGameTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();

		List<EnterValue> list = new ArrayList<EnterValue>();
		EnterValue en1 = new EnterValue();
		en1.setRow(1);
		en1.setColumn(1);
		en1.setBoxValue("X");
		list.add(en1);

		EnterValue en2 = new EnterValue();
		en2.setRow(1);
		en2.setColumn(2);
		en2.setBoxValue("O");
		list.add(en2);

		EnterValue en3 = new EnterValue();
		en3.setRow(1);
		en3.setColumn(3);
		en3.setBoxValue("X");
		list.add(en3);

		EnterValue en4 = new EnterValue();
		en4.setRow(2);
		en4.setColumn(1);
		en4.setBoxValue("O");
		list.add(en4);

		EnterValue en5 = new EnterValue();
		en5.setRow(2);
		en5.setColumn(2);
		en5.setBoxValue("X");
		list.add(en5);

		EnterValue en6 = new EnterValue();
		en6.setRow(2);
		en6.setColumn(3);
		en6.setBoxValue("O");
		list.add(en6);

		EnterValue en7 = new EnterValue();
		en7.setRow(3);
		en7.setColumn(1);
		en7.setBoxValue("X");
		list.add(en7);

		EnterValue en8 = new EnterValue();
		en8.setRow(3);
		en8.setColumn(2);
		en8.setBoxValue("O");
		list.add(en8);

		EnterValue en9 = new EnterValue();
		en9.setRow(3);
		en9.setColumn(3);
		en9.setBoxValue("X");
		list.add(en9);

		String message = "";
		for (EnterValue valueObj : list) {
			message = tic.play(valueObj);
			if (message.equals("SUCCESSFULL")) {
				break;
			}
		}
		Assert.assertEquals("SUCCESSFULL", message);
	}

	/*
	 * Nagative Test Case
	 */
	@Test
	public void inValidBoxValueTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();

		List<EnterValue> list = new ArrayList<EnterValue>();
		EnterValue en1 = new EnterValue();
		en1.setRow(1);
		en1.setColumn(1);
		en1.setBoxValue("TT"); // Invalid Box value
		list.add(en1);

		EnterValue en2 = new EnterValue();
		en2.setRow(1);
		en2.setColumn(2);
		en2.setBoxValue("O");
		list.add(en2);

		EnterValue en3 = new EnterValue();
		en3.setRow(1);
		en3.setColumn(3);
		en3.setBoxValue("X");
		list.add(en3);

		EnterValue en4 = new EnterValue();
		en4.setRow(2);
		en4.setColumn(1);
		en4.setBoxValue("O");
		list.add(en4);

		EnterValue en5 = new EnterValue();
		en5.setRow(2);
		en5.setColumn(2);
		en5.setBoxValue("X");
		list.add(en5);

		EnterValue en6 = new EnterValue();
		en6.setRow(2);
		en6.setColumn(3);
		en6.setBoxValue("O");
		list.add(en6);

		EnterValue en7 = new EnterValue();
		en7.setRow(3);
		en7.setColumn(1);
		en7.setBoxValue("X");
		list.add(en7);

		EnterValue en8 = new EnterValue();
		en8.setRow(3);
		en8.setColumn(2);
		en8.setBoxValue("O");
		list.add(en8);

		EnterValue en9 = new EnterValue();
		en9.setRow(3);
		en9.setColumn(3);
		en9.setBoxValue("X");
		list.add(en9);

		String message = "";
		for (EnterValue valueObj : list) {
			message = tic.play(valueObj);
			if (message.equals("INVALID_BOX_VALUE")) {
				break;
			}
		}
		Assert.assertEquals("SUCCESSFULL", message);
	}

	/**
	 * Nagative Test Case
	 */
	@Test
	public void inValidRowColumnValueTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();

		List<EnterValue> list = new ArrayList<EnterValue>();
		EnterValue en1 = new EnterValue();
		en1.setRow(4); // Entered invalid row value mean out of index or Matrix
		en1.setColumn(1);
		en1.setBoxValue("X");
		list.add(en1);

		EnterValue en2 = new EnterValue();
		en2.setRow(1);
		en2.setColumn(2);
		en2.setBoxValue("O");
		list.add(en2);

		EnterValue en3 = new EnterValue();
		en3.setRow(1);
		en3.setColumn(3);
		en3.setBoxValue("X");
		list.add(en3);

		EnterValue en4 = new EnterValue();
		en4.setRow(2);
		en4.setColumn(1);
		en4.setBoxValue("O");
		list.add(en4);

		EnterValue en5 = new EnterValue();
		en5.setRow(2);
		en5.setColumn(2);
		en5.setBoxValue("X");
		list.add(en5);

		EnterValue en6 = new EnterValue();
		en6.setRow(2);
		en6.setColumn(3);
		en6.setBoxValue("O");
		list.add(en6);

		EnterValue en7 = new EnterValue();
		en7.setRow(3);
		en7.setColumn(1);
		en7.setBoxValue("X");
		list.add(en7);

		EnterValue en8 = new EnterValue();
		en8.setRow(3);
		en8.setColumn(2);
		en8.setBoxValue("O");
		list.add(en8);

		EnterValue en9 = new EnterValue();
		en9.setRow(3);
		en9.setColumn(3);
		en9.setBoxValue("X");
		list.add(en9);

		String message = "";
		for (EnterValue valueObj : list) {
			message = tic.play(valueObj);
			if (message.equals("INVALID_ROW_COLUMN_VALUE")) {
				break;
			}
		}
		Assert.assertEquals("SUCCESSFULL", message);
	}

	/**
	 * Nagative Test Case
	 */
	@Test
	public void nullBoxValueTest() {
		tic = new TicTacToe(3, 3);
		this.tic.constructBoard();

		List<EnterValue> list = new ArrayList<EnterValue>();
		EnterValue en1 = new EnterValue();
		en1.setRow(1);
		en1.setColumn(1);
		en1.setBoxValue(null); // Null value in Box
		list.add(en1);

		EnterValue en2 = new EnterValue();
		en2.setRow(1);
		en2.setColumn(2);
		en2.setBoxValue("O");
		list.add(en2);

		EnterValue en3 = new EnterValue();
		en3.setRow(1);
		en3.setColumn(3);
		en3.setBoxValue("X");
		list.add(en3);

		EnterValue en4 = new EnterValue();
		en4.setRow(2);
		en4.setColumn(1);
		en4.setBoxValue("O");
		list.add(en4);

		EnterValue en5 = new EnterValue();
		en5.setRow(2);
		en5.setColumn(2);
		en5.setBoxValue("X");
		list.add(en5);

		EnterValue en6 = new EnterValue();
		en6.setRow(2);
		en6.setColumn(3);
		en6.setBoxValue("O");
		list.add(en6);

		EnterValue en7 = new EnterValue();
		en7.setRow(3);
		en7.setColumn(1);
		en7.setBoxValue("X");
		list.add(en7);

		EnterValue en8 = new EnterValue();
		en8.setRow(3);
		en8.setColumn(2);
		en8.setBoxValue("O");
		list.add(en8);

		EnterValue en9 = new EnterValue();
		en9.setRow(3);
		en9.setColumn(3);
		en9.setBoxValue("X");
		list.add(en9);

		String message = "";
		for (EnterValue valueObj : list) {
			message = tic.play(valueObj);
			if (message.equals("EMPTY_BOX_VALUE")) {
				break;
			}
		}
		Assert.assertEquals("SUCCESSFULL", message);
	}
}
