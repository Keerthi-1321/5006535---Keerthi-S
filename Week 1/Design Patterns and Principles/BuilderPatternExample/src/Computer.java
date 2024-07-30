public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean hasGraphicsCard;
    private final boolean hasWiFi;

    // Private constructor to enforce the use of the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasWiFi = builder.hasWiFi;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", hasGraphicsCard=" + hasGraphicsCard +
                ", hasWiFi=" + hasWiFi +
                '}';
    }

    // Static nested Builder class
    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage;
        private boolean hasGraphicsCard;
        private boolean hasWiFi;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder wifi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
