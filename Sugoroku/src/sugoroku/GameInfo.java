package sugoroku;

public class GameInfo {
	private int gameMode;
	private int comaPlayerNum;
	private int comaCpuNum;
	private int activeComaNum;
	private int gameSpeed;
	private int turnCount;

	/**
	 * @param gameMode
	 * @param comaPlayerNum
	 * @param comaCpuNum
	 */
	public GameInfo(int gameMode, int comaPlayerNum, int comaCpuNum) {
		this.gameMode = gameMode;
		this.comaPlayerNum = comaPlayerNum;
		this.comaCpuNum = comaCpuNum;
		this.activeComaNum = comaPlayerNum + comaCpuNum;
		this.gameSpeed = SugorokuConstants.INI_GAMESPEED;
		this.turnCount = 0;
	}

	public int getComaPlayerNum() {
		return this.comaPlayerNum;
	}

	public int getComaCpuNum() {
		return this.comaCpuNum;
	}

	public int getActiveComaNum() {
		return this.activeComaNum;
	}

	public void decrementActiveComaNum() {
		this.activeComaNum--;
	}

	public int getGameSpeed() {
		return this.gameSpeed;
	}

	public void setGameSpeed(int gameSpeed) {
		this.gameSpeed = gameSpeed;
	}

	public int getTurnCount() {
		return this.turnCount;
	}

	public void incrementTurnCount() {
		this.turnCount++;
	}
}
