class Solution {
    public boolean lemonadeChange(int[] bills) {
        int $5Count = 0;
        int $10Count = 0;
        for (int bill : bills) {
            if (bill == 5) {
                $5Count++;
            } else if (bill == 10) {
                if ($5Count == 0)
                    return false;
                $5Count--;
                $10Count++;
            } else {
                if ($5Count == 0)
                    return false;
                else if ($10Count == 0) {
                    if ($5Count < 3)
                        return false;
                    $5Count -= 3;
                }else{
                    $5Count--;
                    $10Count--;
                }
            }
        }
        return true;
    }
}