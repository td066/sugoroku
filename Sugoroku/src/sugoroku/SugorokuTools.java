package sugoroku;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SugorokuTools {
	private Scanner input = new Scanner(System.in);
	private SugorokuController controller = new SugorokuController();
	private ArrayList<String> printArray = new ArrayList<String>();

	/**
	 * 開始メッセージの表示
	 */
	public void showStartMessage() {
		this.showPrintLine("ようこそ！双六ゲームです。");
	}

	public int getGameMode() {
		// TODO 現在は新規ゲームで固定
		return SugorokuConstants.GAMEMODE_NEW;
	}

	public void initGameInfo() {
		// TODO ここから見直し対象
		System.out.println("最大６人で楽しめます。");
		// プレイヤー数の確認
		System.out.println("参加するプレイヤーの人数を入力して下さい。（1 - 3）");
		int pNum = getInputNum(1, 3);
		// CPU数の確認
		System.out.println("参加するコンピューターの人数を入力して下さい。（0 - 3）");
		int cNum = getInputNum(0, 3);
		System.out.println("プレイヤー" + pNum + "人、コンピューター" + cNum + "人でゲーム始めます。");
		System.out.println("-------------------------------");
		// TODO ここまで見直し対象

		// コントローラーに設定
		controller.initGameInfo(SugorokuConstants.GAMEMODE_NEW, pNum, cNum);
		this.showPrintTimelag("ゲーム初期化中", "双六開始！", 5);
	}

	public void initComaArray() {
		// キャラクタ群生成用配列作成
		Coma[] comaArray = new Coma[controller.getActiveComaNum()];
		// プレイヤー初期化
		for (int i = 0; i < controller.getComaPlayerNum(); i++) {
			int no = i + 1;
			comaArray[i] = new ComaPlayer("プレイヤー " + no, "P" + no, "");
		}
		// コンピューター初期化
		for (int i = 0; i < controller.getComaCpuNum(); i++) {
			int no = i + 1;
			comaArray[controller.getComaPlayerNum() + i] = new ComaCpu("コンピューター " + no, "C" + no, "");
		}
		// コントローラーに設定
		controller.initComaArray(comaArray);
	}

	public void initDice() {
		// ダイス生成
		// 【注意】ダイスはcontrollerのコンストラクタにて初期化済み
	}

	public void initMap() {
		// area作成
		// TODO area作成方法の見直し
		Cell[] area = new Cell[] { new Cell("スタート", "ST", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_0) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "[]", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_2) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "[]", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_2) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "[]", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_2) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "[]", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_2) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("何かな？", "[]", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_2) {
		}, new Cell("何かな？", "!?", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_1) {
		}, new Cell("ゴール!!", "GL", null, 0, 0, 0, SugorokuConstants.EVENT_GROUP_9) {
		}, };

		// TODO 複数area、mapに変更なら追記

		// コントローラーに設定
		controller.initMap(area);
	}

	public void initLocationInformation() {
		// TODO 複数area、mapに変更なら追記
	}

	public void initStatusInfo() {
		// コントローラーに設定
		controller.initStatusInfo();
	}

	public boolean isDoingSugoroku() {
		// 未ゴールのコマがあるか確認
		return controller.getActiveComaNum() > 0 ? true : false;
	}

	public void doSugoroku() {
		// ターン数の更新
		controller.incrementTurnCount();
		// ターン開始のメッセージ表示
		this.showPrintLine("*****************************************");
		this.showPrintLine();
		this.showPrintTimelag(controller.getTurnCount() + " ターン目 " + this.getGameSpeedStr(), "開始", 0);
		// 各コマのターン実行
		for (Coma coma : controller.getComaArray()) {
			// ゴール済みのコマはターンを飛ばす
			if (coma.getIsGoaled()) {
				continue;
			}
			// 今の状態を画面表示
			this.showGameDisp();
			this.showPrintLine(coma.getName() + " のターン");
			// 休み中のコマはターンを終える
			int breakCount = coma.getBreakTime();
			if (breakCount > 0) {
				breakCount--;
				coma.setBreakTime(breakCount);
				this.showPrintTimelag(coma.getName() + " はひとやすみ中", "あと " + coma.getBreakTime() + " 回休み", 0);
				continue;
			}
			// ターン行動実行
			switch (coma.getActionMode()) {
			case SugorokuConstants.ACTIONMODE_PLAYER:
				while (doPlayerTurn(coma)) {
					// this.doTimeSleep_1000(); // 実行結果確認のため、一時停止
				}
				break;
			case SugorokuConstants.ACTIONMODE_CPU:
				while (doCpuTurn(coma)) {
					// this.doTimeSleep_1000(); // 実行結果確認のため、一時停止
				}
				break;
			default:
				break;
			}
		}
	}

	private String getGameSpeedStr() {
		// ゲームスピードを表す文字列取得
		switch (controller.getGameSpeed()) {
		case 2:
			return SugorokuConstants.STR_GAMESPEED_2x;
		case 3:
			return SugorokuConstants.STR_GAMESPEED_3x;
		case 4:
			return SugorokuConstants.STR_GAMESPEED_4x;
		default:
			return SugorokuConstants.STR_SPACE;
		}
	}

	private void showGameDisp() {
		// 出力用arrayのクリア
		this.clearPrintArray();
		// ステータス情報の設定
		this.setStatusInfo();
		// ロケーション情報の設定
		this.setLocationInfo();
		// マップ情報の設定
		this.setMapInfo();
		// 出力用arrayの画面表示
		this.showPrintArray();
	}

	private void setStatusInfo() {
		for (Coma coma : this.getComaArraySortedByMoney()) {
			// 各コマのステータス表示
			this.addPrintArray("【 " + coma.getName() + " ： " + coma.getMoney() + "円 】" + this.getGoalMark(coma));
		}
		this.addPrintArray("-------------------------------");
	}

	private ArrayList<Coma> getComaArraySortedByMoney() {
		ArrayList<Coma> comaArray = new ArrayList<Coma>();
		for (Coma coma : controller.getComaArray()) {
			comaArray.add(coma);
		}
		// moneyでソート
		Collections.sort(comaArray, new ComaComparator());
		return comaArray;
	}

	private void setLocationInfo() {
		for (Coma coma : controller.getComaArray()) {
			// 各コマのロケーション情報表示
			this.addPrintArray(this.getPathMark(coma) + coma.getPrintName());
		}
	}

	private String getPathMark(Coma coma) {
		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		for (int i = 0; i < coma.getBlockNo(); i++) {
			sb.append(SugorokuConstants.STR_PATHMARK);
		}
		return sb.toString();
	}

	private String getGoalMark(Coma coma) {
		return coma.getIsGoaled() ? " (Goal)" : "";
	}

	private void setMapInfo() {
		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		for (Cell block : controller.getMap()) {
			sb.append(block.getPrintName() + SugorokuConstants.STR_SPACE);
		}
		// マップ情報表示
		this.addPrintArray(sb.toString());
	}

	private boolean doPlayerTurn(Coma coma) {
		// プレイヤーの行動選択
		boolean isNextLoop = false; // false：この行動でターンを終了する場合
		this.showPrintLine("アクションを選択して下さい。（1 - 6）");
		this.showPrintLine("  1: ダイスを振る");
		this.showPrintLine("  2: アイテム一覧");
		this.showPrintLine("  3: アイテムを使う");
		this.showPrintLine("  4: ゲームスピード変更");
		this.showPrintLine("  5: ロード");
		this.showPrintLine("  6: セーブ");
		switch (getInputNum(1, 6)) {
		case 1: // ダイスを振る
			this.doRollDice(coma);
			isNextLoop = false;
			break;
		case 2: // アイテム一覧
			// TODO 未実装
			this.showPrintTimelag("** アイテムがありません **", "", 0);
			this.showPrintLine("-------------------------------");
			isNextLoop = true;
			break;
		case 3: // アイテムを使う
			// TODO 未実装
			this.showPrintTimelag("** アイテムがありません **", "", 0);
			this.showPrintLine("-------------------------------");
			isNextLoop = true;
			break;
		case 4: // ゲームスピード変更
			this.changeGameSpeed();
			this.showPrintTimelag("ゲームスピードを変更しました", "", 0);
			this.showPrintLine("-------------------------------");
			isNextLoop = true;
			break;
		case 5: // ロード
			// TODO 未実装
			this.showPrintTimelag("** セーブファイルがありません **", "", 0);
			this.showPrintLine("-------------------------------");
			isNextLoop = true;
			break;
		case 6: // セーブ
			// TODO 未実装
			this.showPrintTimelag("** 今はセーブができません **", "", 0);
			this.showPrintLine("-------------------------------");
			isNextLoop = true;
			break;
		default:
			break;
		}
		return isNextLoop;
	}

	private boolean doCpuTurn(Coma coma) {
		// コンピューターの行動選択
		boolean isNextLoop = false; // false：この行動でターンを終了する場合
		this.doRollDice(coma);
		return isNextLoop;
	}

	private void doRollDice(Coma coma) {
		// ダイスの値を取得
		int diceNum = controller.getDiceNum();
		this.showPrintTimelag("ダイスを振る", diceNum + " がでました！");
		// コマを次の位置に移動
		controller.moveComa(coma, diceNum);
		// コマがゴールした場合
		if (coma.getIsGoaled()) {
			this.doGoal(coma);
		} else {
			// 移動後のマスのイベント実行
			this.doEvent(coma);
		}
	}

	private void doGoal(Coma coma) {
		this.showPrintTimelag("ゴールしました", "(●´ω｀●)", 0);
		// ゴールした順位により賞金獲得
		int prize = SugorokuConstants.BASE_PRIZE * controller.getActiveComaNum();
		coma.addMoney(prize);
		this.showPrintTimelag(
				(controller.getComaPlayerNum() + controller.getComaCpuNum() - controller.getActiveComaNum())
				+ "番目です", prize + "円を獲得", 0);
	}

	private void doEvent(Coma coma) {
		// マスのイベント情報取得
		Cell block = controller.getBlock(coma.getBlockNo());
		// イベント実行
		switch (block.getEventId()) {
		case SugorokuConstants.EVENT_GROUP_1:
			this.doEventRandom(coma);
			break;
		case SugorokuConstants.EVENT_GROUP_2:
			this.doEventOccupy(coma);
			break;
		}
	}

	private void doEventRandom(Coma coma) {
		try {
			// ランダムイベントの取得
			EventRandom event = SugorokuConstants.eventConfig[this.getRandomNum(SugorokuConstants.eventConfig.length)];
			// イベントタイプ別に実行
			switch (event.getEventType()) {
			case SugorokuConstants.EVENT_TYPE_GETMONEY: { // イベントタイプ：お金get
				int addMoney = this.getRandomMoney();
				coma.addMoney(addMoney);
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), addMoney + event.getEventResult());
			} break;
			case SugorokuConstants.EVENT_TYPE_LOSEMONEY: { // イベントタイプ：お金lose
				int addMoney = this.getRandomMoney();
				coma.addMoney(-addMoney);
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), addMoney + event.getEventResult());
			} break;
			case SugorokuConstants.EVENT_TYPE_GOBACK: { // イベントタイプ：戻る
				// 戻るマス数取得
				int backBlock = this.getRandomNum(1) + 1;
				// コマを次の位置に移動
				controller.moveComa(coma, -backBlock);
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), backBlock + event.getEventResult());
				// 移動先のイベントは行わない
			} break;
			case SugorokuConstants.EVENT_TYPE_MOVE: { // イベントタイプ：移動
				// 進コマ数取得
				int moveBlock = this.getRandomNum(2) + 1;
				// コマを次の位置に移動
				controller.moveComa(coma, moveBlock);
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), moveBlock + event.getEventResult());
				// コマがゴールした場合
				if (coma.getIsGoaled()) {
					this.doGoal(coma);
				}
				// 移動先のイベントは行わない
			} break;
			case SugorokuConstants.EVENT_TYPE_CHANGE: { // イベントタイプ：入れ替わり
				// TODO 未実装
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), event.getEventResult());
			} break;
			case SugorokuConstants.EVENT_TYPE_GETITEM: { // イベントタイプ：アイテムget
				// TODO 未実装
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), event.getEventResult());
			} break;
			case SugorokuConstants.EVENT_TYPE_BREAK: { // イベントタイプ：休み
				// 休む数取得
				int breakCount = this.getRandomNum(1) + 1;
				// コマに休みターン数を設定
				coma.setBreakTime(breakCount);
				this.showPrintEventResult(event.getEventTitle(), event.getEventInfo(), breakCount + event.getEventResult());
			} break;
			case SugorokuConstants.EVENT_TYPE_NOTHING: {} // イベントタイプ：なにもなし
			default: {
				this.showPrintTimelag(event.getEventInfo(), event.getEventResult(), 0);
			} break;
			}
		} catch (Exception e) {
			this.showPrintLine(e.getMessage());
		}
	}

	private void doEventOccupy(Coma coma) {
		Cell block = controller.getBlock(coma.getBlockNo());
		if (block.getIsOccupied()) {
			// 通行料を払う
			int payMoney = this.getRandomMoney();
			coma.addMoney(-payMoney);
			// マスの占領者は通行料を貰う
			Coma ownerComa = block.getOccupiedBy();
			ownerComa.addMoney(payMoney);
			this.showPrintEventResult("占領イベント", ownerComa.getName() + " に通行料を支払った", payMoney + "円のマイナス");
		} else {
			// マスを占領
			block.setPrintName(coma.getPrintName());
			block.setIsOccupied(true);
			block.setOccupiedBy(coma);
			this.showPrintEventResult("占領イベント", "空いてるマスに止まった", coma.getName() + " が占領した");
		}
	}

	private int getRandomMoney() {
		return this.getRandomNum(15) * 1000;
	}

	private int getRandomNum(int limit) {
		return new Random().nextInt(limit);
	}

	/**
	 * 終了メッセージの表示
	 */
	public void showEndMessage() {
		this.showPrintLine();
		this.showPrintLine("*****************************************");
		this.showPrintTimelag(controller.getTurnCount() + " ターンで完了", "", 0);
		this.showPrintLine();
		// 最終ステータス情報の設定
		this.showFinalStatusInfo();
		// 最終メッセージの設定
		this.showFinalMessage();
	}

	private void showFinalStatusInfo() {
		int i = 0;
		for (Coma coma : this.getComaArraySortedByMoney()) {
			i++;
			// 最終順位の表示
			this.showPrintTimelag("  第" + i + "位", coma.getName() + " ： " + coma.getMoney() + "円 ", 0);
		}
	}

	private void showFinalMessage() {
		this.showPrintLine();
		for (Coma coma : this.getComaArraySortedByMoney()) {
			this.showPrintTimelag("  " + coma.getName() + " さん", "おめでとー！！", 0);
			break;
		}
		this.showPrintLine();
		this.showPrintLine("******************************** 終了 ***");
	}

	private void changeGameSpeed() {
		this.showPrintLine("-------------------------------");
		this.showPrintLine("ゲームスピードを選択して下さい。（1 - 4）");
		this.showPrintLine("  1: 通常");
		this.showPrintLine("  2: 2倍速");
		this.showPrintLine("  3: 3倍速");
		this.showPrintLine("  4: 4倍速");
		controller.setGameSpeed(getInputNum(1, 4));
	}

	private void clearPrintArray() {
		this.printArray.clear();
	}

	private void addPrintArray(String line) {
		this.printArray.add(line);
	}

	private void showPrintArray() {
		this.showPrintLine();
		this.showPrintLine("*****************************************");
		for (int i = 0; i < this.printArray.size(); i++) {
			this.showPrintLine(this.printArray.get(i).toString());
		}
		this.showPrintLine("===============================");
	}

	private void showPrintLine(String line) {
		System.out.println(line);
	}

	private void showPrintLine() {
		System.out.println();
	}

	private void showPrintTimelag(String startStr, String endStr, int repeatCount) {
		System.out.print("  " + startStr + " ");
		this.doTimeSleep_500();
		for (int i = 0; i < repeatCount; i++) {
			System.out.print(">");
			this.doTimeSleep_500();
		}
		this.showPrintLine("  " + endStr);
		this.doTimeSleep_1000();
	}

	private void showPrintTimelag(String startStr, String endStr) {
		showPrintTimelag(startStr, endStr, 3);
	}

	private void showPrintEventResult(String title, String startStr, String endStr) {
		this.showPrintTimelag("＜イベント発生＞", title, 0);
		this.showPrintTimelag(startStr, endStr, 0);
	}

	private void doTimeSleep(int t) {
		try {
			Thread.sleep(t / controller.getGameSpeed());
		} catch (InterruptedException e) {
			this.showPrintLine(e.getMessage());
			// e.printStackTrace();
		}
	}

	private void doTimeSleep_500() {
		this.doTimeSleep(500);
	}

	private void doTimeSleep_1000() {
		this.doTimeSleep(1000);
	}

	/**
	 * ユーザの入力値（数値）を取得する。範囲チェックも行う。
	 * 
	 * @param startNum 範囲の最初
	 * @param endNum   範囲の最後
	 * @return ユーザの入力値
	 */
	public int getInputNum(int startNum, int endNum) {
		int returnNum = 0;
		do {
			try {
				int inputNum = input.nextInt();
				if (isRange(inputNum, startNum, endNum)) {
					returnNum = inputNum;
					break; // 正常に受け付けた場合、do文を抜ける
				}
				System.out.println("範囲外です。" + startNum + "-" + endNum + "で数字を入力してください");
			} catch (Exception e) {
				input.nextLine();
				System.out.println("数字を入力してください");
			}
		} while (true);
		return returnNum;
	}

	/**
	 * 数値の範囲チェック
	 * 
	 * @param inputNum   チェックしたい値
	 * @param startMonth 範囲の最初
	 * @param endMonth   範囲の最後
	 * @return true：範囲内の場合
	 */
	private boolean isRange(int inputNum, int startMonth, int endMonth) {
		return (inputNum >= startMonth && inputNum <= endMonth);
	}
}
