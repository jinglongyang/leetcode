package dp;

/**
 * http://www.queryhome.com/22079/minimum-number-swaps-required-transform-one-string-to-other
 * http://stackoverflow.com/questions/2987605/minimum-number-of-swaps-needed-to-change-array-1-to-array-2
 * Given 2 strings s1, s2 and s1 is equal to s2 if they are lexicographically sorted,
 * Find minimum number of swaps required to transform s1 to s2?
 * Swap Definition:
 * Problem 1 : we can transform index i with i+1 where 0<=i< s1.length()-1
 * Problem 2 : we can transform index i with i+1 where 0<=i< s1.length()-1 and other operation we can swap first character of string with last
 * example: s1="abc", s2="cba"
 * In problem1 3 swaps required abc ---> bac ---> bca ---> cba
 * In problem2 1 swaps required abc ---> cba [swap first and last element]
 */
public class MinimumSwaps {
}
