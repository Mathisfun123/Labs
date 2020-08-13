public class binarySearch {
    public static void main(String[] args) {
        int[] list = {1, 2, 5, 6, 9, 23, 25, 34};
        System.out.println(binSearch(23, list));
    }

    private static int binSearch(int i, int[] list) {
        boolean found = false;
        int max = list.length-1;
        int min = 0;
        int mid = 0;
        while (!found && min <= max) {
            mid = (max + min) / 2;
            if(list[mid] == i) {
                found = true;
                return mid;
            } else {
                if(list[mid] < i) {
                    min = mid+1;
                } else {

                }
            }
        }
        return (found?mid:-1);
    }
}
