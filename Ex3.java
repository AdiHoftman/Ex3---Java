package Ex3;

import java.util.Arrays;

public class Ex3 {

	public static String myID() {
		return "" + 322267824;
	}

	/**
	 * This function run over all the string and check if the char of the string is the same char that we choose,
	 * if so, the function move this char to the end of the string.
	 * @param str
	 * @param ch
	 * @return string that the char the chosen to put at the end be there.
	 */
	public static String moveCharToLast(String str, char ch) {
		if (str.length() < 1) return "";
		if(str.length() == 1) return str;
		String newString = str.substring(1); 
		if (str.indexOf(ch) == 0)
			return moveCharToLast(newString, ch)+ ch;
		return str.charAt(0) + moveCharToLast(newString,ch);
	}

	/**
	 * This function run over all the string and check if the char and the char that after it are the same char,
	 * if so, the function remove one of them, because we want that two chars one and after it, not be the same.
	 * @param str
	 * @return reduce string.
	 */
	public static String reduce(String str){
		if (str.length() < 1) return ""; 
		if(str.length() == 1) return str;
		String newString = str.substring(1);
		if (str.charAt(0) == str.charAt(1))
			return reduce(newString);
		return str.charAt(0) + reduce(newString);
	}

	/**
	 * The function uses the auxiliary function and returns two groups divided into two.
	 * @param nums
	 * @return true if the two groups we received are equal.
	 */
	public static boolean mySplit(int[] nums) {
		if(nums.length < 2) return false;
		return recurseMySplit(nums, 0, 0, 0);
	}

	/**
	 * The function divides the array into two groups that the sum of all the numbers in one group
	 * is equal to the other group, the first group gets everything that is divided by 5, the second group
	 * gets everything that is divided by 3 and not divided by 5.
	 * If there is a number that is not divisible by 5 and is not divisible by 3, then the number will go to a group
	 * that is smaller than the other group, each number can appear once in one of the two groups.
	 * @param nums
	 * @param i
	 * @param g1
	 * @param g2
	 * @return true if the function divided for two groups.
	 */
	private static boolean recurseMySplit(int[] nums, int i, int g1, int g2) {
		if(i == nums.length) return g1 == g2;
		if (nums[i] % 5 == 0){
			return recurseMySplit(nums, i+1, g1 + nums[i], g2);
		}
		if(nums[i] % 3 == 0) {
			return recurseMySplit(nums, i+1, g1, g2 + nums[i]);
		}
		if ((nums[i] % 3 != 0) && (nums[i] % 5 != 0)) {
			if(g1 > g2) return recurseMySplit(nums, i+1, g1, g2 + nums[i]);
			if(g1 < g2) return recurseMySplit(nums, i+1, g1 + nums[i], g2);
		}
		return recurseMySplit(nums, i+1, g1+nums[i], g2);
	}

	/**
	 * The function gets an array and calculates for each index the sum of all
	 * its neighbors and puts the sum in the same index in the array.
	 * @param mat
	 * @return the new array of sums of all neighbors of each index in the array.
	 */
	public static int[][] sumOfNeighbours(int[][] mat){
		int row = mat.length;
		int col = mat[0].length;
		int [] [] sum = new int [row][col];
		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[i].length; j++){
				if (i == 0 && j == 0){
					int result = 0;
					result += mat[i+1][j+1]; 
					result += mat[i][j+1];
					result += mat[i+1][j];
					sum[i][j] = result;
				}
				
				else if (i == mat.length-1 && j == 0){
					int result = 0;
					result += mat[i-1][j];
					result += mat[i-1][j+1];
					result += mat[i][j+1];
					sum[i][j] = result;
				}
				
				else if (i == mat.length-1 && j == mat[mat.length-1].length-1){
					int result = 0;
					result += mat[i-1][j-1];
					result += mat[i-1][j];
					result += mat[i][j-1];
					sum[i][j] = result;

				}
				
				else if (i == 0 && j != 0 && j != mat[0].length){
					int result = 0;
					result += mat[i][j-1]; //top value or mirror
					result += mat[i+1][j-1];
					result += mat[i+1][j];

					if(j < mat[mat.length-1].length-1) {
						result += mat[i+1][j+1]; // left value
						result += mat[i][j+1];
					}

					sum[i][j] = result;

				}

				else if (i == mat.length-1 && j != 0 && j != mat[mat.length-1].length-1){
					int result = 0;
					result += mat[i-1][j-1];
					result += mat[i-1][j];
					result += mat[i-1][j+1];
					result += mat[i][j-1];
					result += mat[i][j+1];
					sum[i][j] = result;
				}

				else if (j == 0 && i != 0 && i != mat.length-1){
					int result = 0;
					result += mat[i-1][j];
					result += mat[i-1][j+1];
					result += mat[i][j+1];
					result += mat[i+1][j];
					result += mat[i+1][j+1];
					sum[i][j] = result;
				}
				
				else{
					int result = 0;
					result += mat[i-1][j-1];
					result += mat[i-1][j];
					result += mat[i][j-1];
					result += mat[i+1][j-1];
					result += mat[i+1][j];

					if(j < mat[mat.length-1].length-1) {
						result += mat[i-1][j+1];
						result += mat[i][j+1];
						result += mat[i+1][j+1];
					}

					sum[i][j] = result;
				}
			}
		}
		return sum;
	}

	/**
	 * The function gets a string and an encryption key and returns an encrypted string using an caesar cipher.
	 * @param str
	 * @param key
	 * @return an encrypted string using an caesar cipher.
	 */
	public static String caesarCipherText(String str, int key) {
		int other = 0;
		String newString = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != ' ') {
				if(key < -26 || key > 26) return "";
				other = str.charAt(i) + key;
				if(other > 'z') other -= 26;
				if(other < 'a') other +=26;
				if(str.charAt(i) == ' ') newString += str.charAt(i);
				newString += (char) other;
			}
			if(str.charAt(i) == ' ') newString += str.charAt(i);
		}
		return newString;
	}

	/**
	 * The function gets a string and an encryption key and returns an encrypted string using an vigenere cipher.
	 * @param str
	 * @param key
	 * @return an encrypted string using an vigenere cipher.
	 */
	public static String vigenereCipherText(String str, String key) {
		String newString = "";
		int j = 0;
		char c = 0;
		for(int i=0; i<str.length(); i++) {
			if(j == key.length()) j = 0;
			if(str.charAt(i) != ' ') {
				c = key.charAt(j);
				c -= 'a';
				int sum = str.charAt(i) + c;
				if(sum < 'a') sum += 26;
				if(sum > 'z') sum -= 26;
				newString += (char) sum;
			}
			j++;
			if(str.charAt(i) == ' ') newString += str.charAt(i);
		}
		return newString;
	}

	/**
	 * The function receives a string and key and decodes the code.
	 * @param str
	 * @param key
	 * @return
	 */
	public static String vigenereDecipherText(String str, String key) {
		String newString = "";
		char c = 0;
		int j = 0;
		for(int i=0; i<str.length(); i++) {
			if(j == key.length()) j = 0;
			if(str.charAt(i) != ' ') {
				c = key.charAt(j);
				c -= 'a';
				int sub = str.charAt(i) - c;
				if(sub < 'a') sub += 26;
				if(sub > 'z') sub -= 26;
				newString += (char) sub;
			}
			j++;
			if(str.charAt(i) == ' ') newString += str.charAt(i);
		}
		return newString;
	}
}

