import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Converter {

	private int arabicNum;
	private String romanNum;

	private LinkedHashMap<String, Integer> numerals = new LinkedHashMap<String, Integer>();

	public Converter() {
		numerals.put("M", 1000);
		numerals.put("CM", 900);
		numerals.put("D", 500);
		numerals.put("CD", 400);
		numerals.put("C", 100);
		numerals.put("XC", 90);
		numerals.put("L", 50);
		numerals.put("XL", 40);
		numerals.put("X", 10);
		numerals.put("IX", 9);
		numerals.put("V", 5);
		numerals.put("IV", 4);
		numerals.put("I", 1);
	};

	public String convertToRoman(int number) {

		if (number < 1)
			throw new NumberFormatException("Value of input must be positive.");
		if (number > 3999)
			throw new NumberFormatException("Value of input must be 3999 or less.");

		int times = 0;
		arabicNum = number;
		String ans = "";
		
		for (Entry<String, Integer> entry : numerals.entrySet()) {
			times = arabicNum / entry.getValue();
			while (times > 0) {
				ans += entry.getKey();
				times--;
			}
			arabicNum %= entry.getValue();
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

		for (int i = 0; i < romanNum.length(); i++) {
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
