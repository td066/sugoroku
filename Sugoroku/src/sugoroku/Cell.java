package sugoroku;

public abstract class Cell extends SugorokuObj {
	private int eventId;
	private boolean isOccupied;
	private Coma occupiedBy;
	private int[] nextCell;

	/**
	 * @param name
	 * @param printName
	 * @param info
	 * @param mapNo
	 * @param areaNo
	 * @param blockNo
	 * @param isEnabled
	 * @param eventId
	 * @param coma
	 * @param nextCell
	 */

	public Cell(String name, String printName, String info, int mapNo, int areaNo, int blockNo, int eventId) {
		super(name, printName, info, mapNo, areaNo, blockNo, true);
		this.eventId = eventId;
		this.isOccupied = false;
		this.occupiedBy = null;
		this.nextCell = new int[] {0,0,0};
	}
	public int getEventId() {
		return eventId;
	}
	public boolean getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(boolean flg) {
		this.isOccupied = flg;
	}
	public Coma getOccupiedBy() {
		return occupiedBy;
	}
	public void setOccupiedBy(Coma coma) {
		this.occupiedBy = coma;
	}
}
