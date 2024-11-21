/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		for(int i = 0; i < str1.length(); i++){
			char c = str1.charAt(i);
			if(str2.indexOf(c) == -1) return false; 	//if there is a letter in str1 and not in str2
			else{
				String tempStr = "";
				for(int j = 0; j < str2.length(); j++){
					if(j != str2.indexOf(c))
						tempStr += str2.charAt(j);
				}
				str2 = tempStr;
			}
		}
		if(str2.equals("")) return true;	//if all the letters in str1 are in str2 then str2 should be emptied
		else return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String strNew = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if('A' <= c && c <= 'Z') {
				strNew += Character.toLowerCase(c);
			}
			else if('a' <= c && c <= 'z'){
				strNew += c;
			}
		}
		return strNew;
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String endStr = "";
		while(!str.equals(""))
		{
			int index = (int) (Math.random()*(str.length()-1));	//gives a random index in str
			char c = str.charAt(index);
			endStr += c;
			String newStr = "";
			for(int i = 0; i < str.length(); i++){
				if(i != index)
					newStr += str.charAt(i);
			}
			str = newStr;
		}
		return endStr;
	}
}
