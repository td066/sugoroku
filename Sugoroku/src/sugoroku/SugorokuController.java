package sugoroku;

public class SugorokuController {
	private GameInfo gameInfo;
	private Coma[] comaArray;
	private Dice dice;
	private Cell[] area;

	/**
	 * @param test
	 */
	public SugorokuController() {
		dice = new Dice();
	}

	public void initGameInfo(int gameMode, int comaPlayerNum, int comaCpuNum) {
		this.gameInfo = new GameInfo(gameMode, comaPlayerNum, comaCpuNum);
	}

	public int getGameSpeed() {
		return this.gameInfo.getGameSpeed();
	}

	public void setGameSpeed(int gameSpeed) {
		this.gameInfo.setGameSpeed(gameSpeed);
	}

	public int getComaPlayerNum() {
		return this.gameInfo.getComaPlayerNum();
	}

	public int getComaCpuNum() {
		return this.gameInfo.getComaCpuNum();
	}

	public int getActiveComaNum() {
		return this.gameInfo.getActiveComaNum();
	}

	public int getTurnCount() {
		return this.gameInfo.getTurnCount();
	}

	public void incrementTurnCount() {
		this.gameInfo.incrementTurnCount();
	}

	public void initComaArray(Coma[] comaArray) {
		this.comaArray = comaArray;
	}

	public int getDiceNum() {
		return this.dice.doRollDice();
	}

	public void initMap(Cell[] area) {
		this.area = area;
	}

	public Cell[] getMap() {
		return this.area;
	}

	public Cell getBlock(int index) {
		return this.area[index];
	}

	public void initStatusInfo() {
		// TODO 拡張機能用
	}

	public Coma[] getComaArray() {
		return this.comaArray;
	}

	public void moveComa(Coma coma, int diceNum) {
		// コマの現在地から、移動先ロケーション情報取得
		int nextBlock = coma.getBlockNo() + diceNum;
		// 移動先がエリア範囲外（スタートより前）の場合の補正
		if (nextBlock < 0) {
			nextBlock = 0;
		}
		// 移動先がエリア範囲外（ゴールより後ろ）の場合の補正
		if (nextBlock >= area.length - 1) {
			nextBlock = area.length - 1;
			// コマのゴール設定
			coma.setIsGoaled_True();
			// gamenInfo更新(実行中のコマ数)
			this.gameInfo.decrementActiveComaNum();
		}
		// コマのロケーション情報更新
		coma.setBlockNo(nextBlock);
	}
}
