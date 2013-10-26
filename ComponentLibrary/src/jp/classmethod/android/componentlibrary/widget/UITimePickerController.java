package jp.classmethod.android.componentlibrary.widget;

import java.util.ArrayList;
import java.util.List;

/**
 * TimePickerをSDKバージョンに依らずに操作するためのControllerクラス. <br>
 * @author komuro
 *
 */
public abstract class UITimePickerController {
	
	/** 分計算用MAX定数(60分) */
	protected static final int MINUTES_MAX = 60;
	
	/** 選択肢の単位 */
	protected int unit = 1;
	
	/** 最後の選択肢のIndex */
	protected int maxIdx = MINUTES_MAX - 1;
	
	/**
	 * 何分ごとに表示するか
	 * @param unit minutes
	 */
	public abstract void setIncrementTimeUnit(int unit);
	
	/**
	 * TimePickerをもろもろ上書き. インスタンス生成後に呼ぶ
	 */
	public abstract void overrideTimePicker(UITimePicker picker);

	/**
	 * 選択肢Itemを作成する
	 * @param unit 何分ごと
	 * @return 選択肢ItemのString List
	 */
	protected static String[] createMinItems(int unit) {
		List<String> itemList = new ArrayList<String>();
		// 選択肢の数
		int itemLength = MINUTES_MAX / unit;
		for(int i=0; i<itemLength; i++) {
			itemList.add(String.valueOf(i*unit));
		}
		return itemList.toArray(new String[0]);
	}
	
}
