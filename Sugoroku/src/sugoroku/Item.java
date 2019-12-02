package sugoroku;

public class Item {
	/**
	 * 商品名
	 */
	private String name;

	public Item( String name ) {
		this.name = name;
	}
	/**
	 * 商品名を取得します
	 * @return 商品名
	 */
	public String getName() {
		return this.name;
	}
}
