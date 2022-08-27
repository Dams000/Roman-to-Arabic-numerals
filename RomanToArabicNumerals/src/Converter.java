import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Converter {

	private int arabicNum;
	private String romanNum;

	private int[] arabics = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
	private String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	private HashMap<String, Integer> numerals = new HashMap<String, Integer>();

	public Converter() {
		numerals.put("I", 1);
		numerals.put("IV", 4);
		numerals.put("V", 5);
		numerals.put("IX", 9);
		numerals.put("X", 10);
		numerals.put("XL", 40);
		numerals.put("L", 50);
		numerals.put("XC", 90);
		numerals.put("C", 100);
		numerals.put("CD", 400);
		numerals.put("D", 500);
		numerals.put("CM", 900);
		numerals.put("M", 1000);
	};

	public String convertToRoman(int number) {

		if (number < 1)
			throw new NumberFormatException("Value of input must be positive.");
		if (number > 3999)
			throw new NumberFormatException("Value of input must be 3999 or less.");

		int times = 0;
		arabicNum = number;
		String ans = "";

		for (int i = numerals.size() - 1; i >= 0; i--) {
			times = arabicNum / arabics[i];
			while (times > 0) {
				ans += romans[i];
				times--;
			}
			arabicNum %= arabics[i];
		}

		return ans;
	}

	public int convertToArabic(String number) {
		int ans = 0;
		romanNum = number;

		romanNum = romanNum.replace("IV", "IIII");
		romanNum = romanNum.replace("IX", "VIIII");
		romanNum = romanNum.replace("XL", "XXXX");
		romanNum = romanNum.replace("XC", "LXXXX");
		romanNum = romanNum.replace("CD", "CCCC");
		romanNum = romanNum.replace("CM", "DCCCC");
		
		for (int i = 0; i < romanNum.length(); i++)
        {
            ans += (numerals.get(Character.toString(romanNum.charAt(i))));
        }

		return ans;
	}

	public String count(String s) {
		int n = s.length();
		int count = 0;
		String ans = "";

		for (int i = 0; i <= n; i++) {
			if (i == n || s.charAt(i) != (s.charAt(count))) {
				ans += Integer.toString(i - count);
				count = i;
			}
		}
		return ans;
	}

}
