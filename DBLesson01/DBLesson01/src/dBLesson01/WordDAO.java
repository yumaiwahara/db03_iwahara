package dBLesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WordDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	static String URL = "jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8";
	static String USER = "root";
	static String PW = "";
	static String MYSQL =  "com.mysql.jdbc.Driver";



	public WordDAO(){
	}

	public int registWords(ArrayList<Word> words) {
		int result = 0;
		try {
			// DB接続の記述
			String SQL = "INSERT INTO dictionary VALUES (?, ?)";
			Class.forName(MYSQL);
			con = DriverManager.getConnection(URL, USER, PW);

			for(int i = 0; i < words.size(); i++) {
				Word wd = words.get(i);
				st = con.prepareStatement(SQL);
				st.setString(1, wd.getEnglish());
				st.setString(2, wd.getJapanese());
				//SQL実行
				result = result + st.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	// 結果を返す
	}
}