package sugoroku;

public abstract class Coma extends SugorokuObj {
	/**
	 * 所持金
	 */
	private int money;
	/**
	 * 所持品
	 */
	private Item[] stock;
	/**
	 * 残り休み回数
	 */
	private int breakTime;
	/**
	 * 行動モード
	 */
	private int actionMode;

	/**
	 * ゴール判定
	 */
	private boolean isGoaled;

	/**
	 * @param name
	 * @param printName
	 * @param info
	 * @param mapNo
	 * @param areaNo
	 * @param blockNo
	 * @param isEnabled
	 * @param money
	 * @param stock
	 * @param breakTime
	 * @param actionMode
	 * @param isGoaled
	 */
	public Coma(String name, String printName, String info, int actionMode) {
		super(name, printName, info, 0, 0, 0, true);
		this.money = SugorokuConstants.INI_MONEY;
		this.stock = new Item[0];
		this.breakTime = SugorokuConstants.INI_BREAKTIME;
		this.actionMode = actionMode;
		this.isGoaled = false;
	}

	// public String name() {
	// 	return super.getName();
	// }

	// public String printName() {
	// 	return super.getPrintName();
	// }

	// public String info() {
	// 	return super.getInfo();
	// }
	// public int blockNo() {
	// 	return super.getBlockNo();
	// }

	public int getMoney() {
		return this.money;
	}
	public void addMoney(int addMoney) {
		this.money += addMoney;
	}
	public int getActionMode() {
		return this.actionMode;
	}
	public boolean getIsGoaled() {
		return this.isGoaled;
	}
	public void setIsGoaled_True() {
		this.isGoaled = true;
	}
	public int getBreakTime() {
		return this.breakTime;
	}
	public void setBreakTime(int breakTime) {
		this.breakTime = breakTime;
	}
}
