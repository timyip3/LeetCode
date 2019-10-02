package containerMostWater;

public class ContainerMostWater {

    public int maxArea(int[] height) {
        final int size = height.length;
        if (size == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < size; i++) {
            int start_pt = height[i];

            for (int j = i+1; j < size; j++) {
                int end_pt = height[j];

                int width = j - i;
                int height_area = Math.min(start_pt, end_pt);
                result = Math.max(result, width*height_area);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[]height = {1};

        ContainerMostWater containerMostWater = new ContainerMostWater();
        System.out.print(containerMostWater.maxArea(height));
    }
}
