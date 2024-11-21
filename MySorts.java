public class MySorts {

    // Quicksort algorithm
    public static void quicksort(IList<Integer> list) {
        quicksortHelper(list, 0, list.size() - 1);
    }

    private static void quicksortHelper(IList<Integer> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quicksortHelper(list, low, pi - 1);
            quicksortHelper(list, pi + 1, high);
        }
    }

    private static int partition(IList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static void swap(IList<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Mergesort algorithm
    public static void mergesort(IList<Integer> list) {
        IList<Integer> sortedList = mergesortHelper(list);
        for (int i = 0; i < sortedList.size(); i++) {
            list.set(i, sortedList.get(i));
        }
    }

    private static IList<Integer> mergesortHelper(IList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        IList<Integer> left = getLeftHalf(list);
        IList<Integer> right = getRightHalf(list);

        left = mergesortHelper(left);
        right = mergesortHelper(right);

        return merge(left, right);
    }

    private static IList<Integer> getLeftHalf(IList<Integer> list) {
        int size = list.size() / 2;
        IList<Integer> left = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            left.add(list.get(i));
        }
        return left;
    }

    private static IList<Integer> getRightHalf(IList<Integer> list) {
        int size = list.size() / 2;
        IList<Integer> right = new MyArrayList<>();
        for (int i = size; i < list.size(); i++) {
            right.add(list.get(i));
        }
        return right;
    }

    private static IList<Integer> merge(IList<Integer> left, IList<Integer> right) {
        IList<Integer> result = new MyArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}
