package sugoroku;

import java.util.Random;

public class Dice extends SugorokuObj {
	public Dice() {
		super("ダイス", "ダイス", "双六で使用するダイス", 999, 999, 999, true);
	}

	public int doRollDice() {
		// ダイスを振る
		return new Random().nextInt(6) + 1;
	}
}
