package sugoroku;

/**
 * 双六ゲーム Version 1.0
 * 
 * @author Satoshi Tsuda
 * @since November 28 2019
 */
public class SugorokuMain {
	private SugorokuTools tools = new SugorokuTools();

	/**
	 * メイン（エントリーポイント）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new SugorokuMain().run();
	}

	/**
	 * 双六ゲームの実行本体
	 */
	private void run() {
		// 双六ゲームの初期設定
		this.initSugoroku();
		// 双六ゲームの実行
		this.execSugoroku();
		// 双六ゲームの終了
		this.closeSugoroku();
	}

	private void initSugoroku() {
		// 開始メッセージ表示
		tools.showStartMessage();
		// ゲームモード別初期化処理
		switch (this.getGameMode()) {
		case SugorokuConstants.GAMEMODE_NEW: // 新規でゲーム開始の場合
			this.initNewGame();
			break;
		case SugorokuConstants.GAMEMODE_LOAD: // ロードしてゲーム開始の場合
			this.initLoadGame();
			break;
		}
		;
	}

	private int getGameMode() {
		// ゲームモード選択
		return tools.getGameMode();
	}

	private void initNewGame() {
		// gameInfo生成
		tools.initGameInfo();
		// コマ群生成
		tools.initComaArray();
		// ダイス生成
		tools.initDice();
		// マップ生成
		tools.initMap();
		// 位置情報生成
		tools.initLocationInformation();
		// ステータス情報生成
		tools.initStatusInfo();
	}

	private void initLoadGame() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Load機能は未実装");
	}

	private void execSugoroku() {
		// 双六ゲームの実行
		do {
			tools.doSugoroku();
		} while (tools.isDoingSugoroku());
	}

	private void closeSugoroku() {
		// 終了メッセージ表示
		tools.showEndMessage();
	}
}
