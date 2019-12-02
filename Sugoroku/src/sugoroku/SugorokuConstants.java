package sugoroku;

public class SugorokuConstants {
	// privateコンストラクタでインスタンス生成を抑止
	private SugorokuConstants() {
	}

	// 定数定義
	public static final int GAMEMODE_NEW = 0; // 新規モード
	public static final int GAMEMODE_LOAD = 1; // 再開モード
	public static final int ACTIONMODE_PLAYER = 0; // アクションモード：プレイヤー
	public static final int ACTIONMODE_CPU = 1; // アクションモード：CPU
	public static final int INI_MONEY = 30000; // 各コマの初期の所持金
	public static final int INI_BREAKTIME = 0; // 各コマの初期の残り休み回数
	public static final int INI_GAMESPEED = 1; // ゲームスピード：通常
	public static final int BASE_PRIZE = 10000; // ゴール到達時の賞金基本値
	public static final String STR_GAMESPEED_2x = "(2倍速)"; // ゲームスピード：２倍速
	public static final String STR_GAMESPEED_3x = "(3倍速)"; // ゲームスピード：３倍速
	public static final String STR_GAMESPEED_4x = "(4倍速)"; // ゲームスピード：４倍速
	public static final String STR_SPACE = " "; // 半角スペース
	public static final String STR_PATHMARK = ">>>"; // コマのパスマーク
	public static final int EVENT_GROUP_0 = 0; // イベントグループ：スタート
	public static final int EVENT_GROUP_1 = 1; // イベントグループ：ランダムイベント
	public static final int EVENT_GROUP_2 = 2; // イベントグループ：占領イベント
	public static final int EVENT_GROUP_9 = 9; // イベントグループ：ゴール
	public static final int EVENT_TYPE_NOTHING = 0; // イベントタイプ：なにもなし
	public static final int EVENT_TYPE_GETMONEY = 1; // イベントタイプ：お金get
	public static final int EVENT_TYPE_LOSEMONEY = 2; // イベントタイプ：お金lose
	public static final int EVENT_TYPE_GOBACK = 3; // イベントタイプ：戻る
	public static final int EVENT_TYPE_MOVE = 4; // イベントタイプ：移動
	public static final int EVENT_TYPE_CHANGE = 5; // イベントタイプ：入れ替わり
	public static final int EVENT_TYPE_GETITEM = 6; // イベントタイプ：アイテムget
	public static final int EVENT_TYPE_BREAK = 7; // イベントタイプ：休み

	// イベント定義
	public static final EventRandom[] eventConfig = new EventRandom[] {
			new EventRandom(EVENT_TYPE_NOTHING, "Nothing","(*'ω'*) ？", "何も起きませんでした"),
			new EventRandom(EVENT_TYPE_NOTHING, "Nothing","(*'ω'*) ？", "何も起きませんでした"),
			new EventRandom(EVENT_TYPE_NOTHING, "Nothing","(*'ω'*) ？", "何も起きませんでした"),
			new EventRandom(EVENT_TYPE_NOTHING, "Nothing","(*'ω'*) ？", "何も起きませんでした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "道端に財布が！！", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "先輩と遭遇した", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "先週買った宝くじが当たった", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "下請けからお歳暮が届いた", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "会社の備品を売った", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "おこづかいを貰った", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "お年玉を貰った", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "バグを見つけて報奨金を貰った", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "勤続10年祝い", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "CTFで入賞した", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "株取引を行った", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "道案内をしたら感謝された", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "アルミ缶を回収・換金した", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "自動販売機の下を漁った", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "排水溝の掃除をした", "円getした"),
			new EventRandom(EVENT_TYPE_GETMONEY, "マネーイベント", "本に何かはさまってる", "円getした"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "財布を落とした", "円失った"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "先輩と遭遇した", "円失った"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "宝くじを買った", "円失った"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "取引先を接待した", "円失った"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "株取引を行った", "円失った"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "おこづかいをあげた", "円失った"),
			new EventRandom(EVENT_TYPE_LOSEMONEY, "マネーイベント", "お年玉をあげた", "円失った"),
			new EventRandom(EVENT_TYPE_GOBACK, "？？？", "道に迷った", "マス戻る"),
			new EventRandom(EVENT_TYPE_GOBACK, "？？？", "坂道を転げ落ちた", "マス戻る"),
			new EventRandom(EVENT_TYPE_MOVE, "！！！", "近道を見つけた", "マス進む"),
			new EventRandom(EVENT_TYPE_MOVE, "！！！", "へい、タクシー", "マス進む"),
			new EventRandom(EVENT_TYPE_BREAK, "ひとやすみひとやすみ", "睡魔に襲われた", "ターン休む"),
			new EventRandom(EVENT_TYPE_BREAK, "ひとやすみひとやすみ", "めんどくさくなった", "ターン休む"),
			new EventRandom(EVENT_TYPE_BREAK, "ひとやすみひとやすみ", "ぼーっとしている", "ターン休む"),
			new EventRandom(EVENT_TYPE_BREAK, "ひとやすみひとやすみ", "おいしそうなスイーツだなぁ", "ターン休む"),
	};
}
