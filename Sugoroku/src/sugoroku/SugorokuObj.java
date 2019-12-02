package sugoroku;

public abstract class SugorokuObj {
	private String name;
	private String printName;
	private String info;
	private int mapNo;
	private int areaNo;
	private int blockNo;
	private boolean isEnabled;
	/**
	 * @param name オブジェクトの名前
	 * @param printName 出力時の名称
	 * @param info オブジェクト情報
	 * @param mapNo マップ番号
	 * @param areaNo エリア番号
	 * @param blockNo ブロック番号
	 * @param isEnabled 有効・無効
	 */
	public SugorokuObj(String name, String printName, String info, int mapNo, int areaNo, int blockNo, boolean isEnabled) {
		this.name = name;
		this.printName = printName;
		this.info = info;
		this.mapNo = mapNo;
		this.areaNo = areaNo;
		this.blockNo = blockNo;
		this.isEnabled = isEnabled;
	}
	public String getName() {
		return name;
	}
	//	public void setName(String name) {
	//		this.name = name;
	//	}
	public String getPrintName() {
		return printName;
	}
	public void setPrintName(String printName) {
		this.printName = printName;
	}
	public String getInfo() {
		return info;
	}
	//	public void setInfo(String info) {
	//		this.info = info;
	//	}
	//	public int getMapNo() {
	//		return mapNo;
	//	}
	//	public void setMapNo(int mapNo) {
	//		this.mapNo = mapNo;
	//	}
	//	public int getAreaNo() {
	//		return areaNo;
	//	}
	//	public void setAreaNo(int areaNo) {
	//		this.areaNo = areaNo;
	//	}
	public int getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(int blockNo) {
		this.blockNo = blockNo;
	}
	//	public boolean isEnabled() {
	//		return isEnabled;
	//	}
	//	public void setEnabled(boolean isEnabled) {
	//		this.isEnabled = isEnabled;
	//	}
}
