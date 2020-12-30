package Ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Ex3.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class Ex3Test {

	@Test
	void myID() {
		System.out.println(Ex3.myID());
	}

	@Test
	void testMoveCharToLast() {
		String in = "hello world, let's go!";
		String out = "heo word, et's go!llll";
		Assertions.assertTrue(out.equals(Ex3.moveCharToLast(in, 'l')));
		in = "&hi&hi&";
		out = "hihi&&&";
		Assertions.assertTrue(out.equals(Ex3.moveCharToLast(in, '&')));
	}

	@Test
	void testMoveCharToLast1() {
		String in = "I need to successfull!!";
		String out = "I nd to succssfull!!eee";
		assertEquals(out, Ex3.moveCharToLast(in, 'e'));
		out = "I need to uccefull!!sss";
		assertEquals(out, Ex3.moveCharToLast(in, 's'));
	}

	@Test
	void testReduce() {
		String in = "aaabbccccxxxyzz";
		String out = "abcxyz";
		Assertions.assertTrue(out.equals(Ex3.reduce(in)));
		in = "abcda";
		out = in;
		assertTrue(out.equals(Ex3.reduce(in)));
	}

	@Test
	void testReduce1() {
		String in = "I need to successfull!!";
		String out = "I ned to sucesful!";
		assertEquals(out, Ex3.reduce(in));
	}

	@Test
	void testMySplit() {
		assertEquals(Ex3.mySplit(new int[]{1, 1}), true);
		assertEquals(Ex3.mySplit(new int[]{1, 1, 1}), false);
		assertEquals(Ex3.mySplit(new int[]{2, 4, 2}), true);
		assertEquals(Ex3.mySplit(new int[]{5, 21, 8, 15, 7}), true);
		assertEquals(Ex3.mySplit(new int[]{15, 10, 5}), false);
		assertEquals(Ex3.mySplit(new int[]{15, 8, 7}), true);
	}

	@Test
	void testMySplit1() {
		int[] nums = {1,2,3,4,5,6,7};
		assertNotEquals(Ex3.mySplit(nums), true);
		int[] nums1 = {1,3,5,7,4};
		assertEquals(Ex3.mySplit(nums1), true);
	}

	@Test
	void testSumOfNeighbours() {
		int[][] mat1 = {{3, 5, 7, 5}, {-4, 2, 10, 11}, {9, -50, 3, 60}};
		int[][] matOut1 = {{3, 18, 33, 28}, {-31, -17, 43, 85}, {-52, 20, 33, 24}};
		mat1 = Ex3.sumOfNeighbours(mat1);
		for (int i = 0; i < mat1.length; ++i)
			assertTrue(Arrays.equals(mat1[i], matOut1[i]));	

		int[][] mat2 = {{1, -2}, {4, 1}};
		int[][] matOut2 = {{3, 6}, {0, 3}};
		mat2 = Ex3.sumOfNeighbours(mat2);
		for (int i = 0; i < mat2.length; ++i)
			assertTrue(Arrays.equals(mat2[i], matOut2[i]));
	}

	@Test
	void testSumOfNeighbours1() {
		int[][] mat = {{2,-4,6,-8,10}, {12, -14, 16, -18, 20}, {13, 17, 15, 3, -9}, {11, -21, -32, 40, 5}};
		int [][] matOut = {{-6,22,-28,34,-6},{14,77,-3,53,-22},{5,0,-9,37,50},{9,24,54,-18,34}};
		mat = Ex3.sumOfNeighbours(mat);
		for(int i=0; i<mat.length; i++) {
			assertTrue(Arrays.equals(mat[i], matOut[i]));
		}
	}

	@Test
	void testCaesarCipherText() {
		String in = "abcdefghijklmnopqrstuvwxyz ";
		String out = "efghijklmnopqrstuvwxyzabcd ";
		assertTrue(out.equals(Ex3.caesarCipherText(in, 4)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 4), -4)));
	}
	
	@Test
	void testCaesarCipherText2() {
		String in = "yes we can";
		String out = "vbp tb zxk";
		assertEquals(out, Ex3.caesarCipherText(in, -3));
	}

	@Test
	void testVigenereCipherText() {
		String in = "a simple example";
		String out = "a zqqkpq rqaowti";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "achievement")));
		in = "impressive student from ariel university";
		out = "pacfvzgvjv ggiulbg wycz rywrz bbvjvygvhp";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "honor")));
		in = "test";
		out = "test";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "a")));
	}


	@Test
	void testVigenereCipherText1() {
		String in = "hey man";
		String out = "oij ahr";
		assertEquals(out, Ex3.vigenereCipherText(in, "hello"));
	}
	@Test
	void testVigenereDecipherText() {
		String in = "a simple example";
		String key = "achievement";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in, key), key)));
	}
	
	@Test
	void testVigenereDecipherText1() {
		String in = "yes we can";
		String key = "purple";
		assertEquals(in, Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in, key), key));
	}

}

