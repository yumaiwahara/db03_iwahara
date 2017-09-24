package dBLesson01;

import java.util.ArrayList;
import java.util.Scanner;

public class DBLesson01 {
	public static void main(String[] args) {

		// Wordクラスのインスタンス配列
		ArrayList<Word> words = new ArrayList<Word>();

		// コマンドラインから入力
		System.out.println("英単語と日本語をスペースで区切って入力して下さい。");
		Scanner sc  = new Scanner(System.in);
		String input = sc.nextLine();

		// 例えば、「apple  りんご」と入力されたときはtmp[0]に"apple"、tmp[1]に"りんご"が入る
		try{
			while(!input.equals("e")) {
				String[] tmp = new String[2];
				tmp = input.split(" ");
				Word wd = new Word(tmp[0],tmp[1]);
				words.add(wd);
				System.out.println("次の英単語と日本語を入力してください。\"e\"で終了します。");
				input = sc.nextLine();
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("登録制限を越えました。登録済みのデータは以下になります。");
		}

		WordDAO dao = new WordDAO();
		int count = dao.registWords(words);

		System.out.println(count + "件登録しました。");
	}
}

