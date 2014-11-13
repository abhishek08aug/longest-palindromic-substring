package in.blogspot.randomcompiler.longest.palindromic.substring;

public class LongestPalindromicSubstring {
    public static void longestPalindromicSubstring(String input) {
        if(input == null) {
            System.out.println("Longest palindromic substring in " + input + " is " + null + ", length is 0");
            return;
        }
        boolean isPalindrome[][] = new boolean[input.length()][input.length()];
        /*for(int i=0; i<input.length(); i++) {
            for(int j=0; j<input.length(); j++) {
                System.out.print(isPalindrome[i][j] + " ");
            }
            System.out.println();
        }*/
        for(int i=0; i<input.length(); i++) {
            isPalindrome[i][i] = true;
        }
        int longestPalindromeStartIndex = 0;
        int longestPalindromeEndIndex = 0;
        for(int len=2; len<=input.length(); len++) {
            for(int i=0; i<=input.length()-len;  i++) {
                int j = i + len -1;
                if(input.charAt(i) == input.charAt(j) && (len == 2 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                    if(j-i+1 > longestPalindromeEndIndex -longestPalindromeStartIndex +1) {
                        longestPalindromeStartIndex = i;
                        longestPalindromeEndIndex = j;
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }
        System.out.println("Longest palindromic substring in " + input + " is " + input.substring(longestPalindromeStartIndex, longestPalindromeEndIndex+1) + ", length is " + (longestPalindromeEndIndex -longestPalindromeStartIndex +1));
    }
}
