package ru.asemenov.Bomberman.Elements;
/**
 * Enum Route решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public enum Route {
    /**
     * Up route.
     */
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
    /**
     * Down route.
     */
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
    /**
     * Left route.
     */
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
    /**
     * Right route.
     */
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

    /**
     * Walk.
     * @return int[].
     */
    public abstract int[] route();

    /**
     * Change route.
     * @return new Route.
     */
    public abstract Route changeRoute();
}
