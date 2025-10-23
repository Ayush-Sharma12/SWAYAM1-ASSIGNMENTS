public class CanPlaceFlower {
    
}


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;

        if (len == 1) {

            return flowerbed[0] == 0 && n == 1 || n == 0 ? true : false;
        }

        for (int i = 0; i < len && n > 0; i++) {

            if (flowerbed[i] == 1)
                continue;

            if (i == 0 && flowerbed[i + 1] == 0 || i == len - 1 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }

            else if (i > 0 && i < len && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }

        }

        return n == 0;

    }
}