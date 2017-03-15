package ru.asemenov.Bomberman.Elements;

public enum Route {
    UP {
        @Override
        public int[] route() {
            return new int[]{-1, 0};
        }

        @Override
        public Route changeRoute() {
            return RIGHT;
        }
    },
    DOWN {
        @Override
        public int[] route() {
            return new int[]{1, 0};
        }

        @Override
        public Route changeRoute() {
            return LEFT;
        }
    },
    LEFT {
        @Override
        public int[] route() {
            return new int[]{0, -1};
        }

        @Override
        public Route changeRoute() {
            return UP;
        }
    },
    RIGHT {
        @Override
        public int[] route() {
            return new int[]{0, 1};
        }

        @Override
        public Route changeRoute() {
            return DOWN;
        }
    };
    public abstract int[] route();
    public abstract Route changeRoute();
}
