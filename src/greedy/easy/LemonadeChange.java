package greedy.easy;

/*
* 860. 柠檬水找零
* */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int b:bills) {
            if(b == 5)
                five++;
            else if (b == 10) {
                if (five == 0)
                    return false;
                else {
                    five--;
                    ten++;
                }
            }else if (b == 20){
                if (five >0 && ten >0){
                    five -- ;
                    ten --;
                }else if(five >= 3)
                    five = five-3;
                else
                    return false;
            }
        }


        return true;

    }
}
