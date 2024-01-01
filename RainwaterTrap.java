import java.util.*;

public class RainwaterTrap {

    // Trapping Rainwater...
    public static int trappedRainwater(int height[]) {
        int n = height.length;
        // For left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // For right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i=0; i<n; i++) {
            // waterLevel = min(leftmax bound, rightmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // total trappedwater = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        
        return trappedWater;
    }
    // public static void main(String[] args) {
    //     // int height[] = {4, 2, 0, 6, 3, 2, 5};
    //     int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    //     System.out.println(trappedRainwater(height));
    // }

    // alternate method :

    public static int trap(int height[]) {
        int n = height.length;
        int res = 0, l = 0, r = n - 1;
        int rMax = height[r], lMax = height[l];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
    


    /* 

    public static int buySellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }



    // Container with Most Water ->
    // Using ArrayList

    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        //brute force
        for(int i=0; i<height.size(); i++) {
            for(int j=i+1; j<height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }


    // Time Complexity O(n)
    public static int storeAgain(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;     //left pointer
        int rp = height.size()-1;   //right pointer

        while(lp < rp) {
            //calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            //update ptr 
            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
    
    public static void main(String[] args) {

        // int prices[] = {7, 1, 5, 3, 6, 4};
        // System.out.println(buySellStocks(prices));


        ArrayList<Integer> height = new ArrayList<>();
        //1, 3, 6, 4, 8, 7, 2
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));

        System.out.println(storeAgain(height));
    }

     */

}

