import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int[] prices = {7,6,4,3};
		System.out.println(maxProfit(prices));
	}
	
	
	public static int maxProfit(int[] prices) {
		if (prices.length==0) {
			return 0;
		}
		int min = prices[0];
		int profit = 0;
        for (int i = 0; i < prices.length; i++) {
        	min = Math.min(min, prices[i]);
			profit = Math.max(profit,prices[i]-min);
		}
        return profit;
    }
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
			if (Math.max(p.val, q.val)<root.val) {
				return lowestCommonAncestor(root.left, p, q);
			}else if(Math.min(p.val, q.val)>root.val){
				return lowestCommonAncestor(root.right, p, q);
			}else{
				return root	;
			}
    }
	public static int climbStairs(int n) {
        if (n == 1) {
			return 1;
		}else if(n==2){
			return 2;
		}else{
			//return climbStairs(n-2)+climbStairs(n-1);
			int[] stairs = new int[n];
			stairs[0] = 1;
			stairs[1] = 2;
			for (int i = 2; i < stairs.length; i++) {
				stairs[i] = stairs[i-1]+stairs[i-2];
			}
			return stairs[n-1];
		}
    }

	public static boolean isUgly(int num) {
		if (num<=0) {
			return false;
		}
		if (num==1) {
			return true;
		}
		while(num/2>2&&num%2==0){
			num = num/2;
		}
		while(num/3>2&&num%3==0){
			num = num/3;
		}
		while(num/5>2&&num%5==0){
			num = num/5;
		}
		return num>5?false:true;
		
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {

			if (cur.val == pre.val) {
				pre.next = cur.next;// 删除重复的节点
			} else {
				pre = pre.next;

			}
			cur = cur.next;
		}
		return head;

		/*
		 * Map<Integer, Integer> map = new HashMap<>(); ListNode list = null; if
		 * (head != null) { list = new ListNode(head.val); map.put(head.val, 1);
		 * } else { return null; } head = head.next; while (head != null) { if
		 * (!map.containsKey(head.val)) { map.put(head.val, 1);
		 * System.out.print("不包含"); } else { map.put(head.val, map.get(head.val)
		 * + 1); } if (map.get(head.val) == 1) { System.out.print("添加");
		 * list.next = new ListNode(head.val); list = list.next; } head =
		 * head.next; } return list;
		 */

	}

	public int hammingWeight(int n) {
		String binaryString = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			if (Integer.valueOf(binaryString.charAt(i) + "") == 1) {
				count++;
			}
		}
		return count;
	}

	public static boolean isHappy(int n) {

		String nString = n + "";
		if (nString.length() == 1) {
			if (Integer.valueOf(nString) == 1 || Integer.valueOf(nString) == 7) {
				return true;
			} else {
				return false;
			}
		} else {
			int sum = 0;
			for (int i = 0; i < nString.length(); i++) {
				int a = Integer.valueOf(nString.charAt(i) + "");
				sum += a * a;
			}
			return isHappy(sum);
		}

		/*
		 * while (n > 6) { int next = 0; while (n != 0) { next += (n % 10) * (n
		 * % 10); n /= 10; } n = next; } return n == 1;
		 */

	}

	public boolean isPowerOfTwo(int n) {
		double d = Math.log10(n) / Math.log10(2);
		return (d - (int) d) == 0 ? true : false;
	}

	public boolean isPowerOfThree(int n) {
		double d = Math.log10(n) / Math.log10(3);
		return (d - (int) d) == 0 ? true : false;
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			if (!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			} else {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				map.put(nums2[i], map.get(nums2[i]) - 1);
				list.add(nums2[i]);
				if (map.get(nums2[i]) == 0) {
					map.remove(nums2[i]);
				}
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) > 1) {
				return true;
			}
		}
		return false;

	}

	public int firstUniqChar(String s) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			String c = s.charAt(i) + "";
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			String c = s.charAt(i) + "";
			if (map.get(c) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int num = map.get(nums[i]);
			if (num > nums.length / 2) {
				return nums[i];
			}
		}
		return -1;
	}

	public static int titleToNumber(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			num += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
		}
		return num;
	}

	public static String convertToTitle(int n) {
		String ret = "";
		while (n > 0) {
			ret = (char) ((n - 1) % 26 + 'A') + ret;
			n = (n - 1) / 26;
		}
		return ret;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (q == null & p != null)) {
			return false;
		}

		else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
					&& p.val == q.val;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void deleteNode(ListNode node) {
		if (node == null) {
			return;
		} else {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			if (!list.contains(nums1[i])) {
				list.add(nums1[i]);
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (list.contains(nums2[i]) && !list2.contains(nums2[i])) {
				list2.add(nums2[i]);
			}
		}

		int[] result = new int[list2.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list2.get(i);
		}
		return result;
	}

	public static void moveZeroes(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				list.add(nums[i]);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < list.size()) {
				nums[i] = list.get(i);
			} else {
				nums[i] = 0;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		} else {
			TreeNode left = invertTree(root.left);
			TreeNode right = invertTree(root.right);
			root.left = right;
			root.right = left;
			return root;
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}

	public static int addDigits(int num) {
		/*
		 * if ((num+"").length()==1) { return num; }else{ String s = num + "";
		 * int result = 0; for (int i = 0; i < s.length(); i++) { Integer value
		 * = Integer.valueOf(s.charAt(i)+""); result += value; } return
		 * addDigits(result); }
		 */

		String s = num + "";
		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			Integer value = Integer.valueOf(s.charAt(i) + "");
			total += value;
			if (total > 9) {
				total -= 9;
			}
		}
		return total;
	}

	public static int singleNumber(int[] nums) {
		/*
		 * int result = 0; for (int i = 0; i < nums.length; i++) { result =
		 * result ^ nums[i]; } return result;
		 */

		/*
		 * Map<Integer, Integer> mp = new HashMap<>();
		 * 
		 * for (int i = 0; i < nums.length; i++) { mp.put(nums[i], 0); }
		 * 
		 * for (int i = 0; i < nums.length; i++) { if (mp.get(nums[i]) == 0) {
		 * mp.put(nums[i], 1); } else { mp.put(nums[i], 2); } }
		 * 
		 * for (int i = 0; i < nums.length; i++) { if (mp.get(nums[i]) == 1) {
		 * return nums[i]; } } return -1;
		 */

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
			} else {
				set.remove(nums[i]);
			}
		}

		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			return it.next();
		}
		return -1;
	}

	public String reverseString(String s) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(s.length() - 1 - i));
		}
		return sb.toString();
	}

	public boolean canWinNim(int n) {

		return (n % 4 == 0) ? false : true;
	}

	public static int getSum(int a, int b) {
		int sum = 0, carry = 0;
		if (b == 0) {
			return a;
		} else {
			sum = a ^ b;
			carry = (a & b) << 1;
			return getSum(sum, carry);
		}

	}
}
