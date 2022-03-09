public class Main {

    public final class cargo {
        private int mass;
        private int size;
        private String address;
        private boolean flip;
        private String regNum;
        private boolean brittle;


        public class Dimension implements Cloneable {
            public int width;
            public int height;
            public int length;

            public void findVolume() {
                int size = width * height * length;
            }

            @Override
            public cargo clone() throws CloneNotSupportedException {
                int mass;
                int size;
                String address;
                boolean flip;
                String regNum;
                boolean brittle;
                return (cargo) super.clone();
            }

            public int getWidth(int width) {
                return width;
            }

            public int getLength(int length) {
                return length;
            }

            public int getHeight(int height) {
                return height;
            }

            public void setCurrentDimension() {
                int width = 0;
                int height = 0;
                int length = 0;
                this.width = width;
                this.height = height;
                this.length = length;
            }
        }

        public void currentAddress() {
            String address = "";
            this.address = address;
        }

        public void currentMass() {
            int mass = 0;
            this.mass = mass;
        }
    }
}
