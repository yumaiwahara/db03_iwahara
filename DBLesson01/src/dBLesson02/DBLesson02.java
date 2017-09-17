package dBLesson02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBLesson02 {
	public static void main(String[] args) {

		// Wordクラスのインスタンス配列
		List<Word> words = new ArrayList<Word>();
		WordDAO wdao = new WordDAO();

		// コマンドラインから入力
		System.out.println("英単語と日本語をスペースで区切って入力して下さい。");
		Scanner sc  = new Scanner(System.in);
		String input = sc.nextLine();


		while(!input.equals("e")) {
			String[] tmp = new String[2];
			tmp = input.split(" ");
			Word wd = new Word(tmp[0],tmp[1]);
			words.add(wd);
			System.out.println("次の英単語と日本語を入力してください。\"e\"で終了します。");
			input = sc.nextLine();
		}

		int count = wdao.registWords(words);
		System.out.println(count + "件登録しました。");

		List<Word> wList = new ArrayList<>();
		wList = wdao.getWords();

		int wordNum = 0;
		for(Word tmp : wList){
			System.out.println(tmp);
			wordNum++;
		}
		System.out.println("\n登録件数は" + wordNum + "件です。");
	}
}

