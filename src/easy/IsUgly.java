package easy;

/*
* 263. 丑数
* */
public class IsUgly {
    public boolean isUgly(int num) {

        if (num == 0)
            return false;
        int divisible = num;
        while (divisible > 1){
            if (divisible % 2 == 0)
                divisible = divisible/2;
            else if (divisible % 3 == 0)
                divisible = divisible/3;
            else if (divisible % 5 == 0)
                divisible = divisible/5;
            else
                break;

        }
        if (divisible == 1)
            return true;
        else
            return false;

    }
}
