package Chapter5.Project5_2;

public class RationalComparableDriver
{
    public static void main(String[] args)
    {
        RationalComparable rc1 = new RationalComparable(1, 2);
        RationalComparable rc2 = new RationalComparable(3, 5);

        System.out.println("- rc1: \t" + rc1);
        System.out.println("- rc2: \t" + rc2);
        System.out.println("Result of comparing rc1 to rc2: " + rc1.compareTo(rc2));
        System.out.println();

        RationalComparable rc3 = new RationalComparable(999999, 1000000);
        RationalComparable rc4 = new RationalComparable(1, 1);

        System.out.println("- rc3: \t" + rc3);
        System.out.println("- rc4: \t" + rc4);
        System.out.println("Result of comparing rc3 to rc4: " + rc3.compareTo(rc4));
    }
}
