package com.garnaik;

import java.util.ArrayList;
import java.util.List;

/**
 * Thisn is the main class used for test the TicTacToe game
 *
 */
public class TicTacToeMain {
	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe(3, 3);
		tic.constructBoard();

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

		System.out.println("Game finished with :: " + message);

	}
}
